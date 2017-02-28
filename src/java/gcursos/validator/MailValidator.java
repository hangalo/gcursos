package gcursos.validator;

import gcursos.util.MessageUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author CHANDIMBA
 */
@FacesValidator
public class MailValidator implements Validator{

    private final String PATTERN = "^[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z_+])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9}$";
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        if(!value.toString().matches(PATTERN)) {
            MessageUtil.addErrorMessage(context, "O formato do email não é válido");
        }
        
    }
    
}
