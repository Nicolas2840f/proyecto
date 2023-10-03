/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Sena
 */
public class Persona {

    private int idPersona;
    private String tipoDocumento;
    private String documentoPersona;
    private String nombrePersona;
    private String telefonoPersona;
    private String rolPersona;
    private String correoPersona;
    private String contraseñaPersona;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumentoPersona() {
        return documentoPersona;
    }

    public void setDocumentoPersona(String documentoPersona) {
        this.documentoPersona = documentoPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getRolPersona() {
        return rolPersona;
    }

    public void setRolPersona(String rolPersona) {
        this.rolPersona = rolPersona;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    public String getContraseñaPersona() {
        return contraseñaPersona;
    }

    public void setContraseñaPersona(String contraseñaPersona) {
        this.contraseñaPersona = contraseñaPersona;
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
        final Persona other = (Persona) obj;
        return this.idPersona == other.idPersona;
    }

    @Override
    public String toString() {
        return documentoPersona;
    }

    public ArrayList listar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        ArrayList listaPersonas = new ArrayList();
        Persona laPersona;
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " ORDER BY idPersona";
        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {
                laPersona = new Persona();
                laPersona.setIdPersona(rs.getInt("idPersona"));
                laPersona.setTipoDocumento(rs.getString("tipoDocumento"));
                laPersona.setDocumentoPersona(rs.getString("documentoPersona"));
                laPersona.setNombrePersona(rs.getString("nombrePersona"));
                laPersona.setTelefonoPersona(rs.getString("telefonoPersona"));
                laPersona.setCorreoPersona(rs.getString("correoPersona"));
                listaPersonas.add(laPersona);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar");
        }finally{
            conexion.desconectar();
        }
        if (listaPersonas.isEmpty()) {
            Persona unaPersona = new Persona();
            unaPersona.setNombrePersona("No hay Personas");
            listaPersonas.add(unaPersona);
        }
        return listaPersonas;
    }

    public boolean validarCorreo(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        String consulta = "SELECT * FROM "+this.getClass().getSimpleName()+" WHERE correoPersona = '"+getCorreoPersona()+"'";
        try{
            ResultSet rs = st.executeQuery(consulta);
            return rs.next();
        }catch(SQLException ex){
            System.err.println("Error al validar el correo "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
        return false;
    }
    public boolean validarDocumento(){
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        String consulta = "SELECT * FROM "+this.getClass().getSimpleName()+" WHERE documentoPersona = '"+getDocumentoPersona()+"'";
        try{
            ResultSet rs = st.executeQuery(consulta);
            return rs.next();
        }catch(SQLException ex){
            System.err.println("Error al validar el documento "+ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
        return false;
    }
    public void insertar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        String contraseñaEncriptada = BCrypt.hashpw(getContraseñaPersona(),BCrypt.gensalt() );
        try {
            st.executeUpdate("INSERT INTO " + this.getClass().getSimpleName() + " VALUES(NULL,'" + getTipoDocumento() + "','" + getDocumentoPersona() + "','"
                    + getNombrePersona() + "','" + getTelefonoPersona() + "','Usuario','" + getCorreoPersona() + "','" + contraseñaEncriptada + "')");
        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
    }

    public void modificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("UPDATE " + this.getClass().getSimpleName() + " SET tipoDocumento = '" + getTipoDocumento() + "', documentoPersona = '" + getDocumentoPersona()
                    + "', nombrePersona = '" + getNombrePersona() + "', telefonoPersona = '" + getTelefonoPersona() + "', correoPersona = '" + getCorreoPersona() + "'");
        } catch (SQLException ex) {
            System.err.println("Error al modificar: " + ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
    }

    public void eliminar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        try {
            st.executeUpdate("DELETE * FROM " + this.getClass().getSimpleName() + " WHERE idPersona = " + getIdPersona());
        } catch (SQLException ex) {
            System.err.println("Error al eliminar: " + ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
    }

    public Persona buscarPorId(int elId) {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        Persona unaPersona = new Persona();
        String listado = "SELECT * FROM " + this.getClass().getSimpleName() + " WHERE idPersona = " + getIdPersona();
        try {
            ResultSet rs = st.executeQuery(listado);
            while (rs.next()) {

                unaPersona = new Persona();
                unaPersona.setIdPersona(rs.getInt("idPersona"));
                unaPersona.setTipoDocumento(rs.getString("tipoDocumento"));
                unaPersona.setDocumentoPersona(rs.getString("documentoPersona"));
                unaPersona.setNombrePersona(rs.getString("nombrePersona"));
                unaPersona.setTelefonoPersona(rs.getString("telefonoPersona"));
                unaPersona.setCorreoPersona(rs.getString("correoPersona"));
            }
        } catch (SQLException ex) {
            System.err.println("Error al buscar por id: " + ex.getLocalizedMessage());
        }finally{
            conexion.desconectar();
        }
        return unaPersona;
    }

    public boolean verificar() {
        Conexion conexion = new Conexion();
        Statement st = conexion.conectar();
        String consulta = "SELECT * FROM " + this.getClass().getSimpleName() + " WHERE tipoDocumento = '" + getTipoDocumento() + "' AND documentoPersona = '" + getDocumentoPersona() + "'";

        try {

            ResultSet rs = st.executeQuery(consulta);
            if (rs.next()) {
                String contraseñaBD = rs.getString("contraseñaPersona");
                if (BCrypt.checkpw(getContraseñaPersona(), contraseñaBD)) {
                    int _idPersona = rs.getInt("idPersona");
                    String _nombrePersona = rs.getString("nombrePersona");
                    String _documentoPersona = rs.getString("documentoPersona");
                    String _rolPersona = rs.getString("rolPersona");
                    String _telefonoPersona = rs.getString("telefonoPersona");
                    String _correoPersona = rs.getString("correoPersona");

                    this.idPersona = _idPersona;
                    this.nombrePersona = _nombrePersona;
                    this.documentoPersona = _documentoPersona;
                    this.rolPersona = _rolPersona;
                    this.telefonoPersona = _telefonoPersona;
                    this.correoPersona = _correoPersona;
                    return true;
                    
                }

            }
        } catch (SQLException ex) {
            System.out.println("Error al validar credenciales: " + ex.getLocalizedMessage());
        }
        finally{
            conexion.desconectar();
        }
        
        return false;
    }

}
