package br.ufg.inf.maycon.spring.gestaoacademicaweb.service;

import br.ufg.inf.maycon.spring.gestaoacademicaweb.model.Docente;
import java.util.List;

/**
 *
 * @author Maycon Spirlandelli
 */
public interface DocenteService {
    
    public void adicionarDocente(Docente docente);

    public void removerDocente(int id);

    public List<Docente> listarDocentes();
    
}
