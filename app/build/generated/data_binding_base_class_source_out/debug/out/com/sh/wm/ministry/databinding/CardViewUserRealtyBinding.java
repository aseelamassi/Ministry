// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardViewUserRealtyBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final ImageView circularImageView;

  @NonNull
  public final MaterialTextView materialTextView;

  @NonNull
  public final MaterialTextView materialTextView2;

  @NonNull
  public final MaterialTextView materialTextView3;

  @NonNull
  public final MaterialTextView materialTextView4;

  @NonNull
  public final MaterialTextView materialTextView5;

  @NonNull
  public final MaterialTextView tvAvgShareCapital;

  @NonNull
  public final MaterialTextView tvCustomNumber;

  @NonNull
  public final MaterialTextView tvRealtyAddress;

  @NonNull
  public final MaterialTextView tvRealtyName;

  @NonNull
  public final MaterialTextView tvRealtyType;

  @NonNull
  public final View view;

  private CardViewUserRealtyBinding(@NonNull MaterialCardView rootView,
      @NonNull ImageView circularImageView, @NonNull MaterialTextView materialTextView,
      @NonNull MaterialTextView materialTextView2, @NonNull MaterialTextView materialTextView3,
      @NonNull MaterialTextView materialTextView4, @NonNull MaterialTextView materialTextView5,
      @NonNull MaterialTextView tvAvgShareCapital, @NonNull MaterialTextView tvCustomNumber,
      @NonNull MaterialTextView tvRealtyAddress, @NonNull MaterialTextView tvRealtyName,
      @NonNull MaterialTextView tvRealtyType, @NonNull View view) {
    this.rootView = rootView;
    this.circularImageView = circularImageView;
    this.materialTextView = materialTextView;
    this.materialTextView2 = materialTextView2;
    this.materialTextView3 = materialTextView3;
    this.materialTextView4 = materialTextView4;
    this.materialTextView5 = materialTextView5;
    this.tvAvgShareCapital = tvAvgShareCapital;
    this.tvCustomNumber = tvCustomNumber;
    this.tvRealtyAddress = tvRealtyAddress;
    this.tvRealtyName = tvRealtyName;
    this.tvRealtyType = tvRealtyType;
    this.view = view;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CardViewUserRealtyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardViewUserRealtyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_view_user_realty, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardViewUserRealtyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.circularImageView;
      ImageView circularImageView = rootView.findViewById(id);
      if (circularImageView == null) {
        break missingId;
      }

      id = R.id.materialTextView;
      MaterialTextView materialTextView = rootView.findViewById(id);
      if (materialTextView == null) {
        break missingId;
      }

      id = R.id.materialTextView2;
      MaterialTextView materialTextView2 = rootView.findViewById(id);
      if (materialTextView2 == null) {
        break missingId;
      }

      id = R.id.materialTextView3;
      MaterialTextView materialTextView3 = rootView.findViewById(id);
      if (materialTextView3 == null) {
        break missingId;
      }

      id = R.id.materialTextView4;
      MaterialTextView materialTextView4 = rootView.findViewById(id);
      if (materialTextView4 == null) {
        break missingId;
      }

      id = R.id.materialTextView5;
      MaterialTextView materialTextView5 = rootView.findViewById(id);
      if (materialTextView5 == null) {
        break missingId;
      }

      id = R.id.tv_avg_share_capital;
      MaterialTextView tvAvgShareCapital = rootView.findViewById(id);
      if (tvAvgShareCapital == null) {
        break missingId;
      }

      id = R.id.tv_custom_number;
      MaterialTextView tvCustomNumber = rootView.findViewById(id);
      if (tvCustomNumber == null) {
        break missingId;
      }

      id = R.id.tv_realty_address;
      MaterialTextView tvRealtyAddress = rootView.findViewById(id);
      if (tvRealtyAddress == null) {
        break missingId;
      }

      id = R.id.tv_realty_name;
      MaterialTextView tvRealtyName = rootView.findViewById(id);
      if (tvRealtyName == null) {
        break missingId;
      }

      id = R.id.tv_realty_type;
      MaterialTextView tvRealtyType = rootView.findViewById(id);
      if (tvRealtyType == null) {
        break missingId;
      }

      id = R.id.view;
      View view = rootView.findViewById(id);
      if (view == null) {
        break missingId;
      }

      return new CardViewUserRealtyBinding((MaterialCardView) rootView, circularImageView,
          materialTextView, materialTextView2, materialTextView3, materialTextView4,
          materialTextView5, tvAvgShareCapital, tvCustomNumber, tvRealtyAddress, tvRealtyName,
          tvRealtyType, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
