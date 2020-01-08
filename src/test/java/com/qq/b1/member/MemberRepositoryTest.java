package com.qq.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	void test() throws Exception {
		//long count = memberRepository.count();
		//boolean check = memberRepository.existsById("admin");
		/*
		 * List<MemberVO> ar = memberRepository.findAll(); 
		 * for(MemberVO memberVO:ar) {
		 * 	System.out.println(memberVO.getId()); 
		 * }
		 */
		
		/*
		 * Optional<MemberVO> opt = memberRepository.findById("qq241");
		 * if(opt.isPresent()) {
		 * 
		 * MemberVO memberVO = opt.get(); System.out.println(memberVO.getEmail());
		 * 
		 * }else { System.out.println("NO DATA"); }
		 */
		List<MemberVO> ar =  memberRepository.findByIdAndPw("admin","admin");
		
		for(MemberVO memberVO:ar) {
			System.out.println(memberVO.getId());
		}
		
		
/*		MemberVO memberVO = new MemberVO();
		memberVO.setId("qqq11");
		memberVO.setPw("qqq11");
		memberVO.setName("TestName");
		memberVO.setEmail("qqq11@qq.com");
		memberRepository.save(memberVO);*/
		
	}

}
