package com.sigarda.alaca.datar;

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

public class SegitigaActivity extends AppCompatActivity {
    private EditText alas_et,tinggi_et;
    private int alas,sisi,tinggi;
    private TextView luas;
    private Button hitung;
    private LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        alas_et = findViewById(R.id.alas);
        tinggi_et = findViewById(R.id.tinggi);
        hitung = findViewById(R.id.btn_hitung);
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
            alas = Integer.parseInt(alas_et.getText().toString());
        }catch (Exception e){
            Toast.makeText(this,"Nilai alas tidak boleh kosong",Toast.LENGTH_SHORT).show();
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
        double l =  0.5*alas*tinggi;
        luas.setText(Html.fromHtml("<b>"+l+" cm²</b>"));
        return 0;
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}