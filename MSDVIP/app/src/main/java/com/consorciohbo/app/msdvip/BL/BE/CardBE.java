package com.consorciohbo.app.msdvip.BL.BE;

import android.content.Context;

/**
 * Created by Diego on 25/11/15.
 */
public class CardBE {
    public String id;
    public String name;
    public String imageName;
    public boolean isFav;

    public int getImageResourceId(Context context) {
        return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
    }
}
