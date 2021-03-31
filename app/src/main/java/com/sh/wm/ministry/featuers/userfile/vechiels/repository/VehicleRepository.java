package com.sh.wm.ministry.featuers.userfile.vechiels.repository;

import android.app.Application;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.travel.repository.TravelRepository;
import com.sh.wm.ministry.featuers.userfile.vechiels.model.UserVehicleModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleRepository {
    private static VehicleRepository mInstance;
    private final String TAG = VehicleRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserVehicleModel> userVehicleDataModelMutableLiveData;
    private Application application ;

    private VehicleRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        userVehicleDataModelMutableLiveData = new MutableLiveData<>();
    }

    public static VehicleRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new VehicleRepository(application);
        }
        return mInstance;
    }


    public LiveData<UserVehicleModel> getUserVehicle() {//SharedPreferneceHelper.getUserId(application)  "16028"
        networkUtils.getApiInterface().getUserVehicle(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<UserVehicleModel>() {
            @Override
            public void onResponse(Call<UserVehicleModel> call, Response<UserVehicleModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userVehicleDataModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userVehicleDataModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UserVehicleModel> call, Throwable t) {
                userVehicleDataModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

            }
        });
        return userVehicleDataModelMutableLiveData;
    }


}
