/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.mb;

import gcursos.dao.CategoriaCursoDAO;
import gcursos.dao.CursoDAO;
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
@Named(value = "cursoMBean")
@ViewScoped
public class CursoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Curso curso;
    private List<Curso> cursos;
    private CursoDAO cursoDAO;
    private CategoriaCursoDAO categoriaCursoDAO;
    private List<CategoriaCurso> categoriaCursos;

    public CursoMBean() {
    }

    @PostConstruct()
    public void init() {

        curso = new Curso();
        cursoDAO = new CursoDAO();
        categoriaCursoDAO = new CategoriaCursoDAO();
        cursos = cursoDAO.findAll();
        categoriaCursos = new ArrayList<>();
        categoriaCursos = categoriaCursoDAO.findAll();

    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<CategoriaCurso> getCategoriaCursos() {

        return categoriaCursos;
    }

    public void setCategoriaCursos(List<CategoriaCurso> categoriaCursos) {
        this.categoriaCursos = categoriaCursos;
    }

    public void edit(ActionEvent actionEvent) {
        cursoDAO.update(curso);
        cursos = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Acutalizar", "Dados actualizados com sucesso"));

    }

    public void save(ActionEvent actionEvent) {
        cursoDAO.save(curso);
        curso = new Curso();
        cursos = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Dados guardados com sucesso"));
    }

    public void delete(ActionEvent actionEvent) {
        cursoDAO.delete(curso);
        curso = new Curso();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Elimiar", "Dados eliminados com sucesso"));

    }

    public void reset() {
        RequestContext.getCurrentInstance().reset("regisarNovoCurso");
    }
}
