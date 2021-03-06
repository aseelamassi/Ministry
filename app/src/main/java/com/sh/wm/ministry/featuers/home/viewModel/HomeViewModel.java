package com.sh.wm.ministry.featuers.home.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sh.wm.ministry.featuers.home.model.CertificateRequest;
import com.sh.wm.ministry.featuers.home.repositiory.HomeRepository;

import java.io.InputStream;

import okhttp3.ResponseBody;

public class HomeViewModel extends AndroidViewModel {
    private HomeRepository repository;
    private MutableLiveData<String> userRole;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = HomeRepository.getInstance(application);
    }



    public LiveData<CertificateRequest> requestCertificate(String user_id){
        return repository.requestCertificate(user_id);
    }

}