package gcursos.validator;

import gcursos.modelo.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CHANDIMBA
 */
public class PessoaValidator {
    
    private final String PREFIXO_UNITEL = "(244)?(92|93|94|96)\\d{7}";
    private final String PREFIXO_MOVICEL = "(244)?(91|97|99)\\d{7}";
    private final String PREFIXO_FIXO = "(244)?222\\d{6}";
    private List<String> errors = new ArrayList<>();
    
    public boolean isNull(Object object) {
        return object == null;
    }
    
    public boolean isEmpty(String field) {
        return field.isEmpty();
    }
    
    public boolean isTelemovelUnitel(String telemovel) {
        return isTelefoneValido(telemovel, PREFIXO_UNITEL);
    }
    
    public boolean isTelemovelMovicel(String telemovel) {
        return isTelefoneValido(telemovel, PREFIXO_MOVICEL);
    }
    
    public boolean isTelemovelFixo(String telemovel) {
        return isTelefoneValido(telemovel, PREFIXO_FIXO);
    }
    
    public boolean isTelefoneValido(String telemovel, String prefixoOperadora) {
        if(telemovel.length() == 9 || telemovel.length() == 12) {
            if(telemovel.matches(prefixoOperadora)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isEmail(String email) {
        return email.matches("^[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z_+])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9}$");
        //return email.matches("\\w([-_\\.]?\\w)*@\\w(\\.\\w)+");
    }
    
    public boolean isId(String email) {
        return email.matches("\\d{1,}");
        //return email.matches("\\w([-_\\.]?\\w)*@\\w(\\.\\w)+");
    }
    /**
     * Valida o objecto pessoa e os seus atributos.
     * @param pessoa pessoa a validar
     * @return true caso existam atributos não preenchidos que devem ser obrigatoriamente preenchidos
     */
    public boolean validatePessoa(Pessoa pessoa) {
        
        if(isNull(pessoa)) {
            errors.add("O ojecto " + pessoa.getClass().getSimpleName() + " não foi criado");
            return false;
        }
        if(isNull(pessoa.getPrimeiroNome()) || isEmpty(pessoa.getPrimeiroNome())) {
            errors.add("O Primeiro Nome é obrigatório");
        }
        if(isNull(pessoa.getSobrenome()) || isEmpty(pessoa.getSobrenome())) {
            errors.add("O Sobrenome é obrigatório");
        }
        
        if(isEmpty(pessoa.getTelefoneFixo()) || isEmpty(pessoa.getTelefoneUnitel()) || isEmpty(pessoa.getTelefoneMovicel())) {
            errors.add("Um dos telefones deve ser informado");
        }
        
        if(!isEmail(pessoa.getEmail())) {
            errors.add("O formao do email não é válido");
        }
        
        return errors.isEmpty();
    }

    public String getInvalidateFields() {
        StringBuilder stringBuilder = new StringBuilder();
        
        errors.forEach(error -> {
            stringBuilder.append(error);
            stringBuilder.append("\n");
        });
        
        return stringBuilder.toString();
    }
    
}
