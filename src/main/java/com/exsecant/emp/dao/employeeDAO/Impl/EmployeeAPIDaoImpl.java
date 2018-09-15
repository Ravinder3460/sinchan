package com.exsecant.emp.dao.employeeDAO.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.exsecant.emp.dao.employeeDAO.EmployeeAPIDAO;
import com.exsecant.emp.entity.employee.TblPersonalDetails;

@Repository("employeeAPIDao")
public class EmployeeAPIDaoImpl implements EmployeeAPIDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TblPersonalDetails saveEmployee(TblPersonalDetails tblPeraonDetails) {

		Session sessionObj = null;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			long createdEmployeeId = (long) sessionObj.save(tblPeraonDetails);

			if (createdEmployeeId > 0) {
				System.out.println("You are successfully created your Employee");
				sessionObj.beginTransaction().commit();
				return tblPeraonDetails;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@Override
	public TblPersonalDetails updateEmployee(TblPersonalDetails tblPerson) {

		Session sessionObj = null;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			sessionObj.update(tblPerson);
			System.out.println("You are successfully updated your data");
			sessionObj.beginTransaction().commit();
			return tblPerson;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@Override
	public Boolean employeeExist(long employeeId) {
		@SuppressWarnings("unused")
		Boolean isEmployeeExist = false;
		Session sessionObj = null;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			TblPersonalDetails EmployeeExistingId = sessionObj.get(TblPersonalDetails.class, employeeId);

			if (EmployeeExistingId != null) {
				System.out.println("Your data is found");
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
	public TblPersonalDetails getEmployee(long employeeId) {
		Session sessionObj = null;
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			TblPersonalDetails employeeRecords = sessionObj.get(TblPersonalDetails.class, employeeId);

			System.out.println("You are getting your data");
			sessionObj.beginTransaction().commit();
			return employeeRecords;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean deletedEmployee(long employeeId) {
		@SuppressWarnings("unused")
		Boolean isDeletedEmployeeExist = false;
		Session sessionObj = null;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			TblPersonalDetails deletedEmployeeExistingId = sessionObj.get(TblPersonalDetails.class, employeeId);

			if (deletedEmployeeExistingId != null) {
				sessionObj.delete(deletedEmployeeExistingId);
				System.out.println("You are successfully deleted your data");
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
	public List<TblPersonalDetails> getEmployeeRecords() {

		Session sessionObj = null;
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();
			@SuppressWarnings("unchecked")
			List<TblPersonalDetails> personDetailsRecord = sessionObj.createCriteria(TblPersonalDetails.class).list();

			System.out.println("You are getting all records");
			sessionObj.beginTransaction().commit();
			return personDetailsRecord;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
