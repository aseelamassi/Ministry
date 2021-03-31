package com.sh.wm.ministry.featuers.userfile.workProgramBenefit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.workProgramBenefit.model.TempWork;

import java.util.List;

public class TempWorkAdapter extends RecyclerView.Adapter<TempWorkAdapter.MyViewHolder> {
    Context context;
    List<TempWork> mData;

    public TempWorkAdapter(Context context, List<TempWork> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_temp_work_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvProgramName.setText(mData.get(position).getPROJECTNAME());
        holder.tvFundingAgency.setText(mData.get(position).getPROJECTFINANCEAUTHORITYNAME());
        holder.tvEmployer.setText(mData.get(position).getCONSTRUCTNAMEUSING());


        if (mData.get(position).getCONTRACTSTARTDATE() != null)
            holder.tvWorkBeggingDate.setText(mData.get(position).getCONTRACTSTARTDATE());
        if (mData.get(position).getCONTRACTENDDATE() != null)
            holder.tvWorkEndingDate.setText(mData.get(position).getCONTRACTENDDATE());
        if (mData.get(position).getPROJECTIMPLEMENTATIONENTITY() != null)
            holder.tvImplementingAgency.setText(mData.get(position).getPROJECTIMPLEMENTATIONENTITY());
        if (mData.get(position).getJOBARNAME() != null)
            holder.tvOccupation.setText(mData.get(position).getJOBARNAME());
        if (mData.get(position).getCONTRACTCURRENCYNAME() != null)
            holder.tvPayType.setText(mData.get(position).getCONTRACTCURRENCYNAME());
        if (mData.get(position).getCONTRACTMONTHSALARY() != null)
            holder.tvWage.setText(mData.get(position).getCONTRACTMONTHSALARY());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvProgramName;
        TextView tvFundingAgency;
        TextView tvWorkBeggingDate;
        TextView tvWorkEndingDate;
        TextView tvEmployer;
        TextView tvImplementingAgency;
        TextView tvOccupation;
        TextView tvPayType;
        TextView tvWage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProgramName = itemView.findViewById(R.id.tv_program_name);
            tvFundingAgency = itemView.findViewById(R.id.tv_funding_agency);
            tvWorkBeggingDate = itemView.findViewById(R.id.tv_work_beginning_date);
            tvWorkEndingDate = itemView.findViewById(R.id.tv_work_ending_date);
            tvEmployer = itemView.findViewById(R.id.tv_employer);
            tvImplementingAgency = itemView.findViewById(R.id.tv_implementing_agency);
            tvOccupation = itemView.findViewById(R.id.tv_occupation);
            tvPayType = itemView.findViewById(R.id.tv_pay_type);
            tvWage = itemView.findViewById(R.id.tv_wage);

        }
    }
}

