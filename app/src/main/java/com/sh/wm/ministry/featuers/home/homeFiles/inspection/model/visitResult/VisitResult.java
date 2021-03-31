package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.visitResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VisitResult {

    @SerializedName("QUESTION_1")
    @Expose
    private List<Question> qUESTION1 = null;
    @SerializedName("QUESTION_2")
    @Expose
    private List<Question> qUESTION2 = null;
    @SerializedName("QUESTION_3")
    @Expose
    private List<Question> qUESTION3 = null;
    @SerializedName("QUESTION_1_COUNT")
    @Expose
    private Integer qUESTION1COUNT;
    @SerializedName("QUESTION_3_COUNT")
    @Expose
    private Integer qUESTION3COUNT;
    @SerializedName("avg")
    @Expose
    private Integer avg;
    @SerializedName("ACTION_TAKEN")
    @Expose
    private String aCTIONTAKEN;
    @SerializedName("RECOMMENDED_ACTION")
    @Expose
    private String rECOMMENDEDACTION;
    @SerializedName("ADVISED_ACTION")
    @Expose
    private String aDVISEDACTION;
    @SerializedName("construction_name")
    @Expose
    private String constructionName;
    @SerializedName("contruct_no")
    @Expose
    private String contructNo;

    public List<Question> getQUESTION1() {
        return qUESTION1;
    }

    public void setQUESTION1(List<Question> qUESTION1) {
        this.qUESTION1 = qUESTION1;
    }

    public List<Question> getQUESTION2() {
        return qUESTION2;
    }

    public void setQUESTION2(List<Question> qUESTION2) {
        this.qUESTION2 = qUESTION2;
    }

    public List<Question> getQUESTION3() {
        return qUESTION3;
    }

    public void setQUESTION3(List<Question> qUESTION3) {
        this.qUESTION3 = qUESTION3;
    }

    public Integer getQUESTION1COUNT() {
        return qUESTION1COUNT;
    }

    public void setQUESTION1COUNT(Integer qUESTION1COUNT) {
        this.qUESTION1COUNT = qUESTION1COUNT;
    }

    public Integer getQUESTION3COUNT() {
        return qUESTION3COUNT;
    }

    public void setQUESTION3COUNT(Integer qUESTION3COUNT) {
        this.qUESTION3COUNT = qUESTION3COUNT;
    }

    public Integer getAvg() {
        return avg;
    }

    public void setAvg(Integer avg) {
        this.avg = avg;
    }

    public String getACTIONTAKEN() {
        return aCTIONTAKEN;
    }

    public void setACTIONTAKEN(String aCTIONTAKEN) {
        this.aCTIONTAKEN = aCTIONTAKEN;
    }

    public String getRECOMMENDEDACTION() {
        return rECOMMENDEDACTION;
    }

    public void setRECOMMENDEDACTION(String rECOMMENDEDACTION) {
        this.rECOMMENDEDACTION = rECOMMENDEDACTION;
    }

    public String getADVISEDACTION() {
        return aDVISEDACTION;
    }

    public void setADVISEDACTION(String aDVISEDACTION) {
        this.aDVISEDACTION = aDVISEDACTION;
    }

    public String getConstructionName() {
        return constructionName;
    }

    public void setConstructionName(String constructionName) {
        this.constructionName = constructionName;
    }

    public String getContructNo() {
        return contructNo;
    }

    public void setContructNo(String contructNo) {
        this.contructNo = contructNo;
    }
}
