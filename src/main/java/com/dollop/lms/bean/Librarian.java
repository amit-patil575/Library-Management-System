package com.dollop.lms.bean;

public class Librarian {
	private String uuid;
	private String userName;
	private String password;
	private String address;

	private String contact;
	private String email;
	private boolean isActive;
	private String createDate;
	public Librarian() {
		super();
	}
	public Librarian(String uuid, String userName, String password, String address, String contact, String email,
			boolean isActive, String createDate) {
		super();
		this.uuid = uuid;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.contact = contact;
		this.email = email;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getIsActive() {
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
		return "Librarian [uuid=" + uuid + ", userName=" + userName + ", password=" + password + ", address=" + address
				+ ", contact=" + contact + ", email=" + email + ", isActive=" + isActive + ", createDate=" + createDate
				+ "]";
	}
	
	
	

}
