package com.dev.backend.controller;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaService service;
    
    @GetMapping("/")
    public List<Pessoa> obterTodos() {
        return service.buscarTodos();
    }
    
    @PostMapping("/")
    public Pessoa inserir(@RequestBody Pessoa obj) {
        return service.inserir(obj);
    }
    
    @PutMapping("/")
    public Pessoa alterar(@RequestBody Pessoa obj) {
        return service.alterar(obj);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
