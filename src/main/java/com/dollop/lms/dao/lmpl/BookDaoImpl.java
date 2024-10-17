package com.dollop.lms.dao.lmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.dollop.lms.bean.Book;
import com.dollop.lms.bean.BookOperation;
import com.dollop.lms.controller.AdminController;
import com.dollop.lms.dao.IBookDao;
import com.dollop.lms.utils.DbConnection;

public class BookDaoImpl implements IBookDao {
 private String sql;   
 private PreparedStatement pstmt=null;
 private Connection con=null;
static AdminController adController=new AdminController();
	Scanner sc=new Scanner(System.in);
	IBookDao adminService;
	
    public BookDaoImpl() {
	    super();
	    this.con= DbConnection.getConnection();
     }
	@Override
	public Integer insertBooks(List<Book> books) {
		sql="insert into Books values(?,?,?,?,?,?)";
		
		try {
			
			pstmt=con.prepareStatement(sql);
			for (Book book : books) {
				pstmt.setString(1, UUID.randomUUID().toString());
				pstmt.setString(2, book.getBookName()); 
				pstmt.setString(3, book.getAuthorName());
				pstmt.setInt(4, book.getBookPages());
				pstmt.setInt(5, book.getBookQuantity());
				pstmt.setString(6, book.getCreateDate());
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
	public Integer insertIssueBooks(List<BookOperation> books) {
		sql="insert into issuebooks values(?,?,?,?,?) ";
		
		try {
			
			pstmt=con.prepareStatement(sql);
			for (BookOperation book : books) {
				pstmt.setString(1, UUID.randomUUID().toString());
				pstmt.setString(2, book.getUserName());
				pstmt.setString(3, book.getBookName()); 
				pstmt.setInt(4, book.getBookQuantity());
				pstmt.setString(5, book.getCreateDate());
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
	public void updateBook() throws SQLException{
			 Boolean t=false;
				System.out.println("Enter the 'Name' of the Book whose details you want to update");
				
				String bName=sc.nextLine();
				
				 t=isBookAvailable(bName);
				 
				 if(t.equals(true)) {
			        System.out.println("What do you want to upadate Librarian details");
					System.out.println(" 1) Book Name\n 2) Book Author Name\n 3) Book Pages\n 4) Book Quantity\n 5) Return  Back\n");
					String choice=sc.nextLine();
					
					switch(choice) {
					
					   case "1":
						   updateBookName(bName); 
					       break;
					   case "2":
						    updateBookAuthorName(bName);
						    break;
					   case "3":
						   updateBookPages(bName);
						    break;
					   case "4":
						   updateBookquantity(bName);
						    break;
					   case "5":
						//   adController.bookPanel();
	                       break;
					  }
				   }
					else {
						System.out.println("No Student Found");
					}
			
  }	
		@Override
		public void updateBookName(String bName) throws SQLException {
			 System.out.println("Enter New 'Name' of the Book");
			 String newLiName=sc.nextLine();
			 sql="update books set Name= ? where Name=?";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,newLiName);
			 pstmt.setString(2, bName);
			
			 
			 int i=pstmt.executeUpdate();
			 if(i==1) 
				 System.out.println("Update Succesefull");
			 else 
				 System.out.println("No update details");
	  }
		@Override
		public void updateBookAuthorName(String bName) throws SQLException {
			System.out.println("Enter New 'AuthorName' of the Book");
			String newAuthorName=sc.nextLine();
			 sql="update books set Author= ? where Name=? ";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,newAuthorName);
			 pstmt.setString(2, bName);
			 
			 int i=pstmt.executeUpdate();
			 if(i==1) 
				 System.out.println("Update Succesefull");
			 else 
				 System.out.println("No update details");
			
		}
		@Override
		public void updateBookPages(String bName) throws SQLException {
			System.out.println("Enter New 'Pages' of the Book");
			String newPages=sc.nextLine();
			 sql="update books set Pages= ? where Name = ? ";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,newPages);
			 pstmt.setString(2, bName);
			 
			 int i=pstmt.executeUpdate();
			 if(i==1) 
				 System.out.println("Update Succesefull");
			 else 
				 System.out.println("No update details");
		}
		@Override
		public void updateBookquantity(String bName) throws SQLException {
			 System.out.println("Enter New 'Quantity' of the Book");
			 String newQuantity=sc.nextLine();
			 sql="update books set quantity = ? where Name=? ";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1,newQuantity);
			 pstmt.setString(2, bName);
			 
			 int i=pstmt.executeUpdate();
			 if(i==1) 
				 System.out.println("Update Succesefull");
			 else 
				 System.out.println("No update details");
			
		}
		

		@Override
		public void deleteBook(String bName) {
			sql="delete from books where Name=? ";
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,bName);
				int c=pstmt.executeUpdate();
				if(c==0) 
					System.out.println(" -Wrong Book Name  \n Deleted Data--> "+c);
				else
					System.out.println(" -Delete Book Successfully- \n Deleted Data--> "+c);
			} 
			catch (SQLException e) {
				System.out.println(e);
				System.out.println(" Exception !!!");			
			}
			
		}
  
		@Override
		public Boolean showOneBook(String bName) throws SQLException {
			sql="select * from books where Name= ? ";
			Boolean result=false;
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,bName);
		    ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				result =true;
				 System.out.println("===========================================================");
			       System.out.println("Book uuid--> "+rs.getString("UId")+" \n"+
						"Book Name--> "+rs.getString("Name")+" \n"+
						"Book AuthorName--> "+rs.getString("Author")+" \n"+
						"Book Pages--> "+rs.getInt("Pages")+" \n"+
						"Book Quantity--> "+rs.getInt("quantity")+" \n"+
						"Book CreatedDate--> "+rs.getString("createddate"));
			 System.out.println("===========================================================");
			}
			return result;
			
		}
	
	
		@Override
		public Boolean showAllBook() throws SQLException {
			sql="select * from books";
			Boolean result=false;
			
			pstmt = con.prepareStatement(sql);
		    ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				result =true;
				 System.out.println("===========================================================");
			       System.out.println("Book uuid--> "+rs.getString("UId")+" \n"+
						"Book Name--> "+rs.getString("Name")+" \n"+
						"Book AuthorName--> "+rs.getString("Author")+" \n"+
						"Book Pages--> "+rs.getInt("Pages")+" \n"+
						"Book Quantity--> "+rs.getInt("quantity")+" \n"+
						"Book CreatedDate--> "+rs.getString("createddate"));
			 System.out.println("===========================================================");
			}
			return result;
			
		}
		
		@Override
		public Boolean isBookAvailable(String bName) {
			sql="select Name from books where Name = ?";	
			Boolean result=false;
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,bName);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next())
					result=rs.getString("Name").equals(bName);
			  }
			 catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}
		@Override
		public Boolean isBookIssue(String bName) {
			sql="select * from issuebooks where issuebName = ?";	
			Boolean result=false;
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,bName);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next())
					result=rs.getString("issuebName").equals(bName);
			  }
			 catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}
		@Override
		public void showOneIssueBooks(String uName){
			sql="select * from issuebooks where issueUserName=? ";
			Boolean result=false;
			try {
				pstmt=con.prepareStatement(sql);
			    pstmt.setString(1,uName);
			    ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					result=true;
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
				if(result==false) {
					System.out.println("--Entered Book is not found--");
				}
	   }
		@Override
		public boolean AlreadyIssued(String bookName,String uName) {
			sql="select * from issueBooks where issueUserName=? and issuebName=?";
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, uName);
				pstmt.setString(2, bookName);
				ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
			
		}
		@Override
		public Integer quantityCheck(String bName) throws SQLException {
				sql="select quantity from books where Name = ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,bName);
				ResultSet rs=pstmt.executeQuery();
				int Quantity = 0;
				if(rs.next())
				     Quantity=rs.getInt("quantity");
				else
					return -1;
				
			return Quantity;
		}
		
		@Override
		public void increaseBookQuantity(String bName) {
			sql="update books set quantity =quantity+1 where Name=? ";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,bName);
				int i=pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void decreaseBookQuantity(String bName) throws SQLException {
				sql="update books set quantity =quantity-1 where Name=? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,bName);
				int i=pstmt.executeUpdate();
        }
	@Override
	public void showAllIssueBooks() throws SQLException {
		sql="select * from issuebooks";
		Boolean result=false;
		pstmt=con.prepareStatement(sql);
		 ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				result=true;
				 System.out.println("===========================================================");
			       System.out.println("Book uuid--> "+rs.getString("UId")+" \n"+
						"Issue Book Name--> "+rs.getString("issuebName")+" \n"+
						"Issue Book Issue UserName--> "+rs.getString("issueUserName")+" \n"+
						"Issue Book Quantity--> "+rs.getInt("issueBookQuantity")+" \n"+
						"Book Issue Date--> "+rs.getString("issueDate"));
			 System.out.println("===========================================================");
			}
			if(result==false) {
				System.out.println("--No Issued Book here--");
			}
   }

}
