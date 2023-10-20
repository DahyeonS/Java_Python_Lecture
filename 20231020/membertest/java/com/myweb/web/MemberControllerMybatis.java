package com.myweb.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mx")
public class MemberControllerMybatis {
	@Autowired
	@Qualifier("memberMybatisServiceImpl")
	MemberMybatisService service;
	
	@PostMapping("idCheckJson")
	public Map<String, Object> idCheck(MemberDTO dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Map<String, Object> result = service.getMember(dto);
		if (result == null) map.put("rs", 0);
		else map.put("rs", 1);
		
		return map;
	}
}
