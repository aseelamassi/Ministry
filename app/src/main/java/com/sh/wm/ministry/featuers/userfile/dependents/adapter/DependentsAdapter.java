package com.sh.wm.ministry.featuers.userfile.dependents.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserDependent;
import com.sh.wm.ministry.featuers.userfile.languages.adapter.UserLanguagesAdapter;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguage;

import java.util.List;

public class DependentsAdapter extends RecyclerView.Adapter<DependentsAdapter.ViewHolder> {

    private List<UserDependent> userDependents;
    private OnEditClickListener mListener ;

    public DependentsAdapter(List<UserDependent> userDependents, OnEditClickListener mListener) {
        this.userDependents = userDependents;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.dependents_carview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return userDependents.size();
    }

    public interface OnEditClickListener {
        void onEditClick(UserDependent userLanguage);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView nameTv;
        private MaterialTextView idTv;
        private MaterialTextView relationTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.tv_name_dependents_card);
            idTv = itemView.findViewById(R.id.tv_id_dependents_card);
            relationTv = itemView.findViewById(R.id.tv_relation_dependents_card);

        }

        public void bind(int position) {
            UserDependent userDependent = userDependents.get(position);
            nameTv.setText(userDependent.getUSERDEPFULLNAME());
            idTv.setText(userDependent.getUSERDEPDOCUMENTID());
            relationTv.setText(userDependent.getRELATIONSHIP());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onEditClick(userDependent);
                }
            });
        }
    }

}
