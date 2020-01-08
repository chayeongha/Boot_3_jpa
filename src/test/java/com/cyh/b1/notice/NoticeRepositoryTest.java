package com.cyh.b1.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class NoticeRepositoryTest {

		@Autowired
		private NoticeRepository noticeRepository;
		
		@Test
		void test2() {
			
			NoticeVO noticeVO = noticeRepository.findById(21).get();
			System.out.println(noticeVO.getWriter());
			
		}
		
		
		//@Test
//		void test() {
//			NoticeVO noticeVO = noticeRepository.findById(6).get();
//			System.out.println(noticeVO.getWriter());
//			for(NoticeFilesVO noticeFilesVO: noticeVO.getNoticeFilesVOs()) {
//				System.out.println(noticeFilesVO.getFname());
//			}
//		}

}
