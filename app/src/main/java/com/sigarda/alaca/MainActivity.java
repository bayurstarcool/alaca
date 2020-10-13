package com.sigarda.alaca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.balysv.materialripple.MaterialRippleLayout;

public class MainActivity extends AppCompatActivity {
    private MaterialRippleLayout bbi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bbi = findViewById(R.id.bbi);
        bbi.setOnClickListener(bbi->{
            Intent i = new Intent(this,BBIActivity.class);
            startActivity(i);
        });
    }
}