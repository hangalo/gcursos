/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.mb;

import java.util.HashMap;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author informatica
 */
@Named(value = "relatorio")
@RequestScoped
public class Relatorio {

   @Inject
   GestorImpressao gestorImpressao;
    public Relatorio() {
    }
    
    public String imprimir(){
     String relatorio="funcionarios.jasper";
     
     HashMap paramentros = new HashMap();
     gestorImpressao.imprimirPDF(relatorio, paramentros);
     
        
        return null;
    
    }
    
}
