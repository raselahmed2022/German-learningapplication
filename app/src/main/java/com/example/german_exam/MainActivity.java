package com.example.german_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.german_exam.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.cardviewTense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TensePractice.class);
               intent.putExtra("learning_item","A1_2");
                startActivity(intent);
            }
        });

        binding.cardviewGrammar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Grammar.class);
                intent.putExtra("learning_item","A1_2");
                startActivity(intent);
            }
        });

        binding.cardviewModalverb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ModalVerb_Practice.class);
                intent.putExtra("learning_item","A1_2");
               startActivity(intent);

            }
        });


        binding.cardviewVocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Intent intent = new Intent(MainActivity.this,Vocabulary.class);
              intent.putExtra("category","title");
              startActivity(intent);



            }
        });

  //getSupportActionBar().setTitle("Start learning");
      binding.cardviewReadingA1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this, Reading.class);
              intent.putExtra("level","A2");
              intent.putExtra("level","A1");
              intent.putExtra("actionbar_title","Reading Topics");
             startActivity(intent);


          }
      });



      binding.cardviewWrintingA1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Intent intent = new Intent(MainActivity.this, Writing.class);
              intent.putExtra("level","A2");
              intent.putExtra("level","A1");

              intent.putExtra("actionbar_title","Writing Topics");
              startActivity(intent);



          }
      });

      binding.cardviewSpeakingA1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent= new Intent(MainActivity.this, Speaking.class);
              intent.putExtra("level","A2");
              intent.putExtra("level","A1");
              intent.putExtra("actionbar_title","Speaking Topics");
              startActivity(intent);
          }
      });

      binding.cardviewReadingA2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent =new Intent(MainActivity.this, Reading.class);
              intent.putExtra("level","A2");
              intent.putExtra("actionbar_title","Reading Topics");
              startActivity(intent);
          }
      });
      binding.cardviewWritingA2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this, Writing.class);
              intent.putExtra("level","A2");
              intent.putExtra("actionbar_title","Writing Topics");
              startActivity(intent);
          }
      });


        binding.crdviewSpeakingA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Speaking.class);
                intent.putExtra("level","A2");
                intent.putExtra("actionbar_title","Writing Topics");
                startActivity(intent);
            }
        });



    }
}