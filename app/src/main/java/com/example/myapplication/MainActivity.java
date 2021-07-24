package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email,pass;

    Button signup,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.item_email);
        pass=findViewById(R.id.item_password);
        mAuth=FirebaseAuth.getInstance();
        signup=findViewById(R.id.signup_btn);
        signin=findViewById(R.id.signin_btn);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mMail=email.getText().toString();
                String mPass=pass.getText().toString();
                if(mMail.isEmpty()){
                    email.setError("empty");
                    return;
                }
                if(mPass.isEmpty()){
                    pass.setError("empty");
                    return;
                }
                mAuth.createUserWithEmailAndPassword(mMail,mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "nice", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this,Dynamic_activity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                        }

                    }
                });



            }
        });



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mMail=email.getText().toString();
                String mPass=pass.getText().toString();
                if(mMail.isEmpty()){
                    email.setError("empty");
                    return;
                }
                if(mPass.isEmpty()){
                    pass.setError("empty");
                    return;
                }
                mAuth. signInWithEmailAndPassword(mMail,mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "very nice", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this,Dynamic_activity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(MainActivity.this, "Galat ahi", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });





    }
}