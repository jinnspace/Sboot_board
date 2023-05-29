package com.test.board.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BoardVO {
	
	@NotNull
	private int BRDNO;
	@NotNull
	@NotEmpty
	private String ID;
	@NotNull
	@NotEmpty
	private String BRDNAME;
	@NotNull
	@NotEmpty
	private String BRDCONTENT;
	private Timestamp BRDINDATE;
}
