package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ShowBooks extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_books);

        final DBHelper libraryDBHelper=new DBHelper(this);
        String RetrievedName=(String) getIntent().getStringExtra("name");
        Cursor cursor=libraryDBHelper.getBook(RetrievedName);

        TextView name=findViewById(R.id.BookName);
        TextView author=findViewById(R.id.Author);
        TextView publisher=findViewById(R.id.Publisher);
        TextView category=findViewById(R.id.Category);
        TextView quantity=findViewById(R.id.Quantity);
        TextView price=findViewById(R.id.Price);
        TextView description=findViewById(R.id.Description);




        name.setText(RetrievedName);
        author.setText(cursor.getString(4));
        publisher.setText(cursor.getString(2));
        category.setText(cursor.getString(3));
        quantity.setText(cursor.getString(5));
        price.setText(cursor.getString(6)+" LE");
        description.setText(cursor.getString(7));
    }
}