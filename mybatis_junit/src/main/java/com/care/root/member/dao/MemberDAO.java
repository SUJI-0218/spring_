package com.care.root.member.dao;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberDAO {
	//insert into table values(dto.id, dto.name)
	public int insertMember( MemberDTO dto );//insert라는 method를 부르고 dto를 저장함
	public ArrayList<MemberDTO> getList(); //memberMapper에 getList가 있기에 만들어줌
	

}
