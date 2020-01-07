package com.cyh.b1.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	private String pw;
	@Transient
	private String pw2;
	private String name;
	
	private String email;
	

}
