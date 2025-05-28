package br.com.cpm.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cpm.api.model.Categoria;
import br.com.cpm.api.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @GetMapping
    public ResponseEntity<List<Categoria>> listarProdutos() {
        return ResponseEntity.ok().body(categoriaService.carregarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> buscarCategoriaPeloId(@PathVariable("id") Long id) {
        Optional<Categoria> categoria = categoriaService.carregarDadosCategoriaPeloId(id);

        if (categoria.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable("id") Long id) {
        Optional<Categoria> categoria = categoriaService.carregarDadosCategoriaPeloId(id);

        if (categoria.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        categoriaService.deletarCategoria(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.salvarCategoria(categoria));
    }
    


    @Autowired
    private CategoriaService categoriaService;
}

