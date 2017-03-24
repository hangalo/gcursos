/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.mb;

import gcursos.dao.CategoriaCursoDAO;
import gcursos.modelo.CategoriaCurso;
import gcursos.modelo.Curso;
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
@Named(value = "categoriaCursoMBean")
@ViewScoped
public class CategoriaCursoMBean implements Serializable {

    /**
     * Creates a new instance of CategoriaCursoMBean
     */
    private CategoriaCurso categoriaCurso;
    private List<CategoriaCurso> categoriaCursos;
    private CategoriaCursoDAO categoriaCursoDAO;

    public CategoriaCursoMBean() {
    }

    @PostConstruct()
    public void init() {
        categoriaCurso = new CategoriaCurso();
        categoriaCursoDAO = new CategoriaCursoDAO();
        categoriaCursos = new ArrayList<>();

        categoriaCursos = categoriaCursoDAO.findAll();
    }

    public CategoriaCurso getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(CategoriaCurso categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }
    
    
    
     public void edit(ActionEvent actionEvent) {
        categoriaCursoDAO.update(categoriaCurso);
        categoriaCurso = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Acutalizar", "Dados actualizados com sucesso"));

    }

    public void save(ActionEvent actionEvent) {
       categoriaCursoDAO.save(categoriaCurso);
        categoriaCurso = new CategoriaCurso();
        categoriaCursos = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Dados guardados com sucesso"));
    }

    public void delete(ActionEvent actionEvent) {
        categoriaCursoDAO.delete(categoriaCurso);
        categoriaCurso = new CategoriaCurso();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Elimiar", "Dados eliminados com sucesso"));

    }


     public void reset() {
        RequestContext.getCurrentInstance().reset("formGuardarCategoriaCurso");
    }

    public List<CategoriaCurso> getCategoriaCursos() {
        return categoriaCursos;
    }

    public void setCategoriaCursos(List<CategoriaCurso> categoriaCursos) {
        this.categoriaCursos = categoriaCursos;
    }
    
    
}
