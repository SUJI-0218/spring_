package com.care.member.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.member.dto.MemberDTO;

@Repository
public class MemberDAO {
private ArrayList<MemberDTO> db;
	public MemberDAO() {
		db = new ArrayList<MemberDTO>();		
			System.out.println("---MemberDAO---");
	}
	public void register(MemberDTO dto) { //void는 post방식일때 사용이 가능함
		//insert into table values()
		db.add(dto);
	}
	public ArrayList<MemberDTO> getList() {
		//select * from table;
		return db;
	}
}
 