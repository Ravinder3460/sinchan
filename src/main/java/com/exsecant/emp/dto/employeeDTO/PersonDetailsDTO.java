package com.exsecant.emp.dto.employeeDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonDetailsDTO implements Serializable {

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
	private List<JobDetailsDTO> jobDetailsList = new ArrayList<>(0);
	private List<FunctionDetailsDTO> functionDetailsList = new ArrayList<>(0);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<JobDetailsDTO> getJobDetailsList() {
		return jobDetailsList;
	}

	public void setJobDetailsList(List<JobDetailsDTO> jobDetailsList) {
		this.jobDetailsList = jobDetailsList;
	}

	public List<FunctionDetailsDTO> getFunctionDetailsList() {
		return functionDetailsList;
	}

	public void setFunctionDetailsList(List<FunctionDetailsDTO> functionDetailsList) {
		this.functionDetailsList = functionDetailsList;
	}

}
