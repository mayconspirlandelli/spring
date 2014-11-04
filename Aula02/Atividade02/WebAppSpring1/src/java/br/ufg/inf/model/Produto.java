package br.ufg.inf.model;

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
public class Produto {
    
    private String nome;    
    private int codigo;
    private Double preco;
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }   
    
     public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }    
    
    @Override
    public String toString() {
        return "O produto \"" + this.nome + "\" foi inserido com sucesso!";
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo, preco);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto prod = (Produto) obj;
        if (!Objects.equals(this.nome, prod.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, prod.codigo)) {
            return false;
        }
        if (!Objects.equals(this.preco, prod.preco)) {
            return false;
        }        
        return true;
    }    
}
