package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.CardViewSimilarJobBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.result.SimilarJob;

import java.util.List;

public class SimilarJobAdapter extends RecyclerView.Adapter<SimilarJobAdapter.MyViewHolder> {


    private List<SimilarJob> jobs ;

    public SimilarJobAdapter(List<SimilarJob> jobs) {
        this.jobs = jobs;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_similar_job, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.tvJobName.setText(jobs.get(position).getJOBARNAME());
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardViewSimilarJobBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= CardViewSimilarJobBinding.bind(itemView);
        }
    }
}
