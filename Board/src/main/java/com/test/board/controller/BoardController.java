package com.test.board.controller;

import java.util.List;

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

import com.test.board.dto.BoardVO;
import com.test.board.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;		

	@RequestMapping("/boardList") // 게시판 리스트
	public String boardList(Model model,HttpServletRequest request) {
		List<BoardVO> list = bs.Bgetboard();
		model.addAttribute("list", list);
		return "board/boardList";
	}
	
	
	@RequestMapping("/boardView")
	public String boardView(Model model,@RequestParam("BRDNO") int BRDNO, HttpServletRequest request) {
		// 내가 여기서 해야할 일은 게시물 조회 한가지이므로 hashmap을 사용할 필요가 없다.
		
		BoardVO bvo = bs.boardView(BRDNO);	
		model.addAttribute("board",bvo);
		return "board/boardView";		
	}
	
	
	@RequestMapping("/boardWriteForm") // 게시판 작성페이지로 이동 
	public String boardWriteForm(HttpServletRequest request) {
		String url="board/boardWriteForm";
		return url;
	}
	
	
	@RequestMapping( value="/boardWrite", method=RequestMethod.POST) // 게시물 작성 
	public String boardWrite( @ModelAttribute("dto") @Valid BoardVO boardvo, BindingResult result, Model model, HttpSession session ) {		
		if(session.getAttribute("loginUser")==null) return "redirect:/";
		String url = "board/boardWriteForm";
		if( result.getFieldError("BRDNAME")!=null)
			model.addAttribute("message", "제목을 입력하세요." );
		else if( result.getFieldError("BRDCONTENT")!=null)
			model.addAttribute("message", "내용을 입력하세요." );
		else {			
			bs.insertBoard(boardvo);
			url = "redirect:/boardList";
		}
			return url;
	 }
	
	@RequestMapping("/boardUpdateForm") // 게시물 수정 폼으로 이동 - boardView와 같음
	public String boardUpdateForm(@RequestParam("BRDNO") int BRDNO, Model model,  HttpServletRequest request) {
		BoardVO bvo = bs.boardView(BRDNO);
		model.addAttribute("BRDNO", BRDNO);
		model.addAttribute("dto", bvo);
		return "board/boardUpdateForm";
	}
	
	@RequestMapping(value="/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate( @ModelAttribute("dto") @Valid BoardVO boardvo,BindingResult result, HttpServletRequest request, Model model) {
		
		String url = "board/boardUpdateForm";
		
		if(result.getFieldError("BRDNAME")!=null) 
			model.addAttribute("message" , "제목을 입력하세요.");
		else if(result.getFieldError("BRDCONTENT")!=null) 
			model.addAttribute("message" , "내용을 입력하세요.");
		else {		
			bs.updateBoard( boardvo );
			url = "redirect:/boardView?BRDNO=" + boardvo.getBRDNO();
		}
		return url;
	}
	
	@RequestMapping("boardDelete")
	public String boardDelete(@RequestParam("BRDNO") int BRDNO) {
		
		bs.deleteBoard(BRDNO);	
		return "redirect:/boardList";
	}
	
	
}
	 

	
	



