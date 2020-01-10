package com.qq.b1.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qq.b1.util.FilePathGenerator;
import com.qq.b1.util.FileSaver;
import com.qq.b1.util.Pager;

@Service
@Transactional
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private NoticeFilesRepository noticeFilesRepository;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	/*
	 * public Page<NoticeVO> noticeList(Pager pager) throws Exception{ Pageable
	 * pageable = PageRequest.of(pager.getCurPage(), 10); Page<NoticeVO> ar =
	 * noticeRepository.findByNumGreaterThanOrderByNumDesc(0, pageable);
	 * 
	 * return ar; }
	 */

	public Pager boardList(Pager pager)throws Exception{
		// PageRequest 생성
		//Sort.by("num").descending().and(Sort.by("").ascending()
		pager.makePageRequest(Sort.by("num").descending());
		
		Page<NoticeVO> p  = noticeRepository.findByNumGreaterThan(0, pager.getPageable());
		
		
		pager.setPageList(p);
		
		//페이징 처리 계산
		pager.makeNum();
		
		
		return pager;
	}

	
	public NoticeVO noticeSelect(NoticeVO noticeVO) throws Exception{
		return noticeRepository.findById(noticeVO.getNum()).get();
	}
	
	public Boolean noticeWrite(NoticeVO noticeVO, List<MultipartFile> files) throws Exception{
		
		List<NoticeFilesVO> ar = new ArrayList<NoticeFilesVO>();
		
				
		
				
		for(MultipartFile mf :files) {
				
			if(!mf.isEmpty()) {
					File file = filePathGenerator.getUseClassPathResource("upload");
					String filename = fileSaver.save(file, mf);
					
					NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
					noticeFilesVO.setNoticeVO(noticeVO);
					noticeFilesVO.setFname(filename);
					noticeFilesVO.setOname(mf.getOriginalFilename());
				
					ar.add(noticeFilesVO);
					}
		}
				
		
		noticeVO.setNoticeFilesVO(ar);
		noticeVO = noticeRepository.save(noticeVO);
		if(noticeRepository.existsById(noticeVO.getNum())) {
			return true;
		}

		return false;
		
	}

}
