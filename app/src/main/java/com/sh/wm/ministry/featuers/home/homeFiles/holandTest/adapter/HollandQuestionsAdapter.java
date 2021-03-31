package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.CardViewHollandActivityBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.ActivityModel;

import java.util.HashMap;


public class HollandQuestionsAdapter extends RecyclerView.Adapter<HollandQuestionsAdapter.MyViewHolder> {


    private Context context;
    private ActivityModel activityModel ;
    HashMap<String , String > questions ;

    public HollandQuestionsAdapter(Context context, ActivityModel activityModel) {
        questions = new HashMap<>();
        this.context = context;
        this.activityModel = activityModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_holland_activity, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        switch (position){
            case 0:
                holder.binding.tvTitle.setText(R.string.realistic);
                holder.binding.rvQuestions.setLayoutManager(new LinearLayoutManager(context));
                holder.binding.rvQuestions.setAdapter(new ActivityAdapter(context, activityModel.getActivity1()));
                break;

            case 1:
                holder.binding.tvTitle.setText(R.string.investigative);
                holder.binding.rvQuestions.setLayoutManager(new LinearLayoutManager(context));
                holder.binding.rvQuestions.setAdapter(new ActivityAdapter(context, activityModel.getActivity2()));
                break;
            case 2:
                holder.binding.tvTitle.setText(R.string.artistic);
                holder.binding.rvQuestions.setLayoutManager(new LinearLayoutManager(context));
                holder.binding.rvQuestions.setAdapter(new ActivityAdapter(context, activityModel.getActivity3()));
                break;
            case 3:
                holder.binding.tvTitle.setText(R.string.social);
                holder.binding.rvQuestions.setLayoutManager(new LinearLayoutManager(context));
                holder.binding.rvQuestions.setAdapter(new ActivityAdapter(context, activityModel.getActivity4()));
                break;
            case 4:
                holder.binding.tvTitle.setText(R.string.enterprising);
                holder.binding.rvQuestions.setLayoutManager(new LinearLayoutManager(context));
                holder.binding.rvQuestions.setAdapter(new ActivityAdapter(context, activityModel.getActivity5()));
                break;
            case 5:
                holder.binding.tvTitle.setText(R.string.conventional);
                holder.binding.rvQuestions.setLayoutManager(new LinearLayoutManager(context));
                holder.binding.rvQuestions.setAdapter(new ActivityAdapter(context, activityModel.getActivity6()));
                break;
        }

    }


    @Override
    public int getItemCount() {
        return 6;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardViewHollandActivityBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= CardViewHollandActivityBinding.bind(itemView);
        }
    }


    public ActivityModel getActivityModel() {
        return activityModel;
    }
}
