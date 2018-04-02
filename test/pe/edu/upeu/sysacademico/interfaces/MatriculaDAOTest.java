/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.sysacademico.interfaces;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.edu.upeu.sysacademico.dao.MatriculaDaoImp;
import pe.edu.upeu.sysacademico.dto.Matricula;

/**
 *
 * @author hidden
 */
public class MatriculaDAOTest {
    private static MatriculaDaoImp mdi = new MatriculaDaoImp();    
    public static void main(String[] args) {
        readAll();
    }
    
    private static void create(){
        Matricula m = new Matricula(1,1);
        
        int res = mdi.create(m);
        
        if (res > 0) {
            System.out.println("Agregado Correctamente");
        }else {
            System.out.println("No Agregado");
        }
    }
    
    private static void update(){
        Matricula m = new Matricula(1,2,5);
        
        int res = mdi.update(m);
        
        if (res > 0) {
            System.out.println("Modificado Correctamente");
        }else {
            System.out.println("No Modificado");
        }
    }
    
    private static void delete(){
        int res = mdi.delete(1);
        
        if (res > 0) {
            System.out.println("Borrado Correctamente");
        }else {
            System.out.println("No Borrado");
        }
    }
    
    private static void read(){
        Matricula m = mdi.read(2);
        System.out.println(m.toString());
    }
    
    private static void readAll(){
        List<Matricula> listMatricula = mdi.readAll();
        
        for (int i = 0; i < listMatricula.size(); i++) {
            System.out.println("Id de Matricula : " + listMatricula.get(i).getIdMatricula());
            System.out.println("Id de Alumno : " + listMatricula.get(i).getCodAlumno());
            System.out.println("Id de Curso : " + listMatricula.get(i).getCodCurso());
            System.out.println("--------------------------");
        }
    }
}
