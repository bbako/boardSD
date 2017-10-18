package org.board.domain;

public class Criteria {
	
	private int page;
	
	public Criteria() {
		
		this.page=1;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		
		if(page<=0) {
			this.page=1;
			return;
			
		}
		this.page = page;
	}
	
	public int getPageStart() {
		
		return (this.page-1)*10;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + "]";
	}

}
