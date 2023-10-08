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
                p.setPrecio(rs.getDouble(3));
                p.setCodCat(rs.getInt(4));
                p.setEstado(rs.getString(5));
                p.setImagen(rs.getString(6));
                if (p.getEstadoCategoria() == 1) {
                    platos.add(p);
                }
            }
        } catch (Exception e) {
        }
        return platos;
    }

    public List<Plato> listaPlatosPorCategoria(int codigo) {
        List<Plato> platos = new ArrayList<>();
        Plato p;
        try {
            con = DBConexion.getConexion();
            String sql = "select p.CodPlato,p.nombre,p.precio, c.Nombre, c.estado from plato p join categoria_plato c on c.CodCat=p.CodCat where c.estado = 1";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                p = new Plato();
                p.setCodPlato(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                platos.add(p);
            }
        } catch (SQLException e) {
        }
        return platos;
    }

    public List<Plato> listaPlatosConCategoria() {
        List<Plato> platos = new ArrayList<>();
        Plato p;
        //por arreglar
        try {
            con = DBConexion.getConexion();
            String sql = "select p.CodPlato,p.nombre,p.precio, c.Nombre, c.estado from plato p join categoria_plato c on c.CodCat=p.CodCat where c.estado = 1 and p.estado = 'A'";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                p = new Plato();
                p.setCodPlato(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setCatNombre(rs.getString(4));
                p.setEstadoCategoria(rs.getInt(5));
                platos.add(p);
            }
        } catch (Exception e) {
        }
        return platos;
    }

    public int siguienteCodigoPlato() {
        try {
            con = DBConexion.getConexion();
            String sql = "select max(CodPlato) + 1 from plato;";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return (rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return -1;

    }
    //select max(CodPlato) + 1 from plato;

    public Plato obtenerDatosPlato(int codPlato) {
        String sql = "select nombre, CodPlato from plato where CodPlato = ?;";
        PreparedStatement ps;
        ResultSet rs;
        Plato c = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, codPlato);
            rs = ps.executeQuery();
            if (rs.next()) {
                c = new Plato();
                c.setNombre(rs.getString(1));
                c.setCodPlato(rs.getInt(2));
            }
        } catch (Exception e) {
        }
        return c;
    }

    public void addPlato(Plato p) {

        try {
            con = DBConexion.getConexion();
            String sql = "INSERT INTO PLATO values (?, ?, ?, ?, 1, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCodPlato());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCodCat());
            ps.setString(5, p.getImagen());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deletePlato(int CodPlato) {
        String sql = "update plato set estado = 'I' where CodPlato = " + CodPlato;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }

        /*
        String sql = "delete from plato where CodPlato = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, CodPlato);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
         */
    }

    public void modifyPlato(String nombrePlato, int codPlato) {
        String sql = "update plato set nombre = ? where CodPlato = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrePlato);
            ps.setInt(2, codPlato);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    /// ------------------------------------ METODOS DE CATEGORIAS DE PLATOS ------------------------------------
    public List<Plato> listarNombresYCodigosDeCategorias() {
        List<Plato> platosNombresYCodigosCategorias = new ArrayList<>();
        Plato p;
        try {
            con = DBConexion.getConexion();
            String sql = "select Nombre, CodCat from Categoria_plato;";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                p = new Plato();
                p.setCatNombre(rs.getString(1));
                p.setCodCat(rs.getInt(2));
                if (p.getEstadoCategoria() == 1) {
                    platosNombresYCodigosCategorias.add(p);
                }
            }
        } catch (Exception e) {
        }
        return platosNombresYCodigosCategorias;
    }

    public int siguienteCodigoCategoria() {
        try {
            con = DBConexion.getConexion();
            String sql = "select max(CodCat) + 1 from Categoria_plato;";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return (rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return -1;

    }

    public List<Plato> listarCategorias() {
        List<Plato> categorias = new ArrayList<>();
        String sql = "select * from Categoria_plato where estado = 1";
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

    public Plato obtenerDatosCategoria(int codCat) {
        String sql = "select * from Categoria_plato where CodCat = ?;";
        PreparedStatement ps;
        ResultSet rs;
        Plato c = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, codCat);
            rs = ps.executeQuery();
            if (rs.next()) {
                c = new Plato(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return c;
    }

    public void addCategoriaPlatos(Plato p) {
        String sql = "insert into Categoria_plato values (?, ?, 1)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCodCat());
            ps.setString(2, p.getCatNombre());

            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteCategoriaPlatos(int codCat) {

        String sql = "update categoria_plato set estado = 2 where CodCat = ?;";
        try {//
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codCat);
            ps.executeUpdate();
            sql = "update plato set estado = 'I' where CodCat = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, codCat);
            ps.executeUpdate();
        } catch (SQLException e) {
        }

        /*
        String sql = "delete from plato where CodCat = ?;";
        try {//
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codCat);
            ps.executeUpdate();
            sql = "DELETE FROM Categoria_plato WHERE CodCat = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, codCat);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
         */
    }

    public void terminarEditarCategoria(String nombreCategoria, int codigoCategoria) {//Modifica solo nombre de categoría
        String sql = "update Categoria_plato set Nombre = ?  where CodCat = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreCategoria);
            ps.setInt(2, codigoCategoria);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

}
