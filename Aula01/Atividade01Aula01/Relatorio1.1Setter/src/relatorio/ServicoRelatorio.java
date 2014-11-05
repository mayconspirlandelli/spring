/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package relatorio;

/**
 *
 * @author vinicius
 */
public class ServicoRelatorio {

    
    private GeradorRelatorioHtml  geradorRelatorioHTML;

    public void setGeradorRelatorioHTML(GeradorRelatorioHtml geradorRelatorioHTML) {
        this.geradorRelatorioHTML = geradorRelatorioHTML;
    }
  
    public void geraRelatorioAnual(int ano) {
        String estatisticas = "Estatísticas";
        // Coleta estatisticas do ano
        geradorRelatorioHTML.gerar(estatisticas + " do ano " + ano);        
    }

    public void geraRelatorioMensal(int ano, int mes) {
        String estatisticas = "Estatísticas";
        // Coleta estatisticas do mes
        geradorRelatorioHTML.gerar(estatisticas + " do mês " + mes + " de " + ano);        
    }

    public void geraRelatorioDiario(int ano, int mes, int dia) {
        String estatisticas = "Estatísticas";
        // Coleta estatisticas do dia
        geradorRelatorioHTML.gerar(estatisticas + " do dia " + dia + " de " + mes + " de " + ano);        
    }

   

}