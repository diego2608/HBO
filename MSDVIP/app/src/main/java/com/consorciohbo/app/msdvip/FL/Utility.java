package com.consorciohbo.app.msdvip.FL;

import android.text.TextUtils;

import com.consorciohbo.app.msdvip.BL.BE.MedicoBE;

/**
 * Created by Diego on 11/12/15.
 */
public class Utility {
    public String CodAplicacion = "7DF98BA9-C9CA-450C-8EAF-BD3FBA790DBF";

    public static boolean isNotNull(String txt) {
        return txt != null && txt.trim().length() > 0 ? true : false;
    }

    //----------------------------------------------------------------
    public static String formatearFecha(String fecha) {
        String devolver = fecha.substring(5, 10);
        String mes = devolver.substring(0, 2);
        String dia = devolver.substring(3, 5);
        return dia + "/" + mes;
    }

    //---------------------------------------------------------------
    public static MedicoBE DivCompleteName(MedicoBE objMedicoBE) {

        String nombreCompletoArray[] = objMedicoBE.getNombreCompleto().split(",");

        objMedicoBE.setApellido(nombreCompletoArray[0]);
        objMedicoBE.setNombre(nombreCompletoArray[1]);


        return objMedicoBE;
    }

    //---------------------------------------------------------------
    public static String nombreCompleto(String apellido, String nombre){
        String Nombre ="";

        Nombre = apellido + ", " +nombre;


        return Nombre;
    }
    //---------------------------------------------------------------

    public static String getDatabaseFolderPath() {
        return "/data/data/com.consorciohbo.membership/databases/";
    }
    //---------------------------------------------------------------

    public static String getDatabasePath() {
        return "/data/data/com.consorciohbo.membership/databases/HBOMembership.sqlite";
    }
    //---------------------------------------------------------------

    public static boolean validarPassword(String password) {
        if (password.length() < 8)
            return false;
        return true;
    }
    //---------------------------------------------------------------

    public static boolean validarCelular(String celular) {
        if (celular.length() < 8 || celular.length() > 9)
            return false;
        return true;
    }
    //---------------------------------------------------------------

    public static boolean validarCorreo(String correo) {
        if (correo.length() <= 0) return false;

        if (TextUtils.isEmpty(correo)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches();
        }
    }
    //---------------------------------------------------------------

}
