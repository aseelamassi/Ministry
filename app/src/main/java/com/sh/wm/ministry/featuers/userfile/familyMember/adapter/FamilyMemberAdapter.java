package com.sh.wm.ministry.featuers.userfile.familyMember.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.familyMember.model.UserFamily;

import java.util.List;

public class FamilyMemberAdapter extends RecyclerView.Adapter<FamilyMemberAdapter.MyViewHolder> {
    Context context;
    List<UserFamily> mData;

    public FamilyMemberAdapter(Context context, List<UserFamily> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_family_member_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(mData.get(position).getRELATIVENAME());
        holder.tvId.setText(mData.get(position).getRELATIVESN());
        holder.tvAge.setText(mData.get(position).getRELATIVEAGE());
        holder.tvRelationship.setText(mData.get(position).getRELATIONDESC());
        holder.tvSocialStatus.setText(mData.get(position).getSOCIALSTATUS());
        holder.tvPracticalStatus.setText(mData.get(position).getRELATIVESTATUSNAME());
        holder.tvDesPracticalStatus.setText(mData.get(position).getRELATIVESTATUSDESCNAME());
        holder.tvDesDesPracticalStatus.setText(mData.get(position).getRELATIVESTATUSDESCDESCNAME());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvAge;
        TextView tvId;
        TextView tvRelationship;
        TextView tvSocialStatus;
        TextView tvPracticalStatus;
        TextView tvDesPracticalStatus;
        TextView tvDesDesPracticalStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvAge = itemView.findViewById(R.id.tv_age);
            tvId = itemView.findViewById(R.id.tv_id);
            tvRelationship = itemView.findViewById(R.id.tv_relation_ship);
            tvSocialStatus = itemView.findViewById(R.id.tv_social_status);
            tvPracticalStatus = itemView.findViewById(R.id.tv_practical_status);
            tvDesPracticalStatus = itemView.findViewById(R.id.tv_describe_practical_status);
            tvDesDesPracticalStatus = itemView.findViewById(R.id.tv_describe_describe_practical_status);

        }
    }
}
