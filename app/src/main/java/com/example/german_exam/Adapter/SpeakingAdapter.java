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
import com.example.german_exam.Model.ModelSpeaking;
import com.example.german_exam.R;

import java.util.ArrayList;

   public class SpeakingAdapter extends RecyclerView.Adapter<SpeakingAdapter.MyViewHolder> {

    Context context;
    ArrayList<ModelSpeaking> modelSpeaking;

    public SpeakingAdapter(Context context, ArrayList<ModelSpeaking> modelSpeaking) {
        this.context = context;
        this.modelSpeaking = modelSpeaking;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speaking, parent, false);
        return new  MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText("" + modelSpeaking.get(position).getGeTitle());



        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context, A1SpeakingDescription.class);
                intent.putExtra("gedetails",""+modelSpeaking.get(position).getGeDescription());
                intent.putExtra("endetails",""+modelSpeaking.get(position).getEnDescription());
                //intent.putExtra("getitle",""+modelSpeaking.get(position).getGeTitle());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {


        return modelSpeaking.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

      TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tvtitleSpeaing1);



        }
    }
}
