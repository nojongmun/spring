package com.ict.model;

public class Paging {
	// 페이지 기법 : 전체 정보에서 원하는 일부의 정보를 가져오는 기법
    // 해당 페이지의 시작번호, 끝번호 구하기 
	// 시작 블록, 끝 블록 구하기
	private int nowPage = 1 ;     // 현재 페이지
	private int nowBlock = 1 ;    // 현재 블록
	private int totalRecord = 0 ; // 총 게시물의 수 (원글의 수) => 총 페이지의 수를 구할 수 있다.
	private int numPerPage = 3 ;  // 한 페이지의 게시물의 수
	private int pagePerBlock = 5;  // 블록당 페이지의 수
	private int totalPage = 0 ;    // 전체 페이지의 수
	private int totalBlock = 0 ;   // 전체 블록의 수
	private int begin = 0 ;        // 시작 번호
	private int end = 0 ;          // 끝 번호
	private int beginBlock = 0 ;   // 시작 블록
	private int endBlock = 0 ;     // 끝 블록
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getNowBlock() {
		return nowBlock;
	}
	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getBeginBlock() {
		return beginBlock;
	}
	public void setBeginBlock(int beginBlock) {
		this.beginBlock = beginBlock;
	}
	public int getEndBlock() {
		return endBlock;
	}
	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}
	
	
}
