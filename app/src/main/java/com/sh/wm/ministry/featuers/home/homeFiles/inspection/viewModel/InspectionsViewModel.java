package com.sh.wm.ministry.featuers.home.homeFiles.inspection.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.ConstructLicenceInfo.ConstructLicenceInfoModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisitDataSource;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.legalEntity.LegalEntityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.legalEntity.secondaryActivity.SecondActivityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionArray;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionsModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.owner.ConstructionOwnerModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.registerSideInfo.ConstructRegisterInfoModel;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.repository.InspectionVisitRepository;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.network.database.dbModels.economicSector.EconomicSector;
import com.sh.wm.ministry.network.database.dbModels.insuranceCompany.InsuranceCompany;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.database.dbRepository.DBRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MultipartBody;


public class InspectionsViewModel extends AndroidViewModel {

    static InspectionVisitRepository inspectionVisitRepository;
    DBRepository dbRepository;

    public Flowable<PagingData<InspectionVisit>> pagingDataFlow;

    static String constructId;
    private Application application;

    public InspectionsViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        inspectionVisitRepository = InspectionVisitRepository.getInstance(application);
        dbRepository = DBRepository.getInstance(application);
    }

    public void getInspectionsVisit(String constructId) {

        InspectionVisitDataSource inspectionPagingSource = new InspectionVisitDataSource(application, constructId);




        // Create new Pager
        Pager<Integer, InspectionVisit> pager = new Pager(
                // Create new paging config
                new PagingConfig(10, // pageSize - Count of items in one page
                        10, // prefetchDistance - Number of items to prefetch
                        false, // enablePlaceholders - Enable placeholders for data which is not yet loaded
                        10, // initialLoadSize - Count of items to be loaded initially
                        20 * 499),// maxSize - Count of total items to be shown in recyclerview
                () -> inspectionPagingSource); // set paging source

        // inti Flowabl

        pagingDataFlow = PagingRx.getFlowable(pager);


        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        PagingRx.cachedIn(pagingDataFlow, coroutineScope);


    }


    public LiveData<SafetyQuestionArray>  safetyQuestions() {
     return dbRepository.getAllSafetyQuestions();
    }







    public void startVisit(String visitId) {
        dbRepository.startVisit(visitId);
        Log.d("aseel", dbRepository.getStartedVisitCount() + "");
    }


    public void storeQuestionsAnswer(String constructId, String visitId , ArrayList<HashMap<String , String>> answers , String userId) {
        dbRepository.storeQuestionsAnswer(constructId , visitId, answers , userId);
        Log.d("aseel", dbRepository.getQuestionsAnswer() + "questions");
    }

    public void storeInspection(String constructId, String actionId,
                                String recommendationId, String placementId,
                                String date, String reason,
                                String machineName, String visitId, String userId) {
        dbRepository.storeInspection(constructId, actionId, recommendationId, placementId, date, reason, machineName, visitId, userId);
    }


    public void storeInspectionRecommendation(String constructId, String recommendationId,
                                              String adptedId,
                                              String actionId, String machineName,
                                              String actionDate, String visitId, String userId) {
        dbRepository.storeInspectionRecommendation(constructId, recommendationId, adptedId, actionId, machineName, actionDate, visitId, userId);
    }

    public void storeInspectionRevisit(String constructId, String violationRemoval, String actionId, String recommendationId, String placmentId, String machineName, String reason, String date, String visitId) {
        dbRepository.storeInspectionRevisit(constructId, violationRemoval, actionId, recommendationId, placmentId, machineName, reason, date, visitId);
    }


    public void  storeBossModel(String constructId, String constantInformative, String userSn,
                                String informativeType, String description,
                                String visitId, String type, String submitAction){
        dbRepository.storeBossModel(constructId, constantInformative, userSn, informativeType, description, visitId, type, submitAction);
    }

    public LiveData<UserInfoModel> getUserInfo(String userSn){
        return inspectionVisitRepository.getUserInfo(userSn);
    }

    public void storeConstructionBasicInfo(String action, String constructId, String addressId, String constructionNumber, String visitDate, String nameUsing, String nameOfficial, String municipapiityId, String regionId, String streetId, String streetDetails, String buldingNo, String addressDesc, String xDirection, String yDirections, String telephone, String mobile, String fax, String box, String url, String email, String riskLevelId, @NonNull String visitId, String submitAction){
        dbRepository.storeConstructionBasicInfo(action, constructId, addressId, constructionNumber, visitDate, nameUsing, nameOfficial, municipapiityId, regionId, streetId, streetDetails, buldingNo, addressDesc, xDirection, yDirections, telephone, mobile, fax, box, url, email, riskLevelId, visitId, submitAction);
    }

    public void addWorkModel(String constructId, @NonNull String workerSn, String perExam, String primExam, String haveCertificate, String workTypeId, String workTypeDescId, String workTypeDescDescId, String startDate, String endDate, String leaveDate, String leaveReason, String currencyId, String salary, String payId, String jobId, String skillLevelId, String contractId, String visitId){
        dbRepository.storeAddWorker(constructId, workerSn, perExam, primExam, haveCertificate, workTypeId, workTypeDescId, workTypeDescDescId, startDate, endDate, leaveDate, leaveReason, currencyId, salary, payId, jobId, skillLevelId, contractId, visitId);
    }

    public LiveData<ConstructionOwnerModel> getConstructionOwner(String constructId){
        return inspectionVisitRepository.getConstructionOwner(constructId);
    }

    public LiveData<SecondActivityModel> getSecondaryActivity(String constructId){
        return inspectionVisitRepository.getSecondaryActivity(constructId);
    }

    public LiveData<LegalEntityModel> getLegalEntity(String constructId){
        return inspectionVisitRepository.getLegalEntity(constructId);
    }

    public void storeAddOwner(String constructId, String userSn, String userId, String startDate, String visitId, String type) {

        dbRepository.storeAddOwner(constructId, userSn, userId, startDate, visitId, type);

    }

    public void storeLegalEntityData(String action, @NonNull String constructId, String bossIdentify, String bossIdentify2, String type, String legalId, String constructinType, String ownerShipId, String mainEconomicActivityId, String mainDsec, String sessionId, String year, String workStatusSecId, String foundationNum, String employeeNum, String startWork, String endWork, String visitId, String submitAction){
        dbRepository.storeLegalEntityData(action, constructId, bossIdentify, bossIdentify2, type, legalId, constructinType, ownerShipId, mainEconomicActivityId, mainDsec, sessionId, year, workStatusSecId, foundationNum, employeeNum, startWork, endWork, visitId, submitAction);
    }


    public void storeLicenseSide(String constructId, @NonNull String licenseId, String licenseNumber, String visitId , MultipartBody.Part file){
        dbRepository.storeLicenseSide(constructId, licenseId, licenseNumber, visitId, file);
    }


    public void storeRegisteredSide(String constructId, @NonNull String registeredId, String registeredNumber, String visitId , MultipartBody.Part file){
        dbRepository.storeRegisteredSide(constructId, registeredId, registeredNumber, visitId, file);
    }

    public LiveData<List<InsuranceCompany>> getInsuranceCompanies(){
        return dbRepository.getInsuranceCompanies();
    }

    public void storeLicenseInfo(String action, String constructId, String isPolicy, String isReg, String isLicensed, String insuranceEndDate, String capital, String type, String insuranceId, String insuranceNum, String isInternalSys, String isCertificateYN, String workHoursSum, String workTime, String incomeId, @NonNull String visitId, String submitAction){
        dbRepository.storeLicenseInfo(action, constructId, isPolicy, isReg, isLicensed, insuranceEndDate, capital, type, insuranceId, insuranceNum, isInternalSys, isCertificateYN, workHoursSum, workTime, incomeId, visitId, submitAction);
    }

    public LiveData<ConstructRegisterInfoModel> getConstructRegisterSide(String constructId){
        return inspectionVisitRepository.getConstructRegisterSide(constructId);
    }

    public LiveData<ConstructLicenceInfoModel> getConstructLicenseSide(String constructId){
        return  inspectionVisitRepository.getConstructLicenseSide(constructId);
    }

    public LiveData<List<EconomicSector>> getEconomicSector(String keyword){
        return dbRepository.getEconomicSector(keyword);
    }

    public void storeSecondarySector(String constructId, @NonNull String sectorId, String sectorDescription){
        dbRepository.storeSecondarySector(constructId, sectorId, sectorDescription);
    }



    }
