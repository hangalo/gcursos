/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.crypto.Data;

/**
 *
 * @author praveen
 */
public class Funcionario  implements Serializable{

    
    private static final long serialVersionUID = 1L;
    private int id;
    private String primeiroNome;
    private String segundoNome;
    private String sobrenome;
    private Date dataNascimento;
    private Sexo sexo;
    private String telefonePrincipal;
    private String telefoneAlternativo;
    private String email;
    private String facebook;
       
    public Funcionario() {
    }

    public Funcionario(int id, String primeiroNome, String segundoNome, String sobrenome, Date dataNascimento, Sexo sexo, String telefonePrincipal, String telefoneAlternativo, String email, String facebook) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefonePrincipal = telefonePrincipal;
        this.telefoneAlternativo = telefoneAlternativo;
        this.email = email;
        this.facebook = facebook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSegundoNome() {
        return segundoNome;
    }

    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(String telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    public String getTelefoneAlternativo() {
        return telefoneAlternativo;
    }

    public void setTelefoneAlternativo(String telefoneAlternativo) {
        this.telefoneAlternativo = telefoneAlternativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

   
   

    
    
}
