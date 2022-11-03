package com.dev.backend.service;

import com.dev.backend.entity.Categoria;
import com.dev.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> buscarTodos() {
        return repository.findAll();
    }

    public Categoria inserir(Categoria categoria) {
        categoria.setDataCriacao(new Date());
        return repository.saveAndFlush(categoria);
    }

    public Categoria alterar(Categoria categoria) {
        categoria.setDataAtualizacao(new Date());
        return repository.saveAndFlush(categoria);
    }

    public void excluir(Long id) {
        Categoria categoria = repository.findById(id).get();
        repository.delete(categoria);
    }
}
