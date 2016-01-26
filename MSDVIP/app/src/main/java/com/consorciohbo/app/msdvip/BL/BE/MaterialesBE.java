package com.consorciohbo.app.msdvip.BL.BE;

import android.support.annotation.VisibleForTesting;

/**
 * Created by Diego on 3/12/15.
 */
public class MaterialesBE {

    public String id;
    public String nombreMaterial;
    public String descripcion;
    public String estado;
    public String urlDescargar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrlDescargar() {
        return urlDescargar;
    }

    public void setUrlDescargar(String urlDescargar) {
        this.urlDescargar = urlDescargar;
    }
}
