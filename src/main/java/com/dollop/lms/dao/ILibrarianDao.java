package com.dollop.lms.dao;

import java.sql.SQLException;
import java.util.List;

import com.dollop.lms.bean.Admin;
import com.dollop.lms.bean.Librarian;

public interface ILibrarianDao {
	
	public Integer insertLibrarian(List<Librarian> librarians);
    public Librarian login(String userName,String password);
    public Boolean isLibrarianExist();
    public Boolean isLibrarianAvailable(String name);
  public void deleteLibrarian(String LName,String LPassword) ;
    public Boolean changeLibrarianStatus();
    public Librarian showLibrarian();
    public Integer showPerticularLibrarian(String uName);
    public  Integer checkLibrarianisActive(String LName);
    
    public void updaLibrarian(String uName) throws SQLException;
    public void updateLibrarianName(String uName) throws SQLException;
    public void updateLibrarianPass(String uName) throws SQLException;
    public void updateLibrarianAddress(String uName) throws SQLException;
    public void updateLibrarianContact(String uName) throws SQLException;
    public void updateLibrarianEmail(String uName) throws SQLException;
}
