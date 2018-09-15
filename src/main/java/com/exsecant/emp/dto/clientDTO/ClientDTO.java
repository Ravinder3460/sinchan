package com.exsecant.emp.dto.clientDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String companyName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phone;
	private String website;
	private List<ContactsDTO> contactList = new ArrayList<>(0);
	private List<ProjectsDTO> projectList = new ArrayList<>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<ContactsDTO> getContactList() {
		return contactList;
	}

	public void setContactList(List<ContactsDTO> contactList) {
		this.contactList = contactList;
	}

	public List<ProjectsDTO> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectsDTO> projectList) {
		this.projectList = projectList;
	}

}
