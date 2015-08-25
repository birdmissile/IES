package com.sssystem.edu.qna;

import java.util.ArrayList;
import java.util.List;

public interface QnaService {

	public boolean qnaBoardInsert(QnaBoardVO bean);//게시글 등록
	public boolean atchBoardinsert(AtchFileVO bean);//첨부파일 등록
	public boolean qnaBoardDelete(int qna_no);//게시글 삭제
	public boolean qnaBoardUpdate(QnaBoardVO bean);//게시글 업데이트
	public QnaBoardVO qnaBoardView(int qna_no,int board_gb);//게시글 보기
	public List<QnaBoardVO> qnaBoardListSelectAll(SearchVO bean, int page);//게시글 목록
	public void hitsUpdate(int qna_no);//조회수
	public int cntSelect(SearchVO bean);//검색관련
	public void answerUpdate(QnaBoardVO bean);//답변 등록
	public CheckAuthVO authorityCheck(int qna_no);//권한 체크
	public String answerNmSelect(int user_no);//답변자 이름 검색
	
}
