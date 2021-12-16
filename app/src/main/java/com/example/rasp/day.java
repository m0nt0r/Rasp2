package com.example.rasp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class day extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day);
    }

    public void onClickMon(View view)
    {
        Intent i = getIntent();
        String kurs = i.getStringExtra("kurs");
        String grup = i.getStringExtra("grup");
        String podgrup = i.getStringExtra("podgrup");
        String weekw = i.getStringExtra("weekw");
        String level = i.getStringExtra("level");
        Intent intent = new Intent(day.this, ReadActivity.class);
        intent.putExtra("dayy","1");
        intent.putExtra("podgrup",podgrup);
        intent.putExtra("weekw",weekw);
        intent.putExtra("kurs",kurs);
        intent.putExtra("grup",grup);
        intent.putExtra("level",level);
        startActivity(intent);
    }
    public void onClickTue(View view)
    {
        Intent i = getIntent();
        String kurs = i.getStringExtra("kurs");
        String grup = i.getStringExtra("grup");
        String podgrup = i.getStringExtra("podgrup");
        String weekw = i.getStringExtra("weekw");
        String level = i.getStringExtra("level");
        Intent intent = new Intent(day.this, ReadActivity.class);
        intent.putExtra("dayy","2");
        intent.putExtra("podgrup",podgrup);
        intent.putExtra("weekw",weekw);
        intent.putExtra("kurs",kurs);
        intent.putExtra("grup",grup);
        intent.putExtra("level",level);
        startActivity(intent);
    }
    public void onClickWed(View view)
    {
        Intent i = getIntent();
        String kurs = i.getStringExtra("kurs");
        String grup = i.getStringExtra("grup");
        String podgrup = i.getStringExtra("podgrup");
        String weekw = i.getStringExtra("weekw");
        String level = i.getStringExtra("level");
        Intent intent = new Intent(day.this, ReadActivity.class);
        intent.putExtra("dayy","3");
        intent.putExtra("podgrup",podgrup);
        intent.putExtra("weekw",weekw);
        intent.putExtra("kurs",kurs);
        intent.putExtra("grup",grup);
        intent.putExtra("level",level);
        startActivity(intent);
    }
    public void onClickThu(View view)
    {
        Intent i = getIntent();
        String kurs = i.getStringExtra("kurs");
        String grup = i.getStringExtra("grup");
        String podgrup = i.getStringExtra("podgrup");
        String weekw = i.getStringExtra("weekw");
        String level = i.getStringExtra("level");
        Intent intent = new Intent(day.this, ReadActivity.class);
        intent.putExtra("dayy","4");
        intent.putExtra("podgrup",podgrup);
        intent.putExtra("weekw",weekw);
        intent.putExtra("kurs",kurs);
        intent.putExtra("grup",grup);
        intent.putExtra("level",level);
        startActivity(intent);
    }
    public void onClickFri(View view)
    {
        Intent i = getIntent();
        String kurs = i.getStringExtra("kurs");
        String grup = i.getStringExtra("grup");
        String podgrup = i.getStringExtra("podgrup");
        String weekw = i.getStringExtra("weekw");
        String level = i.getStringExtra("level");
        Intent intent = new Intent(day.this, ReadActivity.class);
        intent.putExtra("dayy","5");
        intent.putExtra("podgrup",podgrup);
        intent.putExtra("weekw",weekw);
        intent.putExtra("kurs",kurs);
        intent.putExtra("grup",grup);
        intent.putExtra("level",level);
        startActivity(intent);
    }
    public void onClickSat(View view)
    {
        Intent i = getIntent();
        String kurs = i.getStringExtra("kurs");
        String grup = i.getStringExtra("grup");
        String podgrup = i.getStringExtra("podgrup");
        String weekw = i.getStringExtra("weekw");
        String level = i.getStringExtra("level");
        Intent intent = new Intent(day.this, ReadActivity.class);
        intent.putExtra("dayy","6");
        intent.putExtra("podgrup",podgrup);
        intent.putExtra("weekw",weekw);
        intent.putExtra("kurs",kurs);
        intent.putExtra("grup",grup);
        intent.putExtra("level",level);
        startActivity(intent);
    }

}

