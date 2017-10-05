/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.mb;

import gcursos.dao.InstrutorDAO;

import gcursos.modelo.Instrutor;
import gcursos.modelo.Sexo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Rei Santo Hangalo
 */
@Named(value = "instrutorBean")
@SessionScoped
public class InstrutorBean implements Serializable {
    private static final long serialVersionUID=1L;
    private Instrutor instrutor;
   
    private InstrutorDAO instrutorDAO;
    private List<Instrutor> instrutors;
    
    public InstrutorBean() {
    }
    
     @PostConstruct
    public void inicializar(){
    instrutor = new Instrutor();
    instrutorDAO= new InstrutorDAO();
    instrutors= instrutorDAO.findAll();
    }
    public List<SelectItem> getOpSexos(){
    List<SelectItem> list= new ArrayList<>();
    for(Sexo sexo: Sexo.values()){
    list.add(new SelectItem(sexo, sexo.getAbreviatura()));
    }
    return list;
    }
    
    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public List<Instrutor> getInstrutors() {
        return instrutors;
    }

    public void setInstrutors(List<Instrutor> instrutors) {
        this.instrutors = instrutors;
    }
    
     public void sava(ActionEvent event){
        instrutorDAO.save(instrutor);
        instrutor= new Instrutor();
        instrutor=null;
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Guardar","Cadastrados com Sucesso"));
     
    }
    public void edit(ActionEvent event){
    instrutorDAO.update(instrutor);
    instrutors=null;
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Atualizar","Dados Actualizados com Sucesso"));
    }
    public void delete(ActionEvent event){
        instrutorDAO.delete(instrutor);
        instrutor= new Instrutor();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Eliminar","Dados Elimidados com Sucesso"));
     }
 public List<Instrutor> getListaInstrutors(){
     if (instrutors== null) {
         instrutors= instrutorDAO.findAll();
         
     }
     return instrutors;
 }

    
}
