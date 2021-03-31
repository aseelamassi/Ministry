package com.sh.wm.ministry.network.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionArray;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionsModel;
import com.sh.wm.ministry.network.database.dao.AddLegalDataDao;
import com.sh.wm.ministry.network.database.dao.AddLicenseDao;
import com.sh.wm.ministry.network.database.dao.AddLicenseInfoDao;
import com.sh.wm.ministry.network.database.dao.AddOwnerDao;
import com.sh.wm.ministry.network.database.dao.AddSecondarySectorDao;
import com.sh.wm.ministry.network.database.dao.AddWorkerDao;
import com.sh.wm.ministry.network.database.dao.AddWorkerHealthDao;
import com.sh.wm.ministry.network.database.dao.BossDao;
import com.sh.wm.ministry.network.database.dao.CitiesDao;
import com.sh.wm.ministry.network.database.dao.ConstructionBasicInfoDao;
import com.sh.wm.ministry.network.database.dao.DirectorsDao;
import com.sh.wm.ministry.network.database.dao.EconomicSectorDao;
import com.sh.wm.ministry.network.database.dao.EduProgramDao;
import com.sh.wm.ministry.network.database.dao.EduQualificationDao;
import com.sh.wm.ministry.network.database.dao.EduQualificationDetailDao;
import com.sh.wm.ministry.network.database.dao.EducationalInstituteDao;
import com.sh.wm.ministry.network.database.dao.InspectionRecommendation;
import com.sh.wm.ministry.network.database.dao.InspectionRevisitDao;
import com.sh.wm.ministry.network.database.dao.InspectionVisitDao;
import com.sh.wm.ministry.network.database.dao.InspectionVisitResultDao;
import com.sh.wm.ministry.network.database.dao.InsuranceCompanyDao;
import com.sh.wm.ministry.network.database.dao.JobListDao;
import com.sh.wm.ministry.network.database.dao.JobTitlesDao;
import com.sh.wm.ministry.network.database.dao.MunicipalitiesDao;
import com.sh.wm.ministry.network.database.dao.QuestionsAnswerDao;
import com.sh.wm.ministry.network.database.dao.RegionsDao;
import com.sh.wm.ministry.network.database.dao.RemoteKeysDao;
import com.sh.wm.ministry.network.database.dao.SafetyQuestionsArrayDao;
import com.sh.wm.ministry.network.database.dao.StartVisitDao;
import com.sh.wm.ministry.network.database.dao.TrainingInstituteDao;
import com.sh.wm.ministry.network.database.dao.TrainingProgramDao;
import com.sh.wm.ministry.network.database.dao.TrainingSideDao;
import com.sh.wm.ministry.network.database.dbModels.cities.City;
import com.sh.wm.ministry.network.database.dbModels.directors.Director;
import com.sh.wm.ministry.network.database.dbModels.economicSector.EconomicSector;
import com.sh.wm.ministry.network.database.dbModels.eduQualification.EduQualification;
import com.sh.wm.ministry.network.database.dbModels.eduQualificationDetail.EduQualificationDetail;
import com.sh.wm.ministry.network.database.dbModels.educationalinstitutes.EducationalInstitute;
import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgram;
import com.sh.wm.ministry.network.database.dbModels.insuranceCompany.InsuranceCompany;
import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitle;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality;
import com.sh.wm.ministry.network.database.convertors.DBConverter;
import com.sh.wm.ministry.network.database.dao.ConstantsDao;
import com.sh.wm.ministry.network.database.dao.CountriesDao;
import com.sh.wm.ministry.network.database.dao.JobsDao;
import com.sh.wm.ministry.network.database.dao.LanguagesDao;
import com.sh.wm.ministry.network.database.dao.WorkStatusDao;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbModels.jobs.Job;
import com.sh.wm.ministry.network.database.dbModels.languages.Language;
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
import com.sh.wm.ministry.network.database.dbModels.offlineModes.RemoteKeys;
import com.sh.wm.ministry.network.database.dbModels.offlineModes.StartVisitModel;
import com.sh.wm.ministry.network.database.dbModels.regions.Region;
import com.sh.wm.ministry.network.database.dbModels.trainingSide.TrainingSide;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitute;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus;
import com.sh.wm.ministry.network.utiels.ModelConverter;
import com.sh.wm.ministry.network.utiels.SingleTypeConverter;
import com.sh.wm.ministry.network.utiels.StringTypeConverter;


@Database(entities = {Language.class, WorkStatus.class, Constants.class, Job.class, Country.class, Municipality.class, Region.class, JobTitle.class,
        City.class, Director.class, EduProgram.class, EducationalInstitute.class, EconomicSector.class, AddSecondarySector.class,TrainingInstitute.class, TrainingProgram.class , TrainingSide.class , EduQualification.class , EduQualificationDetail.class , JobList.class, StartVisitModel.class, SafetyQuestionArray.class , InspectionVisitResult.class , InspectionRecommendationModel.class , InspectionRevisit.class , QuestionsAnswer.class, BossModel.class , ConstructionBasicInfo.class, AddWorkerModel.class , AddWorkerHealthModel.class, InspectionVisit.class, RemoteKeys.class, AddOwnerModel.class, AddLegalEntityData.class, AddLicenseData.class, InsuranceCompany.class, AddLicenseInfo.class}, version = 1, exportSchema = false)
@TypeConverters({DBConverter.class , StringTypeConverter.class , SingleTypeConverter.class , ModelConverter.class})


public abstract class DataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "db_ministry";
    private static DataBase sInstance;

    public static DataBase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    DataBase.class,
                    DATABASE_NAME).allowMainThreadQueries().build();

        }
        return sInstance;
    }

    public abstract CountriesDao countriesDao();
    public abstract LanguagesDao languagesDao();
    public abstract WorkStatusDao workStatusDao();
    public abstract JobsDao jobsDao();
    public abstract ConstantsDao constantsDao();
    public abstract MunicipalitiesDao municipalitiesDao();
    public abstract RegionsDao regionsDao();
    public abstract JobTitlesDao jobTitlesDao();
    public abstract CitiesDao citiesDao();
    public abstract DirectorsDao directorsDao();
    public abstract EduProgramDao eduProgramDao();
    public abstract EducationalInstituteDao educationalInstituteDao();
    public abstract TrainingInstituteDao trainingInstituteDao();
    public abstract TrainingProgramDao trainingProgramDao();
    public abstract TrainingSideDao trainingSideDao();
    public abstract EduQualificationDao eduQualificationDao();
    public abstract EduQualificationDetailDao eduQualificationDetailDao();
    public abstract JobListDao jobListDao();
    public abstract StartVisitDao startVisitDao();
    public abstract InspectionVisitResultDao inspectionVisitResultDao();
    public abstract InspectionRecommendation inspectionRecommendationDao();
    public abstract InspectionRevisitDao inspectionRevisitDao();
    public abstract QuestionsAnswerDao questionsAnswerDao();
    public abstract BossDao bossDao() ;
    public abstract ConstructionBasicInfoDao constructionBasicInfoDao();
    public abstract AddWorkerDao addWorkerDao();
    public abstract AddWorkerHealthDao addWorkerHealthDao();
    public abstract InspectionVisitDao inspectionVisitDao();
    public abstract RemoteKeysDao remoteKeysDao();
    public abstract AddOwnerDao addOwnerDao();
    public abstract AddLegalDataDao addLegalDataDao();
    public abstract AddLicenseDao addLicenseDao();
    public abstract InsuranceCompanyDao insuranceCompanyDao();
    public abstract AddLicenseInfoDao addLicenseInfoDao();
    public abstract EconomicSectorDao economicSectorDao();
    public abstract AddSecondarySectorDao addSecondarySectorDao();
    public abstract SafetyQuestionsArrayDao safetyQuestionsArrayDao ();



}
