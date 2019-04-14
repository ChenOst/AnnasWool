package com.example.annaswool;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.like.LikeButton;
import com.like.OnAnimationEndListener;
import com.like.OnLikeListener;

public class ProductGalleryActivity extends AppCompatActivity implements OnLikeListener, OnAnimationEndListener {

    private static final String TAG = "ProductGalleryActivity";

    //vars
    Toolbar toolbar;
    LikeButton heartButton;
    FirebaseAuth mAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_gallery);
        Log.d(TAG, "onCreate: started.");
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();

        heartButton = findViewById(R.id.heart_button);
        heartButton.setOnLikeListener(this);
        heartButton.setOnAnimationEndListener(this);

        getIncomingIntent();
    }


    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if(getIntent().hasExtra("image") && getIntent().hasExtra("category name") && getIntent().hasExtra("price")){
            Log.d(TAG, "getIncomingIntent: fount intent extras.");

            String image = getIntent().getStringExtra("image");
            String productDescriptoin = getIntent().getStringExtra("category name");
            String price = getIntent().getStringExtra("price");

            setImage(image, productDescriptoin, price);
        }
    }

    private void setImage(String image, String productDescriptoin, String price){
        Log.d(TAG, "setImage: setting the image and category to widgets.");

        TextView name = findViewById(R.id.image_description);
        name.setText(productDescriptoin);

        ImageView imageView = findViewById(R.id.image);
        Glide.with(this).asBitmap().load(image).into(imageView);

        TextView priceOfProduct = findViewById(R.id.price);
        priceOfProduct.setText(price);


    }

    // HeartButton Functions - user can like/dislike only when connected
    @Override
    public void liked(LikeButton likeButton) {
        if(firebaseUser!=null) {
            Toast.makeText(this, "Liked!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Need connect to account", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void unLiked(LikeButton likeButton) {
        if(firebaseUser!=null) {
            Toast.makeText(this, "Disliked!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Need connect to account", Toast.LENGTH_LONG).show();
        }
    }
    @Override public void onAnimationEnd(LikeButton likeButton) {
        Log.d(TAG, "Animation End for %s" + likeButton);
    }

    //ToolBar Functions
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.subitem1:
                Toast.makeText(this, "Main Menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                return true;
            case R.id.subitem2:
                Toast.makeText(this, "Customer Service", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem3:
                Toast.makeText(this, "Store Location", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_account:
                Toast.makeText(this, "account", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
