package model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Maycon Spirlandelli
 */
@Entity
@Table(name = "produto")
@AttributeOverride(name = "objectID", column = @Column(name = "produto_id"))
@SequenceGenerator(name = "SEQUENCE", sequenceName = "produto_produto_id_seq")
public class Produto extends BaseModel {

    @Column(name = "nome") //(name = "nome") somente necessario quando atributo e coluna forem diferentes
    private String nome;

    @Column
    private String descricao;

    @Column
    private int codigo;

    @Column
    private float preco;

    public Produto() {
    }

    public Produto(String nome, String descricao, int codigo, float preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}