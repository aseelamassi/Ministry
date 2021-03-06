// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAdditionalServicesFirstBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final AppCompatButton btnEditConstructionData;

  @NonNull
  public final AppCompatButton btnOccupationalSafetyAndHealth;

  @NonNull
  public final AppCompatButton btnWorkerInfo;

  @NonNull
  public final CardViewSearshShBinding cardViewSearshMoveFacility;

  @NonNull
  public final LinearLayout llCardContainer;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final TextView tvLabel;

  @NonNull
  public final View viewSeparator;

  private FragmentAdditionalServicesFirstBinding(@NonNull NestedScrollView rootView,
      @NonNull AppCompatButton btnEditConstructionData,
      @NonNull AppCompatButton btnOccupationalSafetyAndHealth,
      @NonNull AppCompatButton btnWorkerInfo,
      @NonNull CardViewSearshShBinding cardViewSearshMoveFacility,
      @NonNull LinearLayout llCardContainer, @NonNull ProgressBar progress,
      @NonNull TextView tvLabel, @NonNull View viewSeparator) {
    this.rootView = rootView;
    this.btnEditConstructionData = btnEditConstructionData;
    this.btnOccupationalSafetyAndHealth = btnOccupationalSafetyAndHealth;
    this.btnWorkerInfo = btnWorkerInfo;
    this.cardViewSearshMoveFacility = cardViewSearshMoveFacility;
    this.llCardContainer = llCardContainer;
    this.progress = progress;
    this.tvLabel = tvLabel;
    this.viewSeparator = viewSeparator;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAdditionalServicesFirstBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAdditionalServicesFirstBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_additional_services_first, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAdditionalServicesFirstBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_edit_construction_data;
      AppCompatButton btnEditConstructionData = rootView.findViewById(id);
      if (btnEditConstructionData == null) {
        break missingId;
      }

      id = R.id.btn_occupational_safety_and_health;
      AppCompatButton btnOccupationalSafetyAndHealth = rootView.findViewById(id);
      if (btnOccupationalSafetyAndHealth == null) {
        break missingId;
      }

      id = R.id.btn_worker_info;
      AppCompatButton btnWorkerInfo = rootView.findViewById(id);
      if (btnWorkerInfo == null) {
        break missingId;
      }

      id = R.id.card_view_searsh_move_facility;
      View cardViewSearshMoveFacility = rootView.findViewById(id);
      if (cardViewSearshMoveFacility == null) {
        break missingId;
      }
      CardViewSearshShBinding binding_cardViewSearshMoveFacility = CardViewSearshShBinding.bind(cardViewSearshMoveFacility);

      id = R.id.ll_card_container;
      LinearLayout llCardContainer = rootView.findViewById(id);
      if (llCardContainer == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = rootView.findViewById(id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.tv_label;
      TextView tvLabel = rootView.findViewById(id);
      if (tvLabel == null) {
        break missingId;
      }

      id = R.id.view_separator;
      View viewSeparator = rootView.findViewById(id);
      if (viewSeparator == null) {
        break missingId;
      }

      return new FragmentAdditionalServicesFirstBinding((NestedScrollView) rootView,
          btnEditConstructionData, btnOccupationalSafetyAndHealth, btnWorkerInfo,
          binding_cardViewSearshMoveFacility, llCardContainer, progress, tvLabel, viewSeparator);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
