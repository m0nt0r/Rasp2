package com.example.rasp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
public void onClickGrup(View view)
{
    Intent i = new Intent(menu.this, podgrup.class);
    startActivity(i);
}
}