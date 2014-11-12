/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.ProdutoDAO;
import model.Produto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

///**
// *
// * @author vinicius
// */
////ESTENDENDO JdbcDaoSupport E SEM USAR ANOTACOES
////A anotacao @Repository permite que a classe seja encontrada para que seja configurada sem
////a necessidade de fornecer um arquivo XML de configuracao.
////Utilizada para busca de classes que possuem objeto dataSource para ser injetado.
////Desnecessario quando se estende JdbcDaoSupport
////@Repository 
//public class ProdutoDAOImpl extends JdbcDaoSupport implements ProdutoDAO {
//
////    DESNECESSARIO QUANDO SE ESTENDE JdbcDaoSupport
////    private JdbcTemplate jdbcTemplate;
////
////    @Autowired
////    public void setDataSource(DriverManagerDataSource dataSource) {
////        this.jdbcTemplate = new JdbcTemplate(dataSource);
////    }
//
//    /**
//     * Metodo chamado para atualizar produto na tabela Produto do banco de dados.
//     * @param produto
//     */
//    public void atualizar (Produto produto){ 
//        String sql = "UPDATE produto SET nome=?, preco=?, descricao=? " +
//                    "WHERE codigo=?";
//        getJdbcTemplate().update(sql, new Object[] {produto.getNome(), produto.getPreco(),
//                                    produto.getDescricao(), produto.getCodigo()});
//    }
//
//    /**
//     * Metodo chamado para excluir produto na tabela Produto do banco de dados.
//     * @param produto
//     */
//    public void excluir (Produto produto) {
//        String sql = "DELETE FROM produto WHERE codigo = ?";
//        getJdbcTemplate().update(sql, produto.getCodigo());
//    }
//
//    /**
//     * Metodo chamado para adicionar produto na tabela Produto do banco de dados.
//     * @param produto
//     */
//    public void salvar (Produto produto) {
//        String sql = "INSERT INTO produto (nome, preco, descricao, codigo) " +
//                    "values (?, ?, ?, ?)";
//        getJdbcTemplate().update(sql, new Object[] {produto.getNome(), produto.getPreco(),
//                                    produto.getDescricao(), produto.getCodigo()});
//    }
//
//    /**
//     * Metodo chamado para listar todos os produtos na tabela Produto do banco de dados.
//     * @return
//     */
//    public List todosProdutos () { 
//        String sql = "SELECT * FROM produto";
//        List<Produto> listProdutos = getJdbcTemplate().query(sql, new ProdutoMapper());
//        return listProdutos;
//    }
//
//    /**
//     * Metodo chamado para executar query para procurar produto na tabela
//     * Produto do banco de dados. Parametro da consulta: codigo.
//     * @param codigo
//     * @return
//     */
//    public Produto procurarProduto(int codigo) {
//        String sql = "SELECT * FROM produto WHERE codigo=?";
//        try {
//            Produto produto = getJdbcTemplate().queryForObject(sql,
//                    new Object[] {codigo},
//                    new ProdutoMapper());
//            return produto;
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
//
//}

/**
 *
 * @author vinicius
 */
//********* SEM ESTENDER JdbcDaoSupport E USANDO ANOTACOES
//A anotacao @Repository permite que a classe seja encontrada para que seja configurada sem
//a necessidade de fornecer um arquivo XML de configuracao.
//Utilizada para busca de classes que possuem objeto dataSource para ser injetado.
//Desnecessario quando se estende JdbcDaoSupport
@Repository 
public class ProdutoDAOImpl implements ProdutoDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Metodo chamado para atualizar produto na tabela Produto do banco de dados.
     * @param produto
     */
    public void atualizar (Produto produto){ 
        String sql = "UPDATE produto SET nome=?, preco=?, descricao=? " +
                    "WHERE codigo=?";
        jdbcTemplate.update(sql, new Object[] {produto.getNome(), produto.getPreco(),
                                    produto.getDescricao(), produto.getCodigo()});
    }

    /**
     * Metodo chamado para excluir produto na tabela Produto do banco de dados.
     * @param produto
     */
    public void excluir (Produto produto) {
        String sql = "DELETE FROM produto WHERE codigo = ?";
        jdbcTemplate.update(sql, produto.getCodigo());
    }

    /**
     * Metodo chamado para adicionar produto na tabela Produto do banco de dados.
     * @param produto
     */
    public void salvar (Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, descricao, codigo) " +
                    "values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {produto.getNome(), produto.getPreco(),
                                    produto.getDescricao(), produto.getCodigo()});
    }

    /**
     * Metodo chamado para listar todos os produtos na tabela Produto do banco de dados.
     * @return
     */
    public List todosProdutos () { 
        String sql = "SELECT * FROM produto";
        List<Produto> listProdutos = jdbcTemplate.query(sql, new ProdutoMapper());
        return listProdutos;
    }

    /**
     * Metodo chamado para executar query para procurar produto na tabela
     * Produto do banco de dados. Parametro da consulta: codigo.
     * @param codigo
     * @return
     */
    public Produto procurarProduto(int codigo) {
        String sql = "SELECT * FROM produto WHERE codigo=?";
        try {
            Produto produto = jdbcTemplate.queryForObject(sql,
                    new Object[] {codigo},
                    new ProdutoMapper());
            return produto;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
