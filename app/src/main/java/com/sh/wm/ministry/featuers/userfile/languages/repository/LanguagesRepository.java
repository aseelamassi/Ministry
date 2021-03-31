package com.sh.wm.ministry.featuers.userfile.languages.repository;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguageActionsModel;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguagesModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.io.File;
import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class LanguagesRepository {

    private static LanguagesRepository mInstance;
    private final String TAG = LanguagesRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserLanguagesModel> userLanguagesModelMutableLiveData;
    private MutableLiveData<UserLanguageActionsModel> userActionLanguagesModelMutableLiveData;
    Application application;

    private LanguagesRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        userLanguagesModelMutableLiveData = new MutableLiveData<>();
        userActionLanguagesModelMutableLiveData = new MutableLiveData<>();

    }

    public static LanguagesRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new LanguagesRepository(application);
        }
        return mInstance;
    }

    //get user languages
    public LiveData<UserLanguagesModel> getUserLanguages() {//SharedPreferneceHelper.getUserId(application) "831504"
        networkUtils.getApiInterface().getUserLanguages(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<UserLanguagesModel>() {
            @Override
            public void onResponse(Call<UserLanguagesModel> call, Response<UserLanguagesModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userLanguagesModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userLanguagesModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserLanguagesModel> call, Throwable t) {
                userLanguagesModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.no_internet), Toast.LENGTH_SHORT).show();

            }
        });
        return userLanguagesModelMutableLiveData;
    }

    //add user language
    public LiveData<UserLanguageActionsModel> addUserLanguages(String action, String userId, String langId, String readPer,
                                                               String writePer,
                                                               String conversationPer,String certificatePath) {
        networkUtils.getApiInterface().insertLanguage(action , userId,langId,readPer,writePer,conversationPer,certificatePath).enqueue(new Callback<UserLanguageActionsModel>() {
            @Override
            public void onResponse(Call<UserLanguageActionsModel> call, Response<UserLanguageActionsModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userActionLanguagesModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userActionLanguagesModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UserLanguageActionsModel> call, Throwable t) {
                userActionLanguagesModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
        return userActionLanguagesModelMutableLiveData;
    }





    //add user language
    public LiveData<UserLanguageActionsModel> updateUserLanguages(HashMap<String , RequestBody> data, MultipartBody.Part image ) {
        networkUtils.getApiInterface().updateLanguage(data,image).enqueue(new Callback<UserLanguageActionsModel>() {
            @Override
            public void onResponse(Call<UserLanguageActionsModel> call, Response<UserLanguageActionsModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userActionLanguagesModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    userActionLanguagesModelMutableLiveData.setValue(null);
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UserLanguageActionsModel> call, Throwable t) {
                userActionLanguagesModelMutableLiveData.setValue(null);
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();

            }
        });
        return userActionLanguagesModelMutableLiveData;
    }

}
