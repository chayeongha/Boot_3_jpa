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
	void test() {
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
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test101");
		memberVO.setPw("test101");
		memberVO.setName("rename");
		
		memberRepository.save(memberVO);
		
		
	}

}
