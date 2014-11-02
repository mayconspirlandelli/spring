/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.model;

import java.util.Objects;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 *
 * @author vinicius
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cliente {

    private String nome;
    private String telefone;
    private String email;
    private String sexo;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "O cliente \"" + this.nome + "\" foi inserido com sucesso!";
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, email, sexo);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente cli = (Cliente) obj;
        if (!Objects.equals(this.nome, cli.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, cli.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, cli.email)) {
            return false;
        }
        if (!Objects.equals(this.sexo, cli.sexo)) {
            return false;
        }
        return true;
    }

}
