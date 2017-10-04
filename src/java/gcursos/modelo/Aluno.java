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
public class Aluno implements Serializable {
  private int id;
    private String primeiroNome;
    private String segundoNome;
    private String sobrenome;
    private Date dataNascimento;
    private Sexo sexo;
    private String telefoneFixo;
    private String telefoneMovicel;
    private String telefoneUnitel;
    private String email;
    private String facebook;
    private byte[] foto;
    private String urlFoto;

    public Aluno() {
    }

    public Aluno(int id, String primeiroNome, String segundoNome, String sobrenome, Date dataNascimento, Sexo sexo, String telefoneFixo, String telefoneMovicel, String telefoneUnitel, String email, String facebook, byte[] foto, String urlFoto) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefoneFixo = telefoneFixo;
        this.telefoneMovicel = telefoneMovicel;
        this.telefoneUnitel = telefoneUnitel;
        this.email = email;
        this.facebook = facebook;
        this.foto = foto;
        this.urlFoto = urlFoto;
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

    public String getTelefoneMovicel() {
        return telefoneMovicel;
    }

    public void setTelefoneMovicel(String telefoneMovicel) {
        this.telefoneMovicel = telefoneMovicel;
    }

    public String getTelefoneUnitel() {
        return telefoneUnitel;
    }

    public void setTelefoneUnitel(String telefoneUnitel) {
        this.telefoneUnitel = telefoneUnitel;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aluno{" + "primeiroNome=" + primeiroNome + ", segundoNome=" + segundoNome + ", sobrenome=" + sobrenome + '}';
    }

    
   

}
