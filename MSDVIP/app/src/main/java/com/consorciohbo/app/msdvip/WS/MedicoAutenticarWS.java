package com.consorciohbo.app.msdvip.WS;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.consorciohbo.app.msdvip.BL.BE.MedicoBE;
import com.consorciohbo.app.msdvip.FL.Utility;
import com.consorciohbo.app.msdvip.UI.ControlsViews.LoginActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by Diego on 18/11/15.
 */
public class MedicoAutenticarWS extends AsyncTask<MedicoBE, Integer, MedicoBE> {
    private LoginActivity mContext;
    private ProgressDialog mProgress;
    private Utility objUtility;


    public MedicoAutenticarWS(LoginActivity mContext, int a) {
        this.mContext = mContext;
    }

    @Override
    protected MedicoBE doInBackground(MedicoBE... params) {
        MedicoBE medico = new MedicoBE();
        HttpClient client = new DefaultHttpClient();
        objUtility = new Utility();

        HttpPost request = new HttpPost("https://mobile.consorciohbo.com.pe/HBOMembership.WebService/MedicoWS.svc/MedicoAutenticar");
        request.setHeader("content-type", "application/json");

        try {
            JSONObject data = new JSONObject();

            data.put("MedicoExternoID", params[0].getMedicoExternoID());
            data.put("CMP", params[0].getCMP());
            data.put("Password", params[0].getPassword());
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
                medico.setPassword(jsonReponse.getString("Password"));
              //  medico.setEstadoActivacion(jsonReponse.getString("EstadoActivacion"));

                return medico;
            } catch (Exception ex) {
                return null;
            }
        } catch (Exception e) {
            medico = null;
        }
        return medico;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        mProgress = ProgressDialog.show(mContext, "MSDVip", "Ingresando");
        mProgress.setCancelable(false);
    }

    @Override
    protected void onPostExecute(MedicoBE result) {
        super.onPostExecute(result);

        mProgress.dismiss();

        try {
            mContext.autenticarOnComplete(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
