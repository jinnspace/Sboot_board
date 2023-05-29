package com.test.board.dao;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.test.board.dto.BoardVO;

@Mapper
public interface IBoardDao {

	List<BoardVO> Bgetboard();

	BoardVO boardView(int BRDNO);

	void insertBoard(@Valid BoardVO boardvo);

	void updateBoard(@Valid BoardVO boardvo);

	void deleteBoard(int BRDNO);





}
