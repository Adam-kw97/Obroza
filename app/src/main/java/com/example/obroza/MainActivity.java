package com.example.obroza;

//test comitta

//import android.support.v7.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    TextView a,b;
    //Button btn;
    DatabaseReference reff;
    Point point=new Point();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_points);

        a=(TextView) findViewById(R.id.textX);
        b=(TextView) findViewById(R.id.textY);
        //btn= (Button) findViewById(R.id.but);


                reff= FirebaseDatabase.getInstance().getReference().child("coordinates").child("0");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        point.x=(double)dataSnapshot.child("longitude").getValue();
                        point.y=(double)dataSnapshot.child("latidude").getValue();


                        a.setText("X= "+point.x);
                        b.setText("Y= "+point.y);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });






        //Toast.makeText(MainActivity.this,"Firebase Giiit",Toast.LENGTH_LONG).show();

    }






}