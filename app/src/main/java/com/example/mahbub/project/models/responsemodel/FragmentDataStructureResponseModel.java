package com.example.mahbub.project.models.responsemodel;

import com.example.mahbub.project.models.normalmodel.FragmentDataStructureModel;
import com.example.mahbub.project.models.normalmodel.FragmentOneDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FragmentDataStructureResponseModel {
    @SerializedName("datastructure")
    @Expose
    private List<FragmentDataStructureModel> datastructure = null;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;

    public List<FragmentDataStructureModel> getDatastructure() {
        return datastructure;
    }

    public void setDatastructure(List<FragmentDataStructureModel> datastructure) {
        this.datastructure = datastructure;
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
