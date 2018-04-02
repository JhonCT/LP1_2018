/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.sysacademico.dto;

/**
 *
 * @author hidden
 */
public class Matricula {
    private int idMatricula;
    private int codAlumno;
    private int codCurso;

    public Matricula() {
    }

    public Matricula(int codAlumno, int codCurso) {
        this.codAlumno = codAlumno;
        this.codCurso = codCurso;
    }

    public Matricula(int idMatricula, int codAlumno, int codCurso) {
        this.idMatricula = idMatricula;
        this.codAlumno = codAlumno;
        this.codCurso = codCurso;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public int getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno) {
        this.codAlumno = codAlumno;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    @Override
    public String toString() {
        return "Matricula{" + "idMatricula=" + idMatricula + ", codAlumno=" + codAlumno + ", codCurso=" + codCurso + '}';
    }        
}
