/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.ClienteDAO;
import model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

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
//public class ClienteDAOImpl extends JdbcDaoSupport implements ClienteDAO {
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
//     * Metodo chamado para atualizar cliente na tabela Cliente do banco de dados
//     * @param cliente
//     */
//    public void atualizar (Cliente cliente){
//        String sql = "UPDATE cliente SET nome=?, telefone_fixo=?, " +
//                    "telefone_celular=?, sexo=?, usuario=?, senha=?, " +
//                    "data_nascimento=?  WHERE cpf=?";
//        getJdbcTemplate().update(sql, new Object[] {cliente.getNome(), cliente.getTelefoneFixo(),
//                            cliente.getTelefoneCelular(), cliente.getSexo(), cliente.getUsuario(),
//                            cliente.getSenha(), cliente.getDataNascimento(), cliente.getCpf()});
//    }
//
//    /**
//     * Metodo chamado para excluir cliente na tabela Cliente do banco de dados
//     * @param cliente
//     */
//    public void excluir (Cliente cliente){
//        String sql = "DELETE FROM cliente WHERE cpf=?";
//        getJdbcTemplate().update(sql, cliente.getCpf());
//    }
//
//    /**
//     * Metodo chamado para inserir cliente na tabela Cliente do banco de dados
//     * @param cliente
//     */
//    public void salvar (Cliente cliente){
//        String sql = "INSERT INTO cliente (nome, telefone_fixo, telefone_celular, sexo," +
//                    "usuario, senha, data_nascimento, cpf) " +
//                    "values (?, ?, ?, ?, ?, ?, ?, ?)";
//        getJdbcTemplate().update(sql, new Object[] {cliente.getNome(), cliente.getTelefoneFixo(),
//                            cliente.getTelefoneCelular(), cliente.getSexo(), cliente.getUsuario(),
//                            cliente.getSenha(), cliente.getDataNascimento(), cliente.getCpf()});
//    }
//
//    /**
//     * Metodo chamado para procurar cliente na tabela
//     * Cliente do banco de dados. Parametro da consulta: cpf.
//     * @param cpf
//     * @return Cliente
//     */
//    public Cliente procurarCliente(long cpf){
//        String sql = "SELECT * FROM cliente WHERE cpf=?";
//        try {
//            Cliente cliente = getJdbcTemplate().queryForObject(sql, 
//                    new Object[] {cpf},
//                    new ClienteMapper());
//            return cliente; }
//        catch (EmptyResultDataAccessException e) {
//            return new Cliente();
//        }
//    }
//
//    /**
//     * Metodo chamado para executar query para procurar cliente na tabela
//     * Cliente do banco de dados. Parametro da consulta: usuario e senha.
//     * @param usuario
//     * @param senha
//     * @return Cliente
//     */
//    public Cliente procurarCliente(String usuario, String senha){
//        String sql = "SELECT * FROM cliente WHERE usuario=? AND senha=?";
//        try {
//            Cliente cliente = getJdbcTemplate().queryForObject(sql,
//                    new Object[] {usuario, senha},
//                    new ClienteMapper());
//            return cliente;
//        } catch (EmptyResultDataAccessException e) {
//            return new Cliente();
//        }
//    }
//
//    /**
//     * Metodo chamado para executar query para listar todos clientes na tabela
//     * Cliente do banco de dados. Parametro da consulta: cpf.
//     * @return List<Cliente>
//     */
//    public List todosClientes (){
//        String sql = "SELECT * FROM cliente";
//        List<Cliente> listClientes = (List<Cliente>) getJdbcTemplate().queryForObject(sql,
//                    new ClienteMapper());
//        return listClientes;
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
public class ClienteDAOImpl implements ClienteDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Metodo chamado para atualizar cliente na tabela Cliente do banco de dados
     * @param cliente
     */
    public void atualizar (Cliente cliente){
        String sql = "UPDATE cliente SET nome=?, telefone_fixo=?, " +
                    "telefone_celular=?, sexo=?, usuario=?, senha=?, " +
                    "data_nascimento=?  WHERE cpf=?";
        jdbcTemplate.update(sql, new Object[] {cliente.getNome(), cliente.getTelefoneFixo(),
                            cliente.getTelefoneCelular(), cliente.getSexo(), cliente.getUsuario(),
                            cliente.getSenha(), cliente.getDataNascimento(), cliente.getCpf()});
    }

    /**
     * Metodo chamado para excluir cliente na tabela Cliente do banco de dados
     * @param cliente
     */
    public void excluir (Cliente cliente){
        String sql = "DELETE FROM cliente WHERE cpf=?";
        jdbcTemplate.update(sql, cliente.getCpf());
    }

    /**
     * Metodo chamado para inserir cliente na tabela Cliente do banco de dados
     * @param cliente
     */
    public void salvar (Cliente cliente){
        String sql = "INSERT INTO cliente (nome, telefone_fixo, telefone_celular, sexo," +
                    "usuario, senha, data_nascimento, cpf, administrador) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {cliente.getNome(), cliente.getTelefoneFixo(),
                            cliente.getTelefoneCelular(), cliente.getSexo(), cliente.getUsuario(),
                            cliente.getSenha(), cliente.getDataNascimento(), cliente.getCpf(), cliente.getAdministrador()});
    }

    /**
     * Metodo chamado para procurar cliente na tabela
     * Cliente do banco de dados. Parametro da consulta: cpf.
     * @param cpf
     * @return Cliente
     */
    public Cliente procurarCliente(long cpf){
        String sql = "SELECT * FROM cliente WHERE cpf=?";
        try {
            Cliente cliente = jdbcTemplate.queryForObject(sql, 
                    new Object[] {cpf},
                    new ClienteMapper());
            return cliente; }
        catch (EmptyResultDataAccessException e) {
            return new Cliente();
        }
    }

    /**
     * Metodo chamado para executar query para procurar cliente na tabela
     * Cliente do banco de dados. Parametro da consulta: usuario e senha.
     * @param usuario
     * @param senha
     * @return Cliente
     */
    public Cliente procurarCliente(String usuario, String senha){
        String sql = "SELECT * FROM cliente WHERE usuario=? AND senha=?";
        try {
            Cliente cliente = jdbcTemplate.queryForObject(sql,
                    new Object[] {usuario, senha},
                    new ClienteMapper());
            return cliente;
        } catch (EmptyResultDataAccessException e) {
            return new Cliente();
        }
    }

    /**
     * Metodo chamado para executar query para listar todos clientes na tabela
     * Cliente do banco de dados. Parametro da consulta: cpf.
     * @return List<Cliente>
     */
//    public List todosClientes (){
//        String sql = "SELECT * FROM cliente";
//        List<Cliente> listClientes = (List<Cliente>) jdbcTemplate.queryForObject(sql,
//                    new ClienteMapper());
//        return listClientes;
//    }
    public List todosClientes (){
        String sql = "SELECT * FROM cliente";
        List<Cliente> listClientes = jdbcTemplate.query(sql, new ClienteMapper());
        return listClientes;
    }    
}