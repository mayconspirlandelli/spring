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

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "nome.obrigatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpf", "cpf.obrigatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numeroMatricula", "matricula.obrigatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "anoIngresso", "ano.obrigatorio");

        Aluno aluno = (Aluno) o;

        if (aluno.getAnoIngresso() < 1900) {
            errors.rejectValue("anoIngresso", "ano.menorQ1900");
        }
        if (!(Integer.toString(aluno.getAnoIngresso()).length() == 4)) {
            errors.rejectValue("anoIngresso", "ano.possui4numeros");            
        }
        if(!validaCpf(aluno.getCpf())) {
            errors.rejectValue("cpf", "cpf.invalido");            
        }
    }

    public boolean validaCpf(String cpf) { // formato XXX.XXX.XXX-XX
        boolean validado = true;
        if (!cpf.substring(0, 1).equals("")) {
            try {
                int d1 = 0, d2 = 0;
                int digito1 = 0, digito2 = 0, resto = 0;
                int digitoCPF;
                String nDigResult;
                cpf = cpf.replace('.', ' ');
                cpf = cpf.replace('-', ' ');
                cpf = cpf.replaceAll(" ", "");
                for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
                    digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();
                    //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
                    d1 = d1 + (11 - nCount) * digitoCPF;
                    //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
                    d2 = d2 + (12 - nCount) * digitoCPF;
                }
                //Primeiro resto da divisão por 11.      
                resto = (d1 % 11);
                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.      
                if (resto < 2) {
                    digito1 = 0;
                } else {
                    digito1 = 11 - resto;
                }
                d2 += 2 * digito1;
                //Segundo resto da divisão por 11.
                resto = (d2 % 11);
                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
                if (resto < 2) {
                    digito2 = 0;
                } else {
                    digito2 = 11 - resto;
                }
                //Digito verificador do CPF que está sendo validado.
                String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());
                //Concatenando o primeiro resto com o segundo.
                nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
                //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
                validado = nDigVerific.equals(nDigResult);
            } catch (Exception e) {
                System.err.println("Erro !" + e);
                validado = false;
            }
        } else {
            validado = false;
        }
        return validado;
    }
}
