package com.cyh.b1.member;

import java.io.File;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.cyh.b1.member.util.FilePathGenerator;
import com.cyh.b1.member.util.FileSaver;






@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	
	
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	

		public void memberDelete(MemberVO memberVO) throws Exception{
			memberRepository.deleteById(memberVO.getId());
		}
	
	
	public MemberVO memberUpdate(MemberVO memberVO, MultipartFile files)throws Exception{
		
		if(files.getSize()>0) {
			File file = filePathGenerator.getUseClassPathResource("upload");
			String fileName = fileSaver.save(file, files);
			MemberFilesVO memberFilesVO = memberVO.getMemberFilesVO();
		
			memberFilesVO.setFname(fileName);
			memberFilesVO.setOname(files.getOriginalFilename());
			
			memberVO.setMemberFilesVO(memberFilesVO);
			memberFilesVO.setMemberVO(memberVO);
		}
		
		return memberRepository.save(memberVO);
		
	}
	
	
	
	public boolean memberIdCheck(String id)throws Exception{
		return memberRepository.existsById(id);
	}
	
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception {
	 
		return memberRepository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
		
	}
	
	public Optional<MemberVO> memberPage(MemberVO memberVO)throws Exception{
		return memberRepository.findById(memberVO.getId());
		
	}
	
	
	public MemberVO memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
		File file =filePathGenerator.getUseClassPathResource("upload");
		String fileName=fileSaver.save(file, files);
		
		MemberFilesVO memberFilesVO= new MemberFilesVO();
		memberFilesVO.setFname(fileName);
		memberFilesVO.setOname(files.getOriginalFilename());
		
		memberFilesVO.setMemberVO(memberVO);
		memberVO.setMemberFilesVO(memberFilesVO);
		return memberRepository.save(memberVO);
	}
	
	

	
	public boolean memberJoinValidate(MemberVO memberVO, BindingResult bindingResult)throws Exception{
		boolean check=false;//true -> error, false-> ok
		
		//annotation  검증 결과
		if(bindingResult.hasErrors()) {
			check=true;
		}
		
		//pw가 일치 하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			check=true;
			bindingResult.rejectValue("pw2", "Not Equal PW", "Not Equal PW");
									 //form의 path명, properties의 키 	
		}
		
		
		Boolean ch = memberRepository.existsById(memberVO.getId());
		
		if(ch) {
			check = true;
			bindingResult.rejectValue("id", "Duplicate Id", "Duplicate Id");
		}
		
		return check;
	}

}
