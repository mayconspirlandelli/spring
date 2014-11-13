package validator;

import model.Aluno;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Maycon Spirlandelli
 */
@Component
public class ValidatorAluno implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Aluno.class.equals(type);
    }
    
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "nome.obrigatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpf", "cpf.obrigatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matricula", "matricula.obrigatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ano", "ano.obrigatorio");        
    }
}
