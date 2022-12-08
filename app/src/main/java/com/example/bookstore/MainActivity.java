package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Cursor cursor;
    ArrayAdapter<String> booksNamesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button homeBtn= findViewById(R.id.homeBtn);
        Button categoryBtn= findViewById(R.id.categoryBtn);
        Button cartBtn= findViewById(R.id.cartBtn);
        Button adminBtn= findViewById(R.id.adminBtn);

        homeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        categoryBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Category.class);
                startActivity(i);
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Cart.class);
                startActivity(i);
            }
        });

        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Admin.class);
                startActivity(i);
            }
        });

        final DBHelper libraryDBHelper=new DBHelper(this);
        final EditText libraryNameText=(EditText) findViewById(R.id.SearchText);
        Button searchBtn=(Button) findViewById(R.id.SearchBtn);
        final ListView booksNamesList=(ListView) findViewById(R.id.list);

        booksNamesAdapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);
        booksNamesList.setAdapter(booksNamesAdapter);

        searchBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String libraryName=libraryNameText.getText().toString();
                cursor=libraryDBHelper.getBook(libraryName);

                booksNamesAdapter.clear();

                if(cursor!=null)
                {
                    while(!cursor.isAfterLast())
                    {
                        booksNamesAdapter.add(cursor.getString(1));
                        cursor.moveToNext();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No matched Books",Toast.LENGTH_LONG).show();
                }
            }
        });

        booksNamesList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position,long id)
            {
                String name=(((TextView)view).getText().toString());
                Intent i=new Intent(MainActivity.this,ShowBooks.class);
                i.putExtra("name",name);
                startActivity(i);
            }
        });






    }
}