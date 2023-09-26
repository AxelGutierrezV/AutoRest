/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Orden;

/**
 *
 * @author Axel
 */
public class OrdenDAO {
    public void addOrden(Orden o){
        Orden.ordenes.add(o);        
    }
    
    public void modifyOrden(Orden o){
        
    }
    
    public void selectOrden(int CodOrden){
        Orden or = new Orden();
        Orden.ordenes.indexOf(or.getCodOrden());
    }
}


//almacenar en la orden el codigo del plato y la cantidad, en caso se añada un plato mas se añade por codigo por debajo
//pero se muestra el nombre
