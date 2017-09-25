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
public class Funcionario extends Pessoa implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String primeiroNome;
    private String segundoNome;
    private String sobrenome;
    private Date dataNascimento;
    private Sexo sexo;
    private String telefoneFixo;
    private String telefoneUnitel;
    private String teleFoneMovicel; 
    private String email;
    private String facebook;
    private String urlFoto;
    
    public Funcionario() {
    }
    
    public Funcionario(int id, String primeiroNome, String segundoNome, String sobrenome, Date dataNascimento, Sexo sexo, String telefoneFixo, String telefoneMovicel, String telefoneUnitel, String email, String facebook, String urlFoto) {
        super(id, primeiroNome, segundoNome, sobrenome, dataNascimento, sexo, telefoneFixo, telefoneMovicel, telefoneUnitel, email, facebook);
    this.id=id;
    this.primeiroNome=primeiroNome;
    this.segundoNome=segundoNome;
    this.sobrenome=sobrenome;
    this.dataNascimento=dataNascimento;
    this.sexo=sexo;
    this.telefoneFixo=telefoneFixo;
    this.telefoneUnitel=telefoneUnitel;
    this.teleFoneMovicel=telefoneMovicel;
    this.email=email; 
    this.facebook=facebook;
    this.urlFoto=urlFoto;
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

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneUnitel() {
        return telefoneUnitel;
    }

    public void setTelefoneUnitel(String telefoneUnitel) {
        this.telefoneUnitel = telefoneUnitel;
    }

    public String getTeleFoneMovicel() {
        return teleFoneMovicel;
    }

    public void setTeleFoneMovicel(String teleFoneMovicel) {
        this.teleFoneMovicel = teleFoneMovicel;
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

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
    
    
}
