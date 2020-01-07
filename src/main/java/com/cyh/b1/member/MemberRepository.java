package com.cyh.b1.member;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
																											//프라이머키로되어잇는 변수의 타입을 적는다 뒤에
public interface MemberRepository extends JpaRepository<MemberVO, String>{

	
	public MemberVO findByIdAndPw(String id , String pw)throws Exception;
	
	public Optional<MemberVO> findById(String id);
}
