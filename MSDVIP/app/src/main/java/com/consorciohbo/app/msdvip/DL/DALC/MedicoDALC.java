package com.consorciohbo.app.msdvip.DL.DALC;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.consorciohbo.app.msdvip.BL.BE.MedicoBE;
import com.consorciohbo.app.msdvip.FL.Utility;

/**
 * Created by Diego on 18/11/15.
 */
public class MedicoDALC {

    public static boolean MedicoRegistrar(MedicoBE objMedicoBE) {
        boolean Resultado=true;
        SQLiteDatabase database = SQLiteDatabase.openDatabase(Utility.getDatabasePath(), null, Context.MODE_PRIVATE);
        if(database != null)
        {

            String temp1="INSERT INTO Medico (";
            String temp2=") VALUES (";

            if(objMedicoBE.getMedicoID() != null)
            {
                temp1=String.format("%sMedicoID",temp1);
                temp2=String.format("%s'%s'",temp2,objMedicoBE.getMedicoID());
            } else {
                temp1=String.format("%sMedicoID",temp1);
                temp2=String.format("%s'%s'",temp2,"(null)");
            }

            if(objMedicoBE.getMedicoExternoID() != null)
            {
                temp1=String.format("%s,MedicoExternoID",temp1);
                temp2=String.format("%s,'%s'",temp2,objMedicoBE.getMedicoExternoID());
            }

            if(objMedicoBE.getNombreCompleto() != null)
            {
                temp1=String.format("%s,NombreCompleto",temp1);
                temp2=String.format("%s,'%s'",temp2,objMedicoBE.getNombreCompleto());
            }

            if(objMedicoBE.getEmail() != null)
            {
                temp1=String.format("%s,Email",temp1);
                temp2=String.format("%s,'%s'",temp2,objMedicoBE.getEmail());
            }

            if(objMedicoBE.getTelefono() != null)
            {
                temp1=String.format("%s,Telefono",temp1);
                temp2=String.format("%s,'%s'",temp2,objMedicoBE.getTelefono());
            }

            if(objMedicoBE.getCMP().length() != 0)
            {
                temp1=String.format("%s,CMP",temp1);
                temp2=String.format("%s,'%s'",temp2,objMedicoBE.getCMP());
            }

            temp1=String.format("%s%s)",temp1,temp2);

            database.execSQL(temp1);
            /*
            if(![database executeUpdate:temp1])
            {
                NSLog(@"MedicoDALC: No se pudó registrar el usuario.");
                Resultado = NO;
            }
            */
        }
        return Resultado;
    }

    public static boolean MedicoActualizar(MedicoBE objMedicoBE) {
        boolean Resultado=true;
        SQLiteDatabase database = SQLiteDatabase.openDatabase(Utility.getDatabasePath(), null, Context.MODE_PRIVATE);
        if(database != null)
        {

            String temp="UPDATE Medico SET ";

            if(objMedicoBE.getCMP() != null)
            {
                temp = String.format("%sCMP = '%s'",temp,objMedicoBE.getCMP());
            }

            if(objMedicoBE.getMedicoID() != null)
            {
                temp = String.format("%s, MedicoID = '%s'",temp,objMedicoBE.getMedicoID());
            }
            if(objMedicoBE.getMedicoExternoID() != null)
            {
                temp = String.format("%s, MedicoExternoID = '%s'",temp,objMedicoBE.getMedicoExternoID());
            }

            if(objMedicoBE.getNombreCompleto() != null)
            {
                temp = String.format("%s, NombreCompleto = '%s'",temp,objMedicoBE.getNombreCompleto());
            }

            if(objMedicoBE.getEmail() != null)
            {
                temp = String.format("%s, Email = '%s'",temp,objMedicoBE.getEmail());
            }

            if(objMedicoBE.getTelefono() != null)
            {
                temp = String.format("%s, Telefono = '%s'",temp,objMedicoBE.getTelefono());
            }

            if(objMedicoBE.getPassword() != null)
            {
                temp = String.format("%s, Password = '%s'",temp,objMedicoBE.getPassword());
            }

            database.execSQL(temp);
            /*
            if(![database executeUpdate:temp])
            {
                NSLog(@"MedicoDALC: No se pudó actualizar el usuario.");
                Resultado = NO;
            }
            */

        }
        return Resultado;
    }

    public static boolean MedicoEliminar() {
        String SQLStmt = String.format("DELETE FROM Medico");
        SQLiteDatabase database = SQLiteDatabase.openDatabase(Utility.getDatabasePath(), null, Context.MODE_PRIVATE);
        boolean Resultado = true;
        if(database != null)
        {
            database.execSQL(SQLStmt);
            /*
            if(![database executeUpdate:SQLStmt])
            {
                NSLog(@"MedicoDALC: No se pudó eliminar el usuario.");
                Resultado = NO;
            }
            */
        }
        return Resultado;
    }

    public static MedicoBE MedicoRetornar() {
        MedicoBE objMedicoBE = null;

        SQLiteDatabase database = SQLiteDatabase.openDatabase(Utility.getDatabasePath(), null, Context.MODE_PRIVATE);
        if(database != null)
        {
            String sqlStatement = "SELECT MedicoID, MedicoExternoID, NombreCompleto, Telefono, Email, CMP, Password FROM Medico";

            Cursor res =  database.rawQuery(sqlStatement, null);
            res.moveToFirst();

            while(res.isAfterLast() == false){

                objMedicoBE = new MedicoBE();

                objMedicoBE.setMedicoID(res.getString(0));
                objMedicoBE.setMedicoExternoID(res.getString(1));
                objMedicoBE.setNombreCompleto(res.getString(2));
                objMedicoBE.setTelefono(res.getString(3));
                objMedicoBE.setEmail(res.getString(4));
                objMedicoBE.setCMP(res.getString(5));
                objMedicoBE.setPassword(res.getString(6));

                res.moveToNext();
            }
        }
        return objMedicoBE;
    }

}
