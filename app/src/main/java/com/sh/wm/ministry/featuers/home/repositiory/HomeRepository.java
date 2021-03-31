package com.sh.wm.ministry.featuers.home.repositiory;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.home.model.CertificateRequest;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {
    private final NetworkUtils networkUtils;
    private MutableLiveData<CertificateRequest> certificateRequestMutableLiveData;
    private static HomeRepository homeRepository;

    private HomeRepository(Application applicatio) {
        networkUtils = NetworkUtils.getInstance(true, applicatio);
        certificateRequestMutableLiveData = new MutableLiveData<>();

    }

    public static HomeRepository getInstance(Application application) {
        if (homeRepository == null) homeRepository = new HomeRepository(application);
        return homeRepository;
    }

    public LiveData<CertificateRequest> requestCertificate(String user_id) {


        Call<CertificateRequest> call = networkUtils.getApiInterface().requestCertificate(user_id);
        call.enqueue(new Callback<CertificateRequest>() {
            @Override
            public void onResponse(@NotNull Call<CertificateRequest> call, @NotNull Response<CertificateRequest> response) {
                if (response.isSuccessful()) {

                    certificateRequestMutableLiveData.setValue(response.body());
                } else {
                    certificateRequestMutableLiveData.setValue(null);
                }

            }

            @Override
            public void onFailure(@NotNull Call<CertificateRequest> call, @NotNull Throwable t) {

                certificateRequestMutableLiveData.setValue(null);
            }
        });
        return certificateRequestMutableLiveData;
    }


}
