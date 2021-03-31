package com.sh.wm.ministry.network.utiels;


import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.health.model.health.AddUserHealth;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLegalEntityData;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLicenseData;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLicenseInfo;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddOwnerModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddSecondarySector;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerHealthModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.BossModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.ConstructionBasicInfo;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionRecommendationModel;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionRevisit;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionVisitResult;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.QuestionsAnswer;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.StartVisitModel;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestWorker extends Worker {

    public RequestWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        Log.d("aseel", "on do work");


        NetworkUtils networkUtils = NetworkUtils.getInstance(true, getApplicationContext());
        DBRepository dbRepository = DBRepository.getInstance((Application) getApplicationContext());


//addWorker
        for (String text : getTags()) {
            if (text.equals("inspectionResult")) {
                List<InspectionVisitResult> inspectionVisitResults = dbRepository.getInspectionVisitResults();
                if (dbRepository.getInspectionResultCount() > 0) {
                    for (InspectionVisitResult inspectionVisitResult : inspectionVisitResults) {
                        networkUtils.getApiInterface().storeInspectionVisitResult(inspectionVisitResult.getConstructId(), inspectionVisitResult.getActionId(), inspectionVisitResult.getRecommendationId(), inspectionVisitResult.getPlacementId(), inspectionVisitResult.getDate(), inspectionVisitResult.getReason(), inspectionVisitResult.getMachineName(), inspectionVisitResult.getVisitId(), inspectionVisitResult.getUserId()).enqueue(new Callback<UpdateUser>() {
                            @Override
                            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                                if (response.body() != null) {

                                    Log.d("aseel" , response.body().getMessageText());
                                    dbRepository.deleteInspectionResult(inspectionVisitResult);

                                }

                            }

                            @Override
                            public void onFailure(Call<UpdateUser> call, Throwable t) {

                            }
                        });
                    }
                }
            }
            else if (text.equals("inspectionRevisit")) {
                List<InspectionRevisit> inspectionRevisits = dbRepository.getInspectionRevisit();
                if (dbRepository.getInspectionRevisitCount() > 0) {

                    for (InspectionRevisit inspectionRevisit : inspectionRevisits) {
                        networkUtils.getApiInterface().storeInspectionRevisit(inspectionRevisit.getConstructId(), inspectionRevisit.getViolationRemoval(), inspectionRevisit.getActionId(), inspectionRevisit.getRecommendationId(), inspectionRevisit.getPlacmentId(), inspectionRevisit.getMachineName(), inspectionRevisit.getReason(), inspectionRevisit.getDate(), inspectionRevisit.getVisitId()).enqueue(new Callback<UpdateUser>() {
                            @Override
                            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                                if (response.body() != null) {
                                    Log.d("aseel", response.body().getMessageText());

                                    dbRepository.deleteInspectionRevisit(inspectionRevisit);
                                }
                            }

                            @Override
                            public void onFailure(Call<UpdateUser> call, Throwable t) {
                                Log.d("aseel", t.getMessage());

                            }
                        });

                    }
                }


            } else if (text.equals("recommendation")) {
                List<InspectionRecommendationModel> inspectionRecommendationModels = dbRepository.getReccomendations();
                if (dbRepository.getRecommendationCount() > 0) {

                    for (InspectionRecommendationModel inspectionRecommendationModel : inspectionRecommendationModels) {
                        networkUtils.getApiInterface().storeInspectionRecommendation(inspectionRecommendationModel.getConstructId(), inspectionRecommendationModel.getRecommendationId(), inspectionRecommendationModel.getAdptedId(), inspectionRecommendationModel.getActionId(), inspectionRecommendationModel.getMachineName(), inspectionRecommendationModel.getActionDate(), inspectionRecommendationModel.getVisitId(), inspectionRecommendationModel.getUserId()).enqueue(new Callback<UpdateUser>() {
                            @Override
                            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                                if (response.body() != null) {
                                    Log.d("aseel", response.body().getMessageText());

                                    dbRepository.deleteInspectionRecommendation(inspectionRecommendationModel);
                                }
                            }

                            @Override
                            public void onFailure(Call<UpdateUser> call, Throwable t) {
                                Log.d("aseel", t.getMessage());

                            }
                        });

                    }
                }
            } else if (text.equals("questionAnswer")) {

                List<QuestionsAnswer> questionsAnswers = dbRepository.getQuestionsAnswer();
                if (dbRepository.getQuestionsAnswerCount() > 0) {

                    for (QuestionsAnswer questionsAnswer : questionsAnswers) {
                        networkUtils.getApiInterface().storeQuestionsAnswers(questionsAnswer.getConstructId(), questionsAnswer.getVisitId(), questionsAnswer.getAnswers(), questionsAnswer.getUserId()).enqueue(new Callback<UpdateUser>() {
                            @Override
                            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                                if (response.body() != null) {
                                    Log.d("aseel", response.body().getMessageText());

                                    dbRepository.deleteQuestionsAnswer(questionsAnswer);
                                }
                            }

                            @Override
                            public void onFailure(Call<UpdateUser> call, Throwable t) {
                                Log.d("aseel", t.getMessage());

                            }
                        });

                    }
                }

            }//legalEntity
            else if (text.equals("legalEntity")) {
                List<AddLegalEntityData> addLegalEntityDataList = dbRepository.getLegalEntity();
                if (addLegalEntityDataList.size() > 0) {

                    for (AddLegalEntityData addLegalEntityData : addLegalEntityDataList) {
                        networkUtils.getApiInterface().addLegalEntity(addLegalEntityData.getAction(), addLegalEntityData.getConstructId(), addLegalEntityData.getBossIdentify(), addLegalEntityData.getBossIdentify2(), addLegalEntityData.getType(), addLegalEntityData.getLegalId(), addLegalEntityData.getConstructinType(), addLegalEntityData.getOwnerShipId(), addLegalEntityData.getMainEconomicActivityId(), addLegalEntityData.getMainDsec(), addLegalEntityData.getSessionId(), addLegalEntityData.getYear(), addLegalEntityData.getWorkStatusSecId(), addLegalEntityData.getFoundationNum(), addLegalEntityData.getEmployeeNum(), addLegalEntityData.getStartWork(), addLegalEntityData.getEndWork(), addLegalEntityData.getVisitId(), addLegalEntityData.getSubmitAction()).enqueue(new Callback<ActionModel>() {
                            @Override
                            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                                if (response.body() != null) {
                                    Log.d("aseel", response.body().getMessage());

                                    dbRepository.deleteLegalEntityData(addLegalEntityData);
                                }
                            }

                            @Override
                            public void onFailure(Call<ActionModel> call, Throwable t) {
                                Log.d("aseel", t.getMessage());

                            }
                        });


                    }
                }

            }
            ///secondarySector
            else if (text.equals("secondarySector")) {
                List<AddSecondarySector> secondarySectors = dbRepository.getSecondarySector();
                if (secondarySectors.size() > 0) {

                    for (AddSecondarySector addSecondarySector : secondarySectors) {
                        networkUtils.getApiInterface().addSecondaryWork(addSecondarySector.getConstructId()  , addSecondarySector.getSectorId(), addSecondarySector.getSectorDescription()).enqueue(new Callback<ActionModel>() {
                            @Override
                            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                                if (response.body() != null) {
                                    Log.d("aseel", response.body().getMessage());

                                    dbRepository.deleteAddSecondarySector(addSecondarySector);
                                }
                            }

                            @Override
                            public void onFailure(Call<ActionModel> call, Throwable t) {
                                Log.d("aseel", t.getMessage());

                            }
                        });


                    }
                }

            }
            //licenseSide
            else if (text.equals("licenseSide")) {
                List<AddLicenseData> addLicenseData = dbRepository.getAddLicenseSide("license");
                if (addLicenseData.size() > 0) {

                    for (AddLicenseData addLicenseData1 : addLicenseData) {
                        HashMap<String, RequestBody> hashMap = new HashMap<>();
                        RequestBody constructIdRB = RequestBody.create(addLicenseData1.getConstructId(), MediaType.parse("multipart/form-data"));
                        RequestBody constructLicenseIdRB = RequestBody.create(addLicenseData1.getLicenseId(), MediaType.parse("multipart/form-data"));
                        RequestBody licenseNumberRB = RequestBody.create(addLicenseData1.getLicenseNumber(), MediaType.parse("multipart/form-data"));
                        RequestBody visitIdRB = RequestBody.create(addLicenseData1.getVisitId(), MediaType.parse("multipart/form-data"));
                        RequestBody typeRB = RequestBody.create("0", MediaType.parse("multipart/form-data"));

                        hashMap.put("CONSTRUCT_ID", constructIdRB);
                        hashMap.put("CONSTRUCT_LICENCE_ID", constructLicenseIdRB);
                        hashMap.put("CONSTRUCT_LICENCE_NUM", licenseNumberRB);
                        hashMap.put("VISIT_ID", visitIdRB);
                        hashMap.put("type", typeRB);


                        networkUtils.getApiInterface().addLicenseSide(hashMap, null).enqueue(new Callback<ActionModel>() {
                            @Override
                            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                                if (response.body() != null)
                                    Log.d("aseel", response.body().getMessage());

                                dbRepository.deleteLicenseSideData(addLicenseData1);

                            }

                            @Override
                            public void onFailure(Call<ActionModel> call, Throwable t) {

                            }
                        });
                    }
                }

            }
            //License Info
            else if (text.equals("licenseInfo")) {
                List<AddLicenseInfo> addLicenseInfoList = dbRepository.getLicenseInfo();
                if (addLicenseInfoList.size() > 0) {

                    for (AddLicenseInfo addLicenseInfo : addLicenseInfoList) {
                        networkUtils.getApiInterface().storeLicenseInfo(addLicenseInfo.getAction(),addLicenseInfo.getConstructId(),addLicenseInfo.getIsPolicy(),addLicenseInfo.getIsReg(),addLicenseInfo.getIsLicensed(),addLicenseInfo.getInsuranceEndDate(),addLicenseInfo.getCapital(),addLicenseInfo.getType(),addLicenseInfo.getInsuranceId(),addLicenseInfo.getInsuranceNum(),addLicenseInfo.getIsInternalSys(),addLicenseInfo.getIsCertificateYN(),addLicenseInfo.getWorkHoursSum(),addLicenseInfo.getWorkTime(),addLicenseInfo.getIncomeId(),addLicenseInfo.getVisitId(),addLicenseInfo.getSubmitAction()).enqueue(new Callback<ActionModel>() {
                            @Override
                            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                                if (response.body() != null)
                                    Log.d("aseel", response.body().getMessage());

                                dbRepository.deleteLicenseInfo(addLicenseInfo);

                            }

                            @Override
                            public void onFailure(Call<ActionModel> call, Throwable t) {

                            }
                        });
                    }
                }

            }

            //registeredSide
            else if (text.equals("registeredSide")) {
                List<AddLicenseData> addLicenseData = dbRepository.getAddRegisteredSide("registered");
                if (addLicenseData.size() > 0) {

                    for (AddLicenseData addLicenseData1 : addLicenseData) {
                        HashMap<String, RequestBody> hashMap = new HashMap<>();
                        RequestBody constructIdRB = RequestBody.create(addLicenseData1.getConstructId(), MediaType.parse("multipart/form-data"));
                        RequestBody registeredIdIdRB = RequestBody.create(addLicenseData1.getLicenseId(), MediaType.parse("multipart/form-data"));
                        RequestBody registeredNumberRB = RequestBody.create(addLicenseData1.getLicenseNumber(), MediaType.parse("multipart/form-data"));
                        RequestBody visitIdRB = RequestBody.create(addLicenseData1.getVisitId(), MediaType.parse("multipart/form-data"));
                        RequestBody typeRB = RequestBody.create("0", MediaType.parse("multipart/form-data"));

                        hashMap.put("CONSTRUCT_ID" , constructIdRB);
                        hashMap.put("CONSTRUCT_REG_ID" , registeredIdIdRB);
                        hashMap.put("CONSTRUCT_REG_NUM" , registeredNumberRB);
                        hashMap.put("VISIT_ID" , visitIdRB);
                        hashMap.put("type" , typeRB);

                        networkUtils.getApiInterface().addRegisteredSide(hashMap, null).enqueue(new Callback<ActionModel>() {
                            @Override
                            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                                if (response.body() != null)
                                    Log.d("aseel", response.body().getMessage());

                                dbRepository.deleteLicenseSideData(addLicenseData1);

                            }

                            @Override
                            public void onFailure(Call<ActionModel> call, Throwable t) {

                            }
                        });
                    }
                }

            }
            else if (text.equals("BossModel")) {
                List<BossModel> bossModels = dbRepository.getBossModel();
                if (dbRepository.getBossCount() > 0) {

                    for (BossModel bossModel : bossModels) {
                        networkUtils.getApiInterface().storeBossData(bossModel.getConstructId(), bossModel.getConstantInformative(), bossModel.getUserSn(), bossModel.getInformativeType(), bossModel.getDescription(), bossModel.getVisitId(), bossModel.getType(), bossModel.getSubmitAction()).enqueue(new Callback<ActionModel>() {
                            @Override
                            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                                if (response.body() != null) {
                                    Log.d("aseel", response.body().getMessage());

                                    dbRepository.deleteBossModel(bossModel);
                                }
                            }

                            @Override
                            public void onFailure(Call<ActionModel> call, Throwable t) {
                                Log.d("aseel", t.getMessage());

                            }
                        });

                    }
                }

            } else if (text.equals("ConstructionBasicData")) {
                List<ConstructionBasicInfo> constructionBasicInformations = dbRepository.getConstructionBasicInfo();
                if (dbRepository.getConstructionBasicDataCount() > 0) {

                    for (ConstructionBasicInfo constructionBasicInfo : constructionBasicInformations) {
                        networkUtils.getApiInterface().storeConstructionBasicInfo(constructionBasicInfo.getAction(), constructionBasicInfo.getConstructId(), constructionBasicInfo.getAddressId(), constructionBasicInfo.getConstructionNumber(), constructionBasicInfo.getVisitDate(), constructionBasicInfo.getNameUsing(), constructionBasicInfo.getNameOfficial(), constructionBasicInfo.getMunicipapiityId(), constructionBasicInfo.getRegionId(), constructionBasicInfo.getStreetId(), constructionBasicInfo.getStreetDetails(), constructionBasicInfo.getBuldingNo(), constructionBasicInfo.getAddressDesc(), constructionBasicInfo.getXDirection(), constructionBasicInfo.getYDirections(), constructionBasicInfo.getTelephone(), constructionBasicInfo.getMobile(), constructionBasicInfo.getFax(), constructionBasicInfo.getBox(), constructionBasicInfo.getUrl(), constructionBasicInfo.getEmail(), constructionBasicInfo.getRiskLevelId(), constructionBasicInfo.getVisitId(), constructionBasicInfo.getSubmitAction()).enqueue(new Callback<ActionModel>() {
                            @Override
                            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                                if (response.body() != null) {
                                    Log.d("aseel", response.body().getMessage());

                                    dbRepository.deleteConstructionBasicData(constructionBasicInfo);
                                }
                            }

                            @Override
                            public void onFailure(Call<ActionModel> call, Throwable t) {
                                Log.d("aseel", t.getMessage());

                            }
                        });

                    }
                }
            } else if (text.equals("addWorker")) {
                List<AddWorkerModel> addWorkerModels = dbRepository.getAddWorkerModel();
                if (dbRepository.getAddWorkerCount() > 0) {

                    for (AddWorkerModel addWorkerModel : addWorkerModels) {
                        networkUtils.getApiInterface().addWorker(addWorkerModel.getConstructId(), addWorkerModel.getWorkerSn(), addWorkerModel.getPerExam(), addWorkerModel.getPrimExam(), addWorkerModel.getHaveCertificate(), addWorkerModel.getWorkTypeId(), addWorkerModel.getWorkTypeDescId(), addWorkerModel.getWorkTypeDescDescId(), addWorkerModel.getStartDate(), addWorkerModel.getEndDate(), addWorkerModel.getLeaveDate(), addWorkerModel.getLeaveReason(), addWorkerModel.getCurrencyId(), addWorkerModel.getSalary(), addWorkerModel.getPayId(), addWorkerModel.getJobId(), addWorkerModel.getSkillLevelId(), addWorkerModel.getContractId(), addWorkerModel.getVisitId()).enqueue(new Callback<UpdateUser>() {
                            @Override
                            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                                if (response.body() != null) {
                                    Log.d("aseel", response.body().getMessageText());

                                    dbRepository.deleteAddWorkerModel(addWorkerModel);
                                }
                            }

                            @Override
                            public void onFailure(Call<UpdateUser> call, Throwable t) {
                                Log.d("aseel", t.getMessage());

                            }
                        });

                    }
                }
            } else if (text.equals("addWorkerHealth")) {
                List<AddWorkerHealthModel> addWorkerHealthModels = dbRepository.getAddWorkerHealthModel();
                if (dbRepository.getAddWorkerHealthCount() > 0) {

                    for (AddWorkerHealthModel addWorkerModel : addWorkerHealthModels) {
                        if (addWorkerModel.getUserId() != null) {
                            addUerHealth(addWorkerModel, networkUtils, dbRepository);
                        } else {
                            networkUtils.getApiInterface().getUserInfo(addWorkerModel.getUserSn()).enqueue(new Callback<UserInfoModel>() {
                                @Override
                                public void onResponse(Call<UserInfoModel> call, Response<UserInfoModel> response) {
                                    if (response.body() != null) {
                                        addWorkerModel.setUserId(response.body().getUserWorkInfo().getUSERID());

                                        addUerHealth(addWorkerModel, networkUtils, dbRepository);
                                    }
                                }

                                @Override
                                public void onFailure(Call<UserInfoModel> call, Throwable t) {

                                }
                            });
                        }


                    }
                }
            } else if (text.equals("addOwner")) {
                List<AddOwnerModel> addOwnerModels = dbRepository.getAddOwnerModel();
                if (dbRepository.getAddOwnerCount() > 0) {

                    for (AddOwnerModel addOwnerModel : addOwnerModels) {
                        networkUtils.getApiInterface().addOwner(addOwnerModel.getConstructId(), addOwnerModel.getUserSn(), addOwnerModel.getUserId(), addOwnerModel.getStartDate(), addOwnerModel.getVisitId(), addOwnerModel.getType()).enqueue(new Callback<UpdateUser>() {
                            @Override
                            public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                                if (response.body() != null) {
                                    Log.d("aseel", response.body().getMessageText());

                                    dbRepository.deleteOwnerModel(addOwnerModel);
                                }
                            }

                            @Override
                            public void onFailure(Call<UpdateUser> call, Throwable t) {
                                Log.d("aseel", t.getMessage());

                            }
                        });

                    }
                }


            } else {
                List<StartVisitModel> startedVisits = dbRepository.getStartedVisit();
                if (dbRepository.getStartedVisitCount() > 0) {

                    for (StartVisitModel startVisitModel : startedVisits) {


                        networkUtils.getApiInterface().startInspectionVisit(startVisitModel.getVisit_id()).enqueue(new Callback<ActionModel>() {
                            @Override
                            public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                                if (response.body() != null) {
                                    Log.d("aseel", "on response ");

                                    dbRepository.deleteStartVisit(startVisitModel);

                                }

                            }

                            @Override
                            public void onFailure(Call<ActionModel> call, Throwable t) {

                            }
                        });
                    }
                }
            }
        }

        return Result.success();
    }

    private void addUerHealth(AddWorkerHealthModel addWorkerModel, NetworkUtils networkUtils, DBRepository dbRepository) {
        if (!addWorkerModel.getUserHealthId().equals("130003"))
            networkUtils.getApiInterface().addUserHealthStatus(addWorkerModel.getUserId(), addWorkerModel.getUserHealthId(), addWorkerModel.getDetails()).enqueue(new Callback<AddUserHealth>() {
                @Override
                public void onResponse(Call<AddUserHealth> call, Response<AddUserHealth> response) {
                    if (response.body() != null) {
                        Log.d("aseel", response.body().getMessageText());

                        dbRepository.deleteAddWorkerHealthModel(addWorkerModel);
                    }
                }

                @Override
                public void onFailure(Call<AddUserHealth> call, Throwable t) {
                    Log.d("aseel", t.getMessage());

                }
            });
        else
            networkUtils.getApiInterface().addUserHealthStatusWithAll(addWorkerModel.getUserId(), addWorkerModel.getUserHealthId(), addWorkerModel.getDetails(), addWorkerModel.getDisabilityId(), addWorkerModel.getDisabilityPlace(), addWorkerModel.getDisabilitySize(), addWorkerModel.getReason()).enqueue(new Callback<AddUserHealth>() {
                @Override
                public void onResponse(Call<AddUserHealth> call, Response<AddUserHealth> response) {
                    if (response.body() != null) {
                        Log.d("aseel", response.body().getMessageText());

                        dbRepository.deleteAddWorkerHealthModel(addWorkerModel);
                    }
                }

                @Override
                public void onFailure(Call<AddUserHealth> call, Throwable t) {
                    Log.d("aseel", t.getMessage());

                }
            });

    }
}

