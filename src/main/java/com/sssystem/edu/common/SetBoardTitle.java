package com.sssystem.edu.common;

public class SetBoardTitle {
	
	public static String getBoardTitle(String boardGb) {
		String pageTitle = "";
		if("10".equals(boardGb)) {
			pageTitle = "��������";
			
		} else if ("20".equals(boardGb)) {
			pageTitle = "�ڷ��";
			
		} else if ("30".equals(boardGb)) {
			pageTitle = "�����Խ���";
			
		} else if ("40".equals(boardGb)) {
			pageTitle = "�������亯";
			
		} else if ("50".equals(boardGb)) {
			pageTitle = "FAQ";
			
		} else if ("60".equals(boardGb)) {
			pageTitle = "���ǻ���";
		}
		
		return pageTitle;
	}
}
