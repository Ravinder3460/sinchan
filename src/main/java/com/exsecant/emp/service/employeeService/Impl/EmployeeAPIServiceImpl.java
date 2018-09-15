package com.exsecant.emp.service.employeeService.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exsecant.emp.dto.employeeDTO.FunctionDetailsDTO;
import com.exsecant.emp.dto.employeeDTO.JobDetailsDTO;
import com.exsecant.emp.dto.employeeDTO.PersonDetailsDTO;
import com.exsecant.emp.entity.employee.TblFunctionalDetails;
import com.exsecant.emp.entity.employee.TblJobDetails;
import com.exsecant.emp.entity.employee.TblPersonalDetails;
import com.exsecant.emp.service.employeeService.EmployeeAPIService;

@Service("employeeAPIService")
public class EmployeeAPIServiceImpl implements EmployeeAPIService {

	@Autowired
	private com.exsecant.emp.dao.employeeDAO.EmployeeAPIDAO employeeAPIDao;

	@Override
	public PersonDetailsDTO saveEmployee(PersonDetailsDTO employeeDTO) {

		TblPersonalDetails tblPersonDetails = new TblPersonalDetails();
		tblPersonDetails.setId(employeeDTO.getId());
		tblPersonDetails.setFirstName(employeeDTO.getFirstName());
		tblPersonDetails.setLastName(employeeDTO.getLastName());
		tblPersonDetails.setPermanentAddress(employeeDTO.getPermanentAddress());
		tblPersonDetails.setContactAddress(employeeDTO.getContactAddress());
		tblPersonDetails.setContactDetails(employeeDTO.getContactDetails());
		tblPersonDetails.setDob(employeeDTO.getDob());
		tblPersonDetails.setGender(employeeDTO.getGender());

		List<JobDetailsDTO> jobDetailsDTOList = employeeDTO.getJobDetailsList();
		Set<TblJobDetails> tblJobDetailsList = new HashSet<>();

		for (JobDetailsDTO jobDetailDTOList : jobDetailsDTOList) {

			TblJobDetails tblJobDetails = new TblJobDetails();

			tblJobDetails.setId(jobDetailDTOList.getId());
			tblJobDetails.setJobTitle(jobDetailDTOList.getJobTitle());
			tblJobDetails.setTeamAsign(jobDetailDTOList.getTeamAsign());
			tblJobDetails.setReportingMangaer(jobDetailDTOList.getReportingMangaer());
			tblJobDetails.setTypeOfEmployement(jobDetailDTOList.getTypeOfEmployement());
			tblJobDetails.setEmployeementStatus(jobDetailDTOList.getEmployeementStatus());
			tblJobDetails.setDoj(jobDetailDTOList.getDoj());
			tblJobDetails.setEmployeeInTime(jobDetailDTOList.getEmployeeInTime());
			tblJobDetails.setEmployeeOutTime(jobDetailDTOList.getEmployeeOutTime());
			tblJobDetails.setPersonDetailsId(tblPersonDetails);

			tblJobDetailsList.add(tblJobDetails);

		}

		List<FunctionDetailsDTO> functionDetailsDTOList = employeeDTO.getFunctionDetailsList();
		Set<TblFunctionalDetails> tblFunctionList = new HashSet<>();

		for (FunctionDetailsDTO functionDetailList : functionDetailsDTOList) {
			TblFunctionalDetails dbFunctionalDetails = new TblFunctionalDetails();

			dbFunctionalDetails.setId(functionDetailList.getId());
			dbFunctionalDetails.setEmail(functionDetailList.getEmail());
			dbFunctionalDetails.setPassword(functionDetailList.getPassword());
			dbFunctionalDetails.setUploadDocument(functionDetailList.getUploadDocument());
			dbFunctionalDetails.setDocumentSubmitted(functionDetailList.getDocumentSubmitted());
			dbFunctionalDetails.setRole(functionDetailList.getRole());
			dbFunctionalDetails.setEmergencyContactNumber(functionDetailList.getEmergencyContactNumber());
			dbFunctionalDetails.setPersonDetailsId(tblPersonDetails);
			tblFunctionList.add(dbFunctionalDetails);

		}

		tblPersonDetails.setFunctionalDetailsList(tblFunctionList);
		tblPersonDetails.setJobDetailsList(tblJobDetailsList);

		TblPersonalDetails dbtblEmployee = employeeAPIDao.saveEmployee(tblPersonDetails);

		PersonDetailsDTO employeeDTOToReturn = new PersonDetailsDTO();
		employeeDTOToReturn.setId(dbtblEmployee.getId());
		employeeDTOToReturn.setFirstName(dbtblEmployee.getFirstName());
		employeeDTOToReturn.setLastName(dbtblEmployee.getLastName());
		employeeDTOToReturn.setPermanentAddress(dbtblEmployee.getPermanentAddress());
		employeeDTOToReturn.setContactAddress(dbtblEmployee.getContactAddress());
		employeeDTOToReturn.setContactDetails(dbtblEmployee.getContactDetails());
		employeeDTOToReturn.setDob(dbtblEmployee.getDob());
		employeeDTOToReturn.setGender(dbtblEmployee.getGender());

		Set<TblJobDetails> dbJobDetails = dbtblEmployee.getJobDetailsList();
		List<JobDetailsDTO> jobDetailDTOList = new ArrayList<>();

		for (TblJobDetails dbjobDetail : dbJobDetails) {
			JobDetailsDTO jobDetailsDTOToReturn = new JobDetailsDTO();

			jobDetailsDTOToReturn.setId(dbjobDetail.getId());
			jobDetailsDTOToReturn.setJobTitle(dbjobDetail.getJobTitle());
			jobDetailsDTOToReturn.setTeamAsign(dbjobDetail.getTeamAsign());
			jobDetailsDTOToReturn.setReportingMangaer(dbjobDetail.getReportingMangaer());
			jobDetailsDTOToReturn.setTypeOfEmployement(dbjobDetail.getTypeOfEmployement());
			jobDetailsDTOToReturn.setEmployeementStatus(dbjobDetail.getEmployeementStatus());
			jobDetailsDTOToReturn.setDoj(dbjobDetail.getDoj());
			jobDetailsDTOToReturn.setEmployeementStatus(dbjobDetail.getEmployeeInTime());
			jobDetailsDTOToReturn.setEmployeeOutTime(dbjobDetail.getEmployeeOutTime());

			jobDetailDTOList.add(jobDetailsDTOToReturn);
		}

		Set<TblFunctionalDetails> dbFunctionalDetails = dbtblEmployee.getFunctionalDetailsList();
		List<FunctionDetailsDTO> functionalDetailsDTOToReturn = new ArrayList<>();

		for (TblFunctionalDetails dbFunctionalDetail : dbFunctionalDetails) {
			FunctionDetailsDTO functionDetailsList = new FunctionDetailsDTO();

			functionDetailsList.setId(dbFunctionalDetail.getId());
			functionDetailsList.setEmail(dbFunctionalDetail.getEmail());
			functionDetailsList.setPassword(dbFunctionalDetail.getPassword());
			functionDetailsList.setUploadDocument(dbFunctionalDetail.getUploadDocument());
			functionDetailsList.setDocumentSubmitted(dbFunctionalDetail.getDocumentSubmitted());
			functionDetailsList.setRole(dbFunctionalDetail.getRole());
			functionDetailsList.setEmergencyContactNumber(dbFunctionalDetail.getEmergencyContactNumber());

			functionalDetailsDTOToReturn.add(functionDetailsList);
		}
		employeeDTOToReturn.setFunctionDetailsList(functionalDetailsDTOToReturn);
		employeeDTOToReturn.setJobDetailsList(jobDetailDTOList);
		return employeeDTOToReturn;
	}

	@Override
	public PersonDetailsDTO updateEmployee(PersonDetailsDTO employeeDTO) {

		TblPersonalDetails tblPerson = new TblPersonalDetails();
		tblPerson.setId(employeeDTO.getId());
		tblPerson.setFirstName(employeeDTO.getFirstName());
		tblPerson.setLastName(employeeDTO.getLastName());
		tblPerson.setPermanentAddress(employeeDTO.getPermanentAddress());
		tblPerson.setContactAddress(employeeDTO.getContactAddress());
		tblPerson.setContactDetails(employeeDTO.getContactDetails());
		tblPerson.setDob(employeeDTO.getDob());
		tblPerson.setGender(employeeDTO.getGender());

		List<JobDetailsDTO> jobDetailsDTOList = employeeDTO.getJobDetailsList();
		Set<TblJobDetails> tbljobDetailList = new HashSet<>();

		for (JobDetailsDTO jobDetailsList : jobDetailsDTOList) {

			TblJobDetails tblJobDetails = new TblJobDetails();
			tblJobDetails.setId(jobDetailsList.getId());
			tblJobDetails.setJobTitle(jobDetailsList.getJobTitle());
			tblJobDetails.setTeamAsign(jobDetailsList.getTeamAsign());
			tblJobDetails.setReportingMangaer(jobDetailsList.getReportingMangaer());
			tblJobDetails.setTypeOfEmployement(jobDetailsList.getTypeOfEmployement());
			tblJobDetails.setEmployeementStatus(jobDetailsList.getEmployeementStatus());
			tblJobDetails.setDoj(jobDetailsList.getDoj());
			tblJobDetails.setEmployeeInTime(jobDetailsList.getEmployeeInTime());
			tblJobDetails.setEmployeeOutTime(jobDetailsList.getEmployeeOutTime());
			tblJobDetails.setPersonDetailsId(tblPerson);

			tbljobDetailList.add(tblJobDetails);
		}

		List<FunctionDetailsDTO> functionDetailsDTOList = employeeDTO.getFunctionDetailsList();
		Set<TblFunctionalDetails> tblfunctionDetailsList = new HashSet<>();

		for (FunctionDetailsDTO functionDetailsDTO : functionDetailsDTOList) {

			TblFunctionalDetails tblFunctionDetails = new TblFunctionalDetails();

			tblFunctionDetails.setId(functionDetailsDTO.getId());
			tblFunctionDetails.setEmail(functionDetailsDTO.getEmail());
			tblFunctionDetails.setPassword(functionDetailsDTO.getPassword());
			tblFunctionDetails.setUploadDocument(functionDetailsDTO.getUploadDocument());
			tblFunctionDetails.setDocumentSubmitted(functionDetailsDTO.getDocumentSubmitted());
			tblFunctionDetails.setRole(functionDetailsDTO.getRole());
			tblFunctionDetails.setEmergencyContactNumber(functionDetailsDTO.getEmergencyContactNumber());

			tblFunctionDetails.setPersonDetailsId(tblPerson);
			tblfunctionDetailsList.add(tblFunctionDetails);

		}
		tblPerson.setFunctionalDetailsList(tblfunctionDetailsList);
		tblPerson.setJobDetailsList(tbljobDetailList);

		TblPersonalDetails dbTblPersonDetailsList = employeeAPIDao.updateEmployee(tblPerson);

		PersonDetailsDTO personDetailDTOToReturn = new PersonDetailsDTO();

		personDetailDTOToReturn.setId(dbTblPersonDetailsList.getId());
		personDetailDTOToReturn.setFirstName(dbTblPersonDetailsList.getFirstName());
		personDetailDTOToReturn.setLastName(dbTblPersonDetailsList.getLastName());
		personDetailDTOToReturn.setPermanentAddress(dbTblPersonDetailsList.getPermanentAddress());
		personDetailDTOToReturn.setContactAddress(dbTblPersonDetailsList.getContactAddress());
		personDetailDTOToReturn.setContactDetails(dbTblPersonDetailsList.getContactDetails());
		personDetailDTOToReturn.setDob(dbTblPersonDetailsList.getDob());
		personDetailDTOToReturn.setGender(dbTblPersonDetailsList.getGender());

		Set<TblJobDetails> dbjobDetailsList = dbTblPersonDetailsList.getJobDetailsList();
		List<JobDetailsDTO> jobDetailDTOList = new ArrayList<>();

		for (TblJobDetails dbjobDetailList : dbjobDetailsList) {

			JobDetailsDTO jobDetailsDTOToReturn = new JobDetailsDTO();

			jobDetailsDTOToReturn.setId(dbjobDetailList.getId());
			jobDetailsDTOToReturn.setJobTitle(dbjobDetailList.getJobTitle());
			jobDetailsDTOToReturn.setTeamAsign(dbjobDetailList.getTeamAsign());
			jobDetailsDTOToReturn.setReportingMangaer(dbjobDetailList.getReportingMangaer());
			jobDetailsDTOToReturn.setTypeOfEmployement(dbjobDetailList.getTypeOfEmployement());
			jobDetailsDTOToReturn.setEmployeementStatus(dbjobDetailList.getEmployeementStatus());
			jobDetailsDTOToReturn.setDoj(dbjobDetailList.getDoj());
			jobDetailsDTOToReturn.setEmployeeInTime(dbjobDetailList.getEmployeeInTime());
			jobDetailsDTOToReturn.setEmployeeOutTime(dbjobDetailList.getEmployeeOutTime());

			jobDetailDTOList.add(jobDetailsDTOToReturn);

		}

		Set<TblFunctionalDetails> dbFunctionDetailsList = dbTblPersonDetailsList.getFunctionalDetailsList();
		List<FunctionDetailsDTO> functionDetailList = new ArrayList<>();

		for (TblFunctionalDetails dbFunctionDetailList : dbFunctionDetailsList) {

			FunctionDetailsDTO functionDetailsDTOToReturn = new FunctionDetailsDTO();
			functionDetailsDTOToReturn.setId(dbFunctionDetailList.getId());
			functionDetailsDTOToReturn.setEmail(dbFunctionDetailList.getEmail());
			functionDetailsDTOToReturn.setPassword(dbFunctionDetailList.getPassword());
			functionDetailsDTOToReturn.setUploadDocument(dbFunctionDetailList.getUploadDocument());
			functionDetailsDTOToReturn.setDocumentSubmitted(dbFunctionDetailList.getDocumentSubmitted());
			functionDetailsDTOToReturn.setRole(dbFunctionDetailList.getRole());
			functionDetailsDTOToReturn.setEmergencyContactNumber(dbFunctionDetailList.getEmergencyContactNumber());

			functionDetailList.add(functionDetailsDTOToReturn);
		}

		personDetailDTOToReturn.setJobDetailsList(jobDetailDTOList);
		personDetailDTOToReturn.setFunctionDetailsList(functionDetailList);

		return personDetailDTOToReturn;
	}

	@Override
	public PersonDetailsDTO getEmployee(long employeeId) {

		Boolean isEmployeeIdExist = employeeAPIDao.employeeExist(employeeId);
		PersonDetailsDTO personDetailsDTOToReturn = new PersonDetailsDTO();

		if (isEmployeeIdExist) {
			TblPersonalDetails dbPersonDetails = employeeAPIDao.getEmployee(employeeId);

			personDetailsDTOToReturn.setId(dbPersonDetails.getId());
			personDetailsDTOToReturn.setFirstName(dbPersonDetails.getFirstName());
			personDetailsDTOToReturn.setLastName(dbPersonDetails.getLastName());
			personDetailsDTOToReturn.setPermanentAddress(dbPersonDetails.getPermanentAddress());
			personDetailsDTOToReturn.setContactAddress(dbPersonDetails.getContactAddress());
			personDetailsDTOToReturn.setContactDetails(dbPersonDetails.getContactDetails());
			personDetailsDTOToReturn.setDob(dbPersonDetails.getDob());
			personDetailsDTOToReturn.setGender(dbPersonDetails.getGender());

			/*
			 * JobDetailsDTO jobDetailsReturn = new JobDetailsDTO();
			 * jobDetailsReturn.setId(dbPersonDetails.getJobDetailsList().);
			 */

			Set<TblJobDetails> dbJobDetailsList = dbPersonDetails.getJobDetailsList();
			List<JobDetailsDTO> jobDetailsDTOList = new ArrayList<>();

			for (TblJobDetails dbJobDetailList : dbJobDetailsList) {

				JobDetailsDTO jobDetailDTOToReturn = new JobDetailsDTO();
				jobDetailDTOToReturn.setId(dbJobDetailList.getId());
				jobDetailDTOToReturn.setJobTitle(dbJobDetailList.getJobTitle());
				jobDetailDTOToReturn.setTeamAsign(dbJobDetailList.getTeamAsign());
				jobDetailDTOToReturn.setReportingMangaer(dbJobDetailList.getReportingMangaer());
				jobDetailDTOToReturn.setTypeOfEmployement(dbJobDetailList.getTypeOfEmployement());
				jobDetailDTOToReturn.setEmployeementStatus(dbJobDetailList.getEmployeementStatus());
				jobDetailDTOToReturn.setDoj(dbJobDetailList.getDoj());
				jobDetailDTOToReturn.setEmployeeInTime(dbJobDetailList.getEmployeeInTime());
				jobDetailDTOToReturn.setEmployeeOutTime(dbJobDetailList.getEmployeeOutTime());

				jobDetailsDTOList.add(jobDetailDTOToReturn);

			}

			Set<TblFunctionalDetails> dbFunctionDetailsList = dbPersonDetails.getFunctionalDetailsList();
			List<FunctionDetailsDTO> functionDetailsDTOList = new ArrayList<>();

			for (TblFunctionalDetails dbFunctionDetailList : dbFunctionDetailsList) {

				FunctionDetailsDTO functionDetailDTOToReturn = new FunctionDetailsDTO();
				functionDetailDTOToReturn.setId(dbFunctionDetailList.getId());
				functionDetailDTOToReturn.setEmail(dbFunctionDetailList.getEmail());
				functionDetailDTOToReturn.setPassword(dbFunctionDetailList.getPassword());
				functionDetailDTOToReturn.setUploadDocument(dbFunctionDetailList.getUploadDocument());
				functionDetailDTOToReturn.setDocumentSubmitted(dbFunctionDetailList.getDocumentSubmitted());
				functionDetailDTOToReturn.setRole(dbFunctionDetailList.getRole());
				functionDetailDTOToReturn.setEmergencyContactNumber(dbFunctionDetailList.getEmergencyContactNumber());

				functionDetailsDTOList.add(functionDetailDTOToReturn);
			}

			personDetailsDTOToReturn.setJobDetailsList(jobDetailsDTOList);
			personDetailsDTOToReturn.setFunctionDetailsList(functionDetailsDTOList);

		} else {
			throw new RuntimeException();
		}
		return personDetailsDTOToReturn;
	}

	@Override
	public List<PersonDetailsDTO> getEmployeeRecords() {

		List<TblPersonalDetails> dbPersonDetailsList = employeeAPIDao.getEmployeeRecords();
		List<PersonDetailsDTO> personDetailsDTOList = new ArrayList<>();

		for (TblPersonalDetails personDetailsList : dbPersonDetailsList) {
			PersonDetailsDTO personDetailsDTOToReturn = new PersonDetailsDTO();

			personDetailsDTOToReturn.setId(personDetailsList.getId());
			personDetailsDTOToReturn.setFirstName(personDetailsList.getFirstName());
			personDetailsDTOToReturn.setLastName(personDetailsList.getLastName());
			personDetailsDTOToReturn.setPermanentAddress(personDetailsList.getPermanentAddress());
			personDetailsDTOToReturn.setContactAddress(personDetailsList.getContactAddress());
			personDetailsDTOToReturn.setContactDetails(personDetailsList.getContactDetails());
			personDetailsDTOToReturn.setDob(personDetailsList.getDob());
			personDetailsDTOToReturn.setGender(personDetailsList.getGender());

			List<TblJobDetails> dbjobDetailsList = new ArrayList<>(personDetailsList.getJobDetailsList());
			List<JobDetailsDTO> jobDetailsDTOList = getJobDetailsList(dbjobDetailsList);

			List<TblFunctionalDetails> dbFunctionDetailsList = new ArrayList<>(
					personDetailsList.getFunctionalDetailsList());
			List<FunctionDetailsDTO> functionDetailsDTOList = getFunctionDetailsList(dbFunctionDetailsList);

			personDetailsDTOToReturn.setJobDetailsList(jobDetailsDTOList);
			personDetailsDTOToReturn.setFunctionDetailsList(functionDetailsDTOList);
			personDetailsDTOList.add(personDetailsDTOToReturn);
		}
		return personDetailsDTOList;
	}

	private List<FunctionDetailsDTO> getFunctionDetailsList(List<TblFunctionalDetails> dbFunctionDetailsList) {
		List<FunctionDetailsDTO> functionDetailsDTOList = new ArrayList<>();

		for (TblFunctionalDetails functionDetailsList : dbFunctionDetailsList) {

			FunctionDetailsDTO functionDetailsDTOToReturn = new FunctionDetailsDTO();

			functionDetailsDTOToReturn.setId(functionDetailsList.getId());
			functionDetailsDTOToReturn.setEmail(functionDetailsList.getEmail());
			functionDetailsDTOToReturn.setPassword(functionDetailsList.getPassword());
			functionDetailsDTOToReturn.setUploadDocument(functionDetailsList.getUploadDocument());
			functionDetailsDTOToReturn.setDocumentSubmitted(functionDetailsList.getDocumentSubmitted());
			functionDetailsDTOToReturn.setRole(functionDetailsList.getRole());
			functionDetailsDTOToReturn.setEmergencyContactNumber(functionDetailsList.getEmergencyContactNumber());

			functionDetailsDTOList.add(functionDetailsDTOToReturn);

		}
		return functionDetailsDTOList;
	}

	private List<JobDetailsDTO> getJobDetailsList(List<TblJobDetails> dbjobDetailsList) {

		List<JobDetailsDTO> jobDetailsDTOList = new ArrayList<>();

		for (TblJobDetails tblJobDetails : dbjobDetailsList) {
			JobDetailsDTO jobDetailsDTOToReturn = new JobDetailsDTO();

			jobDetailsDTOToReturn.setId(tblJobDetails.getId());
			jobDetailsDTOToReturn.setJobTitle(tblJobDetails.getJobTitle());
			jobDetailsDTOToReturn.setTeamAsign(tblJobDetails.getTeamAsign());
			jobDetailsDTOToReturn.setReportingMangaer(tblJobDetails.getReportingMangaer());
			jobDetailsDTOToReturn.setTypeOfEmployement(tblJobDetails.getTypeOfEmployement());
			jobDetailsDTOToReturn.setEmployeementStatus(tblJobDetails.getEmployeementStatus());
			jobDetailsDTOToReturn.setDoj(tblJobDetails.getDoj());
			jobDetailsDTOToReturn.setEmployeeInTime(tblJobDetails.getEmployeeInTime());
			jobDetailsDTOToReturn.setEmployeeOutTime(tblJobDetails.getEmployeeOutTime());
			jobDetailsDTOList.add(jobDetailsDTOToReturn);
		}
		return jobDetailsDTOList;
	}

	@Override
	public PersonDetailsDTO deleteEmployee(long employeeId) {

		TblPersonalDetails dbPersonalDetails = employeeAPIDao.getEmployee(employeeId);
		Boolean isEmployeeIdExist = employeeAPIDao.deletedEmployee(employeeId);
		PersonDetailsDTO personDetailsDTOToReturn = new PersonDetailsDTO();
		if (isEmployeeIdExist) {

			personDetailsDTOToReturn.setId(dbPersonalDetails.getId());
			personDetailsDTOToReturn.setFirstName(dbPersonalDetails.getFirstName());
			personDetailsDTOToReturn.setLastName(dbPersonalDetails.getLastName());
			personDetailsDTOToReturn.setPermanentAddress(dbPersonalDetails.getPermanentAddress());
			personDetailsDTOToReturn.setContactAddress(dbPersonalDetails.getContactAddress());
			personDetailsDTOToReturn.setContactDetails(dbPersonalDetails.getContactDetails());
			personDetailsDTOToReturn.setDob(dbPersonalDetails.getDob());
			personDetailsDTOToReturn.setGender(dbPersonalDetails.getGender());

			Set<TblJobDetails> dbJobDetailsList = dbPersonalDetails.getJobDetailsList();
			List<JobDetailsDTO> jobDetailsDTOList = new ArrayList<>();

			for (TblJobDetails JobDetailsList : dbJobDetailsList) {

				JobDetailsDTO jobDetailsDTOToReturn = new JobDetailsDTO();
				jobDetailsDTOToReturn.setId(JobDetailsList.getId());
				jobDetailsDTOToReturn.setJobTitle(JobDetailsList.getJobTitle());
				jobDetailsDTOToReturn.setTeamAsign(JobDetailsList.getTeamAsign());
				jobDetailsDTOToReturn.setReportingMangaer(JobDetailsList.getReportingMangaer());
				jobDetailsDTOToReturn.setTypeOfEmployement(JobDetailsList.getTypeOfEmployement());
				jobDetailsDTOToReturn.setEmployeementStatus(JobDetailsList.getEmployeementStatus());
				jobDetailsDTOToReturn.setDoj(JobDetailsList.getDoj());
				jobDetailsDTOToReturn.setEmployeeInTime(JobDetailsList.getEmployeeInTime());
				jobDetailsDTOToReturn.setEmployeeOutTime(JobDetailsList.getEmployeeOutTime());

				jobDetailsDTOList.add(jobDetailsDTOToReturn);
			}

			Set<TblFunctionalDetails> dbFunctionalDetailsList = dbPersonalDetails.getFunctionalDetailsList();
			List<FunctionDetailsDTO> functionDetailsDTOList = new ArrayList<>();

			for (TblFunctionalDetails functionalDetailsList : dbFunctionalDetailsList) {

				FunctionDetailsDTO functionDetailsDTOToReturn = new FunctionDetailsDTO();

				functionDetailsDTOToReturn.setId(functionalDetailsList.getId());
				functionDetailsDTOToReturn.setEmail(functionalDetailsList.getEmail());
				functionDetailsDTOToReturn.setPassword(functionalDetailsList.getPassword());
				functionDetailsDTOToReturn.setUploadDocument(functionalDetailsList.getUploadDocument());
				functionDetailsDTOToReturn.setDocumentSubmitted(functionalDetailsList.getDocumentSubmitted());
				functionDetailsDTOToReturn.setRole(functionalDetailsList.getRole());
				functionDetailsDTOToReturn.setEmergencyContactNumber(functionalDetailsList.getEmergencyContactNumber());

				functionDetailsDTOList.add(functionDetailsDTOToReturn);
			}
			personDetailsDTOToReturn.setJobDetailsList(jobDetailsDTOList);
			personDetailsDTOToReturn.setFunctionDetailsList(functionDetailsDTOList);

		} else {
			throw new RuntimeException();
		}
		return personDetailsDTOToReturn;
	}

}