package com.sigarda.alaca;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sigarda.alaca.utils.Tools;

public class BBIActivity extends AppCompatActivity {
    private Button btn_hitung;
    private EditText et_height,et_weight,et_name;
    private TextView hasil,hasil_txt,saran_txt;
    private float weight,height,rumus;
    private LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbi);
        initToolbar();
        btn_hitung = findViewById(R.id.btn_hitung);
        et_height = findViewById(R.id.height);
        et_weight = findViewById(R.id.weight);
        et_name = findViewById(R.id.name);
        hasil = findViewById(R.id.hasil);
        hasil_txt = findViewById(R.id.hasil_txt);
        saran_txt = findViewById(R.id.saran_txt);
        container = findViewById(R.id.container_lyt);
        btn_hitung.setOnClickListener(hitung->{
            hitung();
        });
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Berat Badan Ideal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this);
    }
    private int hitung(){
        try{
            height = Integer.parseInt(et_height.getText().toString()); // cm
        }catch (Exception e){
            Toast.makeText(this,"Tinggi badan harus diisi",Toast.LENGTH_SHORT).show();
            container.setVisibility(View.GONE);
            return 0;
        }
        try{
            weight = Integer.parseInt(et_weight.getText().toString()); // kg
        }catch (Exception e){
            Toast.makeText(this,"Berat badan harus diisi",Toast.LENGTH_SHORT).show();
            container.setVisibility(View.GONE);
            return 0;
        }
        rumus = weight / ((height/100) * (height/100));
        container.setVisibility(View.VISIBLE);
        String message = "";
        String saran = "";
        if((rumus>=17)&&(rumus<23)){
            message="Halo "+et_name.getText()+", berat badan Anda IDEAL";
            saran="Tetap pertahankan, jaga pola makan dan gaya hidup ya";
        }else if((rumus>=23)&&(rumus<27)){
            message="Halo "+et_name.getText()+", berat badan Anda Kegemukan";
            saran="Wahh, Anda perlu banyak olahraga nih, <br> jangan makan berlebihan ya";
        }else if(rumus>27){
            message="Halo "+et_name.getText()+", berat badan Anda Berlebihan";
            saran="Wahh, Anda perlu lebih banyak olahraga nih, <br>jangan makan berlebihan ya";
        }else{
            message="Halo "+et_name.getText()+", berat badan Anda Kurus";
            saran="Wahh, Anda perlu banyak makan dengan makanan yang bergizi";
        }
        hasil.setText(Html.fromHtml("Hasil perhitungan : <b>"+String.format("%.2f", rumus)+"</b>"));
        hasil_txt.setText(Html.fromHtml(message));
        saran_txt.setText(Html.fromHtml(saran));
        return 0;
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}