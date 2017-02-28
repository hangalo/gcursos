package gcursos.excepcao;

/**
 * @author CHANDIMBA
 */
public class GCursoException extends Exception{
    
    private String mensagem;

    public GCursoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
    
}
