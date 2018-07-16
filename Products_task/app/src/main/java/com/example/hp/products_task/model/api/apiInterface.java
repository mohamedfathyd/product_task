package com.example.hp.products_task.model.api;

import com.example.hp.products_task.model.contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiInterface {
    @GET("/products")
    Call<List<contact>> getcontacts(@Query("count") int count,@Query("from")int from);
}
