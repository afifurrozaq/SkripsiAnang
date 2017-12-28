package com.anangmufid.android.diagnosisserviks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class hasilDiagnosis extends AppCompatActivity implements View.OnClickListener {

    TextView textPenyakit, textPenanganan, textPersentase;
    ImageView gambarPenyakitDiderita;
    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_diagnosis);
        getIntent().getExtras().getStringArrayList("Gejala");

        textPenyakit = (TextView) this.findViewById(R.id.hasilPenyakit);
        textPenanganan = (TextView) this.findViewById(R.id.hasilPenanganan);
        textPersentase = (TextView) this.findViewById(R.id.hasilPersentase);
        gambarPenyakitDiderita = (ImageView) this.findViewById(R.id.hasilGambar);
        done = (Button) this.findViewById(R.id.Selesai);
        textPenyakit.setText(getIntent().getExtras().getString("NamaPenyakit"));
        textPenanganan.setText(getIntent().getExtras().getString("Penanganan"));
        textPersentase.setText(getIntent().getExtras().getString("Presentase") + " %");

        if (getIntent().getExtras().getString("NamaPenyakit").equalsIgnoreCase("Kanker Vagina")) {
            gambarPenyakitDiderita.setImageResource(R.drawable.vagina);
        } else if (getIntent().getExtras().getString("NamaPenyakit").equalsIgnoreCase("Kanker Ovarium")) {
            gambarPenyakitDiderita.setImageResource(R.drawable.ovarium);
        } else if (getIntent().getExtras().getString("NamaPenyakit").equalsIgnoreCase("Kanker Endometrium")) {
            gambarPenyakitDiderita.setImageResource(R.drawable.endometrium);
        } else if (getIntent().getExtras().getString("NamaPenyakit").equalsIgnoreCase("Kanker Serviks")) {
            gambarPenyakitDiderita.setImageResource(R.drawable.serviks);
        } else if (getIntent().getExtras().getString("Nama enyakit").equalsIgnoreCase("Kista")) {
            gambarPenyakitDiderita.setImageResource(R.drawable.kista);
        } else if (getIntent().getExtras().getString("NamaPenyakit").equalsIgnoreCase("Miom")) {
            gambarPenyakitDiderita.setImageResource(R.drawable.miom);
        }

        done.setOnClickListener(this);
    }

    public void onClick(View view) {
        int button = view.getId();

        if (button == R.id.Selesai) {
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }

    }
}
