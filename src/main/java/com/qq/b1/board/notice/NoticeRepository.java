package com.qq.b1.board.notice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{

	// select * from notice where num > ? order by num desc
	//Page<NoticeVO> findByNumGreaterThanOrderByNumDesc(int num,Pageable pageable) throws Exception;
	Page <NoticeVO> findByNumGreaterThan(int num, Pageable pageable) throws Exception;
	
	Page<NoticeVO> findByTitleContainingAndNumGreaterThan(String title, int num, Pageable pageable) throws Exception;
}
