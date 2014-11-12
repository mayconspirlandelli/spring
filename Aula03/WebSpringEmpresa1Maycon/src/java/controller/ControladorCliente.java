package controller;

import dao.ClienteDAO;
import java.util.List;
import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import validator.ValidatorCliente;

/**
 *
 * @author vinicius
 */
@Controller
@SessionAttributes("cliente")
public class ControladorCliente {

    @Autowired
    private ClienteDAO clienteDAO;
    @Autowired
    private ValidatorCliente validatorCliente;

    /**
     * @param produtoDAO the produtoDAO to set
     */
//    public void setClienteDAO(ClienteDAOImpl clienteDAOImpl) {
//        this.clienteDAO = clienteDAOImpl;
//    }
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public String cliente(ModelMap model) {
        Cliente cli = (Cliente) model.get("cliente");
        if (cli == null || cli.getCpf() == 0) {
            Cliente cliente = new Cliente();
            model.addAttribute(cliente);
            return "login";
        } else {
            return "cliente/cliente";
        }
    }

    @RequestMapping(value = "/autenticar", method = RequestMethod.POST)
    public String autenticar(
            @RequestParam(required = true, value = "usuario") String usuario,
            @RequestParam(required = true, value = "senha") String senha,
            ModelMap model) {
        Cliente cliente = clienteDAO.procurarCliente(usuario, senha);
        if (cliente == null || cliente.getCpf() == 0) {
            model.addAttribute("message", "Erro na autenticação; usuário ou senha inválido(s)!");
            return "login";
        } else {
            model.addAttribute(cliente);
            return "cliente/cliente";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        Cliente cliente = new Cliente();
        model.addAttribute(cliente);
        return "index";
    }

//    @RequestMapping(value = "/atualizarCliente", method = RequestMethod.GET)
//    public String formularioAtualizarCliente(ModelMap model) {
//        return "cliente/atualizarCliente";
//    }
    @RequestMapping(value = "/atualizarCliente", method = RequestMethod.GET)
    public String formularioAtualizarCliente(@RequestParam(required = true, value = "cpf") String strCpf, ModelMap model) {
        long cpf;
        try {
            cpf = Long.valueOf(strCpf);
        } catch (Exception e) {
            cpf = -1;
        }
        Cliente cliente = clienteDAO.procurarCliente(cpf);
        if (cliente != null && cliente.getCpf() > 0) {
            model.addAttribute("cliente", cliente);
            return "cliente/atualizarCliente";
        } else {
            model.addAttribute("message", "O cliente de CPF \'" + cpf + "\' não encontrado.");
            String resultado = mostraClientes(model);
            return resultado;
        }
    }

    //Mostrar o cliente apos alteração.
    @RequestMapping(value = "/clienteAtualizado", method = RequestMethod.POST)
    public String atualizarCliente(@ModelAttribute("cliente") Cliente cliente, BindingResult bResult) {
        validatorCliente.validate(cliente, bResult);
        if (bResult.hasErrors()) {
            return "cliente/atualizarCliente";
        } else {
            clienteDAO.atualizar(cliente);
            return "cliente/cliente";
        }
    }

    @RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
    public String formularioCliente(ModelMap model) {
        Cliente cliente = new Cliente();
        model.addAttribute(cliente);
        return "cliente/cadastrarCliente";
    }

    //Ao se solicitar a insercao dos dados do cliente no BD, faz-se a validacao primeiramente.
    @RequestMapping(value = "/clienteCadastrado", method = RequestMethod.POST)
    public String salvarCliente(@ModelAttribute("cliente") Cliente cliente, BindingResult bResult) {
        validatorCliente.validate(cliente, bResult);
        if (bResult.hasErrors()) {
            return "cliente/cadastrarCliente";
        } else {
            clienteDAO.salvar(cliente);
            return "cliente/cliente";
        }
    }

    @RequestMapping(value = "/excluirCliente", method = RequestMethod.GET)
    public String excluirCliente(@RequestParam(required = true, value = "cpf") long cpf) {
        Cliente cliente = clienteDAO.procurarCliente(cpf);
        clienteDAO.excluir(cliente);
        return "redirect:/mostraClientes";
    }
//    @RequestMapping(value="/excluirCliente", method = RequestMethod.GET)
//    public String excluirCliente(ModelMap model, @ModelAttribute("cliente") Cliente cliente) {
//        clienteDAO.excluir(cliente);
//        model.addAttribute("cliente", new Cliente());
//        return "index";
//    }

    @RequestMapping(value = "/mostraClientes", method = RequestMethod.GET)
    public String mostraClientes(ModelMap model) {
        List<Cliente> listaClientes = clienteDAO.todosClientes();
        model.addAttribute("listaClientes", listaClientes);
        return "cliente/mostraClientes";
    }
}