package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.CardViewDreamJobItemBinding;

import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.JobList;


import java.util.List;

public class DreamJobsAdapter extends RecyclerView.Adapter<DreamJobsAdapter.MyViewHolder>{

    private Context context;
    private List<JobList> jobs;

    private OnDeleteClickListener mListener ;


    public DreamJobsAdapter(Context context, List<JobList> jobs, OnDeleteClickListener mListener) {
        this.context = context;
        this.jobs = jobs;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_dream_job_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        JobList jobList  = jobs.get(position);
        holder.binding.tvJobName.setText(jobList.getJOBARNAME());
        holder.binding.ivDelete.setOnClickListener(view -> mListener.onDeleteClick(jobList));

    }


    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(JobList jobList);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardViewDreamJobItemBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= CardViewDreamJobItemBinding.bind(itemView);
        }
    }
}
