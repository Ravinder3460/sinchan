package com.exsecant.emp.entity.project;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Tbl_ProjectAssign")
public class TblAssign implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String startDate;
	private String dueDate;
	private String timeAllocated;
	private String assignUser;
	private String reportingManager;
	private String attachments;
	private TblProject projectId;

	public TblAssign() {
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

	@Column(name = "Start_Date", nullable = false)
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Column(name = "Due_Date", nullable = false)
	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "Time_Allocated", nullable = false)
	public String getTimeAllocated() {
		return timeAllocated;
	}

	public void setTimeAllocated(String timeAllocated) {
		this.timeAllocated = timeAllocated;
	}

	@Column(name = "Assign_User", nullable = false)
	public String getAssignUser() {
		return assignUser;
	}

	public void setAssignUser(String assignUser) {
		this.assignUser = assignUser;
	}

	@Column(name = "Reporting_Manager", nullable = false)
	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	@Column(name = "Attachments")
	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public TblProject getProjectId() {
		return projectId;
	}

	public void setProjectId(TblProject projectId) {
		this.projectId = projectId;
	}

}
