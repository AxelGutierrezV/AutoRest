/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Axel
 */
public class Mesa {
    private int codMesa;
    private String estado;

    public int getCodMesa() {
        return codMesa;
    }

    public void setCodMesa(int codMesa) {
        this.codMesa = codMesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String nombreEstado(){
        if (estado.equalsIgnoreCase("A"))return "active_table.png";
        if (estado.equalsIgnoreCase("D"))return "disabled_table.png";
        if (estado.equalsIgnoreCase("O"))return "ocupaded_table.png";
        else return "";
    }
}
