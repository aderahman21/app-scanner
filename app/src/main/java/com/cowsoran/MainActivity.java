package com.cowsoran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btn_generator, btn_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_generator = findViewById(R.id.generate);

        btn_scan = findViewById(R.id.scan);

        btn_generator.setOnClickListener(V -> {
            Intent generator = new Intent(MainActivity.this, GenerateActivity.class);
            startActivity(generator);
            finish();
        });

        btn_scan.setOnClickListener(V -> {
            Intent scan = new Intent(MainActivity.this, ScanActivity.class);
            startActivity(scan);
            finish();
        });

    }
}