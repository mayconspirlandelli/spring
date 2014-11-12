/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author vinicius
 */
public class ProdutoMapper implements RowMapper<Produto>{
    
    public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Produto produto = new Produto();
        produto.setNome(rs.getString("nome"));
        produto.setPreco(rs.getFloat("preco"));
        produto.setDescricao(rs.getString("descricao"));
        produto.setCodigo(rs.getInt("codigo"));
        return produto;
    }

}