package com.example.photolibrary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.photolibrary.Adapter.PhotoGridViewAdapter;
import com.example.photolibrary.Fragment.HomeFragment;
import com.example.photolibrary.R;

import java.io.File;

public class LibraryActivity extends AppCompatActivity {
    PhotoGridViewAdapter photoGridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        GridView gridView = findViewById(R.id.grv_images);
        photoGridViewAdapter = new PhotoGridViewAdapter(this);
        gridView.setAdapter(photoGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String path = (String) photoGridViewAdapter.getItem(i);
                Intent mInDisplay = new Intent(LibraryActivity.this, DisplayActivity.class);
                mInDisplay.putExtra("Index", path);
                LibraryActivity.this.finish();
                startActivity(mInDisplay);
            }
        });
        photoGridViewAdapter.notifyDataSetChanged();
//        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String ExternalStorageDirectoryPath = Environment
//                        .getExternalStorageDirectory()
//                        .getAbsolutePath();
//                String targetPath = ExternalStorageDirectoryPath + "/Android/data/com.example.photolibrary/files/Pictures/";
//
//                File targetDirector = new File(targetPath);
//                File[] files = targetDirector.listFiles();
//                File file = files[i].getAbsoluteFile();
//                file.delete();
//                photoGridViewAdapter.notifyDataSetChanged();
//
//                return false;
//            }
//        });
        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();

        String targetPath = ExternalStorageDirectoryPath + "/Android/data/com.example.photolibrary/files/Pictures/";
//        Toast.makeText(this, targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);

//        Toast.makeText(getApplicationContext(), targetDirector.getAbsolutePath(), Toast.LENGTH_LONG).show();
        Log.d("target_dir", targetDirector.getPath());

        File[] files = targetDirector.listFiles();
//        Toast.makeText(getApplicationContext(), Integer.toString(files.length),Toast.LENGTH_LONG).show();
        for (File file : files) {
            photoGridViewAdapter.add(file.getAbsolutePath());
        }
    }

    public void back_home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        LibraryActivity.this.finish();
        startActivity(intent);
    }
}