// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHollandTestActivitiesBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView btnNext;

  @NonNull
  public final ImageView btnPrev;

  @NonNull
  public final Button btnSave;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final RelativeLayout rlButtonsContainer;

  @NonNull
  public final RecyclerView rvActivities;

  @NonNull
  public final TextView tvLabel;

  @NonNull
  public final TextView tvNoInternet;

  private FragmentHollandTestActivitiesBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView btnNext, @NonNull ImageView btnPrev, @NonNull Button btnSave,
      @NonNull ProgressBar progress, @NonNull RelativeLayout rlButtonsContainer,
      @NonNull RecyclerView rvActivities, @NonNull TextView tvLabel,
      @NonNull TextView tvNoInternet) {
    this.rootView = rootView;
    this.btnNext = btnNext;
    this.btnPrev = btnPrev;
    this.btnSave = btnSave;
    this.progress = progress;
    this.rlButtonsContainer = rlButtonsContainer;
    this.rvActivities = rvActivities;
    this.tvLabel = tvLabel;
    this.tvNoInternet = tvNoInternet;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHollandTestActivitiesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHollandTestActivitiesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_holland_test_activities, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHollandTestActivitiesBinding bind(@NonNull View rootView) {
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

      id = R.id.progress;
      ProgressBar progress = rootView.findViewById(id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.rl_buttons_container;
      RelativeLayout rlButtonsContainer = rootView.findViewById(id);
      if (rlButtonsContainer == null) {
        break missingId;
      }

      id = R.id.rv_activities;
      RecyclerView rvActivities = rootView.findViewById(id);
      if (rvActivities == null) {
        break missingId;
      }

      id = R.id.tv_label;
      TextView tvLabel = rootView.findViewById(id);
      if (tvLabel == null) {
        break missingId;
      }

      id = R.id.tv_no_internet;
      TextView tvNoInternet = rootView.findViewById(id);
      if (tvNoInternet == null) {
        break missingId;
      }

      return new FragmentHollandTestActivitiesBinding((RelativeLayout) rootView, btnNext, btnPrev,
          btnSave, progress, rlButtonsContainer, rvActivities, tvLabel, tvNoInternet);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
