package com.cyh.b1.notice;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.b1.board.BoardVO;

@Controller
@RequestMapping("notice/**")
public class NoticeController {

	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	
	@GetMapping("noticeWrite")
	public String noticeWrite()throws Exception {
	
		return "board/boardWrite";
	}
	
	@PostMapping("noticeWrite")
	public String noticeWrite(NoticeVO noticeVO,List<MultipartFile>files)throws Exception {
		files.remove(0);
		noticeService.boardWrite(noticeVO, files);
		return "redirect:./noticeList";
		
	}
	
	
	
	@ModelAttribute(name="boardVO")
	public BoardVO getBoardVO() {
		return new BoardVO();
	}
	
	
	
	//이컨트롤러모든 메서드에서 모델을쓸떄 이걸 가져감.
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "notice";
	}
	
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(Model model ,Pageable pageable) throws Exception{
		ModelAndView mv= new ModelAndView();
		
		//하이버네이트 2.0부터는 new x
		Pageable pageable2 =PageRequest.of(0, 10 ,Sort.Direction.DESC,"num");
		//0번주터 글 10개씩/.
		
		List<NoticeVO>ar=noticeService.boardList(pageable2);
		
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(ModelAndView mv,Integer num) throws Exception{
		
		Optional<NoticeVO> opt = noticeService.boardSelect(num);
		
		if(opt.isPresent()) {
			
			mv.addObject("vo", opt.get());
			mv.setViewName("board/boardSelect");
		}else {
			//펄스면 없다.
			mv.addObject("msg", "존재하지 않는 글입니다.");
			mv.addObject("path", "../board/boardList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	
	
}
