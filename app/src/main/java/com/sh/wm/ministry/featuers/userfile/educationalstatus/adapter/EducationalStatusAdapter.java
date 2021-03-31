package com.sh.wm.ministry.featuers.userfile.educationalstatus.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.model.UserEducationalStatus;


import java.util.List;

public class EducationalStatusAdapter extends RecyclerView.Adapter<EducationalStatusAdapter.ViewHolder> {
    private List<UserEducationalStatus> userEducationalStatusList;
    private EducationalStatusAdapter.OnEditClickListener mListener;

    public EducationalStatusAdapter(List<UserEducationalStatus> userEducationalStatusList, OnEditClickListener mListener) {
        this.userEducationalStatusList = userEducationalStatusList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public EducationalStatusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EducationalStatusAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_eduction_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EducationalStatusAdapter.ViewHolder holder, int position) {
        holder.bind(position);
        holder.editIv.setOnClickListener(view -> {

            mListener.onEditClick(userEducationalStatusList.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return userEducationalStatusList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView eduTypeTv;
        private MaterialTextView eduStatusTv;
        private MaterialTextView qulificationTv;
        private MaterialTextView qulificationDetailTv;
        private AppCompatImageButton editIv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eduTypeTv = itemView.findViewById(R.id.tv_education_type_eductionalstatus);
            eduStatusTv = itemView.findViewById(R.id.tv_education_stauts_eductionalstatus);
            qulificationTv = itemView.findViewById(R.id.tv_qulification_eductionalstatus);
            qulificationDetailTv = itemView.findViewById(R.id.tv_qulification_detail_eductionalstatus);
            editIv = itemView.findViewById(R.id.ib_edit);

        }

        public void bind(int position) {
            UserEducationalStatus educationalStatus = userEducationalStatusList.get(position);
            eduTypeTv.setText(educationalStatus.getEDUTYPE());
            eduStatusTv.setText(educationalStatus.getEDUSTATUS());
            qulificationTv.setText(educationalStatus.getQULNAME().replace("\n", " "));
            qulificationDetailTv.setText(educationalStatus.getQULDETAILSNAME());




        }
    }


    public interface OnEditClickListener {
        void onEditClick(UserEducationalStatus userEducationalStatus);
        void onClick(UserEducationalStatus userEducationalStatus);
    }
}

