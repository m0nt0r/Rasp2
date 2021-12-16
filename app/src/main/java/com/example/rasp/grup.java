package com.example.rasp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class grup extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        String kurs = i.getStringExtra("kurs");
        if(kurs.equals("2"))
        {
            setContentView(R.layout.grupkurs2);
        }
        else if(kurs.equals("3")){
            setContentView(R.layout.grupkurs3);
        }
    }
    public void onClickOne(View view)
    {
        Intent i = getIntent();
        String kurs = i.getStringExtra("kurs");
        String level = i.getStringExtra("level");

        Intent intent = new Intent(grup.this, podgrup.class);
        intent.putExtra("grup","1");
        intent.putExtra("kurs",kurs);
        intent.putExtra("level",level);
        startActivity(intent);
    }
    public void onClickTwo(View view)
    {
        Intent i = getIntent();
        String level = i.getStringExtra("level");
        String kurs = i.getStringExtra("kurs");
        Intent intent = new Intent(grup.this, podgrup.class);
        intent.putExtra("grup","2");
        intent.putExtra("kurs",kurs);
        intent.putExtra("level",level);
        startActivity(intent);
    }
}
