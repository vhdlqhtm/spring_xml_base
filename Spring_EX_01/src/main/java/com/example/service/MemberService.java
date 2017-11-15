package com.example.service;
 
import java.util.List;

import com.example.dto.DkLogin;
import com.example.dto.MemberVO;
 
public interface MemberService {
    
    public List<MemberVO> selectMember() throws Exception;

	public void accountRegister(MemberVO vo);

	public int memberLogin(MemberVO vo);

}


