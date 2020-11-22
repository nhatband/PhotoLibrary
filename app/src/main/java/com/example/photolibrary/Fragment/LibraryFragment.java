package com.example.photolibrary.Fragment;

import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.photolibrary.Adapter.PhotoGridViewAdapter;
import com.example.photolibrary.R;

import java.io.File;

public class LibraryFragment extends Fragment {
    ImageView imageView;
    PhotoGridViewAdapter photoGridViewAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        GridView gridView = view.findViewById(R.id.grv_images);
        photoGridViewAdapter = new PhotoGridViewAdapter(this.getActivity());
        gridView.setAdapter(photoGridViewAdapter);
        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();

        String targetPath = ExternalStorageDirectoryPath + "/files/Pictures";

        Toast.makeText(getContext(), targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);

        File[] files = targetDirector.listFiles();
        for (File file : files) {
            photoGridViewAdapter.add(file.getAbsolutePath());


        }
        return view;
    }
}
