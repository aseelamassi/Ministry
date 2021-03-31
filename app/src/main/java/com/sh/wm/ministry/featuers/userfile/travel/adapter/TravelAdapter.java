package com.sh.wm.ministry.featuers.userfile.travel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelData;

import java.util.List;

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.MyViewHolder> {
    Context context;
    List<UserTravelData> mData;

    public TravelAdapter(Context context, List<UserTravelData> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_travel_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvLocation.setText(mData.get(position).getCONSTANTARANAME());
        holder.tvTravelDate.setText(mData.get(position).getUSERTRAVELDATE());
        holder.tvTravelReason.setText(mData.get(position).getUSERTRAVELREASON());
        holder.tvWhereToTravel.setText(mData.get(position).getCOUNTRYARNAME());
        holder.tvPassportNo.setText(mData.get(position).getUSERPASSPORTNO());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvLocation;
        TextView tvWhereToTravel;
        TextView tvTravelDate;
        TextView tvTravelReason;
        TextView tvPassportNo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvLocation = itemView.findViewById(R.id.tv_location);
            tvWhereToTravel = itemView.findViewById(R.id.tv_where_to_travel);
            tvTravelDate = itemView.findViewById(R.id.tv_travel_date);
            tvTravelReason = itemView.findViewById(R.id.tv_travel_reason);
            tvPassportNo = itemView.findViewById(R.id.tv_passport_no);

        }
    }
}
