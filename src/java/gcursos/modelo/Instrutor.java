/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author praveen
 */
public class Instrutor extends Pessoa implements Serializable{

    private static final long serialVersionUID = 1L;
    private int idInstrutor;
    private String primeiroNomeInstrutor;
    private String segundoNomeInstrutor;
    private String sobrenomeInstrutor;
    private Date dataNascimentoInstrutor;
    private Sexo sexo;
    private String telefonePrincipalInstrutor;
    private String telefoneAlternativoInstrutor;
    private String emailInstrutor;
    private String facebookInstrutor;

    public Instrutor() {
    }

    public Instrutor(int idInstrutor, String primeiroNomeInstrutor, String segundoNomeInstrutor, String sobrenomeInstrutor, Date dataNascimentoInstrutor, Sexo sexo, String telefonePrincipalInstrutor, String telefoneAlternativoInstrutor, String emailInstrutor, String facebookInstrutor) {
        this.idInstrutor = idInstrutor;
        this.primeiroNomeInstrutor = primeiroNomeInstrutor;
        this.segundoNomeInstrutor = segundoNomeInstrutor;
        this.sobrenomeInstrutor = sobrenomeInstrutor;
        this.dataNascimentoInstrutor = dataNascimentoInstrutor;
        this.sexo = sexo;
        this.telefonePrincipalInstrutor = telefonePrincipalInstrutor;
        this.telefoneAlternativoInstrutor = telefoneAlternativoInstrutor;
        this.emailInstrutor = emailInstrutor;
        this.facebookInstrutor = facebookInstrutor;
    }

    public int getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(int idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public String getPrimeiroNomeInstrutor() {
        return primeiroNomeInstrutor;
    }

    public void setPrimeiroNomeInstrutor(String primeiroNomeInstrutor) {
        this.primeiroNomeInstrutor = primeiroNomeInstrutor;
    }

    public String getSegundoNomeInstrutor() {
        return segundoNomeInstrutor;
    }

    public void setSegundoNomeInstrutor(String segundoNomeInstrutor) {
        this.segundoNomeInstrutor = segundoNomeInstrutor;
    }

    public String getSobrenomeInstrutor() {
        return sobrenomeInstrutor;
    }

    public void setSobrenomeInstrutor(String sobrenomeInstrutor) {
        this.sobrenomeInstrutor = sobrenomeInstrutor;
    }

    public Date getDataNascimentoInstrutor() {
        return dataNascimentoInstrutor;
    }

    public void setDataNascimentoInstrutor(Date dataNascimentoInstrutor) {
        this.dataNascimentoInstrutor = dataNascimentoInstrutor;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefonePrincipalInstrutor() {
        return telefonePrincipalInstrutor;
    }

    public void setTelefonePrincipalInstrutor(String telefonePrincipalInstrutor) {
        this.telefonePrincipalInstrutor = telefonePrincipalInstrutor;
    }

    public String getTelefoneAlternativoInstrutor() {
        return telefoneAlternativoInstrutor;
    }

    public void setTelefoneAlternativoInstrutor(String telefoneAlternativoInstrutor) {
        this.telefoneAlternativoInstrutor = telefoneAlternativoInstrutor;
    }

    public String getEmailInstrutor() {
        return emailInstrutor;
    }

    public void setEmailInstrutor(String emailInstrutor) {
        this.emailInstrutor = emailInstrutor;
    }

    public String getFacebookInstrutor() {
        return facebookInstrutor;
    }

    public void setFacebookInstrutor(String facebookInstrutor) {
        this.facebookInstrutor = facebookInstrutor;
    }
    
    
  
        
    
    
}
