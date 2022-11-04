package com.dev.backend.service;

import com.dev.backend.entity.Permissao;
import com.dev.backend.entity.PermissaoPessoa;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PermissaoPessoaRepository;
import com.dev.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoPessoaService {
    
    @Autowired
    private PermissaoPessoaRepository repository;
    
    @Autowired
    private PermissaoRepository permissaoRepository;
    
    public void vincularPessoaPermissaoCliente(Pessoa pessoa) {
        List<Permissao> listaPermissao = permissaoRepository.findByNome("Cliente");
        if (!listaPermissao.isEmpty()) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setDataCriacao(new Date());
            repository.saveAndFlush(permissaoPessoa);
        }
    }
}
