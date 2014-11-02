/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ClienteService;

/** 
 *
 * @author vinicius
 */
@Controller
public class ClienteControl {

    private ClienteService clienteService;

    @Autowired
    public void setClienteService(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @RequestMapping("/index")
    public String controleIndex() {
        return "index";
    }

    @RequestMapping(value="/clienteFormView", method = RequestMethod.GET)
    public String controleClienteFormView(ModelMap model) {
        //Cliente cliente = new Cliente();
        model.addAttribute("clienteService", clienteService);
        return "clienteFormView";
    }

    //@RequestMapping(value="/clienteSalvoView", method = RequestMethod.POST)
    @RequestMapping(value="/clienteSalvoView")
    public String controleClienteSalvoView(@ModelAttribute("clienteService") ClienteService clienteService) {
        return "clienteSalvoView";
    }

}