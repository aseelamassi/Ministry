// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardViewFacilityProceduresInspectionBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final AppCompatButton btnAdditionalServices;

  @NonNull
  public final AppCompatButton btnDisplayResult;

  @NonNull
  public final AppCompatButton btnInspectionResult;

  @NonNull
  public final AppCompatButton btnRecommendation;

  @NonNull
  public final AppCompatButton btnRevisit;

  @NonNull
  public final AppCompatButton btnStartVisit;

  @NonNull
  public final LinearLayout llDirectorate;

  @NonNull
  public final LinearLayout llInspectionsDate;

  @NonNull
  public final TextView tvDirectorate;

  @NonNull
  public final TextView tvDirectorateLabel;

  @NonNull
  public final TextView tvFacilityName;

  @NonNull
  public final TextView tvInspectionStartDate;

  @NonNull
  public final TextView tvInspectionStartDateLabel;

  @NonNull
  public final TextView tvProcedures;

  private CardViewFacilityProceduresInspectionBinding(@NonNull MaterialCardView rootView,
      @NonNull AppCompatButton btnAdditionalServices, @NonNull AppCompatButton btnDisplayResult,
      @NonNull AppCompatButton btnInspectionResult, @NonNull AppCompatButton btnRecommendation,
      @NonNull AppCompatButton btnRevisit, @NonNull AppCompatButton btnStartVisit,
      @NonNull LinearLayout llDirectorate, @NonNull LinearLayout llInspectionsDate,
      @NonNull TextView tvDirectorate, @NonNull TextView tvDirectorateLabel,
      @NonNull TextView tvFacilityName, @NonNull TextView tvInspectionStartDate,
      @NonNull TextView tvInspectionStartDateLabel, @NonNull TextView tvProcedures) {
    this.rootView = rootView;
    this.btnAdditionalServices = btnAdditionalServices;
    this.btnDisplayResult = btnDisplayResult;
    this.btnInspectionResult = btnInspectionResult;
    this.btnRecommendation = btnRecommendation;
    this.btnRevisit = btnRevisit;
    this.btnStartVisit = btnStartVisit;
    this.llDirectorate = llDirectorate;
    this.llInspectionsDate = llInspectionsDate;
    this.tvDirectorate = tvDirectorate;
    this.tvDirectorateLabel = tvDirectorateLabel;
    this.tvFacilityName = tvFacilityName;
    this.tvInspectionStartDate = tvInspectionStartDate;
    this.tvInspectionStartDateLabel = tvInspectionStartDateLabel;
    this.tvProcedures = tvProcedures;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CardViewFacilityProceduresInspectionBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardViewFacilityProceduresInspectionBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_view_facility_procedures_inspection, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardViewFacilityProceduresInspectionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_additional_services;
      AppCompatButton btnAdditionalServices = rootView.findViewById(id);
      if (btnAdditionalServices == null) {
        break missingId;
      }

      id = R.id.btn_display_result;
      AppCompatButton btnDisplayResult = rootView.findViewById(id);
      if (btnDisplayResult == null) {
        break missingId;
      }

      id = R.id.btn_inspection_result;
      AppCompatButton btnInspectionResult = rootView.findViewById(id);
      if (btnInspectionResult == null) {
        break missingId;
      }

      id = R.id.btn_recommendation;
      AppCompatButton btnRecommendation = rootView.findViewById(id);
      if (btnRecommendation == null) {
        break missingId;
      }

      id = R.id.btn_revisit;
      AppCompatButton btnRevisit = rootView.findViewById(id);
      if (btnRevisit == null) {
        break missingId;
      }

      id = R.id.btn_start_visit;
      AppCompatButton btnStartVisit = rootView.findViewById(id);
      if (btnStartVisit == null) {
        break missingId;
      }

      id = R.id.ll_directorate;
      LinearLayout llDirectorate = rootView.findViewById(id);
      if (llDirectorate == null) {
        break missingId;
      }

      id = R.id.ll_inspections_Date;
      LinearLayout llInspectionsDate = rootView.findViewById(id);
      if (llInspectionsDate == null) {
        break missingId;
      }

      id = R.id.tv_directorate;
      TextView tvDirectorate = rootView.findViewById(id);
      if (tvDirectorate == null) {
        break missingId;
      }

      id = R.id.tv_directorate_label;
      TextView tvDirectorateLabel = rootView.findViewById(id);
      if (tvDirectorateLabel == null) {
        break missingId;
      }

      id = R.id.tv_facility_name;
      TextView tvFacilityName = rootView.findViewById(id);
      if (tvFacilityName == null) {
        break missingId;
      }

      id = R.id.tv_inspection_start_date;
      TextView tvInspectionStartDate = rootView.findViewById(id);
      if (tvInspectionStartDate == null) {
        break missingId;
      }

      id = R.id.tv_inspection_start_date_label;
      TextView tvInspectionStartDateLabel = rootView.findViewById(id);
      if (tvInspectionStartDateLabel == null) {
        break missingId;
      }

      id = R.id.tv_procedures;
      TextView tvProcedures = rootView.findViewById(id);
      if (tvProcedures == null) {
        break missingId;
      }

      return new CardViewFacilityProceduresInspectionBinding((MaterialCardView) rootView,
          btnAdditionalServices, btnDisplayResult, btnInspectionResult, btnRecommendation,
          btnRevisit, btnStartVisit, llDirectorate, llInspectionsDate, tvDirectorate,
          tvDirectorateLabel, tvFacilityName, tvInspectionStartDate, tvInspectionStartDateLabel,
          tvProcedures);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}