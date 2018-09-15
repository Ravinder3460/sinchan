package com.exsecant.emp.dao.employeeDAO;

import java.util.List;

import com.exsecant.emp.entity.employee.TblPersonalDetails;

public interface EmployeeAPIDAO {

	TblPersonalDetails saveEmployee(TblPersonalDetails tblEmployee);

	TblPersonalDetails updateEmployee(TblPersonalDetails tblPerson);

	Boolean employeeExist(long employeeId);

	TblPersonalDetails getEmployee(long employeeId);

	Boolean deletedEmployee(long employeeId);

	List<TblPersonalDetails> getEmployeeRecords();

}
