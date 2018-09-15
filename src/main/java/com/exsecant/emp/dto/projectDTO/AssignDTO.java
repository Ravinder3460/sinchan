package com.exsecant.emp.dto.projectDTO;

import java.io.Serializable;

public class AssignDTO implements Serializable {

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

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getTimeAllocated() {
		return timeAllocated;
	}

	public void setTimeAllocated(String timeAllocated) {
		this.timeAllocated = timeAllocated;
	}

	public String getAssignUser() {
		return assignUser;
	}

	public void setAssignUser(String assignUser) {
		this.assignUser = assignUser;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

}
