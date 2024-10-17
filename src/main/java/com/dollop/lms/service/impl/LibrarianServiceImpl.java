package com.dollop.lms.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.dollop.lms.bean.Librarian;
import com.dollop.lms.dao.IAdminDao;
import com.dollop.lms.dao.ILibrarianDao;
import com.dollop.lms.dao.lmpl.LibrarianDaoImpl;
import com.dollop.lms.service.ILibrarianService;

public class LibrarianServiceImpl implements ILibrarianService{
	
	

	 private ILibrarianDao  librarianDao=null;
	    

	public LibrarianServiceImpl() {
		super();
		this.librarianDao = new LibrarianDaoImpl();
	}


	@Override
	public Librarian login(String userName, String password) {
		return librarianDao.login(userName, password);
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
   public void showOneLibrarian(String uName) {
	librarianDao.showPerticularLibrarian(uName);
	}


@Override
public Integer checkLibrarianisActive(String LName) {
	return librarianDao.checkLibrarianisActive(LName);
}

}
