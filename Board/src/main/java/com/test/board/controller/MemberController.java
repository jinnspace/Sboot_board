package com.test.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.board.dto.MemberVO;
import com.test.board.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	@RequestMapping("/") //로그인 페이지 이동 (메인페이지)
	public String index() {
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST) //로그인
	public String login( @ModelAttribute("dto") @Valid MemberVO membervo , BindingResult result, HttpServletRequest request, Model model) {
		
		if( result.getFieldError("ID") != null ) { // id가 공백으로 들어갈때 ; getFieldError- vo에서 공백인지 검증하는 것이다. 그래서 vo에 not null/empty를 써야함.(js로 이를 검증할 때는 사용하지 않아도 됨.)
			model.addAttribute("message", "아이디를 입력해주세요." );
			return "member/loginForm";
		}else if( result.getFieldError("PWD")!=null) {
			model.addAttribute("message", "비밀번호를 입력해주세요." );
			return "member/loginForm";
		}
		
		MemberVO mvo = ms.getMember( membervo.getID() );

		if( mvo == null ) {
			model.addAttribute("message", "아이디가 없습니다."); //id가 데이터베이스와 다를때
			return "member/loginForm";
		}else if( !mvo.getPWD().equals( membervo.getPWD() ) ) {
			model.addAttribute("message", "비밀번호가 맞지않습니다.");
			return "member/loginForm";
		}else if( mvo.getPWD().equals( membervo.getPWD() ) ) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo );
			return "redirect:/boardList";
		}else {
			model.addAttribute("message", "관리자에게 문의하세요.");
			return "member/loginForm";
		}	
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		return "redirect:/boardList";
	}
	
	@RequestMapping("/joinForm") //회원가입 페이지 이동
	public String joinForm() {
		return "member/joinForm";
	}
	
	
	@RequestMapping("/idcheck")
	public String idcheck(@RequestParam("ID")String ID, Model model) {
		
		MemberVO mvo=ms.getMember(ID);
		if(mvo==null) model.addAttribute("result",-1);
		else model.addAttribute("result",1);
		
		model.addAttribute("ID",ID);
		return "member/idcheck";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute("dto") @Valid MemberVO membervo, BindingResult result, Model model) {
			
		if( result.getFieldError("ID")!=null)
			model.addAttribute("message", "아이디를 입력해주세요.");
		else if( result.getFieldError("PWD")!=null)
			model.addAttribute("message", "비밀번호를 입력해주세요.");
		else if( result.getFieldError("NAME")!=null)
			model.addAttribute("message", "이름을 입력해주세요." );
		else if( result.getFieldError("PHONE")!=null)
			model.addAttribute("message", "전화번호를 입력해주세요.");
		else if( !membervo.getID().equals(membervo.getREID()) ) 
			model.addAttribute("message", "아이디 중복체크가 되지 않았습니다");
		else if( !membervo.getPWD().equals(membervo.getPWDCHK())) 
			model.addAttribute("message","비밀번호 확인이 일치하지 않습니다.");
		else {
			ms.insertMember( membervo );
			model.addAttribute("message", "회원가입이 완료되었습니다. 로그인 하세요");
			return "member/loginForm"; 
		}
		return "member/joinForm";
		// vo 안에 reid와 pwdchk를 넣어도 롬복이 알아서 해줌 따라서 requestParam()안해도됨.
	}

}