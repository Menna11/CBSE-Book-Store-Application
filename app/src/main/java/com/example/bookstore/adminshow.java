package com.example.bookstore;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class adminshow extends AppCompatActivity
{
    ListView booksList ;
    ArrayAdapter<String> booksAdapter;
    DBHelper Books;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminshow);
        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        booksList=(ListView) findViewById(R.id.listvieww);
        booksAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        booksList.setAdapter(booksAdapter);

        Books= new DBHelper(getApplicationContext());
        Cursor cursor = Books.fetchBooks();
        while (!cursor.isAfterLast())
        {
            booksAdapter.add(cursor.getString(0));
            booksAdapter.add(cursor.getString(1));
            booksAdapter.add(cursor.getString(2));
            booksAdapter.add(cursor.getString(3));
            booksAdapter.add(cursor.getString(4));
            booksAdapter.add(cursor.getString(5));
            booksAdapter.add(cursor.getString(6));
            booksAdapter.add(cursor.getString(7));

            cursor.moveToNext();
        }




    }






}
