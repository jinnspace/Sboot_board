package com.test.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.IMemberDao;
import com.test.board.dto.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	IMemberDao mdao;

	public MemberVO getMember(String id) {	
		return mdao.getMember(id);
	}

	public void insertMember(MemberVO mvo) {
		mdao.insertMember(mvo);
		
	}


}
