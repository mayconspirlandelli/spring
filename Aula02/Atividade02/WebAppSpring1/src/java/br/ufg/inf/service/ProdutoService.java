package br.ufg.inf.service;

import br.ufg.inf.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * NÃO USADA
 * @author Maycon Spirlandelli
 */

public class ProdutoService {
    
    @Autowired
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    @Override
    public String toString() {
        return "O produto é " + produto.getNome();
    }
    
}