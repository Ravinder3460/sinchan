package com.exsecant.emp.service.projectService;

import java.util.List;

import com.exsecant.emp.dto.projectDTO.ProjectDTO;

public interface ProjectAPIService {

	ProjectDTO createProject(ProjectDTO projectDTO);

	ProjectDTO updateProject(ProjectDTO projectDTO);

	ProjectDTO getProjectRecord(long projectId);

	List<ProjectDTO> getProjectRecords();

	ProjectDTO deleteProject(long projectId);

}
