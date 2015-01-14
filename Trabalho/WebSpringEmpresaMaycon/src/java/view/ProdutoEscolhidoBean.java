package view;

import model.Produto;
import org.springframework.stereotype.Component;

/**
 *
 * @author maycon
 */
@Component
public class ProdutoEscolhidoBean {

    private Produto produto;
    private int quantidade = 0 ;
    private float subTotal = 0;

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        produto.setDescricao(produto.getDescricao().trim());
        produto.setNome(produto.getNome().trim());
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    /*
     * Calcula preço do produto * quantidade do produto. 
    */
    public float calculaTotalPorProduto() {        
        this.subTotal = this.quantidade * this.produto.getPreco();
        return this.subTotal;
    }   
}
