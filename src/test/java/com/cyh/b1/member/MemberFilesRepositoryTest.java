package com.cyh.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@SpringBootTest
class MemberFilesRepositoryTest {

	@Autowired
	private MemberFilesRepository memberFilesRepository;



	@Test
	void test() throws Exception {

		List<MemberFilesVO> ar= memberFilesRepository.findById("cyh2");

		for (MemberFilesVO memberFilesVO : ar) {
			System.out.println(memberFilesVO.getId());
			System.out.println(memberFilesVO.getFname());
		}

		
		
		//findall
		//		List<MemberFilesVO>ar =memberFilesRepository.findAll();
		//		
		//		for (MemberFilesVO memberFilesVO : ar) {
		//			
		//			System.out.println(memberFilesVO.getFname());
		//		}


		//	Optional<MemberFilesVO> opt =	memberFilesRepository.findById(1);
		//	Optional<MemberFilesVO> opt2 = memberFilesRepository.findById(1);
		//		MemberFilesVO memberFilesVO = opt.get();
		//		MemberFilesVO memberFilesVO2 = opt2.get();
		//		System.out.println(memberFilesVO == memberFilesVO2);

		//		MemberFilesVO memberFilesVO = new MemberFilesVO();
		//		memberFilesVO.setId("t3");
		//		memberFilesVO.setFname("t3333@@@@jpg");
		//		memberFilesVO.setOname("t3jpg");
		//		
		//		memberFilesRepository.save(memberFilesVO);

		//select * from memberFiles where id=?






		//		Optional<MemberFilesVO> opt = memberFilesRepository.findById(1);
		//		if(opt.isPresent()) {
		//			MemberFilesVO memberFilesVO = opt.get();
		//			
		//			System.out.println(memberFilesVO.getOname());
		//			
		//		}else {
		//			
		//			System.out.println("no data");
		//		}

	}

}
