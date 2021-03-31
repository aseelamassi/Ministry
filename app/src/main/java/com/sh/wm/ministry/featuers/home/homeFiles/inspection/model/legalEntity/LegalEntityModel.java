package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.legalEntity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.legalEntity.secondaryActivity.SecondActivity;
import com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.owner.ConstructionOwner;

import java.util.List;

public class LegalEntityModel {
    @SerializedName("construct_data")
    @Expose
    private List<ConstructData> constructData = null;
    @SerializedName("get_secon_work")
    @Expose
    private List<SecondActivity> getSeconWork = null;
    @SerializedName("get_owner_construct")
    @Expose
    private List<ConstructionOwner> getOwnerConstruct = null;
    @SerializedName("legal_attach_file")
    @Expose
    private Object legalAttachFile;
    @SerializedName("OWNERSHIP_FILE")
    @Expose
    private Object oWNERSHIPFILE;
    @SerializedName("RECORD_LAST_UPDATE_DATE_TAB2")
    @Expose
    private String rECORDLASTUPDATEDATETAB2;

    public List<ConstructData> getConstructData() {
        return constructData;
    }

    public void setConstructData(List<ConstructData> constructData) {
        this.constructData = constructData;
    }

    public List<SecondActivity> getGetSeconWork() {
        return getSeconWork;
    }

    public void setGetSeconWork(List<SecondActivity> getSeconWork) {
        this.getSeconWork = getSeconWork;
    }

    public List<ConstructionOwner> getGetOwnerConstruct() {
        return getOwnerConstruct;
    }

    public void setGetOwnerConstruct(List<ConstructionOwner> getOwnerConstruct) {
        this.getOwnerConstruct = getOwnerConstruct;
    }

    public Object getLegalAttachFile() {
        return legalAttachFile;
    }

    public void setLegalAttachFile(Object legalAttachFile) {
        this.legalAttachFile = legalAttachFile;
    }

    public Object getOWNERSHIPFILE() {
        return oWNERSHIPFILE;
    }

    public void setOWNERSHIPFILE(Object oWNERSHIPFILE) {
        this.oWNERSHIPFILE = oWNERSHIPFILE;
    }

    public String getRECORDLASTUPDATEDATETAB2() {
        return rECORDLASTUPDATEDATETAB2;
    }

    public void setRECORDLASTUPDATEDATETAB2(String rECORDLASTUPDATEDATETAB2) {
        this.rECORDLASTUPDATEDATETAB2 = rECORDLASTUPDATEDATETAB2;
    }

}
