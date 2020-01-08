package com.cyh.b1.member;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	
	
//	@Autowired
//	private MemberFilesRepository memberFilesRepository;
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception {
	 
		return memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
		
	}
	
	public Optional<MemberVO> memberPage(MemberVO memberVO)throws Exception{
		return memberRepository.findById(memberVO.getId());
		
	}
	
	
	public MemberVO memberJoin(MemberVO memberVO)throws Exception{
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setMemberVO(memberVO);
		memberVO.setMemberFilesVO(memberFilesVO);
		return memberRepository.save(memberVO);
	}
	
	public boolean memberJoinValidate(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		return bindingResult.hasErrors();
	}
	

}
