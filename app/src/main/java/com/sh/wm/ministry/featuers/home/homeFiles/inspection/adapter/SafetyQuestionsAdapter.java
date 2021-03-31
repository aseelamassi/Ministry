package com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SafetyQuestionsAdapter extends RecyclerView.Adapter<SafetyQuestionsAdapter.ViewHolder> {

    private Context context;
    private List<SafetyQuestion> safetyQuestionList;
    private HashMap<String, String> answers;
    ArrayList<HashMap<String, String>> list = new ArrayList();
    private ImageView btn ;


    public SafetyQuestionsAdapter(Context context, List<SafetyQuestion> safetyQuestionList, ImageView btn) {
        this.context = context;
        this.safetyQuestionList = safetyQuestionList;
        this.btn = btn;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.occupational_health_and_safety_card, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SafetyQuestion question = safetyQuestionList.get(position);
        if (position == 14)
            btn.setVisibility(View.GONE);

        int count = position + 1;
        holder.tvCount.setText(count + "-");
        holder.tvLawNumber.setText(context.getString(R.string.law_number).concat(question.getPALLAWARTICALNUM()));
        holder.tvLawText.setText(question.getPALLAWARTICALDESC());
        holder.rgCommit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                answers = new HashMap<>();
                if (i == R.id.rb_committed) {
                    answers.put("question_id", question.getPALLAWARTICALNUM());
                    answers.put("answer", "1");

                } else {
                    answers.put("question_id", question.getPALLAWARTICALNUM());
                    answers.put("answer", "3");
                }


                for (int j = 0; j < list.size(); j++) {
                    if (question.getPALLAWARTICALNUM().equals(list.get(j).get("question_id"))) {
                        list.remove(j);
                        break;
                    }

                }
                list.add(answers);

            }
        });

    }


    @Override
    public int getItemCount() {
        return safetyQuestionList.size();
    }


    public ArrayList getList() {
        return list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvLawNumber, tvLawText, tvCount;
        RadioGroup rgCommit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLawNumber = itemView.findViewById(R.id.tv_law_number);
            tvLawText = itemView.findViewById(R.id.tv_law_text);
            tvCount = itemView.findViewById(R.id.tv_count);
            rgCommit = itemView.findViewById(R.id.rg_commitment);
        }
    }

}
