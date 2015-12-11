package com.consorciohbo.app.msdvip.UI.RecycleViewControllers;

import com.consorciohbo.app.msdvip.BL.BE.CardBE;

import java.util.ArrayList;

/**
 * Created by Diego on 11/12/15.
 */
public class ServiciosData {
    public static String[] serviciosNameArray = {" Información Científica", "Sitios web", "Aplicaciones de salud", "Materiales Médicos","Nuestros Eventos"};

    public static ArrayList<CardBE> placeList() {
        ArrayList<CardBE> list = new ArrayList<>();
        for (int i = 0; i < serviciosNameArray.length; i++) {
            CardBE cardBE = new CardBE();
            cardBE.name = serviciosNameArray[i];
            cardBE.imageName = serviciosNameArray[i].replaceAll("\\s+", "").toLowerCase();
            if (i == 2 || i == 5) {
                cardBE.isFav = true;
            }
            list.add(cardBE);
        }
        return (list);
    }

    public static CardBE getItem(String _id) {
        for (CardBE cardBE : placeList()) {
            if (cardBE.id.equals(_id)) {
                return cardBE;
            }
        }
        return null;
    }
}
