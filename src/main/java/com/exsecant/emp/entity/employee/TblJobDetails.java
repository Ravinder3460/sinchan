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
@Table(name = "Table_JobDetails")
public class TblJobDetails implements Serializable {

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
	private TblPersonalDetails personDetailsId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "Job_Title")
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name = "TeamAssign", nullable = false)
	public String getTeamAsign() {
		return teamAsign;
	}

	public void setTeamAsign(String teamAsign) {
		this.teamAsign = teamAsign;
	}

	@Column(name = "ReportingManger", nullable = false)
	public String getReportingMangaer() {
		return reportingMangaer;
	}

	public void setReportingMangaer(String reportingMangaer) {
		this.reportingMangaer = reportingMangaer;
	}

	@Column(name = "TypeOfEmployement", nullable = false)
	public String getTypeOfEmployement() {
		return typeOfEmployement;
	}

	public void setTypeOfEmployement(String typeOfEmployement) {
		this.typeOfEmployement = typeOfEmployement;
	}

	@Column(name = "EmployeeStatus", nullable = false)
	public String getEmployeementStatus() {
		return employeementStatus;
	}

	public void setEmployeementStatus(String employeementStatus) {
		this.employeementStatus = employeementStatus;
	}

	@Column(name = "DateOfJoining", nullable = false)
	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	@Column(name = "Emloyee_InTime", nullable = false)
	public String getEmployeeInTime() {
		return employeeInTime;
	}

	public void setEmployeeInTime(String employeeInTime) {
		this.employeeInTime = employeeInTime;
	}

	@Column(name = "Employee_OutTime", nullable = false)
	public String getEmployeeOutTime() {
		return employeeOutTime;
	}

	public void setEmployeeOutTime(String employeeOutTime) {
		this.employeeOutTime = employeeOutTime;
	}

	@ManyToOne
	@JoinColumn(name = "PersonId", nullable = false)
	public TblPersonalDetails getPersonDetailsId() {
		return personDetailsId;
	}

	public void setPersonDetailsId(TblPersonalDetails personDetailsId) {
		this.personDetailsId = personDetailsId;
	}

}
