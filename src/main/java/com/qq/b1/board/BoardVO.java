package com.qq.b1.board;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

import com.qq.b1.board.BoardVO;

import lombok.Data;

@Data
@MappedSuperclass
public class BoardVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String title;
	private String writer;
	private String contents;
	@CreationTimestamp
	private Date regDate;
	private int hit;
}
