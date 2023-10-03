/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sena
 */
public class Objeto {

    private int idObjeto;
    private String descripcionObjeto;
    private String cantidadObjeto;

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getDescripcionObjeto() {
        return descripcionObjeto;
    }

    public void setDescripcionObjeto(String descripcionObjeto) {
        this.descripcionObjeto = descripcionObjeto;
    }

    public String getCantidadObjeto() {
        return cantidadObjeto;
    }

    public void setCantidadObjeto(String cantidadObjeto) {
        this.cantidadObjeto = cantidadObjeto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Objeto other = (Objeto) obj;
        return this.idObjeto == other.idObjeto;
    }

    @Override
    public String toString() {
        return descripcionObjeto;
    }
    
    public ArrayList listar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList losObjetos = new ArrayList();
        Objeto elObjeto;
        String listado = "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idObjeto";
        try{
            ResultSet rs = st.executeQuery(listado);
            while(rs.next()){
                elObjeto = new Objeto();
                elObjeto.setIdObjeto(rs.getInt("idObjeto"));
                elObjeto.setDescripcionObjeto(rs.getString("descripcionObjeto"));
                elObjeto.setCantidadObjeto(rs.getString("cantidadObjeto"));
                losObjetos.add(elObjeto);
            }
            
        }catch(SQLException ex){
            System.err.println("Error al listar los Objetos: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
        if(losObjetos.isEmpty()){
            Objeto miObjeto = new Objeto();
            miObjeto.setDescripcionObjeto("No hay objetos");
            losObjetos.add(miObjeto);
        }
        return losObjetos;
    }
    
    public void insertar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try{
            st.executeUpdate("INSERT INTO "+this.getClass().getSimpleName()+" VALUES(NULL,'"+getDescripcionObjeto()+"','"+getCantidadObjeto()+"')");
        }catch(SQLException ex ){
            System.err.println("Error al insertar: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
    }
    public void modificar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try{
            st.executeUpdate("UPDATE "+this.getClass().getSimpleName()+" SET descripcionObjeto = '"+getDescripcionObjeto()
                    +"', cantidadObjeto = '"+getCantidadObjeto()+"' WHERE idObjeto = "+getIdObjeto());
        }catch(SQLException ex ){
            System.err.println("Error al modificar: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
    }
    public void eliminar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try{
            st.executeUpdate("DELETE FROM "+this.getClass().getSimpleName()+" WHERE idObjeto = "+getIdObjeto());
            st.executeUpdate("ALTER TABLE "+this.getClass().getSimpleName()+" AUTO_INCREMENT = 0");
        }catch(SQLException ex ){
            System.err.println("Error al eliminar: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
    }
    
    public Objeto buscarPorId(int elId){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        Objeto elObjeto = new Objeto();
        String listado = "SELECT * FROM "+this.getClass().getSimpleName()+" WHERE idObjeto = "+getIdObjeto();
        try{
            ResultSet rs = st.executeQuery(listado);
            while(rs.next()){
                elObjeto = new Objeto();
                elObjeto.setIdObjeto(rs.getInt("idObjeto"));
                elObjeto.setDescripcionObjeto(rs.getString("descripcionObjeto"));
                elObjeto.setCantidadObjeto(rs.getString("cantidadObjeto"));
            }
        }catch(SQLException ex){
            System.err.println("Error al buscar por Id: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
        return elObjeto;
    }
}
