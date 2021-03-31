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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentEducationalStatusBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final MaterialButton btnAddEductionalstatus;

  @NonNull
  public final FloatingActionButton fabAddNewEductionalstatus;

  @NonNull
  public final LinearLayout llNoDataContainer;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final RecyclerView rvEductionalstatus;

  @NonNull
  public final TextView tvNoEductionalstatus;

  private FragmentEducationalStatusBinding(@NonNull FrameLayout rootView,
      @NonNull MaterialButton btnAddEductionalstatus,
      @NonNull FloatingActionButton fabAddNewEductionalstatus,
      @NonNull LinearLayout llNoDataContainer, @NonNull ProgressBar progress,
      @NonNull RecyclerView rvEductionalstatus, @NonNull TextView tvNoEductionalstatus) {
    this.rootView = rootView;
    this.btnAddEductionalstatus = btnAddEductionalstatus;
    this.fabAddNewEductionalstatus = fabAddNewEductionalstatus;
    this.llNoDataContainer = llNoDataContainer;
    this.progress = progress;
    this.rvEductionalstatus = rvEductionalstatus;
    this.tvNoEductionalstatus = tvNoEductionalstatus;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentEducationalStatusBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentEducationalStatusBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_educational_status, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentEducationalStatusBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_add_eductionalstatus;
      MaterialButton btnAddEductionalstatus = rootView.findViewById(id);
      if (btnAddEductionalstatus == null) {
        break missingId;
      }

      id = R.id.fab_add_new_eductionalstatus;
      FloatingActionButton fabAddNewEductionalstatus = rootView.findViewById(id);
      if (fabAddNewEductionalstatus == null) {
        break missingId;
      }

      id = R.id.ll_no_data_container;
      LinearLayout llNoDataContainer = rootView.findViewById(id);
      if (llNoDataContainer == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = rootView.findViewById(id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.rv_eductionalstatus;
      RecyclerView rvEductionalstatus = rootView.findViewById(id);
      if (rvEductionalstatus == null) {
        break missingId;
      }

      id = R.id.tv_no_eductionalstatus;
      TextView tvNoEductionalstatus = rootView.findViewById(id);
      if (tvNoEductionalstatus == null) {
        break missingId;
      }

      return new FragmentEducationalStatusBinding((FrameLayout) rootView, btnAddEductionalstatus,
          fabAddNewEductionalstatus, llNoDataContainer, progress, rvEductionalstatus,
          tvNoEductionalstatus);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
