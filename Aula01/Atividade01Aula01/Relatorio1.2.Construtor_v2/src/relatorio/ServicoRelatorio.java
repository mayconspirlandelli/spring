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

    private GeradorRelatorio geradorRelatorio;
    //private GeradorRelatorioHtml geradorRelatorioHtml;

    
    //public ServicoRelatorio(GeradorRelatorioHtml geradorRelatorioHtml) {
    public ServicoRelatorio(GeradorRelatorio geradorRelatorio) {
        super();
       this.geradorRelatorio = geradorRelatorio;
    }

    public void geraRelatorioAnual(int ano) {
        String estatisticas = "Estatísticas";
        // Coleta estatisticas do ano
        geradorRelatorio.gerar(estatisticas + " do ano " + ano);
        //geradorRelatorioHtml.gerar(estatisticas + " do ano " + ano);
        
        
    }

    public void geraRelatorioMensal(int ano, int mes) {
        String estatisticas = "Estatísticas";
        // Coleta estatisticas do mes
        geradorRelatorio.gerar(estatisticas + " do mês " + mes + " de " + ano);
        //geradorRelatorioHtml.gerar(estatisticas + " do mês " + mes + " de " + ano);
    }

    public void geraRelatorioDiario(int ano, int mes, int dia) {
        String estatisticas = "Estatísticas";
        // Coleta estatisticas do dia
        geradorRelatorio.gerar(estatisticas + " do dia " + dia + " de " + mes + " de " + ano);
        //geradorRelatorioHtml.gerar(estatisticas + " do dia " + dia + " de " + mes + " de " + ano);
    }


}