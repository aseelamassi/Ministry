package com.sh.wm.ministry.featuers.userfile.partner.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.partner.model.Partner;
import com.sh.wm.ministry.featuers.userfile.partner.model.UserPartner;


import java.util.List;

public class PartnerAdapter extends RecyclerView.Adapter<PartnerAdapter.MyViewHolder>  {

    Context context;
    List<UserPartner> mData;

    public PartnerAdapter(Context context, List<UserPartner> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_partner_item, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForColorStateLists")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserPartner partner = mData.get(position);
        holder.tvPartnerName.setText(partner.getPartner().getWORKERNAME());
        holder.partnerId.setText(partner.getPartner().getUSERSN());
        holder.tvStatus.setText(partner.getPartner().getUSERREGSTATUS());


         setUpData(holder,partner);

        holder.btnPracticalStatus.setOnClickListener(view -> {
            holder.btnPracticalStatus.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimary));
            holder.btnPracticalStatus.setTextColor(context.getResources().getColor(R.color.white));

            holder.btnEducationalStatus.setBackgroundTintList(context.getResources().getColorStateList(R.color.white));
            holder.btnEducationalStatus.setTextColor(context.getResources().getColor(R.color.black));

            setUpData(holder , partner);
           holder.tableRow6.setVisibility(View.GONE);
        });


        holder.btnEducationalStatus.setOnClickListener(view -> {
            holder.btnEducationalStatus.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimary));
            holder.btnEducationalStatus.setTextColor(context.getResources().getColor(R.color.white));

            holder.btnPracticalStatus.setBackgroundTintList(context.getResources().getColorStateList(R.color.white));
            holder.btnPracticalStatus.setTextColor(context.getResources().getColor(R.color.black));

            holder.tableRow6.setVisibility(View.VISIBLE);

            holder.row1Name.setText(context.getString(R.string.scientific_qualification));
            if (partner.getPartnerEduStatus().get(0).getQULNAME() != null)
                holder.row1Value.setText(partner.getPartnerEduStatus().get(0).getQULNAME().trim());
            else
                holder.row1Value.setText(partner.getPartnerEduStatus().get(0).getQULNAME());

            holder.row2Name.setText(context.getString(R.string.specialization));
            holder.row2Value.setText(partner.getPartnerEduStatus().get(0).getSPECILIZATIONNAME());

            holder.row3Name.setText(context.getString(R.string.graduation_year));
            holder.row3Value.setText(partner.getPartnerEduStatus().get(0).getUSEREDUGRADUATIONYEAR());

            holder.row4Name.setText(context.getString(R.string.graduation_country));
            //holder.row4Value.setText(partner.getPartnerEduStatus().get(0).getSPECILIZATIONNAME());

            holder.row5Name.setText(context.getString(R.string.avg));
            holder.row5Value.setText(partner.getPartnerEduStatus().get(0).getUSEREDUAVERAGE());

            holder.row6Name.setText(context.getString(R.string.rating));
          //  holder.row6Value.setText(partner.getPartnerEduStatus().get(0).getSPECILIZATIONNAME());


        });


    }

    private void setUpData(MyViewHolder holder , UserPartner partner){
        holder.row1Name.setText(context.getString(R.string.practical_status));
        holder.row1Value.setText(partner.getPartnerWorkStatus().get(0).getWORKSTATUS());
        holder.row2Name.setText(context.getString(R.string.describe_practical_status));
        holder.row2Value.setText(partner.getPartnerWorkStatus().get(0).getWORKSTATUSDESC());
        holder.row3Name.setText(context.getString(R.string.describe_describe_practical_status));
        holder.row3Value.setText(partner.getPartnerWorkStatus().get(0).getWORKSTATUSDESCDESC());
        holder.row4Name.setText(context.getString(R.string.date_beginning_work));
        holder.row4Value.setText(partner.getPartnerWorkStatus().get(0).getUSERWORKSTARTDATE());
        holder.row5Name.setText(context.getString(R.string.date_ending_work));
        holder.row5Value.setText(partner.getPartnerWorkStatus().get(0).getUSERWORKENDDATE());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvPartnerName;
        TextView partnerId;
        TextView tvStatus;
        Button btnPracticalStatus, btnEducationalStatus ;

        TextView row1Name , row2Name,row3Name,row4Name,row5Name,row6Name;
        TextView row1Value , row2Value,row3Value,row4Value,row5Value,row6Value;
        TableRow tableRow6 ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPartnerName = itemView.findViewById(R.id.tv_partner_name);
            partnerId = itemView.findViewById(R.id.tv_partner_id);
            tvStatus = itemView.findViewById(R.id.tv_status);
            btnPracticalStatus = itemView.findViewById(R.id.btn_practical_status);
            btnEducationalStatus = itemView.findViewById(R.id.btn_educational_status);
            tableRow6 = itemView.findViewById(R.id.tableRow6);
            row1Name = itemView.findViewById(R.id.row1_name);
            row2Name = itemView.findViewById(R.id.row2_name);
            row3Name = itemView.findViewById(R.id.row3_name);
            row4Name = itemView.findViewById(R.id.row4_name);
            row5Name = itemView.findViewById(R.id.row5_name);
            row6Name = itemView.findViewById(R.id.row6_name);

            row1Value = itemView.findViewById(R.id.row1_value);
            row2Value = itemView.findViewById(R.id.row2_value);
            row3Value = itemView.findViewById(R.id.row3_value);
            row4Value = itemView.findViewById(R.id.row4_value);
            row5Value = itemView.findViewById(R.id.row5_value);
            row6Value = itemView.findViewById(R.id.row6_value);


        }
    }




}
