package com.exsecant.emp.controller.projectAPIController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exsecant.emp.dto.projectDTO.ProjectDTO;
import com.exsecant.emp.service.projectService.ProjectAPIService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectAPIController {

	@Autowired
	private ProjectAPIService projectAPIService;

	@PostMapping("/project")
	public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
		return projectAPIService.createProject(projectDTO);
	}

	@PutMapping("/project")
	public ProjectDTO updateProject(@RequestBody ProjectDTO projectDTO) {
		return projectAPIService.updateProject(projectDTO);
	}

	@GetMapping("/project/{project-Id}")
	public ProjectDTO getProjectRecord(@PathVariable("project-Id") long projectId) {
		return projectAPIService.getProjectRecord(projectId);
	}

	@GetMapping("/Project")
	public List<ProjectDTO> getProjectRecords() {
		return projectAPIService.getProjectRecords();
	}

	@DeleteMapping("/project/{project-Id}")
	public ProjectDTO deleteProject(@PathVariable("project-Id") long projectId) {
		return projectAPIService.deleteProject(projectId);
	}
}
