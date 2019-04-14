package com.example.annaswool;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> categoryName = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();
    private ArrayList<String> prices = new ArrayList<>();
    private Context context;

    public SecondAdapter(Context context, ArrayList<String> categoryName, ArrayList<String> images, ArrayList<String> prices){
        this.categoryName = categoryName;
        this.images = images;
        this.context = context;
        this.prices = prices;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG,"onBindViewHolder: called.");
        Glide.with(context).asBitmap().load(images.get(position)).into(viewHolder.imageView);
        viewHolder.categoryTextView.setText(categoryName.get(position));
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: clicked on." + categoryName.get(position));
                Toast.makeText(context, categoryName.get(position),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ProductGalleryActivity.class);
                intent.putExtra("image", images.get(position));
                intent.putExtra("category name", categoryName.get(position));
                intent.putExtra("price", prices.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView categoryTextView;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            categoryTextView =  itemView.findViewById(R.id.category_textview);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
