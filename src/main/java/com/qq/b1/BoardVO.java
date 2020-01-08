package com.qq.b1;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	
	private int nm;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private int hit;
	
}
