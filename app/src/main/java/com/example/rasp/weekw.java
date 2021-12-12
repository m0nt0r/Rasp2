package com.example.rasp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class weekw extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week);
    }
    public void onClickUp(View view)
    {
        Intent i = getIntent();
        String podgrup = i.getStringExtra("podgrup");
        Toast.makeText(this, podgrup, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(weekw.this, day.class);
        intent.putExtra("podgrup",podgrup);
        intent.putExtra("weekw","1");
        startActivity(intent);
    }
    public void onClickDown(View view)
    {
        Intent i = getIntent();
        String podgrup = i.getStringExtra("podgrup");
        Intent intent = new Intent(weekw.this, day.class);
        intent.putExtra("podgrup",podgrup);
        intent.putExtra("weekw","2");
        startActivity(intent);
    }
}
