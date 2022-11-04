package com.dev.backend.service;

import com.dev.backend.entity.Produto;
import com.dev.backend.entity.ProdutoImagens;
import com.dev.backend.repository.ProdutoImagensRepository;
import com.dev.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoImagensService {

    private static final String CAMINHO_IMAGENS = "c:/imagens/";
    
    @Autowired
    private ProdutoImagensRepository repository;
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> buscarTodos() {
        return repository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens obj = new ProdutoImagens();
        
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = produto.getId() + file.getOriginalFilename();
                Path caminho = Paths.get(CAMINHO_IMAGENS + nomeImagem);
                Files.write(caminho, bytes);
                obj.setNome(nomeImagem);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }

        obj.setProduto(produto);
        obj.setDataCriacao(new Date());
        return repository.saveAndFlush(obj);
    }

    public ProdutoImagens alterar(ProdutoImagens obj) {
        obj.setDataAtualizacao(new Date());
        return repository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        ProdutoImagens obj = repository.findById(id).get();
        Path caminho = Paths.get(CAMINHO_IMAGENS + obj.getNome());
        try {
            Files.deleteIfExists(caminho);
        } catch (IOException e) {
            e.printStackTrace();
        }
        repository.delete(obj);
    }
}
