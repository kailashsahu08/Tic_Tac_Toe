package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class user_name extends AppCompatActivity {
    EditText p1name,p2name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);
        Intent inext = new Intent(this,MainActivity.class);
        Button enter = findViewById(R.id.enter);
        p1name = findViewById(R.id.p1name);
        p2name = findViewById(R.id.p2name);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inext.putExtra("p1name",p1name.getText().toString());
                inext.putExtra("p2name",p2name.getText().toString());
                startActivity(inext);
            }
        });
    }
}