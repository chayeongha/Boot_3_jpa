package com.cyh.b1.member;

import java.lang.reflect.Member;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberFilesRepository extends JpaRepository<MemberFilesVO, Integer>{

		Member findbyName(String id);
}
