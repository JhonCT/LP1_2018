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
import pe.edu.upeu.sysacademico.dto.DetalleMatricula;
import pe.edu.upeu.sysacademico.interfaces.DetalleMatriculaDAO;
import pe.edu.upeu.sysacademico.util.Conexion;

/**
 *
 * @author hidden
 */
public class DetalleMatriculaDaoImp implements DetalleMatriculaDAO{    
    private Connection cx = Conexion.getConexion();
    private PreparedStatement ps;
    private ResultSet rs;
    private int res = 0;
    
    private static final String CREATE = "INSERT INTO detalle (idDetaMatri, año, periodo, fechaMat) VALUES(NULL, ?, ?, ?)";
    private static final String UPDATE = "UPDATE detalle SET año=?, periodo=?, fechaMat=? WHERE idDetaMatri = ?";
    private static final String DELETE = "DELETE FROM detalle WHERE idDetaMatri = ?";
    private static final String READ = "SELECT * FROM detalle WHERE idDetaMatri = ?";
    private static final String READ_ALL = "SELECT * FROM detalle";
    
    @Override
    public int create(DetalleMatricula m) {        
        DetalleMatricula dm = new DetalleMatricula();
        try {
            ps = cx.prepareStatement(CREATE);
            ps.setInt(1, m.getAño());
            ps.setString(2, m.getPeriodo());
            ps.setString(3, m.getFechaMat());
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return res;
    }

    @Override
    public int update(DetalleMatricula m) {
        DetalleMatricula dm = new DetalleMatricula();
        try {
            ps = cx.prepareStatement(UPDATE);
            ps.setInt(1, m.getAño());
            ps.setString(2, m.getPeriodo());
            ps.setString(3, m.getFechaMat());
            ps.setInt(4, m.getIdDetMat());
            
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
    public DetalleMatricula read(int key) {
        DetalleMatricula dm = new DetalleMatricula();
        
        try {
            ps = cx.prepareStatement(READ);
            ps.setInt(1, key);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                dm.setIdDetMat(rs.getInt("idDetaMatri"));
                dm.setAño(rs.getInt("año"));
                dm.setPeriodo(rs.getString("periodo"));
                dm.setFechaMat(rs.getString("fechaMat"));                
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return dm;                                                                
    }

    @Override
    public List<DetalleMatricula> readAll() {
        List<DetalleMatricula> listaDetMat = new ArrayList();
        DetalleMatricula dm = new DetalleMatricula();
        
        try {
            ps = cx.prepareStatement(READ_ALL);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                dm.setIdDetMat(rs.getInt("idDetaMatri"));
                dm.setAño(rs.getInt("año"));
                dm.setPeriodo(rs.getString("periodo"));
                dm.setFechaMat(rs.getString("fechaMat"));
                listaDetMat.add(dm);
            }            
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return listaDetMat;
    }
}
