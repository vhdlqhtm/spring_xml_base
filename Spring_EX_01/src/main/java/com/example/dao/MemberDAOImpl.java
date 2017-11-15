package com.example.dao;
 
import java.util.List;
 
import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.dto.DkLogin;
import com.example.dto.MemberVO;
 
@Repository
public class MemberDAOImpl implements MemberDAO {
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.example.mapper.memberMapper";
    
    @Override
    public List<MemberVO> selectMember() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectMember");
    }

	@Override
	public void accountRegister(MemberVO vo) {
		sqlSession.insert(Namespace+".accountRegister", vo);
	}

	@Override
	public int memberLogin(MemberVO vo) {
		int aa = sqlSession.selectOne(Namespace+".memberLogin", vo);
		if(aa == 1) {
			System.out.println("정상");
		}else {
			System.out.println("비정상");
		}
		return aa;
	}

}
