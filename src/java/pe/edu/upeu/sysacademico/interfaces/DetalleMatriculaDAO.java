/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.sysacademico.interfaces;

import java.util.List;
import pe.edu.upeu.sysacademico.dto.DetalleMatricula;

/**
 *
 * @author hidden
 */
public interface DetalleMatriculaDAO {
    int create(DetalleMatricula m);    
    int update(DetalleMatricula m);
    int delete(int key);
    DetalleMatricula read(int key);
    List<DetalleMatricula> readAll();
}
