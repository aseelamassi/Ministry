package com.sh.wm.ministry.featuers.userfile.languages.viewmodel;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguageActionsModel;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguagesModel;
import com.sh.wm.ministry.featuers.userfile.languages.repository.LanguagesRepository;

import java.io.File;
import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class UserLanguagesViewModel extends AndroidViewModel {
    private LanguagesRepository repository;

    public UserLanguagesViewModel(@NonNull Application application) {
        super(application);
        repository = LanguagesRepository.getInstance(application);
    }

    public LiveData<UserLanguagesModel> getUserLanguages() {
        return repository.getUserLanguages();
    }

    public LiveData<UserLanguageActionsModel> addUserLanguages(String action, String userId, String langId, String readPer,
                                                               String writePer,
                                                               String conversationPer,String certificatePath){
        return repository.addUserLanguages(action, userId, langId, readPer, writePer, conversationPer,certificatePath);
    }


    public LiveData<UserLanguageActionsModel> updateUserLanguages(HashMap<String , RequestBody> data, MultipartBody.Part image ) {

        return repository.updateUserLanguages(data , image);
    }


//    public LiveData<UserLanguageActionsModel> updateUserLanguages(RequestBody action, RequestBody userLangId, RequestBody userId, RequestBody langId, RequestBody readPer,
//                                                                  RequestBody writePer,
//                                                                  RequestBody conversationPer, MultipartBody.Part image){
//        return repository.updateUserLanguages(action,userLangId, userId, langId, readPer, writePer, conversationPer, image);
//    }

}