package com.sh.wm.ministry.featuers.userfile.career.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.career.model.UserCareer;
import com.sh.wm.ministry.featuers.userfile.languages.adapter.UserLanguagesAdapter;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguage;

import java.util.List;

public class UserCareersAdapter extends RecyclerView.Adapter<UserCareersAdapter.MyViewHolder> {
    Context context;
    List<UserCareer> mData;
    UserCareersAdapter.OnEditClickListener mListener;

    public UserCareersAdapter(Context context, List<UserCareer> mData,UserCareersAdapter.OnEditClickListener mListener) {
        this.context = context;
        this.mData = mData;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.career_cardview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.TvCareerName.setText(mData.get(position).getCAREERNAME());
        holder.TvCareerVacation.setText(mData.get(position).getCAREERLICENSED());
        if (mData.get(position).getUSERCAREERSKILLLEVELID() != null){
            holder.tvExperienceYear.setText(mData.get(position).getUSERCAREERSKILLLEVELID());
        }else {
            holder.tvFieldThree.setVisibility(View.INVISIBLE);
            holder.tvExperienceYear.setVisibility(View.INVISIBLE);

        }

//        holder.editCareer.setOnClickListener(view -> {
//            mListener.onEditClick(mData.get(position));
//        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public interface OnEditClickListener {
        void onEditClick(UserCareer userLanguage);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView TvCareerName;
        TextView TvCareerVacation;
        TextView tvExperienceYear ;
        TextView tvFieldThree;
        //AppCompatImageButton editCareer ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            TvCareerName = itemView.findViewById(R.id.tv_career_name);
            TvCareerVacation = itemView.findViewById(R.id.tv_career_vacation);
            tvFieldThree = itemView.findViewById(R.id.materialTextView6);
            tvExperienceYear = itemView.findViewById(R.id.tv_experience_year);
            //editCareer = itemView.findViewById(R.id.appCompatImageButton);

        }
    }
}
