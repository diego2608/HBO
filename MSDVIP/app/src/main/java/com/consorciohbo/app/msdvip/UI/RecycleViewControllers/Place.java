package com.consorciohbo.app.msdvip.UI.RecycleViewControllers;

import android.content.Context;

/**
 * Created by Diego on 25/11/15.
 */
public class Place {
    public String id;
    public String name;
    public String imageName;
    public boolean isFav;

    public int getImageResourceId(Context context) {
        return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
    }
}
