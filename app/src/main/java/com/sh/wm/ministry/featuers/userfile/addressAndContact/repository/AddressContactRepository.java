package com.sh.wm.ministry.featuers.userfile.addressAndContact.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.addressAndContact.model.userworkcontact.UserWorkContactModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressContactRepository {

    private static AddressContactRepository mInstance;
    private final String TAG = AddressContactRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserWorkContactModel> userWorkContactMutableLiveData;
    private MutableLiveData<ActionModel> updateUserMutableLiveData;

    private Application application;
    private AddressContactRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        userWorkContactMutableLiveData = new MutableLiveData<>();
        updateUserMutableLiveData = new MutableLiveData<>();
        this.application = application;
    }

    public static AddressContactRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new AddressContactRepository(application);
        }
        return mInstance;
    }


    // For getting user Contact and address data
    public LiveData<UserWorkContactModel> getUserWorkContact(String userId) {
        networkUtils.getApiInterface().getUserWorkContact(userId).enqueue(new Callback<UserWorkContactModel>() {
            @Override
            public void onResponse(Call<UserWorkContactModel> call, Response<UserWorkContactModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userWorkContactMutableLiveData.setValue(response.body());
                    }
                } else {
                    userWorkContactMutableLiveData.setValue(null);

                }
            }

            @Override
            public void onFailure(Call<UserWorkContactModel> call, Throwable t) {
                Toast.makeText(application, application.getString(R.string.no_internet_to_show), Toast.LENGTH_SHORT).show();
                userWorkContactMutableLiveData.setValue(null);

            }
        });
        return userWorkContactMutableLiveData;
    }


    // for update user contact and address data
    public LiveData<ActionModel> updateUser(String telephone, String mobile1 , String mobile2 , String facebookUrl , String addressDetails , String building, String nearestPlace) {
        networkUtils.getApiInterface().updateUserAddress(telephone, mobile1, mobile2, facebookUrl, addressDetails, building  , nearestPlace).enqueue(new Callback<ActionModel>() {
            @Override
            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        updateUserMutableLiveData.setValue(response.body());
                    }
                } else {
                    updateUserMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.no_internet_to_show), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ActionModel> call, Throwable t) {
                updateUserMutableLiveData.setValue(null);

            }
        });
        return updateUserMutableLiveData;
    }



}
