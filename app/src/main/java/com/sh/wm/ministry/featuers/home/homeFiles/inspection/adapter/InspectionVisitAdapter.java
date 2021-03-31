package com.sh.wm.ministry.featuers.home.homeFiles.inspection.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel.InspectionsViewModel;

import org.jetbrains.annotations.NotNull;

public class InspectionVisitAdapter extends PagingDataAdapter<InspectionVisit, InspectionVisitAdapter.ViewHolder> {


    // Define Loading ViewType
    public static final int LOADING_ITEM = 0;
    // Define Movie ViewType
    public static final int MOVIE_ITEM = 1;
    private Context context;
    InspectionsViewModel viewModel;
    private OnClick mListener;
    private int count = 1;

    public InspectionVisitAdapter(@NotNull DiffUtil.ItemCallback<InspectionVisit> diffCallback, Context context, OnClick mListener) {
        super(diffCallback);
        this.context = context;
        this.mListener = mListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.card_view_facility_procedures_inspection, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        InspectionVisit inspectionVisit = getItem(position);

        holder.tv_directorate.setText(inspectionVisit.getDIRECTORATENAME());
        holder.tv_inspection_start_date.setText(inspectionVisit.getVISITDATE());
        holder.tv_facility_name.setText(inspectionVisit.getCONSTRUCTNAMEUSING());


        switch (inspectionVisit.getINSPETVISITSTATUS()) {
            case "0":
                holder.btnStartVisit.setEnabled(true);

                holder.btnAdditionalServices.setEnabled(false);
                holder.btnAdditionalServices.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.primary_color_opacity)));

                holder.btnInspectionRecommendation.setEnabled(false);
                holder.btnInspectionRecommendation.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.anything_opacity)));

                holder.btnInspectionResult.setEnabled(false);
                holder.btnInspectionResult.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.purple_opacity)));


                holder.btnRevisit.setEnabled(false);
                holder.btnRevisit.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.green_opacity)));


                break;
            case "1":

                holder.btnStartVisit.setEnabled(false);
                holder.btnStartVisit.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.orange_opacity)));

                holder.btnAdditionalServices.setEnabled(true);

                holder.btnInspectionRecommendation.setEnabled(false);
                holder.btnInspectionRecommendation.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.anything_opacity)));


                holder.btnInspectionResult.setEnabled(false);
                holder.btnInspectionResult.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.purple_opacity)));


                holder.btnRevisit.setEnabled(false);
                holder.btnRevisit.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.green_opacity)));

                break;

            case "2":
                holder.btnStartVisit.setEnabled(false);
                holder.btnStartVisit.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.orange_opacity)));

                holder.btnAdditionalServices.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.primary_color_opacity)));
                holder.btnAdditionalServices.setEnabled(false);

                holder.btnInspectionRecommendation.setEnabled(true);
                holder.btnInspectionResult.setEnabled(true);
                holder.btnRevisit.setEnabled(true);
                break;

        }

        holder.btnStartVisit.setOnClickListener(view -> {

            showCustomDialog(context, inspectionVisit.getINSPECTVID());
        });


        holder.btnInspectionResult.setOnClickListener(view -> {
            mListener.onClick("storeResult", inspectionVisit);
        });

        holder.btnInspectionRecommendation.setOnClickListener(view ->
                mListener.onClick("recommendation", inspectionVisit));


        holder.btnRevisit.setOnClickListener(view -> mListener.onClick("revisit", inspectionVisit));


        holder.btnAdditionalServices.setOnClickListener(view -> mListener.onClick("additionalServices", inspectionVisit));


    }


    public void showCustomDialog(final Context context, String visitId) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_confirm_start_visit);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.CENTER;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);


        TextView cancelBtn = dialog.findViewById(R.id.btn_cancel);


        cancelBtn.setOnClickListener(view -> {
            cancelBtn.setTextColor(context.getResources().getColor(R.color.white));
            cancelBtn.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            dialog.dismiss();
        });

        TextView yesBtn = dialog.findViewById(R.id.btn_save_dialog);

        yesBtn.setOnClickListener(view -> {
            yesBtn.setTextColor(context.getResources().getColor(R.color.white));
            yesBtn.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));

            viewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(InspectionsViewModel.class);
            viewModel.startVisit(visitId);
            dialog.dismiss();

        });

        dialog.show();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_directorate, tv_inspection_start_date, tv_facility_name;
        AppCompatButton btnStartVisit, btnInspectionResult, btnInspectionRecommendation, btnRevisit, btnAdditionalServices;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_directorate = itemView.findViewById(R.id.tv_directorate);
            tv_inspection_start_date = itemView.findViewById(R.id.tv_inspection_start_date);
            tv_facility_name = itemView.findViewById(R.id.tv_facility_name);
            btnStartVisit = itemView.findViewById(R.id.btn_start_visit);
            btnInspectionResult = itemView.findViewById(R.id.btn_inspection_result);
            btnInspectionRecommendation = itemView.findViewById(R.id.btn_recommendation);
            btnRevisit = itemView.findViewById(R.id.btn_revisit);
            btnAdditionalServices = itemView.findViewById(R.id.btn_additional_services);


        }
    }

    public interface OnClick {
        void onClick(String type, InspectionVisit inspectionVisit);
    }


//    @Override
//    public int getItemViewType(int position) {
//        // set ViewType
//        return position == getItemCount() ? MOVIE_ITEM : LOADING_ITEM;
//    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }


}
