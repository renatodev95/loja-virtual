package com.dev.backend.controller;

import com.dev.backend.entity.Permissao;
import com.dev.backend.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/permissao")
public class PermissaoController {
    
    @Autowired
    private PermissaoService service;
    
    @GetMapping("/")
    public List<Permissao> obterTodos() {
        return service.bucarTodos();
    }
    
    @PostMapping("/")
    public Permissao inserir(@RequestBody Permissao obj) {
        return service.inserir(obj);
    }
    
    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao obj) {
        return service.alterar(obj);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
