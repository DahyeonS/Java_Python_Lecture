package com.myweb.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myweb.mybatis.mapper.MemberMapper;

@Service
public class MemberMybatisServiceImpl implements MemberMybatisService {
	@Autowired
	MemberMapper dao;

	@Override
	public Map<String, Object> getMember(MemberDTO dto) {
		return dao.getMember(dto);
	}
	
}
