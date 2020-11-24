package com.example.photolibrary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
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

    public void back(View view) {
        Intent intent = new Intent(this, LibraryActivity.class);
        DisplayActivity.this.finish();
        startActivity(intent);

    }

    public void delete(View view) {
        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();
        String targetPath = ExternalStorageDirectoryPath + "/Android/data/com.example.photolibrary/files/Pictures/";
        File targetDirector = new File(targetPath);
        File[] files = targetDirector.listFiles();
        int i = 0;
        File file = files[i].getAbsoluteFile();
        file.delete();
        Intent intent = new Intent(this, LibraryActivity.class);
        DisplayActivity.this.finish();
        startActivity(intent);
    }
}