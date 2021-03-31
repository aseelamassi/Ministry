package com.sh.wm.ministry.featuers.home.homeFiles.inspection.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.ConstructLicenceInfo.ConstructLicenceInfoModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.legalEntity.LegalEntityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.legalEntity.secondaryActivity.SecondActivityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.owner.ConstructionOwnerModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.registerSideInfo.ConstructRegisterInfo;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.registerSideInfo.ConstructRegisterInfoModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.visitResult.VisitResult;
import com.sh.wm.ministry.featuers.home.homeFiles.legalAction.repository.LegalActionRepository;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class InspectionVisitRepository {
    private Application application;
    private NetworkUtils networkUtils;
    private List<InspectionVisit> inspectionVisitModelMutableLiveData;
    private MutableLiveData<UpdateUser> actionMutableLiveData;
    private MutableLiveData<SafetyQuestionsModel> safetyQuestionsModelMutableLiveData;
    private MutableLiveData<UserInfoModel> userInfoModelMutableLiveData;
    private MutableLiveData<ConstructionOwnerModel> constructionOwnerModelMutableLiveData;
    private MutableLiveData<LegalEntityModel> legalEntityModelMutableLiveData;
    private MutableLiveData<ConstructRegisterInfoModel> constructRegisterInfoMutableLiveData;
    private MutableLiveData<ConstructLicenceInfoModel> constructLicenceInfoModelMutableLiveData;
    private MutableLiveData<SecondActivityModel> secondActivityModelMutableLiveData;
    private MutableLiveData<VisitResult> visitResultMutableLiveData;

    private static final String TAG = LegalActionRepository.class.getSimpleName();
    static InspectionVisitRepository mInstance;

    public InspectionVisitRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        inspectionVisitModelMutableLiveData = new ArrayList<>();
        safetyQuestionsModelMutableLiveData = new MutableLiveData<>();
        actionMutableLiveData = new MutableLiveData<>();
        userInfoModelMutableLiveData = new MutableLiveData<>();
        constructionOwnerModelMutableLiveData = new MutableLiveData<>();
        legalEntityModelMutableLiveData = new MutableLiveData<>();
        constructRegisterInfoMutableLiveData = new MutableLiveData<>();
        constructLicenceInfoModelMutableLiveData = new MutableLiveData<>();
        secondActivityModelMutableLiveData = new MutableLiveData<>();
    }

    public static InspectionVisitRepository getInstance(Application application) {

        if (mInstance == null) {
            mInstance = new InspectionVisitRepository(application);
        }
        return mInstance;
    }





    public LiveData<UserInfoModel> getUserInfo(String userSn) {
        networkUtils.getApiInterface().getUserInfo(userSn).enqueue(new Callback<UserInfoModel>() {
            @Override
            public void onResponse(Call<UserInfoModel> call, Response<UserInfoModel> response) {
                if (response.body() != null) {
                    userInfoModelMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserInfoModel> call, Throwable t) {

            }
        });

        return userInfoModelMutableLiveData;
    }


    public LiveData<ConstructionOwnerModel> getConstructionOwner(String constructId) {
        networkUtils.getApiInterface().getConstructionOwner(constructId).enqueue(new Callback<ConstructionOwnerModel>() {
            @Override
            public void onResponse(Call<ConstructionOwnerModel> call, Response<ConstructionOwnerModel> response) {
                if (response.body() != null) {
                    constructionOwnerModelMutableLiveData.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<ConstructionOwnerModel> call, Throwable t) {

                constructionOwnerModelMutableLiveData.setValue(null);
            }
        });

        return constructionOwnerModelMutableLiveData;
    }


    public LiveData<SecondActivityModel> getSecondaryActivity(String constructId) {
        networkUtils.getApiInterface().getSecondaryActivity(constructId).enqueue(new Callback<SecondActivityModel>() {
            @Override
            public void onResponse(Call<SecondActivityModel> call, Response<SecondActivityModel> response) {
                if (response.body() != null) {
                    secondActivityModelMutableLiveData.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<SecondActivityModel> call, Throwable t) {
                secondActivityModelMutableLiveData.setValue(null);
            }
        });

        return secondActivityModelMutableLiveData;
    }



    public LiveData<ConstructRegisterInfoModel> getConstructRegisterSide(String constructId) {
        networkUtils.getApiInterface().getConstructRegisterSide(constructId).enqueue(new Callback<ConstructRegisterInfoModel>() {
            @Override
            public void onResponse(Call<ConstructRegisterInfoModel> call, Response<ConstructRegisterInfoModel> response) {
                if (response.body() != null) {
                    constructRegisterInfoMutableLiveData.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<ConstructRegisterInfoModel> call, Throwable t) {
                constructRegisterInfoMutableLiveData.setValue(null);
            }
        });

        return constructRegisterInfoMutableLiveData;
    }


    public LiveData<ConstructLicenceInfoModel> getConstructLicenseSide(String constructId) {
        networkUtils.getApiInterface().getConstructLicenseSide(constructId).enqueue(new Callback<ConstructLicenceInfoModel>() {
            @Override
            public void onResponse(Call<ConstructLicenceInfoModel> call, Response<ConstructLicenceInfoModel> response) {
                if (response.body() != null) {
                    constructLicenceInfoModelMutableLiveData.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<ConstructLicenceInfoModel> call, Throwable t) {
                constructLicenceInfoModelMutableLiveData.setValue(null);
            }
        });

        return constructLicenceInfoModelMutableLiveData;
    }



    public LiveData<LegalEntityModel> getLegalEntity(String constructId) {
        if (!NetworkUtils.isOnline(application))
            Toast.makeText(application, application.getString(R.string.legal_entity_no_internet), Toast.LENGTH_SHORT).show();
        else
            networkUtils.getApiInterface().getLegalEntity(constructId).enqueue(new Callback<LegalEntityModel>() {
                @Override
                public void onResponse(Call<LegalEntityModel> call, Response<LegalEntityModel> response) {
                    if (response.body() != null) {
                        legalEntityModelMutableLiveData.setValue(response.body());

                    }
                }

                @Override
                public void onFailure(Call<LegalEntityModel> call, Throwable t) {
                    legalEntityModelMutableLiveData.setValue(null);
                }
            });

        return legalEntityModelMutableLiveData;
    }


    public LiveData<SafetyQuestionsModel> safetyQuestions() {
        networkUtils.getApiInterface().getSafetyQuestions().enqueue(new Callback<SafetyQuestionsModel>() {
            @Override
            public void onResponse(Call<SafetyQuestionsModel> call, Response<SafetyQuestionsModel> response) {
                if (response.body() != null) {
                    safetyQuestionsModelMutableLiveData.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<SafetyQuestionsModel> call, Throwable t) {
                safetyQuestionsModelMutableLiveData.setValue(null);
            }
        });

        return safetyQuestionsModelMutableLiveData;
    }


    public LiveData<VisitResult> getVisitResult(String constructId , String visitId ){

        networkUtils.getApiInterface().getVisitResult(constructId,visitId).enqueue(new Callback<VisitResult>() {
            @Override
            public void onResponse(Call<VisitResult> call, Response<VisitResult> response) {
                if (response.body() != null) {
                    visitResultMutableLiveData.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<VisitResult> call, Throwable t) {
                visitResultMutableLiveData.setValue(null);
            }
        });


        return visitResultMutableLiveData ;

    }




}
