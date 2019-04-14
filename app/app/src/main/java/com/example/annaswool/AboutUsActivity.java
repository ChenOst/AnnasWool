package com.example.annaswool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {

    ImageView annasImage;
    TextView aboutAnna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        annasImage = findViewById(R.id.imgAnnasimage);
        aboutAnna = findViewById(R.id.tvAnnasImg);

        aboutAnna.setText("Anna is my sister i love anna!");
    }
}
