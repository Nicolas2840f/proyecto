/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Sena
 */
public class Computador {
    
    private int idComputador;
    private String marcaComputador;
    private String colorComputador;
    private String complementoComputador;
    private int idPersona;

    public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }

    public String getMarcaComputador() {
        return marcaComputador;
    }

    public void setMarcaComputador(String marcaComputador) {
        this.marcaComputador = marcaComputador;
    }

    public String getColorComputador() {
        return colorComputador;
    }

    public void setColorComputador(String colorComputador) {
        this.colorComputador = colorComputador;
    }

    public String getComplementoComputador() {
        return complementoComputador;
    }

    public void setComplementoComputador(String complementoComputador) {
        this.complementoComputador = complementoComputador;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int Persona_idPersona) {
        this.idPersona = Persona_idPersona;
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
        final Computador other = (Computador) obj;
        return this.idComputador == other.idComputador;
    }

    @Override
    public String toString() {
        return  marcaComputador;
    }
    
    public ArrayList listar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList losComputadores = new ArrayList();
        Computador elComputador;
        String listado= "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idComputador";
        try{
            ResultSet rs = st.executeQuery(listado);
            while(rs.next()){
                elComputador = new Computador();
                elComputador.setIdComputador(rs.getInt("idComputador"));
                elComputador.setMarcaComputador(rs.getString("marcaComputador"));
                elComputador.setColorComputador(rs.getString("colorComputador"));
                elComputador.setComplementoComputador(rs.getString("complementoComputador"));
                elComputador.setIdPersona(rs.getInt("Persona_idPersona"));
                losComputadores.add(elComputador);
            }
        }catch(SQLException ex){
            System.err.println("Error al listar: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
        
        if(losComputadores.isEmpty()){
            Computador miComputador = new Computador();
            miComputador.setMarcaComputador("No hay computadores");
            losComputadores.add(miComputador);
        }
        return losComputadores;
    }
    
    
    public void insertar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try{
            st.executeUpdate("INSERT INTO "+this.getClass().getSimpleName()+" VALUES(NULL,'"+getMarcaComputador()+"','"+getColorComputador()
                    +"','"+getComplementoComputador()+"','"+getIdPersona()+"')");
        }catch(SQLException ex){
            System.err.println("Error al insertar: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
    }
    public void modificar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try{
            st.executeUpdate("UPDATE "+this.getClass().getSimpleName()+" SET marcaComputador = '"+getMarcaComputador()+"', colorComputador = '"+getColorComputador()
                    +"', complementoComputador = '"+getComplementoComputador()+"', Persona_idPersona = '"+getIdPersona()+"' WHERE idComputador = "+getIdComputador());
        }catch(SQLException ex){
            System.err.println("Error al modificar: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
    }
    public void eliminar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try{
            st.executeUpdate("DELETE FROM "+this.getClass().getSimpleName()+" WHERE idComputador = "+getIdComputador());
            st.executeUpdate("ALTER TABLE "+this.getClass().getSimpleName()+" AUTO_INCREMENT = 0");
        }catch(SQLException ex){
            System.err.println("Error al eliminar: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
    }
    
    public Computador buscarPorId(int elId){
        Conexion conectar = new Conexion();
        Statement st = conectar.conectar();
        Computador elComputador = new Computador();
        String listado = "SELECT * FROM "+getClass().getSimpleName()+" WHERE idComputador = "+getIdComputador();
        try{
            ResultSet rs = st.executeQuery(listado);
            while(rs.next()){
                elComputador = new Computador();
                elComputador.setIdComputador(rs.getInt("idComputador"));
                elComputador.setMarcaComputador(rs.getString("marcaComputador"));
                elComputador.setColorComputador(rs.getString("colorComputador"));
                elComputador.setComplementoComputador(rs.getString("complementoComputador"));
                elComputador.setIdPersona(rs.getInt("Persona_idPersona"));
            }
        }catch(SQLException ex){
            System.err.println("Error al buscar por Id");
        }finally{
            conectar.desconectar();
        }
        return elComputador;
    }
    
    
}
