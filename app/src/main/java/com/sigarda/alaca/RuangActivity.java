package com.sigarda.alaca;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.balysv.materialripple.MaterialRippleLayout;
import com.sigarda.alaca.ruang.BalokActivity;
import com.sigarda.alaca.ruang.BolaActivity;
import com.sigarda.alaca.ruang.KubusActivity;
import com.sigarda.alaca.utils.Tools;

public class RuangActivity extends AppCompatActivity {
    private MaterialRippleLayout bola,kubus,balok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruang);
        bola = findViewById(R.id.bola);
        kubus = findViewById(R.id.kubus);
        balok = findViewById(R.id.balok);
        bola.setOnClickListener(bola->{
            Intent i = new Intent(this, BolaActivity.class);
            startActivity(i);
        });
        balok.setOnClickListener(balok->{
            Intent i = new Intent(this, BalokActivity.class);
            startActivity(i);
        });
        kubus.setOnClickListener(balok->{
            Intent i = new Intent(this, KubusActivity.class);
            startActivity(i);
        });
        initToolbar();
    }
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bangun Ruang");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}