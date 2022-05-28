package org.serratec.backend.projeto06.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto06.dto.ClientDTO;
import org.serratec.backend.projeto06.repository.ClientRepository;
import org.serratec.backend.projeto06.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	// TO DTO
	public ClientDTO toDTO(Client client, ClientDTO clientDTO) {

		clientDTO.setClientId(client.getClientId());
		clientDTO.setCpf(client.getCpf());
		clientDTO.setEmail(client.getEmail());
		clientDTO.setPhoneNum(client.getEmail());

		return clientDTO;
	}

	// TO ENTITY
	public Client toEntity(Client client, ClientDTO clientDTO) {

		client.setCpf(clientDTO.getCpf());
		client.setEmail(clientDTO.getEmail());
		client.setPhoneNum(clientDTO.getPhoneNum());

		return client;
	}

	// CREATE
	public String save(ClientDTO clientDTO) {
		Client client = new Client();
		toEntity(client, clientDTO);
		clientRepository.save(client);
		return "Client successfully saved!";
	}

	// READ
	public ClientDTO searchById(Integer clientId) {
		Optional<Client> client = clientRepository.findById(clientId);
		Client dataClient = new Client();
		ClientDTO clientDTO = new ClientDTO();

		if (client.isPresent()) {
			dataClient = client.get();
			toDTO(dataClient, clientDTO);
		}
		return clientDTO;
	}

	// UPDATE
	public String update(Integer clientId, ClientDTO clientDTO) {
		Optional<Client> client = clientRepository.findById(clientId);
		Client dataClient = new Client();

		if (client.isPresent()) {
			dataClient = client.get();
			if (clientDTO.getCpf() != null) {
				dataClient.setCpf(clientDTO.getCpf());
			}
			if (clientDTO.getPhoneNum() != null) {
				dataClient.setPhoneNum(clientDTO.getPhoneNum());
			}
			if (clientDTO.getEmail() != null) {
				dataClient.setEmail(clientDTO.getEmail());
			}
			clientRepository.save(dataClient);
		}
		return "Client ID " + dataClient.getClientId() + " was successfully updated.";
	}

	// DELETE
	public void delete(Integer clientId) {
		clientRepository.deleteById(clientId);
	}

	// LIST ALL
	public List<ClientDTO> findAll() {
		List<Client> clientList = clientRepository.findAll();
		List<ClientDTO> clientDTOList = new ArrayList<>();

		for (Client client : clientList) {
			ClientDTO clientDTO = new ClientDTO();
			toDTO(client, clientDTO);
			clientDTOList.add(clientDTO);
		}
		return clientDTOList;
	}
}