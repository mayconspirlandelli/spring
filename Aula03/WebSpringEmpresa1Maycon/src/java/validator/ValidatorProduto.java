/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import model.Produto;
import org.springframework.stereotype.Component;

/**
 *
 * @author vinicius
 */
@Component
public class ValidatorProduto implements Validator {

    /*
     * Valida se o parametro passado é da classe Produto.
     */
    public boolean supports(Class<?> type) {
        return Produto.class.equals(type);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "nome.obrigatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "preco", "preco.obrigatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "descricao.obrigatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigo", "codigo.obrigatorio");
        Produto prod = (Produto) o;
        if (prod.getPreco() >= 1000000) {
            errors.rejectValue("preco", "preco.muitoGrande");
        }
        if (prod.getPreco() <= 0) {
            errors.rejectValue("preco", "preco.muitoPequeno");
        }
        if (prod.getCodigo() <= 0) {
            errors.rejectValue("codigo", "codigo.invalido");
        }
    }
}
