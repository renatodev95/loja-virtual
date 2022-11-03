package com.dev.backend.service;

import com.dev.backend.entity.Permissao;
import com.dev.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoService {
    
    @Autowired
    private PermissaoRepository repository;
    
    public List<Permissao> bucarTodos() {
        return repository.findAll();
    }
    
    public Permissao inserir(Permissao obj) {
        obj.setDataCriacao(new Date());
        return repository.saveAndFlush(obj);
    }
    
    public Permissao alterar(Permissao obj) {
        obj.setDataAtualizacao(new Date());
        return repository.saveAndFlush(obj); 
    }
    
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
