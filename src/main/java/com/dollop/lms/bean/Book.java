package com.dollop.lms.bean;

public class Book{
	private String bookId=null;
	private String bookName=null;
	private String authorName=null;
	private int bookPages=0;
	private String bookSubject=null;
	private int bookQuantity=0;
	private String createDate=null;
	public Book() {
		super();
	}
	public Book(String bookId, String bookName, String authorName, int bookPages
			, int bookQuantity,String createDate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookPages = bookPages;
		this.bookQuantity = bookQuantity;
		this.createDate = createDate;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getBookPages() {
		return bookPages;
	}
	public void setBookPages(int bookPages) {
		this.bookPages = bookPages;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
