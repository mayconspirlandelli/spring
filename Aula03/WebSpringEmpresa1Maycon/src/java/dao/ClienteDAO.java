/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author vinicius
 */
public interface ClienteDAO {

    /**
     * Metodo para atualizar objeto cliente na tabela Cliente.
     * @param cliente
     */
    void atualizar (Cliente cliente);

    /**
     * Metodo para excluir cliente da tabela Cliente.
     * @param cliente
     */
    void excluir (Cliente cliente);

    /**
     * Metodo para adicionar objeto cliente na tabela Cliente.
     * @param cliente
     */
    void salvar (Cliente cliente);

    /**
     * Metodo retorna uma lista de objetos com todas as tuplas da tabela Cliente.
     * @return List<Cliente>
     */
    List todosClientes ();

    /**
     * Metodo retorna um objeto do tipo Cliente, consultado pelo cpf
     * @param cpf
     * @return Cliente
     */
    Cliente procurarCliente(long cpf);

    /**
     * Metodo retorna um objeto do tipo Cliente, consultado pelo usuario e senha
     * @param usuario
     * @param senha
     * @return Cliente
     */
    Cliente procurarCliente(String usuario, String senha);

}
