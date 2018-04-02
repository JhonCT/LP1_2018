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
public class Curso {
    private int idCurso;
    private String nombre;
    private int creditos;

    public Curso() {
    }

    public Curso(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Curso(int idCurso, String nombre, int creditos) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", nombre=" + nombre + ", creditos=" + creditos + '}';
    }           
}
