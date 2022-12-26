package com.example.german_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.german_exam.Adapter.SpeakingAdapter;
import com.example.german_exam.DataBase.ApiClient;
import com.example.german_exam.DataBase.ApiInterface;
import com.example.german_exam.Model.ModelSpeaking;
import com.example.german_exam.databinding.ActivityA1SpeakingBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Speaking extends AppCompatActivity {

    ActivityA1SpeakingBinding binding;

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    SpeakingAdapter speakingAdapter;
    ArrayList<ModelSpeaking> modelSpeaking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityA1SpeakingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        String speakinglevel = intent.getStringExtra("level");
        String headername = intent.getStringExtra("actionbar_title");
         binding.textView7.setText(headername);



        modelSpeaking = new ArrayList<>();
        recyclerView = findViewById(R.id.rvspeakingA1);

        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);

        speakingAdapter = new SpeakingAdapter(getApplicationContext(), modelSpeaking);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));


        apiInterface.getspeakingdata(speakinglevel).enqueue(new Callback<List<ModelSpeaking>>() {


            @Override
            public void onResponse(Call<List<ModelSpeaking>> call, Response<List<ModelSpeaking>> response) {

                modelSpeaking.addAll(response.body());
                recyclerView.setAdapter(speakingAdapter);
                speakingAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<ModelSpeaking>> call, Throwable t) {


                
            }
        });


        binding.btnA1speakingBack.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                onBackPressed();

            }
        });
    }
}