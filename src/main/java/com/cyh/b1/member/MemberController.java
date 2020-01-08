package com.cyh.b1.member;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

		@Autowired
		private MemberService memberService;
		
		@GetMapping("memberDelete")
		public String memberDelete(HttpSession session)throws Exception {
			
			MemberVO memberVO = (MemberVO)session.getAttribute("member");
			memberService.memberDelete(memberVO);
			session.invalidate();
			return "redirect:../";
		}
		
		
		
		//아이디체크
		@PostMapping("memberIdCheck")
		@ResponseBody//결과물을 바로제이슨으로 보내주는것.
		public boolean memberIdCheck(String id)throws Exception{
			return memberService.memberIdCheck(id);
		}
		
		
		
//		//파일다운
//		@GetMapping("memberFileDown")
//		public ModelAndView memberFileDown(MemberFilesVO memberFilesVO)throws Exception{
//			ModelAndView mv= new ModelAndView();
//			
//			memberFilesVO=memberService.memberFilesSelect(memberFilesVO);
//		
//			if(memberFilesVO != null) {
//				mv.addObject("memberFiles", memberFilesVO);
//				mv.addObject("path", "upload");
//				mv.setViewName("fileDown");
//				
//			}else {
//				mv.addObject("msg", "이미지가없어용");
//				mv.addObject("path", "./memberPage");
//				mv.setViewName("common/result");
//			}
//			
//			return mv;
//		}
//		
		
		
		//업데이트
		@GetMapping("memberUpdate")
		public ModelAndView memberUpdate(MemberVO memberVO,HttpSession session, ModelAndView mv)throws Exception {
			 
			memberVO = (MemberVO)session.getAttribute("member");
			 mv.addObject("memberVO", memberVO);
			 mv.setViewName("member/memberUpdate");
			 return mv;
		}
		
		@PostMapping("memberUpdate")
		public ModelAndView memberUpdate(MemberVO memberVO, MultipartFile files, HttpSession session)throws Exception{
			
			MemberVO loginVO = (MemberVO)session.getAttribute("member");
			
			System.out.println(memberVO.getMemberFilesVO());
			
			memberVO.setMemberFilesVO(loginVO.getMemberFilesVO());
			
			memberVO = memberService.memberUpdate(memberVO, files);
			
			session.setAttribute("member", memberVO);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("msg", "Update Success");
			mv.addObject("path", "memberPage");
			
			mv.setViewName("common/result");
			
			return mv;
			
		}
		
		//memberVO를 가져옴.
		@ModelAttribute
		public MemberVO getMemberVO( )throws Exception {
			
			
			return new MemberVO();
		}
	
		
		
		//회원가입
		@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
		public String memberJoin()throws Exception {
		
			//MemberVO memberVO = new MemberVO();
			//model.addAttribute("memberVO", new MemberVO());
			
			return "member/memberJoin";
		}
		
		
	
		@PostMapping("memberJoin")										//files인이유 넘어가는 파라미터name과같게..
		public ModelAndView memberJoin(@Valid MemberVO memberVO,BindingResult bindingResult, MultipartFile files )throws Exception {
			
			ModelAndView mv= new ModelAndView();
		
			if(memberService.memberJoinValidate(memberVO, bindingResult)) {
			
				mv.setViewName("member/memberJoin");
				
			}else {
				
			memberVO= memberService.memberJoin(memberVO, files);
			
			String msg="join실패";
			String path="../";//루트밑
			if(memberVO != null) {
				msg="Join Success";
			}
			mv.addObject("path", path);
			mv.addObject("msg", msg);
			mv.setViewName("common/result");
			}
			
			
			return mv;
			}
			
			
		
		
		//로그인
		@GetMapping("memberLogin")
		public void memberLogin()throws Exception {
			
		}
		
		@PostMapping("memberLogin")
		public ModelAndView memberLogin(MemberVO memberVO,HttpSession session)throws Exception {
			ModelAndView mv = new ModelAndView();
			
			memberVO= memberService.memberLogin(memberVO);
			
			String msg = "로그인 실패";
			
			
			if(memberVO != null){
				msg= "로그인 성공";
				session.setAttribute("member", memberVO);
				
			}
			
			mv.addObject("msg", msg);
			mv.addObject("path", "../");
			mv.setViewName("common/result");
			
			return mv;
		}
		
		//마이페이지
		@GetMapping("memberPage")
		public void memberPage( )throws Exception {
		
			
		}
			
		
		//로그아웃
		@GetMapping("memberLogout")
		public ModelAndView memberLogOut(MemberVO memberVO, ModelAndView mv, HttpSession session) throws Exception{
			session.invalidate();
			mv.addObject("msg", "로그아웃 되었습니다.");
			mv.addObject("path", "../");
			mv.setViewName("common/result");
			return mv;
		}
		
		
}
