package com.sh.wm.ministry.featuers.userfile.partner.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.partner.model.Partner;
import com.sh.wm.ministry.featuers.userfile.partner.model.PartnerModel;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.travel.repository.TravelRepository;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PartnerRepository {
    private static PartnerRepository mInstance;
    private final String TAG = PartnerRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<PartnerModel> partnerModelMutableLiveData;
    private Application application ;

    private PartnerRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        partnerModelMutableLiveData = new MutableLiveData<>();
    }

    public static PartnerRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new PartnerRepository(application);
        }
        return mInstance;
    }


    public LiveData<PartnerModel> getPartners() {//SharedPreferneceHelper.getUserId(application)
        networkUtils.getApiInterface().getUserPartner(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<PartnerModel>() {
            @Override
            public void onResponse(Call<PartnerModel> call, Response<PartnerModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        partnerModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    partnerModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PartnerModel> call, Throwable t) {
                partnerModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

            }
        });
        return partnerModelMutableLiveData;
    }

}
