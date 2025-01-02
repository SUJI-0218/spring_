package com.care.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Service
//여기서 service를 넣어야 ctrl이랑 연결이 되어서 서버가 가동이 된다!
//먼저 ctrl에는 ctrl, ser는 ser, dao는 req를 넣어서 연결이 되어야 함
public class MemberService {	
//	public MemberService() {
//		System.out.println("---MemberService---");
		@Autowired
		MemberDAO dao;
		public void register(MemberDTO dto) {
			dao.register( dto );
		}
		public ArrayList<MemberDTO> getList() {
			ArrayList<MemberDTO> list = dao.getList();
			return list;
		}
		

}
