/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Axel
 */
public class Plato {
    private int CodPlato;
    private String nombre;
    private String estado;
    private String imagen;
    private int CodCat;
    private String CatNombre; 

    public Plato(){
        
    }

    public Plato(int CodCat, String CatNombre){
        this.CodCat = CodCat;
        this.CatNombre = CatNombre;
    }
    
    public int getCodPlato() {
        return CodPlato;
    }

    public void setCodPlato(int CodPlato) {
        this.CodPlato = CodPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCodCat() {
        return CodCat;
    }

    public void setCodCat(int CodCat) {
        this.CodCat = CodCat;
    }

    public String getCatNombre() {
        return CatNombre;
    }

    public void setCatNombre(String CatNombre) {
        this.CatNombre = CatNombre;
    }
    
    
}

