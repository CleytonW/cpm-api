package br.com.cpm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cpm.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
