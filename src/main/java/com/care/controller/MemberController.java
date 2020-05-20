package com.care.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.member_service.MemberChkServiceImpl;
import com.care.member_service.MemberChkUserServiceImpl;
import com.care.member_service.MemberService;
import com.care.member_service.MemberUserInfoServiceImpl;
import com.care.member_service.memberInfoServiceImpl;
import com.care.template.Constant;
import com.test.service.LogShowServiceImpl;

@Controller
public class MemberController {
	private MemberService memberService;
	
	public MemberController() {
		System.out.println("자동으로 실행됩니다");
		//web.xml -> servlet-context.xml을 스캔한다.
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
		Constant.template = template;
	}
	
	@RequestMapping("header")
	public String header() {
		return "default/header";
	}
	
	@RequestMapping("footer")
	public String footer() {
		return "default/footer";
	}
	
	@RequestMapping("main")
	public String main() {
		return "default/main";
	}
	
	@RequestMapping("index")
	public String index() {
		return "member/index";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/logout";
	}
	
	@RequestMapping("member")
	public String member() {
		return "member/member";
	}
	
	@RequestMapping("successLogin")
	public String successLogin() {
		return "member/successLogin";
		
	}
	@RequestMapping("chkUser")
	public String chkUser(HttpServletRequest request, Model model) {
		HttpSession session = null;
		model.addAttribute("request", request);
		memberService = new MemberChkUserServiceImpl();
		memberService.execute(model);
		Map<String, Object> map = model.asMap();
		Boolean chkUserResult = (Boolean)map.get("chkUserResult");
		if(chkUserResult == true) {
			session = request.getSession();
			session.setAttribute("mySession",  request.getParameter("id"));
			return "member/chkUser";
		}else{
			System.out.println("로그인 실패");
			return "member/chkUser";
		}
	}
	
	@RequestMapping("memberChk")
	public String memberChk(Model model, HttpServletRequest request) {
		HttpSession session = null;
		model.addAttribute("request", request);
		memberService = new MemberChkServiceImpl();
		memberService.execute(model);
		Map<String, Object> map = model.asMap();
		Boolean memberChk = (Boolean)map.get("memberChk");
		if(memberChk == true) {
			session = request.getSession();
			session.setAttribute("mySession",  request.getParameter("id"));
			return "redirect:index";
		}else {
			System.out.println("회원가입 실패");
			return "redirect:member";
		}
	}
	
	@RequestMapping("memberInfo")
	public String content(Model model) {
		memberService = new memberInfoServiceImpl();
		memberService.execute(model);
		return "member/memberInfo";
	}
	
	@RequestMapping("userInfo")
	public String userInfo(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		memberService = new MemberUserInfoServiceImpl();
		memberService.execute(model);
		return "member/userInfo";
	}
	
	@RequestMapping("showLog")
	public String showLog(Model model) {
		LogShowServiceImpl lss = new LogShowServiceImpl();
		lss.logs(model);
		return "member/showLog";
	}
}
