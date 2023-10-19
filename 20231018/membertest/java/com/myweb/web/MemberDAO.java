package com.myweb.web;

public interface MemberDAO {
	MemberDTO getMember(MemberDTO dto);
	int insert(MemberDTO dto);
	int update(MemberDTO dto);
}
