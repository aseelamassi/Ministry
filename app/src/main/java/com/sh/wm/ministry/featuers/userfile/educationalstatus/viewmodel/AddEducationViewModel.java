package com.sh.wm.ministry.featuers.userfile.educationalstatus.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.repository.EducationalStatusRepository;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbModels.eduDepartmentAndProgram.EduDepartmentsAndProgramModel;
import com.sh.wm.ministry.network.database.dbModels.eduQualification.EduQualification;
import com.sh.wm.ministry.network.database.dbModels.eduQualificationDetail.EduQualificationDetail;
import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgram;
import com.sh.wm.ministry.network.database.dbModels.jobList.ResultModel;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.List;


public class AddEducationViewModel extends AndroidViewModel {

    private EducationalStatusRepository repository;
    private DBRepository dbRepository;

    public AddEducationViewModel(@NonNull Application application) {
        super(application);
        repository = EducationalStatusRepository.getInstance(application);
        dbRepository = DBRepository.getInstance(application);
    }





    public LiveData<List<EduQualification>> getEduQualification(String eduTypeId) {
        return dbRepository.getAllEduQualification(eduTypeId);
    }

    public LiveData<List<EduProgram>> getEduPrograms() {
        return dbRepository.getAllEduPrograms();
    }
    public LiveData<ResultModel> getEducationalInstitute(String keyword){
        return  repository.getEducationalInstitute(keyword);
    }

    public LiveData<ResultModel> getEducationalSpec(String keyword){
        return  repository.getEducationalSpec(keyword);
    }

    public LiveData<ActionModel> educationalStatusAction(String action , String userId, String userEduId , String eduTypeId, String eduStatusId , String instituteId , String qualificationId , String qualificationDesc , String programId , String departmentId , String specializationId , String graduationYear , String countryId, String average , String rateId, String isLicense , String certificateNo , String certificateDate){
        return repository.educationalStatusAction(action, userId, userEduId, eduTypeId, eduStatusId, instituteId, qualificationId, qualificationDesc, programId, departmentId, specializationId, graduationYear, countryId, average, rateId, isLicense, certificateNo, certificateDate);
    }

    public LiveData<List<EduQualificationDetail>> getAllEduQualificationDetail(String eduTypeId){
        return dbRepository.getAllEduQualificationDetail(eduTypeId);
    }

    public LiveData<EduDepartmentsAndProgramModel> getEduDepartmentsAndProgram(String specId){
        return repository.getEduDepartmentsAndProgram(specId);
    }


    }
