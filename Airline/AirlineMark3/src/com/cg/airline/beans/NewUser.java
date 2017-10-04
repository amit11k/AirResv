package com.cg.airline.beans;

public class NewUser {
	private String userName;
	private String password;
	private String emailId;
	private String contact;
	
	public NewUser() {
		// TODO Auto-generated constructor stub
	}

	public NewUser(String userName, String password, String emailId,
			String contact) {
		super();
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.contact = contact;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "NewUser [userName=" + userName + ", password=" + password
				+ ", emailId=" + emailId + ", contact=" + contact + "]";
	}
	
}
