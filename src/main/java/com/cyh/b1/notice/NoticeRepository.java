package com.cyh.b1.notice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{

	
	//public 생략가능. 
		Page<NoticeVO> findByNumGreaterThan(int num, Pageable pageable) throws Exception;
		//=select * from notice order by where num >? num desc
		
		Page<NoticeVO>findByTitleContainingAndNumGreaterThan(String title, int num, Pageable pageable)throws Exception;
		
	}