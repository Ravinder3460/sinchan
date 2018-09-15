package com.exsecant.emp.entity.client;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Client_Table")
public class TblClient implements Serializable {

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
	private Set<TblContacts> contactsList = new HashSet<>();
	private Set<TblProjects> projectList = new HashSet<>();

	public TblClient() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Company_Name", nullable = false)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "Address", nullable = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "City", nullable = false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "State", nullable = false)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "Zip", nullable = false)
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "Country", nullable = false)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "Phone", nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Website", nullable = false)
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clientId", cascade = CascadeType.ALL)
	public Set<TblContacts> getContactsList() {
		return contactsList;
	}

	public void setContactsList(Set<TblContacts> contactsList) {
		this.contactsList = contactsList;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clientId", cascade = CascadeType.ALL)
	public Set<TblProjects> getProjectList() {
		return projectList;
	}

	public void setProjectList(Set<TblProjects> projectList) {
		this.projectList = projectList;
	}
}
