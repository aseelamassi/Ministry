package com.sh.wm.ministry.network.database.dbModels.eduDepartmentAndProgram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EduDepartmentsAndProgramModel {


    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("edu_departments_and_program")
    @Expose
    private List<EduDepartmentsAndProgram> eduDepartmentsAndProgram = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<EduDepartmentsAndProgram> getEduDepartmentsAndProgram() {
        return eduDepartmentsAndProgram;
    }

    public void setEduDepartmentsAndProgram(List<EduDepartmentsAndProgram> eduDepartmentsAndProgram) {
        this.eduDepartmentsAndProgram = eduDepartmentsAndProgram;
    }


}
