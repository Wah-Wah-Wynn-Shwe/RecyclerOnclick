package com.example.jsonretro.webservice;

import com.example.jsonretro.Model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("users")
    Call<List<Item>> getItems();



}
