package com.example.annaswool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class LikedItemsActivity extends AppCompatActivity {
    private ArrayList<String> imgItem = new ArrayList<>();
    private ArrayList<String> imgDeleteItem = new ArrayList<>();
    private ArrayList<String> tvItemDescription = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_items);
        initImageBitmaps();

    }
    //RecyclerView Functions
    private void initImageBitmaps() {
        imgItem.add("https://i.pinimg.com/originals/b4/78/db/b478db5640a3af03997fed77aa51b2f3.jpg");
        imgDeleteItem.add("Baby Clothes");
        tvItemDescription.add("190");

        imgItem.add("https://i.pinimg.com/originals/2a/e9/f6/2ae9f6ccffa455536421f395a2e8c179.jpg");
        imgDeleteItem.add("Baby Shoes");
        tvItemDescription.add("190");

        imgItem.add("https://i.pinimg.com/originals/8e/cc/1d/8ecc1d7f561e620bbe8c5459bc1dbc7c.jpg");
        imgDeleteItem.add("Accessories");
        tvItemDescription.add("190");

        imgItem.add("https://i.pinimg.com/originals/cb/63/68/cb6368f8988e4ccfda9c14f4ee590557.jpg");
        imgDeleteItem.add("Blankets");
        tvItemDescription.add("190");

    }

}
