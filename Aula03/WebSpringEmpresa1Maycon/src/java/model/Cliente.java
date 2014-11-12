/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Objects;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author vinicius
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cliente {

    private String nome;
    private String telefoneFixo;
    private String telefoneCelular;
    private String sexo;
    private String usuario;
    private String senha;
    private Date dataNascimento = new Date();
    private long cpf;
    private boolean administrador;

    public Cliente() {
        //Em branco
    }

    public Cliente(String nome, String telefoneFixo, String telefoneCelular, String sexo,
            String usuario, String senha, Date dataNascimento, long cpf, boolean administrador) {
        this.nome = nome.trim();
        this.telefoneFixo = telefoneFixo.trim();
        this.telefoneCelular = telefoneCelular.trim();
        this.sexo = sexo.trim();
        this.usuario = usuario.trim();
        this.senha = senha.trim();
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.administrador = administrador;
    }

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
        this.nome = nome.trim();
    }

    /**
     * @return the telefoneFixo
     */
    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    /**
     * @param telefoneFixo the telefoneFixo to set
     */
    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo.trim();
    }

    /**
     * @return the telefoneCelular
     */
    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    /**
     * @param telefoneCelular the telefoneCelular to set
     */
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular.trim();
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
        this.sexo = sexo.trim();
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario.trim();
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha.trim();
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the cpf
     */
    public long getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, usuario, cpf, sexo);
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
        if (!Objects.equals(this.usuario, cli.usuario)) {
            return false;
        }
        if (!Objects.equals(this.cpf, cli.cpf)) {
            return false;
        }
        if (!Objects.equals(this.sexo, cli.sexo)) {
            return false;
        }
        // ... fazer para todos
        return true;
    }
}