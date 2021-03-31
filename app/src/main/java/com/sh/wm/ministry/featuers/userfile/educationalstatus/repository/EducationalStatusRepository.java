package com.sh.wm.ministry.featuers.userfile.educationalstatus.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.model.EducationalStatusModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.network.database.dbModels.eduDepartmentAndProgram.EduDepartmentsAndProgram;
import com.sh.wm.ministry.network.database.dbModels.eduDepartmentAndProgram.EduDepartmentsAndProgramModel;
import com.sh.wm.ministry.network.database.dbModels.eduQualification.EduQualification;
import com.sh.wm.ministry.network.database.dbModels.jobList.ResultModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class EducationalStatusRepository {
    private static final String TAG = EducationalStatusRepository.class.getName();
    private static EducationalStatusRepository sInstance;
    private Application application;
    private MutableLiveData<EducationalStatusModel> educationlStatusModelMutableLiveData;
    private MutableLiveData<ResultModel> resultModelMutableLiveData;
    private MutableLiveData<EduDepartmentsAndProgramModel> eduDepartmentsAndProgramMutableLiveData;
    private NetworkUtils networkUtils;
    private MutableLiveData<ActionModel> updateUserMutableLiveData;

    private EducationalStatusRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);

    }

    public static EducationalStatusRepository getInstance(Application application) {
        if (sInstance == null) {
            sInstance = new EducationalStatusRepository(application);
        }
        return sInstance;
    }

    public LiveData<EducationalStatusModel> getEducationlStatusModelLiveData() {
        educationlStatusModelMutableLiveData = new MutableLiveData<>();

        //for test 831504
        //SharedPreferneceHelper.getUserId(application)
        networkUtils.getApiInterface().getEducationlStatus(SharedPreferneceHelper.getUserId(application)).enqueue(new Callback<EducationalStatusModel>() {
            @Override
            public void onResponse(Call<EducationalStatusModel> call, Response<EducationalStatusModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        educationlStatusModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    educationlStatusModelMutableLiveData.setValue(null);
                    Log.d(TAG, "Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<EducationalStatusModel> call, Throwable t) {
                educationlStatusModelMutableLiveData.setValue(null);
                Log.e(TAG, "Response Failed!");
            }
        });
        return educationlStatusModelMutableLiveData;
    }


    public LiveData<ResultModel> getEducationalInstitute(String keyword) {
        resultModelMutableLiveData = new MutableLiveData<>();

        networkUtils.getApiInterface().getEducationalInstitute(keyword).enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                if (response.body() != null && response.body().getStatus() != 1) {
                    if (response.isSuccessful()) {
                        resultModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    resultModelMutableLiveData.setValue(null);

                }
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                resultModelMutableLiveData.setValue(null);

            }
        });
        return resultModelMutableLiveData;
    }

    public LiveData<ResultModel> getEducationalSpec(String keyword) {
        resultModelMutableLiveData = new MutableLiveData<>();

        networkUtils.getApiInterface().getEducationalSpec(keyword).enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                if (response.body() != null && response.body().getStatus() != 1) {

                        resultModelMutableLiveData.setValue(response.body());

                } else{
                    resultModelMutableLiveData.setValue(null);

                }
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                resultModelMutableLiveData.setValue(null);

            }
        });
        return resultModelMutableLiveData;
    }

    public LiveData<ActionModel> educationalStatusAction(String action , String userId, String userEduId , String eduTypeId, String eduStatusId , String instituteId , String qualificationId , String qualificationDesc , String programId , String departmentId , String specializationId , String graduationYear , String countryId, String average , String rateId, String isLicense , String certificateNo , String certificateDate){

        updateUserMutableLiveData = new MutableLiveData<>();

        networkUtils.getApiInterface().educationalStatusAction(action, userId, userEduId, eduTypeId, eduStatusId, instituteId, qualificationId, qualificationDesc, programId, departmentId, specializationId, graduationYear, countryId, average, rateId, isLicense, certificateNo, certificateDate).enqueue(new Callback<ActionModel>() {
            @Override
            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        updateUserMutableLiveData.setValue(response.body());
                    }
                } else {
                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                    updateUserMutableLiveData.setValue(null);

                }
            }

            @Override
            public void onFailure(Call<ActionModel> call, Throwable t) {
                updateUserMutableLiveData.setValue(null);
            }
        });
        return updateUserMutableLiveData;

    }


    public LiveData<EduDepartmentsAndProgramModel> getEduDepartmentsAndProgram(String specId) {
        eduDepartmentsAndProgramMutableLiveData  = new MutableLiveData<>();
        networkUtils.getApiInterface().getEduDepartmentsAndProgram(specId).enqueue(new Callback<EduDepartmentsAndProgramModel>() {
            @Override
            public void onResponse(Call<EduDepartmentsAndProgramModel> call, Response<EduDepartmentsAndProgramModel> response) {
                if (response.body() != null) {
                    eduDepartmentsAndProgramMutableLiveData.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<EduDepartmentsAndProgramModel> call, Throwable t) {
            }
        });

        return  eduDepartmentsAndProgramMutableLiveData;
    }




}
