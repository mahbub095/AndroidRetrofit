package com.example.mahbub.project.models.responsemodel;

import com.example.mahbub.project.models.normalmodel.FragmentOneDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FragmentOneResponseModel {

    @SerializedName("one")
    @Expose
    private List<FragmentOneDataModel> one = null;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;

    public List<FragmentOneDataModel> getOne() {
        return one;
    }

    public void setOne(List<FragmentOneDataModel> one) {
        this.one = one;
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