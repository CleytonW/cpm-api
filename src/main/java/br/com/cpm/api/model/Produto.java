package br.com.cpm.api.model;

import java.math.BigDecimal;

import br.com.cpm.api.dto.ProdutoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_PRODUTOS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco;

    private Integer quantidadeEstoque;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Categoria categoria;

    public ProdutoDTO converterParaDTO() {

        ProdutoDTO dto = new ProdutoDTO();

        dto.setId(id);
        dto.setNome(nome);
        dto.setPreco(preco);
        dto.setDescricao(descricao);
        dto.setCategoria(categoria);

        return dto;
    }

}
