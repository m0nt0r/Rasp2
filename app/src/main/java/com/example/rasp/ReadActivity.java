package com.example.rasp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Placeholder;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<Newt> listTemp;
    private DatabaseReference mDataBase;
    private DatabaseReference mPostReference;
    private String NEWT_KEY = "NEWT";
    private String USER_KEY = "USER";
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
                Intent intent = getIntent();
                String level = intent.getStringExtra("level");
                Toast.makeText(getApplicationContext(),level,Toast.LENGTH_SHORT).show();
                for(DataSnapshot ds: snapshot.getChildren())
                {
                    Intent i = getIntent();
                    String podgrup = i.getStringExtra("podgrup");
                    String weekw = i.getStringExtra("weekw");
                    String dayy = i.getStringExtra("dayy");
                    String kurs = i.getStringExtra("kurs");
                    String grup = i.getStringExtra("grup");
                    Newt newt = ds.getValue(Newt.class);
                    assert newt != null;
                    if(newt.Week.equals(weekw) && newt.podgrup.equals(podgrup) && newt.Day.equals(dayy) && newt.kurs.equals(kurs)
                            && newt.grup.equals(grup))
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
                Intent i = getIntent();
                String level = i.getStringExtra("level");
                if(level.equals("1"))
                {
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    Query applesQuery = ref.child("NEWT").orderByChild("para").equalTo(newt.para);
                    applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            for (DataSnapshot appleSnapshot: snapshot.getChildren()) {

                                appleSnapshot.getRef().removeValue();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                }
                else if (level.equals("0"))
                {
                    Intent intent = new Intent(ReadActivity.this, Show.class);
                    intent.putExtra("newt_cab",newt.cab);
                    intent.putExtra("newt_prep",newt.prep);
                    intent.putExtra("newt_time",newt.Time);
                    intent.putExtra("newt_pred",newt.predmet);
                    startActivity(intent);
                }

                //mPostReference = FirebaseDatabase.getInstance().getReference().child(newt).child(mPostKey);
                //mPostReference.removeValue();
                //DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                //Query applesQuery = ref.child("firebase-test").orderByChild("title").equalTo("Apple");
                //}
                //Intent i = new Intent(ReadActivity.this, Show.class);
                //i.putExtra("newt_cab",newt.cab);
                //i.putExtra("newt_prep",newt.prep);
                //i.putExtra("newt_time",newt.Time);
                //i.putExtra("newt_pred",newt.predmet);
                //startActivity(i);
            }
        });
    }
}
