// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAddPracticalStatusBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout LLPracticalStatus;

  @NonNull
  public final MaterialButton btnSaveAddLanguage;

  @NonNull
  public final LinearLayout lnDate;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final TextView tvCurrencyType;

  @NonNull
  public final TextView tvDescribeDescribePracticalStatus;

  @NonNull
  public final TextView tvDescribePracticalStatus;

  @NonNull
  public final TextView tvEnterprise;

  @NonNull
  public final TextView tvJob;

  @NonNull
  public final EditText tvMonthlyWage;

  @NonNull
  public final TextInputEditText tvNotesAddWorkExperience;

  @NonNull
  public final TextView tvPracticalStatus;

  @NonNull
  public final TextView tvWorkBeginningDate;

  @NonNull
  public final TextView tvWorkEndingDate;

  @NonNull
  public final TextView tvWorkHours;

  @NonNull
  public final TextView tvWorkNature;

  private FragmentAddPracticalStatusBinding(@NonNull RelativeLayout rootView,
      @NonNull LinearLayout LLPracticalStatus, @NonNull MaterialButton btnSaveAddLanguage,
      @NonNull LinearLayout lnDate, @NonNull ProgressBar progress, @NonNull TextView tvCurrencyType,
      @NonNull TextView tvDescribeDescribePracticalStatus,
      @NonNull TextView tvDescribePracticalStatus, @NonNull TextView tvEnterprise,
      @NonNull TextView tvJob, @NonNull EditText tvMonthlyWage,
      @NonNull TextInputEditText tvNotesAddWorkExperience, @NonNull TextView tvPracticalStatus,
      @NonNull TextView tvWorkBeginningDate, @NonNull TextView tvWorkEndingDate,
      @NonNull TextView tvWorkHours, @NonNull TextView tvWorkNature) {
    this.rootView = rootView;
    this.LLPracticalStatus = LLPracticalStatus;
    this.btnSaveAddLanguage = btnSaveAddLanguage;
    this.lnDate = lnDate;
    this.progress = progress;
    this.tvCurrencyType = tvCurrencyType;
    this.tvDescribeDescribePracticalStatus = tvDescribeDescribePracticalStatus;
    this.tvDescribePracticalStatus = tvDescribePracticalStatus;
    this.tvEnterprise = tvEnterprise;
    this.tvJob = tvJob;
    this.tvMonthlyWage = tvMonthlyWage;
    this.tvNotesAddWorkExperience = tvNotesAddWorkExperience;
    this.tvPracticalStatus = tvPracticalStatus;
    this.tvWorkBeginningDate = tvWorkBeginningDate;
    this.tvWorkEndingDate = tvWorkEndingDate;
    this.tvWorkHours = tvWorkHours;
    this.tvWorkNature = tvWorkNature;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAddPracticalStatusBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAddPracticalStatusBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_add_practical_status, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAddPracticalStatusBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.LL_practical_status;
      LinearLayout LLPracticalStatus = rootView.findViewById(id);
      if (LLPracticalStatus == null) {
        break missingId;
      }

      id = R.id.btn_save_add_language;
      MaterialButton btnSaveAddLanguage = rootView.findViewById(id);
      if (btnSaveAddLanguage == null) {
        break missingId;
      }

      id = R.id.ln_date;
      LinearLayout lnDate = rootView.findViewById(id);
      if (lnDate == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = rootView.findViewById(id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.tv_currency_type;
      TextView tvCurrencyType = rootView.findViewById(id);
      if (tvCurrencyType == null) {
        break missingId;
      }

      id = R.id.tv_describe_describe_practical_status;
      TextView tvDescribeDescribePracticalStatus = rootView.findViewById(id);
      if (tvDescribeDescribePracticalStatus == null) {
        break missingId;
      }

      id = R.id.tv_describe_practical_status;
      TextView tvDescribePracticalStatus = rootView.findViewById(id);
      if (tvDescribePracticalStatus == null) {
        break missingId;
      }

      id = R.id.tv_enterprise;
      TextView tvEnterprise = rootView.findViewById(id);
      if (tvEnterprise == null) {
        break missingId;
      }

      id = R.id.tv_job;
      TextView tvJob = rootView.findViewById(id);
      if (tvJob == null) {
        break missingId;
      }

      id = R.id.tv_monthly_wage;
      EditText tvMonthlyWage = rootView.findViewById(id);
      if (tvMonthlyWage == null) {
        break missingId;
      }

      id = R.id.tv_notes_add_work_experience;
      TextInputEditText tvNotesAddWorkExperience = rootView.findViewById(id);
      if (tvNotesAddWorkExperience == null) {
        break missingId;
      }

      id = R.id.tv_practical_status;
      TextView tvPracticalStatus = rootView.findViewById(id);
      if (tvPracticalStatus == null) {
        break missingId;
      }

      id = R.id.tv_work_beginning_date;
      TextView tvWorkBeginningDate = rootView.findViewById(id);
      if (tvWorkBeginningDate == null) {
        break missingId;
      }

      id = R.id.tv_work_ending_date;
      TextView tvWorkEndingDate = rootView.findViewById(id);
      if (tvWorkEndingDate == null) {
        break missingId;
      }

      id = R.id.tv_work_hours;
      TextView tvWorkHours = rootView.findViewById(id);
      if (tvWorkHours == null) {
        break missingId;
      }

      id = R.id.tv_work_nature;
      TextView tvWorkNature = rootView.findViewById(id);
      if (tvWorkNature == null) {
        break missingId;
      }

      return new FragmentAddPracticalStatusBinding((RelativeLayout) rootView, LLPracticalStatus,
          btnSaveAddLanguage, lnDate, progress, tvCurrencyType, tvDescribeDescribePracticalStatus,
          tvDescribePracticalStatus, tvEnterprise, tvJob, tvMonthlyWage, tvNotesAddWorkExperience,
          tvPracticalStatus, tvWorkBeginningDate, tvWorkEndingDate, tvWorkHours, tvWorkNature);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}