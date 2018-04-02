/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.sysacademico.interfaces;

import java.util.List;
import pe.edu.upeu.sysacademico.dto.Matricula;

/**
 *
 * @author hidden
 */
public interface MatriculaDAO {
    int create(Matricula m);
    int update(Matricula m);
    int delete(int key);
    Matricula read(int key);
    List<Matricula> readAll();
        
}
