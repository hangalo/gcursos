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
public class Aluno extends Pessoa implements Serializable{
  private byte [] foto;
  private String urlFoto;
    public Aluno() {
    }

    public Aluno(byte[] foto, String urlFoto, int id, String primeiroNome, String segundoNome, String sobrenome, Date dataNascimento, Sexo sexo, String telefoneFixo, String telefoneMovicel, String telefoneUnitel, String email, String facebook) {
        super(id, primeiroNome, segundoNome, sobrenome, dataNascimento, sexo, telefoneFixo, telefoneMovicel, telefoneUnitel, email, facebook);
        this.foto = foto;
        this.urlFoto = urlFoto;
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

    
   

   
}
