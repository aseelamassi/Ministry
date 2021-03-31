// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHolandMajorServicesBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView btnNext;

  @NonNull
  public final ImageView btnPrev;

  @NonNull
  public final Button btnSave;

  @NonNull
  public final TextView edAge;

  @NonNull
  public final TextView edBirthDate;

  @NonNull
  public final TextView edFullName;

  @NonNull
  public final TextView edGender;

  @NonNull
  public final EditText edNumberOfYears;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final TextView tvAge;

  @NonNull
  public final TextView tvBirthDate;

  @NonNull
  public final TextView tvFullName;

  @NonNull
  public final TextView tvGender;

  @NonNull
  public final TextView tvNumberOfYears;

  private FragmentHolandMajorServicesBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView btnNext, @NonNull ImageView btnPrev, @NonNull Button btnSave,
      @NonNull TextView edAge, @NonNull TextView edBirthDate, @NonNull TextView edFullName,
      @NonNull TextView edGender, @NonNull EditText edNumberOfYears, @NonNull Guideline guideline,
      @NonNull ProgressBar progress, @NonNull TextView tvAge, @NonNull TextView tvBirthDate,
      @NonNull TextView tvFullName, @NonNull TextView tvGender, @NonNull TextView tvNumberOfYears) {
    this.rootView = rootView;
    this.btnNext = btnNext;
    this.btnPrev = btnPrev;
    this.btnSave = btnSave;
    this.edAge = edAge;
    this.edBirthDate = edBirthDate;
    this.edFullName = edFullName;
    this.edGender = edGender;
    this.edNumberOfYears = edNumberOfYears;
    this.guideline = guideline;
    this.progress = progress;
    this.tvAge = tvAge;
    this.tvBirthDate = tvBirthDate;
    this.tvFullName = tvFullName;
    this.tvGender = tvGender;
    this.tvNumberOfYears = tvNumberOfYears;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHolandMajorServicesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHolandMajorServicesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_holand_major_services, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHolandMajorServicesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_next;
      ImageView btnNext = rootView.findViewById(id);
      if (btnNext == null) {
        break missingId;
      }

      id = R.id.btn_prev;
      ImageView btnPrev = rootView.findViewById(id);
      if (btnPrev == null) {
        break missingId;
      }

      id = R.id.btn_save;
      Button btnSave = rootView.findViewById(id);
      if (btnSave == null) {
        break missingId;
      }

      id = R.id.ed_age;
      TextView edAge = rootView.findViewById(id);
      if (edAge == null) {
        break missingId;
      }

      id = R.id.ed_birth_date;
      TextView edBirthDate = rootView.findViewById(id);
      if (edBirthDate == null) {
        break missingId;
      }

      id = R.id.ed_full_name;
      TextView edFullName = rootView.findViewById(id);
      if (edFullName == null) {
        break missingId;
      }

      id = R.id.ed_gender;
      TextView edGender = rootView.findViewById(id);
      if (edGender == null) {
        break missingId;
      }

      id = R.id.ed_number_of_years;
      EditText edNumberOfYears = rootView.findViewById(id);
      if (edNumberOfYears == null) {
        break missingId;
      }

      id = R.id.guideline;
      Guideline guideline = rootView.findViewById(id);
      if (guideline == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = rootView.findViewById(id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.tv_age;
      TextView tvAge = rootView.findViewById(id);
      if (tvAge == null) {
        break missingId;
      }

      id = R.id.tv_birth_date;
      TextView tvBirthDate = rootView.findViewById(id);
      if (tvBirthDate == null) {
        break missingId;
      }

      id = R.id.tv_full_name;
      TextView tvFullName = rootView.findViewById(id);
      if (tvFullName == null) {
        break missingId;
      }

      id = R.id.tv_gender;
      TextView tvGender = rootView.findViewById(id);
      if (tvGender == null) {
        break missingId;
      }

      id = R.id.tv_number_of_years;
      TextView tvNumberOfYears = rootView.findViewById(id);
      if (tvNumberOfYears == null) {
        break missingId;
      }

      return new FragmentHolandMajorServicesBinding((ConstraintLayout) rootView, btnNext, btnPrev,
          btnSave, edAge, edBirthDate, edFullName, edGender, edNumberOfYears, guideline, progress,
          tvAge, tvBirthDate, tvFullName, tvGender, tvNumberOfYears);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}