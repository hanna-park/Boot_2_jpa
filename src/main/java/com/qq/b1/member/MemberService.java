package com.qq.b1.member;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.qq.b1.util.FilePathGenerator;
import com.qq.b1.util.FileSaver;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	@Autowired 
	private ServletContext servelContext;
	 
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	
	public List<MemberVO> memberLogin(MemberVO memberVO)throws Exception{
		List<MemberVO> ar = memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
		return ar; 
	}
	
	public List<MemberFilesVO> memberFilesSelect(MemberFilesVO memberFilesVO) throws Exception{
		List<MemberFilesVO> ar = null;
		//memberFilesRepository.findById(memberFilesVO.getFname());
		return ar;
	}
	
	public boolean memberIdCheck(String id) throws Exception{
		return memberRepository.existsById(id);
	}
	
	public void memberUpdate(MemberVO memberVO, MultipartFile files) throws Exception{
		
		if(files.getSize()>0) {
			File file = filePathGenerator.getUseClassPathResource("upload");
			String fileName = fileSaver.save(file,files);
			MemberFilesVO memberFilesVO = memberVO.getMemberFilesVO();
			memberVO.getMemberFilesVO().setFname(fileName);
			memberVO.getMemberFilesVO().setOname(files.getOriginalFilename());
			
			memberVO.setMemberFilesVO(memberFilesVO);
			memberFilesVO.setMemberVO(memberVO);
		}else {
			memberVO.setMemberFilesVO(null);
		}
		
		memberRepository.save(memberVO);
	}
	
	public Boolean idCheck(MemberVO memberVO) throws Exception {
		return memberRepository.existsById(memberVO.getId());
	}
	
	public Boolean memberJoin(MemberVO memberVO, MultipartFile files) throws Exception{
		memberVO = memberRepository.save(memberVO);
		
		if(memberRepository.existsById(memberVO.getId())) {
			File file = filePathGenerator.getUseClassPathResource("upload");
			String filename = fileSaver.save(file, files);
			
			MemberFilesVO memberFilesVO = new MemberFilesVO();
			memberFilesVO.setMemberVO(memberVO);
			memberFilesVO.setFname(filename);
			memberFilesVO.setOname(files.getOriginalFilename());
			
			memberFilesVO = memberFilesRepository.save(memberFilesVO);
			
			//return memberFilesRepository.existsById(memberVO.getId());
			return true;
		} else {
			return false;
		}
		
	}
	
	public MemberFilesVO memberFileSelect (MemberVO memberVO) throws Exception {
		//List<MemberFilesVO> ar = memberFilesRepository.findById(memberVO.getId());
		//return ar.get(0);
		return new MemberFilesVO();
	}
	
	
	

}