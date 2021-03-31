package com.sh.wm.ministry.featuers.home.homeFiles;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.repository.AlarmFormRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.model.InspectorModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFilesRepository {


    private Application application;
    private NetworkUtils networkUtils;
    private static HomeFilesRepository mInstance;
    private MutableLiveData<Construction> constructionMutableLiveData;
    private MutableLiveData<PalLawModel> palLawMutableLiveData;
    private MutableLiveData<ConstructByName> constructByNameMutableLiveData;
    private MutableLiveData<InspectorModel> inspectorsMutableLiveData;
    private MutableLiveData<ConstructionGroup> constructionGroupMutableLiveData;


    private static final String TAG = AlarmFormRepository.class.getSimpleName();

    public HomeFilesRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        constructionMutableLiveData = new MutableLiveData<>();
        constructByNameMutableLiveData = new MutableLiveData<>();
        palLawMutableLiveData = new MutableLiveData<>();
        inspectorsMutableLiveData = new MutableLiveData<>();
        constructionGroupMutableLiveData = new MutableLiveData<>();

    }

    public static HomeFilesRepository getInstance(Application application) {

        if (mInstance == null) {
            mInstance = new HomeFilesRepository(application);
        }
        return mInstance;
    }


    public LiveData<ConstructByName> getConstruct(String number) {
        networkUtils.getApiInterface().getConstructByName(number).enqueue(new Callback<ConstructByName>() {
            @Override
            public void onResponse(Call<ConstructByName> call, Response<ConstructByName> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: 1 " + response.body());
                    constructByNameMutableLiveData.setValue(response.body());
                } else {
                    Log.d(TAG, "onResponse:  2" + " no data");
                    constructByNameMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ConstructByName> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                constructByNameMutableLiveData.setValue(null);
            }
        });

        return constructByNameMutableLiveData;
    }




    public LiveData<ConstructionGroup> getConstructByNumber(String number) {
        networkUtils.getApiInterface().getDataConstruction(number).enqueue(new Callback<ConstructionGroup>() {
            @Override
            public void onResponse(Call<ConstructionGroup> call, Response<ConstructionGroup> response) {
                if (response.isSuccessful()) {

                    constructionGroupMutableLiveData.setValue(response.body());
                } else {

                    constructionGroupMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ConstructionGroup> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                constructByNameMutableLiveData.setValue(null);
            }
        });

        return constructionGroupMutableLiveData;
    }

    public LiveData<PalLawModel> getPalLawByNum(String numberLaw) {
        networkUtils.getApiInterface().getPalLaw(numberLaw).enqueue(new Callback<PalLawModel>() {
            @Override
            public void onResponse(Call<PalLawModel> call, Response<PalLawModel> response) {


                if (response.isSuccessful()) {
                    palLawMutableLiveData.setValue(response.body());
                } else {

                    palLawMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PalLawModel> call, Throwable t) {
                Log.d(TAG, "onResponse:  " + t.getMessage());
                palLawMutableLiveData.setValue(null);
            }
        });
        return palLawMutableLiveData;
    }



    public LiveData<InspectorModel> getInspectors() {
        networkUtils.getApiInterface().getInspectors().enqueue(new Callback<InspectorModel>() {
            @Override
            public void onResponse(Call<InspectorModel> call, Response<InspectorModel> response) {


                if (response.isSuccessful()) {
                    inspectorsMutableLiveData.setValue(response.body());
                } else {

                    inspectorsMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<InspectorModel> call, Throwable t) {
                Log.d(TAG, "onResponse:  " + t.getMessage());
                inspectorsMutableLiveData.setValue(null);
            }
        });
        return inspectorsMutableLiveData;
    }

}
