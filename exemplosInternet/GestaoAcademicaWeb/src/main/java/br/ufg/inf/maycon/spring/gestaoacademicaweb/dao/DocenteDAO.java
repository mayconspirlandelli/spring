package br.ufg.inf.maycon.spring.gestaoacademicaweb.dao;

import br.ufg.inf.maycon.spring.gestaoacademicaweb.model.Docente;
import java.util.List;

/**
 *
 * @author Maycon Spirlandelli
 */
public interface DocenteDAO {

    public void adicionarDocente(Docente docente);

    public void removerDocente(int id);

    public List<Docente> listarDocentes();
}
