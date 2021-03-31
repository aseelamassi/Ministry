package com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.owner.ConstructionOwner;


import java.util.List;

public class OwnerAdapter extends RecyclerView.Adapter<OwnerAdapter.ViewHolder>{


    private Context context;
    private List<ConstructionOwner> owners;
    public OwnerAdapter(@NonNull Context context, List<ConstructionOwner> owners) {
        this.context = context;
        this.owners = owners;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.card_view_owner_item, parent, false));    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ConstructionOwner owner = owners.get(position);
        holder.tvOwnerName.append(" "+owner.getOWNERNAME());
        holder.tvOwnerSn.append(" "+owner.getUSERSN());
        holder.tvOwnerStartWorkDate.append(" " +owner.getOWENERSTARTDATE());
    }


    @Override
    public int getItemCount() {
        return owners.size();
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
