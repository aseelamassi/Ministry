package com.sh.wm.ministry.featuers.userfile.socialAid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.socialAid.model.SocialAid;


import java.util.List;

public class SocialAidAdapter extends RecyclerView.Adapter<SocialAidAdapter.MyViewHolder> {
    Context context;
    List<SocialAid> mData;

    public SocialAidAdapter(Context context, List<SocialAid> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_social_aid_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.tvSocialType.setText(mData.get(position).getUSERSOCIALAIDAIDTYPEID());
            holder.tvPensionValue.setText(mData.get(position).getUSERSOCIALAIDPENSIONVALUE());
            holder.tvAccountNo.setText(mData.get(position).getUSERSOCIALAIDACCOUNTNUM());
            holder.tvProtectionEntity.setText(mData.get(position).getUSERAIDPROTECTIONENTITY());

            holder.tvBankAddress.setText(mData.get(position).getUSERSOCIALAIDBANKADDRESS());
            holder.tvBankName.setText(mData.get(position).getUSERSOCIALAIDBANKNAME());

            holder.tvBankBranch.setText(mData.get(position).getUSERSOCIALAIDBANKBRANCH());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvSocialType;
        TextView tvBankName;
        TextView tvBankAddress;
        TextView tvBankBranch;
        TextView tvAccountNo;
        TextView tvPensionValue;
        TextView tvProtectionEntity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSocialType = itemView.findViewById(R.id.tv_social_type);
            tvBankName = itemView.findViewById(R.id.tv_bank_name);
            tvBankAddress = itemView.findViewById(R.id.tv_bank_address);
            tvBankBranch = itemView.findViewById(R.id.tv_bank_branch);
            tvAccountNo = itemView.findViewById(R.id.tv_account_no);
            tvPensionValue = itemView.findViewById(R.id.tv_pension_value);
            tvProtectionEntity = itemView.findViewById(R.id.tv_protection_entity);

        }
    }


}
