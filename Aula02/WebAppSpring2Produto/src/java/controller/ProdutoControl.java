package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ProdutoService;

/**
 *
 * @author Maycon Spirlandelli
 */
@Controller
public class ProdutoControl {
       
    private ProdutoService produtoService;

    @Autowired
    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    

    @RequestMapping(value = "/produtoFormView", method = RequestMethod.GET)
    public String controleProdutoFormView(ModelMap model) {
        model.addAttribute("produtoService", produtoService);
        return "produtoFormView";
    }

    //@RequestMapping(value = "/produtoSalvoView", method = RequestMethod.GET)
    @RequestMapping(value = "/produtoSalvoView")
    public String controleProdutoSalvoView(@ModelAttribute("produtoService") ProdutoService produtoService) {        
        return "produtoSalvoView";
    }

}
