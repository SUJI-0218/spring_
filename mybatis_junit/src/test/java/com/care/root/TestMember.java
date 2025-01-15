package com.care.root;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = 
{"classpath:testMember.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"} )
public class TestMember {
	@Autowired MemberController mc; //auto를 통해서 객체가 자동적으로 등록이 됨
	@Autowired MemberService ms;
	@Autowired MemberDAO dao;
	
	//지금 이렇게 확인하고 있는거는 단위test라고 보면 됨, 하나씩 확인하면서 가는거라고 생각하면 됨
	@Test
	public void testMc() {
		System.out.println("---mc => " + mc );
		assertNotNull(mc);//해당하는 객체가 null값인지 아닌지 알려주는 역할임 
	}
	
	@Test
	public void testMs() {
		
		MemberDTO dto = new MemberDTO();
		dto.setId(1);
		dto.setName("홍길동");
		
		int result = dao.insertMember(dto); //dao에 int insertMemberDTO로 받아왔기 때문에 int로 결과값을 받아옴
		System.out.println("result : " + result );
		assertEquals( 1, result );
		
		assertNotNull(ms);//해당하는 객체가 null값인지 아닌지 알려주는 역할임 
		//select * from test_mybatis; 이렇게 smd에 치면 table에 담기 데이터 값을 받아올 수 있음
	
	}
	
	@Test
	public void testDao() { //dao가 잘 작동하는지 확인을 하는거임
		MemberDTO dto = new MemberDTO();
		dto.setId(1);
		dto.setName("홍길동");
		
		int result = dao.insertMember(dto); //dao에 int insertMemberDTO로 받아왔기 때문에 int로 결과값을 받아옴
		System.out.println("result : " + result );
		assertEquals( 1, result );
		assertNotNull(dao);//해당하는 객체가 null값인지 아닌지 알려주는 역할임 
		//select * from test_mybatis; 이렇게 smd에 치면 table에 담기 데이터 값을 받아올 수 있음
	}
	 
	@Test
	public void getList() {
		ArrayList<MemberDTO> list = dao.getList();
		System.out.println( list.size() );
		System.out.println( list.get(0).getName() );
//		assertEquals(4, list.size());
//		assertNotNull(list);
		assertNotSame( 0, list.size() );
		}

}























