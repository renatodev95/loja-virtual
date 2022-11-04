package com.dev.backend.service;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PessoaClienteService {
    
    @Autowired
    private PessoaRepository repository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    public Pessoa registrar(PessoaClienteRequestDTO obj) {
        Pessoa pessoa = PessoaClienteRequestDTO.converter(obj);
        pessoa.setDataCriacao(new Date());
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoa);
        return repository.saveAndFlush(pessoa);
    }
    
}
