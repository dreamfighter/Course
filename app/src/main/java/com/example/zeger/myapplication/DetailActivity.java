package com.example.zeger.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DetailActivity extends AppCompatActivity {
    ImageView previewImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        if (getIntent() != null) {
            Bundle messageData = getIntent().getExtras();

            Toast.makeText(this, messageData.getString("message"), Toast.LENGTH_LONG).show();
        }

        Button exitButton = (Button) findViewById(R.id.back_button);
        Button shareButton = (Button) findViewById(R.id.share_button);
        Button cameraButton = (Button) findViewById(R.id.camera_button);

        //previewImageview = (ImageView) findViewById(R.id.preview_imageview);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();

                Bundle resultData = new Bundle();

                resultData.putString("resultMsg", "ini adalah result");
                resultData.putInt("resultInt",1);
                resultIntent.putExtras(resultData);

                setResult(100,resultIntent);
                finish();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                // Create the text message with a string
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "ini message yang akan kita share ke applikasi lagi");
                sendIntent.setType("text/plain");

                // Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
                */
                String uri = "geo:-6.971015,107.630574?q=-6.971015,107.630574";
                startActivity(new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(uri)));
            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent();
                cameraIntent.setAction(
                        android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cameraIntent, 1);
            }
        });
    }

    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            previewImageview.setImageBitmap(photo);

            try {
                photo.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(Environment.getExternalStorageDirectory() + "/NameOfFile.jpg"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }*/
}