/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author vinicius
 */
public class ClienteMapper implements RowMapper<Cliente> {
    
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setNome(rs.getString("nome"));
        cliente.setTelefoneFixo(rs.getString("telefone_fixo"));
        cliente.setTelefoneCelular(rs.getString("telefone_celular"));
        cliente.setSexo(rs.getString("sexo"));
        cliente.setUsuario(rs.getString("usuario"));
        cliente.setSenha(rs.getString("senha"));
        cliente.setDataNascimento(rs.getDate("data_nascimento"));
        cliente.setCpf(rs.getLong("cpf"));
        cliente.setAdministrador(rs.getBoolean("administrador"));
        return cliente;
    }

}
