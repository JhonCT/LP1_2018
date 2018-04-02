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
import pe.edu.upeu.sysacademico.dao.DetalleMatriculaDaoImp;
import pe.edu.upeu.sysacademico.dto.DetalleMatricula;

/**
 *
 * @author hidden
 */
public class DetalleMatriculaDAOTest {
    private static DetalleMatriculaDaoImp dmi = new DetalleMatriculaDaoImp();
    public static void main(String[] args) {
        readAll();
    }
    
    public static void create(){
        DetalleMatricula dm = new DetalleMatricula(2018,"I","04/03/2018");
        
        int res = dmi.create(dm);
        
        if (res > 0) {
            System.out.println("Agregado Correctamente");
        }else {
            System.out.println("No Agregado");
        }
    }
    
    public static void update(){
        DetalleMatricula dm = new DetalleMatricula(1,2018,"II","09/03/2018");
        
        int res = dmi.update(dm);
        
        if (res > 0) {
            System.out.println("Modificado Correctamente");
        }else {
            System.out.println("No Modificado");        }
    }
    
    public static void delete(){
        int res = dmi.delete(1);
        
        if (res > 0) {
            System.out.println("Eliminado Correctamente");
        }else {
            System.out.println("No Eliminado");
        }
    }
    
    public static void read(){
        DetalleMatricula dm = dmi.read(2);
        System.out.println(dm.toString());
    }
    
    public static void readAll(){
        List<DetalleMatricula> listDetMat = dmi.readAll();
        
        for (int i = 0; i < listDetMat.size(); i++) {
            System.out.println(listDetMat.get(i).getIdDetMat());
            System.out.println(listDetMat.get(i).getAño());
            System.out.println(listDetMat.get(i).getPeriodo());
            System.out.println(listDetMat.get(i).getFechaMat());
            System.out.println("----------------------------");
        }
    }
}
