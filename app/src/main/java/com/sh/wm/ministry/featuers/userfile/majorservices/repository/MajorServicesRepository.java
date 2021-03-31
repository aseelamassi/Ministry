package com.sh.wm.ministry.featuers.userfile.majorservices.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.custem.ToastMsg;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MajorServicesRepository {

    private static MajorServicesRepository mInstance;
    private NetworkUtils networkUtils;
    private MutableLiveData<UserInfoModel> userInfoMutableLiveData;
    private MutableLiveData<UpdateUser> userNationalityMutableLiveData;

    private  Application application ;
    private MajorServicesRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        userInfoMutableLiveData = new MutableLiveData<>();
        userNationalityMutableLiveData = new MutableLiveData<>();
    }

    public static MajorServicesRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new MajorServicesRepository(application);
        }
        return mInstance;
    }


    //getting user info data from API
    public LiveData<UserInfoModel> getUserInfo() {
        networkUtils.getApiInterface().getUserInfo().enqueue(new Callback<UserInfoModel>() {
            @Override
            public void onResponse(Call<UserInfoModel> call, Response<UserInfoModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userInfoMutableLiveData.setValue(response.body());
                    }
                } else {
                    userInfoMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<UserInfoModel> call, Throwable t) {
                userInfoMutableLiveData.setValue(null);
            }
        });
        return userInfoMutableLiveData;
    }



    // update user other nationality and directory if is not added before
    public LiveData<UpdateUser> updateUserNationality(String nationalityId, String otherNationalityId , String directoryBelong) {
        networkUtils.getApiInterface().updateUserNationality(nationalityId,otherNationalityId,directoryBelong).enqueue(new Callback<UpdateUser>() {
            @Override
            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userNationalityMutableLiveData.setValue(response.body());
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_LONG).show();

                    }
                } else {
                    userNationalityMutableLiveData.setValue(null);
                    Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UpdateUser> call, Throwable t) {
                userNationalityMutableLiveData.setValue(null);

            }
        });
        return userNationalityMutableLiveData;
    }




}
