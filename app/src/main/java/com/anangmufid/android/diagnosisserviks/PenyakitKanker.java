package com.anangmufid.android.diagnosisserviks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PenyakitKanker extends AppCompatActivity {
    Button pindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit_kanker);

        pindah = (Button) findViewById(R.id.buttonKembali);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PenyakitKanker.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
