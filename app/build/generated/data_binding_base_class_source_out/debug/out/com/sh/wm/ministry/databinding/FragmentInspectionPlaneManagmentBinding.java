// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentInspectionPlaneManagmentBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView insInspectorName;

  @NonNull
  public final LinearLayout stopResLayout;

  private FragmentInspectionPlaneManagmentBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView insInspectorName, @NonNull LinearLayout stopResLayout) {
    this.rootView = rootView;
    this.insInspectorName = insInspectorName;
    this.stopResLayout = stopResLayout;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentInspectionPlaneManagmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentInspectionPlaneManagmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_inspection_plane_managment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentInspectionPlaneManagmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ins_inspector_name;
      TextView insInspectorName = rootView.findViewById(id);
      if (insInspectorName == null) {
        break missingId;
      }

      id = R.id.stop_res_layout;
      LinearLayout stopResLayout = rootView.findViewById(id);
      if (stopResLayout == null) {
        break missingId;
      }

      return new FragmentInspectionPlaneManagmentBinding((RelativeLayout) rootView,
          insInspectorName, stopResLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}