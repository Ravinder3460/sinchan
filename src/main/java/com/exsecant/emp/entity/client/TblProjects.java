package com.exsecant.emp.entity.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Project_Table")
public class TblProjects {
	private long id;
	private String projectName;
	private String projectDescription;
	private String projectType;
	private String projectStatus;
	private String attachments;
	private String keywords;
	private TblClient clientId;

	public TblProjects() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "Project_Name", nullable = false)
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "Project_Description", nullable = false)
	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	@Column(name = "Project_Type", nullable = false)
	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	@Column(name = "Project_Status", nullable = false)
	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	@Column(name = "Attachments", nullable = false)
	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	@Column(name = "Keywords", nullable = false)
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	@ManyToOne
	@JoinColumn(name ="Client_Id", nullable = false)
	public TblClient getClientId() {
		return clientId;
	}

	public void setClientId(TblClient clientId) {
		this.clientId = clientId;
	}

}
