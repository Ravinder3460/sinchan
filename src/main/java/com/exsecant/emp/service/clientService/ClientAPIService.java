package com.exsecant.emp.service.clientService;

import java.util.List;

import com.exsecant.emp.dto.clientDTO.ClientDTO;

public interface ClientAPIService {

	ClientDTO addClient(ClientDTO clientDTO);

	List<ClientDTO> getClientRecords();

	ClientDTO getClientRecord(int clientId);

	ClientDTO updateClientRecord(ClientDTO clientObj);

	ClientDTO deleteClientRecord(int clientId);

}
