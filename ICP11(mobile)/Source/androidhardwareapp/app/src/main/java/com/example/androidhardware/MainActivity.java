package com.example.androidhardware;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Intent redirect = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LocationDetail(View view) {
        redirect = new Intent(MainActivity.this,LocationActivity.class);
        startActivity(redirect);
    }

    public void takePic(View view) {
        redirect = new Intent(MainActivity.this,CameraActivity.class);
        startActivity(redirect);
    }

    public void record(View view) {
        redirect = new Intent(MainActivity.this,RecordingActivity.class);
        startActivity(redirect);
    }

    public void save(View view) {
        redirect = new Intent(MainActivity.this,StorageActivity.class);
        startActivity(redirect);
    }
}
