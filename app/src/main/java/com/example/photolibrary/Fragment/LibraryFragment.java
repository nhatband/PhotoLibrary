package com.example.photolibrary.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.photolibrary.R;

public class LibraryFragment extends Fragment {
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        imageView = view.findViewById(R.id.mimageView);
        Bitmap bitmap = BitmapFactory.decodeFile(getActivity().getIntent().getStringExtra("image_path"));
        imageView.setImageBitmap(bitmap);
        return view;
    }

}
