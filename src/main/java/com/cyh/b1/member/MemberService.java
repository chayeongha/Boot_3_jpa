package com.cyh.b1.member;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception {
	 
		return memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
		
	}
	
	public Optional<MemberVO> memberMypage(MemberVO memberVO)throws Exception{
		return memberRepository.findById(memberVO.getId());
	}
	
	public MemberFilesVO memberMyPage(MemberFilesVO memberFilesVO)throws Exception{
		return memberFilesRepository.findByFname(memberFilesVO.getFname());
	}
	

}
