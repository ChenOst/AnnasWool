package com.example.annaswool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    //vars
    Button signOut, pay;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    Toolbar toolbar;
    private ArrayList<String> imgItem= new ArrayList();
    private ArrayList<String> tvItemDescription= new ArrayList();
    private ArrayList<String> tvItemPrice= new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        signOut = findViewById(R.id.btnSignOut);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initImageBitmaps();

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

    }

    //RecyclerView Functions
    private void initImageBitmaps(){
        imgItem.add("https://i.pinimg.com/originals/b4/78/db/b478db5640a3af03997fed77aa51b2f3.jpg");
        tvItemDescription.add("Baby Clothes");
        tvItemPrice.add("10");

        imgItem.add("https://i.pinimg.com/originals/2a/e9/f6/2ae9f6ccffa455536421f395a2e8c179.jpg");
        tvItemDescription.add("Baby Shoes");
        tvItemPrice.add("10");

        imgItem.add("https://i.pinimg.com/originals/8e/cc/1d/8ecc1d7f561e620bbe8c5459bc1dbc7c.jpg");
        tvItemDescription.add("Accessories");
        tvItemPrice.add("10");

        imgItem.add("https://i.pinimg.com/originals/cb/63/68/cb6368f8988e4ccfda9c14f4ee590557.jpg");
        tvItemDescription.add("Blankets");
        tvItemPrice.add("10");

        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView liked = findViewById(R.id.recyclerviewLikedItems);
        LikedItemsAdapter adapter = new LikedItemsAdapter(this, imgItem, tvItemDescription, tvItemPrice );
        liked.setAdapter(adapter);
        liked.setLayoutManager(new LinearLayoutManager(this));
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
        switch (item.getItemId()){
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
                if (firebaseUser==null) {
                    Intent intent1 = new Intent(this, LoginActivity.class);
                    startActivity(intent1);
                }
                else{
                    Intent intent1 = new Intent(this, ProfileActivity.class);
                    startActivity(intent1);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
