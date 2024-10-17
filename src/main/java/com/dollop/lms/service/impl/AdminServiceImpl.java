package com.dollop.lms.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.dollop.lms.bean.Admin;
import com.dollop.lms.bean.Book;
import com.dollop.lms.bean.BookOperation;
import com.dollop.lms.bean.Librarian;
import com.dollop.lms.bean.Student;
import com.dollop.lms.dao.IAdminDao;
import com.dollop.lms.dao.IBookDao;
import com.dollop.lms.dao.ILibrarianDao;
import com.dollop.lms.dao.IStudentDao;

import com.dollop.lms.dao.lmpl.AdminDaoImpl;
import com.dollop.lms.dao.lmpl.BookDaoImpl;
import com.dollop.lms.dao.lmpl.LibrarianDaoImpl;
import com.dollop.lms.dao.lmpl.StudentDaoImpl;
import com.dollop.lms.service.IAdminService;

public class AdminServiceImpl implements IAdminService {

	private IAdminDao adminDao = null;
	private ILibrarianDao librarianDao = null;
	IStudentDao studentDao = null;
	IBookDao bookDao = null;

	public AdminServiceImpl() {
		super();
		this.adminDao = new AdminDaoImpl();
		this.librarianDao = new LibrarianDaoImpl();
		this.studentDao = new StudentDaoImpl();
		this.bookDao = new BookDaoImpl();
	}

	@Override
	public Integer saveAdmins(List<Admin> admins) {

		return adminDao.insertAdmin(admins);
	}

	@Override
	public Admin login(String userName, String password) {

		return adminDao.login(userName, password);
	}

	@Override
	public Boolean isAdminExist() {

		return adminDao.isAdminExist();
	}

	@Override
	public Boolean changeAdminStatus(String uuid) {

		return adminDao.changeAdminStatus(uuid);
	}

	@Override
	public boolean isAdminAvailable() {
		return false;
	}

	@Override
	public Integer saveLibrarians(List<Librarian> librarians) {
		return librarianDao.insertLibrarian(librarians);
	}

	@Override
	public void removeLibrarian(String LName, String LPassword) {
		librarianDao.deleteLibrarian(LName, LPassword);
	}

	@Override
	public Boolean isLibrarianAvailable(String name) {
		return librarianDao.isLibrarianAvailable(name);
	}

	@Override
	public Boolean changeLibrarianStatus() {
		return librarianDao.changeLibrarianStatus();
	}

	@Override
	public Librarian showLibrarian() {
		return librarianDao.showLibrarian();

	}

	@Override
	public void showOneLibrarian(String uName) {
		librarianDao.showPerticularLibrarian(uName);
	}

	@Override
	public void updateLibrarian(String uName) {
		try {
			librarianDao.updaLibrarian(uName);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public Integer saveStudents(List<Student> students) {
		return studentDao.insertStudent(students);

	}

	@Override
	public void removeStd(String stdName) {

		studentDao.deleteStudent(stdName);
	}

	@Override
	public void updateStudent() {
		try {
			studentDao.updateStudent();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void showOneStudent(String uName) {
		studentDao.showPerticularStudent(uName);

	}

	@Override
	public void showAllStudent() {
		studentDao.showAllStudent();
	}

	@Override
	public Boolean isStudentAvailable(String sName) {
		return studentDao.isStudentAvailable(sName);
	}

	@Override
	public Integer insertBooks(List<Book> books) {
		return bookDao.insertBooks(books);
	}

	@Override
	public void removeBook(String bookName) {
		bookDao.deleteBook(bookName);

	}

	@Override
	public Boolean isBookExist(String bookName) {
		return bookDao.isBookAvailable(bookName);
	}

	@Override
	public Integer insertIssueBooks(List<BookOperation> books) {
		return bookDao.insertIssueBooks(books);
	}

	@Override
	public Integer quantityCheck(String bName) {
		try {
			return bookDao.quantityCheck(bName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void showAllIssueBooks() {
		try {
			bookDao.showAllIssueBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateBook() {
		try {
			bookDao.updateBook();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showOneBook(String bName) {
		try {
			bookDao.showOneBook(bName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showAllBook() {
		try {
			bookDao.showAllBook();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void increaseBookQuantity(String bName) {
		bookDao.increaseBookQuantity(bName);
	}

	@Override
	public void decreaseBookQuantity(String bName) {
		try {
			bookDao.decreaseBookQuantity(bName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean AlreadyIssued(String bookName, String uName) {
		return bookDao.AlreadyIssued(bookName, uName);
	}

	public Boolean isBookIssue(String bName) {
		return bookDao.isBookIssue(bName);
	}

	public void showOneIssueBooks(String bName) {
		bookDao.showOneIssueBooks(bName);
	}

}
