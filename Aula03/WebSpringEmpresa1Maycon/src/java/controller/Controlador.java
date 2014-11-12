package controller;

import model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vinicius
 */
@Controller
public class Controlador {

    @RequestMapping("/administrador")
    public ModelAndView controleAdmin() {
        String message = "Bem-vindo à página de administração!";
        return new ModelAndView("admin/administrador", "message", message);
    }

//    @RequestMapping("/index")
//    public ModelAndView controleIndex() {
//        return new ModelAndView("index");
//    }

    @RequestMapping("/index")
    public String controleIndex(ModelMap model) {
        Cliente cliente = new Cliente();
        model.addAttribute(cliente);
        return "index";
    }

}