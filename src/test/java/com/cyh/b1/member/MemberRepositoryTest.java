package com.cyh.b1.member;

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
	
	@Test
	void test() throws Exception{
		
//		MemberVO memberVO = new MemberVO();
//		
//		memberVO.setId("te1");
//		memberVO.setPw("te1");
//		memberVO.setName("te1");
//	
//		MemberVO ar = memberRepository.findByIdAndPw("test", "test");
//		System.out.println(ar.getName());
		

		
		
		//페이징처리할떄 따로 메서드안만들고 여기서 처리해도되겟지?
		//long count = memberRepository.count();
		//System.out.println(count);
		
		//아이디 중복할때 따로메서드안만들고 이걸로 처리해도된다.
		//boolean check =memberRepository.existsById("test");
		//System.out.println(check);
		
		//List<MemberVO>ar=memberRepository.findAll();
		
		//for (MemberVO memberVO : ar) {
		//System.out.println(memberVO.getId());
		//}
		
//		Optional<MemberVO>opt =memberRepository.findById("test98");
//		
//		if(opt.isPresent()) {
//		MemberVO memberVO =opt.get();
//		
//		System.out.println(memberVO.getEmail());
//		
//		}else {
//			
//			System.out.println("no data");
//		}
		
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId("test199");
//		memberVO.setPw("test199");
//		memberVO.setName("test199");
//		
//		memberRepository.save(memberVO);
		
		
	}

}
