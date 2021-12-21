package com.example.blood_donor_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class register extends AppCompatActivity {
    Button regbtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    dbhelper myDB;
    EditText username_,location_,bloodgroup_,contact_,availibility_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username_=findViewById(R.id.username_);
        location_=findViewById(R.id.location_);
        availibility_=findViewById(R.id.availibilty_);
        contact_=findViewById(R.id.contact_);
        bloodgroup_=findViewById(R.id.bloodgroup_);
        regbtn=findViewById(R.id.registerbtn_);


        regbtn= findViewById(R.id.registerbtn_);
        regbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("donors");
               String un=username_.getText().toString();
               String bg=bloodgroup_.getText().toString();
               String loc=location_.getText().toString();
               String cont=contact_.getText().toString();
               String avail=availibility_.getText().toString();
                donor d1=new donor(un,bg,loc,avail,cont);
                reference.child(cont).setValue(d1);
               Intent intent=new Intent(getApplicationContext(),MainActivity.class);
               startActivity(intent);
           }
       });

    }

}