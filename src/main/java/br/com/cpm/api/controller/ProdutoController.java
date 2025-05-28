package br.com.cpm.api.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cpm.api.dto.ProdutoDTO;
import br.com.cpm.api.model.Produto;
import br.com.cpm.api.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        return ResponseEntity.ok().body(produtoService.carregarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPeloId(@PathVariable("id") Long id) {
        ProdutoDTO produto = produtoService.carregarDadosProdutosPeloId(id);

        if (Objects.isNull(produto)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Produto>> deletarProduto(@PathVariable("id") Long id) {
        ProdutoDTO produto = produtoService.carregarDadosProdutosPeloId(id);

        if (Objects.isNull(produto)) {
            return ResponseEntity.notFound().build();
        }

        produtoService.deletarProduto(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable("id") Long id, @RequestBody Produto dadosProduto) {
        ProdutoDTO produto = produtoService.carregarDadosProdutosPeloId(id);

        if (Objects.isNull(produto)) {
            return ResponseEntity.notFound().build();
        }

        dadosProduto.setId(id);

        return ResponseEntity.ok().body(produtoService.salvarProduto(dadosProduto));
    }

    @Autowired
    private ProdutoService produtoService;
}
