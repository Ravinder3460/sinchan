package com.exsecant.emp.controller.employeeAPIController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exsecant.emp.dto.employeeDTO.PersonDetailsDTO;
import com.exsecant.emp.exception.ErrorMessage;
import com.exsecant.emp.service.employeeService.EmployeeAPIService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeAPIController {

	@Autowired
	private EmployeeAPIService employeeAPIService;

	@PostMapping("/addEmployee")
	public PersonDetailsDTO saveEmployee(@RequestBody PersonDetailsDTO employeeDTO) {
		return employeeAPIService.saveEmployee(employeeDTO);
	}

	@PutMapping("/updateEmployee")
	public PersonDetailsDTO updateEmployee(@RequestBody PersonDetailsDTO employeeDTO) {
		return employeeAPIService.updateEmployee(employeeDTO);
	}

	@GetMapping("/getEmployeeById/{employee-Id}")
	public PersonDetailsDTO getEmployee(@PathVariable("employee-Id") long employeeId) {
		return employeeAPIService.getEmployee(employeeId);
	}

	@GetMapping("/getEmployeeRecords")
	public List<PersonDetailsDTO> getEmployeeRecords() {
		return employeeAPIService.getEmployeeRecords();
	}

	@DeleteMapping("/deleteEmployee/{employee-Id}")
	public PersonDetailsDTO deleteEmployee(@PathVariable("employee-Id") long employeeId) {
		return employeeAPIService.deleteEmployee(employeeId);
	}

	
	 @ExceptionHandler({ RuntimeException.class,Exception.class })
	    public ErrorMessage handleException() {
		 return new ErrorMessage(404,"Id does not exist");
	    }
}
