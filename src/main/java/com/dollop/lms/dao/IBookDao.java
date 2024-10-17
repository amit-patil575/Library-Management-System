package com.dollop.lms.dao;

import java.sql.SQLException;
import java.util.List;

import com.dollop.lms.bean.Book;
import com.dollop.lms.bean.BookOperation;

public interface IBookDao {
	   public Boolean isBookAvailable(String name);
	   public void increaseBookQuantity(String name);
	   public void decreaseBookQuantity(String bName) throws SQLException;
	  public Integer quantityCheck(String bName) throws SQLException;
	  public Boolean isBookIssue(String bName);
	  public boolean AlreadyIssued(String bookName,String uName);
	   
       public Integer insertBooks(List<Book> books);
       public Integer insertIssueBooks(List<BookOperation> books);
       
       public void showAllIssueBooks() throws SQLException;
       public Boolean showOneBook(String bName) throws SQLException;
       public Boolean showAllBook() throws SQLException;
     
       public void updateBook() throws SQLException;
        public void updateBookName(String bName) throws SQLException;
	 public void updateBookAuthorName(String bName) throws SQLException;
	 public void updateBookPages(String bName) throws SQLException;
	public void updateBookquantity(String bName) throws SQLException;
	 public void deleteBook(String stdName);
	public void showOneIssueBooks(String bName);

       
}
