package br.ufg.inf.maycon.spring.gestaoacademicaweb.service;

import br.ufg.inf.maycon.spring.gestaoacademicaweb.dao.DocenteDAO;
import br.ufg.inf.maycon.spring.gestaoacademicaweb.model.Docente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maycon Spirlandelli
 */
@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteDAO docenteDAO;

    @Transactional
    @Override
    public void adicionarDocente(Docente docente) {
        docenteDAO.adicionarDocente(docente);
    }

    @Transactional
    @Override
    public void removerDocente(int id) {
        docenteDAO.removerDocente(id);
    }

    @Transactional
    @Override
    public List<Docente> listarDocentes() {
        return docenteDAO.listarDocentes();
    }

}
