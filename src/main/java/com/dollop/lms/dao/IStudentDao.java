package com.dollop.lms.dao;

import java.sql.SQLException;
import java.util.List;

import com.dollop.lms.bean.Librarian;
import com.dollop.lms.bean.Student;

public interface IStudentDao {
	  public Student login(String uName,String sPass); 
	  public Integer insertStudent(List<Student> students);
	  public void updateStudent() throws SQLException;
	  public Student showAllStudent();
	  public Integer showPerticularStudent(String uName);
	  public Boolean isStudentExist();
	  public Boolean isStudentAvailable(String name);
	public void deleteStudent(String stdName);
	public void updateStudentName(String sName) throws SQLException;
	public void updateStudentPass(String sName) throws SQLException;
	public void updateStudentAddress(String sName) throws SQLException;
	public void updateStudentContact(String sName) throws SQLException;
	public Integer showStdissueBook(String username);
	  

}
