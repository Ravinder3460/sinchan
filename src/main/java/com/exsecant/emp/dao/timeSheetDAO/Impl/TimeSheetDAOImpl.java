package com.exsecant.emp.dao.timeSheetDAO.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exsecant.emp.dao.timeSheetDAO.TimeSheetDAO;
import com.exsecant.emp.entity.timeSheet.TblTimeSheet;

@Repository("timeSheetDAO")
public class TimeSheetDAOImpl implements TimeSheetDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TblTimeSheet createTimeSheet(TblTimeSheet dbTimeSheet) {
		Session sessionObj = null;
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			long createdTimeSheetId = (long) sessionObj.save(dbTimeSheet);

			if (createdTimeSheetId > 0) {

				System.out.println("You are successfully created new TimeSheet");
				sessionObj.beginTransaction().commit();
				return dbTimeSheet;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@Override
	public TblTimeSheet updateTimeSheet(TblTimeSheet dbTimeSheet) {
		Session sessionObj = null;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			sessionObj.update(dbTimeSheet);
			System.out.println("You are successfully updated your data");
			sessionObj.beginTransaction().commit();
			return dbTimeSheet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TblTimeSheet getTimeSheetRecord(long timeSheetId) {
		Session sessionObj = null;
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			TblTimeSheet dbTimeSheetRecord = sessionObj.get(TblTimeSheet.class, timeSheetId);
			System.out.println("You are successfully getting your data");

			sessionObj.beginTransaction().commit();
			return dbTimeSheetRecord;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@Override
	public Boolean deleteTimeSheet(long deletedTimeSheetId) {

		Session sessionObj = null;
		@SuppressWarnings("unused")
		boolean isDeleted = false;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			TblTimeSheet deletedTimeSheet = sessionObj.get(TblTimeSheet.class, deletedTimeSheetId);

			if (deletedTimeSheet != null) {
				sessionObj.delete(deletedTimeSheet);
				System.out.println("You are successfully delete our data");
				sessionObj.beginTransaction().commit();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TblTimeSheet> getTimeSheetRecords() {
		Session sessionObj = null;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			@SuppressWarnings("unchecked")
			List<TblTimeSheet> timesheetList = sessionObj.createCriteria(TblTimeSheet.class).list();
			System.out.println("You are getting all Timesheet Records");

			return timesheetList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@Override
	public Boolean timeSheetExist(long timeSheetId) {

		@SuppressWarnings("unused")
		Boolean isTimeSheetExist = false;
		Session sessionObj = null;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			TblTimeSheet timeSheetRecordExist = sessionObj.get(TblTimeSheet.class, timeSheetId);

			if (timeSheetRecordExist != null) {
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
}
