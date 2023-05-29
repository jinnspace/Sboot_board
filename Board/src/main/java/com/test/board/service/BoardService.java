package com.test.board.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.IBoardDao;
import com.test.board.dto.BoardVO;


@Service
public class BoardService {
	
	@Autowired
	IBoardDao bdao;

	public List<BoardVO> Bgetboard() {
		return bdao.Bgetboard();
	}
	
	public BoardVO boardView(int BRDNO) {
		return bdao.boardView(BRDNO);
	}

	public void insertBoard(@Valid BoardVO boardvo) { //게시물 작성
		bdao.insertBoard(boardvo);
		
	}

	public void updateBoard(@Valid BoardVO boardvo) { // 게시물 수정
		bdao.updateBoard(boardvo);
		
	}

	public void deleteBoard(int BRDNO) {
		bdao.deleteBoard(BRDNO);
		
	}





	


}
