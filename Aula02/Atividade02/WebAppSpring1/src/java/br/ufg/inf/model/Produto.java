package br.ufg.inf.model;

/**
 *
 * @author Maycon Spirlandelli
 */
public class Produto {
    
    private String nome;    
    private int codigo;
    private Double preco;

    public Produto() {
    }
    
    public Produto(String nome, int codigo, Double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

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
    
}
