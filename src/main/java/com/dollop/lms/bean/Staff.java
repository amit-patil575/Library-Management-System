package com.dollop.lms.bean;

public class Staff {
    
	private String uuid;
	private String userName;
	private String password;
	private String address;

	private String contect;
	private boolean isActive;
	private String createDate;
	

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Staff(String uuid, String userName, String password, String address, String contect, boolean isActive,
			String createDate) {
		super();
		this.uuid = uuid;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.contect = contect;
		this.isActive = isActive;
		this.createDate = createDate;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContect() {
		return contect;
	}


	public void setContect(String contect) {
		this.contect = contect;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "Staff [uuid=" + uuid + ", userName=" + userName + ", password=" + password + ", address=" + address
				+ ", contect=" + contect + ", isActive=" + isActive + ", createDate=" + createDate + ", getUuid()="
				+ getUuid() + ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword()
				+ ", getAddress()=" + getAddress() + ", getContect()=" + getContect() + ", isActive()=" + isActive()
				+ ", getCreateDate()=" + getCreateDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
   
	
  

	
	
    
}
