package com.example.german_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class A1SpeakingDescription extends AppCompatActivity {

   ImageView back;
    TextView descriptiontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_speaking_description);


         descriptiontext = findViewById(R.id.tva1speakingdescrition);
        back = findViewById(R.id.btn_a1speaking_back);



        Intent intent = getIntent();
        String str1 = intent.getStringExtra("endetails");
        String str2 = intent.getStringExtra("gedetails");



        descriptiontext.setText(str1);
        descriptiontext.setText(str2);


  back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {onBackPressed();

    }
});

    }
}