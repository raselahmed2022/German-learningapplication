package com.example.german_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.german_exam.Adapter.ReadingAdapter;
import com.example.german_exam.Adapter.SpeakingAdapter;
import com.example.german_exam.Adapter.WritingAdapter;
import com.example.german_exam.DataBase.ApiClient;
import com.example.german_exam.DataBase.ApiInterface;
import com.example.german_exam.Model.ModelReading;
import com.example.german_exam.Model.ModelWriting;
import com.example.german_exam.databinding.ActivityA1ReadingBinding;
import com.example.german_exam.databinding.ActivityA1SpeakingBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Reading extends AppCompatActivity {

    ActivityA1ReadingBinding binding;

    ImageView back;
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    ArrayList<ModelReading> modelReading;
    ReadingAdapter readingAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityA1ReadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        back = findViewById(R.id.btn_a1reading_back);

        modelReading = new ArrayList<>();
        recyclerView = findViewById(R.id.rvreading);

        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);


        Intent intent = getIntent();
        String readinglevel = intent.getStringExtra("level");
        String headername = intent.getStringExtra("actionbar_title");
        binding.textView7.setText(headername);

        readingAdapter = new ReadingAdapter(getApplicationContext(), modelReading);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        apiInterface.getreadingdata(readinglevel).enqueue(new Callback<List<ModelReading>>() {
            @Override
            public void onResponse(Call<List<ModelReading>> call, Response<List<ModelReading>> response) {

                modelReading.addAll(response.body());
                recyclerView.setAdapter(readingAdapter);
                readingAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<ModelReading>> call, Throwable t) {

            }
        });


        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}