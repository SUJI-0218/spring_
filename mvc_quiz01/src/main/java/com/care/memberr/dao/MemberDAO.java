package com.care.memberr.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.memberr.dto.MemberDTO;

@Repository
public class MemberDAO {
	private ArrayList<MemberDTO> db;
	public MemberDAO() {
		db = new ArrayList<MemberDTO>();
				System.out.println("---MemberDAO---");
	}
	public void register(MemberDTO dto) {
		System.out.println("등록된 데이터: " + dto.getName());
		db.add(dto);
	}
//	public MemberDTO login(MemberDTO dto) {
//		//db.add(dto); //데이터 추가하는거임
//		for(MemberDTO d : db) {
//			if(d.getId().equals(dto.getId())) {
//				return d;
//			}
//		}
//		return null;
//	}
	public ArrayList<MemberDTO> getList(){
		return db;
	}

}
