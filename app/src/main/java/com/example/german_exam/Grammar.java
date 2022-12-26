package com.example.german_exam;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.example.german_exam.Adapter.GrammarAdapter;

import com.example.german_exam.DataBase.ApiClient;
import com.example.german_exam.DataBase.ApiInterface;
import com.example.german_exam.Model.GrammarModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Grammar extends AppCompatActivity {

  ApiInterface apiInterface;
  RecyclerView recyclerView;
  ArrayList<GrammarModel> grammarModels;
  GrammarAdapter grammarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_practice);

        Intent intent = getIntent();
        String readinglevel = intent.getStringExtra("learning_item");

        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);

        recyclerView = findViewById(R.id.rv_grammar);
        grammarModels = new ArrayList<>();
        grammarAdapter = new GrammarAdapter(getApplicationContext(),grammarModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));


        apiInterface.getgrammarmodeldata().enqueue(new Callback<List<GrammarModel>>() {
            @Override
            public void onResponse(Call<List<GrammarModel>> call, Response<List<GrammarModel>> response) {

                grammarModels.addAll(response.body());
                recyclerView.setAdapter(grammarAdapter);
                grammarAdapter.notifyDataSetChanged();





            }


            @Override
            public void onFailure(Call<List<GrammarModel>> call, Throwable t) {

            }
        });



    }
}