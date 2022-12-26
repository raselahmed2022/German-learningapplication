package com.example.german_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.german_exam.Adapter.VocabularyAdapter;
import com.example.german_exam.DataBase.ApiClient;
import com.example.german_exam.DataBase.ApiInterface;
import com.example.german_exam.Model.CategoryModel;
import com.example.german_exam.Model.GeneralVocabModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Vocabulary extends AppCompatActivity implements CategoryItemClick{
  ApiInterface apiInterface;
  RecyclerView recyclerView;
  VocabularyAdapter vocabularyAdapter;
  ArrayList <CategoryModel> vocabularyModels;
  ArrayList <GeneralVocabModel> generalVocabModels;

  CardView meaningcardview;

  ImageView rightarrow,leftarrow;
  TextView tvnumber,tvdemo,title;
    int index = 0;
    String vocindex = "1";

    @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);



        Dialog dialog= new Dialog(Vocabulary.this);
        //dialog.setContentView(R.layout.customdialog);


        meaningcardview = findViewById(R.id.meaningcardview);

        title =findViewById(R.id.tv_title);
        rightarrow =findViewById(R.id.rightarrow);
        leftarrow =findViewById(R.id.leftarrow);
      tvnumber = findViewById(R.id.tv_number);
      tvdemo = findViewById(R.id.tv_demo);
        vocabularyModels = new ArrayList<>();
        recyclerView = findViewById(R.id.rv_category);

        generalVocabModels = new ArrayList<>();

        Intent intent = getIntent();
        String readinglevel = intent.getStringExtra("title");



        Retrofit retrofit = ApiClient.getClint();
        apiInterface = retrofit.create(ApiInterface.class);

        vocabularyAdapter = new VocabularyAdapter(getApplicationContext(), vocabularyModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));

        vocabularyAdapter.setItemClick(this);



        apiInterface.getgeneralvocabdata(vocindex).enqueue(new Callback<List<GeneralVocabModel>>() {
            @Override
            public void onResponse(Call<List<GeneralVocabModel>> call, Response<List<GeneralVocabModel>> response) {
                generalVocabModels.addAll(response.body());
                tvnumber.setText(generalVocabModels.get(0).getEnWord());
                tvdemo.setText(generalVocabModels.get(1).getGeWord());





            }

            @Override
            public void onFailure(Call<List<GeneralVocabModel>> call, Throwable t) {


            }
        });



        rightarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = index+1;
                  if (index < generalVocabModels.size()){
                      tvdemo.setText(generalVocabModels.get(index).getGeWord());
                      tvnumber.setText(generalVocabModels.get(index).getEnWord());

                      //Log.d("sheshir", "insideif");
                     // Log.d("sheshir size",Integer.toString(generalVocabModels.size()));

                  }else{
                      tvnumber.setText(generalVocabModels.get(generalVocabModels.size()-1).getEnWord());
                      tvdemo.setText(generalVocabModels.get(generalVocabModels.size()-1).getGeWord());
                     // Log.d("sheshir", "insideelse");

                  }
             /*     if(index == generalVocabModels.size()){
                     // Toast.makeText(Vocabulary.this, "ok", Toast.LENGTH_SHORT).show();
                      tvnumber.setText(generalVocabModels.get(generalVocabModels.size()).getEnWord());

                  }else{

                      tvnumber.setText(generalVocabModels.get(index).getEnWord());

                  }*/



              //  Toast.makeText(Vocabulary.this, ""+generalVocabModels.size(), Toast.LENGTH_SHORT).show();

            }
        });


        leftarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                index = index-1;
                if(index>=0){
                    if(index <generalVocabModels.size()){

                           tvnumber.setText(generalVocabModels.get(index).getEnWord());

                        //Log.d("sheshir", "insideif");
                        //Log.d("sheshir size",Integer.toString(generalVocabModels.size()));


                    }else{

                        tvnumber.setText(generalVocabModels.get(generalVocabModels.size()).getEnWord());

                       // Log.d("sheshir", "insideelse");

                    }
                }



            }
        });

        meaningcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.setContentView(R.layout.customdialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
              //  dialog.setCancelable(false);

           TextView  meaning = dialog.findViewById(R.id.tv_name);

                meaning.setText(generalVocabModels.get(0).getEnWord());
                dialog.show();




            }
        });

        apiInterface.getvocabdata().enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
                vocabularyModels.addAll(response.body());
                recyclerView.setAdapter(vocabularyAdapter);
                vocabularyAdapter.notifyDataSetChanged();

                title.setText(""+vocabularyModels.get(0).getCategory());
            }

            @Override
            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {

            }
        });




    }

    @Override
    public void onClick(View view, int position) {

       // Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
        //git test
        int pos = position+1;


        title.setText(""+vocabularyModels.get(position).getCategory());

        apiInterface.getgeneralvocabdata(""+pos).enqueue(new Callback<List<GeneralVocabModel>>() {
            @Override
            public void onResponse(Call<List<GeneralVocabModel>> call, Response<List<GeneralVocabModel>> response) {
               generalVocabModels.clear();
                generalVocabModels.addAll(response.body());
                tvnumber.setText(generalVocabModels.get(0).getEnWord());
                tvdemo.setText(generalVocabModels.get(1).getGeWord());


            }

            @Override
            public void onFailure(Call<List<GeneralVocabModel>> call, Throwable t) {


            }
        });
    }
}