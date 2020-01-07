package com.cyh.b1.board;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
		@Id
		private int num;
		private String title;
		private String writer;
		private String contents;
		private Date regDate;
		private int hit;
		
		
}
