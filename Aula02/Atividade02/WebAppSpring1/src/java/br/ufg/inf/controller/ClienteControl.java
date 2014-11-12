/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.controller;

import br.ufg.inf.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author vinicius
 */
@Controller
@Lazy
public class ClienteControl {

    private Cliente cliente;

    @Autowired
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @RequestMapping("/index")
    public String controleIndex() {
        return "index";
    }

    //Para acessa a pagina: https://localhost:8080/clienteFormView
    @RequestMapping(value = "/clienteFormView", method = RequestMethod.GET)
    public String controleClienteFormView(Model model) {
        model.addAttribute("cliente", cliente);
        return "clienteFormView"; //Redireciona para a pagina.
    }

    @RequestMapping(value = "/clienteSalvoView")
    public String controleClienteSalvoView(Model model, Cliente cliente) {
        model.addAttribute("cliente", cliente);
        this.cliente = cliente;
        return "clienteSalvoView";
    }

    //Exemplo de como ler uma variavel de um template na requisicao
    @RequestMapping(value = "/clienteFormView/{pag}"    )
    public String controleClienteFormView2(@PathVariable String pag, Model model) {
        if (pag.equals("dois")) {
            cliente.setNome(pag);
            cliente.setEmail(pag);
            cliente.setSexo(pag);
            cliente.setTelefone(pag);
        } else if(pag.equals("index")){
            return "redirect:/index.html";
        } else {
            cliente = new Cliente();
        }
        model.addAttribute("cliente", cliente);
        return "clienteFormView";
    }

}
