package com.sh.wm.ministry.featuers.home.homeFiles.holandTest.model.activities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activity {

    @SerializedName("QUESTION_ID")
    @Expose
    private String qUESTIONID;
    @SerializedName("QUESTION_TEXT")
    @Expose
    private String qUESTIONTEXT;
    @SerializedName("ANSWER_VALUE")
    @Expose
    private String aNSWERVALUE;
    @SerializedName("ANSWER_OPTION")
    @Expose
    private Object aNSWEROPTION;



    public String getQUESTIONID() {
        return qUESTIONID;
    }

    public void setQUESTIONID(String qUESTIONID) {
        this.qUESTIONID = qUESTIONID;
    }

    public String getQUESTIONTEXT() {
        return qUESTIONTEXT;
    }

    public void setQUESTIONTEXT(String qUESTIONTEXT) {
        this.qUESTIONTEXT = qUESTIONTEXT;
    }

    public String getANSWERVALUE() {
        return aNSWERVALUE;
    }

    public void setANSWERVALUE(String aNSWERVALUE) {
        this.aNSWERVALUE = aNSWERVALUE;
    }

    public Object getANSWEROPTION() {
        return aNSWEROPTION;
    }

    public void setANSWEROPTION(Object aNSWEROPTION) {
        this.aNSWEROPTION = aNSWEROPTION;
    }
}
