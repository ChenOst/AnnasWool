package com.example.annaswool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    //vars
    Toolbar toolbar;
    private ArrayList<String> category = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();
    private ArrayList<String> prices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initImageBitmaps();
    }

    //RecyclerView Functions
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: prepering bitmaps.");
        if(getIntent().hasExtra("category name")){
            String productDescriptoin = getIntent().getStringExtra("category name");
            if (productDescriptoin.equals("Baby Clothes")) {
                images.add("https://i.pinimg.com/originals/fc/2c/5a/fc2c5a5aca1b33fa3360295700c8b4c9.jpg");
                category.add("Item 1");
                prices.add("12₪");

                images.add("https://i.pinimg.com/originals/b7/80/ee/b780ee18fd912c84500f496bb4173933.jpg");
                category.add("Item 2");
                prices.add("13₪");

                images.add("https://i.pinimg.com/originals/c2/b8/86/c2b886890d71b72098399adfc5504def.jpg");
                category.add("Item 3");
                prices.add("14₪");

                images.add("https://i.pinimg.com/originals/55/fd/b2/55fdb2200e1db363fc5174c9381e9e42.jpg");
                category.add("Item 4");
                prices.add("15₪");

                images.add("https://i.pinimg.com/originals/1c/2a/c0/1c2ac0d05a45e1d83b73b856acdacbe9.jpg");
                category.add("Item 5");
                prices.add("16₪");
                initRecyclerView();
            }
            else if (productDescriptoin.equals("Baby Shoes")) {
                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 11");
                prices.add("100₪");

                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 22");
                prices.add("100₪");

                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 33");
                prices.add("100₪");

                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 44");
                prices.add("100₪");
                initRecyclerView();
            }
            else if (productDescriptoin.equals("Accessories")) {
                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 111");
                prices.add("100₪");

                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 222");
                prices.add("100₪");

                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 333");
                prices.add("100₪");

                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 444");
                prices.add("100");
                initRecyclerView();
            }
            else if (productDescriptoin.equals("Blankets")) {
                images.add("https://i.pinimg.com/originals/da/b3/28/dab32897e356e4949830515d6d1c7c57.jpg");
                category.add("Item 1");
                prices.add("100");

                images.add("https://i.pinimg.com/originals/e8/32/f8/e832f8c29a326fdf694b8061dab4d1a2.jpg");
                category.add("Item 2");
                prices.add("100");

                images.add("https://i.pinimg.com/originals/7a/af/45/7aaf454d537cb03d77018a0cd3eb426b.jpg");
                category.add("Item 3");
                prices.add("100");

                images.add("https://i.pinimg.com/originals/e4/b8/f8/e4b8f8cb6c5dd462ce35e3ff2f4ca9db.jpg");
                category.add("Item 4");
                prices.add("100");

                images.add("https://i.pinimg.com/originals/36/0a/ef/360aef3e490939b7baf922c5fd2503b3.jpg");
                category.add("Item 5");
                prices.add("100");

                images.add("https://i.pinimg.com/originals/3c/82/15/3c8215263a844d58c362c84126af0a01.jpg");
                category.add("Item 6");
                prices.add("100");

                images.add("https://i.pinimg.com/originals/ea/a5/c5/eaa5c5cfa3399c1c6cf606681eeb5489.jpg");
                category.add("Item 7");
                prices.add("100");

                images.add("https://i.pinimg.com/originals/02/42/22/024222eadefd6888b93fc5c1f0331fb8.jpg");
                category.add("Item 8");
                prices.add("100");

                images.add("https://i.pinimg.com/originals/bb/2b/88/bb2b88a157bd33c0200120ca881cdf25.jpg");
                category.add("Item 9");
                prices.add("100");
                initRecyclerView();
            }
            else{
                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 6");
                prices.add("100");

                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 7");
                prices.add("100");

                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 8");
                prices.add("100");

                images.add("https://i.redd.it/glin0nwndo501.jpg");
                category.add("Item 9");
                prices.add("100");
                initRecyclerView();
            }
        }
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init RecyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        SecondAdapter adapter = new SecondAdapter(this, category, images, prices);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
