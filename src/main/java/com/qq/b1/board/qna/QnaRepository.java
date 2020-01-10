package com.qq.b1.board.qna;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QnaRepository extends JpaRepository<QnaVO, Integer> {

	List<QnaVO> findByNumGreaterThan(int num,Pageable pageable) throws Exception;
	
	@Query("select q from QnaVO q order by q.ref desc, q.step asc")
	List<QnaVO> findQnas() throws Exception;

	@Query("select q from QnaVO q where num = :num")
	QnaVO findQnaVO(@Param("num")int num) throws Exception;
	
	@Modifying(clearAutomatically = true)
	@Query("update QnaVO q set title=:title, contents =:contents where num=:num")
	void qnaUpdate(@Param("title")String title, @Param("contents")String contents, @Param("num")int num ) throws Exception;
	
	@Query("select q.writer, q.contents from QnaVO q where num =?1")
	List<Object[]> qnaSelect(int num) throws Exception;
	
	
	
}
