package com.example.german_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.german_exam.Adapter.WritingAdapter;
import com.example.german_exam.DataBase.ApiClient;
import com.example.german_exam.DataBase.ApiInterface;
import com.example.german_exam.Model.ModelSpeaking;
import com.example.german_exam.Model.ModelWriting;
import com.example.german_exam.databinding.ActivityA1WritingBinding;
import com.example.german_exam.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Writing extends AppCompatActivity {

    ActivityA1WritingBinding binding;

    ApiInterface apiInterface;
    WritingAdapter writingAdapter;
    RecyclerView recyclerView;
    ArrayList<ModelWriting> modelWriting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityA1WritingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        modelWriting = new ArrayList<>();
        recyclerView=findViewById(R.id.rvwritinga1);

        Retrofit retrofit = ApiClient.getClint();
        apiInterface =retrofit.create(ApiInterface.class);

        Intent intent = getIntent();
        String writinglevel = intent.getStringExtra("level");

        String headername = intent.getStringExtra("actionbar_title");
        binding.textView7.setText(headername);



        writingAdapter = new WritingAdapter(getApplicationContext(),modelWriting);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        apiInterface.getwritingdata(writinglevel).enqueue(new Callback<List<ModelWriting>>() {
            @Override
            public void onResponse(Call<List<ModelWriting>> call, Response<List<ModelWriting>> response) {

                modelWriting.addAll(response.body());
                recyclerView.setAdapter(writingAdapter);
                writingAdapter.notifyDataSetChanged();

                
            }

            @Override
            public void onFailure(Call<List<ModelWriting>> call, Throwable t) {

            }
        });


        binding.btnA1writingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}