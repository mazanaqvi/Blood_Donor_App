package com.example.blood_donor_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText username_,location_,bloodgroup_,contact_,availibility_;
    Button regpagebtn;
    Button callbtn;

    Button register_;
    FirebaseAuth auth;
    public ArrayList<String> usernames=new ArrayList<String>();
    public ArrayList<String>availibilities=new ArrayList<String>();
    public ArrayList<String>locations=new ArrayList<String>();
    public ArrayList<String>bloodgroups=new ArrayList<String>();
    public ArrayList<String>contacts=new ArrayList<String>();
    ArrayList<donor> list;
    ArrayList<Object> dlist;
    donor_adapter dadpter;
    dbhelper myDB;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        regpagebtn= findViewById(R.id.registerpage);

        regpagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),register.class);
                startActivity(intent);
            }
        });

        





        RecyclerView donorlist=findViewById(R.id.donorlist);
        getfromfirebase();

        initrecyclerview();


    }
    public void getfromfirebase(){
        FirebaseDatabase.getInstance().getReference().child("donors").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        donor d=snapshot1.getValue(donor.class);

                        usernames.add(d.name);
                        locations.add(d.location);
                        bloodgroups.add(d.bgroup);
                        contacts.add(d.contact);
                        availibilities.add(d.availability);
                        dadpter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
    public void initrecyclerview(){
        RecyclerView recyclerView=findViewById(R.id.donorlist);
         dadpter=new donor_adapter(this,usernames,bloodgroups,locations,contacts,availibilities);

        recyclerView.setAdapter(dadpter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void listfiller()
    {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

     return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickEvent(View v){
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:"));
        sendIntent.putExtra("address", "03033999512");
        sendIntent.putExtra("sms_body","Please Donate blood, patient is in critical condition and require your blood");
        startActivity(sendIntent);
    }
    public void callclickEvent(View v){
        Intent sendIntent = new Intent(Intent.ACTION_DIAL );
        sendIntent.setData(Uri.parse("tel:03033999512"));
        
        startActivity(sendIntent);
    }
}