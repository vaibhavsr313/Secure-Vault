package com.example.vaibhav;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
{
    private Context context;
    private List<DataClass> dataList;

    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImg()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getDataName());
        holder.recDesc.setText(dataList.get(position).getDataMail());
        holder.recLang.setText(dataList.get(position).getDataPass());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("Image",dataList.get(holder.getAdapterPosition()).getDataImg());
                intent.putExtra("Description",dataList.get(holder.getAdapterPosition()).getDataMail());
                intent.putExtra("Title",dataList.get(holder.getAdapterPosition()).getDataName());
                intent.putExtra("Lang",dataList.get(holder.getAdapterPosition()).getDataPass());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searchDataList(ArrayList<DataClass> searchList){

        dataList = searchList;
        notifyDataSetChanged();

    }

}



class MyViewHolder extends RecyclerView.ViewHolder
{
    ImageView recImage;
    TextView recTitle,recDesc,recLang;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView)
    {
        super(itemView);
        recImage =itemView.findViewById(R.id.recImage);
        recDesc = itemView.findViewById(R.id.recDesc);
        recLang = itemView.findViewById(R.id.recLang);
        recTitle = itemView.findViewById(R.id.recTitle);
        recCard = itemView.findViewById(R.id.recCard);
    }

}
