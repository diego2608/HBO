package com.consorciohbo.app.msdvip.WS;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.consorciohbo.app.msdvip.BL.BE.MedicoBE;
import com.consorciohbo.app.msdvip.FL.Utility;
import com.consorciohbo.app.msdvip.UI.ControlsViews.CrearUserActivity;
import com.consorciohbo.app.msdvip.UI.ControlsViews.LoginActivity;
import com.consorciohbo.app.msdvip.UI.ControlsViews.MainActivity;

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
public class MedicoObtenerWS extends AsyncTask<String, Integer, MedicoBE> {

    Utility objUtility = new Utility();

    private Activity mContext;
    private ProgressDialog mProgress;

    public MedicoObtenerWS(Activity mContext) {
        this.mContext = mContext;
    }

    @Override
    protected MedicoBE doInBackground(String... params) {
        // TODO Auto-generated method stub
        MedicoBE medico = new MedicoBE();
        HttpClient client =  new DefaultHttpClient();

        HttpPost request = new HttpPost("https://mobile.consorciohbo.com.pe/HBOMembership.WebService/MedicoWS.svc/MedicoObtenerPorProgramaIDYCMP");
        request.setHeader("content-type","application/json");

        try {
            JSONObject data = new JSONObject();

            data.put("CMP", params[0]);
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

    @Override
    protected void onPreExecute() {
        mProgress = ProgressDialog.show(mContext, "MSDVip", "Ingresando");
        mProgress.setCancelable(false);
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(MedicoBE result) {
        mProgress.dismiss();
        super.onPostExecute(result);

        try {
            if (mContext.getClass().equals(MainActivity.class)) {
                ((MainActivity) mContext).medicoObtenerOnComplete(result);
            } else if (mContext.getClass().equals(LoginActivity.class)) {
                ((LoginActivity) mContext).medicoObtenerOnComplete(result);
            } else {
                ((CrearUserActivity) mContext).medicoObtenerOnComplete(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
