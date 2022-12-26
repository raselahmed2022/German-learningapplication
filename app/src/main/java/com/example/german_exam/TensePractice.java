package com.example.german_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.german_exam.Adapter.ReadingAdapter;
import com.example.german_exam.Adapter.TenseAdapter;
import com.example.german_exam.Adapter.TenseLessonsAdapter;
import com.example.german_exam.DataBase.ApiClient;
import com.example.german_exam.DataBase.ApiInterface;
import com.example.german_exam.Model.ModelReading;
import com.example.german_exam.Model.TenseModel;
import com.example.german_exam.Model.TenselessonsModel;
import com.example.german_exam.databinding.ActivityA1SpeakingBinding;
import com.example.german_exam.databinding.ActivityTensePracticeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TensePractice extends AppCompatActivity {

    ActivityTensePracticeBinding binding;
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    ArrayList<TenseModel> tenseModel;
    TenseAdapter tenseAdapter;
    ArrayList<TenselessonsModel> tenselessonModel;
    TenseLessonsAdapter tenselessonAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTensePracticeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = findViewById(R.id.rv_tense);
        tenseModel = new ArrayList<>();
        tenselessonModel = new ArrayList<>();

        tenseAdapter = new TenseAdapter(getApplicationContext(),tenseModel);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);

        tenselessonAdapter = new TenseLessonsAdapter(getApplicationContext(),tenselessonModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));


      /*  binding.cardLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                apiInterface.gettenselessonsdata().enqueue(new Callback<List<TenselessonsModel>>() {
                    @Override
                    public void onResponse(Call<List<TenselessonsModel>> call, Response<List<TenselessonsModel>> response) {

                        tenselessonModel.addAll(response.body());
                        recyclerView.setAdapter(tenselessonAdapter);
                        tenselessonAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(Call<List<TenselessonsModel>> call, Throwable t) {

                    }
                });
            }
        });*/


        apiInterface.gettensedata().enqueue(new Callback<List<TenseModel>>() {
            @Override
            public void onResponse(Call<List<TenseModel>> call, Response<List<TenseModel>> response) {

                tenseModel.addAll(response.body());
                recyclerView.setAdapter(tenseAdapter);
                tenseAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<TenseModel>> call, Throwable t) {

            }
        });




        Intent intent = getIntent();
        String readinglevel = intent.getStringExtra("learning_item");


        binding.btnBacktense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}