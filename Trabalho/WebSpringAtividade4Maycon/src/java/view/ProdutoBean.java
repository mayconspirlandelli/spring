package view;

import dao.ProdutoDAO;
import java.util.List;
import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maycon Spirlandelli
 */
@Component
public class ProdutoBean {

    private Produto produto;

    @Autowired
    private ProdutoDAO produtoDAO;

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        produto.setDescricao(produto.getDescricao().trim());
        produto.setNome(produto.getNome().trim());
        this.produto = produto;
    }

    //METODOS PARA MANIPULACAO DE DADOS DO PRODUTO
    /**
     * Metodo chamado para criar novo objeto Produto.
     *
     * @return - String - retorna pagina/formulario para insercao de novo
     * produto.
     */
    public String novoProduto() {
        Produto p = new Produto("", "", 0, 0);
        setProduto(p);
        return "cadastrarProduto";
    }

    /**
     * Metodo chamado para retornar uma estrutura com todos os objetos Produto
     * no BD.
     *
     * @return - DataModel - model.
     * @throws EmpresaDAOException
     */
    public List getTodosProdutos1() {
        List<Produto> lstProd = produtoDAO.todosProdutos();
        return lstProd;
    }
    
     /**
     * Metodo chamado para salvar as alteracoes no produto no Banco de Dados (BD).
     * @return - String - retorna pagina com todos os produtos disponiveis no BD.
     * @throws EmpresaDAOException
     */
    public String atualizarProduto() {
        produtoDAO.atualizar(produto);
        return "mostrarProdutos";
    }

     /**
     * Medodo chamado para buscar produto a ser atualizado pelo usuario.
     * @return - String - retorna a pagina/formulario para atualizar dados do produto.
     */
    public String editarProduto() {
        return "atualizarProduto";
    }
    
    /**
     * Metodo chamado para excluir um produto da tabela produto da base de dados
     * @return - String - retorna pagina com todos os produtos disponiveis no BD.
     * @throws EmpresaDAOException
     */
    public String excluirProduto() {
        produtoDAO.excluir(this.produto);
     
        return "mostrarProdutos";
    }
    
    /**
     * Metodo chamado para incluir/salvar novo produto no banco de dados.
     * @return - String - retorna pagina com todos os produtos disponíveis no BD.
     * @throws EmpresaDAOException
     */
    public String incluirProduto() {
        produtoDAO.salvar(produto);
        return "mostrarProdutos";
    }    
}