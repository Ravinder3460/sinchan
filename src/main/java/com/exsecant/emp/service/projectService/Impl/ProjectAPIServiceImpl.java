package com.exsecant.emp.service.projectService.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exsecant.emp.dao.projectDAO.ProjectAPIDAO;
import com.exsecant.emp.dto.projectDTO.AssignDTO;
import com.exsecant.emp.dto.projectDTO.ProjectDTO;
import com.exsecant.emp.entity.project.TblAssign;
import com.exsecant.emp.entity.project.TblProject;
import com.exsecant.emp.service.projectService.ProjectAPIService;

@Service("projectAPIService")
public class ProjectAPIServiceImpl implements ProjectAPIService {

	@Autowired
	private ProjectAPIDAO projectAPIDao;

	@Override
	public ProjectDTO createProject(ProjectDTO projectDTO) {

		TblProject dbTblProject = new TblProject();

		dbTblProject.setId(projectDTO.getId());
		dbTblProject.setProjectName(projectDTO.getProjectName());
		dbTblProject.setProjectDescription(projectDTO.getProjectDescription());
		dbTblProject.setProjectType(projectDTO.getProjectType());
		dbTblProject.setProjectStatus(projectDTO.getProjectStatus());
		dbTblProject.setClient(projectDTO.getClient());
		dbTblProject.setKeywords(projectDTO.getKeywords());

		AssignDTO assignDTO = projectDTO.getAssignRecord();
		TblAssign tblAssign = new TblAssign();

		tblAssign.setId(assignDTO.getId());
		tblAssign.setStartDate(assignDTO.getStartDate());
		tblAssign.setDueDate(assignDTO.getDueDate());
		tblAssign.setTimeAllocated(assignDTO.getTimeAllocated());
		tblAssign.setAssignUser(assignDTO.getAssignUser());
		tblAssign.setReportingManager(assignDTO.getReportingManager());
		tblAssign.setAttachments(assignDTO.getAttachments());
		tblAssign.setProjectId(dbTblProject);
		dbTblProject.setAssignRecord(tblAssign);

		TblProject dbProjectObj = projectAPIDao.createProject(dbTblProject);
		ProjectDTO projectDTOToReturn = new ProjectDTO();

		projectDTOToReturn.setId(dbProjectObj.getId());
		projectDTOToReturn.setProjectName(dbProjectObj.getProjectName());
		projectDTOToReturn.setProjectDescription(dbProjectObj.getProjectDescription());
		projectDTOToReturn.setProjectType(dbProjectObj.getProjectType());
		projectDTOToReturn.setProjectStatus(dbProjectObj.getProjectStatus());
		projectDTOToReturn.setClient(dbProjectObj.getClient());
		projectDTOToReturn.setKeywords(dbProjectObj.getKeywords());

		TblAssign tblAssignObj = dbProjectObj.getAssignRecord();
		AssignDTO assignDTOToReturn = new AssignDTO();

		assignDTOToReturn.setId(tblAssignObj.getId());
		assignDTOToReturn.setStartDate(tblAssignObj.getStartDate());
		assignDTOToReturn.setDueDate(tblAssignObj.getDueDate());
		assignDTOToReturn.setTimeAllocated(tblAssignObj.getTimeAllocated());
		assignDTOToReturn.setAssignUser(tblAssignObj.getAssignUser());
		assignDTOToReturn.setReportingManager(tblAssignObj.getReportingManager());
		assignDTOToReturn.setAttachments(tblAssignObj.getAttachments());
		projectDTOToReturn.setAssignRecord(assignDTOToReturn);

		return projectDTOToReturn;
	}

	@Override
	public ProjectDTO updateProject(ProjectDTO projectDTO) {

		TblProject dbTblProject = new TblProject();
		
		dbTblProject.setId(projectDTO.getId());
		dbTblProject.setProjectName(projectDTO.getProjectName());
		dbTblProject.setProjectDescription(projectDTO.getProjectDescription());
		dbTblProject.setProjectType(projectDTO.getProjectType());
		dbTblProject.setProjectStatus(projectDTO.getProjectStatus());
		dbTblProject.setClient(projectDTO.getClient());
		dbTblProject.setKeywords(projectDTO.getKeywords());

		AssignDTO assignDTO = projectDTO.getAssignRecord();
		TblAssign tblAssign = new TblAssign();
		
		tblAssign.setId(assignDTO.getId());
		tblAssign.setStartDate(assignDTO.getStartDate());
		tblAssign.setDueDate(assignDTO.getDueDate());
		tblAssign.setTimeAllocated(assignDTO.getTimeAllocated());
		tblAssign.setAssignUser(assignDTO.getAssignUser());
		tblAssign.setReportingManager(assignDTO.getReportingManager());
		tblAssign.setAttachments(assignDTO.getAttachments());
		tblAssign.setProjectId(dbTblProject);
		dbTblProject.setAssignRecord(tblAssign);
		TblProject dbProjectObj = projectAPIDao.updateProject(dbTblProject);

		ProjectDTO projectDTOToReturn = new ProjectDTO();
		projectDTOToReturn.setId(dbProjectObj.getId());
		projectDTOToReturn.setProjectName(dbProjectObj.getProjectName());
		projectDTOToReturn.setProjectDescription(dbProjectObj.getProjectDescription());
		projectDTOToReturn.setProjectType(dbProjectObj.getProjectType());
		projectDTOToReturn.setProjectStatus(dbProjectObj.getProjectStatus());
		projectDTOToReturn.setClient(dbProjectObj.getClient());
		projectDTOToReturn.setKeywords(dbProjectObj.getKeywords());

		TblAssign tblAssignObj = dbProjectObj.getAssignRecord();
		AssignDTO assignDTOToReturn = new AssignDTO();

		assignDTOToReturn.setId(tblAssign.getId());
		assignDTOToReturn.setStartDate(tblAssignObj.getStartDate());
		assignDTOToReturn.setDueDate(tblAssignObj.getDueDate());
		assignDTOToReturn.setTimeAllocated(tblAssignObj.getTimeAllocated());
		assignDTOToReturn.setAssignUser(tblAssignObj.getAssignUser());
		assignDTOToReturn.setReportingManager(tblAssignObj.getReportingManager());
		assignDTOToReturn.setAttachments(tblAssignObj.getAttachments());
		projectDTOToReturn.setAssignRecord(assignDTOToReturn);
		return projectDTOToReturn;
	}

	@Override
	public ProjectDTO getProjectRecord(long projectId) {

		Boolean isProjectExistId = projectAPIDao.projectExist(projectId);
		ProjectDTO projectDTOToReturn = new ProjectDTO();

		if (isProjectExistId) {
			TblProject dbProjectObj = projectAPIDao.getProjectRecord(projectId);
			projectDTOToReturn.setId(dbProjectObj.getId());
			projectDTOToReturn.setProjectName(dbProjectObj.getProjectName());
			projectDTOToReturn.setProjectDescription(dbProjectObj.getProjectDescription());
			projectDTOToReturn.setProjectType(dbProjectObj.getProjectType());
			projectDTOToReturn.setProjectStatus(dbProjectObj.getProjectStatus());
			projectDTOToReturn.setClient(dbProjectObj.getClient());
			projectDTOToReturn.setKeywords(dbProjectObj.getKeywords());

			TblAssign tblAssignObj = dbProjectObj.getAssignRecord();
			AssignDTO assignDTOToReturn = new AssignDTO();

			assignDTOToReturn.setId(tblAssignObj.getId());
			assignDTOToReturn.setStartDate(tblAssignObj.getStartDate());
			assignDTOToReturn.setDueDate(tblAssignObj.getDueDate());
			assignDTOToReturn.setTimeAllocated(tblAssignObj.getTimeAllocated());
			assignDTOToReturn.setAssignUser(tblAssignObj.getAssignUser());
			assignDTOToReturn.setReportingManager(tblAssignObj.getReportingManager());
			assignDTOToReturn.setAttachments(tblAssignObj.getAttachments());
			projectDTOToReturn.setAssignRecord(assignDTOToReturn);
		} else {

		}
		return projectDTOToReturn;
	}

	@Override
	public List<ProjectDTO> getProjectRecords() {

		List<TblProject> dbProjectList = projectAPIDao.getProjectRecords();

		@SuppressWarnings("unused")
		List<ProjectDTO> projectDTOList = new ArrayList<>();
		for (TblProject projectList : dbProjectList) {

			ProjectDTO projectDTO = new ProjectDTO();
			projectDTO.setId(projectList.getId());
			projectDTO.setProjectName(projectList.getProjectName());
			projectDTO.setProjectDescription(projectList.getProjectDescription());
			projectDTO.setProjectType(projectList.getProjectType());
			projectDTO.setProjectStatus(projectList.getProjectStatus());
			projectDTO.setClient(projectList.getClient());
			projectDTO.setKeywords(projectList.getKeywords());

			AssignDTO assignDTO = new AssignDTO();

			assignDTO.setId(projectList.getAssignRecord().getId());
			assignDTO.setStartDate(projectList.getAssignRecord().getStartDate());
			assignDTO.setDueDate(projectList.getAssignRecord().getDueDate());
			assignDTO.setTimeAllocated(projectList.getAssignRecord().getTimeAllocated());
			assignDTO.setAssignUser(projectList.getAssignRecord().getAssignUser());
			assignDTO.setReportingManager(projectList.getAssignRecord().getReportingManager());
			assignDTO.setAttachments(projectList.getAssignRecord().getAttachments());

			projectDTO.setAssignRecord(assignDTO);
			projectDTOList.add(projectDTO);
		}

		return projectDTOList;
	}

	@Override
	public ProjectDTO deleteProject(long projectId) {

		TblProject dbProjectObj = projectAPIDao.getProjectRecord(projectId);

		Boolean deletedProjectId = projectAPIDao.deleteProject(projectId);

		ProjectDTO projectDTOToReturn = new ProjectDTO();
		if (deletedProjectId) {
			projectDTOToReturn.setId(dbProjectObj.getId());
			projectDTOToReturn.setProjectName(dbProjectObj.getProjectName());
			projectDTOToReturn.setProjectDescription(dbProjectObj.getProjectDescription());
			projectDTOToReturn.setProjectType(dbProjectObj.getProjectType());
			projectDTOToReturn.setProjectStatus(dbProjectObj.getProjectStatus());
			projectDTOToReturn.setClient(dbProjectObj.getClient());
			projectDTOToReturn.setKeywords(dbProjectObj.getKeywords());

			TblAssign dbAssignObj = dbProjectObj.getAssignRecord();
			AssignDTO assignDTOToReturn = new AssignDTO();
			
			assignDTOToReturn.setId(dbAssignObj.getId());
			assignDTOToReturn.setStartDate(dbAssignObj.getStartDate());
			assignDTOToReturn.setDueDate(dbAssignObj.getDueDate());
			assignDTOToReturn.setTimeAllocated(dbAssignObj.getTimeAllocated());
			assignDTOToReturn.setAssignUser(dbAssignObj.getAssignUser());
			assignDTOToReturn.setReportingManager(dbAssignObj.getReportingManager());
			assignDTOToReturn.setAttachments(dbAssignObj.getAttachments());
			projectDTOToReturn.setAssignRecord(assignDTOToReturn);
		} else {

		}
		return projectDTOToReturn;
	}
}
