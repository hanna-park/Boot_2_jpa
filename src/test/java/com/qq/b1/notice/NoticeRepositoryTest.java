package com.qq.b1.notice;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qq.b1.board.notice.NoticeFilesVO;
import com.qq.b1.board.notice.NoticeRepository;
import com.qq.b1.board.notice.NoticeVO;
@SpringBootTest
@Transactional
class NoticeRepositoryTest {

	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Test
	void test() {
		
		NoticeVO noticeVO = noticeRepository.findById(1).get();
		System.out.println(noticeVO.getWriter());
		for(NoticeFilesVO noticeFilesVO: noticeVO.getNoticeFilesVO()) {
			System.out.println(noticeFilesVO.getFname());
		}
	}

}
