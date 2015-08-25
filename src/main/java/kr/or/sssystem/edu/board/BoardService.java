package kr.or.sssystem.edu.board;

import java.util.ArrayList;
import java.util.List;


public interface BoardService  {
	
	/**
	 * ��������, �ڷ��, �Խ���
	 * @param bean
	 * @return
	 */
	public boolean boardInsert(BoardVO bean); // ���
	public boolean atchBoardInsert(AtchFileVO atchBean); //÷������
	public boolean boardDelete(int board_no); //����
	public boolean boardUpdate(BoardVO bean); //����
	public BoardVO boardDetailSelect(int no,int gb); //�˻�(Ư����)
	public List<BoardVO> boardListSelectAll(SearchVO bean, int page); //�˻�(��ü��)
	public void upHits(int board_no); //��ȸ��
	public int selectCnt(SearchVO bean); //
	
	/**
	 * ����
	 * @param board_no
	 * @return
	 */
	public List<ReplyVO> replyList(int board_no); //��ȸ
	public boolean replyUpdate(ReplyVO reply); //������Ʈ
	public boolean replyDelete(int comment_no); //����
	public boolean replyInsert(ReplyVO reply); //���
	
	public int selectMaxNo(); //�ִ밹��
	public ReplyVO replySelect(int comment_no);//�������� ������
	public CheckAuthVO checkManage(int user_no);//����üũ
	public ArrayList<String> notice();
	public String selectReply(int user_no);
	public ArrayList<String> replyContents(int user_no);
	

	}
