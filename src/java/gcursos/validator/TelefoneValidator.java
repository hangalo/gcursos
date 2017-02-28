package gcursos.validator;

import gcursos.util.MessageUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author CHANDIMBA
 */
@FacesValidator
public class TelefoneValidator implements Validator{

    private final String OPERADORAS_MOVEIS = "(91|92|93|94|96|97|99)\\d{7}";
    private final String PATTERN_MOVEL = "(244)?" + OPERADORAS_MOVEIS;
    private final String PATTERN_FIXO = "(244)?(222)\\d{6}";
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        String telefone = value.toString();
        
        if(!telefone.matches(PATTERN_MOVEL) && !telefone.matches(PATTERN_FIXO)) {
            MessageUtil.addErrorMessage(context, "O " + component.getId() + " não é válido.");
        }
        
    }
    
}
