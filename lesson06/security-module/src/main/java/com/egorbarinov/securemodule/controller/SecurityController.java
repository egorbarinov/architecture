package com.egorbarinov.securemodule.controller;

import com.egorbarinov.securemodule.dto.ClientDto;
import com.egorbarinov.securemodule.service.SecurityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.net.URL;

@Controller
//@RequestMapping("/clients")
public class SecurityController {

    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }


    @GetMapping("/{id}")
    @ResponseBody
    public ClientDto getClient(@PathVariable Long id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL("http://localhost:8189/1");

        ClientDto client = mapper.readValue( url , ClientDto.class);
        client.setName("Egor"); // проверяем, что можем работать с полученным объектом
        return client;
    }

    private void checkById(@PathVariable Long id) {
        if(!securityService.existById(id)){
            throw new EntityNotFoundException("Client" + id + " Not found");
        }
    }

}
