/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Conexion.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Empleado;

/**
 *
 * @author Axel
 */
public class EmpleadoDAO {

    Connection con = DBConexion.getConexion();

    public List<Empleado> empleados() {
        List<Empleado> empleados = new ArrayList<>();
        Empleado emp;
        try {
            String sql = "SELECT e.CodEmpleado, e.nombre, e.Apellido, Estado, p.Cargo  FROM empleado e inner join perfil_empleado p on e.CodPerfil = p.CodPerfil where estado = 1";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emp = new Empleado();
                emp.setCodEmpleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido(rs.getString(3));
                emp.setEstado(rs.getInt(4));
                emp.setPerfil(rs.getString(5));
                empleados.add(emp);
            }

        } catch (SQLException e) {
        }
        return empleados;
    }
    
    public List<Empleado> listarPerfiles(){
        List<Empleado> empleados = new ArrayList<>();
        Empleado emp;
        try {
            String sql = "select * from perfil_empleado where estado = 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emp = new Empleado();
                emp.setCodPerfil(rs.getInt(1));
                emp.setPerfil(rs.getString(2));
                empleados.add(emp);
            }

        } catch (SQLException e) {
        }
        return empleados;
    }

    public void addEmpleado(Empleado emp) {
        try {
            String sql = "INSERT INTO empleado VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getCodEmpleado());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setString(4, emp.getPass());
            ps.setInt(5, emp.getCodPerfil());
            ps.setInt(6, emp.getEstado());
            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void modifyEmpleado() {
        
    }

    public void deleteEmpleado(int CodEmpleado) {
        String sql = "update empleado set estado = 2 where CodEmpleado = " + CodEmpleado;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }

    }

    public List<Empleado> PerfilesEmpleados() {
        List<Empleado> perfiles = new ArrayList<>();
        Empleado perfil;
        try {
            String sql = "select * from perfil_empleado";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                perfil = new Empleado();
                perfil.setCodPerfil(rs.getInt(1));
                perfil.setPerfil(rs.getString(2));
                perfiles.add(perfil);
            }
        } catch (SQLException e) {
        }
        return perfiles;
    }

    public Empleado getPerfilEmpleado(int CodPerfil){
        Empleado p = new Empleado();
                try {
            String sql = "select * from perfil_empleado where codPerfil = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, CodPerfil);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Empleado();
                p.setCodPerfil(rs.getInt(1));
                p.setPerfil(rs.getString(2));
            }
        } catch (SQLException e) {
        }
        return p;
    }
    
    public void addPerfil(Empleado emp) {
        try {
            String sql = "INSERT INTO perfil_empleado VALUES (?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getCodPerfil());
            ps.setString(2, emp.getPerfil());
            
            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void modifyPerfil(String nombrePerfil, int CodPerfil) {
        String sql = "update perfil_empleado set Cargo = ? where codPerfil = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,nombrePerfil);
            ps.setInt(2, CodPerfil);
            ResultSet rs = ps.executeQuery();
            } catch (SQLException e) {
        }
    }

    public void deletePerfil(int codPerfil) {
        //PENDIENTE POR USAR LA VALIDACIÓN
        String sql = "delete from perfil_empleado where codPerfil = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, codPerfil);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    private boolean validarPerfilEnUso(int cod) {
        int n = 200;
        String sql = "select count(*) from empleado where codPerfil = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n = rs.getInt(1);
                if (n == 0) {
                    return false;
                }
                if (n >= 1) {
                    return true;
                }
            }
        } catch (SQLException e) {
        }
        return true;
    }
}
