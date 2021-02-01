package com.egorbarinov.creditingmodule.controller;

import com.egorbarinov.creditingmodule.dto.ClientDto;
import com.egorbarinov.creditingmodule.dto.CreditDto;
import com.egorbarinov.creditingmodule.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Controller

//@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) throws IOException {
        this.clientService = clientService;
    }

    @GetMapping("index")
    public String init() {
        System.out.println("Привет!");
        return "index";
    }

    @GetMapping("/creating-client")
    public String creatingClient (Model model) {
        model.addAttribute("clientDto", new ClientDto());

        return "creating-client";
    }

    @PostMapping("/creating-client")
    public String processСreatingClient(@Valid ClientDto clientDto, Model model) {

        model.addAttribute("clientDto", clientDto);
        clientService.save(clientDto);
        model.addAttribute("creditDto", new CreditDto());

        return "get-loan";
    }


    @PostMapping("/get-loan")
    public String getLoan(@Valid CreditDto creditDto, Model model) {
        model.addAttribute("creditDto", creditDto);

        return "solution";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ClientDto getClient(@PathVariable Long id){
        checkById(id);
        return clientService.findById(id);
    }

    @GetMapping("/clients")
    @ResponseBody
    public List<ClientDto> getAllClients() throws IOException {
        return clientService.getAll();
    }

    @GetMapping("/checked-clients")
    @ResponseBody
    public void getCheckedClients() throws IOException {
        clientService.loadDataFromSecurityModule();
    }

    private void checkById(@PathVariable Long id) {
        if(!clientService.existById(id)){
            throw new EntityNotFoundException("Client" + id + " Not found");
        }
    }



}
