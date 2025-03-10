package com.spring.springTiles.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.springTiles.service.MemberService;
import com.spring.springTiles.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
	public String memberLoginGet() {
		log.info("MemberController의 memberLogin입니다.");
		return "member/memberLogin";
	}
	@RequestMapping(value = "/memberLogin", method = RequestMethod.POST)
	public String memberLoginPost(Model model, MemberVo vo, HttpServletRequest request, HttpServletResponse response) {
		log.info("MemberController의 memberLogin Post입니다.");
		
		//아이디의 첫글자가 'a'/'A' 인 경우만 회원인증처리하시오.
		if(vo.getMid().substring(0, 1).toLowerCase().equals("a")) { // 회원인 경우
		// 1. Session처리	
			HttpSession session = request.getSession();
			session.setAttribute("sMid", vo.getMid());
			
		// 2. Cookie처리	
		System.out.println("idSave : " + vo.getIdSave());
		if(vo.getIdSave() != null && vo.getIdSave().equals("on")) {
			Cookie cookieMid = new Cookie("cMid", vo.getMid());
			cookieMid.setPath("/");
			cookieMid.setMaxAge(60*60*24*7); // 단위:초...쿠키 만료시간을 7일로 지정
			response.addCookie(cookieMid);
		}
		else { //쿠키 삭제처리
			System.out.println("쿠키삭제");
			
			Cookie[] cookies = request.getCookies();

			if(cookies != null) {
				for(int i=0; i<cookies.length; i++) {
					if(cookies[i].getName().equals("cMid")) {
						cookies[i].setPath("/");
						cookies[i].setMaxAge(0);
						response.addCookie(cookies[i]);
						break;
					}
				}
			}
		}
		// 3. DB처리
			
		// 4. 기타처리	
			return "redirect:/message/memberLoginOk?mid="+vo.getMid();
		}
		else {  // 비회원인 경우(로그인 실패시~)
			return "redirect:/message/memberLoginNo"+vo.getMid();
			
		}
		
	}
	
}
