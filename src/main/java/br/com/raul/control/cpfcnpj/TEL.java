package br.com.raul.control.cpfcnpj;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * @author Gilberto Toledo
 */
public class TEL {
//    private String tel;
    private static final String Formato = "(##)# ####-####";
    
    
    public static DefaultFormatterFactory getFormat(){
        try {
            return new DefaultFormatterFactory(new MaskFormatter(Formato));
        } catch (Exception e) {
            return null;
        }
    }
}
