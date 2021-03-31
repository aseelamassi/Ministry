package com.sh.wm.ministry.featuers.userfile.familyMember.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.familyMember.model.UserFamilyModel;
import com.sh.wm.ministry.featuers.userfile.travel.repository.TravelRepository;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyMemberRepository {

    private static FamilyMemberRepository mInstance;

    private NetworkUtils networkUtils;
    private MutableLiveData<UserFamilyModel> userFamilyModelMutableLiveData;
    private Application application ;

    private FamilyMemberRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        userFamilyModelMutableLiveData = new MutableLiveData<>();
    }

    public static FamilyMemberRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new FamilyMemberRepository(application);
        }
        return mInstance;
    }


    public LiveData<UserFamilyModel> getUserFamilyMember() {//SharedPreferneceHelper.getUserId(application)
        networkUtils.getApiInterface().getUserFamilyMember().enqueue(new Callback<UserFamilyModel>() {
            @Override
            public void onResponse(Call<UserFamilyModel> call, Response<UserFamilyModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userFamilyModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userFamilyModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UserFamilyModel> call, Throwable t) {
                userFamilyModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.no_internet_to_show), Toast.LENGTH_SHORT).show();

            }
        });
        return userFamilyModelMutableLiveData;
    }

}
