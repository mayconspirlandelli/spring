package dao.impl;

import dao.AlunoDao;
import java.util.List;
import model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maycon Spirlandelli
 */

@Repository
public class AlunoDaoImpl implements AlunoDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * private String nome; private int numeroMatricula; private int
     * anoIngresso; private String cpf;
     *
     * ? nome (texto); ? numero_matricula (inteiro); ? ano_ingresso (inteiro); ?
     * cpf (string); ? aluno_id (serial ? campo auto-incrementável ? opcional).
     */
    @Override
    public void atualizar(Aluno aluno) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE aluno SET nome=? , ");
        sql.append("numero_matricula=? , ");
        sql.append("ano_ingresso=? , ");
        sql.append("cpf=?  ");
        sql.append("WHERE aluno_id=?");
        jdbcTemplate.update(sql.toString(), new Object[]{
            aluno.getNome(),
            aluno.getNumeroMatricula(),
            aluno.getAnoIngresso(),
            aluno.getCpf(),
            aluno.getAlunoId()});
    }

    @Override
    public void excluir(Aluno aluno) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM aluno WHERE aluno_id=?");
        jdbcTemplate.update(sql.toString(), aluno.getAlunoId());
    }

    @Override
    public void salvar(Aluno aluno) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO aluno (nome, numero_matricula, ano_ingresso, cpf) ");
        sql.append("values(?,?,?,?)");
        jdbcTemplate.update(sql.toString(), new Object[]{
            aluno.getNome(),
            aluno.getNumeroMatricula(),
            aluno.getAnoIngresso(),
            aluno.getCpf()});
    }

    @Override
    public List todosAlunos() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM aluno");
        List<Aluno> listaAlunos = jdbcTemplate.query(sql.toString(), new AlunoMapper());
        return listaAlunos;
    }

    @Override
    public Aluno procurarAluno(String cpf) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM aluno WHERE cpf=?");
        try { 
            Aluno aluno = jdbcTemplate.queryForObject(sql.toString(), 
                    new Object[] {cpf},
                    new AlunoMapper());
            return aluno;
        } catch (EmptyResultDataAccessException e) {
            return new Aluno();
        }        
    }
}
