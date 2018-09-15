package com.exsecant.emp.controller.clientAPIController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exsecant.emp.dto.clientDTO.ClientDTO;
import com.exsecant.emp.exception.ErrorMessage;
import com.exsecant.emp.service.clientService.ClientAPIService;

@RestController
public class ClientAPIController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientAPIController.class);

	@Autowired
	private ClientAPIService clientAPIService;

	@RequestMapping(value = "AddClient", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientDTO addClient(@RequestBody ClientDTO clientDTO) {
		LOGGER.info("Adding the employee : controller {}", clientDTO);
		return clientAPIService.addClient(clientDTO);
	}

	@RequestMapping(value = "ClientRecords", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClientDTO> getClientRecords() {
		LOGGER.info("You are going to get all recods from controller");
		return clientAPIService.getClientRecords();
	}

	@RequestMapping(value = "ClientRecordById/{client-Id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientDTO getClientRecord(@PathVariable("client-Id") int clientId) {
		LOGGER.info("Getting the employee with Id : controller {}", clientId);
		return clientAPIService.getClientRecord(clientId);
	}

	@RequestMapping(value = "updateClient", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientDTO updateClientRecord(@RequestBody ClientDTO clientObj) {
		LOGGER.info("Updating the employee : controller {}", clientObj);
		return clientAPIService.updateClientRecord(clientObj);
	}

	@RequestMapping(value = "deleteClient/{client-Id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientDTO deleteClientRecord(@PathVariable("client-Id") int clientId) {
		LOGGER.info("Getting a list with employees : controller");
		return clientAPIService.deleteClientRecord(clientId);
	}
	

	 @ExceptionHandler({ RuntimeException.class,Exception.class })
	    public ErrorMessage handleException() {
		 return new ErrorMessage(404,"Id does not exist");
	    }
	 

}
