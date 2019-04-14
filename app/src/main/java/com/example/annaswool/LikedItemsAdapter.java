package com.example.annaswool;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class LikedItemsAdapter extends RecyclerView.Adapter<LikedItemsAdapter.ViewHolder>{

    private ArrayList<String> imgItem= new ArrayList();
    private ArrayList<String> tvItemDescription= new ArrayList();
    private ArrayList<String> tvItemPrice= new ArrayList();
    private Context context;

    public LikedItemsAdapter(Context context, ArrayList<String> imgItem, ArrayList<String> tvItemDescription, ArrayList<String> tvItemPrice){
        this.context = context;
        this.imgItem = imgItem;
        this.tvItemDescription = tvItemDescription;
        this.tvItemPrice = tvItemPrice;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_liked_items, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).asBitmap().load(imgItem.get(i)).into(viewHolder.imgItem);
        viewHolder.tvItemDescription.setText(tvItemDescription.get(i));
        viewHolder.tvItemPrice.setText(tvItemPrice.get(i));
    }

    @Override
    public int getItemCount() {
        return imgItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgItem, imgDeleteItem;
        TextView tvItemDescription, tvItemPrice;
        RelativeLayout LikedRecyclerview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            imgDeleteItem = itemView.findViewById(R.id.imgDeleteItem);
            tvItemDescription = itemView.findViewById(R.id.tvItemDescription);
            tvItemPrice = itemView.findViewById(R.id.tvItemPrice);
            LikedRecyclerview = itemView.findViewById(R.id.LikedRecyclerview);
        }
    }
}
