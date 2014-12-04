package dao.impl;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maycon Spirlandelli
 */
@Repository
public class ClienteDAOImpl implements ClienteDAO {

    /**
     * Objeto de sessao com Banco de Dados
     */
    @Autowired
    //Caso houvesse mais de um bean tipo SessionFactory, seria preciso:
    //@Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

      /**
     * Metodo chamado para atualizar cliente na tabela Cliente do banco de dados
     * @param Cliente
     */
    @Transactional  //Delega ao Hibernate o controle de transacoes
    public void atualizar (Cliente cliente){
        this.sessionFactory.getCurrentSession().merge(cliente);
    }


   
    /**
     * Metodo chamado para excluir cliente na tabela Cliente do banco de dados
     * @param Cliente
     */
    @Transactional
    public void excluir (Cliente cliente){
        this.sessionFactory.getCurrentSession().delete(cliente);
    }

    /**
     * Metodo chamado para inserir cliente na tabela Cliente do banco de dados
     * @param Cliente
     */
    @Transactional
    public void salvar (Cliente cliente){
        this.sessionFactory.getCurrentSession().save(cliente);
    }

    /**
     * Metodo chamado para executar query para listar todos clientes na tabela
     * Cliente do banco de dados. Parametro da consulta: cpf.
     * @return List<Cliente>
     */
    @Transactional(readOnly=true) //Somente operacao de leitura
    public List todosClientes (){
        try{
            List listCliente = this.sessionFactory.getCurrentSession()
                    .createQuery("FROM Cliente").list();
            return listCliente;
        } catch (Exception e){
            return new ArrayList<Cliente>();
        }
    }
    /**
     * Metodo chamado para procurar cliente na tabela
     * Cliente do banco de dados. Parametro da consulta: cpf.
     * @param long cpf
     * @return Cliente
     */
    @Transactional(readOnly=true) //Somente operacao de leitura
    public Cliente procurarCliente(long cpf){
        try{
            Query query = this.sessionFactory.getCurrentSession()
                    .createQuery("FROM Cliente c WHERE c.cpf = :cpf")
                    .setLong("cpf", cpf);
            Cliente cliente = (Cliente) query.uniqueResult();
            return cliente;
        } catch (Exception e){
            return new Cliente();
        }
    }

    /**
     * Metodo chamado para executar query para procurar cliente na tabela
     * Cliente do banco de dados. Parametro da consulta: usuario e senha.
     * @param String usuario
     * @param String senha
     * @return Cliente
     */
    @Transactional(readOnly=true) //Somente operacao de leitura
    public Cliente procurarCliente(String usuario, String senha){
        try{
            Query query = this.sessionFactory.getCurrentSession()
                    .createQuery("FROM Cliente c WHERE c.usuario = :usuario "
                    + "AND c.senha = :senha")
                    .setString("usuario", usuario).setString("senha", senha);
            Cliente cliente = (Cliente) query.uniqueResult();
            return cliente;
        } catch (Exception e){
            return new Cliente();
        }
    }
}
