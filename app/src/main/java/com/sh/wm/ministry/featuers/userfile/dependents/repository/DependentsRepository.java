package com.sh.wm.ministry.featuers.userfile.dependents.repository;

import android.app.Application;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.dependents.model.DependentModel;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserDependentsModel;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserWorkerInsertModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DependentsRepository {


    private static DependentsRepository sInstance;
    private Application application;
    private MutableLiveData<UserDependentsModel> userDependentsModelMutableLiveData;
    private MutableLiveData<UserWorkerInsertModel> userWorkerInsertModelMutableLiveData;
    private MutableLiveData<DependentModel> DependentModelMutableLiveData;
    private NetworkUtils networkUtils;

    private DependentsRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);

    }

    public static DependentsRepository getInstance(Application application) {
        if (sInstance == null) {
            sInstance = new DependentsRepository(application);
        }
        return sInstance;
    }


    public LiveData<UserDependentsModel> getUserDependentsModel() {
        userDependentsModelMutableLiveData = new MutableLiveData<>();
        networkUtils.getApiInterface().getUserDependents(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<UserDependentsModel>() {
            @Override
            public void onResponse(Call<UserDependentsModel> call, Response<UserDependentsModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userDependentsModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userDependentsModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UserDependentsModel> call, Throwable t) {
                userDependentsModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

            }
        });
        return userDependentsModelMutableLiveData;
    }

    public LiveData<UserWorkerInsertModel> addDependent( String dependentSn) {
        userWorkerInsertModelMutableLiveData = new MutableLiveData<>();
        networkUtils.getApiInterface().setNewDependents(SharedPreferneceHelper.getUserSn(application), dependentSn).enqueue(new Callback<UserWorkerInsertModel>() {
            @Override
            public void onResponse(Call<UserWorkerInsertModel> call, Response<UserWorkerInsertModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userWorkerInsertModelMutableLiveData.setValue(response.body());
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_SHORT).show();

                    }
                } else {
                    userWorkerInsertModelMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<UserWorkerInsertModel> call, Throwable t) {
                userWorkerInsertModelMutableLiveData.setValue(null);

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
        return userWorkerInsertModelMutableLiveData;
    }



    public LiveData<DependentModel> getDependentData(String userSn, String dependentSn) {
        DependentModelMutableLiveData = new MutableLiveData<>();
        networkUtils.getApiInterface().getDependentGovData(userSn, dependentSn).enqueue(new Callback<DependentModel>() {
            @Override
            public void onResponse(Call<DependentModel> call, Response<DependentModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        DependentModelMutableLiveData.setValue(response.body());
                        if (response.body().getDependentData() == null)
                            Toast.makeText(application, application.getString(R.string.dependent_not_approve), Toast.LENGTH_SHORT).show();

                    }
                } else {
                    DependentModelMutableLiveData.setValue(null);

                        Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DependentModel> call, Throwable t) {
                DependentModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

            }
        });
        return DependentModelMutableLiveData;
    }

}
