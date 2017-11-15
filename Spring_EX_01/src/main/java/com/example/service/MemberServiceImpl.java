package com.example.service;
 
import java.util.List;
 
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.dao.MemberDAO;
import com.example.dto.DkLogin;
import com.example.dto.MemberVO;
 
@Service
public class MemberServiceImpl implements MemberService {
 
    @Inject
    private MemberDAO dao;
    
    @Override
    public List<MemberVO> selectMember() throws Exception {
 
        return dao.selectMember();
    }

	public void accountRegister(MemberVO vo) {
		dao.accountRegister(vo);
	}

	@Override
	public int memberLogin(MemberVO vo) {
		return dao.memberLogin(vo);
	}

}
