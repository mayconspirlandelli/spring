package dao;

import java.util.List;
import model.Aluno;

/**
 *
 * @author Maycon Spirlandelli
 */
public interface AlunoDao {    
    void atualizar(Aluno aluno);
    void excluir(Aluno aluno);
    void salvar(Aluno aluno);    
    List todosAlunos();        
    Aluno procurarAluno(String cpf);    
}
