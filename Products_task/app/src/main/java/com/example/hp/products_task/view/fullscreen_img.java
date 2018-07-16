package com.example.hp.products_task.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.hp.products_task.R;
import com.squareup.picasso.Picasso;

public class fullscreen_img extends AppCompatActivity {
ImageView imageView;
Intent intent;
String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fullscreen_img);
        imageView=(ImageView)findViewById(R.id.img);
        intent=getIntent();
        url=intent.getStringExtra("url");
        Picasso.with(this).load(url).into(imageView);
    }
}
