package com.example.german_exam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.german_exam.Model.GrammarModel;
import com.example.german_exam.R;

import java.util.ArrayList;

public class GrammarAdapter extends RecyclerView.Adapter<GrammarAdapter.MyViewHolder> {
    Context context;
    ArrayList<GrammarModel> grammarModels;

    public GrammarAdapter(Context context, ArrayList<GrammarModel> grammarModels) {
        this.context = context;
        this.grammarModels = grammarModels;
    }

    @NonNull
    @Override
    public GrammarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grammar,parent,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull GrammarAdapter.MyViewHolder holder, int position) {
        holder.title.setText(""+grammarModels.get(position).getTitle());
        holder.description.setText(""+grammarModels.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.description.getVisibility()==View.VISIBLE){
                    holder.description.setVisibility(View.GONE);
                }else{
                   holder.description.setVisibility(View.VISIBLE);

                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return grammarModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       TextView title,description;
       ImageView imagegrammar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_tenseitem);
            description = itemView.findViewById(R.id.tv_description);
            imagegrammar =itemView.findViewById(R.id.image_grammar);


        }
    }
}
