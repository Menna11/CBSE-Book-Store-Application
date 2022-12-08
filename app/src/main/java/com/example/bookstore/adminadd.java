package com.example.bookstore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class adminadd extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminadd);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        final EditText bookid = findViewById(R.id.bookidtxt);
        final EditText name = findViewById(R.id.nametxt);
        final EditText publisher = findViewById(R.id.publishertxt);
        final EditText category = findViewById(R.id.categorytxt);
        final EditText author = findViewById(R.id.authortxt);
        final EditText quantity = findViewById(R.id.quantitytxt);
        final EditText price = findViewById(R.id.pricetxt);
        final EditText description = findViewById(R.id.descriptiontxt);
        Button addd = findViewById(R.id.addbtnn);
        final DBHelper newThing = new DBHelper(this);



        addd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bookidint = Integer.parseInt(bookid.getText().toString());
                int quantityint = Integer.parseInt(quantity.getText().toString());
                int priceint = Integer.parseInt(price.getText().toString());
                String namestr = name.getText().toString();
                String publisherstr = publisher.getText().toString();
                String categorystr = category.getText().toString();
                String authorstr = author.getText().toString();
                String descriptionstr = description.getText().toString();

                newThing.createNewBook(bookidint,namestr,publisherstr,categorystr,authorstr,quantityint,priceint,descriptionstr);
                Toast.makeText(getApplicationContext(),"Book Added",Toast.LENGTH_LONG).show();







            }
        });








    }





}
