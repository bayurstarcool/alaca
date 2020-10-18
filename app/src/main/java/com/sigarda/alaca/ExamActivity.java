package com.sigarda.alaca;

import android.annotation.SuppressLint;
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

import com.sigarda.alaca.utils.Tools;

public class ExamActivity extends AppCompatActivity {
    EditText presence,avg_Task,mid_exam,final__exam;
    TextView txtResult;
    private LinearLayout container;
    private Button hitung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        initToolbar();
        Initialize();
    }

    private void Initialize(){
        presence = findViewById(R.id.absen);
        avg_Task = findViewById(R.id.tugas);
        mid_exam = findViewById(R.id.uts);
        final__exam = findViewById(R.id.uas);
        txtResult = findViewById(R.id.hasil);
        hitung = findViewById(R.id.btn_hitung);
        container = findViewById(R.id.container_lyt);
        hitung.setOnClickListener(hitung->{
            Calculate();
        });
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void Calculate() {
        try {
            double valuePresence = Double.parseDouble(presence.getText().toString());
            double valueAvgTask = Double.parseDouble(avg_Task.getText().toString());
            double valueMidExam = Double.parseDouble(mid_exam.getText().toString());
            double valueFinalExam = Double.parseDouble(final__exam.getText().toString());
            double valueResult = (((valueAvgTask*0.2) + (valueFinalExam*0.3)+(valueMidExam*0.3)+(valuePresence*0.2)) / 25);

            if (isValidValue(valuePresence, "Absen") && isValidValue (valueAvgTask, "Tugas") && isValidValue(valueFinalExam, "UAS") && isValidValue(valueMidExam,"UTS")) {
                txtResult.setText(Html.fromHtml("Nilai Akhir : "+String.format("%.2f", valueResult) + " / " + convert(valueResult)));
            }
            container.setVisibility(View.VISIBLE);
        }catch (Exception e){
            alert("Pastikan nilai sudah terisi semua");
            container.setVisibility(View.GONE);
        }
    }

    private String convert(double valueResult) {

        String hasil = "";

        if (valueResult <= 4 && valueResult > 3.66){
            hasil = "A";
        } else if (valueResult <= 3.66 && valueResult> 3.33){
            hasil = "A-" ;
        } else if (valueResult <= 3.33 && valueResult > 3){
            hasil = "B+" ;
        } else if (valueResult <= 3 && valueResult > 2.66){
            hasil = "B" ;
        } else if (valueResult <= 2.66 && valueResult > 2.33){
            hasil = "B-" ;
        } else if (valueResult <= 2.33 && valueResult > 2){
            hasil = "C+" ;
        } else if (valueResult <= 2 && valueResult > 1.66){
            hasil = "C" ;
        } else if (valueResult <= 1.66 && valueResult > 0){
            hasil = "D" ;
        } else if (valueResult <= 0){
            hasil = "E" ;
        }

        return hasil ;

    }


    private boolean isValidValue(double val, String teks) {
        if (val <= 100){
            return true ;
        } else {
            alert(teks + " tidak boleh lebih dari 100");
            return false ;
        }
    }

    private void alert(String alert_message) {
        Toast.makeText(this,alert_message, Toast.LENGTH_SHORT).show();
    }
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hitung Segitiga");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
