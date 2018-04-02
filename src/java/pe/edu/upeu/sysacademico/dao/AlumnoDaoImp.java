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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.upeu.sysacademico.dto.Alumno;
import pe.edu.upeu.sysacademico.interfaces.AlumnoDAO;
import pe.edu.upeu.sysacademico.util.Conexion;

/**
 *
 * @author hidden
 */
public class AlumnoDaoImp implements AlumnoDAO{
    private PreparedStatement ps;
    private ResultSet rs;
    private static final String READ_ALL = "SELECT * FROM alumno1";
    private static final String CREATE = "INSERT INTO alumno1 (idAlumno, nombres, apellidos) VALUES(NULL, ?, ?)";
    private static final String UPDATE = "UPDATE alumno1 SET nombres=?,apellidos=? WHERE idAlumno = ?";
    private static final String DELETE = "DELETE FROM alumno1 WHERE idAlumno = ?";
    private static final String READ = "SELECT * FROM alumno1 WHERE idAlumno = ?";
   
    private Connection cx;
            
    @Override
    public int create(Alumno a) {
        int res = 0;
        cx = Conexion.getConexion();
        try {
            ps = cx.prepareStatement(CREATE);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellidos());
                        
            res = ps.executeUpdate();                        
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }                
        return res;
    }

    @Override
    public int update(Alumno a) {
        int res = 0;
        cx = Conexion.getConexion();
        try {
            ps = cx.prepareStatement(UPDATE);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellidos());
            ps.setInt(3, a.getIdalumno());
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
       return res;
    }

    @Override
    public int delete(int key) {
        int res = 0;
        cx = Conexion.getConexion();
        
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
    public Alumno read(int key) {                                        
        Alumno a = new Alumno();
        cx = Conexion.getConexion();
        try{
            ps = cx.prepareStatement(READ);
            ps.setInt(1, key);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                a.setIdalumno(rs.getInt("idAlumno"));
                a.setNombre(rs.getString("nombres"));
                a.setApellidos(rs.getString("apellidos"));         
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        return a;
    }

    @Override
    public List<Alumno> readAll() {
        List<Alumno> list = new ArrayList();
        cx = Conexion.getConexion();
        try {
            ps = cx.prepareStatement(READ_ALL);
            rs = ps.executeQuery();
            
            while (rs.next()) {   
                Alumno a = new Alumno();
                a.setIdalumno(rs.getInt("idAlumno"));
                a.setNombre(rs.getString("nombres"));
                a.setApellidos(rs.getString("apellidos"));                
                list.add(a);                       
            }         
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }        
        return list;
    }
}
