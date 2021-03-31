// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentInspectionVisitingMenuBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final CardView inspectionDecBtn;

  @NonNull
  public final CardView inspectionMngBtn;

  @NonNull
  public final CardView inspectionPlaneMngBtn;

  @NonNull
  public final CardView inspectionPlanePrpBtn;

  @NonNull
  public final CardView inspectionVisitBtn;

  private FragmentInspectionVisitingMenuBinding(@NonNull CoordinatorLayout rootView,
      @NonNull CardView inspectionDecBtn, @NonNull CardView inspectionMngBtn,
      @NonNull CardView inspectionPlaneMngBtn, @NonNull CardView inspectionPlanePrpBtn,
      @NonNull CardView inspectionVisitBtn) {
    this.rootView = rootView;
    this.inspectionDecBtn = inspectionDecBtn;
    this.inspectionMngBtn = inspectionMngBtn;
    this.inspectionPlaneMngBtn = inspectionPlaneMngBtn;
    this.inspectionPlanePrpBtn = inspectionPlanePrpBtn;
    this.inspectionVisitBtn = inspectionVisitBtn;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentInspectionVisitingMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentInspectionVisitingMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_inspection_visiting_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentInspectionVisitingMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.inspection_dec_btn;
      CardView inspectionDecBtn = rootView.findViewById(id);
      if (inspectionDecBtn == null) {
        break missingId;
      }

      id = R.id.inspection_mng_btn;
      CardView inspectionMngBtn = rootView.findViewById(id);
      if (inspectionMngBtn == null) {
        break missingId;
      }

      id = R.id.inspection_plane_mng_btn;
      CardView inspectionPlaneMngBtn = rootView.findViewById(id);
      if (inspectionPlaneMngBtn == null) {
        break missingId;
      }

      id = R.id.inspection_plane_prp_btn;
      CardView inspectionPlanePrpBtn = rootView.findViewById(id);
      if (inspectionPlanePrpBtn == null) {
        break missingId;
      }

      id = R.id.inspection_visit_btn;
      CardView inspectionVisitBtn = rootView.findViewById(id);
      if (inspectionVisitBtn == null) {
        break missingId;
      }

      return new FragmentInspectionVisitingMenuBinding((CoordinatorLayout) rootView,
          inspectionDecBtn, inspectionMngBtn, inspectionPlaneMngBtn, inspectionPlanePrpBtn,
          inspectionVisitBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
