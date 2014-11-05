/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package relatorio;

/**
 *
 * @author vinicius
 */
public class GeradorRelatorioPdf implements GeradorRelatorio {

    public void gerar(String relatorio) {
        System.out.println("Relatorio PDF gerado:" + relatorio);
    }
    
}
