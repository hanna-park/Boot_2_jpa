package com.qq.b1.board.notice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.qq.b1.board.BoardVO;
import com.qq.b1.board.notice.NoticeVO;

import lombok.Data;

@Entity
@Table(name="notice")
@Data	//setter, getter, equals, hashcode
public class NoticeVO extends BoardVO{
	
	@OneToMany(mappedBy = "noticeVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NoticeFilesVO> noticeFilesVO;


}