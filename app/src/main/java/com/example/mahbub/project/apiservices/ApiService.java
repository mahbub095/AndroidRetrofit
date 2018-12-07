package com.example.mahbub.project.apiservices;

import com.example.mahbub.project.models.responsemodel.EnglishResponseModel;
import com.example.mahbub.project.models.responsemodel.FragmentDataStructureResponseModel;
import com.example.mahbub.project.models.responsemodel.FragmentNetworkingResponseModel;
import com.example.mahbub.project.models.responsemodel.FragmentOneResponseModel;
import com.example.mahbub.project.models.responsemodel.MathResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by putuguna on 1/24/2017.
 */

public interface ApiService {
    @GET("food/DisplayJsonFood.php")
    Call<FragmentOneResponseModel> getAllDataFood();

    @GET("food/datastructure.php")
    Call<FragmentDataStructureResponseModel> getAllDataStructure();

    @GET("food/Networking.php")
    Call<FragmentNetworkingResponseModel> getAllNetworking();


    @GET("food/english.php")
    Call<EnglishResponseModel> getAllEnglish();


    @GET("food/math.php")
    Call<MathResponseModel> getAllMath();
}
