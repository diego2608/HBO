package com.consorciohbo.app.msdvip.BL.BE;

import android.support.annotation.VisibleForTesting;

/**
 * Created by Diego on 3/12/15.
 */
public class MaterialesBE {

    public int id;
    public String nombreMaterial;
    public String descripcion;
    public boolean estado;
    public String urlDescargar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUrlDescargar() {
        return urlDescargar;
    }

    public void setUrlDescargar(String urlDescargar) {
        this.urlDescargar = urlDescargar;
    }
}
