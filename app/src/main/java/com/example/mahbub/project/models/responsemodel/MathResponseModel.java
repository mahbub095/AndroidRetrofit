package com.example.mahbub.project.models.responsemodel;

import com.example.mahbub.project.models.normalmodel.MathModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MathResponseModel {

    @SerializedName("math")
    @Expose
    private List<MathModel> math = null;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;

    public List<MathModel> getMath() {
        return math;
    }

    public void setMath(List<MathModel> math) {
        this.math = math;
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
