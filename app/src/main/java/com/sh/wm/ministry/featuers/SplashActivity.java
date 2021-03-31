package com.sh.wm.ministry.featuers;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.main.MainActivity;
import com.sh.wm.ministry.featuers.sso.SsoLoginActivity;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.util.List;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        String manufacturer = android.os.Build.MANUFACTURER;
//        try {
//            Intent intent = new Intent();
//            if ("xiaomi".equalsIgnoreCase(manufacturer)) {
//                intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
//            } else if ("oppo".equalsIgnoreCase(manufacturer)) {
//                intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
//            } else if ("vivo".equalsIgnoreCase(manufacturer)) {
//                intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
//            } else if ("Letv".equalsIgnoreCase(manufacturer)) {
//                intent.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
//            } else if ("Honor".equalsIgnoreCase(manufacturer)) {
//                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
//            }
//
//            List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
//            if (list.size() > 0) {
//                startActivity(intent);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!isTaskRoot()
                && getIntent().hasCategory(Intent.CATEGORY_LAUNCHER)
                && getIntent().getAction() != null
                && getIntent().getAction().equals(Intent.ACTION_MAIN)) {
            finish();
            return;
        }

        if (SharedPreferneceHelper.isLoggedIn(this)) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, SsoLoginActivity.class));
        }
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();

    }

}