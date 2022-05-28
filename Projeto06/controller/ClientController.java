package org.serratec.backend.projeto06.controller;

import org.serratec.backend.projeto06.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClientController {

	@Autowired
	ClientService clientService;
	
}
