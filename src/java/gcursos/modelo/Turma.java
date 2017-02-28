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
    private int idTurma;
    private String turma;

    public Turma() {
    }

    public Turma(int idTurma, String turma) {
        this.idTurma = idTurma;
        this.turma = turma;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idTurma;
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
        if (this.idTurma != other.idTurma) {
            return false;
        }
        return true;
    }

    
    
    
    @Override
    public String toString() {
        return "Turma{" + "turma=" + turma + '}';
    }
    
    
}
