package com.example.dto;


public class MemberDTO {
	private long id;
	private String userName;
	private String password;
	private String name;
	private String address;
	private String email;
	private String contactNo;
	
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(long id, String userName, String password, String name, String address, String email,
			String contactNo) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
	}

		public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	
	
}
