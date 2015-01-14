package view;

import java.util.ArrayList;
import java.util.List;
import model.Produto;
import org.springframework.stereotype.Component;

/**
 *
 * @author maycon
 */
@Component
public class CarrinhoBean {

    private Produto produto;
    private List<ProdutoEscolhidoBean> listaProdutoEscolhido = new ArrayList<ProdutoEscolhidoBean>();
    private boolean vazio = true;
    private float valorTotal = 0;
    private int quantidadeProdutos = 0;

    public List<ProdutoEscolhidoBean> getListaProdutoEscolhido() {
        return listaProdutoEscolhido;
    }

    /**
     * Quantidade de produtos no carrinho.
     *
     * @return int quantidade.
     */
    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    /**
     * Quantidade de produtos no carrinho.
     *
     * @param quantidadeProdutos int.
     */
    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        produto.setDescricao(produto.getDescricao().trim());
        produto.setNome(produto.getNome().trim());
        this.produto = produto;
    }

    public boolean getVazio() {
        return vazio;
    }

    public void setVazio(boolean vazio) {
        this.vazio = vazio;
    }

    public float calculaTotalProdutos() {
        float totalProdutos = 0;

        if ((this.listaProdutoEscolhido != null) && (this.listaProdutoEscolhido.size() > 0)) {
            for (ProdutoEscolhidoBean produtoEscolhidoBean : listaProdutoEscolhido) {
                totalProdutos += produtoEscolhidoBean.calculaTotalPorProduto();
                System.out.println("Produto: " + produtoEscolhidoBean.getProduto().getNome() + "  " + "quantidade: " + produtoEscolhidoBean.getQuantidade());
                System.out.println("valor total por produto: " + produtoEscolhidoBean.calculaTotalPorProduto());
                System.out.println("valor total do carrinho : " + totalProdutos);
            }
        }
        this.valorTotal = totalProdutos;
        return totalProdutos;
    }

    /* Toda vez que adicionar um produto verificar na lista se o produto já foi adicionado.
     * Se já foi adicionado, soma mais 1 a quantidade, 
     * caso contrário criar um novo produtoEscolhido com o produto selecionado.        
     */
    public String addProduto() {
        this.vazio = false;
        this.quantidadeProdutos++;

        if ((this.listaProdutoEscolhido != null) && (this.listaProdutoEscolhido.size() > 0)) {
            for (ProdutoEscolhidoBean produtoEscolhidoBean : listaProdutoEscolhido) {
                if (this.produto.equals(produtoEscolhidoBean.getProduto())) {
                    produtoEscolhidoBean.setQuantidade(produtoEscolhidoBean.getQuantidade() + 1);
                    calculaTotalProdutos();
                    return "mostarProdutos";
                }
            }
        }
        ProdutoEscolhidoBean novoProdutoEscolhidoBean = new ProdutoEscolhidoBean();
        novoProdutoEscolhidoBean.setProduto(this.produto);
        novoProdutoEscolhidoBean.setQuantidade(novoProdutoEscolhidoBean.getQuantidade() + 1);
        listaProdutoEscolhido.add(novoProdutoEscolhidoBean);

        calculaTotalProdutos();
        return "mostarProdutos";
    }

    public String remProduto() {
        if ((this.listaProdutoEscolhido != null) && (this.listaProdutoEscolhido.size() > 0)) {
            for (ProdutoEscolhidoBean produtoEscolhidoBean : listaProdutoEscolhido) {
                if (this.produto.equals(produtoEscolhidoBean.getProduto())) {
                    if (produtoEscolhidoBean.getQuantidade() != 0) {
                        produtoEscolhidoBean.setQuantidade(produtoEscolhidoBean.getQuantidade() - 1);

                        if (produtoEscolhidoBean.getQuantidade() <= 0) {
                            this.listaProdutoEscolhido.remove(produtoEscolhidoBean);
                            break;
                        }
                    }
                }
            }
        }
        this.quantidadeProdutos--; //Decrementa a quantidade de produtos do carrinho.            
        if (this.quantidadeProdutos <= 0) {
            this.vazio = true;
            this.quantidadeProdutos = 0;
        }
        calculaTotalProdutos();
        return "mostarProdutos";
    }

    public String getItens(Produto produtoAtual) {
        if ((this.listaProdutoEscolhido != null) && (this.listaProdutoEscolhido.size() > 0)) {
            for (ProdutoEscolhidoBean produtoEscolhidoBean : listaProdutoEscolhido) {
                if (produtoAtual.equals(produtoEscolhidoBean.getProduto())) {
                    return String.valueOf(produtoEscolhidoBean.getQuantidade());
                }
            }
        }
        return "0";
    }

    public String exibirCarrinho() {
        return "mostrarCarrinho";
    }  
}
