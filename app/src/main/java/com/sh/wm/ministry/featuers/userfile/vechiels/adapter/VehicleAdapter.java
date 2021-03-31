package com.sh.wm.ministry.featuers.userfile.vechiels.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.travel.adapter.TravelAdapter;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelData;
import com.sh.wm.ministry.featuers.userfile.vechiels.model.UserVehicle;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.MyViewHolder> {
    Context context;
    List<UserVehicle> mData;

    public VehicleAdapter(Context context, List<UserVehicle> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_vehicle_item, parent, false);
        return new VehicleAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvVehicleNumber.setText(mData.get(position).getUSERVEHICLEVEHICLENUMBER());
        holder.tvVehicleType.setText(mData.get(position).getUSERVEHICLEVEHICLETYPE());
        holder.tvVehicleCom.setText(mData.get(position).getUSERVEHICLEMANUFACTURECOMP());
        holder.tvVehicleYear.setText(mData.get(position).getUSERVEHICLEPRODUCTIONYEAR());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvVehicleNumber;
        TextView tvVehicleType;
        TextView tvVehicleCom;
        TextView tvVehicleYear;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvVehicleType = itemView.findViewById(R.id.tv_vehicle_type);
            tvVehicleNumber = itemView.findViewById(R.id.tv_vehicle_number);
            tvVehicleCom = itemView.findViewById(R.id.tv_vehicle_com);
            tvVehicleYear = itemView.findViewById(R.id.tv_vehicle_year);


        }
    }
}
