package com.dollop.lms.dao.lmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.dollop.lms.bean.Admin;
import com.dollop.lms.bean.Librarian;
import com.dollop.lms.controller.AdminController;
import com.dollop.lms.dao.IAdminDao;
import com.dollop.lms.dao.ILibrarianDao;
import com.dollop.lms.utils.DbConnection;
import com.dollop.lms.bean.Validation;

public class LibrarianDaoImpl implements ILibrarianDao {
private Connection con=null;
private PreparedStatement pstmt=null;
private String sql=null;
ResultSet result,rs;
Librarian librarian;
static AdminController AController=new AdminController();
Validation vali=new Validation();

Scanner sc=new Scanner(System.in);

	public LibrarianDaoImpl() {
		super();
		this.con= DbConnection.getConnection();
	}
	@Override
	public Integer insertLibrarian(List<Librarian> librarians) {
		sql="insert into Librarian values(?,?,?,?,?,?,?,?)";
				
			try {
				
				pstmt=con.prepareStatement(sql);
				for (Librarian librarian : librarians) {
					pstmt.setString(1, UUID.randomUUID().toString());
					pstmt.setString(2, librarian.getUserName()); 
					pstmt.setString(3, librarian.getPassword());
					pstmt.setString(4, librarian.getAddress());
					pstmt.setString(5, librarian.getContact());
					pstmt.setString(6, librarian.getEmail());
					pstmt.setBoolean(7, librarian.getIsActive());
					pstmt.setString(8, librarian.getCreateDate());
					pstmt.addBatch();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			int [] batch=null;
			try {
				batch=pstmt.executeBatch();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		   return batch.length;			
}
	
	@Override
	public Boolean isLibrarianExist() {
		sql="SELECT COUNT(*) FROM Librarian";
		Boolean result=false;
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
				result=rs.getInt(1)>0;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public  Integer checkLibrarianisActive(String LName) {
		sql="select isActive from librarian where LName =?";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,LName);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
			   return result=rs.getInt("isActive");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Boolean isLibrarianAvailable(String name) {
		sql="select LName from librarian where LName = ?";	
		Boolean result=false;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,name);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				result=rs.getString("LName").equals(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void deleteLibrarian(String LName,String LPassword) {
		  sql="delete from Librarian where LName=? and LPassword= ? ";
		  try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,LName);
			pstmt.setString(2, LPassword);
			int c=pstmt.executeUpdate();
			if(c==0) 
				System.out.println(" -Wrong Lname or LPassword!- \n Deleted Data--> "+c);
			else
			   System.out.println(" -Delete Librarian Successfully- \n Deleted Data--> "+c);
	      } 
		  catch (SQLException e) {
            System.out.println(" Exception !!!");			
		 }
		  
}
	@Override
	public Librarian login(String userName, String password) {

		 sql="SELECT * FROM librarian WHERE LName=? AND LPassword=?";
		 Librarian librarian=null;
		
		try {
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1,userName);
			 pstmt.setString(2,password);
			 ResultSet rs=pstmt.executeQuery();
			 if(rs.next()) {
					librarian = new Librarian(rs.getString("UUId"),
							rs.getString("LName"),
							rs.getString("LPassword"),
							rs.getString("address"),
							rs.getString("contact"),
							rs.getString("Email"),
							rs.getBoolean("isActive"),
							rs.getString("createddate"));
				}
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return librarian;
	}
	
	public  Librarian showLibrarian() {
		Librarian librarian = null;
		if(isLibrarianExist()) {
		sql="select * from librarian";
			
			try {
				 pstmt=con.prepareStatement(sql);
				 ResultSet rs=pstmt.executeQuery();
				 while(rs.next()) {
					 System.out.println("===========================================================");
					       System.out.println("Librarian uuid--> "+rs.getString("uuid")+" \n"+
								"Libararian Name--> "+rs.getString("LName")+" \n"+
								"Libararian Password--> "+rs.getString("LPassword")+" \n"+
								"Libararian Address--> "+rs.getString("address")+" \n"+
								"Libararian Contact--> "+rs.getString("contact")+" \n"+
								"Libararian Email--> "+rs.getString("Email")+" \n"+
								"Libararian isActive--> "+rs.getString("isActive")+" \n"+
								"Libararian CreatedDate--> "+rs.getString("createddate"));
					 System.out.println("===========================================================");
					}
			 }
			 catch(SQLException e)
			 {
				 e.printStackTrace();
			 }
		 }
		else {
			System.out.println("No Librarian Found");
		}
		
		return librarian;
	}

	@Override
	public Integer showPerticularLibrarian(String uName) {
		int c=0;
		Librarian librarian = null;
		if(isLibrarianExist()) {
		sql="select * from librarian where LName=? ";
			try {
				 pstmt=con.prepareStatement(sql);
				 pstmt.setString(1,uName);
				 ResultSet rs=pstmt.executeQuery();
				 while(rs.next()) {
					 c=1;
					 System.out.println("===========================================================");
					       System.out.println("Librarian uuid--> "+rs.getString("uuid")+" \n"+
								"Libararian Name--> "+rs.getString("LName")+" \n"+
								"Libararian Password--> "+rs.getString("LPassword")+" \n"+
								"Libararian Address--> "+rs.getString("address")+" \n"+
								"Libararian Contact--> "+rs.getString("contact")+" \n"+
								"Libararian Email--> "+rs.getString("Email")+" \n"+
								"Libararian isActive--> "+rs.getString("isActive")+" \n"+
								"Libararian CreatedDate--> "+rs.getString("createddate"));
					 System.out.println("===========================================================");
					}
			 }
			 catch(SQLException e)
			 {
				 System.out.println("Wrong LName or LPassword");
				 e.printStackTrace();
			 }
		 }
		else {
			System.out.println(" No Librarian Found");
		}
		
		return c;
	}

	@Override
	public Boolean changeLibrarianStatus() {
		System.out.println("Enter Librarian Name");
		String LName=sc.nextLine();
		System.out.println("Enter Librarian Password");
		String LPass=sc.nextLine();
		String EPass=vali.EncryptPass(LPass);
		sql="UPDATE librarian SET ISACTIVE = NOT ISACTIVE WHERE LName=? and LPassword=?";
		Boolean result=false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, LName);
			pstmt.setString(2, EPass);
			result= pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Boolean oneLibrarianExist(String Lname) throws SQLException{
	
		sql="select * from librarian where LName= ? ";
		Boolean result=false;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,Lname);
	    ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			result =true;
			 System.out.println("===========================================================");
		       System.out.println("Librarian uuid--> "+rs.getString("uuid")+" \n"+
					"Libararian Name--> "+rs.getString("LName")+" \n"+
					"Libararian Password--> "+rs.getString("LPassword")+" \n"+
					"Libararian Address--> "+rs.getString("address")+" \n"+
					"Libararian Contact--> "+rs.getString("contact")+" \n"+
					"Libararian Email--> "+rs.getString("Email")+" \n"+
					"Libararian isActive--> "+rs.getString("isActive")+" \n"+
					"Libararian CreatedDate--> "+rs.getString("createddate"));
		 System.out.println("===========================================================");
		}
		return result;
			
   }
	@Override
	public void updaLibrarian(String uName) throws SQLException {
//		System.out.println("Enter the 'Name' of the librarian whose details you want to update");
//		String Lname=sc.nextLine();
//		System.out.println("Enter the 'Password' of the librarian whose details you want to update");
//		String Lpass=sc.nextLine();
//		String EPass=AdminController.EncryptPass(Lpass);
	while(true) {
		Boolean t=false;
		
		 try {
			t=oneLibrarianExist(uName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 if(t.equals(true)) {
	        System.out.println("What do you want to upadate Librarian details");
			System.out.println(" 1) LName\n 2) LPassword\n 3) address\n 4) contact\n 5) Email\n  6) Back to Librarian Panel\n");
			String choice=sc.nextLine();
			if("6".equals(choice)) {
				break;
			}
			
			switch(choice) {
			
			   case "1":
				   updateLibrarianName(uName); 
			       break;
			   case "2":
				    updateLibrarianPass(uName);
				    break;
			   case "3":
				   updateLibrarianAddress(uName);
				    break;
			   case "4":
				   updateLibrarianContact(uName);
				    break;
			   case "5":
				   updateLibrarianEmail(uName);
				    break;
//			   case "6":
//				   AController.LibrarianPanel(librarian); 
//				   break;
			  }
		   }
			else {
				System.out.println("No Librarian Found");
			}
	   }
	}	
		
		 public void updateLibrarianName(String uName) throws SQLException {
			 System.out.println("Enter New 'Name' of the Librarian");
			 String newLiName=sc.nextLine();
			 sql="update Librarian set LName= ? where LName=? ";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,newLiName);
			 pstmt.setString(2, uName);
			 
			 int i=pstmt.executeUpdate();
			 if(i==1) 
				 System.out.println("Update Succesefull");
			 else 
				 System.out.println("No update details");
	}
		@Override
		public void updateLibrarianPass(String uName) throws SQLException {
			System.out.println("Enter New 'Password' of the Librarian");
			String newLiPass=sc.nextLine();
			String ENewPass=vali.EncryptPass(newLiPass);
			 sql="update Librarian set LPassword= ? where LName=? ";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,ENewPass);
			 pstmt.setString(2, uName);
			 
			 int i=pstmt.executeUpdate();
			 if(i==1) 
				 System.out.println("Update Succesefull");
			 else 
				 System.out.println("No update details");
			
		}
		@Override
		public void updateLibrarianAddress(String uName) throws SQLException {
			System.out.println("Enter New 'Address' of the Librarian");
			String newLiAddress=sc.nextLine();
			 sql="update Librarian set address= ? where LName=? ";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,newLiAddress);
			 pstmt.setString(2, uName);
			 
			 int i=pstmt.executeUpdate();
			 if(i==1) 
				 System.out.println("Update Succesefull");
			 else 
				 System.out.println("No update details");
		}
		@Override
		public void updateLibrarianContact(String uName) throws SQLException {
			 System.out.println("Enter New 'Contact' of the Librarian");
			 String newLiContact=sc.nextLine();
			 sql="update Librarian set contact= ? where LName=? ";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,newLiContact);
			 pstmt.setString(2, uName);
			 
			 int i=pstmt.executeUpdate();
			 if(i==1) 
				 System.out.println("Update Succesefull");
			 else 
				 System.out.println("No update details");
			
		}
		@Override
		public void updateLibrarianEmail(String uName) throws SQLException {
			System.out.println("Enter New 'Email' of the Librarian");
			 String newLiMail=sc.nextLine();
			 sql="update Librarian set Email= ? where LName=? ";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,newLiMail);
			 pstmt.setString(2,uName);
			 
			 int i=pstmt.executeUpdate();
			 if(i==1) 
				 System.out.println("Update Succesefull");
			 else 
				 System.out.println("No update details");
			
		}
}
	


