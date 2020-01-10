package com.cyh.b1.qna;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cyh.b1.board.BoardVO;

import lombok.Data;

@Entity
@Data
@Table(name="qna")
public class QnaVO extends BoardVO{
	
	private int ref;
	private int step;
	private int depth;
	
	
	@OneToMany(mappedBy = "qnaVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<QnaFilesVO> qnaFilesVOs;
	

}
