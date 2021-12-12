package com.example.rasp;

import android.os.Bundle;
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
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;

public class Read extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private DatabaseReference mDataBase;
    private String NEWT_KEY = "NEWT";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_layout);
        //init();
        //getDataFromDB();
    }
    private void init()
    {
        listView = findViewById(R.id.listView);
        listData = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference(NEWT_KEY);
    }
    private void getDataFromDB()
    {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(listData.size() >0)listData.clear();
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    Newt newt = ds.getValue(Newt.class);
                    assert newt != null;
                    listData.add(newt.Day);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDataBase.addValueEventListener(vListener);
    }
}
