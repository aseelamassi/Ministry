package com.sh.wm.ministry.featuers.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.HomeFragment;
import com.sh.wm.ministry.featuers.home.OnFragmentInteractionListener;
import com.sh.wm.ministry.featuers.main.adapter.FloatingMenuAdapter;
import com.sh.wm.ministry.featuers.main.modelMain.NavigationModel;
import com.sh.wm.ministry.featuers.sso.SsoLoginActivity;
import com.sh.wm.ministry.featuers.userfile.UserFileViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.ApiConstent;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnHomeFragmentInteractionListener, OnFragmentInteractionListener {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout sideDrawer;
    private AppCompatImageButton sideButton;
    private CoordinatorLayout.LayoutParams params;
    public NavController navController;
    private static boolean isDrawerVisiable;
    private ListView listView;
    private UserFileViewModel viewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup viewModel
        viewModel = new ViewModelProvider(this).get(UserFileViewModel.class);





        sideDrawer = findViewById(R.id.side_drawer_layout);
        sideButton = findViewById(R.id.btn_side_menu);
        params = (CoordinatorLayout.LayoutParams) sideButton.getLayoutParams();

        setSupportActionBar(findViewById(R.id.toolbar));
        MaterialTextView toolbarTitle = findViewById(R.id.toolbar_title);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.major_services);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.main_nav_view);

        //set user name in navigation header
        View headerLayout = navigationView.getHeaderView(0);
        TextView usernametV = headerLayout.findViewById(R.id.tv_username_header);
        usernametV.setText(SharedPreferneceHelper.getUserName(this));
        ImageView userImage = headerLayout.findViewById(R.id.img_userImg_header);
        if (!SharedPreferneceHelper.getUserImg(this).equals("Empty")) {
            System.out.println(SharedPreferneceHelper.getUserImg(this));
            String img=SharedPreferneceHelper.getUserImg(this);
            byte[] decodedString = Base64.decode(img, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            userImage.setImageBitmap(decodedByte);
        }

//
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_home, R.id.nav_address_contact, R.id.nav_signout, R.id.nav_major_services)
                    .setDrawerLayout(drawer)
                    .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        String[] navItemTitle = getResources().getStringArray(R.array.nav_item_name);
        String[] navItemImage = getResources().getStringArray(R.array.nav_item_image);
        ArrayList<NavigationModel> list = new ArrayList<>();
        for (int i = 0; i < navItemTitle.length; i++) {
            NavigationModel models = new NavigationModel(navItemImage[i], navItemTitle[i]);
            list.add(models);
        }
        listView = findViewById(R.id.lv_float_menu);
        FloatingMenuAdapter adapter = new FloatingMenuAdapter(this, list);
        listView.setAdapter(adapter);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.nav_home)  {
                toolbarTitle.setText(R.string.menu_home);
                closeDrawer();
                sideButton.setVisibility(View.GONE);
                sideDrawer.setVisibility(View.GONE);
            }else if(destination.getId() == R.id.nav_move_facility || destination.getId() == R.id.nav_new_work_place || destination.getId() == R.id.nav_leaving_work_place || destination.getId() == R.id.nav_add_complaint || destination.getId() == R.id.nav_right_calculation || destination.getId() == R.id.nav_holland_main
            ||destination.getId() == R.id.nav_legal_action || destination.getId() == R.id.nav_adjustment_report || destination.getId() == R.id.nav_alarm_form || destination.getId() == R.id.nav_close_facility || destination.getId() == R.id.nav_holland_basic_data
            ||destination.getId() == R.id.nav_holland_activities ||destination.getId() == R.id.nav_holland_careers || destination.getId() == R.id.nav_holland_dream_career || destination.getId() == R.id.nav_holland_skills||destination.getId() == R.id.nav_holland_result || destination.getId() == R.id.nav_holland_evaluation
            ||destination.getId() == R.id.nav_inspection || destination.getId() == R.id.nav_store_inspection_result || destination.getId() == R.id.nav_revisit || destination.getId() == R.id.nav_recommendation || destination.getId() == R.id.nav_additional_services || destination.getId() == R.id.nav_first_additional_services        ){

                sideButton.setVisibility(View.GONE);

            }
            else {
                toolbarTitle.setText(R.string.menu_user_file);
                sideButton.setVisibility(View.VISIBLE);
            }
        });

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            toolbarTitle.setText(destination.getLabel());
            switch (destination.getId()) {
                case R.id.nav_major_services:
                    listView.setItemChecked(0, true);
                    break;
            }
        });

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            listView.setItemChecked(i, true);
            switch (i) {
                case 0:
                    navController.popBackStack();
                    navController.navigate(R.id.nav_major_services);
                    break;
                case 1:
                    navController.popBackStack();
                    navController.navigate(R.id.nav_address_contact);
                    break;
                case 2:
                    navController.popBackStack();
                    navController.navigate(R.id.nav_healh);
                    break;
                case 3:
                    navController.popBackStack();
                    navController.navigate(R.id.nav_dependents);
                    break;
                case 4:
                    navController.popBackStack();
                    navController.navigate(R.id.nav_educational_status);
                    break;
                case 5:
                    navController.popBackStack();
                    navController.navigate(R.id.nav_training_programs);
                    break;
                case 6:
                    navController.popBackStack();
                    navController.navigate(R.id.nav_work_experience);
                    break;
                case 7:
                    navController.popBackStack();
                    navController.navigate(R.id.nav_career);
                    break;
                case 8:
                    navController.popBackStack();
                    navController.navigate(R.id.nav_languages);
                    break;
                case 9:
                    navController.popBackStack();
                    navController.navigate(R.id.nav_practical_status);
                    break;
                case 10:
                    navController.popBackStack();
                    navController.navigate(R.id.trainingSkillsFragment);
                    break;
                case 11 :
                    navController.popBackStack();
                    navController.navigate(R.id.travelFragment);
                    break;
                case 12:
                    navController.popBackStack();
                    navController.navigate(R.id.partnerFragment);
                    break;
                case 13:
                    navController.popBackStack();
                    navController.navigate(R.id.familyMemberFragment);
                    break;
                case 14:
                    navController.popBackStack();
                    navController.navigate(R.id.vehicle);
                    break;

                case 15:
                    navController.popBackStack();
                    navController.navigate(R.id.realty);
                    break;
                case 16:
                    navController.popBackStack();
                    navController.navigate(R.id.supporting_institute);
                    break;

                case 17:
                    navController.popBackStack();
                    navController.navigate(R.id.temp_work);
                    break;

                case 18:
                    navController.popBackStack();
                    navController.navigate(R.id.social_aid);
                    break;
                case 19:
                    navController.popBackStack();
                    navController.navigate(R.id.returning_labor);
                    break;

            }
            closeDrawer();
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this
                , sideDrawer
                , null
                , R.string.navigation_drawer_open
                , R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                sideButton.setImageResource(R.drawable.ic_baseline_arrow_back);
                params.setMarginEnd((int) convertDpToPx());
                sideButton.setLayoutParams(params);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                sideButton.setImageResource(R.drawable.ic_baseline_arrow);
                params.setMarginEnd(0);
                sideButton.setLayoutParams(params);
            }
        };
        sideDrawer.addDrawerListener(toggle);
        toggle.syncState();

        sideButton.setOnClickListener(view -> {
            if (!getSideDrawerVisibility()) {
                sideDrawer.openDrawer(GravityCompat.END);
                sideButton.setImageResource(R.drawable.ic_baseline_arrow_back);
                params.setMarginEnd((int) convertDpToPx());
                sideButton.setLayoutParams(params);
                sideDrawer.setVisibility(View.VISIBLE);
                setSideDrawerVisiability(true);
            } else {
                closeDrawer();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private float convertDpToPx() {
        Resources r = getResources();
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                (float) 94,
                r.getDisplayMetrics()
        );
    }

    private void closeDrawer() {
        sideDrawer.closeDrawer(GravityCompat.END);
        sideButton.setImageResource(R.drawable.ic_baseline_arrow);
        params.setMarginEnd(0);
        sideButton.setLayoutParams(params);
        sideDrawer.setVisibility(View.GONE);
        setSideDrawerVisiability(false);
    }

    @Override
    public void onHomeFragmentInteraction(int cardPos) {
       //main info section
        switch (cardPos) {
            case 1:
                navController.navigate(R.id.nav_home);
                break;
            case 2:
                navController.navigate(R.id.nav_right_calculation);
                break;
            case 3:
                navController.navigate(R.id.nav_add_complaint);
                break;
            case 4:
                navController.navigate(R.id.nav_inspection);
                break;

            case 5 :
                navController.navigate(R.id.nav_holland_main);
                break;
        }
    }

    @Override
    public void onFragmentInteraction(int id) {
        switch (id) {
            case 1:
                navController.navigate(R.id.nav_worker_complaint_form1);
                break;
           //ملف المستخدم
            case 11:
                navController.navigate(R.id.nav_major_services);
                break;

            case 40:
                navController.navigate(R.id.nav_dependents);
                break;
            case 41:
                navController.navigate(R.id.nav_add_dependents);
                break;
            case 50:
                navController.navigate(R.id.nav_educational_status);
break;
            case 51:
                navController.navigate(R.id.nav_add_education);
                break;
            case 61:
                navController.navigate(R.id.nav_add_training_program);
                break;
            case 71:
                navController.navigate(R.id.nav_add_work_experience);
                break;
            case 70:
                navController.navigate(R.id.nav_work_experience);
                break;
            case 91:
                navController.navigate(R.id.nav_add_language);
                break;
            case 90:
                navController.navigate(R.id.nav_languages);
                break;
            case 10:
                navController.navigate(R.id.nav_add_practical_status);
                break;
            case 101:
                navController.navigate(R.id.nav_practical_status);
                break;

            case 12:
                navController.navigate(R.id.trainingSkillsFragment);
                break;
            case 112:
                navController.navigate(R.id.addTrainingSkillsFragment);
                break;
            case 62:
                navController.navigate(R.id.nav_training_programs);
                break;

            case 171 :
                navController.navigate(R.id.returning_labor);
                break;


            case 172:
                navController.navigate(R.id.add_returning_labor);
                break;

            case  0 :
                navController.navigate(R.id.nav_home);
                break;

            case 180 :
                hollandFragmentsFromPopStack();
                navController.navigate(R.id.nav_holland_main);
                break;

            case 182 :
                hollandFragmentsFromPopStack();
                navController.navigate(R.id.nav_holland_dream_career);

                break;

            case 183 :
                hollandFragmentsFromPopStack();
                navController.navigate(R.id.nav_holland_activities);
                break;
            case 181 :
                hollandFragmentsFromPopStack();
                navController.navigate(R.id.nav_holland_basic_data);
                break;

            case 184 :
                hollandFragmentsFromPopStack();
                navController.navigate(R.id.nav_holland_skills);
                break;

            case 185:
                hollandFragmentsFromPopStack();
                navController.navigate(R.id.nav_holland_careers);
                break;

            case 186:
                hollandFragmentsFromPopStack();
                navController.navigate(R.id.nav_holland_evaluation);
                break;

            case 187:
                hollandFragmentsFromPopStack();
                navController.navigate(R.id.nav_holland_result);
                break;

            case 188:
                navController.navigate(R.id.nav_holland_similar_job);
                break;



        }

    }

    @Override
    public void onFragmentInteraction(int id, Bundle bundle) {
        switch (id) {

            case 180 :
                navController.navigate(R.id.nav_holland_main , bundle);
                break;
            case 181 :
                navController.navigate(R.id.nav_holland_basic_data,bundle);
                break;


            case 72:
                navController.navigate(R.id.nav_add_work_experience, bundle);
                break;
            case 92:
                navController.navigate(R.id.nav_add_language, bundle);
                break;
            case 10:
                navController.navigate(R.id.nav_add_practical_status, bundle);
                break;
            case 13:
                navController.navigate(R.id.nav_update_career,bundle);
                break;
            case 51:
                navController.navigate(R.id.nav_add_education,bundle);

                break;
            case 61:
                navController.navigate(R.id.nav_add_training_program,bundle);
                break;
            case 112 :
                navController.navigate(R.id.addTrainingSkillsFragment,bundle);
                break;
            case 172 :
                navController.navigate(R.id.add_returning_labor,bundle);
                break;
            case 41:
                navController.navigate(R.id.nav_add_dependents,bundle);
                break;

            case 402 :
                navController.navigate(R.id.nav_store_inspection_result,bundle);
                break;

            case 403:
                navController.navigate(R.id.nav_recommendation , bundle);
                break;
            case 404:
                navController.navigate(R.id.nav_revisit , bundle);
                break;
            case 405:
                navController.navigate(R.id.nav_additional_services,bundle);
                break;
            case 406 :
                navController.navigate(R.id.nav_occupational_safety_and_health,bundle);
                break;
            case 407 :
                navController.navigate(R.id.nav_insert_work,bundle);
                break;
            case 400 :
                navController.navigate(R.id.nav_first_additional_services,bundle);
                break;
            case 101:
                navController.navigate(R.id.nav_practical_status, bundle);
                break;

        }
    }

    @Override
    public void onHomeSlideNav(int id) {
        switch (id) {
            case 1:
                navController.navigate(R.id.nav_move_facility);
                break;
            case 2:
                navController.navigate(R.id.nav_new_work_place);
                break;
            case 3:
                navController.navigate(R.id.nav_leaving_work_place);
                break;
            case 4:
                navController.navigate(R.id.nav_alarm_form);
                break;
            case 5:
                navController.navigate(R.id.nav_legal_action);
                break;
            case 6:
                navController.navigate(R.id.nav_close_facility);
                break;
            case 7:
                navController.navigate(R.id.nav_adjustment_report);
                break;




        }
    }

    private void setSideDrawerVisiability(boolean isDrawerVisiable) {
        MainActivity.isDrawerVisiable = isDrawerVisiable;
    }

    private boolean getSideDrawerVisibility() {
        return isDrawerVisiable;
    }


    public void deleteUserData(MenuItem item){
        // Save Login Status
        SharedPreferences.Editor loginEditor = getSharedPreferences(ApiConstent.USER_LOGIN_STATUS, MODE_PRIVATE).edit();
        loginEditor.putBoolean(ApiConstent.USER_LOGIN_STATUS, false);
        loginEditor.apply();
        loginEditor.commit();

        //Save Role
        // 0  قوة عمل
        // 1  مفتش او موظف وزارة
        SharedPreferences.Editor roleEditor = getSharedPreferences(ApiConstent.USER_ROLE, MODE_PRIVATE).edit();
        roleEditor.putInt(ApiConstent.USER_ROLE, 0);
        roleEditor.apply();
        roleEditor.commit();

        //Save Token
        SharedPreferences.Editor userRoleEditor = getSharedPreferences(ApiConstent.AUTH_TOKEN, MODE_PRIVATE).edit();
        userRoleEditor.putString(ApiConstent.AUTH_TOKEN, "Empty");
        userRoleEditor.apply();

        // Save UserName
        SharedPreferences.Editor userNameEditor = getSharedPreferences(ApiConstent.USER_NAME, MODE_PRIVATE).edit();
        userNameEditor.putString(ApiConstent.USER_NAME, "Empty");
        userNameEditor.apply();

        //Save UserId
        SharedPreferences.Editor userIdEditor = getSharedPreferences(ApiConstent.USER_ID, MODE_PRIVATE).edit();
        userIdEditor.putString(ApiConstent.USER_ID, "Empty");
        userIdEditor.apply();
        userIdEditor.commit();


        // Save userImg
        SharedPreferences.Editor userEditor = getSharedPreferences(ApiConstent.USER_IMG, MODE_PRIVATE).edit();
        userEditor.putString(ApiConstent.USER_IMG, "Empty");
        userEditor.apply();
        userEditor.commit();


        startActivity(new Intent(MainActivity.this, SsoLoginActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }



    public void getConstant(String parentId) {
            viewModel.getConstant(parentId);
    }


    private void hollandFragmentsFromPopStack(){
        navController.popBackStack(R.id.nav_holland_evaluation, true);
        navController.popBackStack(R.id.nav_holland_careers, true);
        navController.popBackStack(R.id.nav_holland_skills, true);
        navController.popBackStack(R.id.nav_holland_activities, true);
        navController.popBackStack(R.id.nav_holland_basic_data, true);
        navController.popBackStack(R.id.nav_holland_result, true);
        navController.popBackStack(R.id.nav_holland_dream_career, true);


    }


}