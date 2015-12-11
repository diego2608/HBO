package com.consorciohbo.app.msdvip.FL;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Diego on 11/12/15.
 */
public class GIFView extends View {
    private Movie movie;
    private InputStream is;
    private long moviestart;
    public GIFView(Context context) throws IOException {
        super(context);
        //is = getResources().openRawResource(R.drawable.preloader);
        movie = Movie.decodeStream(is);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long now=android.os.SystemClock.uptimeMillis();

        if (moviestart == 0)
            moviestart = now;

        int relTime;
        relTime = (int)((now - moviestart) % movie.duration());
        movie.setTime(relTime);
        movie.draw(canvas,0,0);
        this.invalidate();
    }
}
