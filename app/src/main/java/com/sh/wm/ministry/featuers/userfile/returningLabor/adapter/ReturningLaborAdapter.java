package com.sh.wm.ministry.featuers.userfile.returningLabor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.returningLabor.model.ReturningLabor;
import com.sh.wm.ministry.featuers.userfile.returningLabor.view.ReturningLaborFragment;

import java.util.List;

public class ReturningLaborAdapter extends RecyclerView.Adapter<ReturningLaborAdapter.MyViewHolder> {

    private List<ReturningLabor> mData;
    private OnEditClickListener mListener;
    private Context mContext ;

    public ReturningLaborAdapter(Context mContext , List<ReturningLabor> mData, OnEditClickListener mListener) {
        this.mData = mData;
        this.mListener = mListener;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_returning_labor_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvLastJob;
        private TextView tvStartWorkDate;
        private TextView tvEndWorkDate;
        private TextView tvSkillLevel;
        private TextView tvReturnedCountry;
        private AppCompatImageButton editIv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLastJob = itemView.findViewById(R.id.tv_last_job);
            tvStartWorkDate = itemView.findViewById(R.id.tv_start_work_date);
            tvEndWorkDate = itemView.findViewById(R.id.tv_end_work_date);
            tvSkillLevel = itemView.findViewById(R.id.tv_skill_level);
            tvReturnedCountry = itemView.findViewById(R.id.tv_returned_country);
            editIv = itemView.findViewById(R.id.ib_edit_returning_labor);

        }

        public void bind(int position) {
            ReturningLabor returningLabor = mData.get(position);
            tvLastJob.setText(returningLabor.getLASTJOB());
            tvEndWorkDate.setText(returningLabor.getUSERRELABORENDDATE());
            tvStartWorkDate.setText(returningLabor.getUSERRELABORSTARTDATE());
            mListener.getConstantName(returningLabor.getUSERRELABORSKILLLEVEL() , "142" , tvSkillLevel);
            tvSkillLevel.setText(returningLabor.getUSERRELABORSTARTDATE());
            tvReturnedCountry.setText(returningLabor.getCOUNTRYNAME());

            editIv.setOnClickListener(view -> {
                mListener.onEditClick(returningLabor);
            });

            itemView.setOnClickListener(view -> {
                mListener.onClick(returningLabor);
            });
        }
    }

    public interface OnEditClickListener {
        void onEditClick(ReturningLabor returningLabor);
        void onClick(ReturningLabor returningLabor);
        void getConstantName(String constantId,String parentId, TextView tvChange);
    }




}

