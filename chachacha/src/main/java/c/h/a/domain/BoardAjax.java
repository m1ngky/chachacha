package c.h.a.domain;

import java.util.List;

public class BoardAjax {
	private int page;
	private int maxpage;
	private int startpage;
	private int endpage;
	private int listcount;
	private int limit;
	private List<Board> boardlist;
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getMaxpage() {
		return maxpage;
	}
	
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	
	public int getStartpage() {
		return startpage;
	}
	
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	
	public int getEndpage() {
		return endpage;
	}
	
	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public int getListcount() {
		return listcount;
	}

	public void setListcount(int listcount) {
		this.listcount = listcount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<Board> getBoardlist() {
		return boardlist;
	}

	public void setBoardlist(List<Board> boardlist) {
		this.boardlist = boardlist;
	}
}