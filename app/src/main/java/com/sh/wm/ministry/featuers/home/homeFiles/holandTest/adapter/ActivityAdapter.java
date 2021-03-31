package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.CardViewHollandCheckBoxBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.Activity;

import java.util.HashMap;
import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.MyViewHolder> {

    private Context context;
    private List<Activity> activities;
    private HashMap<String, String> answeredQuestion;


    public ActivityAdapter(Context context, List<Activity> activities) {
        answeredQuestion = new HashMap<>();
        this.context = context;
        this.activities = activities;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_holland_check_box, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Activity activity = activities.get(position);
        holder.binding.tvJobName.setText(activity.getQUESTIONTEXT());

        if (activity.getANSWERVALUE() == null)
            activity.setANSWERVALUE("0");
        else if (activity.getANSWERVALUE().equals("1"))
            holder.binding.checkbox.setChecked(true);

        holder.binding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    activity.setANSWERVALUE("1");
                else
                    activity.setANSWERVALUE("0");

            }
        });

    }


    @Override
    public int getItemCount() {
        return activities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardViewHollandCheckBoxBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CardViewHollandCheckBoxBinding.bind(itemView);
        }
    }


}
