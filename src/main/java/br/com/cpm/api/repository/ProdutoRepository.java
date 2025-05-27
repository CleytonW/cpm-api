package br.com.cpm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cpm.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

        
}
