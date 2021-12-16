package com.example.rasp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Show extends AppCompatActivity {
    private TextView tvcab,tvprep,tvTime,tvpred;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout);
        init();
        getIntentMain();
    }
    private void init()
    {
        tvTime = findViewById(R.id.tvTime);
        tvcab = findViewById(R.id.tvcab);
        tvprep = findViewById(R.id.tvprep);
        tvpred = findViewById(R.id.tvpred);
    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            tvcab.setText(i.getStringExtra("newt_cab"));
            tvprep.setText(i.getStringExtra("newt_prep"));
            tvTime.setText(i.getStringExtra("newt_time"));
            tvpred.setText(i.getStringExtra("newt_pred"));
        }
    }
}
