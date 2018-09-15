package com.exsecant.emp.dao.projectDAO;

import java.util.List;

import com.exsecant.emp.entity.project.TblProject;

public interface ProjectAPIDAO {

	TblProject createProject(TblProject dbTblProject);

	TblProject updateProject(TblProject dbTblProject);

	TblProject getProjectRecord(long projectId);

	Boolean deleteProject(long projectId);

	List<TblProject> getProjectRecords();

	Boolean projectExist(long projectId);

}
