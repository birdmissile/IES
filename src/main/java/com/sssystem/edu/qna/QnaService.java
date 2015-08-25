package com.sssystem.edu.qna;

import java.util.ArrayList;
import java.util.List;

public interface QnaService {

	public boolean qnaBoardInsert(QnaBoardVO bean);//�Խñ� ���
	public boolean atchBoardinsert(AtchFileVO bean);//÷������ ���
	public boolean qnaBoardDelete(int qna_no);//�Խñ� ����
	public boolean qnaBoardUpdate(QnaBoardVO bean);//�Խñ� ������Ʈ
	public QnaBoardVO qnaBoardView(int qna_no,int board_gb);//�Խñ� ����
	public List<QnaBoardVO> qnaBoardListSelectAll(SearchVO bean, int page);//�Խñ� ���
	public void hitsUpdate(int qna_no);//��ȸ��
	public int cntSelect(SearchVO bean);//�˻�����
	public void answerUpdate(QnaBoardVO bean);//�亯 ���
	public CheckAuthVO authorityCheck(int qna_no);//���� üũ
	public String answerNmSelect(int user_no);//�亯�� �̸� �˻�
	
}
