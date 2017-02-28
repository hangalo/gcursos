package gcursos.mb;

import gcursos.dao.AlunoDAO;
import gcursos.modelo.Aluno;
import gcursos.util.MessageUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * @author CHANDIMBA
 */
@Named(value = "alunoBean")
@ViewScoped
public class AlunoBean implements Serializable {

    private AlunoDAO alunoDAO;
    private List<Aluno> alunos;
    private Aluno aluno;

    public void save() {
        try {
            alunoDAO.save(aluno);
            createAluno();
            MessageUtil.addSucessMessage(FacesContext.getCurrentInstance(), "Aluno salvo com sucesso!!!");
        } catch (Exception ex) {
            MessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "Ocorreu um erro. Não foi possível salvar os dados do aluno com id " + aluno.getId());
        }
    }

    public void update() {
        try {
            alunoDAO.update(aluno);
            createAluno();
            MessageUtil.addSucessMessage(FacesContext.getCurrentInstance(), "Aluno editado com sucesso!!!");
        } catch (Exception ex) {
            MessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "Ocorreu um erro. Não foi possível editar os dados do aluno com id " + aluno.getId());
        }
    }

    public void delete() {
        try {
            alunoDAO.delete(aluno);
            MessageUtil.addSucessMessage(FacesContext.getCurrentInstance(), "Aluno com ID " + aluno.getId() + " e Nome " + aluno.getNomeCompeto() + " foi excluído com sucesso!!!");
            createAluno();
        } catch (Exception ex) {
            MessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "Ocorreu um erro. Não foi possível excluir o aluno com o id " + aluno.getId());
        }
    }

    public void findById() {
        try {
            aluno = alunoDAO.findById(aluno.getId());
        } catch (Exception ex) {
            MessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "Ocorreu um erro. Não foi possível buscar dados do aluno com o id " + aluno.getId());
        }
    }

    public void findAll() {
        try {
            alunos = alunoDAO.findAll();
        } catch (Exception ex) {
            MessageUtil.addErrorMessage(FacesContext.getCurrentInstance(), "Ocorreu um erro. Não foi possível buscar todos os alunos");
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

}