package com.consorciohbo.app.msdvip.WS;

import android.os.AsyncTask;

import com.consorciohbo.app.msdvip.BL.BE.MedicoBE;
import com.consorciohbo.app.msdvip.FL.Utility;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by Diego on 11/12/15.
 */
public class MedicoObtenerCompletoWS extends AsyncTask<String, Integer, MedicoBE> {
    Utility objUtility = new Utility();
    @Override
    protected MedicoBE doInBackground(String... params) {
        MedicoBE medico = new MedicoBE();
        HttpClient client =  new DefaultHttpClient();

        HttpPost request = new HttpPost("https://mobile.consorciohbo.com.pe/HBOMembership.WebService/MedicoWS.svc/MedicoObtenerPorProgramaIDYMedicoExternoID");
        request.setHeader("content-type","application/json");

        try {
            JSONObject data = new JSONObject();

            data.put("MedicoExternoID", params[0]);
            data.put("ProgramaID", objUtility.CodAplicacion);

            //StringEntity entity = new StringEntity(data.toString());
            HttpEntity entity = new StringEntity(data.toString());
            request.setEntity(entity);

            HttpResponse response = client.execute(request);

            String responseString = EntityUtils.toString(response.getEntity());

            try {
                JSONObject jsonReponse = new JSONObject(responseString);
                medico.setMedicoExternoID(jsonReponse.getString("MedicoExternoID"));
                medico.setNombreCompleto(jsonReponse.getString("NombreCompleto"));
                medico.setTelefono(jsonReponse.getString("Telefono"));
                medico.setEmail(jsonReponse.getString("Email"));
                medico.setCMP(jsonReponse.getString("CMP"));
                medico.setEspecialidad(jsonReponse.getString("Especialidad"));
                medico.setPassword(jsonReponse.getString("Password"));
                medico = objUtility.DivCompleteName(medico);
            }
            catch (Exception ex){
                medico = null;
            }
        }
        catch (Exception e){
            medico = null;
        }
        return medico;
    }
}
