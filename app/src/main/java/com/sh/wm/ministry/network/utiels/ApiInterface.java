package com.sh.wm.ministry.network.utiels;


import com.sh.wm.ministry.featuers.home.homeFiles.LeavingWorkplace.model.ConstructModel;
import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.ArchiveModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLawModel;
import com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.model.CloseFacilityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.HollandBasicTabsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.ActivityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.EvaluationModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.HollandCareersModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities.SkillsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.HollandDreamJobs;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.jobModel.HollandTestJobModel;
import com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.result.HollandResultModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.ConstructLicenceInfo.ConstructLicenceInfoModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisitModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.legalEntity.LegalEntityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.legalEntity.secondaryActivity.SecondActivityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.owner.ConstructionOwnerModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.registerSideInfo.ConstructRegisterInfoModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.visitResult.VisitResult;
import com.sh.wm.ministry.featuers.home.homeFiles.model.InspectorModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.workerRights.model.ComplaintRightsCalculation;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.UserData;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.home.model.CertificateRequest;
import com.sh.wm.ministry.featuers.sso.model.loginmodel.LoginModel;
import com.sh.wm.ministry.featuers.userfile.dependents.model.DependentModel;
import com.sh.wm.ministry.featuers.userfile.familyMember.model.UserFamilyModel;
import com.sh.wm.ministry.featuers.userfile.health.model.health.AddUserHealth;
import com.sh.wm.ministry.featuers.userfile.incubatorsAndInstitueBenefit.model.SupportingInstituteModel;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguageActionsModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.featuers.userfile.partner.model.PartnerModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescDescModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.WorkStatusDescModel;
import com.sh.wm.ministry.featuers.userfile.returningLabor.model.ReturningLaborAction;
import com.sh.wm.ministry.featuers.userfile.returningLabor.model.ReturningLaborModel;
import com.sh.wm.ministry.featuers.userfile.socialAid.model.SocialAidModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.ActionsTrainingProgramsModel;
import com.sh.wm.ministry.featuers.userfile.trainingprograms.model.UserTrainingProgramModel;
import com.sh.wm.ministry.featuers.userfile.travel.model.UserTravelDataModel;
import com.sh.wm.ministry.featuers.userfile.userRealty.model.UserRealtyModel;
import com.sh.wm.ministry.featuers.userfile.vechiels.model.UserVehicleModel;
import com.sh.wm.ministry.featuers.userfile.workProgramBenefit.model.TempWorkModel;
import com.sh.wm.ministry.network.database.dbModels.directors.DirectorsModel;
import com.sh.wm.ministry.network.database.dbModels.economicSector.EconomicSectorModel;
import com.sh.wm.ministry.network.database.dbModels.eduDepartmentAndProgram.EduDepartmentsAndProgramModel;
import com.sh.wm.ministry.network.database.dbModels.eduQualification.EduQualificationModel;
import com.sh.wm.ministry.network.database.dbModels.eduQualificationDetail.EduQualificationDetailModel;
import com.sh.wm.ministry.network.database.dbModels.insuranceCompany.InsuranceCompanyModel;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobListModel;
import com.sh.wm.ministry.network.database.dbModels.jobList.ResultModel;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.MunicipalityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.PostDataMoveFacility;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.StreetGroup;
import com.sh.wm.ministry.featuers.sso.model.SsoTokenModel;
import com.sh.wm.ministry.featuers.sso.model.UserInfoSsoModel;
import com.sh.wm.ministry.featuers.userfile.addressAndContact.model.userworkcontact.UserWorkContactModel;
import com.sh.wm.ministry.featuers.userfile.career.model.UserCareerModel;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserDependentsModel;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserWorkerInsertModel;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.model.EducationalStatusModel;
import com.sh.wm.ministry.featuers.userfile.health.model.health.UserHealthStatusModel;
import com.sh.wm.ministry.network.database.dbModels.cities.CitiesModel;
import com.sh.wm.ministry.network.database.dbModels.constants.ConstantsModel;
import com.sh.wm.ministry.network.database.dbModels.countries.CountriesModel;
import com.sh.wm.ministry.network.database.dbModels.educationalinstitutes.EducationalInstitutesModel;
import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgramsModel;
import com.sh.wm.ministry.network.database.dbModels.jobs.JobsModel;
import com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitlesModel;
import com.sh.wm.ministry.network.database.dbModels.languages.LanguagesModel;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguagesModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.PracticalStatusModel;
import com.sh.wm.ministry.network.database.dbModels.regions.RegionsModel;
import com.sh.wm.ministry.network.database.dbModels.trainingSide.TrainingSideModel;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitutesModel;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgramsModel;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatusModel;
import com.sh.wm.ministry.featuers.userfile.trainingskills.model.TrainingSkillsModel;
import com.sh.wm.ministry.featuers.userfile.workexperience.model.UserWorkExperienceModel;

import java.util.HashMap;

import io.reactivex.rxjava3.core.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

public interface ApiInterface {

    // login requests ///////////////////////////////////////////////////////////////
    // sso login - get user token
    @FormUrlEncoded
    @POST("sso/module.php/sspoauth2/token.php")
    Call<SsoTokenModel> getSsoAccessToken(@Field("client_id") String clientId, @Field("client_secret") String secret, @Field("code") String code);

    // sso verify token
    @POST("sso/module.php/sspoauth2/verify.php")
    Call<UserInfoSsoModel> verifyToken(@Header("x-sso-authorization") String ssoToken);

    // lmis login - get user info
    @FormUrlEncoded
    @POST("login")
    Call<LoginModel> LogIn(@Field("user_sn") String userSn);

    // user files calls ////////////////////////////////////////////////////////////////
    // major services
    @GET("get_my_data")
    Call<UserInfoModel> getUserInfo();


    @GET("get_user_info")
    Call<UserInfoModel> getUserInfo(@Query("user_sn") String userSn) ;

    @GET("get_auth_user_data")
    Call<UserData> getUserData();



    //update other nationality
    @FormUrlEncoded
    @POST("update_user_nationality")
    Call<UpdateUser> updateUserNationality(@Field("User_Nationality_ID")String nationalityId, @Field("User_Nationality_Other_ID") String otherNationalityId, @Field("USER_DIRECTORATE") String directoryBelong);


    @FormUrlEncoded
    @POST("update_user_nationality")
    Call<UpdateUser> updateUserNationality(@Field("User_Nationality_ID")String nationalityId, @Field("User_Nationality_Other_ID") String otherNationalityId);
     /////

    //contact and address
    @FormUrlEncoded
    @POST("get_user_contact")
    Call<UserWorkContactModel> getUserWorkContact(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("user_worker_insert_user_contact")
    Call<ActionModel>  updateUserAddress(@Field("USER_TELEPHONE") String telephone, @Field("USER_MOBILE_1") String mobile1 , @Field("USER_MOBILE_2") String mobile2 , @Field("USER_FACEBOOK_URL") String facebookUrl , @Field("USER_ADDRESS_DESC_ENTRY") String addressDetailsEntry , @Field("USER_BUILDING_DESC") String building, @Field("USER_ADDRESS_DETAILS") String addressDetail);



    //dependent
    @FormUrlEncoded
    @POST("get_user_dependent")
    Call<UserDependentsModel> getUserDependents(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("user_worker_insert_dependents")
    Call<UserWorkerInsertModel> setNewDependents(@Field("user_sn") String userSn, @Field("dependent_sn") String dependentSn);


    @GET("get_dependent_gov_data")
    Call<DependentModel> getDependentGovData(@Query("user_sn") String userSn, @Query("dependent_sn") String dependentSn);


    //health
    @FormUrlEncoded
    @POST("get_user_health_status")
    Call<UserHealthStatusModel> getUserHealthStauts(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("user_worker_insert_user_health_status")
    Call<AddUserHealth> addUserHealthStatus(@Field("USER_ID") String userId , @Field("USER_HEALTH_TYPE_ID") String userHealthId );


    @FormUrlEncoded
    @POST("user_worker_insert_user_health_status")
    Call<AddUserHealth> addUserHealthStatus(@Field("USER_ID") String userId , @Field("USER_HEALTH_TYPE_ID") String userHealthId, @Field("USER_HEALTH_DESC") String details);

    @FormUrlEncoded
    @POST("user_worker_insert_user_health_status")
    Call<AddUserHealth> addUserHealthStatusWithAll(@Field("USER_ID") String userId , @Field("USER_HEALTH_TYPE_ID") String userHealthId,
                                            @Field("USER_HEALTH_DESC") String details, @Field("USER_HEALTH_DISABILITY_TYPE_ID") String disabilityId,
                                            @Field("USER_HEALTH_DISABILITY_PLACE") String disabilityPlace, @Field("USER_HEALTH_DISABILITY_SIZE") String disabilitySize,
                                            @Field("USER_HEALTH_DISABILITY_REASON") String reason);


    @FormUrlEncoded
    @POST("user_worker_insert_user_health_status")
    Call<AddUserHealth> addUserHealthStatusWithoutDetails(@Field("USER_ID") String userId , @Field("USER_HEALTH_TYPE_ID") String userHealthId,
                                            @Field("USER_HEALTH_DISABILITY_TYPE_ID") String disabilityId,
                                            @Field("USER_HEALTH_DISABILITY_PLACE") String disabilityPlace, @Field("USER_HEALTH_DISABILITY_SIZE") String disabilitySize,
                                            @Field("USER_HEALTH_DISABILITY_REASON") String reason);

    @FormUrlEncoded
    @POST("user_worker_insert_user_health_status")
    Call<AddUserHealth> addUserHealthStatusWithoutDisabilityReason(@Field("USER_ID") String userId , @Field("USER_HEALTH_TYPE_ID") String userHealthId,
                                            @Field("USER_HEALTH_DESC") String details, @Field("USER_HEALTH_DISABILITY_TYPE_ID") String disabilityId,
                                            @Field("USER_HEALTH_DISABILITY_PLACE") String disabilityPlace, @Field("USER_HEALTH_DISABILITY_SIZE") String disabilitySize
                                            );

    @FormUrlEncoded
    @POST("user_worker_insert_user_health_status")
    Call<AddUserHealth> addUserHealthStatusWithoutAll(@Field("USER_ID") String userId , @Field("USER_HEALTH_TYPE_ID") String userHealthId,
                                            @Field("USER_HEALTH_DISABILITY_TYPE_ID") String disabilityId,
                                            @Field("USER_HEALTH_DISABILITY_PLACE") String disabilityPlace, @Field("USER_HEALTH_DISABILITY_SIZE") String disabilitySize);





    //educational status
    @FormUrlEncoded
    @POST("get_user_educational_status")
    Call<EducationalStatusModel> getEducationlStatus(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("user_worker_insert_educational_status")
    Call<ActionModel> educationalStatusAction(@Field("action") String action , @Field("USER_EDU_USER_ID")String userId,
                                             @Field("USER_EDU_ID") String userEduId , @Field("USER_EDU_TYPE_ID") String eduTypeId,
                                             @Field("USER_EDU_STATUS_ID") String eduStatusId , @Field("USER_EDU_INSTITUTION_ID") String instituteId ,
                                             @Field("USER_EDU_QUALIFICATION_ID") String qualificationId , @Field("USER_EDU_QUALIFICATION_DESC") String qualificationDesc ,
                                             @Field("USER_EDU_PROGRAM_ID") String programId ,@Field("USER_EDU_DEPARTMENT_ID") String departmentId ,
                                             @Field("USER_EDU_SPECILIZATION_ID") String specializationId , @Field("USER_EDU_GRADUATION_YEAR") String graduationYear ,
                                             @Field("USER_EDU_GRADUATION_COUNTRY_ID") String countryId, @Field("USER_EDU_AVERAGE") String average ,
                                             @Field("USER_EDU_RATE_ID") String rateId, @Field("USER_EDU_LICENSE_YES_NO") String isLicense ,
                                             @Field("USER_EDU_LICENSE_CERTIFICATION_NO") String certificateNo , @Field("USER_EDU_LICENSE_CERTIFICATION_DATE") String certificateDate
                                             );

    @GET("get_edu_departments_and_program")
    Call<EduDepartmentsAndProgramModel> getEduDepartmentsAndProgram(@Query("EDU_SPECILIZATION_ID") String specId);

    @GET("get_edu_qualifications_by_edu_type")
    Call<EduQualificationModel> getEduQualification(@Query("edu_type_id") String eduTypeId);


    @GET("get_edu_qualification_details_by_edu_type")
    Call<EduQualificationDetailModel> getEduQualificationDetails(@Query("edu_type_id") String eduTypeId);
    //career
    @FormUrlEncoded
    @POST("get_user_career")
    Call<UserCareerModel> getUserCareers(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("user_worker_insert_career")
    Call<UpdateUser> addCareer(@Field("action") String action , @Field("USER_CAREER_CAREER_ID") String careerId ,
                               @Field("USER_CAREER_LICENSED") String careerLicense ,@Field("USER_CAREER_SKILL_LEVEL_ID") String skillLevelId,
                               @Field("USER_CAREER_TRAINING_SIDE_ID") String trainingSideId, @Field("USER_CAREER_CERTIFICATE_YEAR") String certifacteYear,
                               @Field("USER_CAREER_QUALIFICATION_TYPE_ID") String qualificationId);


    @FormUrlEncoded
    @POST("user_worker_insert_career")
    Call<UpdateUser> updateCareer(@Field("action") String action ,@Field("USER_CAREER_ID") String userCareerId, @Field("USER_CAREER_CAREER_ID") String careerId ,
                                  @Field("USER_CAREER_LICENSED") String careerLicense ,@Field("USER_CAREER_SKILL_LEVEL_ID") String skillLevelId,
                                  @Field("USER_CAREER_TRAINING_SIDE_ID") String trainingSideId, @Field("USER_CAREER_CERTIFICATE_YEAR") String certificateYear,
                                  @Field("USER_CAREER_PRIORITY") String priority);




    //work experience
    @FormUrlEncoded
    @POST("get_user_work_experience")
    Call<UserWorkExperienceModel> getUserWorkExperiences(@Field("user_id") String userId);


    @FormUrlEncoded
    @POST("user_worker_insert_work_exper")
    Call<UpdateUser> addUserWorkExperience(@Field("action") String action , @Field("USER_WORK_EXP_USER_ID") String userId ,
                                           @Field("USER_WORK_EXP_EXP_TYPE_ID")String expTypeId , @Field("USER_WORK_EXP_JOB_TITLE_ID") String jobTitleId,
                                           @Field("USER_WORK_EXP_INSTIT_ID") String insistId , @Field("USER_WORK_EXP_START_WORK") String startWork ,
                                           @Field("USER_WORK_EXP_END_WORK") String endWork , @Field("USER_WORK_EXP_LEAVING_REASON") String leavingReason ,
                                           @Field("INSERT_USER_SN") String userSn );


    @FormUrlEncoded
    @POST("user_worker_insert_work_exper")
    Call<UpdateUser> updateUserWorkExperience(@Field("action") String action ,@Field("USER_WORK_EXP_ID") String expId,  @Field("USER_WORK_EXP_USER_ID") String userId ,
                                           @Field("USER_WORK_EXP_EXP_TYPE_ID")String expTypeId , @Field("USER_WORK_EXP_JOB_TITLE_ID") String jobTitleId,
                                           @Field("USER_WORK_EXP_INSTIT_ID") String insistId , @Field("USER_WORK_EXP_START_WORK") String startWork ,
                                           @Field("USER_WORK_EXP_END_WORK") String endWork , @Field("USER_WORK_EXP_LEAVING_REASON") String leavingReason ,
                                           @Field("INSERT_USER_SN") String userSn );

    // languages
    @FormUrlEncoded
    @POST("get_user_language")
    Call<UserLanguagesModel> getUserLanguages(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("user_worker_insert_language")
    Call<UserLanguageActionsModel> insertLanguage(@Field("action") String action ,
                                                  @Field("USER_LANG_USER_ID") String userId,
                                                  @Field("USER_LANG_LANG_ID") String langId,
                                                  @Field("USER_LANG_READ_PERCENTAGE")String readPer,
                                                  @Field("USER_LANG_WRITE_PERCENTAGE") String writePer,
                                                  @Field("USER_LANG_CONVERSATION_PER") String conversationPer,
                                                  @Field("language_certificate") String certificatePath);

//    @Multipart
//    @POST("user_worker_insert_language")
//    Call<UserLanguageActionsModel> updateLanguage(@Field("action") String action ,
//                                                  @Field("USER_LANG_USER_ID") String userId,
//                                                  @Field("USER_LANG_ID") String userLangId,
//                                                  @Field("USER_LANG_LANG_ID") String langId,
//                                                  @Field("USER_LANG_READ_PERCENTAGE")String readPer,
//                                                  @Field("USER_LANG_WRITE_PERCENTAGE") String writePer,
//                                                  @Field("USER_LANG_CONVERSATION_PER") String conversationPer,
//                                                  @Part MultipartBody.Part image
//
//                                                  );



//    @Multipart
//    @POST("user_worker_insert_language")
//    Call<UserLanguageActionsModel> updateLanguage(@Part("action") RequestBody action ,
//                                                  @Part("USER_LANG_USER_ID") RequestBody userId,
//                                                  @Part("USER_LANG_ID") RequestBody userLangId,
//                                                  @Part("USER_LANG_LANG_ID") RequestBody langId,
//                                                  @Part("USER_LANG_READ_PERCENTAGE")RequestBody readPer,
//                                                  @Part("USER_LANG_WRITE_PERCENTAGE") RequestBody writePer,
//                                                  @Part("USER_LANG_CONVERSATION_PER") RequestBody conversationPer,
//                                                  @Part MultipartBody.Part image);


//    @Multipart
//    @POST("user_worker_insert_language")
//    Call<UserLanguageActionsModel> updateLanguage(@Part("action") String action ,
//                                                  @Part("USER_LANG_USER_ID") String userId,
//                                                  @Part("USER_LANG_ID") String userLangId,
//                                                  @Part("USER_LANG_LANG_ID") String langId,
//                                                  @Part("USER_LANG_READ_PERCENTAGE")String readPer,
//                                                  @Part("USER_LANG_WRITE_PERCENTAGE") String writePer,
//                                                  @Part("USER_LANG_CONVERSATION_PER") String conversationPer,
//                                                  @Part MultipartBody.Part image);

    @FormUrlEncoded
    @POST("user_worker_insert_language")
    Call<UserLanguageActionsModel> updateLanguage(@Field("action") String action ,
                                                  @Field("USER_LANG_USER_ID") String userId,
                                                  @Field("USER_LANG_ID") String userLangId,
                                                  @Field("USER_LANG_LANG_ID") String langId,
                                                  @Field("USER_LANG_READ_PERCENTAGE")String readPer,
                                                  @Field("USER_LANG_WRITE_PERCENTAGE") String writePer,
                                                  @Field("USER_LANG_CONVERSATION_PER") String conversationPer,
                                                  @Field("language_certificate") String image);








    @POST("user_worker_insert_language")
    @Multipart
    Call<UserLanguageActionsModel> updateLanguage(
            @PartMap HashMap<String , RequestBody> data , @Part MultipartBody.Part image);


    //work status
    @FormUrlEncoded
    @POST("get_user_work_status")
    Call<PracticalStatusModel> getUserPracticalStatus(@Field("user_id") String userId);


    @FormUrlEncoded
    @POST("update_user_work_status")
    Call<ActionModel> updateWorkStatus(@Field("USER_WORK_ID") String userWorkId , @Field("USER_WORK_STATUS_ID") String userWorkStatusId ,
                                       @Field("USER_WORK_STATUS_DESC_ID") String userWorkDescId, @Field("USER_WORK_DESC_DESC_ID") String userWorkDescDescId,
                                       @Field("USER_WORK_START_DATE") String startDate , @Field("USER_WORK_END_DATE") String endDate,
                                       @Field("USER_WORK_LEFT_REASON") String reason , @Field("USER_WORK_SALARY") String salary ,
                                       @Field("USER_WORK_CURRENCY_TYPE_ID") String currencyId,@Field("USER_WORK_HOURS_TYPE_ID") String hoursId,
                                       @Field("USER_WORK_NATURE_ID") String natureId , @Field("USER_WORK_JOB_TITLE_ID") String jobTitleId,
                                       @Field("USER_WORK_CONSTRUCTION_ID") String constructId
                                       );

    //training skills
    @FormUrlEncoded
    @POST("get_user_skills_need")
    Call<TrainingSkillsModel> getTrainingSkills(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("user_worker_insert_skill_needed")
    Call<UpdateUser> insertTrainingSkill(@Field("action")String action , @Field("USER_SKILLS_NEEDS_USER_ID")String userId , @Field("USER_SKILLS_NEED_COURSE_TYPE") String courseTypeId,
                                         @Field("USER_SKILLS_PRIORITY") String priority , @Field("USER_SKILL_JOB_TITLE_ID") String jobId ,@Field("USER_SKILLS_NEED_COURSE_ID")String courseId);

    @FormUrlEncoded
    @POST("user_worker_insert_skill_needed")
    Call<UpdateUser> updateTrainingSkill(@Field("action")String action ,@Field("USER_SKILLS_NEEDS_ID") String skillId, @Field("USER_SKILLS_NEEDS_USER_ID")String userId , @Field("USER_SKILLS_NEED_COURSE_TYPE") String courseTypeId,
                                         @Field("USER_SKILLS_PRIORITY") String priority , @Field("USER_SKILL_JOB_TITLE_ID") String jobId ,@Field("USER_SKILLS_NEED_COURSE_ID")String courseId);


    //training programs
    @FormUrlEncoded
    @POST("get_user_training_program")
    Call<UserTrainingProgramModel> getUserTrainingPrograms(@Field("user_id")String userId);

    @FormUrlEncoded
    @POST("user_worker_insert_training_program")
    Call<ActionsTrainingProgramsModel> addTrainingProgramsModel(@Field("action") String action ,
                                                                @Field("USER_TRAIN_PROG_USER_ID") String userId,
                                                                @Field("USER_TRAIN_PROG_TRAIN_ENTITY") String trainEntity,
                                                                @Field("USER_TRAIN_PROG_TRAINING_ID") String trainProgId,
                                                                @Field("USER_TRAIN_PROG_COURSE_TYPE") String courseType,
                                                                @Field("USER_TRAIN_PROG_INSTITUTION_ID") String institutionId,
                                                                @Field("USER_TRAIN_PROG_START_DATE") String startDate,
                                                                @Field("USER_TRAIN_PROG_END_DATE") String endDate,
                                                                @Field("USER_TRAIN_PROG_TRAINING_HOURS") String hours,
                                                                @Field("USER_TRAIN_PROG_ENTITY_ADDRESS") String entityAddress,
                                                                @Field("USER_TRAIN_PROG_NOTES") String notes,
                                                                @Field("INSERT_USER_SN") String userSn,
                                                                @Field("USER_TRAIN_PROG_TEMP_WORK") String tempWork);

    @FormUrlEncoded
    @POST("user_worker_insert_training_program")
    Call<ActionsTrainingProgramsModel> updateTrainingProgramsModel(@Field("action") String action ,
                                                                @Field("USER_TRAIN_PROG_ID") String userTrainProgId,
                                                                @Field("USER_TRAIN_PROG_USER_ID") String userId,
                                                                @Field("USER_TRAIN_PROG_TRAIN_ENTITY") String trainEntity,
                                                                @Field("USER_TRAIN_PROG_TRAINING_ID") String trainProgId,
                                                                @Field("USER_TRAIN_PROG_COURSE_TYPE") String courseType,
                                                                @Field("USER_TRAIN_PROG_INSTITUTION_ID") String institutionId,
                                                                @Field("USER_TRAIN_PROG_START_DATE") String startDate,
                                                                @Field("USER_TRAIN_PROG_END_DATE") String endDate,
                                                                @Field("USER_TRAIN_PROG_TRAINING_HOURS") String hours,
                                                                @Field("USER_TRAIN_PROG_ENTITY_ADDRESS") String entityAddress,
                                                                @Field("USER_TRAIN_PROG_NOTES") String notes,
                                                                @Field("INSERT_USER_SN") String userSn,
                                                                @Field("USER_TRAIN_PROG_TEMP_WORK") String tempWork);

    //travel
    @FormUrlEncoded
    @POST("get_user_travel_data")
    Call<UserTravelDataModel> getTravelData(@Field("user_id")String userId);

    //Family member
    @GET("user_get_family_members")
    Call<UserFamilyModel> getUserFamilyMember();

    //Vehicle
    @FormUrlEncoded
    @POST("get_user_vehicle")
    Call<UserVehicleModel> getUserVehicle(@Field("user_id") String userId);

    //partner
    @FormUrlEncoded
    @POST("get_user_partner")
    Call<PartnerModel> getUserPartner(@Field("user_id") String userId);

    //institute benefits

    @GET("get_user_supporting_institution")
    Call<SupportingInstituteModel> getSupportingInstitute();

    //social aid
    @FormUrlEncoded
    @POST("get_user_social_aid")
    Call<SocialAidModel> getSocialAid(@Field("user_id") String userId);


    //realty
    @FormUrlEncoded
    @POST("get_user_realty")
    Call<UserRealtyModel> getUserRealty(@Field("user_id") String userId);

    //returning labor
    @FormUrlEncoded
    @POST("get_user_returning_labor")
    Call<ReturningLaborModel> getReturningLabor(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("user_worker_insert_returning_labor")
    Call<ReturningLaborAction> addReturningLabor(@Field("action") String action , @Field("USER_RE_LABOR_COUNTRY_ID") String countryId,
                                                 @Field("USER_RE_LABOR_REASON") String returningReason, @Field("USER_RE_LABOR_START_DATE") String startDate ,
                                                 @Field("USER_RE_LABOR_END_DATE") String endDate, @Field("USER_RE_LABOR_LAST_JOB") String lastJob ,
                                                 @Field("USER_RE_LABOR_SKILL_LEVEL") String skillLevelId);

    @FormUrlEncoded
    @POST("user_worker_insert_returning_labor")
    Call<ReturningLaborAction> updateReturningLabor(@Field("action") String action ,@Field("USER_RE_LABOR_ID") String userLaborId ,@Field("USER_RE_LABOR_COUNTRY_ID") String countryId,
                                                 @Field("USER_RE_LABOR_REASON") String returningReason, @Field("USER_RE_LABOR_START_DATE") String startDate ,
                                                 @Field("USER_RE_LABOR_END_DATE") String endDate, @Field("USER_RE_LABOR_LAST_JOB") String lastJob ,
                                                 @Field("USER_RE_LABOR_SKILL_LEVEL") String skillLevelId);


    ///////////////////////Main screen ////////////////////////////////
    @FormUrlEncoded
    @POST("add_labor_complaint")
    Call<ActionModel> addLaborComplaint(@Field("COMPLAINT_USER_SN") String userSn , @Field("COMPLAINT_EMPLOYMENT_CONTRACT") String haveContract,
                                       @Field("COMPLAINT_LATE_WAGES") String lateWages, @Field("COMPLAINT_LATE_WAGES_PER") String lateWagePer ,
                                       @Field("COMP_LEGAL_DEADLINE_CONSIDERED") String deadLineConsideration , @Field("COMP_PERIOD_NOT_CONSIDERED") String deadLinePer ,
                                       @Field("COMP_WORK_TERMINATION_REASON") String terminationReason, @Field("INSERT_USERID") String insertUserId,
                                       @Field("COMP_CONSTRUCTION_ID") String constructionId, @Field("COMP_END_WORK_TYPE_ID") String endWorkType ,
                                       @Field("COMPLAINT_WORK_PERIOD") String workPeriod, @Field("COMPLAINT_REAL_WORK_PERIOD") String realWorkPeriod ,
                                       @Field("COMPLAINT_REMAINING_LEAVE_DAYS") String remainLeaveDays, @Field("COMPLAINT_JOB_TITLE_ID") String jobId,
                                       @Field("USER_WORK_NATURE_ID") String natureId , @Field("COMPLAINT_LAST_SALARY") String lastPay ,
                                       @Field("COMPLAINT_LAST_SALARY_CURRENCY") String currency , @Field("COMPLAINT_HOURS_TYPE_ID") String hoursType ,
                                       @Field("COMPLAINT_CERMENORIES") String cermenories , @Field("USER_WORK_START_DATE") String startDate , @Field("USER_WORK_END_DATE") String endDate,
                                       @Field("USER_WORKER_USER_MOBILE_1") String mobile1 , @Field("USER_WORKER_USER_ADDRESS_DESC") String addressDesc
                                       );



    //constants//////////////////////////////////////////////////////////////////////////
    // countries
    @GET("get_all_countries")
    Call<CountriesModel> getCountries();

    // languages
    @GET("get_all_languages")
    Call<LanguagesModel> getLanguages();

    //work status
    @GET("get_work_status")
    Call<WorkStatusModel> getWorkStatus();

    //jobs
    @GET("get_all_jobs")
    Call<JobsModel> getJobs();

    //constants
    @GET("get_const_by_parent_id")
    Call<ConstantsModel> getConstants(@Query("parent_id") String parent_id);

    //municipalities
    @GET("get_all_municipality")
    Call<MunicipalityModel> getMunicipalities();

    //regions
    @GET("get_regions_for_directorate")
    Call<RegionsModel> getRegions(@Query("directorate_id") String directorateId);

    //job titles
    @GET("get_job_title")
    Call<JobTitlesModel> getJobTitles();

    //cities
    @GET("get_all_cities")
    Call<CitiesModel> getCities();

    //directors
    @GET("get_all_director")
    Call<DirectorsModel> getDirectors();

    //edu programs
    @GET("get_edu_program")
    Call<EduProgramsModel> getEduPrograms();

    //educational institutes
    @GET("get_educational_institutes")
    Call<EducationalInstitutesModel> getEducationalInstitutes();

    //training institutes
    @GET("get_training_institutes")
    Call<TrainingInstitutesModel> getTrainingInstitutes();

    //training programs
    @GET("get_training_courses_autocomplete")
    Call<TrainingProgramsModel> getTrainingPrograms(@Query("keyword") String key);

    //get training side
    @GET("get_training_sides_autocomplete")
    Call<TrainingSideModel>getTrainingSide(@Query("keyword") String key);




    // get Job list
    @GET("list_jobs_autocomplete")
    Call<JobListModel>getJobLists(@Query("keyword") String key);

    // get training institute
    @GET("get_training_institutes_autocomplete")
    Call<TrainingInstitutesModel>getTrainingInstitutes(@Query("keyword") String key);

    @GET("get_work_status_desc")
    Call<WorkStatusDescModel> getWorkDescMode(@Query("work_status_id") String workStatusId);

    @GET("get_work_status_desc_desc")
    Call<WorkStatusDescDescModel> getWorkStatusDescDesc(@Query("work_status_desc_id") String workStatusDescId);


    //education institute
    @GET("get_education_institutes_autocomplete")
    Call<ResultModel> getEducationalInstitute(@Query("keyword") String key);

    @GET("get_education_specs_autocomplete")
    Call<ResultModel> getEducationalSpec(@Query("keyword") String key);

    //temp work
    @GET("user_get_temp_work")
    Call<TempWorkModel> getTempWorks();


    //end of constants//////////////////////////////////////////////////////////////////////

    @FormUrlEncoded
    @POST("construction_change_place")
    Call<PostDataMoveFacility> CheangePlace(@Field("cnstruction_id") String construction_id, @Field("address_id") String address_id, @Field("municipapiity_id") String municipapiity_id, @Field("region_id") String region_id,
                                            @Field("street_id") String street_id, @Field("bulding_no") String bulding_no, @Field("address_desc") String address_desc, @Field("x_direction") String x_direction, @Field("y_direction") String y_direction,
                                            @Field("construction_tele") String construction_tele, @Field("construction_mobile") String construction_mobile, @Field("construction_fax") String construction_fax, @Field("construction_box") String construction_box,
                                            @Field("construction_url") String construction_url, @Field("construction_email")String email);

    @GET("get_all_streets")
    Call<StreetGroup> getAllStreets();

    @GET("get_construct_by_num?construct_num=")
    Call<ConstructionGroup> getDataConstruction(@Query("construct_num") String nu_construction);

    @GET("get_palestinian_law_desc")
    Call<PalLawModel> getPalLaw(@Query("PAL_LAW_ARTICAL") String palLaw);

    @GET("get_all_inspectors")
    Call<InspectorModel> getInspectors();


    @FormUrlEncoded
    @POST("store_construction_legal_placement")
    Call<UpdateUser> storeConstructionLegalAction(@Field("CONSTRUCT_ID") String constructId ,@Field("CONSTRUCT_VISIT_DATE") String visitDate,
                                            @Field("CONSTRUCT_PROC_PLACE_DATE") String actionDate , @Field("CONSTRUCT_PROC_ACTION_ID") String LegalChosen ,
                                            @Field("MACHINE_NAME") String machineName,  @FieldMap HashMap<String, String> laws,
                                            @Field("CONSTRUCT_PROC_INSPECT_USERID_1") String inspector1 , @Field("CONSTRUCT_PROC_INSPECT_USERID_2") String inspector2,
                                            @Field("CONSTRUCT_PROC_INSPECT_USERID_3") String inspector3 , @Field("VISIT_ID") String visitId,
                                            @Field("INSERTUSERID") String userId);



    @FormUrlEncoded
    @POST("store_construction_alarm")
    Call<UpdateUser> storeConstructionAlarm(@Field("CONSTRUCT_ID") String constructId ,@Field("CONSTRUCT_ALARM_VISIT_DATE") String visitDate,
                                            @Field("CONSTRUCT_ALARM_ALARM_DATE") String alarmDate , @FieldMap HashMap<String, String> laws,
                                            @Field("INSPECTIONALARM_INSPECTOR_INSP_1") String inspector1 , @Field("INSPECTIONALARM_INSPECTOR_INSP_2") String inspector2,
                                            @Field("INSPECTIONALARM_INSPECTOR_INSP_3") String inspector3 , @Field("VISIT_ID") String visitId,
                                            @Field("INSERTUSERID") String userId);




    @FormUrlEncoded
    @POST("construction_colose_decision")
    Call<UpdateUser> storeConstructionClose(@Field("CONSTRUCT_ID") String constructId ,@Field("CONSTRUCT_ALARM_VISIT_DATE") String visitDate,
                                            @Field("CONSTRUCT_CLOSE_DATE") String closeDate , @Field("CONSTRUCT_CLOSE_CLOSE_TYPE_ID") String legalAction ,
                                             @Field("MACHINE_NAME") String machineName ,@FieldMap HashMap<String, String> laws,
                                            @Field("INSPECTIONALARM_INSPECTOR_INSP_1") String inspector1 , @Field("INSPECTIONALARM_INSPECTOR_INSP_2") String inspector2,
                                            @Field("INSPECTIONALARM_INSPECTOR_INSP_3") String inspector3 , @Field("VISIT_ID") String visitId,
                                            @Field("INSERTUSERID") String userId);




    @FormUrlEncoded
    @POST("construction_colose_decision")
    Call<ActionModel> storeConstructionClose(@Field("CONSTRUCT_ID")String constructId , @Field("CONSTRUCT_CLOSE_DATE") String closeDate ,
                                            @Field("CONSTRUCT_CLOSE_CLOSE_TYPE_ID") String typeId, @Field("MACHINE_NAME") String machineName ,
                                            @FieldMap HashMap<String, String> laws, @Field("VISIT_ID") String visitId,
                                             @FieldMap HashMap<String, String> inspectors , @Field("CONSTRUCT_VISIT_DATE") String visitDate);


    @Multipart
    @POST("store_infraction_report_form")
    Call<ActionModel> storeAdjustmentReport(@PartMap HashMap<String , RequestBody> data ,@Part MultipartBody.Part file);



    @FormUrlEncoded
    @POST("construction_close")
    Call<CloseFacilityModel> postCloseFacility(@Field("CONSTRUCT_ID") String CONSTRUCT_ID, @Field("CLOSE_DATE") String CLOSE_DATE, @Field("CLOSE_REASON") String CLOSE_REASON, @Field("INSERT_USERID") String INSERT_USERID);

    @GET("search_construct_by_using_name?construct_name=")
    Call<ConstructByName> getConstructByName(@Query("construct_name") String ConstructNumber);

    @FormUrlEncoded
    @POST("qyed_request_for_user")
    Call<CertificateRequest> requestCertificate(@Field("QAYED_USER_ID") String userId);

    @FormUrlEncoded
    @POST("get_user_qayed_archive")
    Call<ArchiveModel> requestArchive(@Field("user_id") String userId);

    //complaint rights calculations
    @FormUrlEncoded
    @POST("complaint_rights_calculations")
    Call<ComplaintRightsCalculation>  complaintRightCalculation(@Field("USER_WORK_HOURS_TYPE_ID") String hoursType , @Field("USER_WORK_SALARY") String salary,
                                                                @Field("COMPLAINT_REAL_WORK_PERIOD") String realWorkPeriod , @Field("COMPLAINT_REMAINING_LEAVE_DAYS") String remainingLeaveDays,
                                                                @Field("COMP_PERIOD_NOT_CONSIDERED") String periodNotConsidered, @Field("RIGHTS_LATE_BENEFITS") String lastBenefit,
                                                                @Field("COMPLAINT_CERMONIES") String cermonies , @Field("COMP_END_WORK_TYPE_ID") String endWorkType);



    @GET("get_worker_constructions")
    Call<ConstructModel> getWorkerConstruction();


    @FormUrlEncoded
    @POST("construction_left_work_reported")
    Call<UpdateUser> AddLeavingWorkPlaceReport(@Field("CONSTRUCT_ID")String constructionId , @Field("WORKER_USER_SN") String userSn ,
                                               @Field("RESIGN_REASON") String leavingReason, @Field("RESIGN_DATE")String endDate , @Field("INSERT_USERID") String userId );



    @FormUrlEncoded
    @POST("construction_begin_work_reported")
    Call<UpdateUser> AddNewWorkPlaceReport(@Field("CONSTRUCT_ID")String constructionId , @Field("WORKER_USER_SN") String userSn ,
                                               @Field("HIRE_DATE") String startDate);




    /////////Inspections

    //

    @FormUrlEncoded
    @POST("get_inspection_visit_plan_data")
    Single<InspectionVisitModel> getInspectionVisitsPlan(@Field("CONSTRUCTION_ID_IN") String constructId , @Field("P_START") int startValue , @Field("P_LENGTH") int lengthPerPage);






    @FormUrlEncoded
    @POST("start_inspection_visit")
    Call<ActionModel> startInspectionVisit(@Field("visit_id") String visitId);


    ///store inspection result

    @FormUrlEncoded
    @POST("store_inspection_visit_results")
    Call<UpdateUser> storeInspectionVisitResult(@Field("INSPECT_CONSTRUCT_ID") String constructId , @Field("INSPECT_RESULTS_ACTION_ID") String actionId ,
                                           @Field("INSPECT_RESULTS_RECOM_ID") String recommendationId , @Field("INSPECT_RESULTS_PLACEMENT_ID") String placementId ,
                                           @Field("INSPECT_RESULTS_ACTIN_DATE") String date , @Field("INSPECT_RESULTS_ACTION_REON") String reason ,
                                           @Field("INSPECT_RESULTS_MACHINE_NAME") String machineName, @Field("VISIT_ID") String visitId, @Field("INSERTUSERID") String userId);


    @FormUrlEncoded
    @POST("store_committe_inspection_recommendations")
    Call<UpdateUser> storeInspectionRecommendation(@Field("CONSTRUCT_ID") String constructId , @Field("COM_INSPECT_RECOMM_ID") String recommendationId ,
                                                   @Field("COM_INSPECT_RECOMM_ADOPTED_ID") String adptedId,
                                                   @Field("COM_INSPECT_RECOMM_ACTIONS_ID") String actionId , @Field("COM_INSPECTN_MACHINE_NAME") String machineName ,
                                                   @Field("COM_INSPECTN_ACTION_DATE") String actionDate , @Field("VISIT_ID") String visitId , @Field("INSERTUSERID") String userId) ;



    @FormUrlEncoded
    @POST("store_inspection_revisit_results")
    Call<UpdateUser> storeInspectionRevisit(@Field("CONSTRUCT_ID") String constructId,@Field("VIOLATIONS_REMOVAL") String violationRemoval ,
                                            @Field("INSPECT_RESULTS_ACTION_ID") String actionId , @Field("INSPECT_RESULTS_RECOM_ID") String recommendationId ,
                                            @Field("INSPECT_RESULTS_PLACEMENT_ID") String placmentId , @Field("COM_INSPECTN_MACHINE_NAME") String machineName ,
                                            @Field("INSPECT_RESULTS_ACTION_REON") String reason , @Field("COM_INSPECTN_ACTION_DATE") String date ,
                                            @Field("VISIT_ID") String visitId);



    @GET("get_safty_questions_by_subjectid")
    Call<SafetyQuestionsModel> getSafetyQuestions();

    @FormUrlEncoded
    @POST("store_questions_answer")
    Call<UpdateUser> storeQuestionsAnswers(@Field("CONSTRUCT_ID") String constructId, @Field("INSPECTION_VISIT_ID") String visitId ,
                                           @Field("ANSWERS") String answers , @Field("INSERT_USERID") String userId
                                           );


    @FormUrlEncoded
    @POST("store_construction_boss_info")
    Call<ActionModel> storeBossData(@Field("CONSTRUCT_ID") String constructId , @Field("constant_informative") String constantInformative ,
                                   @Field("query_user_sn") String userSn , @Field("informative_type") String informativeType ,
                                   @Field("informative_desc") String description , @Field("VISIT_ID") String visitId ,
                                   @Field("type") String type , @Field("submit_action") String submitAction);



    @FormUrlEncoded
    @POST("store_construction_basic_info")
    Call<ActionModel> storeConstructionBasicInfo(@Field("action") String action , @Field("CONSTRUCT_ID") String constructId,
                                                 @Field("address_id_1") String addressId , @Field("construction_number") String constructionNumber ,
                                                 @Field("construct_visit_date") String visitDate , @Field("construction_name_using") String nameUsing ,
                                                 @Field("construction_name_official") String nameOfficial, @Field("municipapiity_id_1") String municipapiityId ,
                                                 @Field("region_id_1") String regionId, @Field("street_id") String streetId  ,
                                                 @Field("CONSTRUCT_STREET_DETAILS") String streetDetails ,@Field("bulding_no") String buldingNo ,
                                                 @Field("address_desc") String addressDesc , @Field("x_direction") String xDirection ,
                                                 @Field("y_direction") String yDirections ,@Field("construction_tele") String telephone ,
                                                 @Field("construction_mobile") String mobile,@Field("construction_fax") String fax ,
                                                 @Field("construction_box") String box  , @Field("construction_url") String url,
                                                 @Field("construction_email")String email ,@Field("risk_level_id")String riskLevelId,
                                                 @Field("VISIT_ID") String visitId, @Field("submit_action") String submitAction
                                                 );



    @FormUrlEncoded
    @POST("construction_add_worker")
    Call<UpdateUser> addWorker(@Field("CONSTRUCT_ID") String contructId, @Field("CONSTRUCT_WORKER_SN") String workerSn ,
                               @Field("CON_WORK_PER_MED_EXAM") String perExam , @Field("CON_WORK_PRIM_MED_EXAM") String primExam ,
                               @Field("CON_WORK_HOLD_REGI_CERT") String haveCertificate, @Field("WORK_TYPE_ID") String workTypeId ,
                               @Field("WORK_TYPE_DESC_ID") String workTypeDescId, @Field("WORK_TYPE_DESC_DESC_ID") String workTypeDescDescId,
                               @Field("CONSTRUCT_WORK_START_DATE" ) String startDate,  @Field("CONSTRUCT_WORK_END_DATE") String endDate,
                               @Field("CONSTRUCT_WORK_LEAVE_DATE") String leaveDate, @Field("LEAVE_WORK_REASON") String leaveReason,
                               @Field("CONSTRUCT_WORK_SAL_CURR") String currencyId, @Field("CONSTRUCT_WORK_SALARY") String salary ,
                               @Field("CONSTRUCT_WORK_SAL_PAY_ID") String payId, @Field("CONSTRUCT_WORK_JOB_TITLE_ID") String jobId,
                               @Field("USER_CAREER_SKILL_LEVEL_ID") String skillLevelId,
                               @Field("CONSTRUCT_WORK_CONTRACT_TYPE") String contractId, @Field("VISIT_ID") String visitId
                               ) ;


    @FormUrlEncoded
    @POST("construction_add_new_owner")
    Call<UpdateUser> addOwner(@Field("CONSTRUCT_ID") String constructId , @Field("CONSTRUCT_USER_SN") String userSn ,
                              @Field("INSERT_USERID") String userId , @Field("OWENER_START_DATE")String startDate,
                              @Field("VISIT_ID") String visitId , @Field("type") String type) ;


    @FormUrlEncoded
    @POST("get_construct_owner")
    Call<ConstructionOwnerModel> getConstructionOwner(@Field("construct_id") String constructId);


    @FormUrlEncoded
    @POST("get_legal_entity")
    Call<LegalEntityModel> getLegalEntity(@Field("CONSTRUCT_ID") String constructId);


    @Streaming
    @GET("export_user_unemployed")
    Call<ResponseBody> getUnemployedFile();

    @FormUrlEncoded
    @POST("add_construction_legal_info")
    Call<ActionModel> addLegalEntity(@Field("action") String action , @Field("CONSTRUCT_ID") String constructId,
                                     @Field("construction_boss_identify") String bossIdentify , @Field("construction_boss_identify_2") String bossIdentify2,
                                     @Field("type") String type, @Field("CONSTRUCTION_LEGAL_ID") String legalId, @Field("CONSTRUCTION_TYPE") String constructinType,
                                     @Field("CONSTRUCTION_OWNERSHIP_ID") String ownerShipId , @Field("CONSTRUCTION_MAIN_ECONOMIC_ACTIVITY_ID") String mainEconomicActivityId,
                                     @Field("CONSTRUCTION_MAIN_DESC") String mainDsec , @Field("CONSTRUCTION_SESSON_ID") String sessionId,
                                     @Field("CONSTRUCTION_YEAR_ACTIVITY_MAIN") String year , @Field("CONSTRUCTION_WORK_STATUS_SEC_ID") String workStatusSecId,
                                     @Field("CONSTRUCTION_WORK_FOUNDATION_NUM") String foundationNum , @Field("CONSTRUCTION_WORK_EMPLOYEE_NUM") String employeeNum  ,
                                     @Field("CONSTRUCT_WORK_START_WORK") String startWork , @Field("CONSTRUCT_WORK_END_WORK") String endWork ,
                                     @Field("VISIT_ID") String visitId, @Field("SUBMIT_ACTION") String submitAction);



    @POST("add_construct_licence_side")
    @Multipart
    Call<ActionModel> addLicenseSide(
            @PartMap HashMap<String , RequestBody> data , @Part MultipartBody.Part licenseFile);



    @POST("add_construct_register_side")
    @Multipart
    Call<ActionModel> addRegisteredSide(
            @PartMap HashMap<String , RequestBody> data , @Part MultipartBody.Part registerFile);



    @GET("get_insurance_companies")
    Call<InsuranceCompanyModel> getInsuranceCompany();


    @FormUrlEncoded
    @POST("store_construction_licence_info")
    Call<ActionModel> storeLicenseInfo(@Field("action") String action,@Field("CONSTRUCT_ID") String constructId ,
                                       @Field("constut_is_policy") String isPolicy , @Field("construct_is_reg") String isReg ,
                                       @Field("construct_is_licenced") String isLicensed , @Field("construct_policy_dt_end") String insuranceEndDate,
                                       @Field("capital") String capital , @Field("type") String type ,
                                       @Field("construct_comp_id")  String insuranceId , @Field("construct_policy_num") String insuranceNum ,
                                       @Field("constut_is_internal_sys") String isInternalSys, @Field("constut_is_crertified_y_n") String isCertificateYN,
                                       @Field("construct_work_house_sum") String workHoursSum , @Field("construct_work_time") String workTime ,
                                       @Field("construction_income_level_id") String incomeId , @Field("VISIT_ID") String visitId,
                                       @Field("submit_action") String submitAction) ;


    @FormUrlEncoded
    @POST("get_construct_register_side_info")
    Call<ConstructRegisterInfoModel>getConstructRegisterSide(@Field("construct_id") String constructId);


    @FormUrlEncoded
    @POST("get_construct_licence_info")
    Call<ConstructLicenceInfoModel>getConstructLicenseSide(@Field("construct_id") String constructId);

    @GET("get_all_main_economic_activities_autocomplete")
    Call<EconomicSectorModel> getEconomicSector(@Query("keyword") String keyword);

    @FormUrlEncoded
    @POST("add_construct_secondary_work")
    Call<ActionModel> addSecondaryWork(@Field("construct_id") String constructId, @Field("construct_econ_sec_id") String sectorId , @Field("construct_econ_sec_desc") String sectorDescription);


    @FormUrlEncoded
    @POST("get_construct_second_activities")
    Call<SecondActivityModel> getSecondaryActivity(@Field("construct_id")String constructId);

    @GET("get_holand_basic_tab")
    Call<HollandBasicTabsModel> getHollandBasicTabs();


    @FormUrlEncoded
    @POST("save_basic_data")
    Call<ActionModel> saveBasicDataHollandTest(@Field("test_id") String testId, @Field("years") String numberOfYears);


    @FormUrlEncoded
    @POST("get_holland_job_list")
    Call<HollandTestJobModel> getHollandJobList(@Field("test_id") String testId);

    @FormUrlEncoded
    @POST("add__dream_job")
    Call<ActionModel> addDreamJob(@Field("test_id") String testId , @Field("job_id") String jobId);


    @FormUrlEncoded
    @POST("delete_dream_job")
    Call<ActionModel> deleteDreamJob(@Field("test_id")String testId , @Field("job_id") String jobId);

    @FormUrlEncoded
    @POST("get_holland_dream_jobs")
    Call<HollandDreamJobs> getHollandDreamJobs(@Field("test_id")String testId);

    @GET("get_activities_questions")
    Call<ActivityModel> getActivities(@Query("test_id") String testId) ;



    @FormUrlEncoded
    @POST("save_activity_data")
    Call<ActionModel> saveActivityQuestions(@Field("test_id")String testId ,@Field("answers") String answers );



    @GET("get_skills_questions")
    Call<SkillsModel> getSkills(@Query("test_id") String testId) ;


    @FormUrlEncoded
    @POST("save_skill_data")
    Call<ActionModel> saveSkillsQuestions(@Field("test_id")String testId ,@Field("answers") String answers );


    @GET("get_jobs_questions")
    Call<HollandCareersModel> getHollandCareers(@Query("test_id") String testId) ;


    @FormUrlEncoded
    @POST("save_job_data")
    Call<ActionModel> saveCareerQuestions(@Field("test_id")String testId ,@Field("answers") String answers );



    @GET("get_evaluation_questions")
    Call<EvaluationModel> getEvaluationTest(@Query("test_id") String testId) ;


    @FormUrlEncoded
    @POST("save_eval_data")
    Call<ActionModel> saveEvaluationQuestions(@Field("test_id")String testId ,@Field("answers") String answers );


    @FormUrlEncoded
    @POST("get_visit_result")
    Call<VisitResult> getVisitResult(@Field("construct_id") String constructId , @Field("visit_id") String visitId );


    @FormUrlEncoded
    @POST("holland_result_data")
    Call<HollandResultModel> getHollandResultModel(@Field("test_id") String testId);

    @FormUrlEncoded
    @POST("save_result_data")
    Call<ActionModel> saveResultModel(@Field("test_id") String testId);
}



