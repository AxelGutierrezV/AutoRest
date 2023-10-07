/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Conexion.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HJVM
 */
public class LoginDAO {
    Connection con = null;
    
    public boolean existeCodigoUsuario(int codigoEmpleado){
        try {
            con = DBConexion.getConexion();
            String sql = "select Contrasena from empleado where CodEmpleado=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigoEmpleado);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public String ContraUsuario(int codigoEmpleado){
        try {
            con = DBConexion.getConexion();
            String sql = "select Contrasena from empleado where CodEmpleado=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigoEmpleado);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }
}
