package com.consorciohbo.app.msdvip.UI.RecycleViewControllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.consorciohbo.app.msdvip.BL.BE.CardBE;
import com.consorciohbo.app.msdvip.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Diego on 25/11/15.
 */
public class TravelListAdapter extends RecyclerView.Adapter<TravelListAdapter.ViewHolder> {

    Context mContext;

    // 2
    public TravelListAdapter(Context context) {
        this.mContext = context;
    }

    // 3
    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout placeHolder;
        public LinearLayout placeNameHolder;
        public TextView placeName;
        public ImageView placeImage;

        public ViewHolder(View itemView) {
            super(itemView);
            placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
            placeName = (TextView) itemView.findViewById(R.id.placeName);
            placeNameHolder = (LinearLayout) itemView.findViewById(R.id.placeNameHolder);
            placeImage = (ImageView) itemView.findViewById(R.id.placeImage);
        }
    }

    @Override
    public int getItemCount() {
        return new ComunicacionData().placeList().size();
    }

    // 2
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_cards, parent, false);
        return new ViewHolder(view);
    }

    // 3
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final CardBE cardBE = new ComunicacionData().placeList().get(position);
        holder.placeName.setText(cardBE.name);
        Picasso.with(mContext).load(cardBE.getImageResourceId(mContext)).into(holder.placeImage);
    }

}
