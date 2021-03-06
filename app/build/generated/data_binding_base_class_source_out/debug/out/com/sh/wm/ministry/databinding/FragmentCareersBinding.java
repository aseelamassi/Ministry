// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCareersBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final LinearLayout LLLayoutUserCareers;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final RecyclerView rvCareer;

  @NonNull
  public final TextView tvNoCareer;

  private FragmentCareersBinding(@NonNull FrameLayout rootView,
      @NonNull LinearLayout LLLayoutUserCareers, @NonNull ProgressBar progress,
      @NonNull RecyclerView rvCareer, @NonNull TextView tvNoCareer) {
    this.rootView = rootView;
    this.LLLayoutUserCareers = LLLayoutUserCareers;
    this.progress = progress;
    this.rvCareer = rvCareer;
    this.tvNoCareer = tvNoCareer;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCareersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCareersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_careers, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCareersBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.LL_layout_user_careers;
      LinearLayout LLLayoutUserCareers = rootView.findViewById(id);
      if (LLLayoutUserCareers == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = rootView.findViewById(id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.rv_career;
      RecyclerView rvCareer = rootView.findViewById(id);
      if (rvCareer == null) {
        break missingId;
      }

      id = R.id.tv_no_career;
      TextView tvNoCareer = rootView.findViewById(id);
      if (tvNoCareer == null) {
        break missingId;
      }

      return new FragmentCareersBinding((FrameLayout) rootView, LLLayoutUserCareers, progress,
          rvCareer, tvNoCareer);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
