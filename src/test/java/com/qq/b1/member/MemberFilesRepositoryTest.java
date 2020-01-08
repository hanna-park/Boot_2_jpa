package com.qq.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MemberFilesRepositoryTest {

	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	@Test
	void test() {
		//long count = memberFilesRepository.count();
		//boolean check =  memberFilesRepository.existsById(1);
		//MemberFilesVO memberFilesVO = memberFilesRepository.findById("admin");
		//System.out.println(memberFilesVO.getOname());
		
	}

}
