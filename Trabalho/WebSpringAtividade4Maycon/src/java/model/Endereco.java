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
@Table(name="endereco")
@AttributeOverride(name="objectID", column=@Column(name="endereco_id"))
@SequenceGenerator(name = "SEQUENCE", sequenceName = "endereco_endereco_id_seq")
public class Endereco extends BaseModel{
        
    @Column
    private String rua;

    @Column
    private String setor;

    @Column
    private String complemento;

    @Column
    private String cidade;

    @Column
    private String estado;

    @Column
    private int cep;

    @Column(name="cliente_id") //coluna e atributo tem nomes diferntes, por isso e preciso (name="XX")
    private long clienteId;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }   
}
