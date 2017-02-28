/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author informatica
 */
public class DetalhesMatricula implements Serializable{

    private static final long serialVersionUID = 1L;
    private Matricula matricula;
    private Curso curso;
    private Instrutor instrutor;
    private double precoCurso;
    private Date dataInicio;
    private Date dataFim;

    public DetalhesMatricula() {
    }

    public DetalhesMatricula(Matricula matricula, Curso curso, Instrutor instrutor, double precoCurso, Date dataInicio, Date dataFim) {
        this.matricula = matricula;
        this.curso = curso;
        this.instrutor = instrutor;
        this.precoCurso = precoCurso;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public double getPrecoCurso() {
        return precoCurso;
    }

    public void setPrecoCurso(double precoCurso) {
        this.precoCurso = precoCurso;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.matricula);
        hash = 67 * hash + Objects.hashCode(this.curso);
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
        final DetalhesMatricula other = (DetalhesMatricula) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return true;
    }
    
    
    
}
