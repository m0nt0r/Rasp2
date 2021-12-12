package com.example.rasp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText edWeek,edDay,edTime,edpodgrup,edprep,edcab,edpara;
    private DatabaseReference mDataBase;
    private String NEWT_KEY = "NEWT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init()
    {
        edWeek=findViewById(R.id.edWeek);
        edDay=findViewById(R.id.edDay);
        edTime=findViewById(R.id.edTime);
        edpodgrup=findViewById(R.id.edpodgrup);
        edprep=findViewById(R.id.edprep);
        edcab=findViewById(R.id.edcab);
        edpara=findViewById(R.id.edpara);
        mDataBase = FirebaseDatabase.getInstance().getReference(NEWT_KEY);

    }
    public void onClickSave(View view)
    {
        String id = mDataBase.getKey();
        String week = edWeek.getText().toString();
        String day = edDay.getText().toString();
        String time = edTime.getText().toString();
        String podgrup = edpodgrup.getText().toString();
        String prep = edprep.getText().toString();
        String cab = edcab.getText().toString();
        String para = edpara.getText().toString();
        Newt newNewt = new Newt(id,week,day,time,podgrup,prep,cab,para);
        if(!TextUtils.isEmpty(week) && !TextUtils.isEmpty(day) && !TextUtils.isEmpty(time) && !TextUtils.isEmpty(podgrup)
                && !TextUtils.isEmpty(prep)&& !TextUtils.isEmpty(cab) && !TextUtils.isEmpty(para))
        {
            mDataBase.push().setValue(newNewt);
            Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Empty field", Toast.LENGTH_SHORT).show();
        }

    }
    public void onClickRead(View view)
    {
        Intent i = new Intent(MainActivity.this, ReadActivity.class);
        startActivity(i);
    }
}