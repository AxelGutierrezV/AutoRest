/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import Conexion.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Axel
 */
public class ClienteDAO {

    Connection con = DBConexion.getConexion();

    public List<Cliente> listaClientes() {
        List<Cliente> listaClientes = new ArrayList();
        String sql = "select * from CLIENTE";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCodigo(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDocumento(rs.getString(4));
                c.setTipo(rs.getString(5));
                listaClientes.add(c);
            }
        } catch (SQLException ex) {
        }
        return listaClientes;
    }

    public void AddCliente(Cliente c) {
        String sql = "INSERT INTO CLIENTE(nombre, apellido, documento, tipo) VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDocumento());
            ps.setString(4, c.getTipo());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void ModifyCliente(Cliente c) {
        String sql = "UPDATE CLIENTE SET nombre = ?, apellido = ?, documento = ?, tipo = ? WHERE CodCliente = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDocumento());
            ps.setString(4, c.getTipo());
            ps.setInt(5, c.getCodigo());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void DeleteCliente(int cod) {
        String sql = "DELETE FROM CLIENTE WHERE CodCliente = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Cliente getCliente(int cod) {
        Cliente c = new Cliente();
        String sql = "select * from ClIENTE WHERE CodCliente = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            c.setCodigo(rs.getInt(1));
            c.setNombre(rs.getString(2));
            c.setApellido(rs.getString(3));
            c.setDocumento(rs.getString(4));
            c.setTipo(rs.getString(5));
        } catch (SQLException e) {
        }
        return c;
    }
}
