package com.dollop.lms.service;

import java.sql.SQLException;
import java.util.List;

import com.dollop.lms.bean.Admin;
import com.dollop.lms.bean.Book;
import com.dollop.lms.bean.BookOperation;
import com.dollop.lms.bean.Librarian;
import com.dollop.lms.bean.Student;

public interface IAdminService {
        public Integer saveAdmins(List<Admin> admins);
        public Admin login(String userName,String password);
        public Boolean isAdminExist();

        public Boolean changeAdminStatus(String uuid);
		public boolean isAdminAvailable();
		
		public Integer saveLibrarians(List<Librarian> librarians);
	    public Boolean isLibrarianAvailable(String name);
	    public void removeLibrarian(String LName,String LPassword) ;
	    public Librarian showLibrarian();
	    public void showOneLibrarian(String uName);
	    public void updateLibrarian(String uName);
	    public Boolean changeLibrarianStatus();
	 	    
		  public Integer saveStudents(List<Student> student);
		  public void removeStd(String sName);
		  public void updateStudent();
		  public void showOneStudent(String uName);
		  public void showAllStudent();
		  public Boolean isStudentAvailable(String sName);
	
		  public Integer insertBooks(List<Book> books);
	       public Boolean isBookExist(String bookName);
	       public  void updateBook();
	       public void removeBook(String bookName);
	       public void showOneBook(String bName);
	       public void showAllBook();
	       public Boolean isBookIssue(String bName);

	       public boolean AlreadyIssued(String bookName,String uName);
	       public void showAllIssueBooks();
	       public void increaseBookQuantity(String name);
	       public void decreaseBookQuantity(String bName);
		public Integer insertIssueBooks(List<BookOperation> book);
		public Integer quantityCheck(String bName);
		public void showOneIssueBooks(String bName);
}
