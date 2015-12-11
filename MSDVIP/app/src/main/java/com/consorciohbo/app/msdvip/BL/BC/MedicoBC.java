package com.consorciohbo.app.msdvip.BL.BC;

import com.consorciohbo.app.msdvip.BL.BE.MedicoBE;
import com.consorciohbo.app.msdvip.DL.DALC.MedicoDALC;

/**
 * Created by Diego on 18/11/15.
 */
public class MedicoBC {
    public static boolean MedicoRegistrar(MedicoBE objMedicoBE) {
        boolean Resultado;
        try
        {
            Resultado = MedicoDALC.MedicoRegistrar(objMedicoBE);
        }
        catch (Exception e)
        {
            Resultado = false;
            throw e;
        }
        return Resultado;
    }

    public static boolean MedicoActualizar(MedicoBE objMedicoBE) {
        boolean Resultado;
        try
        {
            Resultado = MedicoDALC.MedicoActualizar(objMedicoBE);
        }
        catch (Exception e)
        {
            Resultado = false;
            throw e;
        }
        return Resultado;
    }

    public static boolean MedicoEliminar()
    {
        boolean Resultado;
        try
        {
            Resultado = MedicoDALC.MedicoEliminar();

        }
        catch (Exception e)
        {
            Resultado = false;
            throw e;
        }
        return Resultado;
    }

    public static MedicoBE MedicoRetornar()
    {
        MedicoBE Resultado=null;
        try
        {
            Resultado = MedicoDALC.MedicoRetornar();
        }
        catch (Exception e)
        {
            Resultado = null;
            throw e;
        }
        return Resultado;
    }
}
