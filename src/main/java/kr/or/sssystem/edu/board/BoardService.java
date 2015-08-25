package kr.or.sssystem.edu.board;

import java.util.ArrayList;
import java.util.List;


public interface BoardService  {
	
	/**
	 * 공지사항, 자료실, 게시판
	 * @param bean
	 * @return
	 */
	public boolean boardInsert(BoardVO bean); // 등록
	public boolean atchBoardInsert(AtchFileVO atchBean); //첨부파일
	public boolean boardDelete(int board_no); //삭제
	public boolean boardUpdate(BoardVO bean); //수정
	public BoardVO boardDetailSelect(int no,int gb); //검색(특정행)
	public List<BoardVO> boardListSelectAll(SearchVO bean, int page); //검색(전체행)
	public void upHits(int board_no); //조회수
	public int selectCnt(SearchVO bean); //
	
	/**
	 * 리플
	 * @param board_no
	 * @return
	 */
	public List<ReplyVO> replyList(int board_no); //조회
	public boolean replyUpdate(ReplyVO reply); //업데이트
	public boolean replyDelete(int comment_no); //삭제
	public boolean replyInsert(ReplyVO reply); //등록
	
	public int selectMaxNo(); //최대갯수
	public ReplyVO replySelect(int comment_no);//리플정보 가져옴
	public CheckAuthVO checkManage(int user_no);//권한체크
	public ArrayList<String> notice();
	public String selectReply(int user_no);
	public ArrayList<String> replyContents(int user_no);
	

	}
