package com.sigarda.alaca;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.balysv.materialripple.MaterialRippleLayout;
import com.sigarda.alaca.datar.PersegiActivity;
import com.sigarda.alaca.datar.PersegiPanjangActivity;
import com.sigarda.alaca.datar.SegitigaActivity;
import com.sigarda.alaca.ruang.BalokActivity;
import com.sigarda.alaca.ruang.BolaActivity;
import com.sigarda.alaca.ruang.KubusActivity;
import com.sigarda.alaca.utils.Tools;

public class DatarActivity extends AppCompatActivity {
    private MaterialRippleLayout segitiga,persegi,persegi_panjang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datar);
        segitiga = findViewById(R.id.segitiga);
        persegi = findViewById(R.id.persegi);
        persegi_panjang = findViewById(R.id.persegi_panjang);
        segitiga.setOnClickListener(bola->{
            Intent i = new Intent(this, SegitigaActivity.class);
            startActivity(i);
        });
        persegi.setOnClickListener(balok->{
            Intent i = new Intent(this, PersegiActivity.class);
            startActivity(i);
        });
        persegi_panjang.setOnClickListener(balok->{
            Intent i = new Intent(this, PersegiPanjangActivity.class);
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