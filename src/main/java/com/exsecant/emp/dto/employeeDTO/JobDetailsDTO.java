package com.exsecant.emp.dto.employeeDTO;

import java.io.Serializable;

public class JobDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String jobTitle;
	private String teamAsign;
	private String reportingMangaer;
	private String typeOfEmployement;
	private String employeementStatus;
	private String doj;
	private String employeeInTime;
	private String employeeOutTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getTeamAsign() {
		return teamAsign;
	}

	public void setTeamAsign(String teamAsign) {
		this.teamAsign = teamAsign;
	}

	public String getReportingMangaer() {
		return reportingMangaer;
	}

	public void setReportingMangaer(String reportingMangaer) {
		this.reportingMangaer = reportingMangaer;
	}

	public String getTypeOfEmployement() {
		return typeOfEmployement;
	}

	public void setTypeOfEmployement(String typeOfEmployement) {
		this.typeOfEmployement = typeOfEmployement;
	}

	public String getEmployeementStatus() {
		return employeementStatus;
	}

	public void setEmployeementStatus(String employeementStatus) {
		this.employeementStatus = employeementStatus;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getEmployeeInTime() {
		return employeeInTime;
	}

	public void setEmployeeInTime(String employeeInTime) {
		this.employeeInTime = employeeInTime;
	}

	public String getEmployeeOutTime() {
		return employeeOutTime;
	}

	public void setEmployeeOutTime(String employeeOutTime) {
		this.employeeOutTime = employeeOutTime;
	}

}
