package model;

import java.util.Objects;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maycon Spirlandelli
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Aluno {

    private int alunoId;
    private String nome;
    private int numeroMatricula;
    private int anoIngresso;
    private String cpf;

    public Aluno() {}
        
    public Aluno(String nome, int numeroMatricula, int anoIngresso, String cpf) {
        this.nome = nome.trim();
        this.numeroMatricula = numeroMatricula;
        this.anoIngresso = anoIngresso;
        this.cpf = cpf.trim();
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }        

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
        
    @Override
    public int hashCode() {
        return Objects.hash(nome, numeroMatricula, anoIngresso, cpf);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno alu = (Aluno) obj;
        if (!Objects.equals(this.nome, alu.nome)) {
            return false;
        }
        if (!Objects.equals(this.numeroMatricula, alu.numeroMatricula)) {
            return false;
        }
        if (!Objects.equals(this.cpf, alu.cpf)) {
            return false;
        }
        if (!Objects.equals(this.anoIngresso, alu.anoIngresso)) {
            return false;
        }
        // ... fazer para todos
        return true;
    }
}
