package com.example.bookstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper
{
    private static final String databaseName = "libraryDatabase";
    SQLiteDatabase libraryDatabase ;
     public DBHelper (Context context)
     {
         super(context,databaseName,null,1);
     }

     @Override
    public void onCreate(SQLiteDatabase db)
     {
         db.execSQL("create table User(" +
                 "userid integer primary key autoincrement " +
                 ", name text" +
                 ",email text " +
                 ", password text " +
                 ", phone text " +
                 ", address text " +
                 ", authority binary" +
                 ");" );


                 db.execSQL("create table Books(" +
                         "bookid integer primary key autoincrement" +
                         ",name text " +
                         ",publisher text " +
                         ",category text " +
                         ",author text " +
                         ",quantity integer " +
                         ",price integer" +
                         ",description text " +
                         ");" );


                 db.execSQL("create table Cart(" +
                         "orderid integer primary key autoincrement " +
                         ",totalprice integer " +
                         ",bookids integer" +
                         ",userids integer " +
                         ",foreign key (bookids) references Books (bookid)" +
                         ",foreign key (userids) references User (userid)" +
                         ");");

     }

     @Override
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion)
     {
         db.execSQL("drop table if exists User");
         db.execSQL("drop table if exists Books");
         db.execSQL("drop table if exists Cart");
         onCreate(db);

     }

public void createNewBook(int bookid, String name, String publisher, String category, String author, int quantity, int price, String description)
{
    ContentValues row = new ContentValues();
    row.put("bookid",bookid);
    row.put("name",name);
    row.put("publisher",publisher);
    row.put("category",category);
    row.put("author",author);
    row.put("quantity",quantity);
    row.put("price",price);
    row.put("description",description);

    libraryDatabase=getWritableDatabase();
    libraryDatabase.insert("Books",null,row);
    libraryDatabase.close();
}

public Cursor fetchBooks()
    {
        libraryDatabase=getReadableDatabase();
        String[] rowDetails={"bookid","name","publisher","category","author","quantity","price","description"};
        Cursor cursor=libraryDatabase.query("Books",rowDetails,null,null,null,null,null);
        if (cursor!=null)
        {
            cursor.moveToFirst();
        }
        libraryDatabase.close();
        return cursor;
    }

    public Cursor getBook(String bookName)
    {
       libraryDatabase=getReadableDatabase();
       String [] arg={bookName};
       Cursor cursor=libraryDatabase.rawQuery("select * from Books where name like ?",arg);

       if(cursor.getCount()!=0)
       {
        cursor.moveToFirst();
        libraryDatabase.close();
        return cursor;
       }

       libraryDatabase.close();
       return null;
    }

    public Cursor getAuthor(String authorName)
    {
        libraryDatabase=getReadableDatabase();
        String [] arg={authorName};
        Cursor cursor=libraryDatabase.rawQuery("select * from Books where author like ?",arg);

        if(cursor.getCount()!=0)
        {
            cursor.moveToFirst();
            libraryDatabase.close();
            return cursor;
        }

        libraryDatabase.close();
        return null;
    }
}
