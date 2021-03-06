// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentInspectionMngBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatImageButton btnGetAll;

  @NonNull
  public final AppCompatImageButton btnSearchConstruct;

  @NonNull
  public final EditText etFacilityName;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final RecyclerView rvFacilityInspections;

  private FragmentInspectionMngBinding(@NonNull LinearLayout rootView,
      @NonNull AppCompatImageButton btnGetAll, @NonNull AppCompatImageButton btnSearchConstruct,
      @NonNull EditText etFacilityName, @NonNull ProgressBar progressbar,
      @NonNull RecyclerView rvFacilityInspections) {
    this.rootView = rootView;
    this.btnGetAll = btnGetAll;
    this.btnSearchConstruct = btnSearchConstruct;
    this.etFacilityName = etFacilityName;
    this.progressbar = progressbar;
    this.rvFacilityInspections = rvFacilityInspections;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentInspectionMngBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentInspectionMngBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_inspection_mng, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentInspectionMngBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_get_all;
      AppCompatImageButton btnGetAll = rootView.findViewById(id);
      if (btnGetAll == null) {
        break missingId;
      }

      id = R.id.btn_search_construct;
      AppCompatImageButton btnSearchConstruct = rootView.findViewById(id);
      if (btnSearchConstruct == null) {
        break missingId;
      }

      id = R.id.et_facility_name;
      EditText etFacilityName = rootView.findViewById(id);
      if (etFacilityName == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = rootView.findViewById(id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.rv_facility_inspections;
      RecyclerView rvFacilityInspections = rootView.findViewById(id);
      if (rvFacilityInspections == null) {
        break missingId;
      }

      return new FragmentInspectionMngBinding((LinearLayout) rootView, btnGetAll,
          btnSearchConstruct, etFacilityName, progressbar, rvFacilityInspections);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
