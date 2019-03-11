package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.dto.MemberVO;


public interface MemberService {
	
	//public List<MemberVO> selectMember() throws Exception;
	public MemberVO read(String id) throws Exception;
	public void insertReply(MemberVO vo) throws Exception;
	//public Map<String,Object>  updateReply(Map<String,Object>  params) throws Exception;
	public List<MemberVO> selectMember() throws Exception;
	
 

}
