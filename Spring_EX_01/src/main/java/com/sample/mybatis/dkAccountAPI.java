package com.sample.mybatis;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.MemberVO;
import com.example.service.MemberService;

@Controller
public class dkAccountAPI {

	@Inject
	private MemberService service;
	
	@PostMapping(value = "/dk/memberLogin.api")
	@ResponseBody
	public String memberLogin(@RequestBody MemberVO vo,
							  HttpSession session) throws Exception {
		String aa = null;
		//여기서 서비스에 던지는 값은 해당값을 조회하기 위한 값이다 이형식으로 값을 리턴받는게아니다!(까먹지마라 빡대가리야)
		int value = service.memberLogin(vo);
		System.out.println("현재 정보조회값 = "+value);
		if(value == 1) {
			aa = "OK";
			session.setAttribute("user", vo);
		} else {
			aa = "FALSE";
		}
		return aa;
	}
	
}
