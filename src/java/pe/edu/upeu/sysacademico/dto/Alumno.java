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
public class Alumno {
    private int idalumno;
    private String nombre;
    private String apellidos;

    public Alumno() {
    }

    public Alumno(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Alumno(int idalumno, String nombre, String apellidos) {
        this.idalumno = idalumno;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idalumno=" + idalumno + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
    
    
}
