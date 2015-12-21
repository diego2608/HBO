package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.consorciohbo.app.msdvip.BL.BC.MedicoBC;
import com.consorciohbo.app.msdvip.BL.BE.MedicoBE;
import com.consorciohbo.app.msdvip.FL.Encriptador;
import com.consorciohbo.app.msdvip.R;
import com.consorciohbo.app.msdvip.WS.MedicoAutenticarWS;
import com.consorciohbo.app.msdvip.WS.MedicoObtenerWS;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener  {
    private EditText txtLoginCMD;
    private EditText txtPasswordCMD;
    private MedicoBE objMedicoBE;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        txtLoginCMD = (EditText)findViewById(R.id.txtLoginCMD);
        txtPasswordCMD = (EditText)findViewById(R.id.txtPasswordLogin);

        btnLogin = (Button)findViewById(R.id.btnIniciarSecionLogin);
        btnLogin.setOnClickListener(this);

        /*
        //-------------------------------------------------------------------------------------------
        //Defino mi boton Ingresar
        Button btnLogin = (Button) findViewById(R.id.btnIniciarSecionLogin);

        //Asigno el evenyo onclick al botn
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent vistaLogin = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(vistaLogin);
            }
        });*/

    }

    public void autenticarOnComplete(MedicoBE resultado) throws Exception {
        if (resultado != null) {
            MedicoBC.MedicoEliminar();

            if (resultado.getEstadoActivacion().equals("ACTIVO")) {
                MedicoBC.MedicoRegistrar(resultado);


            } else {
                txtLoginCMD.setText("");
                txtPasswordCMD.setText("");

                Intent intentConsultaActivacion = new Intent(this, MainActivity.class);
                startActivity(intentConsultaActivacion);
            }
        } else {
            Toast.makeText(this, "Número CMP y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    public void medicoObtenerOnComplete(MedicoBE resultado) throws Exception  {
        if (resultado != null) {
            Encriptador enc = new Encriptador();

            resultado.setPassword(enc.encrypt(txtPasswordCMD.getText().toString()));
            objMedicoBE = resultado;
            autenticar(resultado);

        } else {
            Toast.makeText(this, "Ingrese un número CMP válido", Toast.LENGTH_SHORT).show();
        }
    }

    public void autenticar(MedicoBE objMedicoBE) throws Exception {
        new MedicoAutenticarWS(this, 1).execute(objMedicoBE);
    }

    public void login(View view) throws Exception {
        new MedicoObtenerWS(this).execute(txtLoginCMD.getText().toString());
    }

    @Override
    public void onClick(View v) {

        if (txtLoginCMD.getText().length() > 0) {

            try {
                login(v);
            } catch (InterruptedException e) {
                Toast.makeText(this, "Ha ocurrido un error. Por favor vuelva a intentar.", Toast.LENGTH_SHORT).show();
            } catch (ExecutionException e) {
                Toast.makeText(this, "Ha ocurrido un error. Por favor vuelva a intentar.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Ha ocurrido un error. Por favor vuelva a intentar.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Ingrese un número CMP", Toast.LENGTH_SHORT).show();
        }

    }

}
