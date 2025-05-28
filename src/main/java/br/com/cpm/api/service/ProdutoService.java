package br.com.cpm.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cpm.api.dto.ProdutoDTO;
import br.com.cpm.api.model.Produto;
import br.com.cpm.api.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    public List<ProdutoDTO> carregarProdutos() {

        List<Produto> produtos = produtoRepository.findAll();

        List<ProdutoDTO> dtos = new ArrayList<>();

        for (Produto produto : produtos) {
            dtos.add(produto.converterParaDTO());
        }

        return dtos;
    }

    public ProdutoDTO carregarDadosProdutosPeloId(Long id) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);

        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();

            return produto.converterParaDTO();
        }

        return null;
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
