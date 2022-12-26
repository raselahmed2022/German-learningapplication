package com.example.german_exam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.german_exam.Model.TenseModel;
import com.example.german_exam.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TenseAdapter extends RecyclerView.Adapter<TenseAdapter.MyViewHolder> {
   Context context;
   ArrayList<TenseModel> tenseModel;

    public TenseAdapter(Context context, ArrayList<TenseModel> tenseModel) {
        this.context = context;
        this.tenseModel = tenseModel;
    }

    @NonNull
    @Override
    public TenseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tenses,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TenseAdapter.MyViewHolder holder, int position) {
        holder.title.setText(""+tenseModel.get(position).getTitle());
        holder.description.setText(""+tenseModel.get(position).getDescription());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.cardView.getVisibility() == View.VISIBLE){
                    holder.cardView.setVisibility(View.GONE);


                }else {
                    holder.cardView.setVisibility(View.VISIBLE);

                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return tenseModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,description;
        CardView cardView;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           title = itemView.findViewById(R.id.tv_tenseitem);
            cardView = itemView.findViewById(R.id.cardViewtense);
            description = itemView.findViewById(R.id.tv_tensedescription);



        }
    }
}
