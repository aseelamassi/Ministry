package com.sh.wm.ministry.featuers.home.homeFiles.workerRights.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComplaintRightsCalculation {

    @SerializedName("RIGHT_COMPLAINT_CERMONIES_OUT")
    @Expose
    private Double rIGHTCOMPLAINTCERMONIESOUT;
    @SerializedName("RIGHTS_END_WORK_BENEFITS_OUT")
    @Expose
    private Double rIGHTSENDWORKBENEFITSOUT;
    @SerializedName("RIGHTS_YEARLY_LEAVES_BENEFITS_OUT")
    @Expose
    private Double rIGHTSYEARLYLEAVESBENEFITSOUT;
    @SerializedName("RIGHTS_LEGAL_TIME_BENEFITS_OUT")
    @Expose
    private Double rIGHTSLEGALTIMEBENEFITSOUT;
    @SerializedName("RIGHTS_DISMISSAL_BENEFITS_OUT")
    @Expose
    private Double rIGHTSDISMISSALBENEFITSOUT;
    @SerializedName("COMPLAINT_LATE_WAGES_OUT")
    @Expose
    private String cOMPLAINTLATEWAGESOUT;
    @SerializedName("RIGHTS_TOTALS_OUT")
    @Expose
    private Double rIGHTSTOTALSOUT;

    public Double getRIGHTCOMPLAINTCERMONIESOUT() {
        return rIGHTCOMPLAINTCERMONIESOUT;
    }

    public void setRIGHTCOMPLAINTCERMONIESOUT(Double rIGHTCOMPLAINTCERMONIESOUT) {
        this.rIGHTCOMPLAINTCERMONIESOUT = rIGHTCOMPLAINTCERMONIESOUT;
    }

    public Double getRIGHTSENDWORKBENEFITSOUT() {
        return rIGHTSENDWORKBENEFITSOUT;
    }

    public void setRIGHTSENDWORKBENEFITSOUT(Double rIGHTSENDWORKBENEFITSOUT) {
        this.rIGHTSENDWORKBENEFITSOUT = rIGHTSENDWORKBENEFITSOUT;
    }

    public Double getRIGHTSYEARLYLEAVESBENEFITSOUT() {
        return rIGHTSYEARLYLEAVESBENEFITSOUT;
    }

    public void setRIGHTSYEARLYLEAVESBENEFITSOUT(Double rIGHTSYEARLYLEAVESBENEFITSOUT) {
        this.rIGHTSYEARLYLEAVESBENEFITSOUT = rIGHTSYEARLYLEAVESBENEFITSOUT;
    }

    public Double getRIGHTSLEGALTIMEBENEFITSOUT() {
        return rIGHTSLEGALTIMEBENEFITSOUT;
    }

    public void setRIGHTSLEGALTIMEBENEFITSOUT(Double rIGHTSLEGALTIMEBENEFITSOUT) {
        this.rIGHTSLEGALTIMEBENEFITSOUT = rIGHTSLEGALTIMEBENEFITSOUT;
    }

    public Double getRIGHTSDISMISSALBENEFITSOUT() {
        return rIGHTSDISMISSALBENEFITSOUT;
    }

    public void setRIGHTSDISMISSALBENEFITSOUT(Double rIGHTSDISMISSALBENEFITSOUT) {
        this.rIGHTSDISMISSALBENEFITSOUT = rIGHTSDISMISSALBENEFITSOUT;
    }

    public String getCOMPLAINTLATEWAGESOUT() {
        return cOMPLAINTLATEWAGESOUT;
    }

    public void setCOMPLAINTLATEWAGESOUT(String cOMPLAINTLATEWAGESOUT) {
        this.cOMPLAINTLATEWAGESOUT = cOMPLAINTLATEWAGESOUT;
    }

    public Double getRIGHTSTOTALSOUT() {
        return rIGHTSTOTALSOUT;
    }

    public void setRIGHTSTOTALSOUT(Double rIGHTSTOTALSOUT) {
        this.rIGHTSTOTALSOUT = rIGHTSTOTALSOUT;
    }

}
