package com.cyh.b1.qna;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name="qnaFiles")
public class QnaFilesVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fnum;
	
	private String fname;
	private String oname;
	
	@ManyToOne
	@JoinColumn(name = "num")
	private QnaVO qnaVO;
	
	
}
