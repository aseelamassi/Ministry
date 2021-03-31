package com.sh.wm.ministry.network.database.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.insuranceCompany.InsuranceCompany;
import com.sh.wm.ministry.network.database.dbModels.insuranceCompany.InsuranceCompanyModel;

import java.util.List;

@Dao
public interface InsuranceCompanyDao {

    @Query("SELECT * FROM InsuranceCompany")
    LiveData<List<InsuranceCompany>> getAllInsuranceCompany();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addInsuranceCompany(InsuranceCompany insuranceCompanyModel);

    @Query("SELECT COUNT(*) FROM InsuranceCompany")
    int getDataCount();
}
