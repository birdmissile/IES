package com.sssystem.edu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.BoardService;
import com.sssystem.edu.vo.AtttachFileVO;
import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.ReplyVO;
import com.sssystem.edu.vo.search.SearchBoardVO;
import com.sssystem.edu.vo.support.SessionVO;


public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession session;

	/**
	 * ��������, �����Խ���, �ڷ�� ���
	 * @param bean
	 * @return
	 */
	@Override
	public boolean boardInsert(BoardVO bean) {
		int t = session.insert("notice.boardInsert", bean);
		if(t==1) {
			return true;
		}
		return false;
	}
	
	/**
	 * ��������, �����Խ���, �ڷ�� ÷������ ���
	 * @param bean
	 * @return
	 */
	@Override
	public boolean atchBoardInsert(AtttachFileVO atchBean) {
		int t = session.insert("notice.atchBoardInsert",atchBean);
		return false;
	}

	/**
	 * ��������, �����Խ���, �ڷ�� ����
	 * @param no
	 * @return
	 */
	@Override
	public boolean boardDelete(int board_no) {
		int t = session.delete("notice.boardDelete", board_no);
		return false;
	}
	
	/**
	 * ��������, �����Խ���, �ڷ�� ����
	 * @param bean
	 * @return
	 */
	@Override
	public boolean boardUpdate(BoardVO bean) {
		int t = session.update("notice.boardUpdate", bean);
		if(t==1) {
			return true;
		}
		return false;
	}

	/**
	 * ��������, �����Խ���, �ڷ�� �˻�(Ư����)
	 * @param no
	 * @return
	 */
	@Override
	public BoardVO boardDetailSelect(int no, int gb) {
		BoardVO board = null;
		HashMap<String, Object> map = new HashMap<String, Object>(); 
		map.put("board_gb", gb);
		map.put("board_no", no);		
		
		return board;
	}

	/**
	 * ��������, �����Խ���, �ڷ�� �˻�(��ü��)
	 * @return
	 */
	@Override
	public List<BoardVO> boardListSelectAll(SearchBoardVO bean, int page) {
		List <BoardVO> list = session.selectList("notice.boardListSelectAll", bean,new RowBounds(page*10-10,10));
		return list;
	}
	
	/**
	 * ��������, �����Խ���, �ڷ�� ��ȸ��
	 */
	@Override
	public void upHits(int board_no) {
		session.update("notice.uphits", board_no);
		
	}
	
	@Override
	public int selectCnt(SearchBoardVO bean) {
		int cnt = session.selectOne("qna.cntSelect",bean);
		return cnt;
	}
	
	/**
	 * ��������, �����Խ���, �ڷ�� ������ȸ
	 */
	@Override
	public List<ReplyVO> replyList(int board_no) {
		List<ReplyVO> list = session.selectList("notice.replyList",board_no);
		return list;
	}
	
	/**
	 * ���þ�������
	 */
	@Override
	public boolean replyUpdate(ReplyVO reply) {
		int t = session.update("notice.replyUpdate",reply);
		if(t==1) {
			return true;
		}
		return false;
	}
	
	/**
	 * ���� ����
	 */
	@Override
	public boolean replyDelete(int comment_no) {
		int t = session.delete("notice.replyDelete",comment_no);
		if(t==1){
			return true;		
		}
		return false;
	}
	
	/**
	 * �����߰�
	 */
	@Override
	public boolean replyInsert(ReplyVO reply) {
		session.insert("notice.replyInsert",reply);
			return true;
	}

	/**
	 * 
	 */
	@Override
	public int selectMaxNo() {
		int no = 0;
		//no = (Integer)session.queryForObject("notice.replyMaxNo");
		return no;
	}

	@Override
	public SessionVO checkManage(int user_no) {
	
		return null;
	}
	public ReplyVO replySelect(int comment_no) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> notice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectReply(int user_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> replyContents(int user_no) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
