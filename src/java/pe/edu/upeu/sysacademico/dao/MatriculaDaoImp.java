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
import pe.edu.upeu.sysacademico.dto.Matricula;
import pe.edu.upeu.sysacademico.interfaces.MatriculaDAO;
import pe.edu.upeu.sysacademico.util.Conexion;

/**
 *
 * @author hidden
 */
public class MatriculaDaoImp implements MatriculaDAO{
    private Connection cx = Conexion.getConexion();
    private PreparedStatement ps;
    private ResultSet rs;
    private int res = 0;
    
    private static final String CREATE = "INSERT INTO matricula (idMatricula, codAlumno, codCurso) VALUES(NULL, ?, ?)";
    private static final String UPDATE = "UPDATE matricula SET codAlumno = ?, codCurso = ? WHERE idMatricula = ?";
    private static final String DELETE = "DELETE FROM matricula WHERE idMatricula = ?";
    private static final String READ = "SELECT * FROM matricula WHERE idMatricula = ?";
    private static final String READ_ALL = "SELECT * FROM matricula";
    
    @Override
    public int create(Matricula m) {        
        try {
            ps = cx.prepareStatement(CREATE);
            ps.setInt(1, m.getCodAlumno());
            ps.setInt(2, m.getCodCurso());
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return res;        
    }

    @Override
    public int update(Matricula m) {
        try {
            ps = cx.prepareStatement(UPDATE);
            ps.setInt(1, m.getCodAlumno());
            ps.setInt(2, m.getCodCurso());
            ps.setInt(3, m.getIdMatricula());
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return res;
    }

    @Override
    public int delete(int key) {
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
    public Matricula read(int key) {
        Matricula m = new Matricula();
        try {
            ps = cx.prepareStatement(READ);
            ps.setInt(1, key);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                m.setIdMatricula(rs.getInt("idMatricula"));
                m.setCodAlumno(rs.getInt("codAlumno"));
                m.setCodCurso(rs.getInt("codCurso"));
            }           
        } catch (SQLException e) {
            System.out.println("Error : " + e);        
        }
        return m;
    }

    @Override
    public List<Matricula> readAll() {
        List<Matricula> listaMatricula = new ArrayList();
        
        try {
            ps = cx.prepareStatement(READ_ALL);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Matricula m = new Matricula();
                m.setIdMatricula(rs.getInt("idMatricula"));
                m.setCodAlumno(rs.getInt("codAlumno"));
                m.setCodCurso(rs.getInt("codCurso"));
                listaMatricula.add(m);                                        
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return listaMatricula;
    }    
}
