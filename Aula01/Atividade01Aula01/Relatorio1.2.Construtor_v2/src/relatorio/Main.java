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

        //Caminho Relativo
        ApplicationContext contexto = new ClassPathXmlApplicationContext("config/relatorio.xml");

        //Caminho Absoluto
        //ApplicationContext ctx = new FileSystemXmlApplicationContext("file:/home/alunoinf/conf/relatorio.xml");


        ServicoRelatorio beanServico = (ServicoRelatorio) contexto.getBean("servicoRelatorioPdf");
        beanServico.geraRelatorioAnual(2014);
        beanServico.geraRelatorioMensal(2014, 04);
        beanServico.geraRelatorioDiario(2014, 04, 30);

         System.out.println("********************************************************");
         
        String teste[] = contexto.getBeanDefinitionNames();
        for (String valor : teste) {
            System.out.println("teste:" + valor);
        }

        beanServico = (ServicoRelatorio) contexto.getBean("servicoRelatorioHtml");
        beanServico.geraRelatorioAnual(2016);
        beanServico.geraRelatorioMensal(2016, 05);
        beanServico.geraRelatorioDiario(2016, 06, 31);

        System.out.println("********************************************************");

        /*Outra maneira de fazer */
        //String relatorio = "servicoRelatorioPdf";
        String relatorio = "servicoRelatorioHtml";

        if (relatorio.equals("servicoRelatorioHtml")) {
            beanServico = (ServicoRelatorio) contexto.getBean(relatorio);
        }
        if (relatorio.equals("servicoRelatorioPdf")) {
            beanServico = (ServicoRelatorio) contexto.getBean(relatorio);
        }
        
        beanServico.geraRelatorioAnual(2016);
        beanServico.geraRelatorioMensal(2016, 05);
        beanServico.geraRelatorioDiario(2016, 06, 31);




    }
}
