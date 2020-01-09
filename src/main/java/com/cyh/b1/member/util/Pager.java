package com.cyh.b1.member.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pager {
	
	private Integer curPage;
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;

	private Page<? extends Object>pageList;
	private Pageable pageable;
	
	public Pager() {
		this.curPage=0;
		this.perPage=10;
		
	}
	
	public void makeNum() {
		int perBlock=5;
		this.totalBlock = pageList.getTotalPages()/perBlock;
		
		if(pageList.getTotalPages()%perBlock !=0) {
			
			this.totalBlock++;
		}
		
		this.curBlock =(pageList.getNumber()+1)/perBlock;
		
		if(pageList.getNumber()+1)%perBlock !=0){
			this.curBlock++;
			
			
		}
		
		
	}
	
	//-------------------
		


}
