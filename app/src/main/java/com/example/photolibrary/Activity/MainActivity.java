package com.example.photolibrary.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.photolibrary.Fragment.HelpFragment;
import com.example.photolibrary.Fragment.HomeFragment;
import com.example.photolibrary.Fragment.LibraryFragment;
import com.example.photolibrary.Fragment.SettingFragment;
import com.example.photolibrary.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    private static int REQUEST_IMAGE_CAPTURE = HomeFragment.IMAGE_REQUEST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.nav_container);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frm_Container, new HomeFragment()).commit();
    }
private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment selectfragment = null;
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    selectfragment = new HomeFragment();
                    break;
                case R.id.nav_library:
                    selectfragment = new LibraryFragment();
                    break;
                case R.id.nav_help:
                    selectfragment = new HelpFragment();
                    break;
                case R.id.nav_setting:
                    selectfragment = new SettingFragment();
                    break;
            }
        getSupportFragmentManager().beginTransaction().replace(R.id.frm_Container, selectfragment).commit();
        return true;
    }
};

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }


}
