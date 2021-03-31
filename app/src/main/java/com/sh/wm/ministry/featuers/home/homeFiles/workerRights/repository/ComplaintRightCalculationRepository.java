package com.sh.wm.ministry.featuers.home.homeFiles.workerRights.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.workerRights.model.ComplaintRightsCalculation;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserDependentsModel;
import com.sh.wm.ministry.featuers.userfile.dependents.repository.DependentsRepository;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;


public class ComplaintRightCalculationRepository {

    private static final String TAG = ComplaintRightCalculationRepository.class.getName();
    private static ComplaintRightCalculationRepository sInstance;
    private Application application;
    private MutableLiveData<ComplaintRightsCalculation> complaintRightsCalculationMutableLiveData;
    private MutableLiveData<ConstructByName> constructByNameMutableLiveData;

    private NetworkUtils networkUtils;

    private ComplaintRightCalculationRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        constructByNameMutableLiveData = new MutableLiveData<>();

    }

    public static ComplaintRightCalculationRepository getInstance(Application application) {
        if (sInstance == null) {
            sInstance = new ComplaintRightCalculationRepository(application);
        }
        return sInstance;
    }

    public LiveData<ConstructByName> getConstruct(String number) {
        networkUtils.getApiInterface().getConstructByName(number).enqueue(new Callback<ConstructByName>() {
            @Override
            public void onResponse(Call<ConstructByName> call, Response<ConstructByName> response) {
                if (response.isSuccessful()) {
                    constructByNameMutableLiveData.setValue(response.body());
                } else {
                    constructByNameMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ConstructByName> call, Throwable t) {
                constructByNameMutableLiveData.setValue(null);
            }
        });

        return constructByNameMutableLiveData;
    }









    public LiveData<ComplaintRightsCalculation> complaintRightCalculation( String hoursType ,String salary,
                                                                    String realWorkPeriod ,  String remainingLeaveDays,
                                                                    String periodNotConsidered, String lastBenefit,
                                                                    String cermonies ,  String endWorkType)
    {
        complaintRightsCalculationMutableLiveData = new MutableLiveData<>();
        networkUtils.getApiInterface().complaintRightCalculation(hoursType, salary, realWorkPeriod, remainingLeaveDays, periodNotConsidered, lastBenefit, cermonies, endWorkType).enqueue(new Callback<ComplaintRightsCalculation>() {
            @Override
            public void onResponse(Call<ComplaintRightsCalculation> call, Response<ComplaintRightsCalculation> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        complaintRightsCalculationMutableLiveData.setValue(response.body());
                    }
                } else {
                    complaintRightsCalculationMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ComplaintRightsCalculation> call, Throwable t) {
                complaintRightsCalculationMutableLiveData.setValue(null);
            }
        });
        return complaintRightsCalculationMutableLiveData;
    }





}
