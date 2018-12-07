package com.example.mahbub.project.mFragments;

import android.app.ProgressDialog;
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
import com.example.mahbub.project.adapters.DataStructureAdapter;
import com.example.mahbub.project.adapters.EnglishAdapter;
import com.example.mahbub.project.apiservices.ApiService;
import com.example.mahbub.project.clients.ApiClient;
import com.example.mahbub.project.models.normalmodel.EnglishModel;
import com.example.mahbub.project.models.normalmodel.FragmentDataStructureModel;
import com.example.mahbub.project.models.responsemodel.EnglishResponseModel;
import com.example.mahbub.project.models.responsemodel.FragmentDataStructureResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentEnglish extends Fragment {


    // private Button btnDisplayDatafood;
    private RecyclerView recyclerViewFood;
    private ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_fragment4,container,false);

        recyclerViewFood = (RecyclerView)rootView.findViewById(R.id.fragmentenglish);

        //btnDisplayDatafood = (Button)rootView.findViewById(R.id.button_display_data_food);
        progressDialog = new ProgressDialog(getActivity());
        getAllDataFood();
        return rootView;


    }

    @Override
    public String toString() {
        String title="English";
        return title;
    }
    private void getAllDataFood(){
        progressDialog.setTitle("Displaying data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<EnglishResponseModel> call = apiService.getAllEnglish();
        call.enqueue(new Callback<EnglishResponseModel>() {
            @Override
            public void onResponse(Call<EnglishResponseModel> call, Response<EnglishResponseModel> response) {
                EnglishResponseModel fragmentEnglishResponseModel = response.body();
                if(fragmentEnglishResponseModel.getStatus()==1){
                    List<EnglishModel> listFood = fragmentEnglishResponseModel.getEnglish();
                    EnglishAdapter fragmentOneAdapter = new EnglishAdapter(listFood, getActivity());
                    recyclerViewFood.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerViewFood.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewFood.setAdapter(fragmentOneAdapter);
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(getActivity(), fragmentEnglishResponseModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<EnglishResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}


