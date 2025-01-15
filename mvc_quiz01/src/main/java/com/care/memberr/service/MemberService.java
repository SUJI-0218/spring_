package com.care.memberr.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.memberr.dao.MemberDAO;
import com.care.memberr.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
//	public MemberService() {
//	System.out.println("---MemberService---");
//	}
	MemberDAO dao;
	public void register(MemberDTO dto) {
		dao.register( dto );
		System.out.println("리스트테스트"+ dao.getList().size());
	}
//	public int login(MemberDTO dto) {
//		MemberDTO d = dao.login(dto);
//		if (d != null && d.getPwd().equals(dto.getPwd())) {
//		    return 1;
//		}
//		return 0;
//	}
	public ArrayList<MemberDTO> getList(){
		ArrayList<MemberDTO> list = dao.getList();
		return list;
	}
}
