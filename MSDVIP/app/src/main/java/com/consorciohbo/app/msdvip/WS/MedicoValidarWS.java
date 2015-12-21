package com.consorciohbo.app.msdvip.WS;

import android.app.ProgressDialog;
import android.content.Context;
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
 * Created by Diego on 11/12/15.
 */
public class MedicoValidarWS extends AsyncTask<String, Integer, String> {
    Utility objUtility = new Utility();
    private Context mContext;
    private ProgressDialog mProgress;


    public MedicoValidarWS(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub
        String result = "";
        HttpClient client =  new DefaultHttpClient();

        HttpPost request = new HttpPost("https://mobile.consorciohbo.com.pe/HBOMembership.WebService.Test/MedicoWS.svc/MedicoObtenerPorProgramaIDYCMP");
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
                MedicoBE medico = new MedicoBE();
                medico.setMedicoExternoID(jsonReponse.getString("MedicoExternoID"));
                medico.setNombreCompleto(jsonReponse.getString("NombreCompleto"));
                medico.setTelefono(jsonReponse.getString("Telefono"));
                medico.setEmail(jsonReponse.getString("Email"));
                medico.setCMP(jsonReponse.getString("CMP"));
                medico.setPassword(jsonReponse.getString("Password"));

                if(medico.getPassword() == "null" || medico.getPassword().isEmpty() || medico.getPassword() == null){
                    result = "nopassword";
                }
                else {
                    result = "success";
                }
            }
            catch (Exception ex){
                result = "null";
            }
        }
        catch (Exception e){
            result = "failure";
        }
        return result;
    }

    @Override
    protected void onPreExecute() {
        mProgress = ProgressDialog.show(mContext, "MSDVip", "Validando Médico");
        mProgress.setCancelable(false);
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        mProgress.dismiss();
        super.onPostExecute(result);
    }
}
