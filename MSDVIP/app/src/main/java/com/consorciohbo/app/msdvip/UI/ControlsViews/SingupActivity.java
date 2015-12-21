package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.consorciohbo.app.msdvip.BL.BE.MedicoBE;
import com.consorciohbo.app.msdvip.R;

public class SingupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        //-------------------------------------------------------------------------------------------
        //Defino mi boton Guardar Formulario
        Button btnSaveFormulario = (Button) findViewById(R.id.btnValidarSignUp);

        //Asigno el evenyo onclick al botn
        btnSaveFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent vistaFormulario = new Intent(SingupActivity.this, CrearUserActivity.class);
                startActivity(vistaFormulario);
            }
        });
    }

    public void medicoObtenerOnComplete(final MedicoBE resultado) throws Exception {
        if (resultado != null) {

            if (resultado.getEstadoActivacion().equals("ACTIVO")) {

                final Intent intent = new Intent(this, CrearUserActivity.class);
                new AlertDialog.Builder(this)
                        .setTitle("Mensaje")
                        .setMessage("Se ha activado el uso del aplicativo. Bienvenido")
                        .setPositiveButton("Iniciar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                intent.putExtra("MedicoExternoID", resultado.getMedicoExternoID());
                                intent.putExtra("NombreCompleto", resultado.getNombreCompleto());
                                intent.putExtra("Telefono", resultado.getTelefono());
                                intent.putExtra("Email", resultado.getEmail());
                                intent.putExtra("CMP", resultado.getCMP());
                                intent.putExtra("Password", resultado.getPassword());
                                startActivity(intent);
                            }
                        })
                        .show();

            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Mensaje")
                        .setMessage("Su cuenta aun no ha sido activada")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }

        } else {
            Toast.makeText(this, "Hubo un inconveniente. Por favor vuelva a intentar", Toast.LENGTH_SHORT).show();
        }
    }
}
