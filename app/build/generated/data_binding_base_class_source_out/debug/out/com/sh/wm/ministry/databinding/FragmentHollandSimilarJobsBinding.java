// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHollandSimilarJobsBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView btnNext;

  @NonNull
  public final ImageView btnPrev;

  @NonNull
  public final Button btnSave;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final LinearLayout llContainer;

  @NonNull
  public final RecyclerView rvJobListSimilar;

  @NonNull
  public final NestedScrollView scroll;

  @NonNull
  public final TextView tvHighest;

  @NonNull
  public final TextView tvJobListIdentical;

  @NonNull
  public final TextView tvJobListIdenticalLabel;

  @NonNull
  public final TextView tvJobListSimilar;

  @NonNull
  public final TextView tvJobListSimilarEmpty;

  @NonNull
  public final TextView tvLabel;

  @NonNull
  public final TextView tvSecond;

  @NonNull
  public final TextView tvThird;

  private FragmentHollandSimilarJobsBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView btnNext, @NonNull ImageView btnPrev, @NonNull Button btnSave,
      @NonNull CardView cardView, @NonNull LinearLayout llContainer,
      @NonNull RecyclerView rvJobListSimilar, @NonNull NestedScrollView scroll,
      @NonNull TextView tvHighest, @NonNull TextView tvJobListIdentical,
      @NonNull TextView tvJobListIdenticalLabel, @NonNull TextView tvJobListSimilar,
      @NonNull TextView tvJobListSimilarEmpty, @NonNull TextView tvLabel,
      @NonNull TextView tvSecond, @NonNull TextView tvThird) {
    this.rootView = rootView;
    this.btnNext = btnNext;
    this.btnPrev = btnPrev;
    this.btnSave = btnSave;
    this.cardView = cardView;
    this.llContainer = llContainer;
    this.rvJobListSimilar = rvJobListSimilar;
    this.scroll = scroll;
    this.tvHighest = tvHighest;
    this.tvJobListIdentical = tvJobListIdentical;
    this.tvJobListIdenticalLabel = tvJobListIdenticalLabel;
    this.tvJobListSimilar = tvJobListSimilar;
    this.tvJobListSimilarEmpty = tvJobListSimilarEmpty;
    this.tvLabel = tvLabel;
    this.tvSecond = tvSecond;
    this.tvThird = tvThird;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHollandSimilarJobsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHollandSimilarJobsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_holland_similar_jobs, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHollandSimilarJobsBinding bind(@NonNull View rootView) {
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

      id = R.id.cardView;
      CardView cardView = rootView.findViewById(id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.ll_container;
      LinearLayout llContainer = rootView.findViewById(id);
      if (llContainer == null) {
        break missingId;
      }

      id = R.id.rv_job_list_similar;
      RecyclerView rvJobListSimilar = rootView.findViewById(id);
      if (rvJobListSimilar == null) {
        break missingId;
      }

      id = R.id.scroll;
      NestedScrollView scroll = rootView.findViewById(id);
      if (scroll == null) {
        break missingId;
      }

      id = R.id.tv_highest;
      TextView tvHighest = rootView.findViewById(id);
      if (tvHighest == null) {
        break missingId;
      }

      id = R.id.tv_job_list_identical;
      TextView tvJobListIdentical = rootView.findViewById(id);
      if (tvJobListIdentical == null) {
        break missingId;
      }

      id = R.id.tv_job_list_identical_label;
      TextView tvJobListIdenticalLabel = rootView.findViewById(id);
      if (tvJobListIdenticalLabel == null) {
        break missingId;
      }

      id = R.id.tv_job_list_similar;
      TextView tvJobListSimilar = rootView.findViewById(id);
      if (tvJobListSimilar == null) {
        break missingId;
      }

      id = R.id.tv_job_list_similar_empty;
      TextView tvJobListSimilarEmpty = rootView.findViewById(id);
      if (tvJobListSimilarEmpty == null) {
        break missingId;
      }

      id = R.id.tv_label;
      TextView tvLabel = rootView.findViewById(id);
      if (tvLabel == null) {
        break missingId;
      }

      id = R.id.tv_second;
      TextView tvSecond = rootView.findViewById(id);
      if (tvSecond == null) {
        break missingId;
      }

      id = R.id.tv_third;
      TextView tvThird = rootView.findViewById(id);
      if (tvThird == null) {
        break missingId;
      }

      return new FragmentHollandSimilarJobsBinding((RelativeLayout) rootView, btnNext, btnPrev,
          btnSave, cardView, llContainer, rvJobListSimilar, scroll, tvHighest, tvJobListIdentical,
          tvJobListIdenticalLabel, tvJobListSimilar, tvJobListSimilarEmpty, tvLabel, tvSecond,
          tvThird);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
