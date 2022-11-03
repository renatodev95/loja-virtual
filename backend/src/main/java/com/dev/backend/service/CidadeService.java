package com.dev.backend.service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository repository;
    
    public List<Cidade> bucarTodos() {
        return repository.findAll();
    }
    
    public Cidade inserir(Cidade cidade) {
        cidade.setDataCriacao(new Date());
        return repository.saveAndFlush(cidade);
    }
    
    public Cidade alterar(Cidade objeto) {
        objeto.setDataAtualizacao(new Date());
        return repository.saveAndFlush(objeto); 
    }
    
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
