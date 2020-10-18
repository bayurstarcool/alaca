package com.sigarda.alaca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private MaterialRippleLayout bbi,suhu,ruang,datar,exam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bbi = findViewById(R.id.bbi);
        suhu = findViewById(R.id.suhu);
        ruang = findViewById(R.id.ruang);
        datar = findViewById(R.id.datar);
        exam = findViewById(R.id.exam);
        bbi.setOnClickListener(bbi->{
            Intent i = new Intent(this,BBIActivity.class);
            startActivity(i);
        });
        exam.setOnClickListener(bbi->{
            Intent i = new Intent(this,ExamActivity.class);
            startActivity(i);
        });
        ruang.setOnClickListener(bbi->{
            Intent i = new Intent(this,RuangActivity.class);
            startActivity(i);
        });
        datar.setOnClickListener(bbi->{
            Intent i = new Intent(this,DatarActivity.class);
            startActivity(i);
        });
        suhu.setOnClickListener(suhu->{
            Intent i = new Intent(this,TemperaturesActivity.class);
            startActivity(i);
        });
    }
}