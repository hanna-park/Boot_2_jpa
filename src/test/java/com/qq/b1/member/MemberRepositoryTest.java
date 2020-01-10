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
	
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	@Test
	void updateTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("qqq");
		memberVO.setPw("qq");
		memberVO.setName("qwq");
		memberVO.setEmail("qq@c");
		
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setFname("QQQQ.jsp");
		memberFilesVO.setOname("memba.jsp");
		
		memberVO.setMemberFilesVO(memberFilesVO);
		memberFilesVO.setMemberVO(memberVO);
		
		memberRepository.save(memberVO);
	}
	
	
	//@Test
	void InsertTest() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("qq2112");
		memberVO.setPw("qq2141");
		memberVO.setName("qqq22");
		memberVO.setEmail("qq214124@qq.com");
		
		MemberFilesVO memberfilesVO = new MemberFilesVO();
		memberfilesVO.setMemberVO(memberVO);
		memberfilesVO.setFname("1241241qq.jpg");
		memberfilesVO.setOname("1241412wqq.jpg");
	
		memberVO.setMemberFilesVO(memberfilesVO);
		
		memberRepository.save(memberVO);
	
	}
	
	
	//@Test
	void SelectTest() {
		Optional<MemberVO> opt = memberRepository.findById("admin");
		MemberVO memberVO = opt.get();
		System.out.println(memberVO.getName());
		System.out.println(memberVO.getEmail());
		System.out.println(memberVO.getMemberFilesVO().getFname());
		System.out.println(memberVO.getMemberFilesVO().getMemberVO().getId() );
		
	}
	
	
	//@Test
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
