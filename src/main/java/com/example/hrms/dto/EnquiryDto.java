package com.example.hrms.dto;

public class EnquiryDto {
	
	private int id;
	private String name;
	private String address;
	private String contact_no;
	private String emailaddress;
	private String enquirytext;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getEnquirytext() {
		return enquirytext;
	}
	public void setEnquirytext(String enquirytext) {
		this.enquirytext = enquirytext;
	}
	

}
