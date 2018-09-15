package com.exsecant.emp.dto.timeSheetDTO;

import java.io.Serializable;

public class TimeSheetDTO implements Serializable {

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getInputAsTimeInterval() {
		return inputAsTimeInterval;
	}

	public void setInputAsTimeInterval(String inputAsTimeInterval) {
		this.inputAsTimeInterval = inputAsTimeInterval;
	}

	public String getInputAsDuration() {
		return inputAsDuration;
	}

	public void setInputAsDuration(String inputAsDuration) {
		this.inputAsDuration = inputAsDuration;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
