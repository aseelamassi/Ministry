package com.sh.wm.ministry.network.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.sh.wm.ministry.network.database.dao.AddLegalDataDao;
import com.sh.wm.ministry.network.database.dao.AddLegalDataDao_Impl;
import com.sh.wm.ministry.network.database.dao.AddLicenseDao;
import com.sh.wm.ministry.network.database.dao.AddLicenseDao_Impl;
import com.sh.wm.ministry.network.database.dao.AddLicenseInfoDao;
import com.sh.wm.ministry.network.database.dao.AddLicenseInfoDao_Impl;
import com.sh.wm.ministry.network.database.dao.AddOwnerDao;
import com.sh.wm.ministry.network.database.dao.AddOwnerDao_Impl;
import com.sh.wm.ministry.network.database.dao.AddSecondarySectorDao;
import com.sh.wm.ministry.network.database.dao.AddSecondarySectorDao_Impl;
import com.sh.wm.ministry.network.database.dao.AddWorkerDao;
import com.sh.wm.ministry.network.database.dao.AddWorkerDao_Impl;
import com.sh.wm.ministry.network.database.dao.AddWorkerHealthDao;
import com.sh.wm.ministry.network.database.dao.AddWorkerHealthDao_Impl;
import com.sh.wm.ministry.network.database.dao.BossDao;
import com.sh.wm.ministry.network.database.dao.BossDao_Impl;
import com.sh.wm.ministry.network.database.dao.CitiesDao;
import com.sh.wm.ministry.network.database.dao.CitiesDao_Impl;
import com.sh.wm.ministry.network.database.dao.ConstantsDao;
import com.sh.wm.ministry.network.database.dao.ConstantsDao_Impl;
import com.sh.wm.ministry.network.database.dao.ConstructionBasicInfoDao;
import com.sh.wm.ministry.network.database.dao.ConstructionBasicInfoDao_Impl;
import com.sh.wm.ministry.network.database.dao.CountriesDao;
import com.sh.wm.ministry.network.database.dao.CountriesDao_Impl;
import com.sh.wm.ministry.network.database.dao.DirectorsDao;
import com.sh.wm.ministry.network.database.dao.DirectorsDao_Impl;
import com.sh.wm.ministry.network.database.dao.EconomicSectorDao;
import com.sh.wm.ministry.network.database.dao.EconomicSectorDao_Impl;
import com.sh.wm.ministry.network.database.dao.EduProgramDao;
import com.sh.wm.ministry.network.database.dao.EduProgramDao_Impl;
import com.sh.wm.ministry.network.database.dao.EduQualificationDao;
import com.sh.wm.ministry.network.database.dao.EduQualificationDao_Impl;
import com.sh.wm.ministry.network.database.dao.EduQualificationDetailDao;
import com.sh.wm.ministry.network.database.dao.EduQualificationDetailDao_Impl;
import com.sh.wm.ministry.network.database.dao.EducationalInstituteDao;
import com.sh.wm.ministry.network.database.dao.EducationalInstituteDao_Impl;
import com.sh.wm.ministry.network.database.dao.InspectionRecommendation;
import com.sh.wm.ministry.network.database.dao.InspectionRecommendation_Impl;
import com.sh.wm.ministry.network.database.dao.InspectionRevisitDao;
import com.sh.wm.ministry.network.database.dao.InspectionRevisitDao_Impl;
import com.sh.wm.ministry.network.database.dao.InspectionVisitDao;
import com.sh.wm.ministry.network.database.dao.InspectionVisitDao_Impl;
import com.sh.wm.ministry.network.database.dao.InspectionVisitResultDao;
import com.sh.wm.ministry.network.database.dao.InspectionVisitResultDao_Impl;
import com.sh.wm.ministry.network.database.dao.InsuranceCompanyDao;
import com.sh.wm.ministry.network.database.dao.InsuranceCompanyDao_Impl;
import com.sh.wm.ministry.network.database.dao.JobListDao;
import com.sh.wm.ministry.network.database.dao.JobListDao_Impl;
import com.sh.wm.ministry.network.database.dao.JobTitlesDao;
import com.sh.wm.ministry.network.database.dao.JobTitlesDao_Impl;
import com.sh.wm.ministry.network.database.dao.JobsDao;
import com.sh.wm.ministry.network.database.dao.JobsDao_Impl;
import com.sh.wm.ministry.network.database.dao.LanguagesDao;
import com.sh.wm.ministry.network.database.dao.LanguagesDao_Impl;
import com.sh.wm.ministry.network.database.dao.MunicipalitiesDao;
import com.sh.wm.ministry.network.database.dao.MunicipalitiesDao_Impl;
import com.sh.wm.ministry.network.database.dao.QuestionsAnswerDao;
import com.sh.wm.ministry.network.database.dao.QuestionsAnswerDao_Impl;
import com.sh.wm.ministry.network.database.dao.RegionsDao;
import com.sh.wm.ministry.network.database.dao.RegionsDao_Impl;
import com.sh.wm.ministry.network.database.dao.RemoteKeysDao;
import com.sh.wm.ministry.network.database.dao.RemoteKeysDao_Impl;
import com.sh.wm.ministry.network.database.dao.SafetyQuestionsArrayDao;
import com.sh.wm.ministry.network.database.dao.SafetyQuestionsArrayDao_Impl;
import com.sh.wm.ministry.network.database.dao.StartVisitDao;
import com.sh.wm.ministry.network.database.dao.StartVisitDao_Impl;
import com.sh.wm.ministry.network.database.dao.TrainingInstituteDao;
import com.sh.wm.ministry.network.database.dao.TrainingInstituteDao_Impl;
import com.sh.wm.ministry.network.database.dao.TrainingProgramDao;
import com.sh.wm.ministry.network.database.dao.TrainingProgramDao_Impl;
import com.sh.wm.ministry.network.database.dao.TrainingSideDao;
import com.sh.wm.ministry.network.database.dao.TrainingSideDao_Impl;
import com.sh.wm.ministry.network.database.dao.WorkStatusDao;
import com.sh.wm.ministry.network.database.dao.WorkStatusDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DataBase_Impl extends DataBase {
  private volatile CountriesDao _countriesDao;

  private volatile LanguagesDao _languagesDao;

  private volatile WorkStatusDao _workStatusDao;

  private volatile JobsDao _jobsDao;

  private volatile ConstantsDao _constantsDao;

  private volatile MunicipalitiesDao _municipalitiesDao;

  private volatile RegionsDao _regionsDao;

  private volatile JobTitlesDao _jobTitlesDao;

  private volatile CitiesDao _citiesDao;

  private volatile DirectorsDao _directorsDao;

  private volatile EduProgramDao _eduProgramDao;

  private volatile EducationalInstituteDao _educationalInstituteDao;

  private volatile TrainingInstituteDao _trainingInstituteDao;

  private volatile TrainingProgramDao _trainingProgramDao;

  private volatile TrainingSideDao _trainingSideDao;

  private volatile EduQualificationDao _eduQualificationDao;

  private volatile EduQualificationDetailDao _eduQualificationDetailDao;

  private volatile JobListDao _jobListDao;

  private volatile StartVisitDao _startVisitDao;

  private volatile InspectionVisitResultDao _inspectionVisitResultDao;

  private volatile InspectionRecommendation _inspectionRecommendation;

  private volatile InspectionRevisitDao _inspectionRevisitDao;

  private volatile QuestionsAnswerDao _questionsAnswerDao;

  private volatile BossDao _bossDao;

  private volatile ConstructionBasicInfoDao _constructionBasicInfoDao;

  private volatile AddWorkerDao _addWorkerDao;

  private volatile AddWorkerHealthDao _addWorkerHealthDao;

  private volatile InspectionVisitDao _inspectionVisitDao;

  private volatile RemoteKeysDao _remoteKeysDao;

  private volatile AddOwnerDao _addOwnerDao;

  private volatile AddLegalDataDao _addLegalDataDao;

  private volatile AddLicenseDao _addLicenseDao;

  private volatile InsuranceCompanyDao _insuranceCompanyDao;

  private volatile AddLicenseInfoDao _addLicenseInfoDao;

  private volatile EconomicSectorDao _economicSectorDao;

  private volatile AddSecondarySectorDao _addSecondarySectorDao;

  private volatile SafetyQuestionsArrayDao _safetyQuestionsArrayDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `languages_table` (`lANGUAGEID` TEXT NOT NULL, `lANGUAGEARNAME` TEXT, `lANGUAGEENNAME` TEXT, `iSDELETE` TEXT, PRIMARY KEY(`lANGUAGEID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `work_status_table` (`wORKSTATUSID` TEXT NOT NULL, `wORKSTATUSNAME` TEXT, `iSDELETE` TEXT, PRIMARY KEY(`wORKSTATUSID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `constants_table` (`cONSTANTID` TEXT NOT NULL, `cONSTANTPARENTID` TEXT, `cONSTANTARANAME` TEXT, `cONSTANTENGNAME` TEXT, `iNSERTUSERSN` TEXT, `iNSERTDATE` TEXT, `uPDATEUSERSN` TEXT, `iSDELETE` TEXT, `oLDID` TEXT, `cONSTANTPARENTTBL` TEXT, PRIMARY KEY(`cONSTANTID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `jobs_table` (`jOBID` TEXT NOT NULL, `jOBARNAME` TEXT, `jOBENNAME` TEXT, `iSDELETE` TEXT, `jOBTRICODE` TEXT, `iNSERTUSER` TEXT, `iNSERTDATE` TEXT, `uPDATEUSER` TEXT, `uPDATEDATE` TEXT, `jOBIDOLD` TEXT, PRIMARY KEY(`jOBID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `countries_table` (`cDTBCD` TEXT, `cDCD` TEXT NOT NULL, `cDARBTR` TEXT, `iSDELETE` TEXT, `cDCDNEW` TEXT, `cDENGTR` TEXT, PRIMARY KEY(`cDCD`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `municipalities_table` (`mUNICIPALITYID` TEXT NOT NULL, `mUNICIPALITYNAMEAR` TEXT, `directorId` TEXT, PRIMARY KEY(`mUNICIPALITYID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `regions_table` (`rEGIONID` TEXT, `rEGIONNAMEAR` TEXT NOT NULL, `directorateId` TEXT, PRIMARY KEY(`rEGIONNAMEAR`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `job_titles_table` (`jOBTITLEID` TEXT NOT NULL, `jOBTITLEDESC` TEXT, `jOBTITLEJOBID` TEXT, `iSDELETE` TEXT, PRIMARY KEY(`jOBTITLEID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cities_table` (`rEGIONID` TEXT NOT NULL, `rEGIONNAMEAR` TEXT, PRIMARY KEY(`rEGIONID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `directors_table` (`iD` TEXT NOT NULL, `nAME` TEXT, `iSDELETE` TEXT, `oLD` TEXT, `cONSTID` TEXT, PRIMARY KEY(`iD`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `edu_programs_table` (`pROGCD` TEXT NOT NULL, `pROGDESC` TEXT, `iSDELETE` TEXT, PRIMARY KEY(`pROGCD`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `educational_institutes_table` (`eDUINSTITUTESID` TEXT NOT NULL, `eDUINSTITUTESARNAME` TEXT, `eDUINSTITUTESENNAME` TEXT, `eDUINSTITUTESCOUNTRY` TEXT, PRIMARY KEY(`eDUINSTITUTESID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `EconomicSector` (`Id` TEXT NOT NULL, `text` TEXT, PRIMARY KEY(`Id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AddSecondarySector` (`constructId` TEXT, `sectorId` TEXT NOT NULL, `sectorDescription` TEXT, PRIMARY KEY(`sectorId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `training_institutes_table` (`Id` TEXT NOT NULL, `text` TEXT, PRIMARY KEY(`Id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `training_programs_table` (`tRAININGPROGRAMID` TEXT NOT NULL, `tRAININGPROGRAMARNAME` TEXT, PRIMARY KEY(`tRAININGPROGRAMID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `training_side_table` (`tRAININGPROGRAMID` TEXT NOT NULL, `tRAININGPROGRAMARNAME` TEXT, PRIMARY KEY(`tRAININGPROGRAMID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `eduQualification_table` (`qUALIFICATIONID` TEXT NOT NULL, `qUALIFICATIONNAME` TEXT, `qUALIFICATIONDESC` TEXT, `eDUTYPEID` TEXT, `fLAGQUALTYPE` TEXT, PRIMARY KEY(`qUALIFICATIONID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `eduQualificationDetails_table` (`qUALDETAILSID` TEXT NOT NULL, `qUALDETAILSNAME` TEXT, `qUALDETAILSEDUTYPEID` TEXT, `qUALID` TEXT, PRIMARY KEY(`qUALDETAILSID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `job_lists_table` (`Id` TEXT NOT NULL, `text` TEXT, PRIMARY KEY(`Id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `StartVisit` (`visit_id` TEXT NOT NULL, `isOnline` INTEGER NOT NULL, PRIMARY KEY(`visit_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `SafetyQuestions` (`id` INTEGER NOT NULL, `safetyQuestions1` TEXT, `safetyQuestions2` TEXT, `safetyQuestions3` TEXT, `safetyQuestions4` TEXT, `safetyQuestions5` TEXT, `safetyQuestions6` TEXT, `safetyQuestions7` TEXT, `safetyQuestions8` TEXT, `safetyQuestions9` TEXT, `safetyQuestions10` TEXT, `safetyQuestions11` TEXT, `safetyQuestions12` TEXT, `safetyQuestions13` TEXT, `safetyQuestions14` TEXT, `safetyQuestions15` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `InspectionVisitResult` (`constructId` TEXT, `actionId` TEXT, `recommendationId` TEXT, `placementId` TEXT, `date` TEXT, `reason` TEXT, `machineName` TEXT, `visitId` TEXT NOT NULL, `userId` TEXT, PRIMARY KEY(`visitId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Recommendation` (`constructId` TEXT, `recommendationId` TEXT, `adptedId` TEXT, `actionId` TEXT, `machineName` TEXT, `actionDate` TEXT, `userId` TEXT, `visitId` TEXT NOT NULL, PRIMARY KEY(`visitId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `InspectionRevisit` (`constructId` TEXT, `violationRemoval` TEXT, `actionId` TEXT, `recommendationId` TEXT, `placmentId` TEXT, `machineName` TEXT, `reason` TEXT, `date` TEXT, `visitId` TEXT NOT NULL, PRIMARY KEY(`visitId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `QuestionsAnswer` (`constructId` TEXT, `visitId` TEXT NOT NULL, `answers` TEXT, `userId` TEXT, PRIMARY KEY(`visitId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `BossModel` (`constructId` TEXT, `constantInformative` TEXT, `userSn` TEXT, `informativeType` TEXT, `description` TEXT, `visitId` TEXT NOT NULL, `type` TEXT, `submitAction` TEXT, PRIMARY KEY(`visitId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ConstructionBasicInfo` (`action` TEXT, `constructId` TEXT, `addressId` TEXT, `constructionNumber` TEXT, `visitDate` TEXT, `nameUsing` TEXT, `nameOfficial` TEXT, `municipapiityId` TEXT, `regionId` TEXT, `streetId` TEXT, `streetDetails` TEXT, `buldingNo` TEXT, `addressDesc` TEXT, `xDirection` TEXT, `yDirections` TEXT, `telephone` TEXT, `mobile` TEXT, `fax` TEXT, `box` TEXT, `url` TEXT, `email` TEXT, `riskLevelId` TEXT, `visitId` TEXT NOT NULL, `submitAction` TEXT, PRIMARY KEY(`visitId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AddWorker` (`constructId` TEXT, `workerSn` TEXT NOT NULL, `perExam` TEXT, `primExam` TEXT, `haveCertificate` TEXT, `workTypeId` TEXT, `workTypeDescId` TEXT, `workTypeDescDescId` TEXT, `startDate` TEXT, `endDate` TEXT, `leaveDate` TEXT, `leaveReason` TEXT, `currencyId` TEXT, `salary` TEXT, `payId` TEXT, `jobId` TEXT, `skillLevelId` TEXT, `contractId` TEXT, `visitId` TEXT, PRIMARY KEY(`workerSn`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AddWorkerHealth` (`userId` TEXT, `userHealthId` TEXT, `details` TEXT, `disabilityId` TEXT, `disabilityPlace` TEXT, `disabilitySize` TEXT, `reason` TEXT, `userSn` TEXT NOT NULL, PRIMARY KEY(`userSn`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `InspectionVisit` (`cOUNTROW` TEXT, `iNSPECTVID` TEXT NOT NULL, `cONSTRUCTID` TEXT, `iNSPECTVVISITORID` TEXT, `iNSPECTVVISITORID2` TEXT, `iNSPECTVVISITORID3` TEXT, `iNSPETVISITSTATUS` TEXT, `vISITDATE` TEXT, `iNSPECTVVISITEVALUATPER` TEXT, `iNSPECTVVISITCRITEAPER` TEXT, `iNSPECTVVISITCRITEBPER` TEXT, `iNSPECTVVISITCRITEEPER` TEXT, `iNSPECTPLANID` TEXT, `cONSTRUCTGUID` TEXT, `cONSTRUCTNAMEUSING` TEXT, `cONSTRUCTADDRESSID` TEXT, `cONSTRUCTNUM` TEXT, `dIRECTORATENAME` TEXT, `iNSPECTORENAME` TEXT, PRIMARY KEY(`iNSPECTVID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `RemoteKeys` (`visitId` TEXT NOT NULL, `nextKeys` TEXT, PRIMARY KEY(`visitId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AddOwnerModel` (`constructId` TEXT, `userSn` TEXT NOT NULL, `userId` TEXT, `startDate` TEXT, `visitId` TEXT, `type` TEXT, PRIMARY KEY(`userSn`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AddLegalEntityData` (`action` TEXT, `constructId` TEXT NOT NULL, `bossIdentify` TEXT, `bossIdentify2` TEXT, `type` TEXT, `legalId` TEXT, `constructinType` TEXT, `ownerShipId` TEXT, `mainEconomicActivityId` TEXT, `mainDsec` TEXT, `sessionId` TEXT, `year` TEXT, `workStatusSecId` TEXT, `foundationNum` TEXT, `employeeNum` TEXT, `startWork` TEXT, `endWork` TEXT, `visitId` TEXT, `submitAction` TEXT, PRIMARY KEY(`constructId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AddLicenseData` (`constructId` TEXT, `licenseId` TEXT NOT NULL, `licenseNumber` TEXT, `visitId` TEXT, `type` TEXT, PRIMARY KEY(`licenseId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `InsuranceCompany` (`pOLICYCD` TEXT NOT NULL, `pOLICYDESC` TEXT, `fLAG` TEXT, `iSDELETE` TEXT, PRIMARY KEY(`pOLICYCD`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `AddLicenseInfo` (`action` TEXT, `constructId` TEXT, `isPolicy` TEXT, `isReg` TEXT, `isLicensed` TEXT, `insuranceEndDate` TEXT, `capital` TEXT, `type` TEXT, `insuranceId` TEXT, `insuranceNum` TEXT, `isInternalSys` TEXT, `isCertificateYN` TEXT, `workHoursSum` TEXT, `workTime` TEXT, `incomeId` TEXT, `visitId` TEXT NOT NULL, `submitAction` TEXT, PRIMARY KEY(`visitId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '715c6921bb340b0de99c7c3526ec4c5b')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `languages_table`");
        _db.execSQL("DROP TABLE IF EXISTS `work_status_table`");
        _db.execSQL("DROP TABLE IF EXISTS `constants_table`");
        _db.execSQL("DROP TABLE IF EXISTS `jobs_table`");
        _db.execSQL("DROP TABLE IF EXISTS `countries_table`");
        _db.execSQL("DROP TABLE IF EXISTS `municipalities_table`");
        _db.execSQL("DROP TABLE IF EXISTS `regions_table`");
        _db.execSQL("DROP TABLE IF EXISTS `job_titles_table`");
        _db.execSQL("DROP TABLE IF EXISTS `cities_table`");
        _db.execSQL("DROP TABLE IF EXISTS `directors_table`");
        _db.execSQL("DROP TABLE IF EXISTS `edu_programs_table`");
        _db.execSQL("DROP TABLE IF EXISTS `educational_institutes_table`");
        _db.execSQL("DROP TABLE IF EXISTS `EconomicSector`");
        _db.execSQL("DROP TABLE IF EXISTS `AddSecondarySector`");
        _db.execSQL("DROP TABLE IF EXISTS `training_institutes_table`");
        _db.execSQL("DROP TABLE IF EXISTS `training_programs_table`");
        _db.execSQL("DROP TABLE IF EXISTS `training_side_table`");
        _db.execSQL("DROP TABLE IF EXISTS `eduQualification_table`");
        _db.execSQL("DROP TABLE IF EXISTS `eduQualificationDetails_table`");
        _db.execSQL("DROP TABLE IF EXISTS `job_lists_table`");
        _db.execSQL("DROP TABLE IF EXISTS `StartVisit`");
        _db.execSQL("DROP TABLE IF EXISTS `SafetyQuestions`");
        _db.execSQL("DROP TABLE IF EXISTS `InspectionVisitResult`");
        _db.execSQL("DROP TABLE IF EXISTS `Recommendation`");
        _db.execSQL("DROP TABLE IF EXISTS `InspectionRevisit`");
        _db.execSQL("DROP TABLE IF EXISTS `QuestionsAnswer`");
        _db.execSQL("DROP TABLE IF EXISTS `BossModel`");
        _db.execSQL("DROP TABLE IF EXISTS `ConstructionBasicInfo`");
        _db.execSQL("DROP TABLE IF EXISTS `AddWorker`");
        _db.execSQL("DROP TABLE IF EXISTS `AddWorkerHealth`");
        _db.execSQL("DROP TABLE IF EXISTS `InspectionVisit`");
        _db.execSQL("DROP TABLE IF EXISTS `RemoteKeys`");
        _db.execSQL("DROP TABLE IF EXISTS `AddOwnerModel`");
        _db.execSQL("DROP TABLE IF EXISTS `AddLegalEntityData`");
        _db.execSQL("DROP TABLE IF EXISTS `AddLicenseData`");
        _db.execSQL("DROP TABLE IF EXISTS `InsuranceCompany`");
        _db.execSQL("DROP TABLE IF EXISTS `AddLicenseInfo`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLanguagesTable = new HashMap<String, TableInfo.Column>(4);
        _columnsLanguagesTable.put("lANGUAGEID", new TableInfo.Column("lANGUAGEID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLanguagesTable.put("lANGUAGEARNAME", new TableInfo.Column("lANGUAGEARNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLanguagesTable.put("lANGUAGEENNAME", new TableInfo.Column("lANGUAGEENNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLanguagesTable.put("iSDELETE", new TableInfo.Column("iSDELETE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLanguagesTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLanguagesTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLanguagesTable = new TableInfo("languages_table", _columnsLanguagesTable, _foreignKeysLanguagesTable, _indicesLanguagesTable);
        final TableInfo _existingLanguagesTable = TableInfo.read(_db, "languages_table");
        if (! _infoLanguagesTable.equals(_existingLanguagesTable)) {
          return new RoomOpenHelper.ValidationResult(false, "languages_table(com.sh.wm.ministry.network.database.dbModels.languages.Language).\n"
                  + " Expected:\n" + _infoLanguagesTable + "\n"
                  + " Found:\n" + _existingLanguagesTable);
        }
        final HashMap<String, TableInfo.Column> _columnsWorkStatusTable = new HashMap<String, TableInfo.Column>(3);
        _columnsWorkStatusTable.put("wORKSTATUSID", new TableInfo.Column("wORKSTATUSID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkStatusTable.put("wORKSTATUSNAME", new TableInfo.Column("wORKSTATUSNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkStatusTable.put("iSDELETE", new TableInfo.Column("iSDELETE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkStatusTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkStatusTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkStatusTable = new TableInfo("work_status_table", _columnsWorkStatusTable, _foreignKeysWorkStatusTable, _indicesWorkStatusTable);
        final TableInfo _existingWorkStatusTable = TableInfo.read(_db, "work_status_table");
        if (! _infoWorkStatusTable.equals(_existingWorkStatusTable)) {
          return new RoomOpenHelper.ValidationResult(false, "work_status_table(com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus).\n"
                  + " Expected:\n" + _infoWorkStatusTable + "\n"
                  + " Found:\n" + _existingWorkStatusTable);
        }
        final HashMap<String, TableInfo.Column> _columnsConstantsTable = new HashMap<String, TableInfo.Column>(10);
        _columnsConstantsTable.put("cONSTANTID", new TableInfo.Column("cONSTANTID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstantsTable.put("cONSTANTPARENTID", new TableInfo.Column("cONSTANTPARENTID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstantsTable.put("cONSTANTARANAME", new TableInfo.Column("cONSTANTARANAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstantsTable.put("cONSTANTENGNAME", new TableInfo.Column("cONSTANTENGNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstantsTable.put("iNSERTUSERSN", new TableInfo.Column("iNSERTUSERSN", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstantsTable.put("iNSERTDATE", new TableInfo.Column("iNSERTDATE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstantsTable.put("uPDATEUSERSN", new TableInfo.Column("uPDATEUSERSN", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstantsTable.put("iSDELETE", new TableInfo.Column("iSDELETE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstantsTable.put("oLDID", new TableInfo.Column("oLDID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstantsTable.put("cONSTANTPARENTTBL", new TableInfo.Column("cONSTANTPARENTTBL", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConstantsTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesConstantsTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoConstantsTable = new TableInfo("constants_table", _columnsConstantsTable, _foreignKeysConstantsTable, _indicesConstantsTable);
        final TableInfo _existingConstantsTable = TableInfo.read(_db, "constants_table");
        if (! _infoConstantsTable.equals(_existingConstantsTable)) {
          return new RoomOpenHelper.ValidationResult(false, "constants_table(com.sh.wm.ministry.network.database.dbModels.constants.Constants).\n"
                  + " Expected:\n" + _infoConstantsTable + "\n"
                  + " Found:\n" + _existingConstantsTable);
        }
        final HashMap<String, TableInfo.Column> _columnsJobsTable = new HashMap<String, TableInfo.Column>(10);
        _columnsJobsTable.put("jOBID", new TableInfo.Column("jOBID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobsTable.put("jOBARNAME", new TableInfo.Column("jOBARNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobsTable.put("jOBENNAME", new TableInfo.Column("jOBENNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobsTable.put("iSDELETE", new TableInfo.Column("iSDELETE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobsTable.put("jOBTRICODE", new TableInfo.Column("jOBTRICODE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobsTable.put("iNSERTUSER", new TableInfo.Column("iNSERTUSER", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobsTable.put("iNSERTDATE", new TableInfo.Column("iNSERTDATE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobsTable.put("uPDATEUSER", new TableInfo.Column("uPDATEUSER", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobsTable.put("uPDATEDATE", new TableInfo.Column("uPDATEDATE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobsTable.put("jOBIDOLD", new TableInfo.Column("jOBIDOLD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysJobsTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesJobsTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoJobsTable = new TableInfo("jobs_table", _columnsJobsTable, _foreignKeysJobsTable, _indicesJobsTable);
        final TableInfo _existingJobsTable = TableInfo.read(_db, "jobs_table");
        if (! _infoJobsTable.equals(_existingJobsTable)) {
          return new RoomOpenHelper.ValidationResult(false, "jobs_table(com.sh.wm.ministry.network.database.dbModels.jobs.Job).\n"
                  + " Expected:\n" + _infoJobsTable + "\n"
                  + " Found:\n" + _existingJobsTable);
        }
        final HashMap<String, TableInfo.Column> _columnsCountriesTable = new HashMap<String, TableInfo.Column>(6);
        _columnsCountriesTable.put("cDTBCD", new TableInfo.Column("cDTBCD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountriesTable.put("cDCD", new TableInfo.Column("cDCD", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountriesTable.put("cDARBTR", new TableInfo.Column("cDARBTR", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountriesTable.put("iSDELETE", new TableInfo.Column("iSDELETE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountriesTable.put("cDCDNEW", new TableInfo.Column("cDCDNEW", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountriesTable.put("cDENGTR", new TableInfo.Column("cDENGTR", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCountriesTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCountriesTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCountriesTable = new TableInfo("countries_table", _columnsCountriesTable, _foreignKeysCountriesTable, _indicesCountriesTable);
        final TableInfo _existingCountriesTable = TableInfo.read(_db, "countries_table");
        if (! _infoCountriesTable.equals(_existingCountriesTable)) {
          return new RoomOpenHelper.ValidationResult(false, "countries_table(com.sh.wm.ministry.network.database.dbModels.countries.Country).\n"
                  + " Expected:\n" + _infoCountriesTable + "\n"
                  + " Found:\n" + _existingCountriesTable);
        }
        final HashMap<String, TableInfo.Column> _columnsMunicipalitiesTable = new HashMap<String, TableInfo.Column>(3);
        _columnsMunicipalitiesTable.put("mUNICIPALITYID", new TableInfo.Column("mUNICIPALITYID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMunicipalitiesTable.put("mUNICIPALITYNAMEAR", new TableInfo.Column("mUNICIPALITYNAMEAR", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMunicipalitiesTable.put("directorId", new TableInfo.Column("directorId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMunicipalitiesTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMunicipalitiesTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMunicipalitiesTable = new TableInfo("municipalities_table", _columnsMunicipalitiesTable, _foreignKeysMunicipalitiesTable, _indicesMunicipalitiesTable);
        final TableInfo _existingMunicipalitiesTable = TableInfo.read(_db, "municipalities_table");
        if (! _infoMunicipalitiesTable.equals(_existingMunicipalitiesTable)) {
          return new RoomOpenHelper.ValidationResult(false, "municipalities_table(com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality).\n"
                  + " Expected:\n" + _infoMunicipalitiesTable + "\n"
                  + " Found:\n" + _existingMunicipalitiesTable);
        }
        final HashMap<String, TableInfo.Column> _columnsRegionsTable = new HashMap<String, TableInfo.Column>(3);
        _columnsRegionsTable.put("rEGIONID", new TableInfo.Column("rEGIONID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRegionsTable.put("rEGIONNAMEAR", new TableInfo.Column("rEGIONNAMEAR", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRegionsTable.put("directorateId", new TableInfo.Column("directorateId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRegionsTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRegionsTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRegionsTable = new TableInfo("regions_table", _columnsRegionsTable, _foreignKeysRegionsTable, _indicesRegionsTable);
        final TableInfo _existingRegionsTable = TableInfo.read(_db, "regions_table");
        if (! _infoRegionsTable.equals(_existingRegionsTable)) {
          return new RoomOpenHelper.ValidationResult(false, "regions_table(com.sh.wm.ministry.network.database.dbModels.regions.Region).\n"
                  + " Expected:\n" + _infoRegionsTable + "\n"
                  + " Found:\n" + _existingRegionsTable);
        }
        final HashMap<String, TableInfo.Column> _columnsJobTitlesTable = new HashMap<String, TableInfo.Column>(4);
        _columnsJobTitlesTable.put("jOBTITLEID", new TableInfo.Column("jOBTITLEID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobTitlesTable.put("jOBTITLEDESC", new TableInfo.Column("jOBTITLEDESC", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobTitlesTable.put("jOBTITLEJOBID", new TableInfo.Column("jOBTITLEJOBID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobTitlesTable.put("iSDELETE", new TableInfo.Column("iSDELETE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysJobTitlesTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesJobTitlesTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoJobTitlesTable = new TableInfo("job_titles_table", _columnsJobTitlesTable, _foreignKeysJobTitlesTable, _indicesJobTitlesTable);
        final TableInfo _existingJobTitlesTable = TableInfo.read(_db, "job_titles_table");
        if (! _infoJobTitlesTable.equals(_existingJobTitlesTable)) {
          return new RoomOpenHelper.ValidationResult(false, "job_titles_table(com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitle).\n"
                  + " Expected:\n" + _infoJobTitlesTable + "\n"
                  + " Found:\n" + _existingJobTitlesTable);
        }
        final HashMap<String, TableInfo.Column> _columnsCitiesTable = new HashMap<String, TableInfo.Column>(2);
        _columnsCitiesTable.put("rEGIONID", new TableInfo.Column("rEGIONID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCitiesTable.put("rEGIONNAMEAR", new TableInfo.Column("rEGIONNAMEAR", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCitiesTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCitiesTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCitiesTable = new TableInfo("cities_table", _columnsCitiesTable, _foreignKeysCitiesTable, _indicesCitiesTable);
        final TableInfo _existingCitiesTable = TableInfo.read(_db, "cities_table");
        if (! _infoCitiesTable.equals(_existingCitiesTable)) {
          return new RoomOpenHelper.ValidationResult(false, "cities_table(com.sh.wm.ministry.network.database.dbModels.cities.City).\n"
                  + " Expected:\n" + _infoCitiesTable + "\n"
                  + " Found:\n" + _existingCitiesTable);
        }
        final HashMap<String, TableInfo.Column> _columnsDirectorsTable = new HashMap<String, TableInfo.Column>(5);
        _columnsDirectorsTable.put("iD", new TableInfo.Column("iD", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDirectorsTable.put("nAME", new TableInfo.Column("nAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDirectorsTable.put("iSDELETE", new TableInfo.Column("iSDELETE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDirectorsTable.put("oLD", new TableInfo.Column("oLD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDirectorsTable.put("cONSTID", new TableInfo.Column("cONSTID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDirectorsTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDirectorsTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDirectorsTable = new TableInfo("directors_table", _columnsDirectorsTable, _foreignKeysDirectorsTable, _indicesDirectorsTable);
        final TableInfo _existingDirectorsTable = TableInfo.read(_db, "directors_table");
        if (! _infoDirectorsTable.equals(_existingDirectorsTable)) {
          return new RoomOpenHelper.ValidationResult(false, "directors_table(com.sh.wm.ministry.network.database.dbModels.directors.Director).\n"
                  + " Expected:\n" + _infoDirectorsTable + "\n"
                  + " Found:\n" + _existingDirectorsTable);
        }
        final HashMap<String, TableInfo.Column> _columnsEduProgramsTable = new HashMap<String, TableInfo.Column>(3);
        _columnsEduProgramsTable.put("pROGCD", new TableInfo.Column("pROGCD", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEduProgramsTable.put("pROGDESC", new TableInfo.Column("pROGDESC", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEduProgramsTable.put("iSDELETE", new TableInfo.Column("iSDELETE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEduProgramsTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEduProgramsTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEduProgramsTable = new TableInfo("edu_programs_table", _columnsEduProgramsTable, _foreignKeysEduProgramsTable, _indicesEduProgramsTable);
        final TableInfo _existingEduProgramsTable = TableInfo.read(_db, "edu_programs_table");
        if (! _infoEduProgramsTable.equals(_existingEduProgramsTable)) {
          return new RoomOpenHelper.ValidationResult(false, "edu_programs_table(com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgram).\n"
                  + " Expected:\n" + _infoEduProgramsTable + "\n"
                  + " Found:\n" + _existingEduProgramsTable);
        }
        final HashMap<String, TableInfo.Column> _columnsEducationalInstitutesTable = new HashMap<String, TableInfo.Column>(4);
        _columnsEducationalInstitutesTable.put("eDUINSTITUTESID", new TableInfo.Column("eDUINSTITUTESID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEducationalInstitutesTable.put("eDUINSTITUTESARNAME", new TableInfo.Column("eDUINSTITUTESARNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEducationalInstitutesTable.put("eDUINSTITUTESENNAME", new TableInfo.Column("eDUINSTITUTESENNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEducationalInstitutesTable.put("eDUINSTITUTESCOUNTRY", new TableInfo.Column("eDUINSTITUTESCOUNTRY", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEducationalInstitutesTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEducationalInstitutesTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEducationalInstitutesTable = new TableInfo("educational_institutes_table", _columnsEducationalInstitutesTable, _foreignKeysEducationalInstitutesTable, _indicesEducationalInstitutesTable);
        final TableInfo _existingEducationalInstitutesTable = TableInfo.read(_db, "educational_institutes_table");
        if (! _infoEducationalInstitutesTable.equals(_existingEducationalInstitutesTable)) {
          return new RoomOpenHelper.ValidationResult(false, "educational_institutes_table(com.sh.wm.ministry.network.database.dbModels.educationalinstitutes.EducationalInstitute).\n"
                  + " Expected:\n" + _infoEducationalInstitutesTable + "\n"
                  + " Found:\n" + _existingEducationalInstitutesTable);
        }
        final HashMap<String, TableInfo.Column> _columnsEconomicSector = new HashMap<String, TableInfo.Column>(2);
        _columnsEconomicSector.put("Id", new TableInfo.Column("Id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEconomicSector.put("text", new TableInfo.Column("text", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEconomicSector = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEconomicSector = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEconomicSector = new TableInfo("EconomicSector", _columnsEconomicSector, _foreignKeysEconomicSector, _indicesEconomicSector);
        final TableInfo _existingEconomicSector = TableInfo.read(_db, "EconomicSector");
        if (! _infoEconomicSector.equals(_existingEconomicSector)) {
          return new RoomOpenHelper.ValidationResult(false, "EconomicSector(com.sh.wm.ministry.network.database.dbModels.economicSector.EconomicSector).\n"
                  + " Expected:\n" + _infoEconomicSector + "\n"
                  + " Found:\n" + _existingEconomicSector);
        }
        final HashMap<String, TableInfo.Column> _columnsAddSecondarySector = new HashMap<String, TableInfo.Column>(3);
        _columnsAddSecondarySector.put("constructId", new TableInfo.Column("constructId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddSecondarySector.put("sectorId", new TableInfo.Column("sectorId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddSecondarySector.put("sectorDescription", new TableInfo.Column("sectorDescription", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddSecondarySector = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddSecondarySector = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddSecondarySector = new TableInfo("AddSecondarySector", _columnsAddSecondarySector, _foreignKeysAddSecondarySector, _indicesAddSecondarySector);
        final TableInfo _existingAddSecondarySector = TableInfo.read(_db, "AddSecondarySector");
        if (! _infoAddSecondarySector.equals(_existingAddSecondarySector)) {
          return new RoomOpenHelper.ValidationResult(false, "AddSecondarySector(com.sh.wm.ministry.network.database.dbModels.offlineModes.AddSecondarySector).\n"
                  + " Expected:\n" + _infoAddSecondarySector + "\n"
                  + " Found:\n" + _existingAddSecondarySector);
        }
        final HashMap<String, TableInfo.Column> _columnsTrainingInstitutesTable = new HashMap<String, TableInfo.Column>(2);
        _columnsTrainingInstitutesTable.put("Id", new TableInfo.Column("Id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainingInstitutesTable.put("text", new TableInfo.Column("text", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTrainingInstitutesTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTrainingInstitutesTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTrainingInstitutesTable = new TableInfo("training_institutes_table", _columnsTrainingInstitutesTable, _foreignKeysTrainingInstitutesTable, _indicesTrainingInstitutesTable);
        final TableInfo _existingTrainingInstitutesTable = TableInfo.read(_db, "training_institutes_table");
        if (! _infoTrainingInstitutesTable.equals(_existingTrainingInstitutesTable)) {
          return new RoomOpenHelper.ValidationResult(false, "training_institutes_table(com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitute).\n"
                  + " Expected:\n" + _infoTrainingInstitutesTable + "\n"
                  + " Found:\n" + _existingTrainingInstitutesTable);
        }
        final HashMap<String, TableInfo.Column> _columnsTrainingProgramsTable = new HashMap<String, TableInfo.Column>(2);
        _columnsTrainingProgramsTable.put("tRAININGPROGRAMID", new TableInfo.Column("tRAININGPROGRAMID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainingProgramsTable.put("tRAININGPROGRAMARNAME", new TableInfo.Column("tRAININGPROGRAMARNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTrainingProgramsTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTrainingProgramsTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTrainingProgramsTable = new TableInfo("training_programs_table", _columnsTrainingProgramsTable, _foreignKeysTrainingProgramsTable, _indicesTrainingProgramsTable);
        final TableInfo _existingTrainingProgramsTable = TableInfo.read(_db, "training_programs_table");
        if (! _infoTrainingProgramsTable.equals(_existingTrainingProgramsTable)) {
          return new RoomOpenHelper.ValidationResult(false, "training_programs_table(com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram).\n"
                  + " Expected:\n" + _infoTrainingProgramsTable + "\n"
                  + " Found:\n" + _existingTrainingProgramsTable);
        }
        final HashMap<String, TableInfo.Column> _columnsTrainingSideTable = new HashMap<String, TableInfo.Column>(2);
        _columnsTrainingSideTable.put("tRAININGPROGRAMID", new TableInfo.Column("tRAININGPROGRAMID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainingSideTable.put("tRAININGPROGRAMARNAME", new TableInfo.Column("tRAININGPROGRAMARNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTrainingSideTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTrainingSideTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTrainingSideTable = new TableInfo("training_side_table", _columnsTrainingSideTable, _foreignKeysTrainingSideTable, _indicesTrainingSideTable);
        final TableInfo _existingTrainingSideTable = TableInfo.read(_db, "training_side_table");
        if (! _infoTrainingSideTable.equals(_existingTrainingSideTable)) {
          return new RoomOpenHelper.ValidationResult(false, "training_side_table(com.sh.wm.ministry.network.database.dbModels.trainingSide.TrainingSide).\n"
                  + " Expected:\n" + _infoTrainingSideTable + "\n"
                  + " Found:\n" + _existingTrainingSideTable);
        }
        final HashMap<String, TableInfo.Column> _columnsEduQualificationTable = new HashMap<String, TableInfo.Column>(5);
        _columnsEduQualificationTable.put("qUALIFICATIONID", new TableInfo.Column("qUALIFICATIONID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEduQualificationTable.put("qUALIFICATIONNAME", new TableInfo.Column("qUALIFICATIONNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEduQualificationTable.put("qUALIFICATIONDESC", new TableInfo.Column("qUALIFICATIONDESC", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEduQualificationTable.put("eDUTYPEID", new TableInfo.Column("eDUTYPEID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEduQualificationTable.put("fLAGQUALTYPE", new TableInfo.Column("fLAGQUALTYPE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEduQualificationTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEduQualificationTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEduQualificationTable = new TableInfo("eduQualification_table", _columnsEduQualificationTable, _foreignKeysEduQualificationTable, _indicesEduQualificationTable);
        final TableInfo _existingEduQualificationTable = TableInfo.read(_db, "eduQualification_table");
        if (! _infoEduQualificationTable.equals(_existingEduQualificationTable)) {
          return new RoomOpenHelper.ValidationResult(false, "eduQualification_table(com.sh.wm.ministry.network.database.dbModels.eduQualification.EduQualification).\n"
                  + " Expected:\n" + _infoEduQualificationTable + "\n"
                  + " Found:\n" + _existingEduQualificationTable);
        }
        final HashMap<String, TableInfo.Column> _columnsEduQualificationDetailsTable = new HashMap<String, TableInfo.Column>(4);
        _columnsEduQualificationDetailsTable.put("qUALDETAILSID", new TableInfo.Column("qUALDETAILSID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEduQualificationDetailsTable.put("qUALDETAILSNAME", new TableInfo.Column("qUALDETAILSNAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEduQualificationDetailsTable.put("qUALDETAILSEDUTYPEID", new TableInfo.Column("qUALDETAILSEDUTYPEID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEduQualificationDetailsTable.put("qUALID", new TableInfo.Column("qUALID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEduQualificationDetailsTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEduQualificationDetailsTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEduQualificationDetailsTable = new TableInfo("eduQualificationDetails_table", _columnsEduQualificationDetailsTable, _foreignKeysEduQualificationDetailsTable, _indicesEduQualificationDetailsTable);
        final TableInfo _existingEduQualificationDetailsTable = TableInfo.read(_db, "eduQualificationDetails_table");
        if (! _infoEduQualificationDetailsTable.equals(_existingEduQualificationDetailsTable)) {
          return new RoomOpenHelper.ValidationResult(false, "eduQualificationDetails_table(com.sh.wm.ministry.network.database.dbModels.eduQualificationDetail.EduQualificationDetail).\n"
                  + " Expected:\n" + _infoEduQualificationDetailsTable + "\n"
                  + " Found:\n" + _existingEduQualificationDetailsTable);
        }
        final HashMap<String, TableInfo.Column> _columnsJobListsTable = new HashMap<String, TableInfo.Column>(2);
        _columnsJobListsTable.put("Id", new TableInfo.Column("Id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJobListsTable.put("text", new TableInfo.Column("text", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysJobListsTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesJobListsTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoJobListsTable = new TableInfo("job_lists_table", _columnsJobListsTable, _foreignKeysJobListsTable, _indicesJobListsTable);
        final TableInfo _existingJobListsTable = TableInfo.read(_db, "job_lists_table");
        if (! _infoJobListsTable.equals(_existingJobListsTable)) {
          return new RoomOpenHelper.ValidationResult(false, "job_lists_table(com.sh.wm.ministry.network.database.dbModels.jobList.JobList).\n"
                  + " Expected:\n" + _infoJobListsTable + "\n"
                  + " Found:\n" + _existingJobListsTable);
        }
        final HashMap<String, TableInfo.Column> _columnsStartVisit = new HashMap<String, TableInfo.Column>(2);
        _columnsStartVisit.put("visit_id", new TableInfo.Column("visit_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStartVisit.put("isOnline", new TableInfo.Column("isOnline", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStartVisit = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStartVisit = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStartVisit = new TableInfo("StartVisit", _columnsStartVisit, _foreignKeysStartVisit, _indicesStartVisit);
        final TableInfo _existingStartVisit = TableInfo.read(_db, "StartVisit");
        if (! _infoStartVisit.equals(_existingStartVisit)) {
          return new RoomOpenHelper.ValidationResult(false, "StartVisit(com.sh.wm.ministry.network.database.dbModels.offlineModes.StartVisitModel).\n"
                  + " Expected:\n" + _infoStartVisit + "\n"
                  + " Found:\n" + _existingStartVisit);
        }
        final HashMap<String, TableInfo.Column> _columnsSafetyQuestions = new HashMap<String, TableInfo.Column>(16);
        _columnsSafetyQuestions.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions1", new TableInfo.Column("safetyQuestions1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions2", new TableInfo.Column("safetyQuestions2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions3", new TableInfo.Column("safetyQuestions3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions4", new TableInfo.Column("safetyQuestions4", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions5", new TableInfo.Column("safetyQuestions5", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions6", new TableInfo.Column("safetyQuestions6", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions7", new TableInfo.Column("safetyQuestions7", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions8", new TableInfo.Column("safetyQuestions8", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions9", new TableInfo.Column("safetyQuestions9", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions10", new TableInfo.Column("safetyQuestions10", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions11", new TableInfo.Column("safetyQuestions11", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions12", new TableInfo.Column("safetyQuestions12", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions13", new TableInfo.Column("safetyQuestions13", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions14", new TableInfo.Column("safetyQuestions14", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSafetyQuestions.put("safetyQuestions15", new TableInfo.Column("safetyQuestions15", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSafetyQuestions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSafetyQuestions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSafetyQuestions = new TableInfo("SafetyQuestions", _columnsSafetyQuestions, _foreignKeysSafetyQuestions, _indicesSafetyQuestions);
        final TableInfo _existingSafetyQuestions = TableInfo.read(_db, "SafetyQuestions");
        if (! _infoSafetyQuestions.equals(_existingSafetyQuestions)) {
          return new RoomOpenHelper.ValidationResult(false, "SafetyQuestions(com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel.SafetyQuestionArray).\n"
                  + " Expected:\n" + _infoSafetyQuestions + "\n"
                  + " Found:\n" + _existingSafetyQuestions);
        }
        final HashMap<String, TableInfo.Column> _columnsInspectionVisitResult = new HashMap<String, TableInfo.Column>(9);
        _columnsInspectionVisitResult.put("constructId", new TableInfo.Column("constructId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisitResult.put("actionId", new TableInfo.Column("actionId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisitResult.put("recommendationId", new TableInfo.Column("recommendationId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisitResult.put("placementId", new TableInfo.Column("placementId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisitResult.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisitResult.put("reason", new TableInfo.Column("reason", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisitResult.put("machineName", new TableInfo.Column("machineName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisitResult.put("visitId", new TableInfo.Column("visitId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisitResult.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInspectionVisitResult = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInspectionVisitResult = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInspectionVisitResult = new TableInfo("InspectionVisitResult", _columnsInspectionVisitResult, _foreignKeysInspectionVisitResult, _indicesInspectionVisitResult);
        final TableInfo _existingInspectionVisitResult = TableInfo.read(_db, "InspectionVisitResult");
        if (! _infoInspectionVisitResult.equals(_existingInspectionVisitResult)) {
          return new RoomOpenHelper.ValidationResult(false, "InspectionVisitResult(com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionVisitResult).\n"
                  + " Expected:\n" + _infoInspectionVisitResult + "\n"
                  + " Found:\n" + _existingInspectionVisitResult);
        }
        final HashMap<String, TableInfo.Column> _columnsRecommendation = new HashMap<String, TableInfo.Column>(8);
        _columnsRecommendation.put("constructId", new TableInfo.Column("constructId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecommendation.put("recommendationId", new TableInfo.Column("recommendationId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecommendation.put("adptedId", new TableInfo.Column("adptedId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecommendation.put("actionId", new TableInfo.Column("actionId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecommendation.put("machineName", new TableInfo.Column("machineName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecommendation.put("actionDate", new TableInfo.Column("actionDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecommendation.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRecommendation.put("visitId", new TableInfo.Column("visitId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRecommendation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRecommendation = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRecommendation = new TableInfo("Recommendation", _columnsRecommendation, _foreignKeysRecommendation, _indicesRecommendation);
        final TableInfo _existingRecommendation = TableInfo.read(_db, "Recommendation");
        if (! _infoRecommendation.equals(_existingRecommendation)) {
          return new RoomOpenHelper.ValidationResult(false, "Recommendation(com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionRecommendationModel).\n"
                  + " Expected:\n" + _infoRecommendation + "\n"
                  + " Found:\n" + _existingRecommendation);
        }
        final HashMap<String, TableInfo.Column> _columnsInspectionRevisit = new HashMap<String, TableInfo.Column>(9);
        _columnsInspectionRevisit.put("constructId", new TableInfo.Column("constructId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionRevisit.put("violationRemoval", new TableInfo.Column("violationRemoval", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionRevisit.put("actionId", new TableInfo.Column("actionId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionRevisit.put("recommendationId", new TableInfo.Column("recommendationId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionRevisit.put("placmentId", new TableInfo.Column("placmentId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionRevisit.put("machineName", new TableInfo.Column("machineName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionRevisit.put("reason", new TableInfo.Column("reason", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionRevisit.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionRevisit.put("visitId", new TableInfo.Column("visitId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInspectionRevisit = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInspectionRevisit = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInspectionRevisit = new TableInfo("InspectionRevisit", _columnsInspectionRevisit, _foreignKeysInspectionRevisit, _indicesInspectionRevisit);
        final TableInfo _existingInspectionRevisit = TableInfo.read(_db, "InspectionRevisit");
        if (! _infoInspectionRevisit.equals(_existingInspectionRevisit)) {
          return new RoomOpenHelper.ValidationResult(false, "InspectionRevisit(com.sh.wm.ministry.network.database.dbModels.offlineModes.InspectionRevisit).\n"
                  + " Expected:\n" + _infoInspectionRevisit + "\n"
                  + " Found:\n" + _existingInspectionRevisit);
        }
        final HashMap<String, TableInfo.Column> _columnsQuestionsAnswer = new HashMap<String, TableInfo.Column>(4);
        _columnsQuestionsAnswer.put("constructId", new TableInfo.Column("constructId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestionsAnswer.put("visitId", new TableInfo.Column("visitId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestionsAnswer.put("answers", new TableInfo.Column("answers", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestionsAnswer.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQuestionsAnswer = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQuestionsAnswer = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQuestionsAnswer = new TableInfo("QuestionsAnswer", _columnsQuestionsAnswer, _foreignKeysQuestionsAnswer, _indicesQuestionsAnswer);
        final TableInfo _existingQuestionsAnswer = TableInfo.read(_db, "QuestionsAnswer");
        if (! _infoQuestionsAnswer.equals(_existingQuestionsAnswer)) {
          return new RoomOpenHelper.ValidationResult(false, "QuestionsAnswer(com.sh.wm.ministry.network.database.dbModels.offlineModes.QuestionsAnswer).\n"
                  + " Expected:\n" + _infoQuestionsAnswer + "\n"
                  + " Found:\n" + _existingQuestionsAnswer);
        }
        final HashMap<String, TableInfo.Column> _columnsBossModel = new HashMap<String, TableInfo.Column>(8);
        _columnsBossModel.put("constructId", new TableInfo.Column("constructId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBossModel.put("constantInformative", new TableInfo.Column("constantInformative", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBossModel.put("userSn", new TableInfo.Column("userSn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBossModel.put("informativeType", new TableInfo.Column("informativeType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBossModel.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBossModel.put("visitId", new TableInfo.Column("visitId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBossModel.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBossModel.put("submitAction", new TableInfo.Column("submitAction", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBossModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBossModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBossModel = new TableInfo("BossModel", _columnsBossModel, _foreignKeysBossModel, _indicesBossModel);
        final TableInfo _existingBossModel = TableInfo.read(_db, "BossModel");
        if (! _infoBossModel.equals(_existingBossModel)) {
          return new RoomOpenHelper.ValidationResult(false, "BossModel(com.sh.wm.ministry.network.database.dbModels.offlineModes.BossModel).\n"
                  + " Expected:\n" + _infoBossModel + "\n"
                  + " Found:\n" + _existingBossModel);
        }
        final HashMap<String, TableInfo.Column> _columnsConstructionBasicInfo = new HashMap<String, TableInfo.Column>(24);
        _columnsConstructionBasicInfo.put("action", new TableInfo.Column("action", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("constructId", new TableInfo.Column("constructId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("addressId", new TableInfo.Column("addressId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("constructionNumber", new TableInfo.Column("constructionNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("visitDate", new TableInfo.Column("visitDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("nameUsing", new TableInfo.Column("nameUsing", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("nameOfficial", new TableInfo.Column("nameOfficial", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("municipapiityId", new TableInfo.Column("municipapiityId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("regionId", new TableInfo.Column("regionId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("streetId", new TableInfo.Column("streetId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("streetDetails", new TableInfo.Column("streetDetails", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("buldingNo", new TableInfo.Column("buldingNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("addressDesc", new TableInfo.Column("addressDesc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("xDirection", new TableInfo.Column("xDirection", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("yDirections", new TableInfo.Column("yDirections", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("telephone", new TableInfo.Column("telephone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("mobile", new TableInfo.Column("mobile", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("fax", new TableInfo.Column("fax", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("box", new TableInfo.Column("box", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("riskLevelId", new TableInfo.Column("riskLevelId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("visitId", new TableInfo.Column("visitId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConstructionBasicInfo.put("submitAction", new TableInfo.Column("submitAction", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConstructionBasicInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesConstructionBasicInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoConstructionBasicInfo = new TableInfo("ConstructionBasicInfo", _columnsConstructionBasicInfo, _foreignKeysConstructionBasicInfo, _indicesConstructionBasicInfo);
        final TableInfo _existingConstructionBasicInfo = TableInfo.read(_db, "ConstructionBasicInfo");
        if (! _infoConstructionBasicInfo.equals(_existingConstructionBasicInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "ConstructionBasicInfo(com.sh.wm.ministry.network.database.dbModels.offlineModes.ConstructionBasicInfo).\n"
                  + " Expected:\n" + _infoConstructionBasicInfo + "\n"
                  + " Found:\n" + _existingConstructionBasicInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsAddWorker = new HashMap<String, TableInfo.Column>(19);
        _columnsAddWorker.put("constructId", new TableInfo.Column("constructId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("workerSn", new TableInfo.Column("workerSn", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("perExam", new TableInfo.Column("perExam", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("primExam", new TableInfo.Column("primExam", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("haveCertificate", new TableInfo.Column("haveCertificate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("workTypeId", new TableInfo.Column("workTypeId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("workTypeDescId", new TableInfo.Column("workTypeDescId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("workTypeDescDescId", new TableInfo.Column("workTypeDescDescId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("startDate", new TableInfo.Column("startDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("endDate", new TableInfo.Column("endDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("leaveDate", new TableInfo.Column("leaveDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("leaveReason", new TableInfo.Column("leaveReason", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("currencyId", new TableInfo.Column("currencyId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("salary", new TableInfo.Column("salary", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("payId", new TableInfo.Column("payId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("jobId", new TableInfo.Column("jobId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("skillLevelId", new TableInfo.Column("skillLevelId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("contractId", new TableInfo.Column("contractId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorker.put("visitId", new TableInfo.Column("visitId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddWorker = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddWorker = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddWorker = new TableInfo("AddWorker", _columnsAddWorker, _foreignKeysAddWorker, _indicesAddWorker);
        final TableInfo _existingAddWorker = TableInfo.read(_db, "AddWorker");
        if (! _infoAddWorker.equals(_existingAddWorker)) {
          return new RoomOpenHelper.ValidationResult(false, "AddWorker(com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerModel).\n"
                  + " Expected:\n" + _infoAddWorker + "\n"
                  + " Found:\n" + _existingAddWorker);
        }
        final HashMap<String, TableInfo.Column> _columnsAddWorkerHealth = new HashMap<String, TableInfo.Column>(8);
        _columnsAddWorkerHealth.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorkerHealth.put("userHealthId", new TableInfo.Column("userHealthId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorkerHealth.put("details", new TableInfo.Column("details", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorkerHealth.put("disabilityId", new TableInfo.Column("disabilityId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorkerHealth.put("disabilityPlace", new TableInfo.Column("disabilityPlace", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorkerHealth.put("disabilitySize", new TableInfo.Column("disabilitySize", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorkerHealth.put("reason", new TableInfo.Column("reason", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddWorkerHealth.put("userSn", new TableInfo.Column("userSn", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddWorkerHealth = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddWorkerHealth = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddWorkerHealth = new TableInfo("AddWorkerHealth", _columnsAddWorkerHealth, _foreignKeysAddWorkerHealth, _indicesAddWorkerHealth);
        final TableInfo _existingAddWorkerHealth = TableInfo.read(_db, "AddWorkerHealth");
        if (! _infoAddWorkerHealth.equals(_existingAddWorkerHealth)) {
          return new RoomOpenHelper.ValidationResult(false, "AddWorkerHealth(com.sh.wm.ministry.network.database.dbModels.offlineModes.AddWorkerHealthModel).\n"
                  + " Expected:\n" + _infoAddWorkerHealth + "\n"
                  + " Found:\n" + _existingAddWorkerHealth);
        }
        final HashMap<String, TableInfo.Column> _columnsInspectionVisit = new HashMap<String, TableInfo.Column>(19);
        _columnsInspectionVisit.put("cOUNTROW", new TableInfo.Column("cOUNTROW", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("iNSPECTVID", new TableInfo.Column("iNSPECTVID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("cONSTRUCTID", new TableInfo.Column("cONSTRUCTID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("iNSPECTVVISITORID", new TableInfo.Column("iNSPECTVVISITORID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("iNSPECTVVISITORID2", new TableInfo.Column("iNSPECTVVISITORID2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("iNSPECTVVISITORID3", new TableInfo.Column("iNSPECTVVISITORID3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("iNSPETVISITSTATUS", new TableInfo.Column("iNSPETVISITSTATUS", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("vISITDATE", new TableInfo.Column("vISITDATE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("iNSPECTVVISITEVALUATPER", new TableInfo.Column("iNSPECTVVISITEVALUATPER", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("iNSPECTVVISITCRITEAPER", new TableInfo.Column("iNSPECTVVISITCRITEAPER", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("iNSPECTVVISITCRITEBPER", new TableInfo.Column("iNSPECTVVISITCRITEBPER", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("iNSPECTVVISITCRITEEPER", new TableInfo.Column("iNSPECTVVISITCRITEEPER", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("iNSPECTPLANID", new TableInfo.Column("iNSPECTPLANID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("cONSTRUCTGUID", new TableInfo.Column("cONSTRUCTGUID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("cONSTRUCTNAMEUSING", new TableInfo.Column("cONSTRUCTNAMEUSING", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("cONSTRUCTADDRESSID", new TableInfo.Column("cONSTRUCTADDRESSID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("cONSTRUCTNUM", new TableInfo.Column("cONSTRUCTNUM", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("dIRECTORATENAME", new TableInfo.Column("dIRECTORATENAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInspectionVisit.put("iNSPECTORENAME", new TableInfo.Column("iNSPECTORENAME", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInspectionVisit = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInspectionVisit = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInspectionVisit = new TableInfo("InspectionVisit", _columnsInspectionVisit, _foreignKeysInspectionVisit, _indicesInspectionVisit);
        final TableInfo _existingInspectionVisit = TableInfo.read(_db, "InspectionVisit");
        if (! _infoInspectionVisit.equals(_existingInspectionVisit)) {
          return new RoomOpenHelper.ValidationResult(false, "InspectionVisit(com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.InspectionVisit).\n"
                  + " Expected:\n" + _infoInspectionVisit + "\n"
                  + " Found:\n" + _existingInspectionVisit);
        }
        final HashMap<String, TableInfo.Column> _columnsRemoteKeys = new HashMap<String, TableInfo.Column>(2);
        _columnsRemoteKeys.put("visitId", new TableInfo.Column("visitId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRemoteKeys.put("nextKeys", new TableInfo.Column("nextKeys", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRemoteKeys = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRemoteKeys = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRemoteKeys = new TableInfo("RemoteKeys", _columnsRemoteKeys, _foreignKeysRemoteKeys, _indicesRemoteKeys);
        final TableInfo _existingRemoteKeys = TableInfo.read(_db, "RemoteKeys");
        if (! _infoRemoteKeys.equals(_existingRemoteKeys)) {
          return new RoomOpenHelper.ValidationResult(false, "RemoteKeys(com.sh.wm.ministry.network.database.dbModels.offlineModes.RemoteKeys).\n"
                  + " Expected:\n" + _infoRemoteKeys + "\n"
                  + " Found:\n" + _existingRemoteKeys);
        }
        final HashMap<String, TableInfo.Column> _columnsAddOwnerModel = new HashMap<String, TableInfo.Column>(6);
        _columnsAddOwnerModel.put("constructId", new TableInfo.Column("constructId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddOwnerModel.put("userSn", new TableInfo.Column("userSn", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddOwnerModel.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddOwnerModel.put("startDate", new TableInfo.Column("startDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddOwnerModel.put("visitId", new TableInfo.Column("visitId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddOwnerModel.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddOwnerModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddOwnerModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddOwnerModel = new TableInfo("AddOwnerModel", _columnsAddOwnerModel, _foreignKeysAddOwnerModel, _indicesAddOwnerModel);
        final TableInfo _existingAddOwnerModel = TableInfo.read(_db, "AddOwnerModel");
        if (! _infoAddOwnerModel.equals(_existingAddOwnerModel)) {
          return new RoomOpenHelper.ValidationResult(false, "AddOwnerModel(com.sh.wm.ministry.network.database.dbModels.offlineModes.AddOwnerModel).\n"
                  + " Expected:\n" + _infoAddOwnerModel + "\n"
                  + " Found:\n" + _existingAddOwnerModel);
        }
        final HashMap<String, TableInfo.Column> _columnsAddLegalEntityData = new HashMap<String, TableInfo.Column>(19);
        _columnsAddLegalEntityData.put("action", new TableInfo.Column("action", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("constructId", new TableInfo.Column("constructId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("bossIdentify", new TableInfo.Column("bossIdentify", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("bossIdentify2", new TableInfo.Column("bossIdentify2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("legalId", new TableInfo.Column("legalId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("constructinType", new TableInfo.Column("constructinType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("ownerShipId", new TableInfo.Column("ownerShipId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("mainEconomicActivityId", new TableInfo.Column("mainEconomicActivityId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("mainDsec", new TableInfo.Column("mainDsec", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("sessionId", new TableInfo.Column("sessionId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("year", new TableInfo.Column("year", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("workStatusSecId", new TableInfo.Column("workStatusSecId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("foundationNum", new TableInfo.Column("foundationNum", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("employeeNum", new TableInfo.Column("employeeNum", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("startWork", new TableInfo.Column("startWork", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("endWork", new TableInfo.Column("endWork", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("visitId", new TableInfo.Column("visitId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLegalEntityData.put("submitAction", new TableInfo.Column("submitAction", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddLegalEntityData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddLegalEntityData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddLegalEntityData = new TableInfo("AddLegalEntityData", _columnsAddLegalEntityData, _foreignKeysAddLegalEntityData, _indicesAddLegalEntityData);
        final TableInfo _existingAddLegalEntityData = TableInfo.read(_db, "AddLegalEntityData");
        if (! _infoAddLegalEntityData.equals(_existingAddLegalEntityData)) {
          return new RoomOpenHelper.ValidationResult(false, "AddLegalEntityData(com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLegalEntityData).\n"
                  + " Expected:\n" + _infoAddLegalEntityData + "\n"
                  + " Found:\n" + _existingAddLegalEntityData);
        }
        final HashMap<String, TableInfo.Column> _columnsAddLicenseData = new HashMap<String, TableInfo.Column>(5);
        _columnsAddLicenseData.put("constructId", new TableInfo.Column("constructId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseData.put("licenseId", new TableInfo.Column("licenseId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseData.put("licenseNumber", new TableInfo.Column("licenseNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseData.put("visitId", new TableInfo.Column("visitId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseData.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddLicenseData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddLicenseData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddLicenseData = new TableInfo("AddLicenseData", _columnsAddLicenseData, _foreignKeysAddLicenseData, _indicesAddLicenseData);
        final TableInfo _existingAddLicenseData = TableInfo.read(_db, "AddLicenseData");
        if (! _infoAddLicenseData.equals(_existingAddLicenseData)) {
          return new RoomOpenHelper.ValidationResult(false, "AddLicenseData(com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLicenseData).\n"
                  + " Expected:\n" + _infoAddLicenseData + "\n"
                  + " Found:\n" + _existingAddLicenseData);
        }
        final HashMap<String, TableInfo.Column> _columnsInsuranceCompany = new HashMap<String, TableInfo.Column>(4);
        _columnsInsuranceCompany.put("pOLICYCD", new TableInfo.Column("pOLICYCD", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInsuranceCompany.put("pOLICYDESC", new TableInfo.Column("pOLICYDESC", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInsuranceCompany.put("fLAG", new TableInfo.Column("fLAG", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInsuranceCompany.put("iSDELETE", new TableInfo.Column("iSDELETE", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInsuranceCompany = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInsuranceCompany = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInsuranceCompany = new TableInfo("InsuranceCompany", _columnsInsuranceCompany, _foreignKeysInsuranceCompany, _indicesInsuranceCompany);
        final TableInfo _existingInsuranceCompany = TableInfo.read(_db, "InsuranceCompany");
        if (! _infoInsuranceCompany.equals(_existingInsuranceCompany)) {
          return new RoomOpenHelper.ValidationResult(false, "InsuranceCompany(com.sh.wm.ministry.network.database.dbModels.insuranceCompany.InsuranceCompany).\n"
                  + " Expected:\n" + _infoInsuranceCompany + "\n"
                  + " Found:\n" + _existingInsuranceCompany);
        }
        final HashMap<String, TableInfo.Column> _columnsAddLicenseInfo = new HashMap<String, TableInfo.Column>(17);
        _columnsAddLicenseInfo.put("action", new TableInfo.Column("action", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("constructId", new TableInfo.Column("constructId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("isPolicy", new TableInfo.Column("isPolicy", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("isReg", new TableInfo.Column("isReg", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("isLicensed", new TableInfo.Column("isLicensed", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("insuranceEndDate", new TableInfo.Column("insuranceEndDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("capital", new TableInfo.Column("capital", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("insuranceId", new TableInfo.Column("insuranceId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("insuranceNum", new TableInfo.Column("insuranceNum", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("isInternalSys", new TableInfo.Column("isInternalSys", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("isCertificateYN", new TableInfo.Column("isCertificateYN", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("workHoursSum", new TableInfo.Column("workHoursSum", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("workTime", new TableInfo.Column("workTime", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("incomeId", new TableInfo.Column("incomeId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("visitId", new TableInfo.Column("visitId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddLicenseInfo.put("submitAction", new TableInfo.Column("submitAction", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddLicenseInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddLicenseInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddLicenseInfo = new TableInfo("AddLicenseInfo", _columnsAddLicenseInfo, _foreignKeysAddLicenseInfo, _indicesAddLicenseInfo);
        final TableInfo _existingAddLicenseInfo = TableInfo.read(_db, "AddLicenseInfo");
        if (! _infoAddLicenseInfo.equals(_existingAddLicenseInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "AddLicenseInfo(com.sh.wm.ministry.network.database.dbModels.offlineModes.AddLicenseInfo).\n"
                  + " Expected:\n" + _infoAddLicenseInfo + "\n"
                  + " Found:\n" + _existingAddLicenseInfo);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "715c6921bb340b0de99c7c3526ec4c5b", "bc9e9cb7143ba3195e59d2dac9906b0a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "languages_table","work_status_table","constants_table","jobs_table","countries_table","municipalities_table","regions_table","job_titles_table","cities_table","directors_table","edu_programs_table","educational_institutes_table","EconomicSector","AddSecondarySector","training_institutes_table","training_programs_table","training_side_table","eduQualification_table","eduQualificationDetails_table","job_lists_table","StartVisit","SafetyQuestions","InspectionVisitResult","Recommendation","InspectionRevisit","QuestionsAnswer","BossModel","ConstructionBasicInfo","AddWorker","AddWorkerHealth","InspectionVisit","RemoteKeys","AddOwnerModel","AddLegalEntityData","AddLicenseData","InsuranceCompany","AddLicenseInfo");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `languages_table`");
      _db.execSQL("DELETE FROM `work_status_table`");
      _db.execSQL("DELETE FROM `constants_table`");
      _db.execSQL("DELETE FROM `jobs_table`");
      _db.execSQL("DELETE FROM `countries_table`");
      _db.execSQL("DELETE FROM `municipalities_table`");
      _db.execSQL("DELETE FROM `regions_table`");
      _db.execSQL("DELETE FROM `job_titles_table`");
      _db.execSQL("DELETE FROM `cities_table`");
      _db.execSQL("DELETE FROM `directors_table`");
      _db.execSQL("DELETE FROM `edu_programs_table`");
      _db.execSQL("DELETE FROM `educational_institutes_table`");
      _db.execSQL("DELETE FROM `EconomicSector`");
      _db.execSQL("DELETE FROM `AddSecondarySector`");
      _db.execSQL("DELETE FROM `training_institutes_table`");
      _db.execSQL("DELETE FROM `training_programs_table`");
      _db.execSQL("DELETE FROM `training_side_table`");
      _db.execSQL("DELETE FROM `eduQualification_table`");
      _db.execSQL("DELETE FROM `eduQualificationDetails_table`");
      _db.execSQL("DELETE FROM `job_lists_table`");
      _db.execSQL("DELETE FROM `StartVisit`");
      _db.execSQL("DELETE FROM `SafetyQuestions`");
      _db.execSQL("DELETE FROM `InspectionVisitResult`");
      _db.execSQL("DELETE FROM `Recommendation`");
      _db.execSQL("DELETE FROM `InspectionRevisit`");
      _db.execSQL("DELETE FROM `QuestionsAnswer`");
      _db.execSQL("DELETE FROM `BossModel`");
      _db.execSQL("DELETE FROM `ConstructionBasicInfo`");
      _db.execSQL("DELETE FROM `AddWorker`");
      _db.execSQL("DELETE FROM `AddWorkerHealth`");
      _db.execSQL("DELETE FROM `InspectionVisit`");
      _db.execSQL("DELETE FROM `RemoteKeys`");
      _db.execSQL("DELETE FROM `AddOwnerModel`");
      _db.execSQL("DELETE FROM `AddLegalEntityData`");
      _db.execSQL("DELETE FROM `AddLicenseData`");
      _db.execSQL("DELETE FROM `InsuranceCompany`");
      _db.execSQL("DELETE FROM `AddLicenseInfo`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public CountriesDao countriesDao() {
    if (_countriesDao != null) {
      return _countriesDao;
    } else {
      synchronized(this) {
        if(_countriesDao == null) {
          _countriesDao = new CountriesDao_Impl(this);
        }
        return _countriesDao;
      }
    }
  }

  @Override
  public LanguagesDao languagesDao() {
    if (_languagesDao != null) {
      return _languagesDao;
    } else {
      synchronized(this) {
        if(_languagesDao == null) {
          _languagesDao = new LanguagesDao_Impl(this);
        }
        return _languagesDao;
      }
    }
  }

  @Override
  public WorkStatusDao workStatusDao() {
    if (_workStatusDao != null) {
      return _workStatusDao;
    } else {
      synchronized(this) {
        if(_workStatusDao == null) {
          _workStatusDao = new WorkStatusDao_Impl(this);
        }
        return _workStatusDao;
      }
    }
  }

  @Override
  public JobsDao jobsDao() {
    if (_jobsDao != null) {
      return _jobsDao;
    } else {
      synchronized(this) {
        if(_jobsDao == null) {
          _jobsDao = new JobsDao_Impl(this);
        }
        return _jobsDao;
      }
    }
  }

  @Override
  public ConstantsDao constantsDao() {
    if (_constantsDao != null) {
      return _constantsDao;
    } else {
      synchronized(this) {
        if(_constantsDao == null) {
          _constantsDao = new ConstantsDao_Impl(this);
        }
        return _constantsDao;
      }
    }
  }

  @Override
  public MunicipalitiesDao municipalitiesDao() {
    if (_municipalitiesDao != null) {
      return _municipalitiesDao;
    } else {
      synchronized(this) {
        if(_municipalitiesDao == null) {
          _municipalitiesDao = new MunicipalitiesDao_Impl(this);
        }
        return _municipalitiesDao;
      }
    }
  }

  @Override
  public RegionsDao regionsDao() {
    if (_regionsDao != null) {
      return _regionsDao;
    } else {
      synchronized(this) {
        if(_regionsDao == null) {
          _regionsDao = new RegionsDao_Impl(this);
        }
        return _regionsDao;
      }
    }
  }

  @Override
  public JobTitlesDao jobTitlesDao() {
    if (_jobTitlesDao != null) {
      return _jobTitlesDao;
    } else {
      synchronized(this) {
        if(_jobTitlesDao == null) {
          _jobTitlesDao = new JobTitlesDao_Impl(this);
        }
        return _jobTitlesDao;
      }
    }
  }

  @Override
  public CitiesDao citiesDao() {
    if (_citiesDao != null) {
      return _citiesDao;
    } else {
      synchronized(this) {
        if(_citiesDao == null) {
          _citiesDao = new CitiesDao_Impl(this);
        }
        return _citiesDao;
      }
    }
  }

  @Override
  public DirectorsDao directorsDao() {
    if (_directorsDao != null) {
      return _directorsDao;
    } else {
      synchronized(this) {
        if(_directorsDao == null) {
          _directorsDao = new DirectorsDao_Impl(this);
        }
        return _directorsDao;
      }
    }
  }

  @Override
  public EduProgramDao eduProgramDao() {
    if (_eduProgramDao != null) {
      return _eduProgramDao;
    } else {
      synchronized(this) {
        if(_eduProgramDao == null) {
          _eduProgramDao = new EduProgramDao_Impl(this);
        }
        return _eduProgramDao;
      }
    }
  }

  @Override
  public EducationalInstituteDao educationalInstituteDao() {
    if (_educationalInstituteDao != null) {
      return _educationalInstituteDao;
    } else {
      synchronized(this) {
        if(_educationalInstituteDao == null) {
          _educationalInstituteDao = new EducationalInstituteDao_Impl(this);
        }
        return _educationalInstituteDao;
      }
    }
  }

  @Override
  public TrainingInstituteDao trainingInstituteDao() {
    if (_trainingInstituteDao != null) {
      return _trainingInstituteDao;
    } else {
      synchronized(this) {
        if(_trainingInstituteDao == null) {
          _trainingInstituteDao = new TrainingInstituteDao_Impl(this);
        }
        return _trainingInstituteDao;
      }
    }
  }

  @Override
  public TrainingProgramDao trainingProgramDao() {
    if (_trainingProgramDao != null) {
      return _trainingProgramDao;
    } else {
      synchronized(this) {
        if(_trainingProgramDao == null) {
          _trainingProgramDao = new TrainingProgramDao_Impl(this);
        }
        return _trainingProgramDao;
      }
    }
  }

  @Override
  public TrainingSideDao trainingSideDao() {
    if (_trainingSideDao != null) {
      return _trainingSideDao;
    } else {
      synchronized(this) {
        if(_trainingSideDao == null) {
          _trainingSideDao = new TrainingSideDao_Impl(this);
        }
        return _trainingSideDao;
      }
    }
  }

  @Override
  public EduQualificationDao eduQualificationDao() {
    if (_eduQualificationDao != null) {
      return _eduQualificationDao;
    } else {
      synchronized(this) {
        if(_eduQualificationDao == null) {
          _eduQualificationDao = new EduQualificationDao_Impl(this);
        }
        return _eduQualificationDao;
      }
    }
  }

  @Override
  public EduQualificationDetailDao eduQualificationDetailDao() {
    if (_eduQualificationDetailDao != null) {
      return _eduQualificationDetailDao;
    } else {
      synchronized(this) {
        if(_eduQualificationDetailDao == null) {
          _eduQualificationDetailDao = new EduQualificationDetailDao_Impl(this);
        }
        return _eduQualificationDetailDao;
      }
    }
  }

  @Override
  public JobListDao jobListDao() {
    if (_jobListDao != null) {
      return _jobListDao;
    } else {
      synchronized(this) {
        if(_jobListDao == null) {
          _jobListDao = new JobListDao_Impl(this);
        }
        return _jobListDao;
      }
    }
  }

  @Override
  public StartVisitDao startVisitDao() {
    if (_startVisitDao != null) {
      return _startVisitDao;
    } else {
      synchronized(this) {
        if(_startVisitDao == null) {
          _startVisitDao = new StartVisitDao_Impl(this);
        }
        return _startVisitDao;
      }
    }
  }

  @Override
  public InspectionVisitResultDao inspectionVisitResultDao() {
    if (_inspectionVisitResultDao != null) {
      return _inspectionVisitResultDao;
    } else {
      synchronized(this) {
        if(_inspectionVisitResultDao == null) {
          _inspectionVisitResultDao = new InspectionVisitResultDao_Impl(this);
        }
        return _inspectionVisitResultDao;
      }
    }
  }

  @Override
  public InspectionRecommendation inspectionRecommendationDao() {
    if (_inspectionRecommendation != null) {
      return _inspectionRecommendation;
    } else {
      synchronized(this) {
        if(_inspectionRecommendation == null) {
          _inspectionRecommendation = new InspectionRecommendation_Impl(this);
        }
        return _inspectionRecommendation;
      }
    }
  }

  @Override
  public InspectionRevisitDao inspectionRevisitDao() {
    if (_inspectionRevisitDao != null) {
      return _inspectionRevisitDao;
    } else {
      synchronized(this) {
        if(_inspectionRevisitDao == null) {
          _inspectionRevisitDao = new InspectionRevisitDao_Impl(this);
        }
        return _inspectionRevisitDao;
      }
    }
  }

  @Override
  public QuestionsAnswerDao questionsAnswerDao() {
    if (_questionsAnswerDao != null) {
      return _questionsAnswerDao;
    } else {
      synchronized(this) {
        if(_questionsAnswerDao == null) {
          _questionsAnswerDao = new QuestionsAnswerDao_Impl(this);
        }
        return _questionsAnswerDao;
      }
    }
  }

  @Override
  public BossDao bossDao() {
    if (_bossDao != null) {
      return _bossDao;
    } else {
      synchronized(this) {
        if(_bossDao == null) {
          _bossDao = new BossDao_Impl(this);
        }
        return _bossDao;
      }
    }
  }

  @Override
  public ConstructionBasicInfoDao constructionBasicInfoDao() {
    if (_constructionBasicInfoDao != null) {
      return _constructionBasicInfoDao;
    } else {
      synchronized(this) {
        if(_constructionBasicInfoDao == null) {
          _constructionBasicInfoDao = new ConstructionBasicInfoDao_Impl(this);
        }
        return _constructionBasicInfoDao;
      }
    }
  }

  @Override
  public AddWorkerDao addWorkerDao() {
    if (_addWorkerDao != null) {
      return _addWorkerDao;
    } else {
      synchronized(this) {
        if(_addWorkerDao == null) {
          _addWorkerDao = new AddWorkerDao_Impl(this);
        }
        return _addWorkerDao;
      }
    }
  }

  @Override
  public AddWorkerHealthDao addWorkerHealthDao() {
    if (_addWorkerHealthDao != null) {
      return _addWorkerHealthDao;
    } else {
      synchronized(this) {
        if(_addWorkerHealthDao == null) {
          _addWorkerHealthDao = new AddWorkerHealthDao_Impl(this);
        }
        return _addWorkerHealthDao;
      }
    }
  }

  @Override
  public InspectionVisitDao inspectionVisitDao() {
    if (_inspectionVisitDao != null) {
      return _inspectionVisitDao;
    } else {
      synchronized(this) {
        if(_inspectionVisitDao == null) {
          _inspectionVisitDao = new InspectionVisitDao_Impl(this);
        }
        return _inspectionVisitDao;
      }
    }
  }

  @Override
  public RemoteKeysDao remoteKeysDao() {
    if (_remoteKeysDao != null) {
      return _remoteKeysDao;
    } else {
      synchronized(this) {
        if(_remoteKeysDao == null) {
          _remoteKeysDao = new RemoteKeysDao_Impl(this);
        }
        return _remoteKeysDao;
      }
    }
  }

  @Override
  public AddOwnerDao addOwnerDao() {
    if (_addOwnerDao != null) {
      return _addOwnerDao;
    } else {
      synchronized(this) {
        if(_addOwnerDao == null) {
          _addOwnerDao = new AddOwnerDao_Impl(this);
        }
        return _addOwnerDao;
      }
    }
  }

  @Override
  public AddLegalDataDao addLegalDataDao() {
    if (_addLegalDataDao != null) {
      return _addLegalDataDao;
    } else {
      synchronized(this) {
        if(_addLegalDataDao == null) {
          _addLegalDataDao = new AddLegalDataDao_Impl(this);
        }
        return _addLegalDataDao;
      }
    }
  }

  @Override
  public AddLicenseDao addLicenseDao() {
    if (_addLicenseDao != null) {
      return _addLicenseDao;
    } else {
      synchronized(this) {
        if(_addLicenseDao == null) {
          _addLicenseDao = new AddLicenseDao_Impl(this);
        }
        return _addLicenseDao;
      }
    }
  }

  @Override
  public InsuranceCompanyDao insuranceCompanyDao() {
    if (_insuranceCompanyDao != null) {
      return _insuranceCompanyDao;
    } else {
      synchronized(this) {
        if(_insuranceCompanyDao == null) {
          _insuranceCompanyDao = new InsuranceCompanyDao_Impl(this);
        }
        return _insuranceCompanyDao;
      }
    }
  }

  @Override
  public AddLicenseInfoDao addLicenseInfoDao() {
    if (_addLicenseInfoDao != null) {
      return _addLicenseInfoDao;
    } else {
      synchronized(this) {
        if(_addLicenseInfoDao == null) {
          _addLicenseInfoDao = new AddLicenseInfoDao_Impl(this);
        }
        return _addLicenseInfoDao;
      }
    }
  }

  @Override
  public EconomicSectorDao economicSectorDao() {
    if (_economicSectorDao != null) {
      return _economicSectorDao;
    } else {
      synchronized(this) {
        if(_economicSectorDao == null) {
          _economicSectorDao = new EconomicSectorDao_Impl(this);
        }
        return _economicSectorDao;
      }
    }
  }

  @Override
  public AddSecondarySectorDao addSecondarySectorDao() {
    if (_addSecondarySectorDao != null) {
      return _addSecondarySectorDao;
    } else {
      synchronized(this) {
        if(_addSecondarySectorDao == null) {
          _addSecondarySectorDao = new AddSecondarySectorDao_Impl(this);
        }
        return _addSecondarySectorDao;
      }
    }
  }

  @Override
  public SafetyQuestionsArrayDao safetyQuestionsArrayDao() {
    if (_safetyQuestionsArrayDao != null) {
      return _safetyQuestionsArrayDao;
    } else {
      synchronized(this) {
        if(_safetyQuestionsArrayDao == null) {
          _safetyQuestionsArrayDao = new SafetyQuestionsArrayDao_Impl(this);
        }
        return _safetyQuestionsArrayDao;
      }
    }
  }
}
