package com.exsecant.emp.service.clientService.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.exsecant.emp.dao.clientDAO.ClientAPIDAO;
import com.exsecant.emp.dto.clientDTO.ClientDTO;
import com.exsecant.emp.dto.clientDTO.ContactsDTO;
import com.exsecant.emp.dto.clientDTO.ProjectsDTO;
import com.exsecant.emp.entity.client.TblClient;
import com.exsecant.emp.entity.client.TblContacts;
import com.exsecant.emp.entity.client.TblProjects;
import com.exsecant.emp.service.clientService.ClientAPIService;

@Service("clientAPIService")
public class ClientAPIServiceImpl implements ClientAPIService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientAPIServiceImpl.class);

	@Autowired
	private ClientAPIDAO clientAPIdao;

	@Transactional
	@Override
	public ClientDTO addClient(ClientDTO clientDTO) {

		TblClient tblClient = new TblClient();
		tblClient.setId(clientDTO.getId());
		tblClient.setCompanyName(clientDTO.getCompanyName());
		tblClient.setAddress(clientDTO.getAddress());
		tblClient.setCity(clientDTO.getCity());
		tblClient.setState(clientDTO.getState());
		tblClient.setZip(clientDTO.getZip());
		tblClient.setCountry(clientDTO.getCountry());
		tblClient.setPhone(clientDTO.getPhone());
		tblClient.setWebsite(clientDTO.getWebsite());

		List<ContactsDTO> contactDTOList = clientDTO.getContactList();
		Set<TblContacts> tblContactList = new HashSet<>();

		for (ContactsDTO contactList : contactDTOList) {

			TblContacts dbcontact = new TblContacts();

			dbcontact.setName(contactList.getName());
			dbcontact.setDesignation(contactList.getDesignation());
			dbcontact.setPhone(contactList.getPhone());
			dbcontact.setEmail(contactList.getEmail());
			dbcontact.setLocation(contactList.getLocation());
			dbcontact.setStatus(contactList.getStatus());
			dbcontact.setClientId(tblClient); // set the client Id in the
												// TblClient
			tblContactList.add(dbcontact);

		}

		List<ProjectsDTO> projectList = clientDTO.getProjectList();
		Set<TblProjects> tblProjects = new HashSet<>();

		for (ProjectsDTO projectsList : projectList) {

			TblProjects dbProjectList = new TblProjects();
			dbProjectList.setId(projectsList.getId());
			dbProjectList.setProjectName(projectsList.getProjectName());
			dbProjectList.setProjectStatus(projectsList.getProjectStatus());
			dbProjectList.setProjectType(projectsList.getProjectType());
			dbProjectList.setAttachments(projectsList.getAttachments());
			dbProjectList.setKeywords(projectsList.getKeywords());
			dbProjectList.setProjectDescription(projectsList.getProjectDescription());
			dbProjectList.setClientId(tblClient);

			tblProjects.add(dbProjectList);
		}

		tblClient.setContactsList(tblContactList);
		tblClient.setProjectList(tblProjects);
		LOGGER.info("You are going for add client in dao Layer");

		TblClient dbAddClient = clientAPIdao.addClient(tblClient);

		ClientDTO dbClientDto = new ClientDTO();
		dbClientDto.setId(dbAddClient.getId());
		dbClientDto.setCompanyName(dbAddClient.getCompanyName());
		dbClientDto.setAddress(dbAddClient.getAddress());
		dbClientDto.setCity(dbAddClient.getCity());
		dbClientDto.setState(dbAddClient.getState());
		dbClientDto.setZip(dbAddClient.getZip());
		dbClientDto.setCountry(dbAddClient.getCountry());
		dbClientDto.setPhone(dbAddClient.getPhone());
		dbClientDto.setWebsite(dbAddClient.getWebsite());

		Set<TblContacts> dbContactList = dbAddClient.getContactsList();
		List<ContactsDTO> dbcontactDTOList = new ArrayList<>();

		for (TblContacts dbContactDTO : dbContactList) {

			ContactsDTO contactDTO = new ContactsDTO();

			contactDTO.setId(dbContactDTO.getId());
			contactDTO.setName(dbContactDTO.getName());
			contactDTO.setDesignation(dbContactDTO.getDesignation());
			contactDTO.setPhone(dbContactDTO.getPhone());
			contactDTO.setEmail(dbContactDTO.getEmail());
			contactDTO.setLocation(dbContactDTO.getLocation());
			contactDTO.setStatus(dbContactDTO.getStatus());

			dbcontactDTOList.add(contactDTO);

		}

		Set<TblProjects> dbProjectsList = dbAddClient.getProjectList();
		List<ProjectsDTO> projectDTOToReturn = new ArrayList<>(0);

		for (TblProjects dbprojectList : dbProjectsList) {
			ProjectsDTO projectDTOList = new ProjectsDTO();

			projectDTOList.setId(dbprojectList.getId());
			projectDTOList.setProjectName(dbprojectList.getProjectName());
			projectDTOList.setProjectDescription(dbprojectList.getProjectDescription());
			projectDTOList.setProjectType(dbprojectList.getProjectType());
			projectDTOList.setProjectStatus(dbprojectList.getProjectStatus());
			projectDTOList.setAttachments(dbprojectList.getAttachments());
			projectDTOList.setKeywords(dbprojectList.getKeywords());
			projectDTOToReturn.add(projectDTOList);
		}

		dbClientDto.setContactList(dbcontactDTOList);
		dbClientDto.setProjectList(projectDTOToReturn);

		LOGGER.info("You are going for return the clientDTO to the controller");
		return dbClientDto;
	}

	@Transactional(readOnly = true)
	@Override
	public List<ClientDTO> getClientRecords() {
		LOGGER.info("You are going to get All records from service");
		List<TblClient> tblClientList = clientAPIdao.getClientRecords();

		List<ClientDTO> clientDTOToReturn = new ArrayList<>();

		for (TblClient tblClientObj : tblClientList) {

			ClientDTO clientDTO = new ClientDTO();
			clientDTO.setId(tblClientObj.getId());
			clientDTO.setCompanyName(tblClientObj.getCompanyName());
			clientDTO.setAddress(tblClientObj.getAddress());
			clientDTO.setCity(tblClientObj.getCity());
			clientDTO.setState(tblClientObj.getState());
			clientDTO.setZip(tblClientObj.getZip());
			clientDTO.setCountry(tblClientObj.getCountry());
			clientDTO.setPhone(tblClientObj.getPhone());
			clientDTO.setWebsite(tblClientObj.getWebsite());

			List<TblContacts> tblContactsList = new ArrayList<>(tblClientObj.getContactsList());
			List<ContactsDTO> contactsDTO = getContactsDTO(tblContactsList);

			List<TblProjects> tblProjectList = new ArrayList<TblProjects>(tblClientObj.getProjectList());
			List<ProjectsDTO> projectsDTO = getProjectsDTO(tblProjectList);

			clientDTO.setContactList(contactsDTO);
			clientDTO.setProjectList(projectsDTO);
			clientDTOToReturn.add(clientDTO);
		}
		LOGGER.info("You are return all the all the records from the database from service");
		return clientDTOToReturn;
	}

	private List<ProjectsDTO> getProjectsDTO(List<TblProjects> tblProjectList) {

		List<ProjectsDTO> projectDTOList = new ArrayList<>();

		for (TblProjects tblProjectObj : tblProjectList) {

			ProjectsDTO projectDTOToReturn = new ProjectsDTO();
			projectDTOToReturn.setId(tblProjectObj.getId());
			projectDTOToReturn.setProjectName(tblProjectObj.getProjectName());
			projectDTOToReturn.setProjectDescription(tblProjectObj.getProjectDescription());
			projectDTOToReturn.setProjectType(tblProjectObj.getProjectType());
			projectDTOToReturn.setProjectStatus(tblProjectObj.getProjectStatus());
			projectDTOToReturn.setAttachments(tblProjectObj.getAttachments());
			projectDTOToReturn.setKeywords(tblProjectObj.getKeywords());

			projectDTOList.add(projectDTOToReturn);
		}

		return projectDTOList;
	}

	private List<ContactsDTO> getContactsDTO(List<TblContacts> tblContactsList) {

		List<ContactsDTO> contactsDTOList = new ArrayList<>();

		for (TblContacts contactListObj : tblContactsList) {
			ContactsDTO contactListToReturn = new ContactsDTO();

			contactListToReturn.setId(contactListObj.getId());
			contactListToReturn.setName(contactListObj.getName());
			contactListToReturn.setDesignation(contactListObj.getDesignation());
			contactListToReturn.setPhone(contactListObj.getPhone());

			contactListToReturn.setEmail(contactListObj.getDesignation());
			contactListToReturn.setLocation(contactListObj.getLocation());
			contactListToReturn.setStatus(contactListObj.getStatus());

			contactsDTOList.add(contactListToReturn);
		}
		return contactsDTOList;
	}

	@Transactional(readOnly = true)
	@Override
	public ClientDTO getClientRecord(int clientId) {
		ClientDTO clientDTOToReturn = new ClientDTO();
		Boolean isClientExist = clientAPIdao.clientExist(clientId);
		if (isClientExist) {
			TblClient tblClient = clientAPIdao.getClientRecord(clientId);
			clientDTOToReturn.setId(tblClient.getId());
			clientDTOToReturn.setCompanyName(tblClient.getCompanyName());
			clientDTOToReturn.setAddress(tblClient.getAddress());
			clientDTOToReturn.setCity(tblClient.getCity());
			clientDTOToReturn.setState(tblClient.getState());
			clientDTOToReturn.setZip(tblClient.getZip());
			clientDTOToReturn.setCountry(tblClient.getCountry());
			clientDTOToReturn.setPhone(tblClient.getPhone());
			clientDTOToReturn.setWebsite(tblClient.getWebsite());

			List<TblContacts> tblContactsList = new ArrayList<TblContacts>(tblClient.getContactsList());
			List<ContactsDTO> contactDTOList = new ArrayList<>();

			for (TblContacts dbContactObj : tblContactsList) {
				ContactsDTO contactDTO = new ContactsDTO();

				contactDTO.setId(dbContactObj.getId());
				contactDTO.setName(dbContactObj.getName());
				contactDTO.setDesignation(dbContactObj.getDesignation());
				contactDTO.setPhone(dbContactObj.getPhone());
				contactDTO.setEmail(dbContactObj.getEmail());
				contactDTO.setLocation(dbContactObj.getLocation());
				contactDTO.setStatus(dbContactObj.getStatus());
				contactDTOList.add(contactDTO);
			}

			List<TblProjects> tblProjectList = new ArrayList<TblProjects>(tblClient.getProjectList());
			List<ProjectsDTO> projectsDTOList = new ArrayList<>();

			for (TblProjects tblProjectObj : tblProjectList) {

				ProjectsDTO projectsDTOToReturn = new ProjectsDTO();
				projectsDTOToReturn.setId(tblProjectObj.getId());
				projectsDTOToReturn.setProjectName(tblProjectObj.getProjectName());
				projectsDTOToReturn.setProjectDescription(tblProjectObj.getProjectDescription());
				projectsDTOToReturn.setProjectType(tblProjectObj.getProjectType());
				projectsDTOToReturn.setProjectStatus(tblProjectObj.getProjectStatus());
				projectsDTOToReturn.setAttachments(tblProjectObj.getAttachments());
				projectsDTOToReturn.setKeywords(tblProjectObj.getKeywords());

				projectsDTOList.add(projectsDTOToReturn);
			}
			clientDTOToReturn.setProjectList(projectsDTOList);
			clientDTOToReturn.setContactList(contactDTOList);
		} else {
			// System.out.println("invalid Id");
			throw new RuntimeException();
		}
		return clientDTOToReturn;

	}

	@Transactional
	@Override
	public ClientDTO updateClientRecord(ClientDTO clientDTOObj) {
		TblClient tblClient = new TblClient();
		tblClient.setId(clientDTOObj.getId());
		tblClient.setCompanyName(clientDTOObj.getCompanyName());
		tblClient.setAddress(clientDTOObj.getAddress());
		tblClient.setCity(clientDTOObj.getCity());
		tblClient.setState(clientDTOObj.getState());
		tblClient.setZip(clientDTOObj.getZip());
		tblClient.setCountry(clientDTOObj.getCountry());
		tblClient.setPhone(clientDTOObj.getPhone());
		tblClient.setWebsite(clientDTOObj.getWebsite());

		List<ContactsDTO> contactDTOList = clientDTOObj.getContactList();
		Set<TblContacts> tblContactList = new HashSet<>();

		for (ContactsDTO contactDTOObj : contactDTOList) {

			TblContacts tblContact = new TblContacts();
			tblContact.setId(contactDTOObj.getId());
			tblContact.setName(contactDTOObj.getName());
			tblContact.setDesignation(contactDTOObj.getDesignation());
			tblContact.setPhone(contactDTOObj.getPhone());
			tblContact.setEmail(contactDTOObj.getEmail());
			tblContact.setLocation(contactDTOObj.getLocation());
			tblContact.setStatus(contactDTOObj.getStatus());
			tblContact.setClientId(tblClient);
			tblContactList.add(tblContact);
		}

		List<ProjectsDTO> projectDTOList = clientDTOObj.getProjectList();
		Set<TblProjects> tblProjectList = new HashSet<>();

		for (ProjectsDTO projectDTOObj : projectDTOList) {

			TblProjects tblProjectObj = new TblProjects();
			tblProjectObj.setId(projectDTOObj.getId());
			tblProjectObj.setProjectName(projectDTOObj.getProjectName());
			tblProjectObj.setProjectDescription(projectDTOObj.getProjectDescription());
			tblProjectObj.setProjectType(projectDTOObj.getProjectType());
			tblProjectObj.setProjectStatus(projectDTOObj.getProjectStatus());
			tblProjectObj.setAttachments(projectDTOObj.getAttachments());
			tblProjectObj.setKeywords(projectDTOObj.getKeywords());
			tblProjectObj.setClientId(tblClient);
			tblProjectList.add(tblProjectObj);
		}
		tblClient.setProjectList(tblProjectList);
		tblClient.setContactsList(tblContactList);

		TblClient dbTblClient = clientAPIdao.updateClientRecord(tblClient);

		ClientDTO clientDTOToReturn = new ClientDTO();

		clientDTOToReturn.setId(dbTblClient.getId());
		clientDTOToReturn.setCompanyName(dbTblClient.getCompanyName());
		clientDTOToReturn.setAddress(dbTblClient.getAddress());
		clientDTOToReturn.setCity(dbTblClient.getCity());
		clientDTOToReturn.setState(dbTblClient.getState());
		clientDTOToReturn.setZip(dbTblClient.getZip());
		clientDTOToReturn.setCountry(dbTblClient.getCountry());
		clientDTOToReturn.setPhone(dbTblClient.getPhone());
		clientDTOToReturn.setWebsite(dbTblClient.getWebsite());

		List<TblContacts> dbContactList = new ArrayList<>(dbTblClient.getContactsList());
		List<ContactsDTO> contactDTO = new ArrayList<>();

		for (TblContacts tblContactObj : dbContactList) {

			ContactsDTO contactDTOToReturn = new ContactsDTO();
			contactDTOToReturn.setId(tblContactObj.getId());
			contactDTOToReturn.setName(tblContactObj.getName());
			contactDTOToReturn.setDesignation(tblContactObj.getDesignation());
			contactDTOToReturn.setPhone(tblContactObj.getPhone());
			contactDTOToReturn.setEmail(tblContactObj.getEmail());
			contactDTOToReturn.setLocation(tblContactObj.getLocation());
			contactDTOToReturn.setStatus(tblContactObj.getStatus());
			contactDTO.add(contactDTOToReturn);
		}

		Set<TblProjects> tblprojectList = dbTblClient.getProjectList();
		List<ProjectsDTO> projectsDTOList = new ArrayList<>();

		for (TblProjects tblprojectObj : tblprojectList) {

			ProjectsDTO projectsDTOToReturn = new ProjectsDTO();
			projectsDTOToReturn.setId(tblprojectObj.getId());
			projectsDTOToReturn.setProjectName(tblprojectObj.getProjectName());
			projectsDTOToReturn.setProjectDescription(tblprojectObj.getProjectDescription());
			projectsDTOToReturn.setProjectType(tblprojectObj.getProjectType());
			projectsDTOToReturn.setProjectStatus(tblprojectObj.getProjectStatus());
			projectsDTOToReturn.setAttachments(tblprojectObj.getAttachments());
			projectsDTOToReturn.setKeywords(tblprojectObj.getKeywords());
			projectsDTOList.add(projectsDTOToReturn);
		}
		clientDTOToReturn.setProjectList(projectsDTOList);
		clientDTOToReturn.setContactList(contactDTO);
		return clientDTOToReturn;
	}

	@Transactional
	@Override
	public ClientDTO deleteClientRecord(int clientId) {
		ClientDTO clientDTOToReturn = new ClientDTO();
		TblClient dbClient = clientAPIdao.getClientRecord(clientId);
		Boolean isClientExist = clientAPIdao.deleteClientRecord(clientId);
		if (isClientExist) {
			clientDTOToReturn.setId(dbClient.getId());
			clientDTOToReturn.setCompanyName(dbClient.getCompanyName());
			clientDTOToReturn.setAddress(dbClient.getAddress());
			clientDTOToReturn.setCity(dbClient.getCity());
			clientDTOToReturn.setState(dbClient.getState());
			clientDTOToReturn.setZip(dbClient.getZip());
			clientDTOToReturn.setCountry(dbClient.getCountry());
			clientDTOToReturn.setPhone(dbClient.getPhone());
			clientDTOToReturn.setWebsite(dbClient.getWebsite());

			List<TblContacts> dbContactList = new ArrayList<TblContacts>(dbClient.getContactsList());
			List<ContactsDTO> contactsDTOToReturn = new ArrayList<>();

			for (TblContacts dbContactsObj : dbContactList) {
				ContactsDTO contactDTO = new ContactsDTO();

				contactDTO.setId(dbContactsObj.getId());
				contactDTO.setName(dbContactsObj.getName());
				contactDTO.setDesignation(dbContactsObj.getDesignation());
				contactDTO.setPhone(dbContactsObj.getPhone());
				contactDTO.setEmail(dbContactsObj.getEmail());
				contactDTO.setLocation(dbContactsObj.getLocation());
				contactDTO.setStatus(dbContactsObj.getStatus());

				contactsDTOToReturn.add(contactDTO);
			}

			List<TblProjects> tblProjectList = new ArrayList<TblProjects>(dbClient.getProjectList());
			List<ProjectsDTO> projectDTOList = new ArrayList<>();

			for (TblProjects tblProjectObj : tblProjectList) {

				ProjectsDTO projectDTOToReturn = new ProjectsDTO();
				projectDTOToReturn.setId(tblProjectObj.getId());
				projectDTOToReturn.setProjectName(tblProjectObj.getProjectName());
				projectDTOToReturn.setProjectDescription(tblProjectObj.getProjectDescription());
				projectDTOToReturn.setProjectType(tblProjectObj.getProjectType());
				projectDTOToReturn.setProjectStatus(tblProjectObj.getProjectStatus());
				projectDTOToReturn.setAttachments(tblProjectObj.getAttachments());
				projectDTOToReturn.setKeywords(tblProjectObj.getKeywords());

				projectDTOList.add(projectDTOToReturn);
			}
			clientDTOToReturn.setProjectList(projectDTOList);
			clientDTOToReturn.setContactList(contactsDTOToReturn);
		} else {
			throw new RuntimeException();
		}
		return clientDTOToReturn;
	}
}