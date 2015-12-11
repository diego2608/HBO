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
public class MedicoRegistrarWS extends AsyncTask<MedicoBE, Integer, String> {
    Utility objUtility = new Utility();

    @Override
    protected String doInBackground(MedicoBE... params) {
        String result = "";
        HttpClient client = new DefaultHttpClient();

        HttpPost request = new HttpPost("https://mobile.consorciohbo.com.pe/HBOMembership.WebService/MedicoWS.svc/MedicoRegistrar");
        request.setHeader("content-type", "application/json");

        try {
            JSONObject data = new JSONObject();
            data.put("MedicoExternoID", params[0].getMedicoExternoID());
            data.put("NombreCompleto", objUtility.nombreCompleto(params[0].getApellido(),params[0].getNombre()));
            data.put("Email", params[0].getEmail());
            data.put("Telefono", params[0].getTelefono());
            data.put("CMP", params[0].getCMP());
            data.put("Password", params[0].getPassword());
            data.put("Especialidad",params[0].getEspecialidad());
            data.put("ProgramaID", objUtility.CodAplicacion);

            //StringEntity entity = new StringEntity(data.toString());
            HttpEntity entity = new StringEntity(data.toString());
            request.setEntity(entity);

            HttpResponse response = client.execute(request);

            String responseString = EntityUtils.toString(response.getEntity());

            if (responseString.equals("true")) {
                result = "true";
            } else {
                result = "false";
            }
        } catch (Exception e) {
            result = "error";
        }
        return result;
    }
}
