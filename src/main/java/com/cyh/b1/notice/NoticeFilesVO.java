package com.cyh.b1.notice;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "noticeFiles")
public class NoticeFilesVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fnum;
	
	private String fname;
	private String oname;
	
	@ManyToOne
	@JoinColumn(name = "num")
	private NoticeVO noticeVO;
	
}