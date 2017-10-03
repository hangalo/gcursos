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
    private int idInstudor;
    private String primeiroNomeInstrutor;
    private String segundoNomeInstrutor;
    private String sobrenomeInstrutor;
    private Date dataNascimentoInstrutor;
    private Sexo Sexo;
    private String telefonePrincipal; 
    private String telefoneAlternativo;
    
    private String email;
    private String facebookInstrutor;
    private String urlfotoInstrutor;
    private byte[] fotoInstrutor;
    

    public Instrutor() {
    }

    public Instrutor(int idIstrutor, String primeiroNome, String segundoNome, String sobrenome, Date dataNascimento, Sexo sexo, String telefoneFixo, String telefoneMovicel, String telefoneUnitel, String email, String facebook, String foto) {
        super(idIstrutor, primeiroNome, segundoNome, sobrenome, dataNascimento, sexo, telefoneFixo, telefoneMovicel, telefoneUnitel, email, facebook);
    }

    public int getIdInstudor() {
        return idInstudor;
    }

    public void setIdInstudor(int idInstudor) {
        this.idInstudor = idInstudor;
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
        return Sexo;
    }

    public void setSexo(Sexo Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(String telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    public String getTelefoneAlternatico() {
        return telefoneAlternativo;
    }

    public void setTelefoneAlternatico(String telefoneAlternatico) {
        this.telefoneAlternativo = telefoneAlternatico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebookInstrutor() {
        return facebookInstrutor;
    }

    public void setFacebookInstrutor(String facebookInstrutor) {
        this.facebookInstrutor = facebookInstrutor;
    }

    public String getUrlfotoInstrutor() {
        return urlfotoInstrutor;
    }

    public void setUrlfotoInstrutor(String urlfotoInstrutor) {
        this.urlfotoInstrutor = urlfotoInstrutor;
    }

    public byte[] getFotoInstrutor() {
        return fotoInstrutor;
    }

    public void setFotoInstrutor(byte[] fotoInstrutor) {
        this.fotoInstrutor = fotoInstrutor;
    }
    
}
