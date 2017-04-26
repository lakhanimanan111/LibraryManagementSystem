package com.manan.dbproject.utilities;

public class Borrower {

	private String ssn;
	private String fname;
	private String lname;
	private String address;
	private String city;
	private String state;
	private String phone;
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		if(ssn.equals(""))
			this.ssn = null;
		else
			this.ssn = ssn;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		if(fname.equals(""))
			this.fname = null;
		else
			this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		if(lname.equals(""))
			this.lname = null;
		else
			this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address.equals(""))
			this.address = null;
		else
			this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		if(city.equals(""))
			this.city = null;
		else
			this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		if(state.equals(""))
			this.state = null;
		else
			this.state = state;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		if(phone.equals(""))
			this.phone = null;
		else
			this.phone = phone;
	}
	
}
