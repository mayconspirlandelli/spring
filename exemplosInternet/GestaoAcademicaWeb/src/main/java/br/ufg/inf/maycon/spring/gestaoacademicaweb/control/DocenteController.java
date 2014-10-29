package br.ufg.inf.maycon.spring.gestaoacademicaweb.control;

import br.ufg.inf.maycon.spring.gestaoacademicaweb.model.Docente;
import br.ufg.inf.maycon.spring.gestaoacademicaweb.service.DocenteService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Maycon Spirlandelli
 */
@Controller
public class DocenteController  {
    
    @Autowired
    private DocenteService docenteService;
    
    @RequestMapping("/index")
    public String listarDocentes(Map<String, Object> map) {    
        map.put("docente", new Docente());
        map.put("docenteList", docenteService.listarDocentes());        
        return "listar_docentes";
    }
    
    @RequestMapping("/form")
    public String form(Map<String, Object> map) {        
        map.put("docente", new Docente());        
        return "inserir_docente_form";
    }
    
    @RequestMapping(value="/adicionar" , method = RequestMethod.POST)
    public String adicionarDocente(@ModelAttribute("docente") Docente docente , BindingResult result) {        
        docenteService.adicionarDocente(docente);        
        return "redirect:/index";
    }
    
    @RequestMapping("/remover/{docenteId}")
    public String removerDocente(@PathVariable("docenteId") int id) {        
        docenteService.removerDocente(id);
        return "redirect:/index";        
    }
}
