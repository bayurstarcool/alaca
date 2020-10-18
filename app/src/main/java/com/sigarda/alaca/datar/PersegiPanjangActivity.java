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

public class PersegiPanjangActivity extends AppCompatActivity {
    private EditText panjang_et,lebar_et;
    private int panjang,lebar;
    private TextView luas,keliling;
    private Button hitung;
    private LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegipanjang);
        panjang_et = findViewById(R.id.panjang);
        lebar_et = findViewById(R.id.lebar);
        hitung = findViewById(R.id.btn_hitung);
        luas = findViewById(R.id.luas);
        keliling = findViewById(R.id.keliling);
        container = findViewById(R.id.container_lyt);
        hitung.setOnClickListener(hitung->{
            hitung();
        });
        initToolbar();
    }
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hitung Persegi Panjang");
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
        container.setVisibility(View.VISIBLE);
        double l =  panjang*lebar;
        double k =  2*(panjang+lebar);
        luas.setText(Html.fromHtml("<b>"+l+" cm²</b>"));
        keliling.setText(Html.fromHtml("<b>"+k+" cm²</b>"));
        return 0;
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}