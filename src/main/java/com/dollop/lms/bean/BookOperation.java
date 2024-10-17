package com.dollop.lms.bean;


public class BookOperation{
	private String bookId=null;
	private String bookName=null;
	private String userName=null;
	private int bookPages=0;
	private int bookQuantity=0;
	private String createDate=null;
	public BookOperation() {
		super();
	}
	public BookOperation(String bookId,String userName, String bookName, int bookQuantity,String createDate) {
		super();
		this.bookId = bookId;
		this.userName = userName;
		this.bookName = bookName;
		this.bookQuantity = bookQuantity;
		this.createDate = createDate;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
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



/*
 * public class BookOperation {
 * 
 * private String issuBookId; private String issuBookName; private String
 * author; private String userName; private String issueDate; private String
 * returnDate; int period; int fine; public BookOperation() { super(); } public
 * BookOperation(String issuBookId, String issuBookName, String author, String
 * userName, String issueDate,String returnDate, int period, int fine) {
 * super(); this.issuBookId = issuBookId; this.issuBookName = issuBookName;
 * this.author = author; this.userName = userName; this.issueDate = issueDate;
 * this.returnDate = returnDate; this.period = period; this.fine = fine; }
 * public String getIssuBookId() { return issuBookId; } public void
 * setIssuBookId(String issuBookId) { this.issuBookId = issuBookId; } public
 * String getIssuBookName() { return issuBookName; } public void
 * setIssuBookName(String issuBookName) { this.issuBookName = issuBookName; }
 * public String getAuthor() { return author; } public void setAuthor(String
 * author) { this.author = author; } public String getUserName() { return
 * userName; } public void setUserName(String userName) { this.userName =
 * userName; } public String getIssueDate() { return issueDate; } public void
 * setIssueDate(String issueDate) { this.issueDate = issueDate; } public String
 * getReturnDate() { return returnDate; } public void setReturnDate(String
 * returnDate) { this.returnDate = returnDate; } public int getPeriod() { return
 * period; } public void setPeriod(int period) { this.period = period; } public
 * int getFine() { return fine; } public void setFine(int fine) { this.fine =
 * fine; }
 * 
 * @Override public String toString() { return "BookOperation [issuBookId=" +
 * issuBookId + ", issuBookName=" + issuBookName + ", author=" + author +
 * ", userName=" + userName + ", issueDate=" + issueDate + ", returnDate=" +
 * returnDate + ", period=" + period + ", fine=" + fine + "]"; }
 * 
 * 
 * }
 */