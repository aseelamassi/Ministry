package com.sh.wm.ministry.featuers.userfile.addressAndContact.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.addressAndContact.model.userworkcontact.UserWorkContactModel;
import com.sh.wm.ministry.featuers.userfile.addressAndContact.repository.AddressContactRepository;



public class AddressAndContactViewModel extends AndroidViewModel {

    private AddressContactRepository repository;

    public AddressAndContactViewModel(@NonNull Application application) {
        super(application);
        repository = AddressContactRepository.getInstance(application);
    }


    //getting user address and contact data
    public LiveData<UserWorkContactModel> userWorkContactLiveData(String userId) {
        return repository.getUserWorkContact(userId);
    }


    //update user address and contact data
    public LiveData<ActionModel> updateUser(String telephone, String mobile1 , String mobile2 , String facebookUrl , String addressDetails , String building  , String nearestPlace){
        return repository.updateUser(telephone, mobile1, mobile2, facebookUrl, addressDetails, building,nearestPlace);
    }



}