/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author vinicius
 */
public class ClienteService {

    private Cliente cliente;

    @Autowired
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public String toString(){
        return "O cliente \"" + cliente.getNome() + "\" foi inserido com sucesso!";
    }

}
