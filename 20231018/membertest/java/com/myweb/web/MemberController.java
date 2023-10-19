package com.myweb.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("member")
public class MemberController {
	String view;
	
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService service;
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		view = "member/join";
		return view;
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String joinAction(MemberDTO dto, RedirectAttributes ra) {
		int rs = service.insert(dto);		
		ra.addFlashAttribute("rs", rs);
		
		view = "redirect:login";		
		return view;
	}
	
	@GetMapping(value = "login")
	public String login() {
		view = "member/login";
		return view;
	}
	
	@PostMapping("login")
	public String loginAction(MemberDTO dto, HttpSession session) {
		view = "member/login";
		String id = dto.getId();
		String pw = dto.getPw();
		
		dto = service.getMember(dto);
		
		if (dto != null) {
			if (dto.getPw().equals(pw)) {
				session.setAttribute("id", id);
				session.setAttribute("name", dto.getName());
				session.setAttribute("role", dto.getRole());
				
				view = "redirect:../";
			}
		}
		return view;
	}
	
	@GetMapping("logout")
	private String logout(HttpSession session) {
		view = "redirect:../";
		session.invalidate();
		return view;
	}
	
	@GetMapping("update")
	public String update() {
		view = "member/update";
		return view;
	}
	
	@PostMapping("update")
	public String updateAction(MemberDTO dto, HttpSession session, RedirectAttributes ra) {
		String id = (String)session.getAttribute("id");
		view = "member/update";
		
		dto.setId(id);
		int rs = service.update(dto);
		
		if (rs == 0) ra.addFlashAttribute("rs", rs);
		else {
			session.setAttribute("name", dto.getName());
			session.setAttribute("role", dto.getRole());
		}
		return view;
	}
	
	@GetMapping("delete")
	public String delete() {
		view = "member/delete";
		return view;
	}
	
	@GetMapping("list")
	public String list() {
		view = "member/memberList";
		return view;
	}
}
