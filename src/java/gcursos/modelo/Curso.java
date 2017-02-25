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
public class Curso implements Serializable{

    private static final long serialVersionUID = 1L;
    private int idCurso;
    private String nomeCurso;
    private String requisitosCurso;
    private String conteudoCurso;
    private int cargaHorariaCurso;
    private CategoriaCurso categoriaCurso;
    private double precoCurso;

    public Curso() {
    }

    public Curso(int idCurso, String nomeCurso, String requisitosCurso, String conteudoCurso, int cargaHorariaCurso, double precoCurso) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.requisitosCurso = requisitosCurso;
        this.conteudoCurso = conteudoCurso;
        this.cargaHorariaCurso = cargaHorariaCurso;
        this.precoCurso = precoCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getRequisitosCurso() {
        return requisitosCurso;
    }

    public void setRequisitosCurso(String requisitosCurso) {
        this.requisitosCurso = requisitosCurso;
    }

    public String getConteudoCurso() {
        return conteudoCurso;
    }

    public void setConteudoCurso(String conteudoCurso) {
        this.conteudoCurso = conteudoCurso;
    }

    public int getCargaHorariaCurso() {
        return cargaHorariaCurso;
    }

    public void setCargaHorariaCurso(int cargaHorariaCurso) {
        this.cargaHorariaCurso = cargaHorariaCurso;
    }

    public CategoriaCurso getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(CategoriaCurso categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }

    
    
    public double getPrecoCurso() {
        return precoCurso;
    }

    public void setPrecoCurso(double precoCurso) {
        this.precoCurso = precoCurso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idCurso;
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
        final Curso other = (Curso) obj;
        if (this.idCurso != other.idCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curso{" + "nomeCurso=" + nomeCurso + '}';
    }
    
    
 
}
