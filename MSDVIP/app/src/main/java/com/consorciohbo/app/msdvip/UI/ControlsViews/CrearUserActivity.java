package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.consorciohbo.app.msdvip.BL.BE.MedicoBE;
import com.consorciohbo.app.msdvip.R;

public class CrearUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_user);
    }

    public void medicoRegistrarOnComplete(MedicoBE objMedicoBE, String resultado) throws Exception {
        if (resultado.equals("true")) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("CMP", objMedicoBE.getCMP());
            startActivity(intent);
        } else {
            Toast.makeText(this, "Ha ocurrido un inconveniente. Por favor vuelva a intentarlo", Toast.LENGTH_SHORT).show();
        }
    }

    public void medicoObtenerOnComplete(MedicoBE resultado) throws Exception  {
        if (resultado != null) {

            if (resultado.getPassword() == "null") {
                Intent intent = new Intent(this, CrearUserActivity.class);
                intent.putExtra("MedicoExternoID", resultado.getMedicoExternoID());
                intent.putExtra("CMP", resultado.getCMP());
                intent.putExtra("NombreCompleto", resultado.getNombreCompleto());
                startActivity(intent);
            } else {
                Toast.makeText(this, "Este médico ya cuenta con un usuario registrado", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Ingrese un número CMP válido", Toast.LENGTH_SHORT).show();
        }
    }

}
