/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.mb;

import gcursos.dao.CursoDAO;
import gcursos.modelo.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author informatica
 */
@Named(value = "cursoMBean")
@ViewScoped
public class CursoMBean {

    private Curso curso;
    private List<Curso> cursos;
    private CursoDAO cursoDAO;

    public CursoMBean() {
    }

    @PostConstruct()
    public void init() {

        curso = new Curso();
        cursos = new ArrayList<>();
        cursoDAO = new CursoDAO();
        cursos = cursoDAO.findAll();

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

    public void finishEdit(ActionEvent actionEvent) {
        cursoDAO.update(curso);
        cursos = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Acutalizar", "Dados actualizados com sucesso"));

    }

    public void salvare(ActionEvent actionEvent) {
        cursoDAO.save(curso);
        curso = new Curso();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Dados guardados com sucesso"));
    }

    public void eliminare(ActionEvent actionEvent) {
        cursoDAO.delete(curso);
        curso = new Curso();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Elimiar", "Dados eliminados com sucesso"));

    }

}
