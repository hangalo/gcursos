/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.mb;

import gcursos.dao.TurmaDAO;
import gcursos.modelo.CategoriaCurso;
import gcursos.modelo.Turma;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author informatica
 */
@Named(value = "turmaBean")
@ViewScoped
public class TurmaBean implements Serializable {

    private Turma turma;
    private List<Turma> turmas;
    private TurmaDAO turmaDAO;

    public TurmaBean() {
    }

    @PostConstruct()
    public void init() {
        turma = new Turma();
        turmaDAO = new TurmaDAO();
        turmas = new ArrayList<>();
        turmas = turmaDAO.findAll();
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    
    
    
    
    
 public void edit(ActionEvent actionEvent) {
       turmaDAO.update(turma);
        turma = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Acutalizar", "Dados actualizados com sucesso"));

    }

    public void save(ActionEvent actionEvent) {
       turmaDAO.save(turma);
        turma = new Turma();
        turmas = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Dados guardados com sucesso"));
    }

    public void delete(ActionEvent actionEvent) {
        turmaDAO.delete(turma);
        turma = new Turma();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Elimiar", "Dados eliminados com sucesso"));

    }


     public void reset() {
        RequestContext.getCurrentInstance().reset("formGuardarCategoriaCurso");
    }

   
    
}
