package com.example.mahbub.project.mFragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mahbub.project.R;
import com.example.mahbub.project.adapters.EnglishAdapter;
import com.example.mahbub.project.adapters.MathAdapter;
import com.example.mahbub.project.apiservices.ApiService;
import com.example.mahbub.project.clients.ApiClient;
import com.example.mahbub.project.models.normalmodel.EnglishModel;
import com.example.mahbub.project.models.normalmodel.MathModel;
import com.example.mahbub.project.models.responsemodel.EnglishResponseModel;
import com.example.mahbub.project.models.responsemodel.MathResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragmentmath extends Fragment {


    private RecyclerView recyclerViewFood;
    private ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragmentmath, container, false);

        recyclerViewFood = (RecyclerView) rootView.findViewById(R.id.fragmentmath);

        //btnDisplayDatafood = (Button)rootView.findViewById(R.id.button_display_data_food);
        progressDialog = new ProgressDialog(getActivity());
        getAllDataFood();
        return rootView;


    }

    @Override
    public String toString() {
        String title = "Math";
        return title;
    }

    private void getAllDataFood() {
        progressDialog.setTitle("Displaying data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<MathResponseModel> call = apiService.getAllMath();
        call.enqueue(new Callback<MathResponseModel>() {
            @Override
            public void onResponse(Call<MathResponseModel> call, Response<MathResponseModel> response) {
                MathResponseModel fragmentmathResponseModel = response.body();
                if (fragmentmathResponseModel.getStatus() == 1) {
                    List<MathModel> listFood = fragmentmathResponseModel.getMath();
                    MathAdapter fragmentOneAdapter = new MathAdapter(listFood, getActivity());
                    recyclerViewFood.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerViewFood.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewFood.setAdapter(fragmentOneAdapter);
                    progressDialog.dismiss();
                } else {
                    Toast.makeText(getActivity(), fragmentmathResponseModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<MathResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}


