package com.sigarda.alaca.ruang;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sigarda.alaca.R;
import com.sigarda.alaca.utils.Tools;

public class BalokActivity extends AppCompatActivity {
    private EditText panjang_et,lebar_et,tinggi_et;
    private int panjang,lebar,tinggi;
    private TextView volume,luas;
    private Button hitung;
    private LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balok);
        panjang_et = findViewById(R.id.panjang);
        lebar_et = findViewById(R.id.lebar);
        tinggi_et = findViewById(R.id.tinggi);
        hitung = findViewById(R.id.btn_hitung);
        volume = findViewById(R.id.volume);
        luas = findViewById(R.id.luas);
        container = findViewById(R.id.container_lyt);
        hitung.setOnClickListener(hitung->{
            hitung();
        });
        initToolbar();
    }
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hitung Segitiga");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this);
    }
    private int hitung(){
        try {
            panjang = Integer.parseInt(panjang_et.getText().toString());
        }catch (Exception e){
            Toast.makeText(this,"Nilai panjang tidak boleh kosong",Toast.LENGTH_SHORT).show();
            container.setVisibility(View.GONE);
            return 0;
        }
        try {
            lebar = Integer.parseInt(lebar_et.getText().toString());
        }catch (Exception e){
            Toast.makeText(this,"Nilai lebar tidak boleh kosong",Toast.LENGTH_SHORT).show();
            container.setVisibility(View.GONE);
            return 0;
        }
        try {
            tinggi = Integer.parseInt(tinggi_et.getText().toString());
        }catch (Exception e){
            Toast.makeText(this,"Nilai tinggi tidak boleh kosong",Toast.LENGTH_SHORT).show();
            container.setVisibility(View.GONE);
            return 0;
        }
        container.setVisibility(View.VISIBLE);
        double v = (panjang*lebar*tinggi);
        double l =  (panjang+lebar+tinggi);
        luas.setText(Html.fromHtml("<b>"+l+" cm³</b>"));
        volume.setText(Html.fromHtml("<b>"+v+" cm³</b>"));
        return 0;
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}