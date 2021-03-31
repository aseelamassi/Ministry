package com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;

import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.ConstructLicenceInfo.ConstructLicenceInfo;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.registerSideInfo.ConstructRegisterInfo;

import java.util.List;

public class ConstructRegisterSideAdapter extends RecyclerView.Adapter<ConstructRegisterSideAdapter.ViewHolder> {

    private Context context;
    private List<ConstructRegisterInfo> registerInfoList;
    private List<ConstructLicenceInfo> licenceInfoList;
    private String type;


    public ConstructRegisterSideAdapter(Context context, List<ConstructRegisterInfo> registerInfoList, List<ConstructLicenceInfo> licenceInfoList, String type) {
        this.context = context;
        this.registerInfoList = registerInfoList;
        this.licenceInfoList = licenceInfoList;
        this.type = type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.card_view_owner_item, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvOwnerStartWorkDate.setVisibility(View.GONE);
        if (type.equals("register")){
            ConstructRegisterInfo registerInfo = registerInfoList.get(position);
            holder.tvName.setText(context.getString(R.string.registration_side) + " " + registerInfo.getCONSTRUCTREGNAME());
            holder.tvNumber.setText(context.getString(R.string.registration_number) + " " + registerInfo.getCONSTRUCTREGNUM());

        }else {

            Log.d("aseel" , "hi");
            ConstructLicenceInfo constructLicenceInfo = licenceInfoList.get(position);
            holder.tvName.setText(context.getString(R.string.licensed_side) + " " + constructLicenceInfo.getCONSTRUCTLICENAME());
            holder.tvNumber.setText(context.getString(R.string.licensed_number) + " " + constructLicenceInfo.getCONSTRUCTLICENCENUM());
        }

    }

    @Override
    public int getItemCount() {
        if (type.equals("register"))
            return registerInfoList.size();
        else
            return licenceInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvNumber, tvOwnerStartWorkDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_owner_name);
            tvNumber = itemView.findViewById(R.id.tv_owner_sn);
            tvOwnerStartWorkDate = itemView.findViewById(R.id.tv_owner_start_work);
        }
    }
}
