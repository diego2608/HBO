package com.consorciohbo.app.msdvip.WS;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

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
public class MedicoRecuperarCredencialesWS extends AsyncTask<String, Integer, String> {
    Utility objUtility = new Utility();

    private Context mContext;
    private ProgressDialog mProgress;

    public MedicoRecuperarCredencialesWS(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected String doInBackground(String... params) {
        String result = "";
        HttpClient client = new DefaultHttpClient();

        HttpPost request = new HttpPost("https://mobile.consorciohbo.com.pe/HBOMembership.WebService/MedicoWS.svc/MedicoRecuperarCredenciales");
        request.setHeader("content-type", "application/json");

        try {
            JSONObject data = new JSONObject();

            data.put("MedicoExternoID", params[0]);
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

    @Override
    protected void onPreExecute() {
        mProgress = ProgressDialog.show(mContext, "MSDVip", "Recuperando Credenciales");
        mProgress.setCancelable(false);
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        mProgress.dismiss();
        super.onPostExecute(result);
    }
}
