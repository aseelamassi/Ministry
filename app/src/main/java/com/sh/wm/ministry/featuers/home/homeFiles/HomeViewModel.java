package com.sh.wm.ministry.featuers.home.homeFiles;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.ConstructModel;
import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.repository.LeavingWorkplaceRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.viewmodel.LeavingWorkPlaceViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.repository.AlarmFormRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.viewmodel.AlarmFormViewModel;
import com.sh.wm.ministry.featuers.home.homeFiles.model.InspectorModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.repositiory.HomeRepository;
import com.sh.wm.ministry.network.database.dbModels.directors.Director;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality;
import com.sh.wm.ministry.network.database.dbModels.regions.Region;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    public static final String TAG = AlarmFormViewModel.class.getSimpleName();
    HomeFilesRepository homeRepository;
    LeavingWorkplaceRepository leavingWorkplaceRepository ;
    DBRepository repository ;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        homeRepository = HomeFilesRepository.getInstance(application);
        leavingWorkplaceRepository = LeavingWorkplaceRepository.getInstance(application);
        repository = DBRepository.getInstance(application);
    }

    public LiveData<ConstructModel> getWorkerConstruct(){
        return leavingWorkplaceRepository.getWorkerConstruct();
    }


    public LiveData<PalLawModel> getPalLaw(String num_law) {

        return homeRepository.getPalLawByNum(num_law);

    }


    public LiveData<ConstructionGroup> getConstructByNumber(String number){
        return homeRepository.getConstructByNumber(number);
    }

    public LiveData<ConstructByName> getConstruct(String number) {
        return homeRepository.getConstruct(number);
    }

    public LiveData<InspectorModel> getInspectors() {
        return homeRepository.getInspectors();
    }



    public LiveData<List<Municipality>> getAllMunicipalities(String directorId) {
        return repository.getAllMunicipalities(directorId);
    }

    public LiveData<List<Region>> getAllRegions(String directorateId) {
        return repository.getAllRegions( directorateId);
    }


    public LiveData<List<Director>> getAllDirectors() {
        return repository.getAllDirectors();
    }

}
