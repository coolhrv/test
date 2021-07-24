package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Home_activity extends AppCompatActivity {
    private EditText mname,number,age;

    private Button submit;
    private FirebaseFirestore mStore;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mname=findViewById(R.id.textView);
        number=findViewById(R.id.textView2);
        age=findViewById(R.id.textView3);
        submit=findViewById(R.id.button);
        mStore=FirebaseFirestore.getInstance();
        mAuth= FirebaseAuth.getInstance();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=mname.getText().toString();
                String mnumber=number.getText().toString();
                String mage=age.getText().toString();
                if(name.isEmpty()){
                    mname.setError("gand fatt gyi naam ki");
                    return;
                }
                if(mnumber.isEmpty()){
                    number.setError("gand fatt gyi number ki");
                    return;
                }
                if(mage.isEmpty()){
                    age.setError("gand fatt gyi age ki");
                    return;
                }else{
                    UserData userData=new UserData(name,mnumber,mage);

                    mStore.collection(mAuth.getCurrentUser().getUid()).add(userData).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull  Task<DocumentReference> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Home_activity.this, "ho gya kaam", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(Home_activity.this, "ma chud gyi", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });





                }



            }
        });
    }
}