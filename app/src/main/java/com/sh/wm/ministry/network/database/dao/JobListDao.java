package com.sh.wm.ministry.network.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sh.wm.ministry.network.database.dbModels.jobList.JobList;
import com.sh.wm.ministry.network.database.dbModels.jobs.Job;

import java.util.List;

@Dao
public interface JobListDao {

    @Query("SELECT * FROM job_lists_table where text like :keyword ")
    LiveData<List<JobList>> getAllJobs(String keyword);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addJob(JobList job);

    @Query("SELECT COUNT(*) FROM job_lists_table")
    int getDataCount();


}
