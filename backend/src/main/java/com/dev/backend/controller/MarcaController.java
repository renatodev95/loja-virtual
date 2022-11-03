package com.dev.backend.controller;

import com.dev.backend.entity.Marca;
import com.dev.backend.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/marca")
public class MarcaController {
    
    @Autowired
    private MarcaService service;
    
    @GetMapping("/")
    public List<Marca> obterTodos() {
        return service.bucarTodos();
    }
    
    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca) {
        return service.inserir(marca);
    }
    
    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca) {
        return service.alterar(marca);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
