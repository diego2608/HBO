package com.consorciohbo.app.msdvip.UI.RecycleViewControllers;

import com.consorciohbo.app.msdvip.BL.BE.CardBE;

import java.util.ArrayList;

/**
 * Created by Diego on 25/11/15.
 */
public class ComunicacionData {

    public static String[] placeNameArray = {" Mi Consultor", "Marketing", "Gerente General", "Eventos Adversos"};

    public static ArrayList<CardBE> placeList() {
        ArrayList<CardBE> list = new ArrayList<>();
        for (int i = 0; i < placeNameArray.length; i++) {
            CardBE cardBE = new CardBE();
            cardBE.name = placeNameArray[i];
            cardBE.imageName = placeNameArray[i].replaceAll("\\s+", "").toLowerCase();
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
