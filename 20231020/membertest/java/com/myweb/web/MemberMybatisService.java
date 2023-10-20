package com.myweb.web;

import java.util.Map;

public interface MemberMybatisService {
	Map<String, Object> getMember(MemberDTO dto);
}
