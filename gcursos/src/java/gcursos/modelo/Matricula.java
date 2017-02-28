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
 * @author informatica
 */
public class Matricula implements Serializable{
   private int idMatricula;
   private Aluno aluno;
   private Turma turma;
   private Funcionario funcionario;
   private Date dataMatricula;

    public Matricula() {
    }

    public Matricula(int idMatricula, Aluno aluno, Turma turma, Funcionario funcionario, Date dataMatricula) {
        this.idMatricula = idMatricula;
        this.aluno = aluno;
        this.turma = turma;
        this.funcionario = funcionario;
        this.dataMatricula = dataMatricula;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idMatricula;
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
        final Matricula other = (Matricula) obj;
        if (this.idMatricula != other.idMatricula) {
            return false;
        }
        return true;
    }
   
    
}
