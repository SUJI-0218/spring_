package com.care.root.mybatis.member;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO getMember(String id);
	public ArrayList<MemberDTO> getList(); 
//	public ArrayList<MemberDTO> getData(String id); 
	public ArrayList<MemberDTO> getData(@Param("bbb") String id); 
	public int register( MemberDTO dto );
//	public void keepLogin(String sessionId, String id);
	public void keepLogin(@Param("sessionId") String sessionId, @Param("id") String id );
	public MemberDTO getSessionId(String sessionId );
}
