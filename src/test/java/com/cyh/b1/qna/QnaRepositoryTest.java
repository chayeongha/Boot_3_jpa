package com.cyh.b1.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

//@Transactional
@SpringBootTest
class QnaRepositoryTest {

	@Resource
	private QnaRepository qnaRepository;
	@Autowired
	private QnaService qnaService;
	
	@Test
	void columnTest()throws Exception {
	List<	Object[]> obj=qnaRepository.qnaSelect(1);
		
		for (Object [] o : obj) {
			for (Object o2 : o) {
				
				System.out.println(o2);
			}
		}
		
	}
	
	
	//@Test
	void updateTest()throws Exception{
		qnaService.qnaUpdate();
	}
	
	
	
	
	
	
	//@Test
	void selectOneTest ( )throws Exception{

		QnaVO qnaVO=qnaRepository.findQnaVO(1);
		
		//System.out.println(qnaVO.getTitle());
		//System.out.println(qnaVO.getQnaFilesVOs().get(0).getFname());
	}
	
	
	
	//@Test
	void selectTest()throws Exception{
//	Pageable pageable = PageRequest.of(0, 10, Sort.by("ref").descending().and(Sort.by("step").ascending()));	
//		
//	List<QnaVO>ar=qnaRepository.findByNumGreaterThan(0, pageable);
//	
//	for (QnaVO qnaVO : ar) {
//		System.out.println(qnaVO.getTitle());
//	}
	List< QnaVO> ar = qnaRepository.findQna();
	for (QnaVO qnaVO : ar) {
		
		System.out.println(qnaVO.getTitle());
		
		for (QnaFilesVO qnaFilesVO : qnaVO.getQnaFilesVOs()) {
			System.out.println(qnaFilesVO.getFname());
		}
	}
		
	}
	
	
	
	
	
	//@Test
	void test() {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("test");
		qnaVO.setWriter("test");
		qnaVO.setContents("test");
		
		List<QnaFilesVO>ar = new ArrayList<QnaFilesVO>();
		
		QnaFilesVO qnaFilesVO = new QnaFilesVO();
		qnaFilesVO.setFname("test11@@.jpg");
		qnaFilesVO.setOname("test11.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		
		ar.add(qnaFilesVO);
		
		qnaFilesVO = new QnaFilesVO();
		qnaFilesVO.setFname("test22@@.jpg");
		qnaFilesVO.setOname("test22.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		
		ar.add(qnaFilesVO);
		
		qnaVO	=	qnaRepository.save(qnaVO);
		
		qnaVO.setQnaFilesVOs(ar);
		qnaVO.setRef(qnaVO.getNum());
		
		qnaRepository.save(qnaVO);
		
		
		
		System.out.println(qnaVO.getNum());
		System.out.println(qnaVO.getTitle());
	}

}
