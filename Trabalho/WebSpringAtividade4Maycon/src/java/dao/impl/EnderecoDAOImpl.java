package dao.impl;

import dao.EnderecoDAO;
import model.Endereco;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maycon Spirlandelli
 */
@Repository
public class EnderecoDAOImpl implements EnderecoDAO {

    /**
     * Objeto de sessao com Banco de Dados
     */
    @Autowired
    //Caso houvesse mais de um bean tipo SessionFactory, seria preciso:
    //@Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Metodo chamado para atualizar endereco na tabela Endereco do banco de
     * dados
     *
     * @param Endereco
     */
    @Transactional //Delega ao Hibernate o controle de transacoes
    public void atualizar(Endereco endereco) {
        this.sessionFactory.getCurrentSession().update(endereco);
    }

    @Transactional
    public void excluir(Endereco endereco) {
        this.sessionFactory.getCurrentSession().delete(endereco);
    }

    @Transactional
    public void salvar(Endereco endereco) {
        this.sessionFactory.getCurrentSession().save(endereco);
    }
}
