package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Adapter.ImportAdapter;
import com.example.myapplication.Domain.ImageDownload;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Dynamic_activity extends AppCompatActivity {


ImportAdapter madapter;
List<ImageDownload> imgList;

FirebaseFirestore mStore;
RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        imgList=new ArrayList<>();
        madapter=new ImportAdapter(getApplicationContext(),imgList);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(madapter);
        mStore=FirebaseFirestore.getInstance();


        mStore.collection("ImageDownload").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull  Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot document: task.getResult()){
                        ImageDownload imgdownload=document.toObject(ImageDownload.class);
                        imgList.add(imgdownload);
                        madapter.notifyDataSetChanged();
                        Toast.makeText(Dynamic_activity.this, "ho haa hai", Toast.LENGTH_SHORT).show();



                    }
                }else{
                    Toast.makeText(Dynamic_activity.this, "Gand fatt gyi", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}