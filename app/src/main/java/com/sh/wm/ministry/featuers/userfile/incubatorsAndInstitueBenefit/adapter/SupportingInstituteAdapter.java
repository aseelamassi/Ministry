package com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.model.SupportingInstitute;
import com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.model.SupportingInstituteModel;


import java.util.List;

public class SupportingInstituteAdapter extends RecyclerView.Adapter<SupportingInstituteAdapter.MyViewHolder> {
    Context context;
    List<SupportingInstitute> mData;

    public SupportingInstituteAdapter(Context context, List<SupportingInstitute> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_supporting_institute_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvInstituteName.setText(mData.get(position).getSUPPORTINGINSTITUATIONNAME());
        holder.tvProjectName.setText(mData.get(position).getBENEFICIARYPROJECTTITLE());
        holder.tvProjectStartDate.setText(mData.get(position).getBENEFICIARYPROJECTSTARTDATE());
        holder.tvActiveSector.setText(mData.get(position).getBENEFICIARYPROJECTLABORSECTORID());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvInstituteName;
        TextView tvProjectName;
        TextView tvProjectStartDate ;
        TextView tvActiveSector;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvInstituteName = itemView.findViewById(R.id.tv_institution_name);
            tvProjectName = itemView.findViewById(R.id.tv_project_name);
            tvProjectStartDate = itemView.findViewById(R.id.tv_project_start_date);
            tvActiveSector = itemView.findViewById(R.id.tv_active_sector);

        }
    }
}
