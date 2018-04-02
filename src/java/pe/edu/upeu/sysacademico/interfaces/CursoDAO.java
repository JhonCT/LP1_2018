/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.sysacademico.interfaces;

import java.util.List;
import pe.edu.upeu.sysacademico.dto.Curso;

/**
 *
 * @author hidden
 */
public interface CursoDAO {
    int create(Curso c);
    int update(Curso c);
    int delete(int key);
    Curso read(int key);
    List<Curso> readAll();
}
