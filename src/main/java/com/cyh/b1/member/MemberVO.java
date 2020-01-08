package com.cyh.b1.member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "members")
public class MemberVO {
	
	@Id//프라이머리키로 쓰겠다.
	@NotEmpty
	private String id;
	//변수명이틀릴떈 이렇게 변수명을 따로 설정이가능 .@Column(name = "password")
	//@Column(name="password")
	//인서트는 되지만 수정을 못하게 하는것.
	//@Column(updatable = false)
	private String pw;
	
	//맵핑하지말자. 이게없으면 에러.
	@Transient
	private String pw2;
	
	private String name;
	
	private String email;
	
	
	//@OneToOne(mappedBy = "join하는 entity(vo)에 선언된 자기자신의 entity(vo)변수명" )
	@OneToOne(mappedBy = "memberVO" , cascade = CascadeType.ALL)
	private MemberFilesVO memberFilesVO;
}
