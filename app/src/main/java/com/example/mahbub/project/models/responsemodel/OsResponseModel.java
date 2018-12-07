package com.example.mahbub.project.models.responsemodel;

import com.example.mahbub.project.models.normalmodel.OsModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OsResponseModel {
    @SerializedName("os")
    @Expose
    private List<OsModel> os = null;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;

    public List<OsModel> getOs() {
        return os;
    }

    public void setOs(List<OsModel> os) {
        this.os = os;
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
