package com.exsecant.emp.entity.timeSheet;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tbl_TimeSheet")
public class TblTimeSheet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String project;
	private String task;
	private String inputAsTimeInterval;
	private String inputAsDuration;
	private String discription;
	private String user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "Project", nullable = false)
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@Column(name = "Task", nullable = false)
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Column(name = "Time_Interval", nullable = false)
	public String getInputAsTimeInterval() {
		return inputAsTimeInterval;
	}

	public void setInputAsTimeInterval(String inputAsTimeInterval) {
		this.inputAsTimeInterval = inputAsTimeInterval;
	}

	@Column(name = "Duration", nullable = false)
	public String getInputAsDuration() {
		return inputAsDuration;
	}

	public void setInputAsDuration(String inputAsDuration) {
		this.inputAsDuration = inputAsDuration;
	}

	@Column(name = "Discription", nullable = false)
	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Column(name = "User", nullable = false)
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
