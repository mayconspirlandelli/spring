package br.ufg.inf.controller;

/**
 *
 * @author Maycon Spirlandelli
 */
import br.ufg.inf.model.Produto;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Maycon Spirlandelli
 */
@Controller
public class ProdutoControl {

    private Produto produto;

    @Autowired
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
//       @RequestMapping(value = "/clienteFormView", method = RequestMethod.GET)
//    public String controleClienteFormView(Model model) {
//        model.addAttribute("cliente", cliente);
//        return "clienteFormView";
//    }
//
//    @RequestMapping(value = "/clienteSalvoView")
//    public String controleClienteSalvoView(Model model, Cliente cliente) {
//        model.addAttribute("cliente", cliente);
//        this.cliente = cliente;
//        return "clienteSalvoView";
//    }

    @RequestMapping(value = "/produtoFormView", method = RequestMethod.GET)
    public String controleProdutoFormView(Produto produto) {        
        return "produtoFormView";
    }
//    @RequestMapping(value = "/produtoFormView", method = RequestMethod.GET)
//    public String controleProdutoFormView(@RequestParam("codigo") int codigo,
//            @RequestParam("nome") String nome,
//            @RequestParam("preco") Double preco) {
//
//        return "produtoFormView";
//    }

//    @RequestMapping(value = "/produtoFormView", method = RequestMethod.GET)
//    public String controleProdutoFormView(@ModelAttribute("produtoModel") @RequestParam("codigo") int codigo,
//            @RequestParam("nome") String nome,
//            @RequestParam("preco") Double preco, Model model) {
//        model.addAttribute("nome", nome);
//        model.addAttribute("codigo", nome);
//        model.addAttribute("preco", nome);
//        return "produtoFormView";
//    }
    @RequestMapping(value = "/produtoSalvoView")
    //public String controleProdutoSalvoView(@ModelAttribute("produto") Produto produto) {        
    public String controleProdutoSalvoView(Model model, Produto produto) {
        model.addAttribute("produto", produto);
        this.produto = produto;
        return "produtoSalvoView";
    }
}
