package com.sh.wm.ministry.featuers.userfile.socialAid.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.socialAid.model.SocialAidModel;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.travel.repository.TravelRepository;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SocialAidRepository {

    private static SocialAidRepository mInstance;
    private final String TAG = SocialAidRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<SocialAidModel> socialAidModelMutableLiveData;
    private Application application ;

    private SocialAidRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        socialAidModelMutableLiveData = new MutableLiveData<>();
    }

    public static SocialAidRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new SocialAidRepository(application);
        }
        return mInstance;
    }


    public LiveData<SocialAidModel> getSocialAid() {//SharedPreferneceHelper.getUserId(application)
        networkUtils.getApiInterface().getSocialAid(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<SocialAidModel>() {
            @Override
            public void onResponse(Call<SocialAidModel> call, Response<SocialAidModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        socialAidModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    socialAidModelMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<SocialAidModel> call, Throwable t) {
                socialAidModelMutableLiveData.setValue(null);

            }
        });
        return socialAidModelMutableLiveData;
    }


}
