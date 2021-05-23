package process;

import dao.NoticeDao;

public class Paging {
	private int rowSize;
	private int pg;
	private int start;
	private int end;
	private int total;
	private int totalPage;
	private int block;
	private int startPage;
	private int endPage;
	
	public int getRowSize() {
		return rowSize;
	}
	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}
	public int getPg() {
		return pg;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	/* 전체 리스트 */
	public void makePaging(String strPg) {
		
		NoticeDao nDao = NoticeDao.getInstance();
		
		setRowSize(5); // 한 화면에 보여줄 게시글 행 수 셋팅값 변경가능
		setPg(1); // 현재 페이지
		if(strPg != null) {  // pg값이 들어 갈때
			setPg(Integer.parseInt(strPg));
		}
		setStart((getPg() * getRowSize()) - (getRowSize() - 1)); // list 시작
		setEnd((getPg() * getRowSize())); // list 끝

		setTotal(nDao.getTotal()); // 전체 게시글 수
		setTotalPage((int) Math.ceil(getTotal()/(double)getRowSize())); // 총 페이지
		setBlock(5); // 한 화면에 보여줄 page 범위 셋팅값 변경 가능

		setStartPage(((getPg() - 1)/getBlock() * getBlock()) + 1); // 시작 페이지
		setEndPage(getStartPage() + getBlock() - 1); // 끝 페이지
		
		if(getTotalPage() < getEndPage()) { // 끝 page가 총 page보다 클 때
			setEndPage(getTotalPage());
		}
		
	}
	
	/* 검색 시 */
	public void makePaging(String strPg, String search) {
		
		NoticeDao nDao = NoticeDao.getInstance();
		
		
		setRowSize(5); // 한 화면에 보여줄 게시글 행 수 셋팅값 변경가능
		setPg(1); // 현재 페이지
		if(strPg != null) {  // pg값이 들어 갈때
			setPg(Integer.parseInt(strPg));
		}
		setStart((getPg() * getRowSize()) - (getRowSize() - 1)); // list 시작
		setEnd((getPg() * getRowSize())); // list 끝

		setTotal(nDao.getSearchCount(search)); // 전체 게시글 수
		setTotalPage((int) Math.ceil(getTotal()/(double)getRowSize())); // 총 페이지
		setBlock(5); // 한 화면에 보여줄 page 범위 셋팅값 변경 가능

		setStartPage(((getPg() - 1)/getBlock() * getBlock()) + 1); // 시작 페이지
		setEndPage(getStartPage() + getBlock() - 1); // 끝 페이지
	
		if(getTotalPage() < getEndPage()) { // 끝 page가 총 page보다 클 때
			setEndPage(getTotalPage());
		}
		
	}
}
