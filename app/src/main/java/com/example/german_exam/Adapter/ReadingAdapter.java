package com.example.german_exam.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.german_exam.A1SpeakingDescription;
import com.example.german_exam.Model.ModelReading;
import com.example.german_exam.R;

import java.util.ArrayList;

public class ReadingAdapter extends RecyclerView.Adapter<ReadingAdapter.MyViewHolder> {

  Context context ;
  ArrayList<ModelReading> modelReading;

    public ReadingAdapter(Context context, ArrayList<ModelReading> modelReading) {
        this.context = context;
        this.modelReading = modelReading;
    }

    @NonNull
    @Override
    public ReadingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reading, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ReadingAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText(""+modelReading.get(position).getGeTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context, A1SpeakingDescription.class);
                intent.putExtra("gedetails",""+modelReading.get(position).getGeDescription());
               // intent.putExtra("endetails",""+modelReading.get(position).getEnDescription());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return modelReading.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tva1reading);

        }
    }
}
