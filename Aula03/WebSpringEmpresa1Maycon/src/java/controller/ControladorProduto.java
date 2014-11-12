/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.ProdutoDAO;
import java.util.List;
import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import validator.ValidatorProduto;

/**
 *
 * @author vinicius
 */
@Controller
//@SessionAttributes("produto") //nao e necessario o produto na sessao p/ esta aplicacao
public class ControladorProduto {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private ValidatorProduto validatorProduto;

    @RequestMapping("/produto")
    public ModelAndView controleProd() {
        String message = "Bem-vindo ao sistema de cadastro de produtos!";
        return new ModelAndView("produto/produto", "message", message);
    }

    @RequestMapping(value="/mostrarProdutos", method = RequestMethod.GET)
    public String mostraProdutos(ModelMap model) {
        List<Produto> listaProdutos = produtoDAO.todosProdutos();
        model.addAttribute("listaProdutos", listaProdutos);        
        return "produto/mostrarProdutos";
    }

    @RequestMapping(value="/cadastrarProduto", method = RequestMethod.GET)
    public String formularioProduto(ModelMap model) {
        model.addAttribute("produto", new Produto());
        return "produto/cadastrarProduto";
    }

    @RequestMapping(value="/produtoCadastrado", method = RequestMethod.POST)
    public String salvarProduto(ModelMap model, @ModelAttribute("produto") Produto produto, BindingResult bResult) {
        validatorProduto.validate(produto, bResult);
        if (bResult.hasErrors()) {
            return "produto/cadastrarProduto";
	} else {
            produtoDAO.salvar(produto);
            model.addAttribute("produto", new Produto());
            return "redirect:/mostrarProdutos";
        }
    }

    @RequestMapping(value="/atualizarProduto")
    public String formularioAtualizarProduto(@RequestParam(required=true, value="codigo") String codigo,
            ModelMap model) {
        int cod;
        try {
            cod = Integer.valueOf(codigo);
        } catch (Exception e){
            cod = -1;
        }
        Produto produto = produtoDAO.procurarProduto(cod);
        if (produto != null) {
            model.addAttribute("produto", produto);                        
            return "produto/atualizarProduto";
        } else {
            model.addAttribute("message", "O produto de código \'" + codigo + "\' não foi encontrado.");
            //testar
            //return "produto/mostrarProdutos"; e
            //return ""; e
            //return "redirect:/mostrarProdutos";
            
            String resultado = mostraProdutos(model);
            return resultado;
        }
    }

    @RequestMapping(value="/produtoAtualizado", method = RequestMethod.POST)
    public String atualizarProduto(ModelMap model, @ModelAttribute("produto") Produto produto, BindingResult bResult) {
        validatorProduto.validate(produto, bResult);
        if (bResult.hasErrors()) {
            return "produto/atualizarProduto";
	} else {
            produtoDAO.atualizar(produto);
            model.addAttribute("produto", new Produto());
            return "redirect:/mostrarProdutos";
        }
    }

    @RequestMapping(value="/excluirProduto", method = RequestMethod.GET)
    public String excluirProduto(@RequestParam(required=true, value="codigo") int codigo) {
        Produto produto = produtoDAO.procurarProduto(codigo);
        produtoDAO.excluir(produto);
        return "redirect:/mostrarProdutos";
    }

}
