package com.example.rasp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class menu_admin extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_admin);
    }
    public void onClickAdd(View view)
    {
        Intent i = new Intent(menu_admin.this, MainActivity.class);
        startActivity(i);
    }
    public void onClickDel(View view)
    {
        Intent i = getIntent();
        String level = i.getStringExtra("level");
        Intent intent = new Intent(menu_admin.this, kurs.class);
        intent.putExtra("level",level);
        startActivity(intent);
    }
}