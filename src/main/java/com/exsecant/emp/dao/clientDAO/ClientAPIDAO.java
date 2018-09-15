package com.exsecant.emp.dao.clientDAO;

import java.util.List;

import com.exsecant.emp.entity.client.TblClient;

public interface ClientAPIDAO {

	TblClient addClient(TblClient tblClient);

	List<TblClient> getClientRecords();

	TblClient getClientRecord(int clientId);

	boolean deleteClientRecord(int clientId);

	TblClient updateClientRecord(TblClient tblClient);

	Boolean clientExist(int clientId);

}
