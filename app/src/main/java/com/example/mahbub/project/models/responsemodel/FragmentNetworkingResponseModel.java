package com.example.mahbub.project.models.responsemodel;

import com.example.mahbub.project.models.normalmodel.FragmentNetworkingModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FragmentNetworkingResponseModel {
    @SerializedName("networking")
    @Expose
    private List<FragmentNetworkingModel> networking = null;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;

    public List<FragmentNetworkingModel> getNetworking() {
        return networking;
    }

    public void setNetworking(List<FragmentNetworkingModel> networking) {
        this.networking = networking;
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
