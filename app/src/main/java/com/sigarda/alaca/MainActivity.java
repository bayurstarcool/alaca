package com.sigarda.alaca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.balysv.materialripple.MaterialRippleLayout;

public class MainActivity extends AppCompatActivity {
    private MaterialRippleLayout bbi,suhu,ruang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bbi = findViewById(R.id.bbi);
        suhu = findViewById(R.id.suhu);
        ruang = findViewById(R.id.ruang);
        bbi.setOnClickListener(bbi->{
            Intent i = new Intent(this,BBIActivity.class);
            startActivity(i);
        });
        ruang.setOnClickListener(bbi->{
            Intent i = new Intent(this,RuangActivity.class);
            startActivity(i);
        });
        suhu.setOnClickListener(suhu->{
            Intent i = new Intent(this,TemperaturesActivity.class);
            startActivity(i);
        });
    }
}