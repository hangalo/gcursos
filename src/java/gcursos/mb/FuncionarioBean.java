/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.mb;

import gcursos.dao.FuncionarioDAO;
import gcursos.modelo.Funcionario;
import gcursos.modelo.Sexo;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Rei Santo Hangalo
 */
@Named(value = "funcionarioBean")
@ViewScoped
public class FuncionarioBean {

    private static final long serialVersionUID=1L;
    private Funcionario funcionario;
    private List<Sexo> sexos;
    private FuncionarioDAO funcionarioDAO;
    private List<Funcionario> funcionarios;
    
    public FuncionarioBean() {
    }
    public void inicializar(){
    funcionario= new Funcionario();
    sexos= Arrays.asList(Sexo.values());
    funcionarioDAO= new FuncionarioDAO();
    }
    
    public List<SelectItem> getOpSexos(){
    List<SelectItem> list= new ArrayList<>();
    for(Sexo sexo: Sexo.values()){
    list.add(new SelectItem(sexo, sexo.getAbreviatura()));
    }
    return list;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Sexo> getSexos() {
        return sexos;
    }

    public void setSexos(List<Sexo> sexos) {
        this.sexos = sexos;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    public void sava(ActionEvent event){
        funcionarioDAO.save(funcionario);
        funcionario= new Funcionario();
        funcionario=null;
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Guardar","Cadastrados com Sucesso"));
     
    }
    public void edit(ActionEvent event){
    funcionarioDAO.update(funcionario);
    funcionarios=null;
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Atualizar","Dados Actualizados com Sucesso"));
    }
    public void delete(ActionEvent event){
        funcionarioDAO.delete(funcionario);
        funcionario= new Funcionario();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Eliminar","Dados Elimidados com Sucesso"));
     }
 public List<Funcionario> getListaFuncionarios(){
     if (funcionarios== null) {
         funcionarios= funcionarioDAO.findAll();
         
     }
     return funcionarios;
 }
}
