/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package basedatosborrar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class BaseDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        //CREACION DEL OBJETO PARA LLAMAR A LAS FUNCIONES DE LA CLASE 'EntidadBancaria'
            EntidadBancaria entidadBancaria = new EntidadBancaria();
            entidadBancaria.setIdEntidadBancaria(7);
            entidadBancaria.setNombre("santander");
            entidadBancaria.setCodigoEntidad("00" + entidadBancaria.getIdEntidadBancaria());
            entidadBancaria.setFechaCreacion(null);
        
        //CREACIÓN DEL OBJETO PARA LLAMAR A LAS FUNCIONES DE LA CLASE 'EntidadBancariaDAO'
            EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAO();
        
        //BORRAR UNA FILA CONCRETA DE LA TABLA 'entidadBancaria'
//            entidadBancariaDAO.delete(4); 
        
        //INSERTAR UNA FILA CONCRETA DE LA TABLA 'entidadBancaria'
//            entidadBancariaDAO.insert(entidadBancaria);
        
//            entidadBancaria.setNombre("bankia");
            
        //MODIFICAR UNA FILA CONCRETA DE LA TABLA 'entidadBancaria'
//            entidadBancariaDAO.update(entidadBancaria);
         
        //MOSTRAR UNA LISTA DE FILAS DE LA BASE DE DATOS
//            entidadBancariaDAO.select();
    }   
}
