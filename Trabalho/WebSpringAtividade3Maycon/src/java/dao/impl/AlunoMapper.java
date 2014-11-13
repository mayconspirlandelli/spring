package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Aluno;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Maycon Spirlandelli
 */
public class AlunoMapper implements RowMapper<Aluno> {

    @Override
    public Aluno mapRow(ResultSet rs, int rowNum) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setAlunoId(rs.getInt("aluno_id"));
        aluno.setNome(rs.getString("nome"));
        aluno.setNumeroMatricula(rs.getInt("numero_matricula"));
        aluno.setAnoIngresso(rs.getInt("ano_ingresso"));
        aluno.setCpf(rs.getString("cpf"));
        return aluno;
    }
}
