package com.sh.wm.ministry.featuers.userfile.userRealty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.userRealty.model.UserRealty;


import java.util.List;

public class RealtyAdapter extends RecyclerView.Adapter<RealtyAdapter.MyViewHolder> {
    Context context;
    List<UserRealty> mData;

    public RealtyAdapter(Context context, List<UserRealty> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_user_realty, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserRealty userRealty = mData.get(position);
        holder.tvCustomNumber.setText(userRealty.getUSERREALITYNO());
        holder.tvRealtyName.setText(userRealty.getUSERREALTYREALTYNAME());
        holder.tvAvgShareCapital.setText(userRealty.getUSERREALTYCAPITALVALUE());
        holder.tvRealtyType.setText(userRealty.getREALTYTYPE());
        holder.tvRealtyAddress.setText(userRealty.getUSERREALTYREALTYADDRESS());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvCustomNumber;
        TextView tvRealtyType;
        TextView tvRealtyName ;
        TextView tvRealtyAddress;
        TextView tvAvgShareCapital;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCustomNumber = itemView.findViewById(R.id.tv_custom_number);
            tvRealtyType = itemView.findViewById(R.id.tv_realty_type);
            tvRealtyName = itemView.findViewById(R.id.tv_realty_name);
            tvRealtyAddress = itemView.findViewById(R.id.tv_realty_address);
            tvAvgShareCapital = itemView.findViewById(R.id.tv_avg_share_capital);

        }
    }
}
