// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardViewTrainingProgramItemBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final ImageView circularImageView;

  @NonNull
  public final AppCompatImageButton ibEditTrainProgram;

  @NonNull
  public final MaterialTextView tvFiledFour;

  @NonNull
  public final MaterialTextView tvFiledOne;

  @NonNull
  public final MaterialTextView tvFiledThree;

  @NonNull
  public final MaterialTextView tvFiledTwo;

  @NonNull
  public final MaterialTextView tvTrainDest;

  @NonNull
  public final MaterialTextView tvTrainHour;

  @NonNull
  public final MaterialTextView tvTrainName;

  @NonNull
  public final MaterialTextView tvTrainType;

  @NonNull
  public final View view;

  private CardViewTrainingProgramItemBinding(@NonNull MaterialCardView rootView,
      @NonNull ImageView circularImageView, @NonNull AppCompatImageButton ibEditTrainProgram,
      @NonNull MaterialTextView tvFiledFour, @NonNull MaterialTextView tvFiledOne,
      @NonNull MaterialTextView tvFiledThree, @NonNull MaterialTextView tvFiledTwo,
      @NonNull MaterialTextView tvTrainDest, @NonNull MaterialTextView tvTrainHour,
      @NonNull MaterialTextView tvTrainName, @NonNull MaterialTextView tvTrainType,
      @NonNull View view) {
    this.rootView = rootView;
    this.circularImageView = circularImageView;
    this.ibEditTrainProgram = ibEditTrainProgram;
    this.tvFiledFour = tvFiledFour;
    this.tvFiledOne = tvFiledOne;
    this.tvFiledThree = tvFiledThree;
    this.tvFiledTwo = tvFiledTwo;
    this.tvTrainDest = tvTrainDest;
    this.tvTrainHour = tvTrainHour;
    this.tvTrainName = tvTrainName;
    this.tvTrainType = tvTrainType;
    this.view = view;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CardViewTrainingProgramItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardViewTrainingProgramItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_view_training_program_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardViewTrainingProgramItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.circularImageView;
      ImageView circularImageView = rootView.findViewById(id);
      if (circularImageView == null) {
        break missingId;
      }

      id = R.id.ib_edit_train_program;
      AppCompatImageButton ibEditTrainProgram = rootView.findViewById(id);
      if (ibEditTrainProgram == null) {
        break missingId;
      }

      id = R.id.tv_filed_four;
      MaterialTextView tvFiledFour = rootView.findViewById(id);
      if (tvFiledFour == null) {
        break missingId;
      }

      id = R.id.tv_filed_one;
      MaterialTextView tvFiledOne = rootView.findViewById(id);
      if (tvFiledOne == null) {
        break missingId;
      }

      id = R.id.tv_filed_three;
      MaterialTextView tvFiledThree = rootView.findViewById(id);
      if (tvFiledThree == null) {
        break missingId;
      }

      id = R.id.tv_filed_two;
      MaterialTextView tvFiledTwo = rootView.findViewById(id);
      if (tvFiledTwo == null) {
        break missingId;
      }

      id = R.id.tv_train_dest;
      MaterialTextView tvTrainDest = rootView.findViewById(id);
      if (tvTrainDest == null) {
        break missingId;
      }

      id = R.id.tv_train_hour;
      MaterialTextView tvTrainHour = rootView.findViewById(id);
      if (tvTrainHour == null) {
        break missingId;
      }

      id = R.id.tv_train_name;
      MaterialTextView tvTrainName = rootView.findViewById(id);
      if (tvTrainName == null) {
        break missingId;
      }

      id = R.id.tv_train_type;
      MaterialTextView tvTrainType = rootView.findViewById(id);
      if (tvTrainType == null) {
        break missingId;
      }

      id = R.id.view;
      View view = rootView.findViewById(id);
      if (view == null) {
        break missingId;
      }

      return new CardViewTrainingProgramItemBinding((MaterialCardView) rootView, circularImageView,
          ibEditTrainProgram, tvFiledFour, tvFiledOne, tvFiledThree, tvFiledTwo, tvTrainDest,
          tvTrainHour, tvTrainName, tvTrainType, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
