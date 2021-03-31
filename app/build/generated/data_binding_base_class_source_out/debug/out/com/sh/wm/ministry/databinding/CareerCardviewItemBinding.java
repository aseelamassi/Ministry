// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CareerCardviewItemBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final CircularImageView circularImageView;

  @NonNull
  public final MaterialTextView materialTextView;

  @NonNull
  public final MaterialTextView materialTextView3;

  @NonNull
  public final MaterialTextView materialTextView6;

  @NonNull
  public final MaterialTextView tvCareerName;

  @NonNull
  public final MaterialTextView tvCareerVacation;

  @NonNull
  public final MaterialTextView tvExperienceYear;

  @NonNull
  public final View view;

  private CareerCardviewItemBinding(@NonNull MaterialCardView rootView,
      @NonNull CircularImageView circularImageView, @NonNull MaterialTextView materialTextView,
      @NonNull MaterialTextView materialTextView3, @NonNull MaterialTextView materialTextView6,
      @NonNull MaterialTextView tvCareerName, @NonNull MaterialTextView tvCareerVacation,
      @NonNull MaterialTextView tvExperienceYear, @NonNull View view) {
    this.rootView = rootView;
    this.circularImageView = circularImageView;
    this.materialTextView = materialTextView;
    this.materialTextView3 = materialTextView3;
    this.materialTextView6 = materialTextView6;
    this.tvCareerName = tvCareerName;
    this.tvCareerVacation = tvCareerVacation;
    this.tvExperienceYear = tvExperienceYear;
    this.view = view;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CareerCardviewItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CareerCardviewItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.career_cardview_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CareerCardviewItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.circularImageView;
      CircularImageView circularImageView = rootView.findViewById(id);
      if (circularImageView == null) {
        break missingId;
      }

      id = R.id.materialTextView;
      MaterialTextView materialTextView = rootView.findViewById(id);
      if (materialTextView == null) {
        break missingId;
      }

      id = R.id.materialTextView3;
      MaterialTextView materialTextView3 = rootView.findViewById(id);
      if (materialTextView3 == null) {
        break missingId;
      }

      id = R.id.materialTextView6;
      MaterialTextView materialTextView6 = rootView.findViewById(id);
      if (materialTextView6 == null) {
        break missingId;
      }

      id = R.id.tv_career_name;
      MaterialTextView tvCareerName = rootView.findViewById(id);
      if (tvCareerName == null) {
        break missingId;
      }

      id = R.id.tv_career_vacation;
      MaterialTextView tvCareerVacation = rootView.findViewById(id);
      if (tvCareerVacation == null) {
        break missingId;
      }

      id = R.id.tv_experience_year;
      MaterialTextView tvExperienceYear = rootView.findViewById(id);
      if (tvExperienceYear == null) {
        break missingId;
      }

      id = R.id.view;
      View view = rootView.findViewById(id);
      if (view == null) {
        break missingId;
      }

      return new CareerCardviewItemBinding((MaterialCardView) rootView, circularImageView,
          materialTextView, materialTextView3, materialTextView6, tvCareerName, tvCareerVacation,
          tvExperienceYear, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
