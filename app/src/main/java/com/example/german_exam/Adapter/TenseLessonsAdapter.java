package com.example.german_exam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.german_exam.Model.TenselessonsModel;
import com.example.german_exam.R;

import java.util.ArrayList;

public class TenseLessonsAdapter extends RecyclerView.Adapter<TenseLessonsAdapter.MyViewHolder> {
    Context context;
    ArrayList<TenselessonsModel> tenselessonsmodel;

    public TenseLessonsAdapter(Context context, ArrayList<TenselessonsModel> tenselessonsmodel) {
        this.context = context;
        this.tenselessonsmodel = tenselessonsmodel;
    }

    @NonNull
    @Override
    public TenseLessonsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_writing,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TenseLessonsAdapter.MyViewHolder holder, int position) {
        holder.title.setText(""+tenselessonsmodel.get(position).getAnswer());

    }

    @Override
    public int getItemCount() {
        return tenselessonsmodel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title =itemView.findViewById(R.id.tv_tenseitem);
            description=itemView.findViewById(R.id.tv_tensedescription);


        }
    }
}
