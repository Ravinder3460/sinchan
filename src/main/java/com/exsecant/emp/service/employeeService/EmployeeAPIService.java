package com.exsecant.emp.service.employeeService;

import java.util.List;

import com.exsecant.emp.dto.employeeDTO.PersonDetailsDTO;

public interface EmployeeAPIService {

	PersonDetailsDTO saveEmployee(PersonDetailsDTO employeeDTO);

	PersonDetailsDTO updateEmployee(PersonDetailsDTO employeeDTO);

	PersonDetailsDTO getEmployee(long employeeId);

	List<PersonDetailsDTO> getEmployeeRecords();

	PersonDetailsDTO deleteEmployee(long employeeId);

}
