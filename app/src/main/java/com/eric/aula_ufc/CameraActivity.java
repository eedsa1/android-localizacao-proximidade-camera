package com.eric.aula_ufc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {

    private Button btnCamera;
    private ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        btnCamera = (Button)findViewById(R.id.btnCamera);
        imgPhoto = (ImageView) findViewById(R.id.imgPhoto);
    }

    public void abrirCamera(View v){
        Intent inCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(inCamera, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            Bitmap bitPhoto = (Bitmap)data.getExtras().get("data");
            imgPhoto.setImageBitmap(bitPhoto);
        }
    }
}
