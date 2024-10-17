package com.dollop.lms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
  
	 private static String DB_NAME=null;
	 private static String DB_URL=null;
	 private static String DB_UNAME=null;
	 private static String DB_PWD=null;
	 private static Connection con=null;
	 private static String DB_DRIVER=null;
	 
	 static {
		 File file=new File("D:\\Advance1\\LMS_Project\\LMSweb\\src\\application.properties");
		 try {
			 FileInputStream fis=new FileInputStream(file);
		     Properties p=new Properties();
		     p.load(fis);
		     DB_NAME=p.getProperty("DB_NAME");
		     DB_PWD=p.getProperty("DB_PWD");
		     DB_URL=p.getProperty("DB_URL");
		     DB_UNAME=p.getProperty("DB_UNAME");
		     DB_DRIVER=p.getProperty("DB_DRIVER");
		     
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
    public static Connection getConnection(){
    	if(con!=null)
    		return con;
    	else
    		return getConnection(DB_URL+DB_NAME,DB_UNAME,DB_PWD);
    }
    private static Connection getConnection(String db_URL,String db_UNAME2,String db_PWD2) {
    	try {
    		Class.forName(DB_DRIVER);
    		con=DriverManager.getConnection(db_URL,db_UNAME2,db_PWD2);
    	}
    	catch(ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    		
    	}
    	return con;
    }
    
}
