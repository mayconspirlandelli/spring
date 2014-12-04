package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Maycon Spirlandelli
 */
@Entity
@Table(name = "cliente")
@AttributeOverride(name = "objectID", column = @Column(name = "cliente_id"))
@SequenceGenerator(name = "SEQUENCE", sequenceName = "cliente_cliente_id_seq")
public class Cliente extends BaseModel {

    @Column
    private String nome;

    @Column(name = "telefone_fixo")
    private String telefoneFixo;

    @Column(name = "telefone_celular")
    private String telefoneCelular;

    @Column
    private String sexo;

    @Column
    private String usuario;

    @Column
    private String senha;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento", nullable = false, length = 10)
    private Date dataNascimento;

    @Column(name = "cpf", nullable = false)
    private long cpf;

    //FetchType: EAGER anteriormente buscados; LAZY: posteriormente buscados
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    //Cpf do tipo string - para auxiliar a trabalhar com mascara.
    @Transient
    private String cpfs = "";

    public Cliente() {
    }

    public Cliente(String nome, String telefoneCelular, String telefoneFixo, String sexo,
            String usuario, String senha, Date dataNascimento, int cpf, List<Endereco> enderecos) {
        this.nome = nome;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.sexo = sexo;
        this.usuario = usuario;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    public void setCpfs(String cpfs) {
        cpfs = cpfs.trim();
        this.cpfs = cpfs;
        try {
            cpfs = this.cpfs.substring(0,3);  //111.111.111-11
            cpfs += this.cpfs.substring(4,7);
            cpfs += this.cpfs.substring(8,11);
            cpfs += this.cpfs.substring(12,14);
        } catch (Exception e){
            //do nothing;
        }
        this.cpf = Long.parseLong(cpfs);
    }
    
    public String getCpfs() {
        String cpfs = String.valueOf(this.cpf);
        try {
            cpfs = cpfs.substring(0,3) + "." + cpfs.substring(3,6) + "." + cpfs.substring(6,9) + 
                "-" + cpfs.substring(9,11);
        } catch (Exception e) {
            //do nothing;
        }
        return cpfs;
    }
    
     /**
     * @return the enderecos
     */
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    /**
     * @param enderecos the enderecos to set
     */
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
