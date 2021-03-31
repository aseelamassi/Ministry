// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AlertDialogCardviewBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final TextView btnCancel;

  @NonNull
  public final TextView btnSave;

  @NonNull
  public final TextView textView;

  private AlertDialogCardviewBinding(@NonNull MaterialCardView rootView,
      @NonNull TextView btnCancel, @NonNull TextView btnSave, @NonNull TextView textView) {
    this.rootView = rootView;
    this.btnCancel = btnCancel;
    this.btnSave = btnSave;
    this.textView = textView;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static AlertDialogCardviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AlertDialogCardviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.alert_dialog_cardview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AlertDialogCardviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_cancel;
      TextView btnCancel = rootView.findViewById(id);
      if (btnCancel == null) {
        break missingId;
      }

      id = R.id.btn_save;
      TextView btnSave = rootView.findViewById(id);
      if (btnSave == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = rootView.findViewById(id);
      if (textView == null) {
        break missingId;
      }

      return new AlertDialogCardviewBinding((MaterialCardView) rootView, btnCancel, btnSave,
          textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}