package com.exsecant.emp.entity.project;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tbl_AssignProject")
public class TblProject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String projectName;
	private String projectDescription;
	private String projectType;
	private String projectStatus;
	private String client;
	private String keywords;
	private TblAssign assignRecord;

	public TblProject() {
		// TODO Auto-generated constructor stub
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

	@Column(name = "Client", nullable = false)
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Column(name = "Keywords", nullable = false)
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "projectId", cascade = CascadeType.ALL)
	public TblAssign getAssignRecord() {
		return assignRecord;
	}

	public void setAssignRecord(TblAssign assignRecord) {
		this.assignRecord = assignRecord;
	}

}
