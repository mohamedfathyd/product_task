package com.example.hp.products_task.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.hp.products_task.model.Adapter.RecyclerAdapter;
import com.example.hp.products_task.model.api.ApiClient;
import com.example.hp.products_task.model.api.apiInterface;
import com.example.hp.products_task.model.contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Controller {
    Context context;
    private List<contact> contactList;
    private apiInterface apiInterface;

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    public Controller(Context context, RecyclerView recyclerView) {
        this.context=context;
        this.recyclerView=recyclerView;
    }
    public void startFetching() {

        apiInterface= ApiClient.getapiClient().create(apiInterface.class);
        Call<List<contact>> call = apiInterface.getcontacts(10,1);

        call.enqueue(new Callback<List<contact>>() {

            @Override
            public void onResponse(Call<List<contact>> call, Response<List<contact>> response) {

                contactList = response.body();

                recyclerAdapter=new RecyclerAdapter(context,contactList);
                recyclerView.setAdapter(recyclerAdapter);

            }

            @Override
            public void onFailure(Call<List<contact>> call, Throwable t) {

            }
        });
    }
}
