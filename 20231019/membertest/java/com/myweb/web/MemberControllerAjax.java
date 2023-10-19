package com.myweb.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MemberControllerAjax {
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService service;
	
	@PostMapping("deleteJson")
	public Map<String, Object> deleteAction(MemberDTO dto, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		String id = (String)session.getAttribute("id");
		String pw = dto.getPw();
		
		dto.setId(id);
		dto = service.getMember(dto);
		
		if (dto.getPw().equals(pw)) {
			service.delete(dto);
			session.invalidate();
			map.put("rs", 1);
		} else map.put("rs", 0);
		
		return map;
	}
	
	@GetMapping("memberListJson")
	public Map<String, Object> memberList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MemberDTO> list = service.getMemberList();
		
		if(list.size() != 0) map.put("rs", list);
		else map.put("rs", 0);
		
		return map;
	}
}
