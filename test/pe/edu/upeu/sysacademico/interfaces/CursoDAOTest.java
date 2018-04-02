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
import pe.edu.upeu.sysacademico.dao.CursoDaoImp;
import pe.edu.upeu.sysacademico.dto.Curso;

/**
 *
 * @author hidden
 */
public class CursoDAOTest {
    private static CursoDaoImp cdi = new CursoDaoImp();
    public static void main(String[] args) {
        readAll();
    }
    
    public static void create(){
        Curso c = new Curso("Algebra", 5);        
        int res = cdi.create(c);
        
        if (res > 0) {
            System.out.println("Curso Agregado Correctamente");
        }else {
            System.out.println("Curso No Agregado");
        }
        
    }
    public static void update(){
        Curso c = new Curso(1,"LP1", 6);
        
        int res = cdi.update(c);
        
        if (res > 0) {
            System.out.println(c.toString());
        }else {
            System.out.println("Curso No Modificado");
        }
        
    }
    public static void delete(){
        int res = cdi.delete(2);
        
        if (res > 0) {
            System.out.println("Curso Eliminado Correctamente");
        }else {
            System.out.println("Curso No Eliminado");
        }
    }
    public static void read(){
        Curso c = cdi.read(1);
        System.out.println(c.toString());                            
    }
    public static void readAll(){
        List<Curso> listCurso = cdi.readAll();
        
        for (int i = 0; i < listCurso.size(); i++) {
            System.out.println("Id del Curso : " + listCurso.get(i).getIdCurso());
            System.out.println("Nombre del Curso : " + listCurso.get(i).getNombre());
            System.out.println("Creditos del Curso : " + listCurso.get(i).getCreditos());
            System.out.println("-------------------------");
        }                
    }    
}
