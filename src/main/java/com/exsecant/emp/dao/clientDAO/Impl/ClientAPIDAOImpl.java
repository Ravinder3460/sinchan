package com.exsecant.emp.dao.clientDAO.Impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.exsecant.emp.dao.clientDAO.ClientAPIDAO;
import com.exsecant.emp.entity.client.TblClient;

@Repository("clientAPIdao")
public class ClientAPIDAOImpl implements ClientAPIDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientAPIDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TblClient addClient(TblClient tblClient) {

		Session sessionObj = null;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			int addClientValue = (int) sessionObj.save(tblClient);

			if (addClientValue > 0) {
				System.out.println("Client added Successfully");
				LOGGER.info("You are successfully created");
				sessionObj.beginTransaction().commit();
				return tblClient;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TblClient> getClientRecords() {
		LOGGER.info("You are going to fetch the data from the database");
		Session sessionObj = null;
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();
			return sessionObj.createCriteria(TblClient.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@Override
	public TblClient getClientRecord(int clientId) {
		Session sessionObj = null;
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			@SuppressWarnings("unchecked")
			List<TblClient> dataList = sessionObj.createQuery("from TblClient where id=" + clientId).list();

			return dataList != null && !dataList.isEmpty() ? dataList.get(0) : null;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return null;
	}

	@Override
	public boolean deleteClientRecord(int clientId) {

		@SuppressWarnings("unused")

		boolean isdeleted = false;
		Session sessionObj = null;
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			TblClient deletedClientId = sessionObj.get(TblClient.class, clientId);

			if (deletedClientId != null) {
				sessionObj.delete(deletedClientId);
				System.out.println("You are successfully deleted your data");
				sessionObj.beginTransaction().commit();
				return true;
			}
			/*
			 * <------------------------------------ HQL QUERY
			 * ------------------------------------------->
			 * 
			 * / Query query = sessionObj.
			 * createQuery("delete TblContacts t where t.client.id= :id121");
			 * query.setParameter("id121", clientId); int result =
			 * query.executeUpdate();
			 * 
			 * if (result > 0) { System.out.
			 * println("all the contacts associated with the clients has been deleted"
			 * ); }
			 * 
			 * query =
			 * sessionObj.createQuery("delete TblClient where id = :clientId121"
			 * ); query.setParameter("clientId121", clientId); result =
			 * query.executeUpdate();
			 * 
			 * if (result > 0) {
			 * System.out.println("Client deleted Successfully"); isdeleted =
			 * true; sessionObj.beginTransaction().commit(); }
			 * 
			 * <-------------------------------- END HQL QUERY
			 * --------------------------------------------->
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return false;
	}

	@Override
	public TblClient updateClientRecord(TblClient tblClient) {

		Session sessionObj = null;
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			sessionObj.update(tblClient);
			System.out.println("Client has been updated successfully");
			sessionObj.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return tblClient;
	}

	@Override
	public Boolean clientExist(int clientId) {

		Session sessionObj = null;
		@SuppressWarnings("unused")
		Boolean isClientExist = false;

		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();

			TblClient existingClientId = sessionObj.get(TblClient.class, clientId);

			if (existingClientId != null) {
				sessionObj.beginTransaction().commit();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
		return false;
	}
}
