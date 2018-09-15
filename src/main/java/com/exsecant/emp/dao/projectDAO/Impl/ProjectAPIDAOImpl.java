package com.exsecant.emp.dao.projectDAO.Impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exsecant.emp.dao.projectDAO.ProjectAPIDAO;
import com.exsecant.emp.entity.project.TblProject;

@Repository("projectAPIDao")
public class ProjectAPIDAOImpl implements ProjectAPIDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TblProject createProject(TblProject dbTblProject) {

		Session sessionObj = null;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			long createdProjectId = (long) sessionObj.save(dbTblProject);

			if (createdProjectId > 0) {
				System.out.println("You are successfully created new Employee");
				sessionObj.beginTransaction().commit();
				return dbTblProject;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}

		return null;
	}

	@Override
	public TblProject updateProject(TblProject dbTblProject) {

		Session sessionObj = null;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			sessionObj.update(dbTblProject);
			System.out.println("You are successfully updated your data");
			sessionObj.beginTransaction().commit();

			return dbTblProject;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@Override
	public TblProject getProjectRecord(long projectId) {

		Session sessionObj = null;
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			TblProject tblProjectObj = sessionObj.get(TblProject.class, projectId);

			System.out.println("You are getting Project Record");
			sessionObj.beginTransaction().commit();
			return tblProjectObj;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@Override
	public Boolean deleteProject(long projectId) {
		@SuppressWarnings("unused")
		boolean isDeleted = false;
		Session sessionObj = null;
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			TblProject isDeletedId = sessionObj.get(TblProject.class, projectId);

			if (isDeletedId != null) {
				sessionObj.delete(isDeletedId);
				System.out.println("You are successfully deleted your Project");
				sessionObj.beginTransaction().commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@Override
	public List<TblProject> getProjectRecords() {
		Session sessionObj = null;
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();
			@SuppressWarnings("unchecked")
			List<TblProject> projectList = sessionObj.createCriteria(TblProject.class).list();
			System.out.println("You are successfully getting the project list");
			return projectList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@Override
	public Boolean projectExist(long projectId) {

		@SuppressWarnings("unused")
		boolean isProjectExist = false;
		Session sessionObj = null;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			TblProject existingProjectId = sessionObj.get(TblProject.class, projectId);

			if (existingProjectId != null) {
				System.out.println("Your data is found");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}

		return null;
	}

}
