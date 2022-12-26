package com.example.german_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartPage extends AppCompatActivity {


    CardView startpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        startpage = findViewById(R.id.cv_startpage);


        startpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(StartPage.this,MainActivity.class);

                startActivity(intent);

            }
        });


    }
}