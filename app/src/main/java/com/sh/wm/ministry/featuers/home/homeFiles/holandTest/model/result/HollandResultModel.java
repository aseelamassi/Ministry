package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class HollandResultModel implements Serializable {

    @SerializedName("summary")
    @Expose
    private List<Summary> summary = null;
    @SerializedName("sum1")
    @Expose
    private Integer sum1;
    @SerializedName("sum2")
    @Expose
    private Integer sum2;
    @SerializedName("sum3")
    @Expose
    private Integer sum3;
    @SerializedName("sum4")
    @Expose
    private Integer sum4;
    @SerializedName("sum5")
    @Expose
    private Integer sum5;
    @SerializedName("sum6")
    @Expose
    private Integer sum6;
    @SerializedName("max1")
    @Expose
    private String max1;
    @SerializedName("max2")
    @Expose
    private String max2;
    @SerializedName("max3")
    @Expose
    private String max3;
    @SerializedName("similar_jobs")
    @Expose
    private List<SimilarJob> similarJobs = null;
    @SerializedName("identical_job")
    @Expose
    private String identicalJob;

    public List<Summary> getSummary() {
        return summary;
    }

    public void setSummary(List<Summary> summary) {
        this.summary = summary;
    }

    public Integer getSum1() {
        return sum1;
    }

    public void setSum1(Integer sum1) {
        this.sum1 = sum1;
    }

    public Integer getSum2() {
        return sum2;
    }

    public void setSum2(Integer sum2) {
        this.sum2 = sum2;
    }

    public Integer getSum3() {
        return sum3;
    }

    public void setSum3(Integer sum3) {
        this.sum3 = sum3;
    }

    public Integer getSum4() {
        return sum4;
    }

    public void setSum4(Integer sum4) {
        this.sum4 = sum4;
    }

    public Integer getSum5() {
        return sum5;
    }

    public void setSum5(Integer sum5) {
        this.sum5 = sum5;
    }

    public Integer getSum6() {
        return sum6;
    }

    public void setSum6(Integer sum6) {
        this.sum6 = sum6;
    }

    public String getMax1() {
        return max1;
    }

    public void setMax1(String max1) {
        this.max1 = max1;
    }

    public String getMax2() {
        return max2;
    }

    public void setMax2(String max2) {
        this.max2 = max2;
    }

    public String getMax3() {
        return max3;
    }

    public void setMax3(String max3) {
        this.max3 = max3;
    }

    public List<SimilarJob> getSimilarJobs() {
        return similarJobs;
    }

    public void setSimilarJobs(List<SimilarJob> similarJobs) {
        this.similarJobs = similarJobs;
    }

    public String getIdenticalJob() {
        return identicalJob;
    }

    public void setIdenticalJob(String identicalJob) {
        this.identicalJob = identicalJob;
    }
}
