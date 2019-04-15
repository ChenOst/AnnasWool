package com.example.annaswool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AboutUsActivity extends AppCompatActivity {

    ImageView annasImage;
    TextView aboutAnna;
    Toolbar toolbar;
    FirebaseAuth mAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        annasImage = findViewById(R.id.imgAnnasimage);
        aboutAnna = findViewById(R.id.tvAnnasImg);
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
        String image = "https://i.pinimg.com/originals/cb/90/62/cb90623a5a7a182fedfff6eecc57efe8.jpg";
        Glide.with(this).asBitmap().load(image).into(annasImage);
        aboutAnna.setText("Hello, my name is Anna and knitting is my passion. When I was younger my mother taught me how to knit, but only recently as i started to expecting a baby I" +
                " started to create a baby clothes and accessories. I hope you all enjoy my product.");
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
                    intent = new Intent(this, ContactUsActivity.class);
                    this.startActivity(intent);
                    return true;
                case R.id.subitem3:
                    Toast.makeText(this, "Store Location", Toast.LENGTH_SHORT).show();
                    intent = new Intent(this, LocationActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.subitem4:
                    Toast.makeText(this, "About us", Toast.LENGTH_SHORT).show();
                    intent = new Intent(this, AboutUsActivity.class);
                    this.startActivity(intent);
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
