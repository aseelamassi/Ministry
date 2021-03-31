// Generated by view binder compiler. Do not edit!
package com.sh.wm.ministry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.sh.wm.ministry.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public final class ActivitySsoLoginBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final MaterialProgressBar pbSsoLogin;

  @NonNull
  public final WebView wvSsoLogin;

  private ActivitySsoLoginBinding(@NonNull FrameLayout rootView,
      @NonNull MaterialProgressBar pbSsoLogin, @NonNull WebView wvSsoLogin) {
    this.rootView = rootView;
    this.pbSsoLogin = pbSsoLogin;
    this.wvSsoLogin = wvSsoLogin;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySsoLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySsoLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sso_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySsoLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.pb_sso_login;
      MaterialProgressBar pbSsoLogin = rootView.findViewById(id);
      if (pbSsoLogin == null) {
        break missingId;
      }

      id = R.id.wv_sso_login;
      WebView wvSsoLogin = rootView.findViewById(id);
      if (wvSsoLogin == null) {
        break missingId;
      }

      return new ActivitySsoLoginBinding((FrameLayout) rootView, pbSsoLogin, wvSsoLogin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}