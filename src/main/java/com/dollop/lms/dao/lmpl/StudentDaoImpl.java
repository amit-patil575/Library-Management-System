package com.dollop.lms.dao.lmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.dollop.lms.bean.Admin;
import com.dollop.lms.bean.Librarian;
import com.dollop.lms.bean.Student;
import com.dollop.lms.bean.Validation;
import com.dollop.lms.controller.AdminController;
//import com.dollop.lms.controller.StudentController;
import com.dollop.lms.dao.IAdminDao;
import com.dollop.lms.dao.IStudentDao;
import com.dollop.lms.utils.DbConnection;



public class StudentDaoImpl implements IStudentDao {
	private static final Student Student = null;
	private Connection con = null;
	public StudentDaoImpl() {
		super();
		this.con=DbConnection.getConnection();
	}
	Student student;
static AdminController AController=new AdminController();
//static StudentController studentController=new StudentController();
Validation vali=new Validation();

private PreparedStatement pstmt=null;
	private String sql=null;
	ResultSet result,rs;
Scanner sc=new Scanner(System.in);

@Override
public Boolean isStudentAvailable(String name) {
     sql="select Std_Name from student where Std_Name = ?";	
     Boolean result=false;
     try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,name);
		 ResultSet rs=pstmt.executeQuery();
		if(rs.next())
			result=rs.getString("Std_Name").equals(name);
	} catch (SQLException e) {
		e.printStackTrace();
	}
     return result;
}

	@Override
	public Integer insertStudent(List<Student> students) {
		sql = "insert into Student values(?,?,?,?,?,?,?,?)";
		
		try {
			pstmt=con.prepareStatement(sql);
			for (Student student : students) {
				pstmt.setString(1, UUID.randomUUID().toString());
				pstmt.setString(2, student.getUserName()); 
				pstmt.setString(3, student.getPassword());
				pstmt.setString(4, student.getAddress());
				pstmt.setString(5, student.getContact());
				pstmt.setString(6, student.getEmail());
				pstmt.setBoolean(7, student.isActive());
				pstmt.setString(8, student.getCreateDate());
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
		//	System.out.println("kjhygtfrd");
		}
	   return batch.length;	
	
	}
	@Override
	public Student login(String userName, String password) {

		 sql="SELECT * FROM student WHERE Std_Name=? AND Std_Password=?";
		 Student student=null;
		
		try {
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1,userName);
			 pstmt.setString(2,password);
			 ResultSet rs=pstmt.executeQuery();
			 if(rs.next()) {
					student = new Student(rs.getString("UUId"),
							rs.getString("Std_Name"),
							rs.getString("Std_Password"),
							rs.getString("Std_Address"),
							rs.getString("Std_Contact"),
							rs.getString("Std_Email"),
							rs.getBoolean("isActive"),
							rs.getString("createddate"));
				}
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return student;
	}
	@Override
	public Boolean isStudentExist() {
		sql="SELECT COUNT(*) FROM Student";
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
	public Integer showPerticularStudent(String uName) {
		int c=0;
		Student student = null;
		if(isStudentExist()) {
		sql="select * from Student where Std_Name =? ";
			try {
				 pstmt=con.prepareStatement(sql);
				 pstmt.setString(1,uName);
				 ResultSet rs=pstmt.executeQuery();
				 while(rs.next()) {
					 c=1;
					 System.out.println("===========================================================");
				       System.out.println("Student uuid--> "+rs.getString("uuid")+" \n"+
							"Student Name--> "+rs.getString("Std_Name")+" \n"+
							"Student Password--> "+rs.getString("Std_Password")+" \n"+
							"Student Address--> "+rs.getString("Std_Address")+" \n"+
							"Student Contact--> "+rs.getString("Std_Contact")+" \n"+
							"Student Email--> "+rs.getString("Std_Email")+" \n"+
							"Student isActive--> "+rs.getString("isActive")+" \n"+
							"Student CreatedDate--> "+rs.getString("createddate"));
				 System.out.println("===========================================================");
				 }
			 }
			 catch(SQLException e)
			 {
				 System.out.println("> Wrong std_Name <");
				 e.printStackTrace();
			 }
		 }
		else {
			System.out.println("> No Student Found <");
		}
		
		return c;
	}
  @Override
	public  Student showAllStudent() {
		Student student = null;
		if(isStudentExist()) {
		sql="select * from student";
			
			try {
				 pstmt=con.prepareStatement(sql);
				 ResultSet rs=pstmt.executeQuery();
				 while(rs.next()) {
					 System.out.println("===========================================================");
				       System.out.println("Student uuid--> "+rs.getString("uuid")+" \n"+
							"Student Name--> "+rs.getString("Std_Name")+" \n"+
							"Student Password--> "+rs.getString("Std_Password")+" \n"+
							"Student Address--> "+rs.getString("Std_Address")+" \n"+
							"Student Contact--> "+rs.getString("Std_Contact")+" \n"+
							"Student Email--> "+rs.getString("Std_Email")+" \n"+
							"Student isActive--> "+rs.getString("isActive")+" \n"+
							"Student CreatedDate--> "+rs.getString("createddate"));
				 System.out.println("===========================================================");

					}
			 }
			 catch(SQLException e)
			 {
				 e.printStackTrace();
			 }
		 }
		else {
			System.out.println("No Student Found");
		}
		
		return student;
	}


	public Boolean oneStudentExist(String sName) throws SQLException{
		sql="select * from Student where Std_Name= ? ";
		Boolean result=false;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,sName);
	    ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			result =true;
			 System.out.println("===========================================================");
		       System.out.println("Student uuid--> "+rs.getString("uuid")+" \n"+
					"Student Name--> "+rs.getString("Std_Name")+" \n"+
					"Student Password--> "+rs.getString("Std_Password")+" \n"+
					"Student Address--> "+rs.getString("Std_Address")+" \n"+
					"Student Contact--> "+rs.getString("Std_Contact")+" \n"+
					"Student Email--> "+rs.getString("Std_Email")+" \n"+
					"Student isActive--> "+rs.getString("isActive")+" \n"+
					"Student CreatedDate--> "+rs.getString("createddate"));
		 System.out.println("===========================================================");
		}
		return result;
			
   }
	@Override
	public void updateStudent() throws SQLException {
		
		  Boolean t=false;
			System.out.println("Enter the 'Name' of the Student whose details you want to update");
			
			String sName=sc.nextLine();
			
			 try {
				t=oneStudentExist(sName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 if(t.equals(true)) {
		        System.out.println("What do you want to upadate Librarian details");
				System.out.println(" 1) LName\n 2) LPassword\n 3) address\n 4) contact\n 5) Email\n 6) Return  Back\n");
				String choice=sc.nextLine();
				
				switch(choice) {
				
				   case "1":
					   updateStudentName(sName); 
				       break;
				   case "2":
					    updateStudentPass(sName);
					    break;
				   case "3":
					   updateStudentAddress(sName);
					    break;
				   case "4":
					   updateStudentContact(sName);
					    break;
				   case "5":
					   updateStudentEmail(sName);
					    break;
				   case "6":
				//	   studentController.studentDashboard(student);
					   break;
				  }
			   }
				else {
					System.out.println("No Student Found");
				}
		
  }	
	@Override
	public void updateStudentName(String sName) throws SQLException {
		 System.out.println("Enter New 'Name' of the Student");
		 String newLiName=sc.nextLine();
		 sql="update Student set Std_Name= ? where Std_Name=?";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,newLiName);
		 pstmt.setString(2, sName);
		
		 
		 int i=pstmt.executeUpdate();
		 if(i==1) 
			 System.out.println("Update Succesefull");
		 else 
			 System.out.println("No update details");
}
	@Override
	public void updateStudentPass(String sName) throws SQLException {
		System.out.println("Enter New 'Password' of the Student");
		String newLiPass=sc.nextLine();
		String ENewPass=vali.EncryptPass(newLiPass);
		 sql="update student set Std_Password= ? where Std_Name=? ";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,ENewPass);
		 pstmt.setString(2, sName);
		 
		 int i=pstmt.executeUpdate();
		 if(i==1) 
			 System.out.println("Update Succesefull");
		 else 
			 System.out.println("No update details");
		
	}
	@Override
	public void updateStudentAddress(String sName) throws SQLException {
		System.out.println("Enter New 'Address' of the Student");
		String newLiAddress=sc.nextLine();
		 sql="update student set Std_Address= ? where Std_Name=? ";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,newLiAddress);
		 pstmt.setString(2, sName);
		 
		 int i=pstmt.executeUpdate();
		 if(i==1) 
			 System.out.println("Update Succesefull");
		 else 
			 System.out.println("No update details");
	}
	@Override
	public void updateStudentContact(String sName) throws SQLException {
		 System.out.println("Enter New 'Contact' of the Student");
		 String newLiContact=sc.nextLine();
		 sql="update student set Std_Contact= ? where Std_Name=? ";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,newLiContact);
		 pstmt.setString(2, sName);
		 
		 int i=pstmt.executeUpdate();
		 if(i==1) 
			 System.out.println("Update Succesefull");
		 else 
			 System.out.println("No update details");
		
	}
	public void updateStudentEmail(String sName) throws SQLException {
		System.out.println("Enter New 'Email' of the Student");
		 String newLiMail=sc.nextLine();
		 sql="update Student set Std_Email= ? where Std_Name=? ";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,newLiMail);
		 pstmt.setString(2, sName);
		 
		 int i=pstmt.executeUpdate();
		 if(i==1) 
			 System.out.println("Update Succesefull");
		 else 
			 System.out.println("No update details");
		
	}

	@Override
	public void deleteStudent(String stdName) {
		sql="delete from Student where Std_Name=? ";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,stdName);
			int c=pstmt.executeUpdate();
			if(c==0) 
				System.out.println(" -Wrong Studet user Name  \n Deleted Data--> "+c);
			else
				System.out.println(" -Delete Student Successfully- \n Deleted Data--> "+c);
		} 
		catch (SQLException e) {
			System.out.println(e);
			System.out.println(" Exception !!!");			
		}
		
	}
	@Override
	public Integer showStdissueBook(String username) {
		int result=0;
		sql="select * from issuebooks where issueUserName=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				result=1;
					 System.out.println("===========================================================");
				       System.out.println("Book uuid--> "+rs.getString("UId")+" \n"+
							"Issue Book Name--> "+rs.getString("issuebName")+" \n"+
							"Issue Book Issue UserName--> "+rs.getString("issueUserName")+" \n"+
							"Issue Book Quantity--> "+rs.getInt("issueBookQuantity")+" \n"+
							"Book Issue Date--> "+rs.getString("issueDate"));
				 System.out.println("===========================================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
}

