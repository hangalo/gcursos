/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.modelo;

import java.io.Serializable;

/**
 *
 * @author informatica
 */
public class Turma implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;

    public Turma() {
    }

    public Turma(int idTurma, String turma) {
        this.id = idTurma;
        this.nome = turma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final Turma other = (Turma) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    @Override
    public String toString() {
        return "Turma{" + "turma=" + nome + '}';
    }
    
    
}
