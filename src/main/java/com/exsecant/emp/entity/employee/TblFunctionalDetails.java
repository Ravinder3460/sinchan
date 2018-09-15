package com.exsecant.emp.entity.employee;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Table_FunctionDetails")
public class TblFunctionalDetails implements Serializable {

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
	private TblPersonalDetails personDetailsId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "Email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "uploadDocument", nullable = false)
	public String getUploadDocument() {
		return uploadDocument;
	}

	public void setUploadDocument(String uploadDocument) {
		this.uploadDocument = uploadDocument;
	}

	@Column(name = "documentSubmitted", nullable = false)
	public String getDocumentSubmitted() {
		return documentSubmitted;
	}

	public void setDocumentSubmitted(String documentSubmitted) {
		this.documentSubmitted = documentSubmitted;
	}

	@Column(name = "Role", nullable = false)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "EmergencyContactNumber", nullable = false)
	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	@ManyToOne
	@JoinColumn(name = "personId", nullable = false)
	public TblPersonalDetails getPersonDetailsId() {
		return personDetailsId;
	}

	public void setPersonDetailsId(TblPersonalDetails personDetailsId) {
		this.personDetailsId = personDetailsId;
	}

}
