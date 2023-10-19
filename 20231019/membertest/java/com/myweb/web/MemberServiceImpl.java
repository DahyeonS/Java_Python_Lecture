package com.myweb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	@Qualifier("memberDAOImpl")
	MemberDAO dao;
	
	@Override
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}

	@Override
	public MemberDTO getMember(MemberDTO dto) {
		return dao.getMember(dto);
	}

	@Override
	public int update(MemberDTO dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(MemberDTO dto) {
		return dao.delete(dto);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		return dao.getMemberList();
	};
}
