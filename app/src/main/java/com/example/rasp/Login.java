package com.example.rasp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    private EditText edLogin, edPassword;
    private FirebaseAuth mAuth;
    private DatabaseReference mDataBase;
    private String USER_KEY= "USER";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser cUser = mAuth.getCurrentUser();
        if(cUser!= null)
        {
            Toast.makeText(this,"User not null",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"User null",Toast.LENGTH_SHORT).show();
        }
    }

    private void init()
    {
        edLogin = findViewById(R.id.edLogin);
        edPassword = findViewById(R.id.edPassword);
        mAuth = FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }
    public void onClickSignUp(View view)
    {
        if(!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString()))
        {
        mAuth.createUserWithEmailAndPassword(edLogin.getText().toString(),edPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String id =  mDataBase.getKey();
                    String uid = user.getUid();
                    String level = "0";
                    User newUser = new User(id,uid,level);
                    mDataBase.push().setValue(newUser);
                    Toast.makeText(getApplicationContext(),"User SignUp",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"User not SignUp",Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
        else
            {
                Toast.makeText(getApplicationContext(),"Pass and mail GDE ?",Toast.LENGTH_SHORT).show();
            }
    }
    public void onClickSignIn(View view)
    {
        if(!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString())) {
        }
        mAuth.signInWithEmailAndPassword(edLogin.getText().toString(),edPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String uid = user.getUid();
                    ValueEventListener vListener = new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot)
                        {
                            for(DataSnapshot ds: snapshot.getChildren())
                            {
                                User user = ds.getValue(User.class);
                                assert user != null;
                                if(user.uid.equals(uid) && user.level.equals("1"))
                                {
                                    Toast.makeText(getApplicationContext(),"Admin",Toast.LENGTH_SHORT).show();
                                    Toast.makeText(getApplicationContext(),uid,Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(Login.this, menu_admin.class);
                                    startActivity(i);
                                    finish();
                                    break;
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"User",Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(Login.this, menu.class);
                                    startActivity(i);
                                    finish();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    };
                    mDataBase.addValueEventListener(vListener);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"User not SignIn",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
