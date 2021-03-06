package com.sh.wm.ministry.featuers.userfile.trainingskills.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.trainingskills.model.TrainingSkills;

import java.util.List;

public class TrainingSkillAdapter extends RecyclerView.Adapter<TrainingSkillAdapter.MyViewHolder> {

    private List<TrainingSkills> mData;
    private TrainingSkillAdapter.OnEditClickListener mListener;

    public TrainingSkillAdapter(List<TrainingSkills> mData, TrainingSkillAdapter.OnEditClickListener mListener) {
        this.mData = mData;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public TrainingSkillAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_skill_item, parent, false);
        return new TrainingSkillAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingSkillAdapter.MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_course_type;
        private TextView tv_course , tv_job , tvFiledThree;

        private AppCompatImageButton editIv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_course_type = itemView.findViewById(R.id.tv_course_type);
            tv_course = itemView.findViewById(R.id.tv_course);
            tv_job = itemView.findViewById(R.id.tv_job);
            tvFiledThree = itemView.findViewById(R.id.tv_filed_three);
            editIv = itemView.findViewById(R.id.ib_edit_skill);

        }

        public void bind(int position) {
            TrainingSkills skill=mData.get(position);
            tv_course_type.setText(skill.getCOURSETYPE());
            tv_course.setText(skill.getTRAINPROGNAME());


            if(skill.getJOBARNAME() != null){
                tvFiledThree.setVisibility(View.VISIBLE);
                tv_job.setVisibility(View.VISIBLE);
                tv_job.setText(skill.getJOBARNAME());
            }

            editIv.setOnClickListener(view -> {
                mListener.onEditClick(skill);
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onClick(skill);
                }
            });
        }
    }

    public interface OnEditClickListener {
        void onEditClick(TrainingSkills trainingSkills);
        void onClick(TrainingSkills trainingSkills);
    }
}
