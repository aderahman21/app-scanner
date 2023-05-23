package com.cowsoran;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class ScanActivity extends AppCompatActivity {

    private Button btnScan;
    private ImageView ivback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        btnScan = findViewById(R.id.btn_scan);

        ivback = findViewById(R.id.ivBack2);

        ivback.setOnClickListener(V -> {
            Intent back = new Intent(ScanActivity.this, MainActivity.class);
            startActivity(back);
            finish();
        });

        btnScan.setOnClickListener(V -> {
        scan();
        });
    }

    public void scan() {
        ScanOptions scanOptions = new ScanOptions();
        scanOptions.setPrompt("Volume Up To Flash On");
        scanOptions.setBeepEnabled(true);
        scanOptions.setOrientationLocked(true);
        scanOptions.setCaptureActivity(Scan.class);
        louncer.launch(scanOptions);
    }

    ActivityResultLauncher<ScanOptions> louncer = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ScanActivity.this);
            builder.setTitle("QR Result");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("oke",(dialogInterface, i) -> dialogInterface.dismiss()).show();
        }
    });
}