package com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;

import java.util.ArrayList;

public class SubjectNumberAdapter extends RecyclerView.Adapter<SubjectNumberAdapter.MyHolder> {

    private ArrayList<PalLaw> items;
    private OnItemClicked onItemClicked;

    public SubjectNumberAdapter(ArrayList<PalLaw> items, OnItemClicked onItemClicked) {
        this.items = items;
        this.onItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_supject_number_alarm_fragment, parent, false);
        return new MyHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        PalLaw itemAdapter = items.get(position);
        holder.bind(position, onItemClicked);
        if (itemAdapter == null) {
            holder.tv_law.setText(null);
            return;
        }
        if (itemAdapter.getText() != null) {
            holder.tv_law.setEnabled(false);

        }


        holder.tv_law.setText(itemAdapter.getText());
        holder.deleteBtn.setOnClickListener(view -> {
            items.remove(position);
            if (items.size() == 0)
                items.add(null);
            notifyDataSetChanged();
        });




    }

    @Override
    public int getItemCount() {
        return items.size();

    }

    public ArrayList<PalLaw> getItems() {
        return items;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayout;
        TextView tv_law;
        AppCompatImageButton deleteBtn;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.cl_search_container);
            tv_law = itemView.findViewById(R.id.ed_article_number_alarm_form_fragment);
            deleteBtn = itemView.findViewById(R.id.btn_delete);
        }

        public void bind(int position, OnItemClicked onItemClicked) {
           constraintLayout.setOnClickListener(view -> onItemClicked.itemClicked(position));

        }
    }

    public interface OnItemClicked {

        void itemClicked(int position);

    }
}
