	package com.care.aaa;

import org.springframework.stereotype.Repository;

@Repository //이러한 객체들을 빈으로 등록을 함, 데이터에 접근을 하겠다 싶으면 Repository를 붙임
public class MemberDAO {
		public MemberDAO() {
			System.out.println("MemberDAO");
		}

}
