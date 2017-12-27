package com.anangmufid.android.diagnosisserviks;

import android.content.Intent;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class Diagnosis extends AppCompatActivity implements View.OnClickListener {
   public String gejala[][] = {{"1", "Keluar darah sedikit-sedikit dari vagina"},
            {"2", "Nyeri pada perut bagian bawah"},
            {"3", "Keluar flek dari vagina"},
            {"4", "Pusing"},
            {"5", "Keluar darah menggumpal dari vagina"},
            {"6", "Perut terasa mual"},
            {"7", "Muntah tiap kali makan"},
            {"8", "Nyeri perut menyeluruh"},
            {"9", "Nafsu makan menghilang"},
            {"10", "Kembung terus menerus"},
            {"11", "Pucat"},
            {"12", "Terasa sesak"},
            {"13", "Meriang"},
            {"14", "Berat badan menurun"},
            {"15", "Nyeri selama menstruasi"},
            {"16", "Muncul benjolan diperut"},
            {"17", "Nyeri pada saat buang air kecil"},
            {"18", "Sakit pada panggul"},
            {"19", "Merasa kelelahan terus menerus"},
            {"20", "Sering buang air kecil"},
            {"21", "Nyeri saat buang air besar"},
            {"22", "Nyeri pada payudara"},
            {"23", "Muncul benjolan pada vagina"},
            {"24", "Sakit pada saat berhubungan seksual"}};

    public String penyakit[][] = {{"1", "Kanker Vagina", "Operasi Pengangkatan"},
            {"2", "Kanker Ovarium", "Operasi Pengangkatan"},
            {"3", "Kanker Endometrium", "Operasi Pengangkatan"},
            {"4", "Kanker Serviks", "Operasi Pengangkatan"},
            {"5", "Kista", "Pemantauan ruting dengan USG, Mengkonsumsi pil KB"},
            {"6", "Miom", "Operasi Pengangkatan"}};

    public double bobotGejalaCF[][] = {{0.7, 0.8, 0, 0.4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.9, 0},
            {0.8, 0, 0, 0.4, 0, 0.5, 0.6, 0.6, 0.7, 0.6, 0, 0, 0, 0.8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0.7, 0, 0, 0.4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.9, 0.7, 0.6, 0, 0, 0, 0, 0.8},
            {0.9, 0.8, 0.8, 0.4, 0.7, 0.5, 0, 0, 0, 0, 0.4, 0.4, 0.4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0.5, 0, 0.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.7, 0.7, 0.8, 0.9, 0, 0},
            {0, 0, 0, 0.6, 0, 0.5, 0, 0, 0, 0, 0, 0, 0.4, 0, 0.9, 0.9, 0, 0, 0, 0, 0, 0, 0, 0}};

    public String dataLatih[][] = {{"1", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Serviks"},
            {"1", "1", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Serviks"},
            {"0", "1", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Serviks"},
            {"1", "0", "0", "1", "0", "1", "1", "1", "1", "1", "0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Ovarium"},
            {"1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Serviks"},
            {"1", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Serviks"},
            {"1", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Serviks"},
            {"1", "1", "0", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Serviks"},
            {"1", "0", "0", "1", "0", "0", "0", "1", "0", "1", "0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Ovarium"},
            {"0", "0", "0", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "Miom"},
            {"0", "0", "0", "0", "0", "1", "1", "1", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Ovarium"},
            {"0", "0", "0", "1", "0", "1", "1", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Ovarium"},
            {"1", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Kanker Serviks"},
            {"0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "Miom"},
            {"1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "1", "0", "0", "0", "0", "0", "Kanker Endometrium"},
            {"0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "1", "1", "0", "0", "Kista"},
            {"0", "0", "0", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "1", "0", "0", "Kista"},
            {"1", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "Kanker Vagina"},
            {"0", "0", "0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "1", "0", "1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "Miom"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "1", "0", "0", "0", "0", "1", "Kanker Endometrium"},
            {"1", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "Kanker Vagina"},
            {"0", "0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "0", "1", "0", "0", "Kista"},
            {"1", "0", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "1", "0", "0", "0", "0", "1", "Kanker Endometrium"},
            {"1", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "Kanker Vagina"},
            {"0", "0", "0", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "1", "0", "0", "Kista"}};
    double CertaintyFactor[] = new double[24];
    double propPenyakit[];
    double nilaiLikelihood[][];
    double[] nilaiTotalLikelihood;
    double nilaiPosterior[];
    int checkList[] = new int[24];
    int cekcounter;
    CheckBox checkBox[] = new CheckBox[24];
    private Button btnDiagnosis;
    double[][] counterHitungGejala;
    double[] counterHitungPenyakit = new double[6];
    double temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        checkBox[0] = (CheckBox) this.findViewById(R.id.gejala1);
        checkBox[1] = (CheckBox) this.findViewById(R.id.gejala2);
        checkBox[2] = (CheckBox) this.findViewById(R.id.gejala3);
        checkBox[3] = (CheckBox) this.findViewById(R.id.gejala4);
        checkBox[4] = (CheckBox) this.findViewById(R.id.gejala5);
        checkBox[5] = (CheckBox) this.findViewById(R.id.gejala6);
        checkBox[6] = (CheckBox) this.findViewById(R.id.gejala7);
        checkBox[7] = (CheckBox) this.findViewById(R.id.gejala8);
        checkBox[8] = (CheckBox) this.findViewById(R.id.gejala9);
        checkBox[9] = (CheckBox) this.findViewById(R.id.gejala10);
        checkBox[10] = (CheckBox) this.findViewById(R.id.gejala11);
        checkBox[11] = (CheckBox) this.findViewById(R.id.gejala12);
        checkBox[12] = (CheckBox) this.findViewById(R.id.gejala13);
        checkBox[13] = (CheckBox) this.findViewById(R.id.gejala14);
        checkBox[14] = (CheckBox) this.findViewById(R.id.gejala15);
        checkBox[15] = (CheckBox) this.findViewById(R.id.gejala16);
        checkBox[16] = (CheckBox) this.findViewById(R.id.gejala17);
        checkBox[17] = (CheckBox) this.findViewById(R.id.gejala18);
        checkBox[18] = (CheckBox) this.findViewById(R.id.gejala19);
        checkBox[19] = (CheckBox) this.findViewById(R.id.gejala20);
        checkBox[20] = (CheckBox) this.findViewById(R.id.gejala21);
        checkBox[21] = (CheckBox) this.findViewById(R.id.gejala22);
        checkBox[22] = (CheckBox) this.findViewById(R.id.gejala23);
        checkBox[23] = (CheckBox) this.findViewById(R.id.gejala24);

        btnDiagnosis = (Button) this.findViewById(R.id.buttonProsesDiagnosis);
        btnDiagnosis.setOnClickListener(this);
        double conterPenyakit1 = 0;
        double conterPenyakit2 = 0;
        double conterPenyakit3 = 0;
        double conterPenyakit4 = 0;
        double conterPenyakit5 = 0;
        double conterPenyakit6 = 0;
        for (int j = 0; j < 25; j++) {
            if (dataLatih[j][24].equalsIgnoreCase("Kanker Vagina")) {
                conterPenyakit1++;
                counterHitungPenyakit[0] = conterPenyakit1;
            } else if (dataLatih[j][24].equalsIgnoreCase("Kanker Ovarium")) {
                conterPenyakit2++;
                counterHitungPenyakit[1] = conterPenyakit2;
            } else if (dataLatih[j][24].equalsIgnoreCase("Kanker Endometrium")) {
                conterPenyakit3++;
                counterHitungPenyakit[2] = conterPenyakit3;
            } else if (dataLatih[j][24].equalsIgnoreCase("Kanker Serviks")) {
                conterPenyakit4++;
                counterHitungPenyakit[3] = conterPenyakit4;
            } else if (dataLatih[j][24].equalsIgnoreCase("Kista")) {
                conterPenyakit5++;
                counterHitungPenyakit[4] = conterPenyakit5;
            } else if (dataLatih[j][24].equalsIgnoreCase("Miom")) {
                conterPenyakit6++;
                counterHitungPenyakit[5] = conterPenyakit6;
            }
        }
        Log.i("Jumlah P1", " " + String.valueOf(counterHitungPenyakit[0]));
        Log.i("Jumlah P2", " " + String.valueOf(counterHitungPenyakit[1]));
        Log.i("Jumlah P3", " " + String.valueOf(counterHitungPenyakit[2]));
        Log.i("Jumlah P4", " " + String.valueOf(counterHitungPenyakit[3]));
        Log.i("Jumlah P5", " " + String.valueOf(counterHitungPenyakit[4]));
        Log.i("Jumlah P6", " " + String.valueOf(counterHitungPenyakit[5]));

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        int button = view.getId();
        ArrayList<String> gejalainput = new ArrayList<>();
        if (button == R.id.buttonProsesDiagnosis) {

            double contergejala1;
            double contergejala2;
            double contergejala3;
            double contergejala4;
            double contergejala5;
            double contergejala6;
            double CheckList;
            cekcounter = 0;
            for (int i = 0; i < checkBox.length; i++) {
                if (checkBox[i].isChecked()) {
                    cekcounter++;
                }
            }
            Log.i("Jumlah Centang", " " + String.valueOf(cekcounter));
            counterHitungGejala = new double[counterHitungPenyakit.length][cekcounter];
            int k = 0;

            if (cekcounter > 0) {
                for (int i = 0; i < checkBox.length; i++) {

                    if (checkBox[i].isChecked()) {
                        contergejala1 = 0;
                        contergejala2 = 0;
                        contergejala3 = 0;
                        contergejala4 = 0;
                        contergejala5 = 0;
                        contergejala6 = 0;
                        CheckList = 0;

                        for (int j = 0; j < 25; j++) {
                            if (dataLatih[j][24].equalsIgnoreCase("Kanker Vagina")) {
                                if (dataLatih[j][i].equalsIgnoreCase("1")) {
                                    contergejala1++;
                                }
                            } else if (dataLatih[j][24].equalsIgnoreCase("Kanker Ovarium")) {
                                if (dataLatih[j][i].equalsIgnoreCase("2")) {
                                    contergejala2++;
                                }
                            } else if (dataLatih[j][24].equalsIgnoreCase("Kanker Endometrium")) {
                                if (dataLatih[j][i].equalsIgnoreCase("3")) {
                                    contergejala3++;
                                }
                            } else if (dataLatih[j][24].equalsIgnoreCase("Kanker Serviks")) {
                                if (dataLatih[j][i].equalsIgnoreCase("4")) {
                                    contergejala4++;
                                }
                            } else if (dataLatih[j][24].equalsIgnoreCase("Kista")) {
                                if (dataLatih[j][i].equalsIgnoreCase("5")) {
                                    contergejala5++;
                                }
                            } else if (dataLatih[j][24].equalsIgnoreCase("Miom")) {
                                if (dataLatih[j][i].equalsIgnoreCase("6")) {
                                    contergejala6++;
                                }
                            }
                        }
                        for (int c = 0; c < checkBox.length; c++) {
                            if (checkBox[c].isChecked()) {
                                Log.i("Gejala", " " + String.valueOf(gejala[c][1]));
                                gejalainput.add(gejala[c][1]);
                                checkList[c] = 1;
                                Log.i("CheckList", " " + String.valueOf(c));
                            } else {
                                checkList[c] = 0;
                            }
                        }
                        counterHitungGejala[0][k] = contergejala1;
                        counterHitungGejala[1][k] = contergejala2;
                        counterHitungGejala[2][k] = contergejala3;
                        counterHitungGejala[3][k] = contergejala4;
                        counterHitungGejala[4][k] = contergejala5;
                        counterHitungGejala[5][k] = contergejala6;
                        k++;

                        Log.i("Jumlah gejala di P1", " " + String.valueOf(contergejala1));
                        Log.i("Jumlah gejala di P2", " " + String.valueOf(contergejala2));
                        Log.i("Jumlah gejala di P3", " " + String.valueOf(contergejala3));
                        Log.i("Jumlah gejala di P4", " " + String.valueOf(contergejala4));
                        Log.i("Jumlah gejala di P5", " " + String.valueOf(contergejala5));
                        Log.i("Jumlah gejala di P6", " " + String.valueOf(contergejala6));
                        Log.i("======================", "=========================");
                    }
                }
                hitungnilaiPrior();
                hitungnilaiLikelihood();
                hitungnilaiPosterior();

                int max = max(nilaiPosterior);
                Log.i("Nama Penyakit", " " + String.valueOf(penyakit[max][1]));
                temp = CF(max);
                double Presentasetemp;
                Presentasetemp = temp * 100;
                Intent intent = new Intent(getApplicationContext(), hasilDiagnosis.class);
                intent.putExtra("Gejala", gejalainput);
                intent.putExtra("NamaPenyakit", penyakit[max][1]);
                intent.putExtra("Penanganan", penyakit[max][2]);
                intent.putExtra("Presentase", String.valueOf(Presentasetemp));
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Masukkan terlebih dahulu gejala yang anda derita", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void hitungnilaiPrior() {
        propPenyakit = new double[counterHitungPenyakit.length];
        for (int x = 0; x < propPenyakit.length; x++) {
            propPenyakit[x] = counterHitungPenyakit[x] / dataLatih.length;

        }
        Log.i("Nilai Prior", " " + String.valueOf(propPenyakit[0]));
        Log.i("Nilai Prior", " " + String.valueOf(propPenyakit[1]));
        Log.i("Nilai Prior", " " + String.valueOf(propPenyakit[2]));
        Log.i("Nilai Prior", " " + String.valueOf(propPenyakit[3]));
        Log.i("Nilai Prior", " " + String.valueOf(propPenyakit[4]));
        Log.i("Nilai Prior", " " + String.valueOf(propPenyakit[5]));
    }

    public void hitungnilaiLikelihood() {
        nilaiLikelihood = new double[counterHitungPenyakit.length][cekcounter];
        nilaiTotalLikelihood = new double[counterHitungPenyakit.length];
        double likelihoodtemp = 1;

        for (int i = 0; i < counterHitungPenyakit.length; i++) {
            for (int k = 0; k < cekcounter; k++) {
                nilaiLikelihood[i][k] = counterHitungGejala[i][k] / counterHitungPenyakit[i];
                Log.i("Nilai Likelihood " + (i + 1) + "." + (k + 1), " " + String.valueOf(nilaiLikelihood[i][k]));
            }
        }
        for (int j = 0; j < counterHitungPenyakit.length; j++) {
            for (int i = 0; i < cekcounter; i++) {
                likelihoodtemp *= nilaiLikelihood[j][i];
            }
            nilaiTotalLikelihood[j] = likelihoodtemp;
            likelihoodtemp = 1;
            Log.i("Total Likelihood pada P" + (j + 1), " " + String.valueOf(nilaiTotalLikelihood[j]));
        }
    }

    public void hitungnilaiPosterior() {
        nilaiPosterior = new double[6];
        for (int i = 0; i < nilaiPosterior.length; i++) {
            nilaiPosterior[i] = propPenyakit[i] * nilaiTotalLikelihood[i];
            Log.i("Nilai Posterior P" + (i + 1), " " + String.valueOf(nilaiPosterior[i]));
        }
    }

    //mencari nilai max
    public int max(double[] x) {
        int panjang = 6;
        int index[] = {0, 1, 2, 3, 4, 5};
        double temp[] = new double[6];
        temp = x;
        double nilaiTertinggi = 0;
        int indexPenyakit = 0;
        int swap;
        System.out.println("input masuk Posterior:");

        for (int i = 0; i < panjang; i++) {
            System.out.println(temp[i]);
        }
        for (int i = 0; i < panjang; i++) {
            System.out.println(index[i]);
        }
        for (int a = 0; a < panjang; a++) {
            for (int b = 0; b < panjang - 1; b++) {
                if (temp[b] < temp[b + 1]) {
                    double tampung = temp[b];
                    swap = index[b];
                    index[b] = index[b + 1];
                    index[b + 1] = swap;
                    temp[b] = temp[b + 1];
                    temp[b + 1] = tampung;
                }
            }
        }
        System.out.println("Output masuk MAX Posterior:");

        for (int i = 0; i < panjang; i++) {
            System.out.println(temp[i]);
        }
        for (int i = 0; i < panjang; i++) {
            System.out.println(index[i]);
        }
        nilaiTertinggi = temp[0];
        indexPenyakit = index[0];
        return indexPenyakit;
    }

    public double CF(int x) {
        double cfCombine = 0;
        double temp = 0;
        System.out.println("x : " + x);
        for (int i = 0; i < 18; i++) {
            CertaintyFactor[i] = bobotGejalaCF[x][i] * checkList[i];
            System.out.println("Bobot Pakar " + (i + 1) + ":" + bobotGejalaCF[x][i]);

        }
        temp = CertaintyFactor[0] + (CertaintyFactor[1] * (1 - CertaintyFactor[0]));
        for (int i = 2; i < 18; i++) {
            temp = CertaintyFactor[i] + (temp * (1 - CertaintyFactor[i]));
        }
        Log.i("Nilai CF ", " " + temp);
        return temp;
   }
}