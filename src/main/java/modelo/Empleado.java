/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import sun.security.util.Password;

/**
 *
 * @author Axel
 */
public class Empleado {
    private int CodEmpleado;
    private String nombre;
    private String apellido;
    private String pass; //in the future it could change to a secure method
    private int codPerfil;
    private String perfil;
    private int estado;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
  

    public int getCodEmpleado() {
        return CodEmpleado;
    }

    public void setCodEmpleado(int CodEmpleado) {
        this.CodEmpleado = CodEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(int codPerfil) {
        this.codPerfil = codPerfil;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public String estadoNombre(){
        String e = "";
            if(estado==1){
                e = "Activo";
            } else if(estado==2){
                e = "Inactivo";
            }
        return e;
    }
    
}
