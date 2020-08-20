package com.example.jsonretro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.jsonretro.Model.Item;
import com.example.jsonretro.adapter.Itemadapter;
import com.example.jsonretro.webservice.ApiInterface;
import com.example.jsonretro.webservice.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Itemadapter.RecyclerViewClickListener {
    private final String TAG=MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<Item> items=new ArrayList<>();
    private Itemadapter itemsAdapter;
    private RecyclerView.LayoutManager linearLayoutManager;
    private Itemadapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Itemadapter adapter=new Itemadapter(listener);
        recyclerView.setAdapter(adapter);


        fetchUsers();
    }

    private void fetchUsers() {
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<List<Item>> call = apiInterface.getItems();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()) {
                    Log.d("GG_", "" + response.body());
                    itemsAdapter.setItems(response.body());
                } else {
                    Log.e(TAG, response.message());
                }

            }
            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }


    @Override
    public void onClick(Item item) {
        Intent intent=new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("id" ,item.getID());
        startActivity(intent);
    }
}

