package com.dollop.lms.dao.lmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import com.dollop.lms.bean.Admin;
import com.dollop.lms.controller.AdminController;
import com.dollop.lms.dao.IAdminDao;
import com.dollop.lms.utils.DbConnection;

public class AdminDaoImpl implements IAdminDao {
private Connection con=null;
private PreparedStatement pstmt=null;
private String sql=null;
ResultSet result,rs;

public AdminDaoImpl() {
	super();
	this.con= DbConnection.getConnection();
}


	public Integer insertAdmin(List<Admin> admins) {
		sql="insert into Admin values(?,?,?,?,?,?,?)";
				
			try {
				pstmt=con.prepareStatement(sql);
				for (Admin admin : admins) {
					pstmt.setString(1, UUID.randomUUID().toString());
					pstmt.setString(2, admin.getUserName()); 
					pstmt.setString(3, admin.getPassword());
					pstmt.setString(4, admin.getAddress());
					pstmt.setString(5, admin.getContect());
					pstmt.setBoolean(6, admin.isActive());
					pstmt.setString(7, admin.getCreateDate());
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

	
	public Admin login(String userName, String password) {
		
		 sql="SELECT * FROM ADMIN WHERE USERNAME=? AND PASSWORD=?";
		Admin admin=null;
		
		byte[] encrypt=Base64.getEncoder().encode(password.getBytes());
		
//		System.out.println("pass=> "+password);
		try {
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1,userName);
			 pstmt.setString(2,password);
			 ResultSet rs=pstmt.executeQuery();
			 if(rs.next()) {
					admin = new Admin(rs.getString("UUId"),
							rs.getString("userName"),
							rs.getString("password"),
							rs.getString("address"),
							rs.getString("contact"),
							rs.getBoolean("isActive"),
							rs.getString("createdData"));
				}
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return admin;
	}

	
	public Boolean isAdminExist() {
		sql="SELECT COUNT(*) FROM ADMIN";
		Boolean result=false;
		try {
			rs=pstmt.executeQuery(sql);
			if(rs.next())
			result=rs.getInt(1)>0;
		}
		catch(SQLException e)
        {
           e.printStackTrace();
        }
        	return result;
	}

	public Boolean changeAdminStatus(String uuid) {
		sql="UPDATE ADMIN SET ISACTIVE =NOT ISACTIVE WHERE uuid=?";
		Boolean result=false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uuid);
			result= pstmt.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
