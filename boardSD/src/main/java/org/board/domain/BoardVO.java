package org.board.domain;

import java.util.Date;

public class BoardVO {
	
	int seq_id ;
	String board_title ,	board_content ,	board_writer ;
	Date board_datetime;
	int board_viewcounter;
	
	public int getSeq_id() {
		return seq_id;
	}
	public void setSeq_id(int seq_id) {
		this.seq_id = seq_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public Date getBoard_datetime() {
		return board_datetime;
	}
	public void setBoard_datetime(Date board_datetime) {
		this.board_datetime = board_datetime;
	}
	public int getBoard_viewcounter() {
		return board_viewcounter;
	}
	public void setBoard_viewcounter(int board_viewcounter) {
		this.board_viewcounter = board_viewcounter;
	}
	@Override
	public String toString() {
		return "BoardVO [seq_id=" + seq_id + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_writer=" + board_writer + ", board_datetime=" + board_datetime + ", board_viewcounter="
				+ board_viewcounter + "]";
	}
	


}
