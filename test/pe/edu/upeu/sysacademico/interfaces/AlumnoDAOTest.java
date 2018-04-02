/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.sysacademico.interfaces;

import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.sysacademico.dao.AlumnoDaoImp;
import pe.edu.upeu.sysacademico.dto.Alumno;

/**
 *
 * @author hidden
 */
public class AlumnoDAOTest {    
     public static AlumnoDaoImp adi = new AlumnoDaoImp();
    
    public static void main(String[] args) {
        create();
    }
    
    public static void create(){
        Alumno a = new Alumno("jqwe", "caqw");
        
        int r = adi.create(a);
        
        if (r > 0) {
            System.out.println("Agregado Correctamente");
        }else{
            System.out.println("No Agregado");
        }
    }
    
    public static void delete(){                
        int r = adi.delete(2);
        
        if (r > 0) {
            System.out.println("Borrado Correctamente");
        }else {
            System.out.println("No Borrado");
        }
    }
    
    public static void update(){
        Alumno a = new Alumno(4,"jhon", "catacora");
        int r  = adi.update(a);
        if (r > 0) {
            System.out.println(a.toString());
        }else {
            System.out.println("No Modificado");
        }
    }
    
    public static void read(){
        Alumno a = adi.read(2);                
        System.out.println(a.toString());
    }
    
    public static void readAll(){
        List<Alumno> a = adi.readAll();
       
        for(int i=0; i<a.size();i++){
            System.out.println("Id del Alumno : " + a.get(i).getIdalumno());
            System.out.println("Nombres del Alumno : " + a.get(i).getNombre());
            System.out.println("Apellidos del Alumno : " + a.get(i).getApellidos());
            System.out.println("------------------------");
        }
    }
}
