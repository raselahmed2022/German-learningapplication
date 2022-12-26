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
import com.example.german_exam.Model.ModelWriting;
import com.example.german_exam.R;

import java.util.ArrayList;

public class WritingAdapter extends RecyclerView.Adapter<WritingAdapter.MyViewHolder> {
     Context context;
     ArrayList<ModelWriting> modelWriting;

    public WritingAdapter(Context context, ArrayList<ModelWriting> modelWriting) {
        this.context = context;
        this.modelWriting = modelWriting;
    }

    @NonNull
    @Override
    public WritingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_writing,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WritingAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(""+modelWriting.get(position).getGeTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context, A1SpeakingDescription.class);
                intent.putExtra("gedetails",""+modelWriting.get(position).getGeDescription());
             //   intent.putExtra("endetails",""+modelWriting.get(position).getEnDescription());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return modelWriting.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title =itemView.findViewById(R.id.tva1writing);
        }
    }
}
