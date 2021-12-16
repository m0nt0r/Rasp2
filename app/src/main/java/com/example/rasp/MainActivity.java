package com.example.rasp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText edWeek,edDay,edTime,edpodgrup,edprep,edcab,edpara, edgrup,edkurs,edpredmet;
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
        edgrup=findViewById(R.id.edgrup);
        edkurs=findViewById(R.id.edkurs);
        edpredmet=findViewById(R.id.edpredmet);
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
        String grup = edgrup.getText().toString();
        String kurs = edkurs.getText().toString();
        String predmet = edpredmet.getText().toString();
        Newt newNewt = new Newt(id,week,day,time,podgrup,prep,cab,para,kurs,grup,predmet);
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
}