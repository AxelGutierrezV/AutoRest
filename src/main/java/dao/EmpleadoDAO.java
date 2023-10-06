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
import modelo.Empleado;

/**
 *
 * @author Axel
 */
public class EmpleadoDAO {

    public List<Empleado> empleados() {
        List<Empleado> empleados = new ArrayList<>();
        Connection con = DBConexion.getConexion();
        Empleado emp;
        try {
            String sql = "call ListaEmpleados";
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

    public void addEmpleado() {
    }

    public void modifyEmpleado() {
    }

    public void deleteEmpleado() {
    }

    public List<Empleado> PerfilesEmpleados() {
        List<Empleado> perfiles = new ArrayList<>();
        Connection con = DBConexion.getConexion();
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
}

