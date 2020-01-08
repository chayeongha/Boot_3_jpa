package com.cyh.b1.notice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(ModelAndView mv) throws Exception{
		List<NoticeVO> ar = noticeService.noticeList();
		mv.addObject("list", ar);
		return mv;
	}
	
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(ModelAndView mv, int num) throws Exception{
		Optional<NoticeVO> opt = noticeService.noticeSelect(num);
		
		if(opt.isPresent()) {
			mv.addObject("noticeVO", opt.get());
			mv.setViewName("board/boardSelect");
		}else {
			mv.addObject("msg", "존재하지 않는 글입니다.");
			mv.addObject("path", "../board/boardList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	
	
}
