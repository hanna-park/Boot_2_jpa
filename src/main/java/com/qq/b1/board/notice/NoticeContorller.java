package com.qq.b1.board.notice;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qq.b1.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeContorller {

	
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	
	@ModelAttribute(name="board")
	public String getBoard() {
		return "notice";
	}
	
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(Model model, Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		//Pageable pageable2 = PageRequest.of(0, 10, Sort.Direction.ASC, "num");
		
		
		//List<NoticeVO> ar = noticeService.boardList(pageable2);
		pager = noticeService.boardList(pager);
		mv.addObject("list", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	/*
	 * @GetMapping("noticeList") public ModelAndView noticeList(Pager pager) throws
	 * Exception { ModelAndView mv = new ModelAndView();
	 * 
	 * Page<NoticeVO> ar = noticeService.noticeList(pager); List<NoticeVO> br =
	 * ar.getContent();
	 * 
	 * mv.addObject("list",br); mv.setViewName("board/boardList"); return mv; }
	 */
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(NoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		/*
		 * Optional<NoticeVO> opt = noticeService.noticeSelect(num);
		 * 
		 * if(opt.isPresent()) { mv.setViewName("board/boardSelect");
		 * mv.addObject("vo",opt.get()); 
		 * }else { mv.addObject("msg","없는 게시물");
		 * mv.addObject("path","./noticeList"); 
		 * mv.setViewName("common/result"); }
		 */
		
		noticeVO = noticeService.noticeSelect(noticeVO);
		mv.addObject("vo",noticeVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView noticeWrite(NoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("noticeVO",noticeVO);
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(NoticeVO noticeVO, List<MultipartFile> files) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		files.remove(0);
		
		String msg = "작성 실패";
		String path = "./noticeList";
		
		boolean check = noticeService.noticeWrite(noticeVO, files);
		
		if(check) {
			msg="작성 성공";
		}
		
		mv.addObject("msg",msg);
		mv.addObject("path",path);
		mv.setViewName("common/result");
		return mv;
	}
	
}
