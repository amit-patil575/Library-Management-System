package com.dollop.lms.service;

import java.util.List;

import com.dollop.lms.bean.Librarian;
import com.dollop.lms.bean.Student;

public interface ILibrarianService {
	
    public Librarian login(String userName,String password);
	public void updateLibrarian(String uName);
	public void showOneLibrarian(String uName);
	public  Integer checkLibrarianisActive(String LName);
}
