package com.cowsoran;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class GenerateActivity extends AppCompatActivity {

    private ImageView ivBack, ivResult;
    private Button btnGenerate;
    private EditText edtInput;
    private MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);

        edtInput = findViewById(R.id.edtInput);

        btnGenerate = findViewById(R.id.btnGenerate2);

        ivResult = findViewById(R.id.iv_result);

        ivBack = findViewById(R.id.tvBack);
        ivBack.setOnClickListener(V -> {
            Intent back  = new Intent(GenerateActivity.this, MainActivity.class);
            startActivity(back);
            finish();
        });

        btnGenerate.setOnClickListener(V -> create());


    }

    public void create() {
        try {
            String input = edtInput.getText().toString();
            if (input != null) {
                BitMatrix bitMatrix = multiFormatWriter.encode(input, BarcodeFormat.QR_CODE, 300, 300);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                ivResult.setImageBitmap(bitmap);
            } else {
                Toast.makeText(this, "Harap Masukan Sesuatu", Toast.LENGTH_SHORT).show();
            }
        } catch (WriterException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}