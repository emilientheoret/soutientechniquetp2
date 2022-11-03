package com.example.soutientechtp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_00;
    private Button btn_01;
    private Button btn_02;

    private Button btn_10;
    private Button btn_11;
    private Button btn_12;

    private Button btn_20;
    private Button btn_21;
    private Button btn_22;

    private Button btn_reset;

    private String[] valeurs = {"x", "o"};

    private char[] table;

    private int col;
    private int index;
    private int clics;
    private String winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn_00.setOnClickListener(this);
        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_10.setOnClickListener(this);
        btn_11.setOnClickListener(this);
        btn_12.setOnClickListener(this);
        btn_20.setOnClickListener(this);
        btn_21.setOnClickListener(this);
        btn_22.setOnClickListener(this);

    }


    @Override
    public void onClick(View v){
        if(clics < 9) {
            switch (v.getId()) {
                case R.id.btn_00:
                    col = 0;
                    index(btn_00);
                    break;
                case R.id.btn_01:
                    col = 1;
                    index(btn_01);
                    break;
                case R.id.btn_02:
                    col = 2;
                    index(btn_02);
                    break;
                case R.id.btn_10:
                    col = 3;
                    index(btn_10);
                    break;
                case R.id.btn_11:
                    col = 4;
                    index(btn_11);
                    break;
                case R.id.btn_12:
                    col = 5;
                    index(btn_12);
                    break;
                case R.id.btn_20:
                    col = 6;
                    index(btn_20);
                    break;
                case R.id.btn_21:
                    col = 7;
                    index(btn_21);
                    break;
                case R.id.btn_22:
                    col = 8;
                    index(btn_22);
                    break;
                default:
                    break;
            }
        }
        if(win('x') || win('o')) {
            Toast.makeText(getApplicationContext(), winner, Toast.LENGTH_SHORT).show();
            btn_00.setEnabled(false);
            btn_01.setEnabled(false);
            btn_02.setEnabled(false);
            btn_10.setEnabled(false);
            btn_11.setEnabled(false);
            btn_12.setEnabled(false);
            btn_20.setEnabled(false);
            btn_21.setEnabled(false);
            btn_22.setEnabled(false);
        }
    }

    private void init(){
        btn_00 = findViewById(R.id.btn_00);
        btn_01 = findViewById(R.id.btn_01);
        btn_02 = findViewById(R.id.btn_02);
        btn_10 = findViewById(R.id.btn_10);
        btn_11 = findViewById(R.id.btn_11);
        btn_12 = findViewById(R.id.btn_12);
        btn_20 = findViewById(R.id.btn_20);
        btn_21 = findViewById(R.id.btn_21);
        btn_22 = findViewById(R.id.btn_22);
        btn_reset = findViewById(R.id.btn_reset);

        table = new char[] {'a', 'a', 'a','a', 'a', 'a','a', 'a', 'a'};
        col = 0;
        index = 0;
        clics = 0;
        winner = "";

    }

    private void index(Button btn){
        if (index == 0) {
            if(!isAlreadyClicked(table[col])) {
                btn.setText(valeurs[index]);
                table[col] = 'x';
                index++;
                clics++;
            } else {
                Toast.makeText(getApplicationContext(), "DEJA CLIQUER", Toast.LENGTH_SHORT).show();
            }
        } else {
            if(!isAlreadyClicked(table[col])) {
                btn.setText(valeurs[index]);
                table[col] = 'o';
                index--;
                clics++;
            } else {
                Toast.makeText(getApplicationContext(), "DEJA CLIQUER", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClickReset(View v){
        btn_00.setText("");
        btn_01.setText("");
        btn_02.setText("");
        btn_10.setText("");
        btn_11.setText("");
        btn_12.setText("");
        btn_20.setText("");
        btn_21.setText("");
        btn_22.setText("");
        init();
    }

    private boolean isAlreadyClicked(char value){
        if (value == 'x' || value == 'o')
            return true;
        return false;
    }

    private boolean win(char value){
        String msgWin = "Joueur ";

        int win[][] = { {0, 1, 2},
                        {3, 4, 5},
                        {6, 7, 8},
                        {0, 3, 6},
                        {1, 4, 7},
                        {2, 5, 8},
                        {0, 4, 8},
                        {2, 4, 6}};

        if (value == 'x')
            msgWin += "'X' est le gagnant!";
        else
            msgWin += "'O' est le gagnant!";

            for (int i= 0; i < 8; i++) {
                if (table[win[i][0]] == value && table[win[i][1]]== value && table[win[i][2]]== value) {
                    winner = msgWin;
                    return true;
                }
            }

            return false;
    }

}