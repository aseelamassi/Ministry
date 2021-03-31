package com.sh.wm.ministry.featuers.userfile.career.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.userfile.career.model.UserCareerModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CareerRepository {


    private static CareerRepository mInstance;
    private final String TAG = CareerRepository.class.getName();
    private NetworkUtils networkUtils;
    private MutableLiveData<UserCareerModel> userCareerModelMutableLiveData;
    private MutableLiveData<UpdateUser> actionUserCareerModelMutableLiveData;

    private Application application;

    private CareerRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        userCareerModelMutableLiveData = new MutableLiveData<>();
        actionUserCareerModelMutableLiveData = new MutableLiveData<>();
        this.application = application;
    }

    public static CareerRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new CareerRepository(application);
        }
        return mInstance;
    }


    //get User Career from API
    public LiveData<UserCareerModel> getUserCareers(String userId) {
        networkUtils.getApiInterface().getUserCareers(userId).enqueue(new Callback<UserCareerModel>() {
            @Override
            public void onResponse(Call<UserCareerModel> call, Response<UserCareerModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        userCareerModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    Toast.makeText(application,application.getString(R.string.error) , Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UserCareerModel> call, Throwable t) {
                userCareerModelMutableLiveData.setValue(null);
                Toast.makeText(application,application.getString(R.string.error) , Toast.LENGTH_SHORT).show();

            }
        });
        return userCareerModelMutableLiveData;
    }


    //add new Career
    //it is canceled
    public LiveData<UpdateUser> addCareers(  String careerId ,
                                            String careerLicense , String skillLevelId,
                                           String trainingSideId, String certificateYear,
                                           String qualificationId) {
        networkUtils.getApiInterface().addCareer("insert", careerId, careerLicense, skillLevelId, trainingSideId, certificateYear, qualificationId).enqueue(new Callback<UpdateUser>() {
            @Override
            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        actionUserCareerModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    actionUserCareerModelMutableLiveData.setValue(null);
                    Toast.makeText(application,application.getString(R.string.error) , Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UpdateUser> call, Throwable t) {
                actionUserCareerModelMutableLiveData.setValue(null);
                Toast.makeText(application,application.getString(R.string.error) , Toast.LENGTH_SHORT).show();

            }
        });
        return actionUserCareerModelMutableLiveData;
    }


    //update  Career
    //it is canceled
    public LiveData<UpdateUser> updateCareers( String userCareerId, String careerId ,
                                             String careerLicense , String skillLevelId,
                                             String trainingSideId, String certificateYear,
                                             String priority) {
        networkUtils.getApiInterface().updateCareer("update", userCareerId,careerId, careerLicense, skillLevelId, trainingSideId, certificateYear, priority).enqueue(new Callback<UpdateUser>() {
            @Override
            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                if (response.body() != null) {
                    Toast.makeText(application, response.message(), Toast.LENGTH_SHORT).show();
                    if (response.isSuccessful()) {
                        actionUserCareerModelMutableLiveData.setValue(response.body());
                    }
                } else {
                    actionUserCareerModelMutableLiveData.setValue(null);
                    Toast.makeText(application,application.getString(R.string.error) , Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UpdateUser> call, Throwable t) {
                actionUserCareerModelMutableLiveData.setValue(null);
                Toast.makeText(application,application.getString(R.string.error) , Toast.LENGTH_SHORT).show();

            }
        });
        return actionUserCareerModelMutableLiveData;
    }

//    public LiveData<ResultModel> getJobListModel(String keyword) {
//        networkUtils.getApiInterface().getJobList(keyword).enqueue(new Callback<ResultModel>() {
//            @Override
//            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
//                if (response.body() != null) {
//                    if (response.isSuccessful()) {
//                        jobListModelMutableLiveData.setValue(response.body());
//                    }
//                } else {
//                    jobListModelMutableLiveData.setValue(null);
//                    Log.d(TAG, "job list  Empty Response!");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResultModel> call, Throwable t) {
//                jobListModelMutableLiveData.setValue(null);
//                Log.e(TAG, "job list Empty Response!");
//            }
//        });
//        return jobListModelMutableLiveData;
//    }


//    public LiveData<ResultModel> getTrainingInstitutes(String keyword) {
//        networkUtils.getApiInterface().getTrainingInstitutes(keyword).enqueue(new Callback<ResultModel>() {
//            @Override
//            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
//                if (response.body() != null) {
//                    if (response.isSuccessful()) {
//                        jobListModelMutableLiveData.setValue(response.body());
//                    }
//                } else {
//                    jobListModelMutableLiveData.setValue(null);
//                    Log.d(TAG, "training institute Empty Response!");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResultModel> call, Throwable t) {
//                jobListModelMutableLiveData.setValue(null);
//                Log.e(TAG, "training institute Empty Response!");
//            }
//        });
//        return jobListModelMutableLiveData;
//    }

}
