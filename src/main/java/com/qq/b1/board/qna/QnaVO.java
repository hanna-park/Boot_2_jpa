package com.qq.b1.board.qna;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.qq.b1.board.BoardVO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="qna")
@Getter
@Setter
public class QnaVO extends BoardVO{


	private int ref;	
	@ColumnDefault("0")
	private int depth;
	@ColumnDefault("0")
	private int step;
	

	@OneToMany(mappedBy = "qnaVO", cascade =CascadeType.ALL)
	private List<QnaFilesVO> qnaFilesVO;
	
}
