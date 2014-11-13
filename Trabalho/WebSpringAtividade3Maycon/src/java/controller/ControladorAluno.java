package controller;

import dao.AlunoDao;
import java.util.List;
import model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import validator.ValidatorAluno;

/**
 *
 * @author Maycon Spirlandelli
 */
@Controller
@SessionAttributes("aluno")
public class ControladorAluno {

    @Autowired
    private AlunoDao alunoDao;

    @Autowired
    private ValidatorAluno validatorAluno;

    //Exibir o formulario de cadastro de aluno.
    @RequestMapping(value = "/cadastrarAluno", method = RequestMethod.GET) 
    public String formularioAluno(ModelMap model) {
        model.addAttribute("aluno", new Aluno());
        return "inserirAluno";
    }
    
    @RequestMapping(value = "/alunoCadastrado", method = RequestMethod.POST)
    public String cadastrarAluno(@ModelAttribute("aluno") Aluno aluno, BindingResult bResult) {
        validatorAluno.validate(aluno, bResult);        
        if(bResult.hasErrors()) {
            return "inserirAluno";
        } else {
            alunoDao.salvar(aluno);
            return "alunos"; //exibir a lista apos cadastro.
        }        
    }
    
    @RequestMapping(value = "/obterAlunos", method = RequestMethod.GET)
    public String obterAlunos(ModelMap model) {
        List<Aluno> listaAlunos = alunoDao.todosAlunos();
        model.addAttribute("listaAlunos", listaAlunos);
        return "alunos"; //exibir a lista apos cadastro.
    }
}
