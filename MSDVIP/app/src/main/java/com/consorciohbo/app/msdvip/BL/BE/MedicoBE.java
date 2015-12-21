package com.consorciohbo.app.msdvip.BL.BE;

/**
 * Created by Diego on 18/11/15.
 */
public class MedicoBE {
    private String MedicoID;
    private String MedicoExternoID;
    private String NombreCompleto;
    private String Telefono;
    private String Email;
    private String CMP;
    private String Password;
    private String Especialidad;
    private String Nombre;
    private String Apellido;
    private String EstadoActivacion;


    public MedicoBE() {
    }

    public MedicoBE(String medicoExternoID, String nombreCompleto,
                    String telefono, String email, String cMP, String password,String especialidad) throws Exception {
        super();
        MedicoExternoID = medicoExternoID;
        NombreCompleto = nombreCompleto;
        Telefono = telefono;
        Email = email;
        CMP = cMP;
        Password = password;
        Especialidad = especialidad;
    }

    public String getEstadoActivacion() {
        return EstadoActivacion;
    }

    public void setEstadoActivacion(String estadoActivacion) {
        EstadoActivacion = estadoActivacion;
    }

    public String getMedicoID() {
        return MedicoID;
    }

    public void setMedicoID(String medicoID) {
        MedicoID = medicoID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getMedicoExternoID() {
        return MedicoExternoID;
    }

    public void setMedicoExternoID(String medicoExternoID) {
        MedicoExternoID = medicoExternoID;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCMP() {
        return CMP;
    }

    public void setCMP(String cMP) {
        CMP = cMP;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
