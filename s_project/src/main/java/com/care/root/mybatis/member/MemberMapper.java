package com.care.root.mybatis.member;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public String successLogin( MemberDTO dto );
	public String register(MemberDTO dto);
	public ArrayList<MemberDTO> getList();

}
