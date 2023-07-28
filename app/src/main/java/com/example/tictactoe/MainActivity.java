package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
//import android.widget.TextView;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button rst;
    private String p1name,p2name;
    boolean win=true;
    private int arr[][]=new int[3][3];
    int ed = 0, count = 0,p1w=0,p1l=0,p1d=0,p2w=0,p2l=0,p2d=0;
    TextView txt1,txt2,p1win,p2win,p1lose,p2lose,p1draw,p2draw,nameOfP1,nameOfP2;
    private GridLayout gridLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout = findViewById(R.id.gridLayout);
        arrInitialize();
        init();
        Intent name = getIntent();
        p1name = name.getStringExtra("p1name");
        p2name = name.getStringExtra("p2name");
        nameOfP1.setText(p1name);
        nameOfP2.setText(p2name);
    }
    public void arrInitialize()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                arr[i][j]=0;
            }
        }
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
        txt2 = findViewById(R.id.txt2);
        p1win = findViewById(R.id.p1win);
        p1lose = findViewById(R.id.p1lose);
        p1draw = findViewById(R.id.p1draw);
        nameOfP1 = findViewById(R.id.nameOfP1);
        p2win = findViewById(R.id.p2win);
        p2lose = findViewById(R.id.p2lose);
        p2draw = findViewById(R.id.p2draw);
        nameOfP2 = findViewById(R.id.nameOfp2);
    }

    public void click(View b) {
        ImageView btc = (ImageView) b;
        int index = gridLayout.indexOfChild(b);
        int row = index/3;
        int col = index%3;
        if (arr[row][col]==0 && win) {
            count++;
            if (ed == 0) {
                btc.setImageResource(R.drawable.rec);
                txt1.setText(p1name+" TURN");
                txt2.setText("");
                arr[row][col] = 2;
                ed = 1;
            } else {
                btc.setImageResource(R.drawable.close);
                txt1.setText("");
                txt2.setText(p2name+" TURN");
                arr[row][col]=1;
                ed = 0;
            }
            if (count > 4) {
                if (arr[row][0]==arr[row][1] && arr[row][1]==arr[row][2] &&  arr[row][0]!=0) {
                    if(arr[row][0]==2)
                    {
                        p1w++;
                        p2l++;
                        p1win.setText(p1w+"");
                        p2lose.setText(p2l+"");
                        nameOfP1.setText("WINNER");
                        txt1.setText("THE WINNER is "+p1name);
                    }
                    else
                    {
                        p1l++;
                        p2w++;
                        p2win.setText(p2w+"");
                        p1lose.setText(p1l+"");
                        nameOfP2.setText("WINNER");
                        txt2.setText("THE WINNER is "+p2name);
                    }
                    win=false;
                    newgame();
                } else if (arr[0][col]==arr[1][col] && arr[1][col]==arr[2][col] && arr[0][col]!=0) {
                    if(arr[0][col]==2) {
                        p1w++;
                        p2l++;
                        p1win.setText(p1w+"");
                        p2lose.setText(p2l+"");
                        nameOfP1.setText("WINNER");
                        txt1.setText("THE WINNER is "+p1name);
                    }
                    else {
                        p1l++;
                        p2w++;
                        p2win.setText(p2w+"");
                        p1lose.setText(p1l+"");
                        nameOfP2.setText("WINNER");
                        txt2.setText("THE WINNER is "+p2name);
                    }
                    win = false;
                    newgame();
                } else if (arr[0][0]==arr[1][1] && arr[1][1]==arr[2][2] && arr[0][0]!=0) {
                    if(arr[0][0]==2) {
                        p1w++;
                        p2l++;
                        p1win.setText(p1w+"");
                        p2lose.setText(p2l+"");
                        nameOfP1.setText("WINNER");
                        txt1.setText("THE WINNER is "+p1name);
                    }
                    else {
                        p1l++;
                        p2w++;
                        p2win.setText(p2w+"");
                        p1lose.setText(p1l+"");
                        nameOfP2.setText("WINNER");
                        txt2.setText("THE WINNER is "+p2name);

                    }
                    win=false;
                    newgame();
                }else if (arr[0][2]==arr[1][1] && arr[1][1]==arr[2][0] && arr[1][1]!=0) {
                    if(arr[2][0]==2){
                        p1w++;
                        p2l++;
                        p1win.setText(p1w+"");
                        p2lose.setText(p2l+"");
                        nameOfP1.setText("WINNER");
                        txt1.setText("THE WINNER is "+p1name);
                    }
                    else {
                        p1l++;
                        p2w++;
                        p2win.setText(p2w+"");
                        p1lose.setText(p1l+"");
                        nameOfP2.setText("WINNER");
                        txt2.setText("THE WINNER is "+p2name);
                    }
                    win=false;
                    newgame();
                } else if (count == 9) {
                    p1d++;
                    p2d++;
                    p1draw.setText(p1d+"");
                    p2draw.setText(p2d+"");
                    nameOfP1.setText("DRAW");
                    nameOfP2.setText("DRAW");
                    txt1.setText("MATCH DRAW");
                    txt2.setText("MATCH DRAW");
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
                arrInitialize();
                btn1.setImageResource(0);
                btn2.setImageResource(0);
                btn3.setImageResource(0);
                btn4.setImageResource(0);
                btn5.setImageResource(0);
                btn6.setImageResource(0);
                btn7.setImageResource(0);
                btn8.setImageResource(0);
                btn9.setImageResource(0);
                nameOfP1.setText(p1name);
                nameOfP2.setText(p2name);
                win = true;
                ed = (ed==1)?0:1 ;
                count =0;
                nameOfP1.setText(p1name);
                nameOfP2.setText(p2name);
                if (ed == 0) {
                    txt1.setText(p1name+" TURN");
                    txt2.setText("");
                } else {
                    txt1.setText("");
                    txt2.setText(p2name+" TURN");
                }
            }
        },4000);
    }
    public void restart(View r)
    {
        arrInitialize();
        btn1.setImageResource(0);
        btn2.setImageResource(0);
        btn3.setImageResource(0);
        btn4.setImageResource(0);
        btn5.setImageResource(0);
        btn6.setImageResource(0);
        btn7.setImageResource(0);
        btn8.setImageResource(0);
        btn9.setImageResource(0);
        nameOfP1.setText(p1name);
        nameOfP2.setText(p2name);
        win = true;
        ed = (ed==1)?0:1 ;
        count =0;
        nameOfP1.setText(p1name);
        nameOfP2.setText(p2name);
        if (ed == 0) {
            txt1.setText(p1name+" TURN");
            txt2.setText("");
        } else {
            txt1.setText("");
            txt2.setText(p2name+" TURN");
        }
    }
}