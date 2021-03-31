package com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.legalEntity.secondaryActivity.SecondActivity;

import java.util.List;

public class SecondaryActivityAdapter extends
        RecyclerView.Adapter<SecondaryActivityAdapter.ViewHolder> {


    private Context context;
    private List<SecondActivity> secondActivities;

    public SecondaryActivityAdapter(@NonNull Context context, List<SecondActivity> secondActivities) {
        this.context = context;
        this.secondActivities = secondActivities;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.card_view_owner_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SecondActivity secondActivity = secondActivities.get(position);
        holder.tvOwnerName.setText(context.getString(R.string.secondary_active_name) + " " + secondActivity.getECONOMICDESC());
        holder.tvOwnerSn.setText(context.getString(R.string.secondary_active_code) +" " + secondActivity.getNO());
         holder.tvOwnerStartWorkDate.setVisibility(View.GONE);
    }


    @Override
    public int getItemCount() {
        return secondActivities.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvOwnerName, tvOwnerSn, tvOwnerStartWorkDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOwnerName = itemView.findViewById(R.id.tv_owner_name);
            tvOwnerSn = itemView.findViewById(R.id.tv_owner_sn);
            tvOwnerStartWorkDate = itemView.findViewById(R.id.tv_owner_start_work);
        }

    }
}
