package com.dev.backend.controller;

import com.dev.backend.entity.Cidade;
import com.dev.backend.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {
    
    @Autowired
    private CidadeService service;
    
    @GetMapping("/")
    public List<Cidade> buscarTodos() {
        return service.bucarTodos();
    }
    
    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade obj) {
        return service.inserir(obj);
    }

    @PutMapping("/")
    public Cidade alterar(@RequestBody Cidade obj) {
        return service.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
