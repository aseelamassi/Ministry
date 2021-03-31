package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetDialogGeneral;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.databinding.CardViewEvaluationItemBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.Activity;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.EvaluationModel;

import java.util.Arrays;
import java.util.List;


public class EvaluationAdapter extends RecyclerView.Adapter<EvaluationAdapter.MyViewHolder> implements BottomSheetDialogGeneral.BottomSheetInterface {

    private Context context;
    private EvaluationModel model;
    private List<Activity> evaluationList;
    private int position;
    private String type;
    Activity activity;


    public EvaluationAdapter(Context context, EvaluationModel model, String type) {
        this.context = context;
        this.model = model;
        this.type = type;
        if (type.equals("0"))
            this.evaluationList = model.getEvaluation1();
        else
            this.evaluationList = model.getEvaluation2();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_evaluation_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        activity = evaluationList.get(position);
        holder.binding.tvQuestionName.setText(activity.getQUESTIONTEXT());
        holder.binding.etEvaluation.setText(activity.getANSWERVALUE());

        holder.binding.etEvaluation.setOnClickListener(view -> showBtmSheet(R.string.evaluation, holder.binding.etEvaluation, position));

    }


    @Override
    public int getItemCount() {
        return evaluationList.size();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        if (type.equals("0")) {

            for (int n = 0; n < model.getEvaluation1().size(); n++) {
                model.getEvaluation1().get(position).setANSWERVALUE(adapterView.getItemAtPosition(i).toString());

            }


        } else {
            for (int j = 0; j < model.getEvaluation2().size(); j++) {
                model.getEvaluation2().get(position).setANSWERVALUE(adapterView.getItemAtPosition(i).toString());

            }
        }


    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardViewEvaluationItemBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CardViewEvaluationItemBinding.bind(itemView);
        }
    }


    public void showBtmSheet(int title, TextView tv_change, int position) {

        this.position = position;
        BottomSheetDialogGeneral bottomSheetDialogGeneral = new BottomSheetDialogGeneral(context, this::onItemClick);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, Arrays.asList(context.getResources().getStringArray(R.array.evaluation)));

        bottomSheetDialogGeneral.openDialog(itemsAdapter, title, tv_change);

    }


    public EvaluationModel getModel() {
        return model;
    }
}
