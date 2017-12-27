package com.anangmufid.android.diagnosisserviks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDiagnosis;
    private Button btnInformasi;
    private Button btnPetunjuk;
    private Button btnKeluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDiagnosis = (Button) this.findViewById(R.id.buttonDiagnosis);
        btnInformasi = (Button) this.findViewById(R.id.buttonPenyakitKanker);
        btnPetunjuk = (Button) this.findViewById(R.id.buttonInfo);
        btnKeluar = (Button) this.findViewById(R.id.buttonExit);

        btnDiagnosis.setOnClickListener(this);
        btnInformasi.setOnClickListener(this);
        btnPetunjuk.setOnClickListener(this);
        btnKeluar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int button = view.getId();

        if (button == R.id.buttonDiagnosis) {
            Intent myIntent = new Intent(getApplicationContext(), Diagnosis.class);
            startActivity(myIntent);
        } else if (button == R.id.buttonPenyakitKanker) {
            Intent myIntent = new Intent(getApplicationContext(), PenyakitKanker.class);
            startActivity(myIntent);
        } else if (button == R.id.buttonInfo) {
            Intent myIntent = new Intent(getApplicationContext(), petunjuk.class);
            startActivity(myIntent);
        } else if (button == R.id.buttonExit) {
            finish();
            System.exit(0);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
