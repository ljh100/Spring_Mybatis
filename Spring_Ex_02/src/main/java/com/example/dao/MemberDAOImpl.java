package com.example.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static final String Namespace = "com.example.mapper.memberMapper";
			
	@Override
	public List<MemberVO> selectMember() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace + ".selectMember");
	}

	@Override
	public MemberVO read(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace + ".read", id);
		
		
	}
	@Override
	public void insertReply(MemberVO vo) throws Exception {
		sqlSession.insert(Namespace + ".insertReply", vo);
		
	}
	

	/*public Map<String, Object> updateReply(Map<String, Object>  params) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(Namespace + ".updateReply", params);
		return params;
	}*/

	
}
