package com.sample.mybatis;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.MemberVO;
import com.example.service.MemberService;

@Controller
public class dkAccountView {

	private static final Logger logger = LoggerFactory.getLogger(dkAccountView.class);
	
	@Inject
	private MemberService service;
	
	@PostMapping(value = "/dk/accountRegister.do") 
	//@RequestMapping(value = "/dk/accountRegister.do", method = RequestMethod.POST)
	@ResponseBody
	public String accountRegister(@RequestBody MemberVO vo) throws Exception{
		//json 형식으로 ajax하기위해선 jackson librery 필요하고 해당 파일은 di로 추가해주면됨
		//Ajax 에서 보낸값을 리턴하기위해 @ResponseBody를 사용, @RequestBody는 ajax에서 던진 값을 받기위해 사용
		
		service.accountRegister(vo);
		
		String aa = "성공";
		return aa;
	}
	
	//회원가입 페이지 이동
		@GetMapping(value = "/dk/login.do")
		public ModelAndView userJoinView() {
			logger.info("로그인페이지");
			ModelAndView mav = new ModelAndView("main");
			return mav;
		}
	
}
