package com.egorbarinov.securemodule.controller;

import com.egorbarinov.securemodule.dto.ClientDto;
import com.egorbarinov.securemodule.service.SecurityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Controller
@RequestMapping("/clients-list")
public class SecurityController {

    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) throws IOException {
        this.securityService = securityService;
        securityService.loadDataFromCreditingModule();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllClients(Model model) throws IOException {
        List<ClientDto> clientDtos = securityService.loadDataFromCreditingModule();
        model.addAttribute("clientsDto", clientDtos);
        return "clients-list";
    }

    @GetMapping("/clients-list-from-json")
    @ResponseBody
    public List<ClientDto> getAllClientsAsJson() throws IOException {
        return securityService.getDataFromSecurityModule();
    }


    @GetMapping("/{id}")
    public String getClientById(@PathVariable Long id, Model model) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL("http://localhost:8189/" + id);
        ClientDto client = mapper.readValue( url , ClientDto.class);
        model.addAttribute("newClient", client);
        return "clients-check";
    }

    @PostMapping("/clients-check")
    @ResponseBody
    public ClientDto inputData(ClientDto clientDto, Model model) {
        model.addAttribute("newClient", clientDto);

        return securityService.assignResultOfCheck(clientDto);

    }

    @GetMapping("/passport-id/{serial}")
    @ResponseBody
    public String getClientByPassportId(@PathVariable String serial) throws JsonProcessingException {
        if (!securityService.existByPassportId(serial)) {
            throw new EntityNotFoundException("Client with passport serial " + serial + " Not found");
        }
        ClientDto clientDto = securityService.findByPassportId(serial);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(clientDto);

    }


}
