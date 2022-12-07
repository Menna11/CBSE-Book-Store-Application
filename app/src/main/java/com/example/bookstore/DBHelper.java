package com.example.bookstore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper
{
    private static String databaseName = "libraryDatabase";
    SQLiteDatabase libraryDatabase ;
     public DBHelper (Context context)
     {
         super(context,databaseName,null,1);
     }

     @Override
    public void onCreate(SQLiteDatabase db)
     {
         db.execSQL("create table User(" +
                 "userid integer primary key " +
                 ", name text" +
                 ",email text " +
                 ", password text " +
                 ", phone text " +
                 ", address text " +
                 ", authority binary" +
                 ");" );


                 db.execSQL("create table Books(" +
                         "bookid integer primary key" +
                         ",name text " +
                         ",publisher text " +
                         ",category text " +
                         ",author text " +
                         ",quantity integer " +
                         ",price integer" +
                         ",description text " +
                         ");" );


                 db.execSQL("create table Cart(" +
                         "orderid integer primary key " +
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





}
