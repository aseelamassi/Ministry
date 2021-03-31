package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model.occupationalModel;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sh.wm.ministry.network.utiels.ModelConverter;


import java.util.List;


@Entity(tableName =  "SafetyQuestions")

public class SafetyQuestionArray {

    @NonNull
    @PrimaryKey
    private  int id  =1;


    @SerializedName("1")
    @Expose
    private List<SafetyQuestion> safetyQuestions1 = null;

    @SerializedName("2")
    @Expose
    private List<SafetyQuestion> safetyQuestions2 = null;

    @SerializedName("3")
    @Expose
    private List<SafetyQuestion> safetyQuestions3 = null;

    @SerializedName("4")
    @Expose
    private List<SafetyQuestion> safetyQuestions4 = null;

    @SerializedName("5")
    @Expose
    private List<SafetyQuestion> safetyQuestions5 = null;

    @SerializedName("6")
    @Expose
    private List<SafetyQuestion> safetyQuestions6 = null;

    @SerializedName("7")
    @Expose
    private List<SafetyQuestion> safetyQuestions7 = null;

    @SerializedName("8")
    @Expose
    private List<SafetyQuestion> safetyQuestions8 = null;


    @SerializedName("9")
    @Expose
    private List<SafetyQuestion> safetyQuestions9 = null;

    @SerializedName("10")
    @Expose
    private List<SafetyQuestion> safetyQuestions10 = null;


    @SerializedName("11")
    @Expose
    private List<SafetyQuestion> safetyQuestions11 = null;

    @SerializedName("12")
    @Expose
    private List<SafetyQuestion> safetyQuestions12 = null;

    @SerializedName("13")
    @Expose
    private List<SafetyQuestion> safetyQuestions13 = null;

    @SerializedName("14")
    @Expose
    private List<SafetyQuestion> safetyQuestions14 = null;

    @SerializedName("15")
    @Expose
    private List<SafetyQuestion> safetyQuestions15 = null;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions1() {
        return safetyQuestions1;
    }

    public void setSafetyQuestions1(List<SafetyQuestion> _1) {
        this.safetyQuestions1 = _1;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions2() {
        return safetyQuestions2;
    }

    public void setSafetyQuestions2(List<SafetyQuestion> _2) {
        this.safetyQuestions2 = _2;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions3() {
        return safetyQuestions3;
    }

    public void setSafetyQuestions3(List<SafetyQuestion> _3) {
        this.safetyQuestions3 = _3;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions4() {
        return safetyQuestions4;
    }

    public void setSafetyQuestions4(List<SafetyQuestion> _4) {
        this.safetyQuestions4 = _4;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions5() {
        return safetyQuestions5;
    }

    public void setSafetyQuestions5(List<SafetyQuestion> _5) {
        this.safetyQuestions5 = _5;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions6() {
        return safetyQuestions6;
    }

    public void setSafetyQuestions6(List<SafetyQuestion> _6) {
        this.safetyQuestions6 = _6;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions7() {
        return safetyQuestions7;
    }

    public void setSafetyQuestions7(List<SafetyQuestion> _7) {
        this.safetyQuestions7 = _7;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions8() {
        return safetyQuestions8;
    }

    public void setSafetyQuestions8(List<SafetyQuestion> _8) {
        this.safetyQuestions8 = _8;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions9() {
        return safetyQuestions9;
    }

    public void setSafetyQuestions9(List<SafetyQuestion> _9) {
        this.safetyQuestions9 = _9;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions10() {
        return safetyQuestions10;
    }

    public void setSafetyQuestions10(List<SafetyQuestion> _10) {
        this.safetyQuestions10 = _10;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions11() {
        return safetyQuestions11;
    }

    public void setSafetyQuestions11(List<SafetyQuestion> _11) {
        this.safetyQuestions11 = _11;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions12() {
        return safetyQuestions12;
    }

    public void setSafetyQuestions12(List<SafetyQuestion> _12) {
        this.safetyQuestions12 = _12;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions13() {
        return safetyQuestions13;
    }

    public void setSafetyQuestions13(List<SafetyQuestion> _13) {
        this.safetyQuestions13 = _13;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions14() {
        return safetyQuestions14;
    }

    public void setSafetyQuestions14(List<SafetyQuestion> _14) {
        this.safetyQuestions14 = _14;
    }
    @TypeConverters(ModelConverter.class)

    public List<SafetyQuestion> getSafetyQuestions15() {
        return safetyQuestions15;
    }

    public void setSafetyQuestions15(List<SafetyQuestion> _15) {
        this.safetyQuestions15 = _15;
    }
}
