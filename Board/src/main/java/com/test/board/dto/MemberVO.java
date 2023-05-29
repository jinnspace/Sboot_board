package com.test.board.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class MemberVO {
	@NotNull
	@NotEmpty
	private String ID;
	@NotNull
	@NotEmpty
	private String PWD;
	@NotNull
	@NotEmpty
	private String NAME;
	@NotNull
	@NotEmpty
	private String PHONE;
	private String REID;
	private String PWDCHK;
}
