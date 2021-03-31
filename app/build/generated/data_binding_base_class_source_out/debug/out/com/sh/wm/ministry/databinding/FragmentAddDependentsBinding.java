// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAddDependentsBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final AppCompatImageButton btnGetDependentData;

  @NonNull
  public final MaterialButton btnSaveNewDependents;

  @NonNull
  public final EditText etDependentSn;

  @NonNull
  public final TextView etFamilyName;

  @NonNull
  public final TextView etFirstName;

  @NonNull
  public final TextView etJob;

  @NonNull
  public final TextView etRelationShip;

  @NonNull
  public final TextView etSecondName;

  @NonNull
  public final TextView etThirdName;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final TextView tvBirthDateDependents;

  private FragmentAddDependentsBinding(@NonNull CoordinatorLayout rootView,
      @NonNull AppCompatImageButton btnGetDependentData,
      @NonNull MaterialButton btnSaveNewDependents, @NonNull EditText etDependentSn,
      @NonNull TextView etFamilyName, @NonNull TextView etFirstName, @NonNull TextView etJob,
      @NonNull TextView etRelationShip, @NonNull TextView etSecondName,
      @NonNull TextView etThirdName, @NonNull ProgressBar progress,
      @NonNull TextView tvBirthDateDependents) {
    this.rootView = rootView;
    this.btnGetDependentData = btnGetDependentData;
    this.btnSaveNewDependents = btnSaveNewDependents;
    this.etDependentSn = etDependentSn;
    this.etFamilyName = etFamilyName;
    this.etFirstName = etFirstName;
    this.etJob = etJob;
    this.etRelationShip = etRelationShip;
    this.etSecondName = etSecondName;
    this.etThirdName = etThirdName;
    this.progress = progress;
    this.tvBirthDateDependents = tvBirthDateDependents;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAddDependentsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAddDependentsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_add_dependents, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAddDependentsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_get_dependent_data;
      AppCompatImageButton btnGetDependentData = rootView.findViewById(id);
      if (btnGetDependentData == null) {
        break missingId;
      }

      id = R.id.btn_save_new_dependents;
      MaterialButton btnSaveNewDependents = rootView.findViewById(id);
      if (btnSaveNewDependents == null) {
        break missingId;
      }

      id = R.id.et_dependent_sn;
      EditText etDependentSn = rootView.findViewById(id);
      if (etDependentSn == null) {
        break missingId;
      }

      id = R.id.et_family_name;
      TextView etFamilyName = rootView.findViewById(id);
      if (etFamilyName == null) {
        break missingId;
      }

      id = R.id.et_first_name;
      TextView etFirstName = rootView.findViewById(id);
      if (etFirstName == null) {
        break missingId;
      }

      id = R.id.et_job;
      TextView etJob = rootView.findViewById(id);
      if (etJob == null) {
        break missingId;
      }

      id = R.id.et_relation_ship;
      TextView etRelationShip = rootView.findViewById(id);
      if (etRelationShip == null) {
        break missingId;
      }

      id = R.id.et_second_name;
      TextView etSecondName = rootView.findViewById(id);
      if (etSecondName == null) {
        break missingId;
      }

      id = R.id.et_third_name;
      TextView etThirdName = rootView.findViewById(id);
      if (etThirdName == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = rootView.findViewById(id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.tv_birth_date_dependents;
      TextView tvBirthDateDependents = rootView.findViewById(id);
      if (tvBirthDateDependents == null) {
        break missingId;
      }

      return new FragmentAddDependentsBinding((CoordinatorLayout) rootView, btnGetDependentData,
          btnSaveNewDependents, etDependentSn, etFamilyName, etFirstName, etJob, etRelationShip,
          etSecondName, etThirdName, progress, tvBirthDateDependents);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}