package com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.model.SupportingInstituteModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SupportingInstituteRepository {

    private static SupportingInstituteRepository mInstance;
    private final String TAG = SupportingInstituteRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<SupportingInstituteModel> supportingInstituteModelMutableLiveData;
    private Application application ;

    private SupportingInstituteRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        supportingInstituteModelMutableLiveData = new MutableLiveData<>();
    }

    public static SupportingInstituteRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new SupportingInstituteRepository(application);
        }
        return mInstance;
    }


    public LiveData<SupportingInstituteModel> getSupportingInstitutes() {
        networkUtils.getApiInterface().getSupportingInstitute().enqueue(new Callback<SupportingInstituteModel>() {
            @Override
            public void onResponse(Call<SupportingInstituteModel> call, Response<SupportingInstituteModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        supportingInstituteModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    supportingInstituteModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SupportingInstituteModel> call, Throwable t) {
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
        return supportingInstituteModelMutableLiveData;
    }
}
