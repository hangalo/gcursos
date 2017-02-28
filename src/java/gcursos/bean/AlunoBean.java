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
        } catch (Exception ex) {
            MessageUtil.addErrorMessage("Ocorreu um erro. Não foi possível salvar os dados do aluno com id " + aluno.getId());
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
        } catch (Exception ex) {
            MessageUtil.addErrorMessage("Ocorreu um erro. Não foi possível editar os dados do aluno com id " + aluno.getId());
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
        } catch (Exception ex) {
            MessageUtil.addErrorMessage("Ocorreu um erro. Não foi possível excluir o aluno com o id " + aluno.getId());
        }
    }
    
    public void findById() {
        try {
            aluno = alunoDAO.findById(id);
        } catch (Exception ex) {
            MessageUtil.addErrorMessage("Ocorreu um erro. Não foi possível buscar dados do aluno com o id " + id);
        }
    }
    
    
    public void findAll() {
        try {
            alunos = alunoDAO.findAll();
        } catch (Exception ex) {
            MessageUtil.addErrorMessage("Ocorreu um erro. Não foi possível buscar todos os alunos");
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

    public Aluno getAluno() {
        return aluno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
