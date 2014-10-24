/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package basedatosborrar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAO {
    public void delete (int idEntidadBancaria) throws SQLException {
         
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_bancario","root", "root");
        String deleteTableSQL = "DELETE FROM entidadbancaria WHERE idEntidadBancaria = ?";
        
        PreparedStatement preparedStatement = conn.prepareStatement(deleteTableSQL);
        preparedStatement.setInt(1, idEntidadBancaria);
        
        //EJECUTAR LA CONSULTA DELETE
        preparedStatement.executeUpdate();
    }    
    
    public void insert(EntidadBancaria entidadBancaria) throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_bancario","root", "root");
        String insertTableSQL = "INSERT INTO entidadbancaria VALUES (?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, entidadBancaria.getIdEntidadBancaria());
        preparedStatement.setString(2, entidadBancaria.getNombre());
        preparedStatement.setString(3, entidadBancaria.getCodigoEntidad());
        preparedStatement.setTimestamp(4, getCurrentTimeStamp());
        
        //EJECUTAR LA CONSULTA INSERT
        preparedStatement.executeUpdate();
    }
    
    public void update(EntidadBancaria entidadBancaria) throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_bancario","root", "root");
        String updateTableSQL = "UPDATE entidadbancaria SET nombre = ?, codigoEntidad = ? WHERE idEntidadBancaria = ?";
        
        PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
        preparedStatement.setString(1, entidadBancaria.getNombre());
        preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
        preparedStatement.setInt(3, entidadBancaria.getIdEntidadBancaria());
        
        //EJECUTAR LA CONSULTA UPDATE
        preparedStatement.executeUpdate();
    }
    
    public List<EntidadBancaria> findAll() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_bancario","root", "root");
        String selectSQL = "SELECT * FROM entidadbancaria";
        
        PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
        ResultSet rs = preparedStatement.executeQuery(selectSQL );
        
        List<EntidadBancaria> entidadesBancarias = new ArrayList<EntidadBancaria>();
        
        while (rs.next()) {
            EntidadBancaria entidadBancaria = new EntidadBancaria();
            entidadBancaria.setIdEntidadBancaria(rs.getInt("idEntidadBancaria"));
            entidadBancaria.setNombre(rs.getString("nombre"));
            entidadBancaria.setCodigoEntidad(rs.getString("codigoEntidad"));
            entidadBancaria.setFechaCreacion(rs.getDate("fechaCreacion"));
            
            entidadesBancarias.add(entidadBancaria);
        }
        return entidadesBancarias;
    }
    
    public void find(EntidadBancaria entidadBancaria) throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_bancario","root", "root");
        String selectParcialSQL = "SELECT * FROM entidadbancaria WHERE nombre = ?";
        
        PreparedStatement preparedStatement = conn.prepareStatement(selectParcialSQL);
        preparedStatement.setString(1, entidadBancaria.getNombre());
        ResultSet rs = preparedStatement.executeQuery(selectParcialSQL);
        
        System.out.println("ID_ENTIDAD_BANCARIA" + "    " + "NOMBRE" + "    " + "CODIGO_ENTIDAD" + "    " 
                + "FECHA_CREACION");
        while (rs.next()) {
            System.out.println(rs.getInt("idEntidadBancaria") + "                      " 
                + rs.getString(entidadBancaria.getNombre()) + "       " + rs.getString("codigoEntidad") + "           " 
                + rs.getDate("fechaCreacion"));
        }
    }
    
    private static java.sql.Timestamp getCurrentTimeStamp() {
 
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
 
    }
    
}
