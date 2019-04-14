package com.example.annaswool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AboutUsActivity extends AppCompatActivity {

    ImageView annasImage;
    TextView aboutAnna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        annasImage = findViewById(R.id.imgAnnasimage);
        aboutAnna = findViewById(R.id.tvAnnasImg);
        String image = "https://i.pinimg.com/originals/cb/90/62/cb90623a5a7a182fedfff6eecc57efe8.jpg";
        Glide.with(this).asBitmap().load(image).into(annasImage);
        aboutAnna.setText("Hello, my name is Anna and knitting is my passion. When I was younger my mother taught me how to knit, but only recently as i started to expecting a baby I" +
                " started to create a baby clothes and accessories. I hope you all enjoy my product." );



    }
}
