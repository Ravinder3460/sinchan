package com.exsecant.emp.dto.employeeDTO;

import java.io.Serializable;

public class FunctionDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String email;
	private String password;
	private String uploadDocument;
	private String documentSubmitted;
	private String role;
	private String emergencyContactNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUploadDocument() {
		return uploadDocument;
	}

	public void setUploadDocument(String uploadDocument) {
		this.uploadDocument = uploadDocument;
	}

	public String getDocumentSubmitted() {
		return documentSubmitted;
	}

	public void setDocumentSubmitted(String documentSubmitted) {
		this.documentSubmitted = documentSubmitted;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

}
