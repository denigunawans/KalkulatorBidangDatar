package com.example.kalkulatorbidangdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtPanjang, edtLebar, edtAlas, edtTinggi, edtDiameter;
    TextView txtRLuas, txtRKeliling, txtLuas, txtKeliling;

    // set format 2 angka di belakang ,
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    private void initComponent(){
        edtAlas = findViewById(R.id.edtAlas);
        edtPanjang = findViewById(R.id.edtPanjang);
        edtLebar = findViewById(R.id.edtLebar);
        edtTinggi = findViewById(R.id.edtTinggi);
        edtDiameter = findViewById(R.id.edtDiameter);
        txtLuas = findViewById(R.id.txtLuas);
        txtKeliling = findViewById(R.id.txtKeliling);
        txtRLuas = findViewById(R.id.txtRumusLuas);
        txtRKeliling = findViewById(R.id.txtRumusKeliling);
    }

    public void hitungPersegi(View view){
        try {
            txtRLuas.setText(getString(R.string.rumus_L_persegi));
            txtRKeliling.setText(getString(R.string.rumus_K_persegi));

            double s = Double.parseDouble(edtPanjang.getText().toString());

            double luas = s * s;
            double keliling = s + s + s + s;

            txtLuas.setText("luas persegi : "+df.format(luas));
            txtKeliling.setText("keliling persegi : " + df.format(keliling));
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "masukan nilai dengan benar", Toast.LENGTH_SHORT).show();
        }
    }

    public void hitungLingkaran(View view){
        try {
            txtRLuas.setText(getString(R.string.rumus_L_lingkaran));
            txtRKeliling.setText(getString(R.string.rumus_K_lingkaran));

            double r = Double.parseDouble(edtDiameter.getText().toString())/2d;
            double phi = 22d/7d;

            double luas = phi * r * r;
            double keliling = phi * 2 * r;


            txtLuas.setText("luas lingkaran : "+df.format(luas));
            // set format 2 angka di belakang ,
            txtKeliling.setText("keliling lingkaran : " + df.format(keliling));
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "masukan nilai dengan benar", Toast.LENGTH_SHORT).show();
        }
    }

    public void hitungSegitiga(View view){
        try {
            txtRLuas.setText(getString(R.string.rumus_L_segitiga));
            txtRKeliling.setText(getString(R.string.rumus_K_segitiga));

            double a = Double.parseDouble(edtAlas.getText().toString());
            double t = Double.parseDouble(edtTinggi.getText().toString());
            double s = Double.parseDouble(edtPanjang.getText().toString());

            double luas = 0.5 * a * t;
            double keliling = s + s + s;

            txtLuas.setText("luas segitiga : "+df.format(luas));
            txtKeliling.setText("keliling segitiga sama sisi : " + df.format(keliling));
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "masukan nilai dengan benar", Toast.LENGTH_SHORT).show();
        }

    }
}