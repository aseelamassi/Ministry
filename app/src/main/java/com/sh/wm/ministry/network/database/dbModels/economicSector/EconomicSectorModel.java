package com.sh.wm.ministry.network.database.dbModels.economicSector;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sh.wm.ministry.network.database.dbModels.jobList.Result;

import java.util.List;

public class EconomicSectorModel {
    @SerializedName("status")
    @Expose
    private int status ;

    @SerializedName("result")
    @Expose
    private List<EconomicSector> results ;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<EconomicSector> getResults() {
        return results;
    }

    public void setResults(List<EconomicSector> results) {
        this.results = results;
    }

}
