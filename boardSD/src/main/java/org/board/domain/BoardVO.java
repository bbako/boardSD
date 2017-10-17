package org.board.domain;

import java.util.Date;

public class BoardVO {
	
	int seq_id ;
	String BOARD_TITLE ,	BOARD_CONTENT ,	BOARD_WRITER ;
	Date BOARD_DATETIME;
	int BOARD_VIEWCOUNTER;
	
	
	public int getSeq_id() {
		return seq_id;
	}
	public void setSeq_id(int seq_id) {
		this.seq_id = seq_id;
	}
	public String getBOARD_TITLE() {
		return BOARD_TITLE;
	}
	public void setBOARD_TITLE(String bOARD_TITLE) {
		BOARD_TITLE = bOARD_TITLE;
	}
	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}
	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}
	public String getBOARD_WRITER() {
		return BOARD_WRITER;
	}
	public void setBOARD_WRITER(String bOARD_WRITER) {
		BOARD_WRITER = bOARD_WRITER;
	}
	public Date getBOARD_DATETIME() {
		return BOARD_DATETIME;
	}
	public void setBOARD_DATETIME(Date bOARD_DATETIME) {
		BOARD_DATETIME = bOARD_DATETIME;
	}
	public int getBOARD_VIEWCOUNTER() {
		return BOARD_VIEWCOUNTER;
	}
	public void setBOARD_VIEWCOUNTER(int bOARD_VIEWCOUNTER) {
		BOARD_VIEWCOUNTER = bOARD_VIEWCOUNTER;
	}
	
	@Override
	public String toString() {
		return "BoardVO [seq_id=" + seq_id + ", BOARD_TITLE=" + BOARD_TITLE + ", BOARD_CONTENT=" + BOARD_CONTENT
				+ ", BOARD_WRITER=" + BOARD_WRITER + ", BOARD_DATETIME=" + BOARD_DATETIME + ", BOARD_VIEWCOUNTER="
				+ BOARD_VIEWCOUNTER + "]";
	}
	
	
	
	

}
