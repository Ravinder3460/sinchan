package com.exsecant.emp.entity.employee;

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
@Table(name = "Table_PersonDetails")
public class TblPersonalDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String firstName;
	private String lastName;
	private String permanentAddress;
	private String contactAddress;
	private String contactDetails;
	private String dob;
	private String gender;
	private Set<TblJobDetails> jobDetailsList = new HashSet<>();
	private Set<TblFunctionalDetails> functionalDetailsList = new HashSet<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "FirstName", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LastName", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "PermanentAddress", nullable = false)
	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@Column(name = "ContactAddress", nullable = false)
	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	@Column(name = "ContactDetails", nullable = false)
	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	@Column(name = "Dob", nullable = false)
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Column(name = "Gender", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "personDetailsId", cascade = CascadeType.ALL)
	public Set<TblJobDetails> getJobDetailsList() {
		return jobDetailsList;
	}

	public void setJobDetailsList(Set<TblJobDetails> jobDetailsList) {
		this.jobDetailsList = jobDetailsList;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "personDetailsId", cascade = CascadeType.ALL)
	public Set<TblFunctionalDetails> getFunctionalDetailsList() {
		return functionalDetailsList;
	}

	public void setFunctionalDetailsList(Set<TblFunctionalDetails> functionalDetailsList) {
		this.functionalDetailsList = functionalDetailsList;
	}

}
