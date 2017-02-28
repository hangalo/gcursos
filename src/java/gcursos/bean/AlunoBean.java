package gcursos.bean;

import gcursos.dao.AlunoDAO;
import gcursos.excepcao.GCursoException;
import gcursos.modelo.Aluno;
import gcursos.util.MessageUtil;
import gcursos.validator.PessoaValidator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author CHANDIMBA
 */
@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable{
    
    private AlunoDAO alunoDAO;
    private List<Aluno> alunos;
    private Aluno aluno;
    private Integer id;
    
    private PessoaValidator pessoaValidator;
    
    public void save() {
        try {
            if(pessoaValidator.validatePessoa(aluno)) {
                alunoDAO.save(aluno);
                createAluno();
                MessageUtil.addSucessMessage("Aluno salvo com sucesso!!!");
            } else {
                MessageUtil.addErrorMessage(pessoaValidator.getInvalidateFields());
            }
        } catch (GCursoException ex) {
            MessageUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void update() {
        try {
            if(pessoaValidator.validatePessoa(aluno)) {
                alunoDAO.update(aluno);
                createAluno();
                MessageUtil.addSucessMessage("Aluno editado com sucesso!!!");
            } else {
                MessageUtil.addErrorMessage(pessoaValidator.getInvalidateFields());
            }
        } catch (GCursoException ex) {
            MessageUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void delete() {
        try {
            if(pessoaValidator.validatePessoa(aluno)) {
                alunoDAO.delete(aluno);
                MessageUtil.addSucessMessage("Aluno com ID " + aluno.getId() + " e Nome " +aluno.getNomeCompeto()+ " foi excluído com sucesso!!!");
                createAluno();
            } else {
                MessageUtil.addErrorMessage(pessoaValidator.getInvalidateFields());
            }
        } catch (GCursoException ex) {
            MessageUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void findById() {
        try {
            aluno = alunoDAO.findById(id);
        } catch (GCursoException ex) {
            MessageUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    
    public void findAll() {
        try {
            alunos = alunoDAO.findAll();
        } catch (GCursoException ex) {
            MessageUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    @PostConstruct
    public void initAttributs() {
        createAluno();
        alunos = new ArrayList<>();
        
        alunoDAO = new AlunoDAO();
    }
    
    public void createAluno() {
        aluno = new Aluno();
    }
    
}
