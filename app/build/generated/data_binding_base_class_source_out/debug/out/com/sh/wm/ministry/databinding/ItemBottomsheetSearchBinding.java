// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemBottomsheetSearchBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView constructionName;

  @NonNull
  public final TextView constructionNumber;

  private ItemBottomsheetSearchBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView constructionName, @NonNull TextView constructionNumber) {
    this.rootView = rootView;
    this.constructionName = constructionName;
    this.constructionNumber = constructionNumber;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemBottomsheetSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemBottomsheetSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_bottomsheet_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemBottomsheetSearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.construction_name;
      TextView constructionName = rootView.findViewById(id);
      if (constructionName == null) {
        break missingId;
      }

      id = R.id.construction_number;
      TextView constructionNumber = rootView.findViewById(id);
      if (constructionNumber == null) {
        break missingId;
      }

      return new ItemBottomsheetSearchBinding((RelativeLayout) rootView, constructionName,
          constructionNumber);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}