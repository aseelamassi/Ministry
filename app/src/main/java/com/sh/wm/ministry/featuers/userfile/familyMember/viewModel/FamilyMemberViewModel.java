package com.sh.wm.ministry.featuers.userfile.familyMember.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.userfile.familyMember.model.UserFamilyModel;
import com.sh.wm.ministry.featuers.userfile.familyMember.repository.FamilyMemberRepository;


public class FamilyMemberViewModel extends AndroidViewModel {

    private FamilyMemberRepository repository ;

    public FamilyMemberViewModel(@NonNull Application application) {
        super(application);
        repository = FamilyMemberRepository.getInstance(application);
    }

    public LiveData<UserFamilyModel> getUserFamilyMember() {
        return repository.getUserFamilyMember();
    }
}
