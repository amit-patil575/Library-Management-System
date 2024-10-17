package com.dollop.lms.service;

import com.dollop.lms.bean.Librarian;
import com.dollop.lms.bean.Student;

public interface IStudentService {
	public Student login(String userName,String password);
	public void updateStudent();
	public void showOneStudent(String uName);
	public Integer showStdissueBook(String username); 
}
