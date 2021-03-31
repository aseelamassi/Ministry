package com.sh.wm.ministry.network.database.dbRepository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionArray;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionsModel;
import com.sh.wm.ministry.featuers.home.model.ActionModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UpdateUser;
import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.database.dao.AddLegalDataDao;
import com.sh.wm.ministry.network.database.dao.AddLicenseDao;
import com.sh.wm.ministry.network.database.dao.AddLicenseInfoDao;
import com.sh.wm.ministry.network.database.dao.AddOwnerDao;
import com.sh.wm.ministry.network.database.dao.AddSecondarySectorDao;
import com.sh.wm.ministry.network.database.dao.AddWorkerDao;
import com.sh.wm.ministry.network.database.dao.AddWorkerHealthDao;
import com.sh.wm.ministry.network.database.dao.BossDao;
import com.sh.wm.ministry.network.database.dao.CitiesDao;
import com.sh.wm.ministry.network.database.dao.ConstantsDao;
import com.sh.wm.ministry.network.database.dao.ConstructionBasicInfoDao;
import com.sh.wm.ministry.network.database.dao.CountriesDao;
import com.sh.wm.ministry.network.database.dao.DirectorsDao;
import com.sh.wm.ministry.network.database.dao.EconomicSectorDao;
import com.sh.wm.ministry.network.database.dao.EduProgramDao;
import com.sh.wm.ministry.network.database.dao.EduQualificationDao;
import com.sh.wm.ministry.network.database.dao.EduQualificationDetailDao;
import com.sh.wm.ministry.network.database.dao.EducationalInstituteDao;
import com.sh.wm.ministry.network.database.dao.InspectionRecommendation;
import com.sh.wm.ministry.network.database.dao.InspectionRevisitDao;
import com.sh.wm.ministry.network.database.dao.InspectionVisitResultDao;
import com.sh.wm.ministry.network.database.dao.InsuranceCompanyDao;
import com.sh.wm.ministry.network.database.dao.JobListDao;
import com.sh.wm.ministry.network.database.dao.JobTitlesDao;
import com.sh.wm.ministry.network.database.dao.JobsDao;
import com.sh.wm.ministry.network.database.dao.LanguagesDao;
import com.sh.wm.ministry.network.database.dao.MunicipalitiesDao;
import com.sh.wm.ministry.network.database.dao.QuestionsAnswerDao;
import com.sh.wm.ministry.network.database.dao.RegionsDao;
import com.sh.wm.ministry.network.database.dao.SafetyQuestionsArrayDao;
import com.sh.wm.ministry.network.database.dao.StartVisitDao;
import com.sh.wm.ministry.network.database.dao.TrainingInstituteDao;
import com.sh.wm.ministry.network.database.dao.TrainingProgramDao;
import com.sh.wm.ministry.network.database.dao.TrainingSideDao;
import com.sh.wm.ministry.network.database.dao.WorkStatusDao;
import com.sh.wm.ministry.network.database.dbModels.cities.CitiesModel;
import com.sh.wm.ministry.network.database.dbModels.cities.City;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.constants.ConstantsModel;
import com.sh.wm.ministry.network.database.dbModels.countries.CountriesModel;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbModels.directors.Director;
import com.sh.wm.ministry.network.database.dbModels.directors.DirectorsModel;
import com.sh.wm.ministry.network.database.dbModels.economicSector.EconomicSector;
import com.sh.wm.ministry.network.database.dbModels.economicSector.EconomicSectorModel;
import com.sh.wm.ministry.network.database.dbModels.eduQualification.EduQualification;
import com.sh.wm.ministry.network.database.dbModels.eduQualification.EduQualificationModel;
import com.sh.wm.ministry.network.database.dbModels.eduQualificationDetail.EduQualificationDetail;
import com.sh.wm.ministry.network.database.dbModels.eduQualificationDetail.EduQualificationDetailModel;
import com.sh.wm.ministry.network.database.dbModels.educationalinstitutes.EducationalInstitute;
import com.sh.wm.ministry.network.database.dbModels.educationalinstitutes.EducationalInstitutesModel;
import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgram;
import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgramsModel;
import com.sh.wm.ministry.network.database.dbModels.insuranceCompany.InsuranceCompany;
import com.sh.wm.ministry.network.database.dbModels.insuranceCompany.InsuranceCompanyModel;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobListModel;
import com.sh.wm.ministry.network.database.dbModels.jobs.Job;
import com.sh.wm.ministry.network.database.dbModels.jobs.JobsModel;
import com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitle;
import com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitlesModel;
import com.sh.wm.ministry.network.database.dbModels.languages.Language;
import com.sh.wm.ministry.network.database.dbModels.languages.LanguagesModel;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.MunicipalityModel;
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
import com.sh.wm.ministry.network.database.dbModels.regions.Region;
import com.sh.wm.ministry.network.database.dbModels.regions.RegionsModel;
import com.sh.wm.ministry.network.database.dbModels.trainingSide.TrainingSide;
import com.sh.wm.ministry.network.database.dbModels.trainingSide.TrainingSideModel;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitute;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitutesModel;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgramsModel;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatusModel;
import com.sh.wm.ministry.network.utiels.NetworkUtils;
import com.sh.wm.ministry.network.utiels.RequestWorker;
import com.sh.wm.ministry.network.utiels.StringTypeConverter;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DBRepository {
    private static DBRepository mInstance;
    private final String TAG = DBRepository.class.getName();
    private NetworkUtils networkUtils;
    private CountriesDao countriesDao;
    private LanguagesDao languagesDao;
    private WorkStatusDao workStatusDao;
    private JobsDao jobsDao;
    private ConstantsDao constantsDao;
    private MunicipalitiesDao municipalitiesDao;
    private RegionsDao regionsDao;
    private JobTitlesDao jobTitlesDao;
    private CitiesDao citiesDao;
    private DirectorsDao directorsDao;
    private EduProgramDao eduProgramDao;
    private EducationalInstituteDao educationalInstituteDao;
    private TrainingInstituteDao trainingInstituteDao;
    private TrainingProgramDao trainingProgramDao;
    private TrainingSideDao trainingSideDao;
    private EduQualificationDao eduQualificationDao;
    private EduQualificationDetailDao eduQualificationDetailDao;
    private JobListDao jobListDao;
    private StartVisitDao startVisitDao;
    private InspectionVisitResultDao inspectionVisitResultDao;
    private InspectionRecommendation inspectionRecommendationDao;
    private InspectionRevisitDao inspectionRevisitDao;
    private QuestionsAnswerDao questionsAnswerDao;
    private BossDao bossDao;
    private ConstructionBasicInfoDao constructionBasicInfoDao;
    private AddWorkerDao addWorkerDao;
    private AddWorkerHealthDao addWorkerHealthDao;
    private AddOwnerDao addOwnerDao;
    private AddLegalDataDao addLegalDataDao;
    private AddLicenseDao addLicenseDao;
    private InsuranceCompanyDao insuranceCompanyDao;
    private AddLicenseInfoDao addLicenseInfoDao;
    private EconomicSectorDao economicSectorDao;
    private AddSecondarySectorDao addSecondarySectorDao;
    private SafetyQuestionsArrayDao safetyQuestionsArrayDao;


    private Application application;

    private DBRepository(Application application) {
        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        countriesDao = DataBase.getInstance(application).countriesDao();
        languagesDao = DataBase.getInstance(application).languagesDao();
        workStatusDao = DataBase.getInstance(application).workStatusDao();
        jobsDao = DataBase.getInstance(application).jobsDao();
        constantsDao = DataBase.getInstance(application).constantsDao();
        municipalitiesDao = DataBase.getInstance(application).municipalitiesDao();
        regionsDao = DataBase.getInstance(application).regionsDao();
        jobTitlesDao = DataBase.getInstance(application).jobTitlesDao();
        citiesDao = DataBase.getInstance(application).citiesDao();
        directorsDao = DataBase.getInstance(application).directorsDao();
        eduProgramDao = DataBase.getInstance(application).eduProgramDao();
        educationalInstituteDao = DataBase.getInstance(application).educationalInstituteDao();
        trainingInstituteDao = DataBase.getInstance(application).trainingInstituteDao();
        trainingProgramDao = DataBase.getInstance(application).trainingProgramDao();
        trainingSideDao = DataBase.getInstance(application).trainingSideDao();
        eduQualificationDao = DataBase.getInstance(application).eduQualificationDao();
        eduQualificationDetailDao = DataBase.getInstance(application).eduQualificationDetailDao();
        jobListDao = DataBase.getInstance(application).jobListDao();
        startVisitDao = DataBase.getInstance(application).startVisitDao();
        inspectionVisitResultDao = DataBase.getInstance(application).inspectionVisitResultDao();
        inspectionRecommendationDao = DataBase.getInstance(application).inspectionRecommendationDao();
        inspectionRevisitDao = DataBase.getInstance(application).inspectionRevisitDao();
        questionsAnswerDao = DataBase.getInstance(application).questionsAnswerDao();
        bossDao = DataBase.getInstance(application).bossDao();
        constructionBasicInfoDao = DataBase.getInstance(application).constructionBasicInfoDao();
        addWorkerDao = DataBase.getInstance(application).addWorkerDao();
        addWorkerHealthDao = DataBase.getInstance(application).addWorkerHealthDao();
        addOwnerDao = DataBase.getInstance(application).addOwnerDao();
        addLegalDataDao = DataBase.getInstance(application).addLegalDataDao();
        addLicenseDao = DataBase.getInstance(application).addLicenseDao();
        insuranceCompanyDao = DataBase.getInstance(application).insuranceCompanyDao();
        addLicenseInfoDao = DataBase.getInstance(application).addLicenseInfoDao();
        economicSectorDao = DataBase.getInstance(application).economicSectorDao();
        addSecondarySectorDao = DataBase.getInstance(application).addSecondarySectorDao();
        safetyQuestionsArrayDao = DataBase.getInstance(application).safetyQuestionsArrayDao();


    }

    public static DBRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new DBRepository(application);
        }
        return mInstance;
    }

    //countries
    public LiveData<List<Country>> getAllCountries() {
        if (NetworkUtils.isOnline(application))
            updateCountries();
        return countriesDao.getAllCountries();
    }

    public LiveData<List<Country>> getAllCountries(String countryName) {
        if (NetworkUtils.isOnline(application))
            updateCountries();
        return countriesDao.getAllCountries("%" + countryName + "%");
    }

    public LiveData<String> getUserCountry(String countryID) {
        if (NetworkUtils.isOnline(application))
            updateCountries();
        return countriesDao.getUserCountry(countryID);
    }

    public void updateCountries() {
        networkUtils.getApiInterface().getCountries().enqueue(new Callback<CountriesModel>() {
            @Override
            public void onResponse(Call<CountriesModel> call, Response<CountriesModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCountries().size() != countriesDao.getDataCount()) {
                        List<Country> countries = response.body().getCountries();
                        for (Country country : countries)
                            countriesDao.addCountry(country);
                    }
                }
            }

            @Override
            public void onFailure(Call<CountriesModel> call, Throwable t) {
            }
        });
    }

    // languages
    public LiveData<List<Language>> getAllLanguages(String keyword) {
        if (NetworkUtils.isOnline(application))
            updateLanguages();
        return languagesDao.getAllLanguages("%" + keyword + "%");
    }

    public LiveData<List<Language>> getAllLanguages() {
        if (NetworkUtils.isOnline(application))
            updateLanguages();
        return languagesDao.getAllLanguages();
    }


    //////////////////Inspection///////////////////

    public int getStartedVisitCount() {
        return startVisitDao.getDataCount();
    }

    public void deleteStartVisit(StartVisitModel startVisitModel) {
        startVisitDao.deleteVisit(startVisitModel);


    }

    public List<StartVisitModel> getStartedVisit() {
        return startVisitDao.getStartedVisits();
    }

    public void startVisit(String visitId) {
        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().startInspectionVisit(visitId).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null) {
                        Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {

                }
            });
        } else {
            Toast.makeText(application, "hi from offline", Toast.LENGTH_SHORT).show();
            startVisitDao.addVisit(new StartVisitModel(visitId, 0));

            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).build();
            workManager.enqueue(saveData);


//             service = new Intent(application, Services.class);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                application.startForegroundService(service);
//            }else
//                application.startService(service);
//


//
//            intent.setAction("android.net.conn.CONNECTIVITY_CHANGE");
//            intent.putExtra("id" , visitId);
//            intent.putExtra("type" , "start");
//            application.sendBroadcast(intent);


//            IntentFilter filter = new IntentFilter();
//
//            application.registerReceiver(new NetworkChangeReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));


//             application.registerReceiver(new NetworkChangeReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));


            //Intent intent = new Intent(application , )
        }


    }


    public int getRecommendationCount() {
        return inspectionRecommendationDao.getDataCount();
    }

    public void deleteInspectionRecommendation(InspectionRecommendationModel inspectionRecommendationModel) {
        inspectionRecommendationDao.deleteRecommendation(inspectionRecommendationModel);
    }

    public List<InspectionRecommendationModel> getReccomendations() {
        return inspectionRecommendationDao.getRecommendations();
    }

    public void storeInspectionRecommendation(String constructId, String recommendationId,
                                              String adptedId,
                                              String actionId, String machineName,
                                              String actionDate, String visitId, String userId) {

        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().storeInspectionRecommendation(constructId, recommendationId, adptedId, actionId, machineName, actionDate, visitId, userId).enqueue(new Callback<UpdateUser>() {
                @Override
                public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<UpdateUser> call, Throwable t) {

                }
            });
        } else {

            inspectionRecommendationDao.addVisit(new InspectionRecommendationModel(constructId, recommendationId, adptedId, actionId, machineName, actionDate, visitId, userId));

            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("recommendation").build();

            workManager.enqueue(saveData);


        }

    }


    //////
    public int getInspectionResultCount() {
        return inspectionVisitResultDao.getDataCount();
    }

    public void deleteInspectionResult(InspectionVisitResult inspectionVisitResult) {
        inspectionVisitResultDao.deleteResult(inspectionVisitResult);
    }

    public List<InspectionVisitResult> getInspectionVisitResults() {
        return inspectionVisitResultDao.getResults();
    }

    public void storeInspection(String constructId, String actionId,
                                String recommendationId, String placementId,
                                String date, String reason,
                                String machineName, String visitId, String userId) {

        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().storeInspectionVisitResult(constructId, actionId, recommendationId, placementId, date, reason, machineName, visitId, userId).enqueue(new Callback<UpdateUser>() {
                @Override
                public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<UpdateUser> call, Throwable t) {

                }
            });
        } else {

            inspectionVisitResultDao.addResult(new InspectionVisitResult(constructId, actionId, recommendationId, placementId, date, reason, machineName, visitId, userId));

            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("inspectionResult").build();

            workManager.enqueue(saveData);


        }

    }


    //////
    public int getInspectionRevisitCount() {
        return inspectionRevisitDao.getDataCount();
    }

    public void deleteInspectionRevisit(InspectionRevisit inspectionRevisit) {
        inspectionRevisitDao.deleteRevisit(inspectionRevisit);
    }

    public List<InspectionRevisit> getInspectionRevisit() {
        return inspectionRevisitDao.getRevisits();
    }

    public void storeInspectionRevisit(String constructId, String violationRemoval, String actionId, String recommendationId, String placmentId, String machineName, String reason, String date, String visitId) {

        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().storeInspectionRevisit(constructId, violationRemoval, actionId, recommendationId, placmentId, machineName, reason, date, visitId).enqueue(new Callback<UpdateUser>() {
                @Override
                public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<UpdateUser> call, Throwable t) {

                }
            });
        } else {

            inspectionRevisitDao.addRevisit(new InspectionRevisit(constructId, violationRemoval, actionId, recommendationId, placmentId, machineName, reason, date, visitId));

            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("inspectionRevisit").build();

            workManager.enqueue(saveData);


        }

    }

    //////////////////////////SafetyQuestion
    public int getQuestionsAnswerCount() {
        return questionsAnswerDao.getDataCount();
    }

    public void deleteQuestionsAnswer(QuestionsAnswer questionsAnswer) {
        questionsAnswerDao.deleteQuestionsAnswer(questionsAnswer);
    }

    public List<QuestionsAnswer> getQuestionsAnswer() {
        return questionsAnswerDao.getQuestionsAnswer();
    }

    public void storeQuestionsAnswer(String constructId, @NonNull String visitId, ArrayList<HashMap<String, String>> answers, String userId) {

        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().storeQuestionsAnswers(constructId, visitId, StringTypeConverter.fromStringMap(answers), userId).enqueue(new Callback<UpdateUser>() {
                @Override
                public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<UpdateUser> call, Throwable t) {

                }
            });
        } else {

            questionsAnswerDao.addQuestionsAnswer(new QuestionsAnswer(constructId, visitId, StringTypeConverter.fromStringMap(answers), userId));

            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("questionAnswer").build();

            workManager.enqueue(saveData);


        }

    }

    ////////////////////////////////////ConstructionBasicInfo///////////////////////


    public int getConstructionBasicDataCount() {
        return constructionBasicInfoDao.getDataCount();
    }

    public void deleteConstructionBasicData(ConstructionBasicInfo model) {
        constructionBasicInfoDao.deleteConstructionBasicInfo(model);
    }

    public List<ConstructionBasicInfo> getConstructionBasicInfo() {
        return constructionBasicInfoDao.getConstructionBasicInfo();
    }

    public void storeConstructionBasicInfo(String action, String constructId, String addressId, String constructionNumber, String visitDate, String nameUsing, String nameOfficial, String municipapiityId, String regionId, String streetId, String streetDetails, String buldingNo, String addressDesc, String xDirection, String yDirections, String telephone, String mobile, String fax, String box, String url, String email, String riskLevelId, @NonNull String visitId, String submitAction) {

        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().storeConstructionBasicInfo(action, constructId, addressId, constructionNumber, visitDate, nameUsing, nameOfficial, municipapiityId, regionId, streetId, streetDetails, buldingNo, addressDesc, xDirection, yDirections, telephone, mobile, fax, box, url, email, riskLevelId, visitId, submitAction).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {

                }
            });
        } else {

            constructionBasicInfoDao.addConstructionBasicInfo(new ConstructionBasicInfo(action, constructId, addressId, constructionNumber, visitDate, nameUsing, nameOfficial, municipapiityId, regionId, streetId, streetDetails, buldingNo, addressDesc, xDirection, yDirections, telephone, mobile, fax, box, url, email, riskLevelId, visitId, submitAction)
            );

            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("ConstructionBasicData").build();

            workManager.enqueue(saveData);


        }

    }

    ////////////////////////////////////Legal Entity//////////////////////////////////
    public int getLegalEntityCount() {
        return addLegalDataDao.getDataCount();
    }

    public void deleteLegalEntityData(AddLegalEntityData model) {
        addLegalDataDao.deleteLegalData(model);
    }

    public List<AddLegalEntityData> getLegalEntity() {
        return addLegalDataDao.getAddLegalData();
    }

    public void storeLegalEntityData(String action, @NonNull String constructId, String bossIdentify, String bossIdentify2, String type, String legalId, String constructinType, String ownerShipId, String mainEconomicActivityId, String mainDsec, String sessionId, String year, String workStatusSecId, String foundationNum, String employeeNum, String startWork, String endWork, String visitId, String submitAction) {
        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().addLegalEntity(action, constructId, bossIdentify, bossIdentify2, type, legalId, constructinType, ownerShipId, mainEconomicActivityId, mainDsec, sessionId, year, workStatusSecId, foundationNum, employeeNum, startWork, endWork, visitId, submitAction).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {

                }
            });
        } else {

            addLegalDataDao.addLegalModel(new AddLegalEntityData(action, constructId, bossIdentify, bossIdentify2, type, legalId, constructinType, ownerShipId, mainEconomicActivityId, mainDsec, sessionId, year, workStatusSecId, foundationNum, employeeNum, startWork, endWork, visitId, submitAction));
            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("legalEntity").build();

            workManager.enqueue(saveData);


        }

    }
///////////////////////////////Add License side////////////////////


    public void deleteLicenseSideData(AddLicenseData model) {
        addLicenseDao.deleteLicense(model);
    }

    public List<AddLicenseData> getAddLicenseSide(String type) {
        return addLicenseDao.getAddLicenseData(type);
    }

    public void storeLicenseSide(String constructId, @NonNull String licenseId, String licenseNumber, String visitId, MultipartBody.Part file) {

        if (NetworkUtils.isOnline(application)) {

            HashMap<String, RequestBody> hashMap = new HashMap<>();
            RequestBody constructIdRB = RequestBody.create(constructId, MediaType.parse("multipart/form-data"));
            RequestBody constructLicenseIdRB = RequestBody.create(licenseId, MediaType.parse("multipart/form-data"));
            RequestBody licenseNumberRB = RequestBody.create(licenseNumber, MediaType.parse("multipart/form-data"));
            RequestBody visitIdRB = RequestBody.create(visitId, MediaType.parse("multipart/form-data"));
            RequestBody typeRB = RequestBody.create("0", MediaType.parse("multipart/form-data"));

            hashMap.put("CONSTRUCT_ID", constructIdRB);
            hashMap.put("CONSTRUCT_LICENCE_ID", constructLicenseIdRB);
            hashMap.put("CONSTRUCT_LICENCE_NUM", licenseNumberRB);
            hashMap.put("VISIT_ID", visitIdRB);
            hashMap.put("type", typeRB);


            networkUtils.getApiInterface().addLicenseSide(hashMap, file).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {

                }
            });
        } else {

            addLicenseDao.addLicenseModel(new AddLicenseData(constructId, licenseId, licenseNumber, visitId, "license"));

            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("licenseSide").build();

            workManager.enqueue(saveData);


        }

    }

//////////////////////////////Add Registered side ////////////////////


    public void deleteRegisteredSideData(AddLicenseData model) {
        addLicenseDao.deleteLicense(model);
    }

    public List<AddLicenseData> getAddRegisteredSide(String type) {
        return addLicenseDao.getAddLicenseData(type);
    }

    public void storeRegisteredSide(String constructId, @NonNull String registeredId, String registeredNumber, String visitId, MultipartBody.Part file) {

        if (NetworkUtils.isOnline(application)) {

            HashMap<String, RequestBody> hashMap = new HashMap<>();
            RequestBody constructIdRB = RequestBody.create(constructId, MediaType.parse("multipart/form-data"));
            RequestBody registeredIdIdRB = RequestBody.create(registeredId, MediaType.parse("multipart/form-data"));
            RequestBody registeredNumberRB = RequestBody.create(registeredNumber, MediaType.parse("multipart/form-data"));
            RequestBody visitIdRB = RequestBody.create(visitId, MediaType.parse("multipart/form-data"));
            RequestBody typeRB = RequestBody.create("0", MediaType.parse("multipart/form-data"));

            hashMap.put("CONSTRUCT_ID", constructIdRB);
            hashMap.put("CONSTRUCT_REG_ID", registeredIdIdRB);
            hashMap.put("CONSTRUCT_REG_NUM", registeredNumberRB);
            hashMap.put("VISIT_ID", visitIdRB);
            hashMap.put("type", typeRB);


            networkUtils.getApiInterface().addRegisteredSide(hashMap, file).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {

                }
            });
        } else {

            addLicenseDao.addLicenseModel(new AddLicenseData(constructId, registeredId, registeredNumber, visitId, "registered"));

            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("registeredSide").build();

            workManager.enqueue(saveData);


        }

    }
    //////////////////////////Add License info ///////////////////


    public void deleteLicenseInfo(AddLicenseInfo licenseInfo) {
        addLicenseInfoDao.deleteLicenseInfo(licenseInfo);
    }

    public List<AddLicenseInfo> getLicenseInfo() {
        return addLicenseInfoDao.getAddLicenseInfo();
    }

    public void storeLicenseInfo(String action, String constructId, String isPolicy, String isReg, String isLicensed, String insuranceEndDate, String capital, String type, String insuranceId, String insuranceNum, String isInternalSys, String isCertificateYN, String workHoursSum, String workTime, String incomeId, @NonNull String visitId, String submitAction) {

        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().storeLicenseInfo(action, constructId, isPolicy, isReg, isLicensed, insuranceEndDate, capital, type, insuranceId, insuranceNum, isInternalSys, isCertificateYN, workHoursSum, workTime, incomeId, visitId, submitAction).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {

                }
            });
        } else {


            addLicenseInfoDao.addLicenseInfo(new AddLicenseInfo(action, constructId, isPolicy, isReg, isLicensed, insuranceEndDate, capital, type, insuranceId, insuranceNum, isInternalSys, isCertificateYN, workHoursSum, workTime, incomeId, visitId, submitAction));
            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("licenseInfo").build();

            workManager.enqueue(saveData);


        }

    }
    ////////////////////////////add secondary sector ////////////////////////////


    public void deleteAddSecondarySector(AddSecondarySector model) {
        addSecondarySectorDao.deleteSecondarySector(model);
    }

    public List<AddSecondarySector> getSecondarySector() {
        return addSecondarySectorDao.getSecondarySector();
    }

    public void storeSecondarySector(String constructId, @NonNull String sectorId, String sectorDescription) {

        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().addSecondaryWork(constructId, sectorId, sectorDescription).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {

                }
            });
        } else {


            addSecondarySectorDao.addSecondarySector(new AddSecondarySector(constructId, sectorId, sectorDescription));
            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("secondarySector").build();

            workManager.enqueue(saveData);


        }

    }


    ///////////////////////Boss ///////////////////////////////


    public int getBossCount() {
        return bossDao.getDataCount();
    }

    public void deleteBossModel(BossModel bossModel) {
        bossDao.deleteBossModel(bossModel);
    }

    public List<BossModel> getBossModel() {
        return bossDao.getBossModel();
    }

    public void storeBossModel(String constructId, String constantInformative, String userSn,
                               String informativeType, String description,
                               String visitId, String type, String submitAction) {

        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().storeBossData(constructId, constantInformative, userSn, informativeType, description, visitId, type, submitAction).enqueue(new Callback<ActionModel>() {
                @Override
                public void onResponse(Call<ActionModel> call, Response<ActionModel> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ActionModel> call, Throwable t) {

                }
            });
        } else {

            bossDao.addBossModel(new BossModel(constructId, constantInformative, userSn, informativeType, description, visitId, type, submitAction));

            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("BossModel").build();

            workManager.enqueue(saveData);


        }

    }
    ////////////////////////////////Add Worker ////////////////////////

    public int getAddWorkerCount() {
        return addWorkerDao.getDataCount();
    }

    public void deleteAddWorkerModel(AddWorkerModel addWorkerModel) {
        addWorkerDao.deleteAddWorkerModel(addWorkerModel);
    }

    public List<AddWorkerModel> getAddWorkerModel() {
        return addWorkerDao.getAddWorker();
    }

    public void storeAddWorker(String constructId, @NonNull String workerSn, String perExam, String primExam, String haveCertificate, String workTypeId, String workTypeDescId, String workTypeDescDescId, String startDate, String endDate, String leaveDate, String leaveReason, String currencyId, String salary, String payId, String jobId, String skillLevelId, String contractId, String visitId) {

        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().addWorker(constructId, workerSn, perExam, primExam, haveCertificate, workTypeId, workTypeDescId, workTypeDescDescId, startDate, endDate, leaveDate, leaveReason, currencyId, salary, payId, jobId, skillLevelId, contractId, visitId).enqueue(new Callback<UpdateUser>() {
                @Override
                public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<UpdateUser> call, Throwable t) {

                }
            });
        } else {
            addWorkerDao.addAddWorkerModel(new AddWorkerModel(constructId, workerSn, perExam, primExam, haveCertificate, workTypeId, workTypeDescId, workTypeDescDescId, startDate, endDate, leaveDate, leaveReason, currencyId, salary, payId, jobId, skillLevelId, contractId, visitId));
            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("addWorker").build();

            workManager.enqueue(saveData);


        }

    }


/////////////////////////////////////////////////AddWorkerHealth////////////////

    public int getAddWorkerHealthCount() {
        return addWorkerHealthDao.getDataCount();
    }

    public void deleteAddWorkerHealthModel(AddWorkerHealthModel addWorkerModel) {
        addWorkerHealthDao.deleteAddWorkerHealthModel(addWorkerModel);
    }

    public List<AddWorkerHealthModel> getAddWorkerHealthModel() {
        return addWorkerHealthDao.getAddWorkerHealth();
    }

    public void storeAddWorkerHealth(AddWorkerHealthModel model) {

        if (!NetworkUtils.isOnline(application)) {
            addWorkerHealthDao.addAddWorkerHealthModel(model);
            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("addWorkerHealth").build();

            workManager.enqueue(saveData);


        }

    }
/////////////////////////////////////////////Add Owner //////////////////////////////////////////

    public int getAddOwnerCount() {
        return addOwnerDao.getDataCount();
    }

    public void deleteOwnerModel(AddOwnerModel addOwnerModel) {
        addOwnerDao.deleteOwnerModel(addOwnerModel);
    }

    public List<AddOwnerModel> getAddOwnerModel() {
        return addOwnerDao.getAddOwner();
    }

    public void storeAddOwner(String constructId, String userSn, String userId, String startDate, String visitId, String type) {

        if (NetworkUtils.isOnline(application)) {
            networkUtils.getApiInterface().addOwner(constructId, userSn, userId, startDate, visitId, type).enqueue(new Callback<UpdateUser>() {
                @Override
                public void onResponse(Call<UpdateUser> call, Response<UpdateUser> response) {
                    if (response.body() != null)
                        Toast.makeText(application, response.body().getMessageText(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<UpdateUser> call, Throwable t) {

                }
            });
        } else {
            addOwnerDao.addAddOwnerModel(new AddOwnerModel(constructId, userSn, userId, startDate, visitId, type));
            WorkManager workManager = WorkManager.getInstance(application);

            Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest saveData = new OneTimeWorkRequest.Builder(RequestWorker.class).setConstraints(constraints).setInitialDelay(10, TimeUnit.SECONDS).addTag("addOwner").build();

            workManager.enqueue(saveData);


        }

    }

    ////////////////////////Economic sector /////////////////////////////////
    public LiveData<List<EconomicSector>> getEconomicSector(String keyword) {
        String search = "%" + keyword + "%";
        if (NetworkUtils.isOnline(application))
            updateEconomicSector(search);
        return economicSectorDao.getEconomicSector(search);
    }

    public void updateEconomicSector(String keyword) {
        networkUtils.getApiInterface().getEconomicSector(keyword).enqueue(new Callback<EconomicSectorModel>() {
            @Override
            public void onResponse(Call<EconomicSectorModel> call, Response<EconomicSectorModel> response) {
                if (response.isSuccessful()) {

                    if (response.body()!=null && response.body().getStatus() != 1 &&response.body().getResults() != null && (response.body().getResults().size() != economicSectorDao.getDataCount())) {
                        List<EconomicSector> economicSectors = response.body().getResults();
                        for (EconomicSector economicSector : economicSectors)
                            economicSectorDao.addEconomicSector(economicSector);
                    }
                }
            }

            @Override
            public void onFailure(Call<EconomicSectorModel> call, Throwable t) {
            }
        });
    }


    ///////////////////////
    public void updateLanguages() {
        networkUtils.getApiInterface().getLanguages().enqueue(new Callback<LanguagesModel>() {
            @Override
            public void onResponse(Call<LanguagesModel> call, Response<LanguagesModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        if (response.body().getLanguages().size() != languagesDao.getDataCount()) {

                            List<Language> languages = response.body().getLanguages();
                            for (Language language : languages) {
                                languagesDao.addLanguage(language);


                            }
                        }
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<LanguagesModel> call, Throwable t) {
                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //work status
    public LiveData<List<WorkStatus>> getAllWorkStatuses() {
        if (NetworkUtils.isOnline(application))
            updateWorkStatus();
        return workStatusDao.getAllWorkStatuses();
    }

    public void updateWorkStatus() {
        networkUtils.getApiInterface().getWorkStatus().enqueue(new Callback<WorkStatusModel>() {
            @Override
            public void onResponse(Call<WorkStatusModel> call, Response<WorkStatusModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        if (response.body().getWorkStatus().size() != workStatusDao.getDataCount()) {

                            List<WorkStatus> workStatuses = response.body().getWorkStatus();
                            for (WorkStatus workStatus : workStatuses) {
                                workStatusDao.addWorkStatus(workStatus);

                            }
                        }
                    }
                } else {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WorkStatusModel> call, Throwable t) {

                Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }


    //Insurance company

    public LiveData<List<InsuranceCompany>> getInsuranceCompanies() {
        if (NetworkUtils.isOnline(application))
            updateInsuranceCompanies();
        return insuranceCompanyDao.getAllInsuranceCompany();
    }

    public void updateInsuranceCompanies() {
        networkUtils.getApiInterface().getInsuranceCompany().enqueue(new Callback<InsuranceCompanyModel>() {
            @Override
            public void onResponse(Call<InsuranceCompanyModel> call, Response<InsuranceCompanyModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {

                        if (response.body().getInsuranceCompanies().size() != insuranceCompanyDao.getDataCount()) {

                            List<InsuranceCompany> insuranceCompanies = response.body().getInsuranceCompanies();
                            for (InsuranceCompany insuranceCompany : insuranceCompanies) {
                                insuranceCompanyDao.addInsuranceCompany(insuranceCompany);


                            }
                        }
                    }
                } else {

                        Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<InsuranceCompanyModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //jobs
    public LiveData<List<Job>> getAllJobs() {
        if (NetworkUtils.isOnline(application))
            updateJobs();
        return jobsDao.getAllJobs();
    }

    public void updateJobs() {
        networkUtils.getApiInterface().getJobs().enqueue(new Callback<JobsModel>() {
            @Override
            public void onResponse(Call<JobsModel> call, Response<JobsModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getJobs().size() != jobsDao.getDataCount()) {
                        List<Job> jobs = response.body().getJobs();
                        for (Job job : jobs)
                            jobsDao.addJob(job);
                    }
                }
            }

            @Override
            public void onFailure(Call<JobsModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public LiveData<List<JobList>> getJobList(String keyword) {
        String search = "%" + keyword + "%";
        if (NetworkUtils.isOnline(application))
            updateJobList(search);
        return jobListDao.getAllJobs(search);
    }

    public void updateJobList(String keyword) {
        networkUtils.getApiInterface().getJobLists(keyword).enqueue(new Callback<JobListModel>() {
            @Override
            public void onResponse(Call<JobListModel> call, Response<JobListModel> response) {
                if (response.isSuccessful()) {

                    if (response.body().getResults() != null && (response.body().getResults().size() != jobsDao.getDataCount())) {
                        List<JobList> jobs = response.body().getResults();
                        for (JobList job : jobs)
                            jobListDao.addJob(job);
                    }
                }
            }

            @Override
            public void onFailure(Call<JobListModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }


    //eduQualification
    public LiveData<List<EduQualification>> getAllEduQualification(String eduTypeId) {
        if (NetworkUtils.isOnline(application))
            updateEduQualification(eduTypeId);
        return eduQualificationDao.getAllEduQualification(eduTypeId);
    }

    public void updateEduQualification(String eduTypeId) {
        networkUtils.getApiInterface().getEduQualification(eduTypeId).enqueue(new Callback<EduQualificationModel>() {
            @Override
            public void onResponse(Call<EduQualificationModel> call, Response<EduQualificationModel> response) {
                if (response.isSuccessful() && response.body()!= null && response.body().getEduQualifications()!= null) {
                    if (response.body().getEduQualifications().size() != eduQualificationDao.getDataCount()) {
                        List<EduQualification> eduQualifications = response.body().getEduQualifications();
                        for (EduQualification eduQualification : eduQualifications) {
                            eduQualification.seteDUTYPEID(eduTypeId);
                            eduQualificationDao.addEduQualification(eduQualification);
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<EduQualificationModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }


    //eduQualificationDetails
    public LiveData<List<EduQualificationDetail>> getAllEduQualificationDetail(String eduTypeId) {
        if (NetworkUtils.isOnline(application))
            updateEduQualificationDetail(eduTypeId);
        return eduQualificationDetailDao.getAllEduQualification(eduTypeId);
    }

    public void updateEduQualificationDetail(String eduTypeId) {
        networkUtils.getApiInterface().getEduQualificationDetails(eduTypeId).enqueue(new Callback<EduQualificationDetailModel>() {
            @Override
            public void onResponse(Call<EduQualificationDetailModel> call, Response<EduQualificationDetailModel> response) {
                if (response.isSuccessful() && response.body() != null &&  response.body().getEduQualificationDetails() != null) {
                    if (response.body().getEduQualificationDetails().size() != eduQualificationDetailDao.getDataCount()) {
                        List<EduQualificationDetail> eduQualificationDetails = response.body().getEduQualificationDetails();
                        for (EduQualificationDetail eduQualificationDetail : eduQualificationDetails) {
                            eduQualificationDetail.setQUALDETAILSEDUTYPEID(eduTypeId);
                            eduQualificationDetailDao.addEduQualificationDetail(eduQualificationDetail);
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<EduQualificationDetailModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //constants
    public LiveData<List<Constants>> getAllConstants(String constantId) {

        if (NetworkUtils.isOnline(application))
            updateConstants(constantId);
        return constantsDao.getConstants(constantId);
    }


    public LiveData<String> getConstantName(String constantId, String parentId) {
        if (NetworkUtils.isOnline(application))
            updateConstants(parentId);
        return constantsDao.getConstantName(constantId);
    }

    public void updateConstants(String constantId) {
        networkUtils.getApiInterface().getConstants(constantId).enqueue(new Callback<ConstantsModel>() {
            @Override
            public void onResponse(Call<ConstantsModel> call, Response<ConstantsModel> response) {
                if (response.body() != null) {
                    List<String> apiDates = new ArrayList<>();
                    List<String> dbDates = new ArrayList<>();
//                    for (Constants constant : response.body().getConstants()) {
//                        if (constant.getUPDATEDATE() != null)
//                            System.out.println(" api : " + constant.getUPDATEDATE().toString() + " constant : " + constant.getCONSTANTARANAME());
//                        //   apiDates.add(constant.getUPDATEDATE().toString());
//                    }
////                    long maxApiDate = MaxDate(apiDates);
//                    for (Object object : constantsDao.getMaxDate(constantId)) {
//                        if (object != null)
//                            System.out.println(" object : " + object.toString());
//                        //   dbDates.add(object.toString());
//                    }
//                    long maxDbDate = MaxDate(dbDates);
//                    if (maxApiDate != -1 && maxDbDate != -1)
//                        if (maxApiDate != maxDbDate)
//                            System.out.println("the two dates do not match");
                    if (response.body().getConstants().size() != constantsDao.getDataCount(constantId)) {
                        List<Constants> constants = response.body().getConstants();
                        for (Constants constant : constants) {
                            constantsDao.addConstant(constant);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ConstantsModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();            }
        });
    }

    public long MaxDate(List<String> dates) {
        if (dates.isEmpty())
            return -1;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        Date maxDate = null;
        try {
            maxDate = sdf.parse(dates.get(0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < dates.size(); i++) {
            System.out.println(dates.get(i));
            Date strDate = null;
            try {
                strDate = sdf.parse(dates.get(i));
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            if (strDate.getTime() > maxDate.getTime()) {
//                System.out.println("wejdan date" + strDate.getTime() + "   " + maxDate.getTime());
//                maxDate = strDate;
//            } else {
//                System.out.println("wejdan date" + strDate.getTime() + "   " + maxDate.getTime());
//            }
        }
//        return maxDate.getTime();
        return -1;
    }

    //municipalities
    public LiveData<List<Municipality>> getAllMunicipalities(String directorId) {
        if (NetworkUtils.isOnline(application))
            updateMunicipalities();
        return municipalitiesDao.getAllMunicipalities(directorId);
    }

    public void updateMunicipalities() {
        Call<MunicipalityModel> call = networkUtils.getApiInterface().getMunicipalities();
        call.enqueue(new Callback<MunicipalityModel>() {
            @Override
            public void onResponse(@NotNull Call<MunicipalityModel> call, @NotNull Response<MunicipalityModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getMunicipalities() != null && response.body().getMunicipalities().size() != municipalitiesDao.getDataCount()) {
                        List<Municipality> municipalities = response.body().getMunicipalities();
                        for (Municipality municipality : municipalities)
                            municipalitiesDao.addMunicipality(municipality);
                    }
                }
            }

            @Override
            public void onFailure(Call<MunicipalityModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //regions
    public LiveData<List<Region>> getAllRegions(String directorateId) {
        if (NetworkUtils.isOnline(application))
            updateRegions(directorateId);
        return regionsDao.getAllRegions(directorateId);
    }

    public void updateRegions(String directorateId) {
        Call<RegionsModel> call = networkUtils.getApiInterface().getRegions(directorateId);
        call.enqueue(new Callback<RegionsModel>() {
            @Override
            public void onResponse(Call<RegionsModel> call, Response<RegionsModel> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null && response.body().getRegions() != null) {
                        List<Region> regions = response.body().getRegions();
                        for (Region region : regions)
                            regionsDao.addRegion(region);
                    }
                }
            }

            @Override
            public void onFailure(Call<RegionsModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //job titles
    public LiveData<List<JobTitle>> getAllJobTitles() {
        if (NetworkUtils.isOnline(application))

        updateJobTitles();
        return jobTitlesDao.getAllJobTitles();
    }

    public void updateJobTitles() {
        Call<JobTitlesModel> call = networkUtils.getApiInterface().getJobTitles();
        call.enqueue(new Callback<JobTitlesModel>() {
            @Override
            public void onResponse(Call<JobTitlesModel> call, Response<JobTitlesModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getJobTitles().size() != jobTitlesDao.getDataCount()) {
                        List<JobTitle> jobTitles = response.body().getJobTitles();
                        for (JobTitle jobTitle : jobTitles)
                            jobTitlesDao.addJobTitle(jobTitle);
                    }
                }
            }

            @Override
            public void onFailure(Call<JobTitlesModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //cities
    public LiveData<List<City>> getAllCities() {
        if (NetworkUtils.isOnline(application))
            updateCities();
        return citiesDao.getAllCities();
    }

    public void updateCities() {
        networkUtils.getApiInterface().getCities().enqueue(new Callback<CitiesModel>() {
            @Override
            public void onResponse(Call<CitiesModel> call, Response<CitiesModel> response) {
                if (response.isSuccessful())
                    if (response.body().getCities().size() != citiesDao.getDataCount())
                        for (City city : response.body().getCities())
                            citiesDao.addCity(city);
            }

            @Override
            public void onFailure(Call<CitiesModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }

        });
    }


    public LiveData<SafetyQuestionArray> getAllSafetyQuestions() {
        if (NetworkUtils.isOnline(application))
            safetyQuestions();


        return safetyQuestionsArrayDao.getSafetyQuestions();
    }


    public void safetyQuestions() {
        networkUtils.getApiInterface().getSafetyQuestions().enqueue(new Callback<SafetyQuestionsModel>() {
            @Override
            public void onResponse(Call<SafetyQuestionsModel> call, Response<SafetyQuestionsModel> response) {
                if (response.body() != null && response.body().getSafetyQuestions() != null) {

                    safetyQuestionsArrayDao.addSafetyQuestions(response.body().getSafetyQuestions());

                }
            }

            @Override
            public void onFailure(Call<SafetyQuestionsModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });


    }


    //directors
    public LiveData<List<Director>> getAllDirectors() {
        if (NetworkUtils.isOnline(application))
            updateDirectors();
        return directorsDao.getAllDirectors();
    }

    public void updateDirectors() {
        networkUtils.getApiInterface().getDirectors().enqueue(new Callback<DirectorsModel>() {
            @Override
            public void onResponse(Call<DirectorsModel> call, Response<DirectorsModel> response) {
                if (response.isSuccessful())
                    if (response.body().getDirectors().size() != directorsDao.getDataCount())
                        for (Director director : response.body().getDirectors())
                            directorsDao.addDirector(director);
            }

            @Override
            public void onFailure(Call<DirectorsModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //edu programs
    public LiveData<List<EduProgram>> getAllEduPrograms() {
        if (NetworkUtils.isOnline(application))

        updateEduPrograms();
        return eduProgramDao.getAllEduPrograms();
    }

    public void updateEduPrograms() {
        networkUtils.getApiInterface().getEduPrograms().enqueue(new Callback<EduProgramsModel>() {
            @Override
            public void onResponse(Call<EduProgramsModel> call, Response<EduProgramsModel> response) {
                if (response.isSuccessful())
                    if (response.body().getEduPrograms().size() != eduProgramDao.getDataCount())
                        for (EduProgram eduProgram : response.body().getEduPrograms())
                            eduProgramDao.addEduProgram(eduProgram);
            }

            @Override
            public void onFailure(Call<EduProgramsModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //educational institutes
    public LiveData<List<EducationalInstitute>> getAllEducationalInstitutes() {
        if (NetworkUtils.isOnline(application))

        updateEducationalInstitutes();
        return educationalInstituteDao.getAllEducationalInstitutes();
    }

    public void updateEducationalInstitutes() {
        networkUtils.getApiInterface().getEducationalInstitutes().enqueue(new Callback<EducationalInstitutesModel>() {
            @Override
            public void onResponse(Call<EducationalInstitutesModel> call, Response<EducationalInstitutesModel> response) {
                if (response.isSuccessful())
                    if (response.body().getEducationalInstitutes().size() != educationalInstituteDao.getDataCount())
                        for (EducationalInstitute educationalInstitute : response.body().getEducationalInstitutes())
                            educationalInstituteDao.addEducationalInstitute(educationalInstitute);
            }

            @Override
            public void onFailure(Call<EducationalInstitutesModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //training institutes
    public LiveData<List<TrainingInstitute>> getAllTrainingInstitutes(String keyword) {
        if (NetworkUtils.isOnline(application))

        updateTrainingInstitutes(keyword);
        return trainingInstituteDao.getAllTrainingInstitutes();
    }

    public void updateTrainingInstitutes(String keyword) {
        networkUtils.getApiInterface().getTrainingInstitutes(keyword).enqueue(new Callback<TrainingInstitutesModel>() {
            @Override
            public void onResponse(Call<TrainingInstitutesModel> call, Response<TrainingInstitutesModel> response) {
                if (response.isSuccessful())
                    if (response.body()!= null && response.body().getStatus() != 1 && response.body().getTrainingInstitutes().size() != trainingInstituteDao.getDataCount())
                        for (TrainingInstitute trainingInstitute : response.body().getTrainingInstitutes())
                            trainingInstituteDao.addTrainingInstitute(trainingInstitute);
            }

            @Override
            public void onFailure(Call<TrainingInstitutesModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //training programs
    public LiveData<List<TrainingProgram>> getAllTrainingPrograms(String key) {
        if (NetworkUtils.isOnline(application))
        updateTrainingPrograms(key);
        return trainingProgramDao.getAllTrainingPrograms("%" + key + "%");
    }

    public void updateTrainingPrograms(String key) {
        networkUtils.getApiInterface().getTrainingPrograms(key).enqueue(new Callback<TrainingProgramsModel>() {
            @Override
            public void onResponse(@NotNull Call<TrainingProgramsModel> call, @NotNull Response<TrainingProgramsModel> response) {
                if (response.body() != null && response.body().getStatus() != 1 ) {

//                    if (response.body().getTrainingPrograms().size() != trainingProgramDao.getDataCount())
                    //trainingProgramDao.getAllTrainingPrograms(key);
                    for (TrainingProgram trainingProgram : response.body().getTrainingPrograms())
                        trainingProgramDao.addTrainingProgram(trainingProgram);
                }

            }

            @Override
            public void onFailure(Call<TrainingProgramsModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //training side
    public LiveData<List<TrainingSide>> getAllTrainingSide(String keyword) {
        if (NetworkUtils.isOnline(application))

        updateTrainingSide(keyword);
        return trainingSideDao.getAllTrainingSide("%" + keyword + "%");
    }

    public void updateTrainingSide(String keyword) {
        networkUtils.getApiInterface().getTrainingSide(keyword).enqueue(new Callback<TrainingSideModel>() {
            @Override
            public void onResponse(Call<TrainingSideModel> call, Response<TrainingSideModel> response) {
                if (response.isSuccessful())
                    if (response.body() != null && response.body().getStatus() != 1)
//                    if (response.body().getTrainingPrograms().size() != trainingSideDao.getDataCount())
                        for (TrainingSide trainingSide : response.body().getTrainingPrograms())
                            trainingSideDao.addTrainingSide(trainingSide);
            }

            @Override
            public void onFailure(Call<TrainingSideModel> call, Throwable t) {

                    Toast.makeText(application, application.getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
