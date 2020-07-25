package com.example.restaurant;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Setting extends AppCompatActivity {


    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        Button btncamera = (Button) findViewById(R.id.camerapress);
        imageView = (ImageView) findViewById(R.id.userprofilepic);

        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        Bitmap bitmap =(Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

    public void confirm(View view) {
        Intent intent = new Intent(Setting.this, Category.class);
        startActivity(intent);
    }
}
