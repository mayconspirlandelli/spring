/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package relatorio;

/**
 *
 * @author vinicius
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServicoRelatorio serRel = new ServicoRelatorio(2); //1 pdf; 2 html.
        serRel.geraRelatorioAnual(2010);
        serRel.geraRelatorioMensal(2010,04);
        serRel.geraRelatorioDiario(2010,04,30);
    }

}
