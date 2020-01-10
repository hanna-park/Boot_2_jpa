package com.qq.b1.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.qq.b1.board.qna.QnaFilesVO;
import com.qq.b1.board.qna.QnaRepository;
import com.qq.b1.board.qna.QnaService;
import com.qq.b1.board.qna.QnaVO;
//@Transactional
@SpringBootTest
class QnaRepositoryTest {
	
	@Autowired
	private QnaRepository qnaRepository;
	
	@Autowired
	private QnaService qnaService;
	
	@Test
	void columnTest() throws Exception{
		List<Object []> obj = qnaRepository.qnaSelect(1);
		for(Object[] o:obj) {
			for(Object o2:o) {
			System.out.println(o);
			}
		}
	}
	
	
	//@Test
	void updateTest() throws Exception{
		qnaService.qnaUpdate();
		
	}
	
	
	//@Test
	void selectOneTest() throws Exception{
		QnaVO qnaVO = qnaRepository.findQnaVO(1);
		System.out.println(qnaVO.getTitle());
		System.out.println(qnaVO.getQnaFilesVO().get(0).getFname());
	}
	
	
	//@Test
	void selectTest2() throws Exception{
		List<QnaVO> ar = qnaRepository.findQnas();
		for(QnaVO qnaVO:ar) {
			System.out.println(qnaVO.getTitle());
			for(QnaFilesVO qnaFilesVO : qnaVO.getQnaFilesVO()) {
				System.out.println(qnaFilesVO.getFname());
			}
		}
	}
	
	//@Test
	void selectTest() throws Exception{
		Pageable pageable = PageRequest.of(0, 10, Sort.by("ref").descending().and(Sort.by("step").ascending()));
		/*List<QnaVO> ar = qnaRepository.findByNumGreaterThan(0, pageable);
		for(QnaVO qnaVO:ar) {
			System.out.println(qnaVO.getTitle());
		}*/
	}

	//@Test
	void test() {
		QnaVO qnaVO = new QnaVO();
		
		qnaVO.setTitle("qq");
		qnaVO.setWriter("qq123");
		qnaVO.setContents("woW");
		
		List<QnaFilesVO> ar = new ArrayList<QnaFilesVO>();
		QnaFilesVO qnaFilesVO = new QnaFilesVO();
		
		qnaFilesVO.setFname("qq.jpg");
		qnaFilesVO.setOname("Qqqqqq.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		ar.add(qnaFilesVO);
		
		qnaFilesVO = new QnaFilesVO();
		
		qnaFilesVO.setFname("qq22.jpg");
		qnaFilesVO.setOname("Qqqqqq22.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		ar.add(qnaFilesVO);
		
		qnaVO.setQnaFilesVO(ar);
		
		qnaVO = qnaRepository.save(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		qnaRepository.save(qnaVO);
		
	}

}
