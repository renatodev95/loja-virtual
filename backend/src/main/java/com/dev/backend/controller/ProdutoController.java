package com.dev.backend.controller;

import com.dev.backend.entity.Produto;
import com.dev.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;
    
    @GetMapping("/")
    public List<Produto> obterTodos() {
        return service.buscarTodos();
    }
    
    @PostMapping("/")
    public Produto inserir(@RequestBody Produto obj) {
        return service.inserir(obj);
    }
    
    @PutMapping("/")
    public Produto alterar(@RequestBody Produto obj) {
        return service.alterar(obj);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
