package com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.Repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.ArchiveModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArchiveRepository {
    private static String TAG = ArchiveRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<ArchiveModel> archiveModelMutableLiveData;
    private static ArchiveRepository repository ;
    Application application ;

    private ArchiveRepository(Application application){
        networkUtils = NetworkUtils.getInstance(true, application);
        this.application= application;
        archiveModelMutableLiveData=new MutableLiveData<>();
    }//end constructor

    public static ArchiveRepository getInstance(Application application){
        if(repository==null) repository=new ArchiveRepository(application);
        return repository;
    }//end getInstance

    public MutableLiveData<ArchiveModel> archiveRequest(){
        Call<ArchiveModel> call= networkUtils.getApiInterface().requestArchive(SharedPreferneceHelper.getUserId(application));
        call.enqueue(new Callback<ArchiveModel>() {
            @Override
            public void onResponse(Call<ArchiveModel> call, Response<ArchiveModel> response) {
                if (response.isSuccessful()) {
                    archiveModelMutableLiveData.setValue(response.body());
                } else {
                    archiveModelMutableLiveData.setValue(null);

                }
            }//END onResponse

            @Override
            public void onFailure(Call<ArchiveModel> call, Throwable t) {

                archiveModelMutableLiveData.setValue(null);

            }//end onFailure
        });
        return archiveModelMutableLiveData;
    }//end archiveRequest
}//end class