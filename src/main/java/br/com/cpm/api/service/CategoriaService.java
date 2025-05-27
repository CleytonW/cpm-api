package br.com.cpm.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cpm.api.model.Categoria;
import br.com.cpm.api.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    public List<Categoria> carregarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> carregarDadosCategoriaPeloId(Long id) {
        return categoriaRepository.findById(id);
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Autowired
    private CategoriaRepository categoriaRepository;
}
