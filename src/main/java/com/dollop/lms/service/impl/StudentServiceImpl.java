package com.dollop.lms.service.impl;

import java.sql.SQLException;

import com.dollop.lms.bean.Librarian;
import com.dollop.lms.bean.Student;
import com.dollop.lms.dao.ILibrarianDao;
import com.dollop.lms.dao.IStudentDao;
import com.dollop.lms.dao.lmpl.StudentDaoImpl;
import com.dollop.lms.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	 private IStudentDao  studentDao=null;
	 
	

	public StudentServiceImpl() {
		super();
	    this.studentDao=new StudentDaoImpl();
	}

	@Override
	public Student login(String userName, String password) {
		return studentDao.login(userName, password);
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
	public Integer showStdissueBook(String username) {
		return studentDao.showStdissueBook(username);
	}

}
