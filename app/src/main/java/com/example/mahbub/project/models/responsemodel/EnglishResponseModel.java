package com.example.mahbub.project.models.responsemodel;

import com.example.mahbub.project.models.normalmodel.EnglishModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EnglishResponseModel {
    @SerializedName("english")
    @Expose
    private List<EnglishModel> english = null;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;

    public List<EnglishModel> getEnglish() {
        return english;
    }

    public void setEnglish(List<EnglishModel> english) {
        this.english = english;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
