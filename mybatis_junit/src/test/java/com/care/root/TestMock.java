package com.care.root;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.care.root.member.controller.MemberController;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = 
{"classpath:testMember.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"} )
public class TestMock {
	@Autowired MemberController mc;
	MockMvc mock;
	
	@Before
	public void setUp() {
		System.out.println("--- setUp 실행 ---");
		mock = MockMvcBuilders.standaloneSetup(mc).build();
	}
	
	@Test
	public void testIndex() throws Exception {
		mock.perform(get("/index"))
		.andDo(print()) //;을 넣으면 안됨 이어서 작성되는것이라고 보면 됨
		.andExpect( status().isOk() ) //비교 기능
		.andExpect( forwardedUrl("member/index"));
	}
	//test인데 데이터가 저장이 되면 안되는데 저장이 됨, 그것을 저장을 하지않게 만들고 rollback을 통해서 되돌린다고 생각하면 됨
	
	@Test
	@Transactional( transactionManager = "txMgr")
	public void testInsert() throws Exception {
		mock.perform( post("/insert").param("id", "7878").param("name", "7878") )
		.andDo( print() ) //성공을 하면 insert에서 저 데이터를 추가를 해줌
		.andExpect( status().is3xxRedirection() ); //성공이 떴으면 데이터베이스에도 저장이 될거니 test의 성공여부만 확인하면 됨
	}
	@Test
	public void testMemberView() throws Exception {
		mock.perform(get("/memberview"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/memberview"))
		.andExpect(model().attributeExists("list"));
		//위에서부터 하나씩 차근차근 test해보기!
	}
	
	@Test
	public void test() {
		System.out.println("--- test 실행 ---");
	}

}
