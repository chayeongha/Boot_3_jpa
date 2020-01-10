package com.cyh.b1.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.cyh.b1.member.util.FilePathGenerator;
import com.cyh.b1.member.util.FileSaver;
import com.cyh.b1.member.util.Pager;

@Service
@Transactional
public class NoticeService {

	@Autowired//@resource써도됨.
	private NoticeRepository noticeRepository;
	@Autowired
	private NoticeFilesRepository noticeFilesRepository;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	
	//글쓰기
	public NoticeVO boardWrite(NoticeVO noticeVO, List<MultipartFile>files)throws Exception{
		
		List<NoticeFilesVO>noticeFilesVOs = null;
	
		boolean check= false; 
		
				
		if (files.size()>0) {
			for (MultipartFile multipartFile : files) {
			
				//리스트안에 제대로넣은 파일이 있는지 확인
				//파일에 빈파일이라면??
			if(	multipartFile.getSize() >0) {
				check= true;
				break;
				
				}
			
			}//for문 끝
			if(check) {
				noticeFilesVOs= new ArrayList<>();
				for (MultipartFile multipartFile : files) {
					
					if(multipartFile.getSize()>0) {
					NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
					File file = filePathGenerator.getUseClassPathResource("upload");
					String fileName = fileSaver.save(file,multipartFile);
					noticeFilesVO.setFname(fileName);
					noticeFilesVO.setOname(multipartFile.getOriginalFilename());
					noticeFilesVOs.add(noticeFilesVO);
					noticeFilesVO.setNoticeVO(noticeVO);
					}
				}
				
				noticeVO.setNoticeFilesVOs(noticeFilesVOs);
				
			}
			
		}
		//----파일의유무검증
		
		return noticeRepository.save(noticeVO);
		
		
	}
	
	//리스트
	
	
//방법 1	
//	public List<NoticeVO> boardList(Pageable pageable) throws Exception{
//		
//		Page<NoticeVO> p= noticeRepository.findByNumGreaterThan(0, pageable);
//	//		for (NoticeVO noticeVO : ar) {
//	//			noticeVO.getNoticeFilesVOs();
//	//			
//	//		}
//		System.out.println(p.isFirst());
//		System.out.println(p.isLast());
//		
//		
//		System.out.println(p.getTotalPages());
//		
//		return p.getContent();
//		
//	}
		
//방법2
	public Pager boardList(Pager pager)throws Exception{
		// PageRequest 생성
		//Sort.by("num").descending().and(Sort.by("").ascending()
		pager.makePageRequest(Sort.by("num").descending());
		
		Page<NoticeVO> p= noticeRepository.findByTitleContainingAndNumGreaterThan("t", 0, pager.getPageable());
		
		//Page<NoticeVO> p  = noticeRepository.findByNumGreaterThan(0, pager.getPageable());
		
		
		pager.setPageList(p);
		
		//페이징 처리 계산
		pager.makeNum();
		
		
		return pager;
	}
	
	
	
	
	
	
	//셀렉트
	public Optional<NoticeVO> boardSelect(int num)throws Exception{
		
		return noticeRepository.findById(num);
	}
	//public NoticeVO boardSelect(int num)throws Exception{
	//return noticeRepository.findById(num).get();}으로도 가능합니다.
	
	
	
//	@Transactional
//	public Optional<NoticeVO> noticeSelect(int num) throws Exception{
//		return noticeRepository.findById(num);
//	}
//	
}
