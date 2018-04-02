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
public class DetalleMatricula {
    private int idDetMat;
    private int año;
    private String periodo;
    private String fechaMat;

    public DetalleMatricula() {
    }

    public DetalleMatricula(int año, String periodo, String fechaMat) {
        this.año = año;
        this.periodo = periodo;
        this.fechaMat = fechaMat;
    }

    public DetalleMatricula(int idDetMat, int año, String periodo, String fechaMat) {
        this.idDetMat = idDetMat;
        this.año = año;
        this.periodo = periodo;
        this.fechaMat = fechaMat;
    }

    public int getIdDetMat() {
        return idDetMat;
    }

    public void setIdDetMat(int idDetMat) {
        this.idDetMat = idDetMat;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getFechaMat() {
        return fechaMat;
    }

    public void setFechaMat(String fechaMat) {
        this.fechaMat = fechaMat;
    }

    @Override
    public String toString() {
        return "DetalleMatricula{" + "idDetMat=" + idDetMat + ", a\u00f1o=" + año + ", periodo=" + periodo + ", fechaMat=" + fechaMat + '}';
    }        
}
