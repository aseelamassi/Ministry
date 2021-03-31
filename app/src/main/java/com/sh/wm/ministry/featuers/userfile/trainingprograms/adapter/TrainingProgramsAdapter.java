package com.sh.wm.ministry.featuers.userfile.trainingprograms.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;


import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.featuers.userfile.languages.adapter.UserLanguagesAdapter;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguage;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.UserTrainingProgram;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;

import java.util.List;

public class TrainingProgramsAdapter extends RecyclerView.Adapter<TrainingProgramsAdapter.MyViewHolder> {

    private List<UserTrainingProgram> mData;
    private OnEditClickListener mListener;
    private UserFileViewModel viewModel;

    public TrainingProgramsAdapter(List<UserTrainingProgram> mData, OnEditClickListener mListener) {
        this.mData = mData;
        this.mListener = mListener;

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_training_program_item, parent, false);
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

    public interface OnEditClickListener {
        void onEditClick(UserTrainingProgram trainingProgram);
        void onClick(UserTrainingProgram trainingProgram);
        void getConstantName(String trainEntityId, TextView textView);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_train_name;
        private TextView tv_train_type;
        private TextView tv_train_dest;
        private TextView tv_train_hour;
        private AppCompatImageButton editIv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_train_name = itemView.findViewById(R.id.tv_train_name);
            tv_train_type = itemView.findViewById(R.id.tv_train_type);
            tv_train_dest = itemView.findViewById(R.id.tv_train_dest);
            tv_train_hour = itemView.findViewById(R.id.tv_train_hour);
            editIv = itemView.findViewById(R.id.ib_edit_train_program);


        }

        public void bind(int position) {
            UserTrainingProgram trainingProgram=mData.get(position);


            if (trainingProgram.getUSERTRAINPROGTRAINENTITY() != null ){
                mListener.getConstantName(trainingProgram.getUSERTRAINPROGTRAINENTITY() ,tv_train_dest );

            }


            tv_train_name.setText(trainingProgram.getTRAINPROGNAME());
            tv_train_type.setText(trainingProgram.getCOURSETYPE());
            tv_train_hour.setText(trainingProgram.getUSERTRAINPROGTRAININGHOURS());


            editIv.setOnClickListener(view -> {
                mListener.onEditClick(trainingProgram);
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onClick(trainingProgram);
                }
            });
        }

    }









    }
