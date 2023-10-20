package com.myweb.web;

import java.util.List;

public interface MemberService {
	List<MemberDTO> getMemberList();
	MemberDTO getMember(MemberDTO dto);
	int insert(MemberDTO dto);
	int update(MemberDTO dto);
	int delete(MemberDTO dto);
}
