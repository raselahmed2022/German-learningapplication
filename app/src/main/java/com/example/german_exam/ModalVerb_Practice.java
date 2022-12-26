package com.example.german_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.german_exam.Adapter.ModalVerbAdapter;
import com.example.german_exam.Adapter.TenseAdapter;
import com.example.german_exam.DataBase.ApiClient;
import com.example.german_exam.DataBase.ApiInterface;
import com.example.german_exam.Model.ModalVerbModel;
import com.example.german_exam.Model.TenseModel;
import com.example.german_exam.databinding.ActivityModalVerbPracticeBinding;
import com.example.german_exam.databinding.ActivityTensePracticeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ModalVerb_Practice extends AppCompatActivity {
 ActivityModalVerbPracticeBinding binding;
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    ArrayList<ModalVerbModel> modalVerbModel;
    ModalVerbAdapter modalVerbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityModalVerbPracticeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
       String readinglevel = intent.getStringExtra("learning_item");



        recyclerView = findViewById(R.id.rv_modalverb);

        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);

        modalVerbModel = new ArrayList<>();
        modalVerbAdapter = new ModalVerbAdapter(getApplicationContext(),modalVerbModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        apiInterface.getmodalverbdata().enqueue(new Callback<List<ModalVerbModel>>() {
            @Override
            public void onResponse(Call<List<ModalVerbModel>> call, Response<List<ModalVerbModel>> response) {

                modalVerbModel.addAll(response.body());
                recyclerView.setAdapter(modalVerbAdapter);
                modalVerbAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<ModalVerbModel>> call, Throwable t) {

            }
        });


        binding.btnBackmodalverb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}