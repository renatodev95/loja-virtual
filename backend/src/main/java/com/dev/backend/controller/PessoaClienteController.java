package com.dev.backend.controller;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.PessoaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
public class PessoaClienteController {
    
    @Autowired
    private PessoaClienteService service;
    
    @PostMapping("/")
    public Pessoa inserir(@RequestBody PessoaClienteRequestDTO obj) {
        return service.registrar(obj);
    }
}
