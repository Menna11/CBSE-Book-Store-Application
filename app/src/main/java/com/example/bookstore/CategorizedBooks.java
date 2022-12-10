package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CategorizedBooks extends AppCompatActivity {

    ListView listView;
    Integer[] Rimageid={R.drawable.rb1,R.drawable.rb2};
    Integer[] Simageid={R.drawable.scfi1,R.drawable.scfi2};
    Integer[] Himageid={R.drawable.h1,R.drawable.h2};
    Integer[] Timageid={R.drawable.t1,R.drawable.t2};

    String[] matchedbooks={};
    String[]matchedauthors={};


    public void FillList(String[]books,String[]authors,Integer[]images)
    {
        BookAdapter adapter=new BookAdapter(CategorizedBooks.this,books,authors,images);
        listView=findViewById(R.id.book_list_view);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorized_books);
          final DBHelper dbHelper=new DBHelper(this);
          int num=getIntent().getExtras().getInt("Category");
        if(num==0)
        {
                    matchedbooks=dbHelper.getBooksname("Romance");
                    matchedauthors=dbHelper.getBooksauthors("Romance");
                    FillList(matchedbooks,matchedauthors,Rimageid);
        }
        if(num==1)
        {
            matchedbooks=dbHelper.getBooksname("SC-FI");
            matchedauthors=dbHelper.getBooksauthors("SC-FI");
            FillList(matchedbooks,matchedauthors,Simageid);
        }
        else if(num==2)
        {
            matchedbooks=dbHelper.getBooksname("Horror");
            matchedauthors=dbHelper.getBooksauthors("Horror");
            FillList(matchedbooks,matchedauthors,Himageid);
        }
        else if(num==3)

        {
            matchedbooks=dbHelper.getBooksname("Thriller");
            matchedauthors=dbHelper.getBooksauthors("Thriller");
            FillList(matchedbooks,matchedauthors,Timageid);
        }






    }
}