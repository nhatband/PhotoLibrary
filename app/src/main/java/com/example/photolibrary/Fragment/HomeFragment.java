package com.example.photolibrary.Fragment;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.photolibrary.Activity.CameraResultActivity;
import com.example.photolibrary.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {
    String currentImagePath;
    public static final int IMAGE_REQUEST = 1;
    ImageButton imgShot, imgLibrary;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        imgLibrary = view.findViewById(R.id.imgLibrary);
        imgShot = view.findViewById(R.id.imgShot);
        imgShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
        imgLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LibraryFragment.class);
                intent.putExtra("image_path", currentImagePath);
                startActivity(intent);
            }
        });
        return view;
    }

//    private void dispatchTakePictureIntent() {
//        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        Log.d("log_package_manager", getActivity().getPackageManager().toString());
////        Log.d("test_photo:", cameraIntent.resolveActivity(getActivity().getPackageManager()).toString());
//        if (cameraIntent.resolveActivity(this.getActivity().getPackageManager())!=null) {
//
//            File imageFile = null;
//            try {
//                imageFile = getImageFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (imageFile != null) {
//                Uri imageUri = FileProvider.getUriForFile(getContext(), "com.example.android.fileprovider", imageFile);
//                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
//                getActivity().startActivityForResult(cameraIntent, IMAGE_REQUEST);
//            }
//        }
//    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, IMAGE_REQUEST);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    private File getImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageName = "jpg_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imageFile = File.createTempFile(imageName, ".jpg", storageDir);
        currentImagePath = imageFile.getAbsolutePath();
        return imageFile;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("on_activity_result", "is called");
        if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK) {
            Log.d("request_code", "is_correct");
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Intent intent = new Intent(this.getActivity(), CameraResultActivity.class);
            intent.putExtra("photo_result_bitmap", imageBitmap);
            startActivity(intent);

//            imageView.setImageBitmap(imageBitmap);
        }
    }

}
