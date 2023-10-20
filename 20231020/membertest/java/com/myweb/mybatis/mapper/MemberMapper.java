package com.myweb.mybatis.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.web.MemberDTO;

@Mapper
public interface MemberMapper {
	public Map<String, Object> getMember(MemberDTO dto);
}
