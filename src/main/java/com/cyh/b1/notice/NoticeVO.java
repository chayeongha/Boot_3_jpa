package com.cyh.b1.notice;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.cyh.b1.board.BoardVO;

import lombok.Data;

@Data //setter, getter, equals, hashcode
@Entity
@Table(name="notice")
public class NoticeVO extends BoardVO {
	
	@OneToMany(mappedBy = "noticeVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NoticeFilesVO> noticeFilesVOs;

	

	
}
