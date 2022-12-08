package com.example.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Admin extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        Button addbtn= findViewById(R.id.addbtn);
        Button editbtn= findViewById(R.id.editbtn);
        Button delbtn= findViewById(R.id.delbtn);
        Button showbtn = findViewById(R.id.showbtn);





        addbtn.setOnClickListener(v -> {
            Intent i=new Intent(Admin.this,adminadd.class);
            startActivity(i);




        });


        showbtn.setOnClickListener(view -> {
            Intent i = new Intent(Admin.this,adminshow.class);
            startActivity(i);

        });

    }




}
