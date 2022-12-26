package com.example.german_exam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.german_exam.CategoryItemClick;
import com.example.german_exam.Model.CategoryModel;
import com.example.german_exam.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class VocabularyAdapter extends RecyclerView.Adapter<VocabularyAdapter.MyViewHolder> {
    Context context;
    ArrayList<CategoryModel> vocabularyModel;

    private CategoryItemClick categoryItemClick;

    public VocabularyAdapter(Context context, ArrayList<CategoryModel> arrayList) {
        this.context = context;
        this.vocabularyModel = arrayList;
    }


    @NonNull
    @Override
    public VocabularyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vocabulary,parent,false);
        return new MyViewHolder(view);
    }

    private final int[] backgroundColors = {
            R.color.list_color1,
            R.color.list_color2,
            R.color.list_color3,
            R.color.list_color4,
            R.color.list_color5,
            R.color.list_color6,
            R.color.list_color7 };

    @Override
    public void onBindViewHolder(@NonNull VocabularyAdapter.MyViewHolder holder, int position) {



// in onBindViewHolder
        int index = position % backgroundColors.length;
        int color = ContextCompat.getColor(context, backgroundColors[index]);
        holder.card.setCardBackgroundColor(color);
       // holder.title.setBackgroundColor(color);
        holder.title.setText(""+vocabularyModel.get(position).getCategory());

    }

    public void setItemClick(CategoryItemClick itemClick){
        this.categoryItemClick = itemClick;
    }

    @Override
    public int getItemCount() {
        return vocabularyModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;

        MaterialCardView card;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            card = itemView.findViewById(R.id.mcard);
            title = itemView.findViewById(R.id.tv_category);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            categoryItemClick.onClick(view,getAdapterPosition());
        }

    }
}
