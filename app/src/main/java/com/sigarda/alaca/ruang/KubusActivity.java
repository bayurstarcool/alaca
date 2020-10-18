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

public class KubusActivity extends AppCompatActivity {
    private EditText rusuk_et;
    private int rusuk;
    private TextView volume,luas;
    private Button hitung;
    private LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus);
        rusuk_et = findViewById(R.id.rusuk);
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
        getSupportActionBar().setTitle("Hitung Kubus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this);
    }
    private int hitung(){
        try {
            rusuk = Integer.parseInt(rusuk_et.getText().toString());
        }catch (Exception e){
            Toast.makeText(this,"Nilai rusuk tidak boleh kosong",Toast.LENGTH_SHORT).show();
            container.setVisibility(View.GONE);
            return 0;
        }
        container.setVisibility(View.VISIBLE);
        double v = (rusuk*rusuk*rusuk);
        double l =  (6*rusuk*rusuk);
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