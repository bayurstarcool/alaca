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

public class BolaActivity extends AppCompatActivity {
    private EditText jari;
    private TextView volume,lp;
    private Button hitung;
    private LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bola);
        jari = findViewById(R.id.jari);
        hitung = findViewById(R.id.btn_hitung);
        volume = findViewById(R.id.volume);
        lp = findViewById(R.id.luas_permukaan);
        container = findViewById(R.id.container_lyt);
        hitung.setOnClickListener(hitung->{
            hitung();
        });
        initToolbar();
    }
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hitung Bola");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this);
    }
    private int hitung(){
        try {
            int r = Integer.parseInt(jari.getText().toString());
            container.setVisibility(View.VISIBLE);
            double v = 1.3333 * 3.14 * r * r * r;
            double l =  4 * 3.14 * r * r;
            lp.setText(Html.fromHtml("<b>"+l+" cm³</b>"));
            volume.setText(Html.fromHtml("<b>"+v+" cm³</b>"));
        }catch (Exception e){
            Toast.makeText(this,"Nilai jari-jari tidak boleh kosong",Toast.LENGTH_SHORT).show();
            container.setVisibility(View.GONE);
        }
     return 0;
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}