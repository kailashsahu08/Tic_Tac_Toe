package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
//import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,rst;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int ed = 0, count = 0;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        rst = findViewById(R.id.rst);
        txt1 = findViewById(R.id.txt1);
    }

    public void click(View b) {
        Button btc = (Button) b;
        if (btc.getText().toString().equals("")) {
            count++;
            if (ed == 0) {
                btc.setText("X");
                ed = 1;
            } else {
                btc.setText("o");
                ed = 0;
            }

            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();

            if (count > 4) {
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    txt1.setText("The winner is "+b1);
                    newgame();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    txt1.setText("The winner is "+b6);
                    newgame();
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    txt1.setText("The winner is "+b7);
                    newgame();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    txt1.setText("The winner is "+b1);
                    newgame();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    txt1.setText("The winner is "+b2);
                    newgame();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    txt1.setText("The winner is "+b3);
                    newgame();
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    txt1.setText("The winner is "+b1);
                    newgame();
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    txt1.setText("The winner is "+b3);
                    newgame();
                } else if (count == 9) {
                    txt1.setText("The match is draw");
                    newgame();
                }
            }
        }
    }

    public void newgame()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                txt1.setText("result shown here");
                ed =0;
                count =0;
            }
        },4000);
    }
    public void restart(View r)
    {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        txt1.setText("result shown here");
        ed =0;
        count =0;
    }
}