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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
//            EntidadBancaria entidadBancaria = new EntidadBancaria();
//            entidadBancaria.setIdEntidadBancaria(7);
//            entidadBancaria.setNombre("santander");
//            entidadBancaria.setCodigoEntidad("00" + entidadBancaria.getIdEntidadBancaria());
//            entidadBancaria.setFechaCreacion(null);
        
        //CREACIÓN DEL OBJETO PARA LLAMAR A LAS FUNCIONES DE LA CLASE 'EntidadBancariaDAO'
            EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAO();
        
        //BORRAR UNA FILA CONCRETA DE LA TABLA 'entidadBancaria'
//            entidadBancariaDAO.delete(4); 
        
        //INSERTAR UNA FILA CONCRETA DE LA TABLA 'entidadBancaria'
//            entidadBancariaDAO.insert(entidadBancaria);
        
//            entidadBancaria.setNombre("bankia");
            
//        MODIFICAR UNA FILA CONCRETA DE LA TABLA 'entidadBancaria'
//            entidadBancariaDAO.update(entidadBancaria);
         
        //MOSTRAR TODOS LOS REGISTROS O FILAS DE LA BASE DE DATOS
            List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
            
            entidadesBancarias = entidadBancariaDAO.findAll();
            
            
            System.out.println("IdEntidadBancaria    Nombre    CodigoEntidad   FechaCreacion" );
            System.out.println("");
            
            for (EntidadBancaria entidadBancaria: entidadesBancarias) {
                System.out.println(entidadBancaria.getIdEntidadBancaria() + "                    " + entidadBancaria.getNombre() +
                        "       " + entidadBancaria.getCodigoEntidad() + "          " + entidadBancaria.getFechaCreacion());
            }
            
        //MOSTRAR TODOS LOS REGISTROS O FILAS DE LA BASE DE DATOS
//            entidadBancariaDAO.find(entidadBancaria);
    }   
}
