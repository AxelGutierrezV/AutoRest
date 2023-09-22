/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Plato;
import Conexion.DBConexion;
import java.sql.SQLException;

/**
 *
 * @author Axel
 */
public class PlatoDAO {

    Connection con = DBConexion.getConexion();

    public List<Plato> listaPlatos() {
        List<Plato> platos = new ArrayList<>();
        Plato p;
        try {
            con = DBConexion.getConexion();
            String sql = "Select * from Plato";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                p = new Plato();
                p.setCodPlato(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCodCat(rs.getInt(3));
                p.setEstado(rs.getString(4));
                p.setImagen(rs.getString(5));
                platos.add(p);
            }
        } catch (Exception e) {
        }
        return platos;
    }
    
        public List<Plato> listaPlatosPorCategoria(int codCat) {
        List<Plato> platos = new ArrayList<>();
        Plato p;
        try {
            con = DBConexion.getConexion();
            String sql = "Select * from Plato where CodCat = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codCat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Plato();
                p.setCodPlato(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCodCat(rs.getInt(3));
                p.setEstado(rs.getString(4));
                p.setImagen(rs.getString(5));
                platos.add(p);
            }
        } catch (Exception e) {
        }
        return platos;
    }
    
    public void addPlato(Plato p, Plato c){
        
        try {
            con = DBConexion.getConexion();
            String sql = "INSERT INTO PLATO(nombre, codCat) values (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,p.getNombre());
            ps.setInt(2, c.getCodCat());
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
        }
    }

    public void deltePlato(){
        
    }
    
    public void modifyPlato(){
        
    }
    
    
    /// METODOS DE CATEGORIAS DE PLATOS
    
    public List<Plato> listarCategorias() {
        List<Plato> categorias = new ArrayList<>();
        String sql = "select * from Categoria_plato";
        PreparedStatement ps;
        ResultSet rs;
        Plato c;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Plato(rs.getInt(1), rs.getString(2));
                categorias.add(c);
            }
        } catch (Exception e) {
        }
        return categorias;
    }

    public void addCategoriaPlatos(Plato c) {
        String sql = "insert into Categoria_plato (nombre) values (?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCatNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteCategoriaPlatos(int codCat) {
        String sql = "DELETE FROM Categoria_plato WHERE CodCat = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codCat);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
