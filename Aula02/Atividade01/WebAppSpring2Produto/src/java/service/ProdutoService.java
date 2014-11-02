package service;

import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
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
