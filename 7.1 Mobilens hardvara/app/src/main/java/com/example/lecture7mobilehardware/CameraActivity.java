package com.example.lecture7mobilehardware;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class CameraActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> activityLauncher;

    private Button openCameraButton;
    private ImageView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_camera);

        activityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent cameraDataIntent = result.getData();
                        displayPhoto(cameraDataIntent);
                    }
                }
        );

        openCameraButton = findViewById(R.id.cameraOpenCameraButton);
        photoView = findViewById(R.id.cameraPhotoView);

        openCameraButton.setOnClickListener(v -> {
            this.openCamera();
        });
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activityLauncher.launch(cameraIntent);
    }

    private void displayPhoto(Intent cameraDataIntent) {
        Bitmap picture = (Bitmap)cameraDataIntent.getExtras().get("data");
        photoView.setImageBitmap(picture);
    }
}