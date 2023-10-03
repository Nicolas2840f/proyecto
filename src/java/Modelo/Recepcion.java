/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Sena
 */
public class Recepcion {
    
    private int idRecepcion;
    private LocalDate fechaRecepcion;
    private String documentoCelador;
    private String nombreCelador;
    private LocalTime horaEntrada;
    private int idComputador;
    private LocalTime horaSalida;

    public int getIdRecepcion() {
        return idRecepcion;
    }

    public void setIdRecepcion(int idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getDocumentoCelador() {
        return documentoCelador;
    }

    public void setDocumentoCelador(String documentoCelador) {
        this.documentoCelador = documentoCelador;
    }

    public String getNombreCelador() {
        return nombreCelador;
    }

    public void setNombreCelador(String nombreCelador) {
        this.nombreCelador = nombreCelador;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }


    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    public ArrayList listar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList lasRecepciones = new ArrayList();
        Recepcion laRecepcion;
        String listado = "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idRecepcion";
        try{
            ResultSet rs = st.executeQuery(listado);
            while(rs.next()){
                laRecepcion = new Recepcion();
                laRecepcion.setIdRecepcion(rs.getInt("idRecepcion"));
                laRecepcion.setFechaRecepcion(rs.getObject("fechaRecepcion",LocalDate.class));
                laRecepcion.setDocumentoCelador(rs.getString("documentoCelador"));
                laRecepcion.setNombreCelador(rs.getString("nombreCelador"));
                laRecepcion.setHoraEntrada(rs.getObject("horaEntrada",LocalTime.class));
                laRecepcion.setIdComputador(rs.getInt("Computador_idComputador"));
                laRecepcion.setHoraSalida(rs.getObject("horaSalida",LocalTime.class));
                lasRecepciones.add(laRecepcion);
            }
        }catch(SQLException ex){
            System.err.println("Error al listar: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
        return lasRecepciones;
    }
    
    public void insertar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try{
            st.executeUpdate("INSERT INTO "+this.getClass().getSimpleName()+" VALUES (NULL,'"+getFechaRecepcion()+"','"+getDocumentoCelador()
                    +"','"+getNombreCelador()+"','"+getHoraEntrada()+"','"+getIdComputador()+"','"+getHoraSalida()+"')");
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
            st.executeUpdate("UPDATE "+this.getClass().getSimpleName()+" SET fechaRecepcion = '"+getFechaRecepcion()+"', documentoCelador = '"+getDocumentoCelador()
                    +"', nombreCelador = '"+getNombreCelador()+"', horaEntrada = '"+getHoraEntrada()+"',"
                            + " Computador_idComputador = '"+getIdComputador()+"', horaSalida = '"+getHoraSalida()+"' WHERE idRecepcion = "+getIdRecepcion());
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
            st.executeUpdate("DELETE  FROM "+this.getClass().getSimpleName()+" WHERE idRecepcion = "+getIdRecepcion());
        }catch(SQLException ex){
            System.err.println("Error al eliminar: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
    }
}
