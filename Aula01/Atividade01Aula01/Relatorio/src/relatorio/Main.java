/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author vinicius
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ServicoRelatorio serRel = new ServicoRelatorio(2); //1 pdf; 2 html.
//        serRel.geraRelatorioAnual(2010);
//        serRel.geraRelatorioMensal(2010,04);
//        serRel.geraRelatorioDiario(2010,04,30);

        //Caminho Relativo
        ApplicationContext contexto = new ClassPathXmlApplicationContext("config/relatorio.xml");

        //Caminho Absoluto
        //ApplicationContext ctx = new FileSystemXmlApplicationContext("file:/home/alunoinf/conf/relatorio.xml");


        ServicoRelatorio beanServico = (ServicoRelatorio) contexto.getBean("servicoRelatorio");       
        beanServico.geraRelatorioAnual(2014);        
        beanServico.geraRelatorioMensal(2010, 04);
        beanServico.geraRelatorioDiario(2010, 04, 30);





    }
}
