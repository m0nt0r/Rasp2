package com.example.rasp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class kurs extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kurs);
    }
    public void onClick2(View view)
    {
        Intent i = getIntent();
        String level = i.getStringExtra("level");
        Intent intent = new Intent(kurs.this, grup.class);
        intent.putExtra("kurs","2");
        intent.putExtra("level",level);
        startActivity(intent);
    }
    public void onClick3(View view)
    {
        Intent i = getIntent();
        String level = i.getStringExtra("level");
        Intent intent = new Intent(kurs.this, grup.class);
        intent.putExtra("kurs","3");
        intent.putExtra("level",level);
        startActivity(intent);
    }
}