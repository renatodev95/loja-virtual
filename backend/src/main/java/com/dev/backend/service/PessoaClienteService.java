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
    
    @Autowired
    private EmailService emailService;

    public Pessoa registrar(PessoaClienteRequestDTO obj) {
        Pessoa pessoa = PessoaClienteRequestDTO.converter(obj);
        pessoa.setDataCriacao(new Date());
        repository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoa);
        emailService.enviarEmailTexto(obj.getEmail(), 
                "Cadastro na Loja Virtual", 
                "O registo na loja foi realizado com sucesso. Em breve você receberá a senha de acesso por email!!");
        return pessoa;
    }
    
}
