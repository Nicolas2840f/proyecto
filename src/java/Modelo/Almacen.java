/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Sena
 */
public class Almacen {
    
    private int idAlmacen;
    private LocalDate fechaAlmacen;
    private String documentoEncargado;
    private String nombreEncargado;
    private LocalTime horaEntrada;
    private int idObjeto;
    private int idPersona;
    private LocalTime horaSalida;

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public LocalDate getFechaAlmacen() {
        return fechaAlmacen;
    }

    public void setFechaAlmacen(LocalDate fechaAlmacen) {
        this.fechaAlmacen = fechaAlmacen;
    }

    public String getDocumentoEncargado() {
        return documentoEncargado;
    }

    public void setDocumentoEncargado(String documentoEncargado) {
        this.documentoEncargado = documentoEncargado;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Almacen other = (Almacen) obj;
        return this.idAlmacen == other.idAlmacen;
    }
    
    public ArrayList listar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList losAlmacenes =  new ArrayList();
        Almacen elAlmacen;
        String listado = "SELECT * FROM "+this.getClass().getSimpleName()+" ORDER BY idAlmacen";
        try{
            ResultSet rs = st.executeQuery(listado);
            while(rs.next()){
                elAlmacen = new Almacen();
                elAlmacen.setIdAlmacen(rs.getInt("idAlmacen"));
                elAlmacen.setFechaAlmacen(rs.getObject("fechaAlmacen", LocalDate.class));
                elAlmacen.setDocumentoEncargado(rs.getString("documentoEncargado"));
                elAlmacen.setNombreEncargado(rs.getString("nombreEncargado"));
                elAlmacen.setHoraEntrada(rs.getObject("horaEntrada",LocalTime.class));
                elAlmacen.setIdObjeto(rs.getInt("Objeto_idObjeto"));
                elAlmacen.setIdPersona(rs.getInt("Persona_idPersona"));
                elAlmacen.setHoraSalida(rs.getObject("horaSalida",LocalTime.class));
                losAlmacenes.add(elAlmacen);
            }
        }catch(SQLException ex){
            System.err.println("Error al listar: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
        return losAlmacenes;
    }
    
    public void insertar(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try{
            st.executeUpdate("INSERT INTO "+this.getClass().getSimpleName()+" VALUES (NULL,'"+getFechaAlmacen()+"','"+getDocumentoEncargado()
                    +"','"+getNombreEncargado()+"','"+getHoraEntrada()+"','"+getIdObjeto()+"','"+getIdPersona()+"','"+getHoraSalida()+"')");
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
            st.executeUpdate("UPDATE "+this.getClass().getSimpleName()+" SET fechaAlmacen = '"+getFechaAlmacen()+"', documentoEncargado = '"+getDocumentoEncargado()
                    +"', nombreEncargado = '"+getNombreEncargado()+"', horaEntrada = '"+getHoraEntrada()+"',"
                            + " Objeto_idObjeto = '"+getIdObjeto()+"', Persona_idPersona = '"+getIdPersona()+"',horaSalida = '"+getHoraSalida()+"' WHERE idAlmacen = "+getIdAlmacen());
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
            st.executeUpdate("DELETE FROM "+this.getClass().getSimpleName()+" WHERE idAlmacen = "+getIdAlmacen());
            st.executeUpdate("ALTER TABLE "+this.getClass().getSimpleName()+" AUTO_INCREMENT = 0");
        }catch(SQLException ex){
            System.err.println("Error al eliminar: "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
    }
}
