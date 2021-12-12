package com.example.rasp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<Newt> listTemp;
    private DatabaseReference mDataBase;
    private String NEWT_KEY = "NEWT";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_layout);
        init();
        getDataFromDB();
        SetOnClickItem();
    }
    private void init()
    {
        listView = findViewById(R.id.listView);
        listData = new ArrayList<>();
        listTemp = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference(NEWT_KEY);
    }
    private void getDataFromDB()
    {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                if(listData.size() >0)listData.clear();
                if(listTemp.size() >0)listTemp.clear();
                for(DataSnapshot ds: snapshot.getChildren())
                {
                    Intent i = getIntent();
                    String podgrup = i.getStringExtra("podgrup");
                    String weekw = i.getStringExtra("weekw");
                    String dayy = i.getStringExtra("dayy");
                    Newt newt = ds.getValue(Newt.class);
                    assert newt != null;
                    if(newt.Week.equals(weekw) && newt.podgrup.equals(podgrup) && newt.Day.equals(dayy))
                    {
                        listData.add(newt.para);
                        listTemp.add(newt);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDataBase.addValueEventListener(vListener);
    }
    private void SetOnClickItem()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Newt newt = listTemp.get(position);
                Intent i = new Intent(ReadActivity.this, Show.class);
                i.putExtra("newt_cab",newt.cab);
                i.putExtra("newt_prep",newt.prep);
                i.putExtra("newt_time",newt.Time);
                startActivity(i);
            }
        });
    }
}
