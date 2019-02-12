package com.javalec.teampro.RS.dto;

import java.sql.Timestamp;

public class RSdto {

	private String id;
	private String password;
	private String newpassword;
	private String newrepassword;
	private String name;
	private String birth;
	private String postcode;
	private String address;
	private String address2;
	private String tel;
	private String email;
	private String gender;
	private String genre;
	private Timestamp Rdate;
	
	
	
	
	public String getNewrepassword() {
		return newrepassword;
	}
	public void setNewrepassword(String newrepassword) {
		this.newrepassword = newrepassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getRdate() {
		return Rdate;
	}
	public void setRdate(Timestamp rdate) {
		Rdate = rdate;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
