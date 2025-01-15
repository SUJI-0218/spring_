package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberSeriveceImpl implements MemberSerivece{
	@Autowired MemberMapper mapper;
	BCryptPasswordEncoder encoder;
	public MemberSeriveceImpl() {
		encoder = new BCryptPasswordEncoder();
	}
	public int loginCheck(String id, String pwd) {
		//select * from table where id = id
		//MemberDTO dto = mapper.getMember(id);
		ArrayList<MemberDTO> list = mapper.getData(id);
		//if(dto != null) { //일치하는 데이터 있음
		if( list.size() != 0 ) {
			MemberDTO dto = list.get(0);

			System.out.println(encoder.matches(id, dto.getPwd()));

			if(pwd.equals(dto.getPwd()) ||
					encoder.matches(pwd, dto.getPwd())) {
				return 1;
			}
		}
		return 0;
	}
	public ArrayList<MemberDTO> getList(){
		//return mapper.getList();
		return mapper.getData( null );
	}
	public MemberDTO getMember(String id) {
		ArrayList<MemberDTO> list = mapper.getData(id);
		return list.get(0);
	}
	public int register( MemberDTO dto ) {
		//암호화
		String securePwd = encoder.encode(dto.getPwd());
		System.out.println("pwd : " + dto.getPwd());
		System.out.println("securePwd : " + securePwd);
		dto.setPwd(securePwd);

		int result = 0;
		try {
			result = mapper.register( dto );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public void keepLogin(String sessionId, String id) {
		mapper.keepLogin(sessionId, id);
	}
	public MemberDTO getSessionId(String sessionId ) {
		return mapper.getSessionId(sessionId);
	}
}











