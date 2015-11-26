package com.consorciohbo.app.msdvip.UI.RecycleViewControllers;

import com.consorciohbo.app.msdvip.BL.BE.Place;

import java.util.ArrayList;

/**
 * Created by Diego on 25/11/15.
 */
public class PlaceData {

    public static String[] placeNameArray = {" Mi Consultor", "Marketing", "Gerente General", "Eventos Adversos"};

    public static ArrayList<Place> placeList() {
        ArrayList<Place> list = new ArrayList<>();
        for (int i = 0; i < placeNameArray.length; i++) {
            Place place = new Place();
            place.name = placeNameArray[i];
            place.imageName = placeNameArray[i].replaceAll("\\s+", "").toLowerCase();
            if (i == 2 || i == 5) {
                place.isFav = true;
            }
            list.add(place);
        }
        return (list);
    }

    public static Place getItem(String _id) {
        for (Place place : placeList()) {
            if (place.id.equals(_id)) {
                return place;
            }
        }
        return null;
    }
}
