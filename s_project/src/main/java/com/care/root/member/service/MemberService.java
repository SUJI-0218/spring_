package com.care.root.member.service;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public String successLogin(MemberDTO dto);
	public String register(MemberDTO dto);

}
