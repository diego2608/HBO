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
 * Created by Diego on 25/01/16.
 */

public class TravelListAdapterServicios extends RecyclerView.Adapter<TravelListAdapterServicios.ViewHolder> {
    Context mContext;

    // 2
    public TravelListAdapterServicios(Context context) {
        this.mContext = context;
    }

    // 3
    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mainHolderService;
        public LinearLayout placeNameHolderService;
        public TextView placeNameService;
        public ImageView placeImageService;

        public ViewHolder(View itemView) {
            super(itemView);
            mainHolderService = (LinearLayout) itemView.findViewById(R.id.mainHolderService);
            placeNameService = (TextView) itemView.findViewById(R.id.placeNameService);
            placeNameHolderService = (LinearLayout) itemView.findViewById(R.id.placeNameHolderService);
            placeImageService = (ImageView) itemView.findViewById(R.id.placeImageService);
        }
    }

    @Override
    public int getItemCount() {
        return new ServiciosData().placeList().size();
    }

    // 2
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_cards_servicios, parent, false);
        return new ViewHolder(view);
    }

    // 3
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final CardBE cardBE = new ServiciosData().placeList().get(position);
        holder.placeNameService.setText(cardBE.name);
        Picasso.with(mContext).load(cardBE.getImageResourceId(mContext)).into(holder.placeImageService);
    }

}
