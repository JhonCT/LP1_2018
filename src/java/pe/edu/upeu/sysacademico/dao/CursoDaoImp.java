/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.sysacademico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.upeu.sysacademico.dto.Curso;
import pe.edu.upeu.sysacademico.interfaces.CursoDAO;
import pe.edu.upeu.sysacademico.util.Conexion;

/**
 *
 * @author hidden
 */
public class CursoDaoImp implements CursoDAO{
    private PreparedStatement ps;
    private Connection cx;
    private ResultSet rs;
    
    private static final String CREATE = "INSERT INTO curso (idCurso, nombre, creditos) VALUES(NULL,?,?)";
    private static final String UPDATE = "UPDATE curso SET nombre = ?, creditos = ? WHERE idCurso = ?";
    private static final String DELETE = "DELETE FROM curso WHERE idCurso = ?";
    private static final String READ = "SELECT * FROM curso WHERE idCurso = ?";
    private static final String READ_ALL = "SELECT * FROM curso";
    
    @Override
    public int create(Curso c) {
        cx = Conexion.getConexion();
        int res = 0;
        try {
            ps = cx.prepareStatement(CREATE);
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getCreditos());
            
            res = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }                        
        return res;
    }

    @Override
    public int update(Curso c) {
        cx = Conexion.getConexion();
        int res = 0;
        try {
            ps = cx.prepareStatement(UPDATE);
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getCreditos());
            ps.setInt(3, c.getIdCurso());
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return res;
    }

    @Override
    public int delete(int key) {
        cx = Conexion.getConexion();
        int res = 0;
        try {
            ps = cx.prepareStatement(DELETE);
            ps.setInt(1, key);
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return res;        
    }

    @Override
    public Curso read(int key) {
        cx = Conexion.getConexion();
        Curso c = new Curso();
        try {
            ps = cx.prepareStatement(READ);
            ps.setInt(1, key);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                c.setIdCurso(rs.getInt("idCurso"));
                c.setNombre(rs.getString("nombre"));   
                c.setCreditos(rs.getInt("creditos"));
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return c;        
    }

    @Override
    public List<Curso> readAll() {
        cx = Conexion.getConexion();
        List<Curso> listaCurso = new ArrayList();
        
        try {
            ps = cx.prepareStatement(READ_ALL);
            
            rs = ps.executeQuery();
            while (rs.next()) {                                        
                Curso c = new Curso();
                c.setIdCurso(rs.getInt("idCurso"));
                c.setNombre(rs.getString("nombre"));
                c.setCreditos(rs.getInt("creditos"));
                listaCurso.add(c);                        
            }            
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return listaCurso;
    }    
}