package com.example.hp.products_task.model.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.products_task.R;
import com.example.hp.products_task.model.contact;
import com.example.hp.products_task.view.fullscreen_img;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<contact> contacts;
    private Context context;
     public RecyclerAdapter(Context context,List<contact> contacts){
         this.contacts=contacts;
         this.context=context;
     }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_items,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
          holder.price.setText("$"+contacts.get(position).getPrice());
        Picasso.with(context).load(contacts.get(position).getImage().getUrl()).into(holder.image);
        int width = contacts.get(position).getImage().getWidth();
        int hight = contacts.get(position).getImage().getHeight()*2;
        holder.cardView.getLayoutParams().height=hight;
        holder.cardView.requestLayout();
        holder.description.setText(contacts.get(position).getProductDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,fullscreen_img.class);
                intent.putExtra("url",contacts.get(position).getImage().getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
         TextView price,description;
         CardView cardView;
         ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            price=(TextView)itemView.findViewById(R.id.price);
            image=(ImageView)itemView.findViewById(R.id.image);
            description=(TextView)itemView.findViewById(R.id.description);
            cardView=(CardView)itemView.findViewById(R.id.card);
        }
    }
}
