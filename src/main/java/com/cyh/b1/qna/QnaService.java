package com.cyh.b1.qna;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyh.b1.member.util.FilePathGenerator;
import com.cyh.b1.member.util.FileSaver;

@Service
@Transactional
public class QnaService {

		@Autowired
		private QnaRepository qnaRepository;
		
		@Autowired
		private QnaFilesRepository qnaFilesRepository;
		
		@Autowired
		private FilePathGenerator filePathGenerator;
		
		@Autowired
		private FileSaver fileSaver;
		
		
		public void qnaUpdate()throws Exception{
			qnaRepository.qnaUpdate("re3", "re3", 2);
		}
}
