package com.example.photolibrary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.photolibrary.Adapter.PhotoGridViewAdapter;
import com.example.photolibrary.R;

import java.io.File;
import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String path = getIntent().getStringExtra("Index");
        ImageView mimageview = findViewById(R.id.mImgView1);
        mimageview.setImageURI(Uri.parse(path));
    }
}