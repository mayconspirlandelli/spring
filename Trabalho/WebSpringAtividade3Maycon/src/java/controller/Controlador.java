package controller;

import model.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author maycon
 */
@Controller
public class Controlador {
    

//    @RequestMapping("/index")
//    public ModelAndView controleIndex() {
//        return new ModelAndView("index");
//    }


    @RequestMapping("/index")
    public String controleIndex(ModelMap model) {        
        Aluno aluno = new Aluno();
        model.addAttribute(aluno);
        return "index";
    }

}