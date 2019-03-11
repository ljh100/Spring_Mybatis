package com.example.dto;

public class MemberVO {
	private String id;
	private String name;
	private String pw;
	private String address;
	
	public void MemberVO(String id, String name, String pw, String address) {

		this.id = id;
		this.name = name;
		this.pw = pw;
		this.address = address;
		
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
    public String toString() {
    	return "MemberVO [id=" + id + ", name=" + name 
				+ ", pw=" + pw + ", address=" + "]";
    }
}
