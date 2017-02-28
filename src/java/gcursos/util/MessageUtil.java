package gcursos.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author CHANDIMBA
 */
public class MessageUtil {
    
    public static void addSucessMessage(String message) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, null, message);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    
    public static void addSucessMessage(FacesContext facesContext, String message) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, null, message);
        facesContext.addMessage(null, facesMessage);
    }
    
    public static void addErrorMessage(String message) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, message);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    
    public static void addErrorMessage(FacesContext facesContext, String message) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, message);
        facesContext.addMessage(null, facesMessage);
    }
    
}
