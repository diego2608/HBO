package com.consorciohbo.app.msdvip.UI.Controls;

import android.support.v4.app.FragmentActivity;

import com.consorciohbo.app.msdvip.R;

import org.eazegraph.lib.charts.StackedBarChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.StackedBarModel;

/**
 * Created by Diego on 17/12/15.
 */
public class EazeGraphController extends FragmentActivity {

    StackedBarChart mStackedBarChart = (StackedBarChart) findViewById(R.id.stackedbarchart);

    private void LoadData() {
        StackedBarModel barrr = new StackedBarModel("Enero");
        barrr.addBar(new BarModel(5, 0xe15258));
        barrr.addBar(new BarModel(5, 0xFFFF00));
        barrr.addBar(new BarModel(5, 0x00FF00));

        /*
         for (lstSeguimiento: objseguimiento) {

        barr = new StackedBarModel(objseguimiento.Mes);
        barrr.addBar(new BarModel(objseguimiento.CantAfiliados, 0x00FF00));//verde
        barrr.addBar(new BarModel(objseguimiento.CantNoAfiliados, 0xFF0000));//rojo
        barrr.addBar(new BarModel(objseguimiento.CantPendientes, 0xFFFF00));//amarillo

        mStackedBarChart.addBar(barrr);
        }
        */

    }


}
