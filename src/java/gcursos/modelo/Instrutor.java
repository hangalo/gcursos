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

    public Instrutor() {
    }

    public Instrutor(int id, String primeiroNome, String segundoNome, String sobrenome, Date dataNascimento, Sexo sexo, String telefoneFixo, String telefoneMovicel, String telefoneUnitel, String email, String facebook, String foto) {
        super(id, primeiroNome, segundoNome, sobrenome, dataNascimento, sexo, telefoneFixo, telefoneMovicel, telefoneUnitel, email, facebook, foto);
    }
}
