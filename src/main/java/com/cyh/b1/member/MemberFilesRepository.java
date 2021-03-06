package com.cyh.b1.member;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFilesRepository extends JpaRepository<MemberFilesVO, Integer>{
	
	public List<MemberFilesVO> findById(String id)throws Exception;
	
	public MemberFilesVO findByFname(String fname)throws Exception;
}	

