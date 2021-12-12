package com.example.rasp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class podgrup extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.podgrup);
    }
    public void onClickOne(View view)
    {
        Intent i = new Intent(podgrup.this, weekw.class);
        i.putExtra("podgrup","1");
        startActivity(i);
    }
    public void onClickTwo(View view)
    {
        Intent i = new Intent(podgrup.this, weekw.class);
        i.putExtra("podgrup","2");
        startActivity(i);
    }
}