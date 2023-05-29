package com.test.board.dao;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.test.board.dto.MemberVO;

@Mapper
public interface IMemberDao {

	MemberVO getMember(String id);
	
	void insertMember(@Valid MemberVO membervo);

}
