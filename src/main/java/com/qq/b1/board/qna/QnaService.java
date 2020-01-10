package com.qq.b1.board.qna;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class QnaService {

	@Autowired
	private QnaRepository qnaRepository;
	
	public void qnaUpdate() throws Exception{
		
		qnaRepository.qnaUpdate("retitle", "recontents", 1);
		
	}
	
}
