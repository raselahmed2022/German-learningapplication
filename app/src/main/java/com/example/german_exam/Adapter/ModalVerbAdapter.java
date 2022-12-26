package com.example.german_exam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.german_exam.Model.ModalVerbModel;
import com.example.german_exam.R;

import java.util.ArrayList;

public class ModalVerbAdapter extends RecyclerView.Adapter<ModalVerbAdapter.MyViewHolder> {
   Context context;
   ArrayList<ModalVerbModel> modalverb;

    public ModalVerbAdapter(Context context, ArrayList<ModalVerbModel> modalverb) {
        this.context = context;
        this.modalverb = modalverb;
    }

    @NonNull
    @Override
    public ModalVerbAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modalverb,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModalVerbAdapter.MyViewHolder holder, int position) {

        holder.title.setText(""+modalverb.get(position).getTitle());
        holder.descripton.setText(""+modalverb.get(position).getDescription());
        Glide
                .with(context)
                .load(""+modalverb.get(position).getUrl())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.descripton.getVisibility()==View.VISIBLE){
                    holder.descripton.setVisibility(View.GONE);
                    holder.imageView.setVisibility(View.GONE);


                }else{
                    holder.descripton.setVisibility(View.VISIBLE);
                    holder.imageView.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return modalverb.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,descripton;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title =itemView.findViewById(R.id.tv_modalverbitem);
            descripton =itemView.findViewById(R.id.tv_modalverbDescription);
            imageView = itemView.findViewById(R.id.image_description);
        }
    }
}
