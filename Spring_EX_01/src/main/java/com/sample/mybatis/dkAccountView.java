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
		//json �삎�떇�쑝濡� ajax�븯湲곗쐞�빐�꽑 jackson librery �븘�슂�븯怨� �빐�떦 �뙆�씪�� di濡� 異붽��빐二쇰㈃�맖
		//Ajax �뿉�꽌 蹂대궦媛믪쓣 由ы꽩�븯湲곗쐞�빐 @ResponseBody瑜� �궗�슜, @RequestBody�뒗 ajax�뿉�꽌 �뜕吏� 媛믪쓣 諛쏄린�쐞�빐 �궗�슜
		
		service.accountRegister(vo);
		
		String aa = "�꽦怨�";
		return aa;
	}
	
	//�쉶�썝媛��엯 �럹�씠吏� �씠�룞
		@GetMapping(value = "/dk/login.do")
		public ModelAndView userJoinView() {
			logger.info("濡쒓렇�씤�럹�씠吏�");
			ModelAndView mav = new ModelAndView("main");
			return mav;
		}
		
		@GetMapping(value = "/test.do")
		public ModelAndView test() {
			ModelAndView mav = new ModelAndView("test");
			return mav;
		}
	
}
