package br.ufg.inf.maycon.spring.gestaoacademicaweb.dao;

import br.ufg.inf.maycon.spring.gestaoacademicaweb.model.Docente;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Maycon Spirlandelli
 */
@Repository
public class DocenteDAOImpl implements DocenteDAO {
    
    private SessionFactory sessionFactory;
    
    @Override
    public void adicionarDocente(Docente docente) {
        sessionFactory.getCurrentSession().save(docente);
    }

    @Override
    public void removerDocente(int id) {
        Docente docente = (Docente) sessionFactory.getCurrentSession().load(Docente.class, id);
        if (null != docente) {
            sessionFactory.getCurrentSession().delete(docente);
        }
    }

    @Override
    public List<Docente> listarDocentes() {
        return sessionFactory.getCurrentSession().createQuery("from DOCENTE").list();
    }
    
}
