package com.example.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.dto.MemberVO;


@Service
public class MemberServiceImpl implements MemberService{

	@Inject
    private MemberDAO dao;
    
    @Override
    public List<MemberVO> selectMember() throws Exception {
 
        return dao.selectMember();
    }

	@Override
	public MemberVO read(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public void insertReply(MemberVO vo) throws Exception {
	    dao.insertReply(vo);
	}
	
    

}
