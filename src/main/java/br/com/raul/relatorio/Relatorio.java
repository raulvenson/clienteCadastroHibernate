/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.raul.relatorio;

import br.com.raul.control.Cliente;
import java.io.InputStream;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author VRauuul
 */
public class Relatorio {
    
    public void gerarRelatorio(List<Cliente> lCliente) throws JRException{
        
        String fonte = "D:\\Projetos\\CadastroClientes\\cadastroClienteM\\src\\main\\java\\report\\relatorio.jasper";
        
//        JasperReport report = JasperCompileManager.compileReport(fonte);
        
        JasperPrint print = JasperFillManager.fillReport(fonte, null, new JRBeanCollectionDataSource(lCliente)); 
        //JasperPrint print = JasperFillManager.fillReport(fonte, null, new JRBeanCollectionDataSource(lCliente)); 
        
        JasperViewer.viewReport(print, false);
        
    }
    
}
