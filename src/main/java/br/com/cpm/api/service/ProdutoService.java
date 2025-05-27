package br.com.cpm.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cpm.api.model.Produto;
import br.com.cpm.api.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    public List<Produto> carregarCategoria() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> carregarDadosProdutosPeloId(Long id) {
        return produtoRepository.findById(id);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Autowired
    private ProdutoRepository produtoRepository;
}
