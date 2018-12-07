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
import com.example.mahbub.project.adapters.ProgrammingAdapter;
import com.example.mahbub.project.apiservices.ApiService;
import com.example.mahbub.project.clients.ApiClient;
import com.example.mahbub.project.models.normalmodel.FragmentOneDataModel;
import com.example.mahbub.project.models.responsemodel.FragmentOneResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentProgramming extends Fragment {



   // private Button btnDisplayDatafood;
    private RecyclerView recyclerViewFood;
    private ProgressDialog progressDialog;
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_fragmentprogramming,container,false);
        recyclerViewFood = (RecyclerView)rootView.findViewById(R.id.fragmentone);

        //btnDisplayDatafood = (Button)rootView.findViewById(R.id.button_display_data_food);
        progressDialog = new ProgressDialog(getActivity());
       getAllDataFood();
        return rootView;
    }

    @Override
    public String toString() {
        String title="Programming";
        return title;
    }

    private void getAllDataFood(){
        progressDialog.setTitle("Displaying data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<FragmentOneResponseModel> call = apiService.getAllDataFood();
        call.enqueue(new Callback<FragmentOneResponseModel>() {
            @Override
            public void onResponse(Call<FragmentOneResponseModel> call, Response<FragmentOneResponseModel> response) {
                FragmentOneResponseModel fragmentOneResponseModel = response.body();
                if(fragmentOneResponseModel.getStatus()==1){
                    List<FragmentOneDataModel> listFood = fragmentOneResponseModel.getOne();
                    ProgrammingAdapter programmingAdapter = new ProgrammingAdapter(listFood, getActivity());
                    recyclerViewFood.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerViewFood.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewFood.setAdapter(programmingAdapter);
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(getActivity(), fragmentOneResponseModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<FragmentOneResponseModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}


