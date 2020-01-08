package com.cyh.b1.board;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@MappedSuperclass
public class BoardVO {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private int hit;
	
		
		
}
