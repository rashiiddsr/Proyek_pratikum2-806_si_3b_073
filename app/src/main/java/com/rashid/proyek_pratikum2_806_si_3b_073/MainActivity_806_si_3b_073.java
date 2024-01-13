package com.rashid.proyek_pratikum2_806_si_3b_073;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_806_si_3b_073 extends AppCompatActivity {
    EditText etKategori, etPenghasilan;
    int penghasilan, gajiBersih;
    double pajak;
    Button btProses, btBersih, btKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_806_si_3b_073);
        etKategori = findViewById(R.id.etKategori);
        etPenghasilan = findViewById(R.id.etPenghasilan);
        btProses = findViewById(R.id.btProses);
        btBersih = findViewById(R.id.btBersih);
        btKeluar = findViewById(R.id.btKeluar);

        btProses.setOnClickListener(v -> {
            if (etKategori.getText().toString().isEmpty() || etPenghasilan.getText().toString().isEmpty() || etKategori.getText().toString().isEmpty() && etPenghasilan.getText().toString().isEmpty()) {
                Toast.makeText(this, "Objek parameter masukan dibutuhkan", Toast.LENGTH_SHORT).show();
                return;
            }

            penghasilan = Integer.parseInt(etPenghasilan.getText().toString());
            switch (etKategori.getText().toString().toLowerCase()) {
                case "pekerja":
                    if (penghasilan <= 2500000) {
                        pajak = 0.15;
                    } else if (penghasilan <= 3500000) {
                        pajak = 0.2;
                    } else {
                        pajak = 0.25;
                    }
                    gajiBersih = (int) (penghasilan - (penghasilan * pajak));
                    new AlertDialog.Builder(this)
                            .setTitle("Hasil Proses")
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("Gaji bersih anda adalah " + gajiBersih)
                            .setPositiveButton("Ok", null).
                            setNegativeButton("Rincian", (dialog, which) -> new AlertDialog.Builder(MainActivity_806_si_3b_073.this)
                                .setTitle("Rincian Proses")
                                .setIcon(R.mipmap.ic_launcher)
                                .setMessage("Penghasilan Kotor : " + penghasilan + "\nPajak diterima : " + pajak + "  (" + pajak * 100 + "%)" + "\nGaji Bersih : " + gajiBersih)
                                .setNeutralButton("Ok", null)
                                .create()
                                .show())
                            .create()
                            .show();
                    break;
                case "pebisnis":
                    if (penghasilan <= 2000000) {
                        pajak = 0.1;
                    } else if (penghasilan <= 3000000) {
                        pajak = 0.15;
                    } else {
                        pajak = 0.2;
                    }
                    gajiBersih = (int) (penghasilan - (penghasilan * pajak));
                    new AlertDialog.Builder(this)
                            .setTitle("Hasil Proses")
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("Gaji bersih anda adalah " + gajiBersih)
                            .setPositiveButton("Ok", null).
                            setNegativeButton("Rincian", (dialog, which) -> new AlertDialog.Builder(MainActivity_806_si_3b_073.this)
                                    .setTitle("Rincian Proses")
                                    .setIcon(R.mipmap.ic_launcher)
                                    .setMessage("Penghasilan Kotor : " + penghasilan + "\nPajak diterima : " + pajak + "  (" + pajak * 100 + "%)" + "\nGaji Bersih : " + gajiBersih)
                                    .setNeutralButton("Ok", null)
                                    .create()
                                    .show())
                            .create()
                            .show();
                    break;
                default:
                    new AlertDialog.Builder(this)
                            .setTitle("Peringatan")
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("Kategori yang anda masukkan tidak valid, kategori yang tersedia :" + "\n\npekerja\npebisnis")
                            .setNegativeButton("Kembali", null)
                            .create()
                            .show();
            }
        });

        btKeluar.setOnClickListener(v -> finish());

        btBersih.setOnClickListener(v -> {
            if (etKategori.getText().toString().isEmpty() && etPenghasilan.getText().toString().isEmpty()) {
                Toast.makeText(this, "Sudah Bersih Sebelumnya!!!", Toast.LENGTH_SHORT).show();
                return;
            }
            etKategori.setText(null);
            etPenghasilan.setText(null);
        });
    }
}