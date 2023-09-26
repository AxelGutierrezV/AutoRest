/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Axel
 */
public class Orden {
    int CodOrden;
    int CodEmpleado;
    int CodMesa;
    char Estado;
    Date Creacion; //por revisar si el tipo de dato funciona bien
    ArrayList<Plato> platos;
    public static ArrayList<Orden> ordenes;

    public Orden(){
        platos = new ArrayList<>();
    }
    public int getCodOrden() {
        return CodOrden;
    }

    public void setCodOrden(int CodOrden) {
        this.CodOrden = CodOrden;
    }

    public int getCodEmpleado() {
        return CodEmpleado;
    }

    public void setCodEmpleado(int CodEmpleado) {
        this.CodEmpleado = CodEmpleado;
    }

    public int getCodMesa() {
        return CodMesa;
    }

    public void setCodMesa(int CodMesa) {
        this.CodMesa = CodMesa;
    }

    public char getEstado() {
        return Estado;
    }

    public void setEstado(char Estado) {
        this.Estado = Estado;
    }

    public Date getCreacion() {
        return Creacion;
    }

    public void setCreacion(Date Creacion) {
        this.Creacion = Creacion;
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }
    
}
