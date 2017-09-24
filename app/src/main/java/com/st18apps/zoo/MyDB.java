package com.st18apps.zoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by dev on 22.09.2017.
 */

public class MyDB extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "zoo.db";
    private static final int DATABASE_VERSION = 4;

    public MyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Create tables
        String SQL_CREATE_ANIMALS_TABLE =
                "CREATE TABLE animals (_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, TYPE TEXT NOT NULL UNIQUE);";

        String SQL_CREATE_EXAMPLE_TABLE =
                "CREATE TABLE example (_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, EXAMPLE TEXT NOT NULL UNIQUE, ID_TYPE INTEGER NOT NULL);";

        sqLiteDatabase.execSQL(SQL_CREATE_ANIMALS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_EXAMPLE_TABLE);

        String SQL_INSERT_INTO_ANIMALS =
                "INSERT INTO animals('_ID',`TYPE`) VALUES(1,'Bugs'),(2,'Reptile'),(3,'Mammal'),(4,'Birds');";

        String SQL_INSERT_INTO_EXAMPLE =
                "INSERT INTO example('_ID','EXAMPLE',`ID_TYPE`) VALUES(1,'Coloradskii',1),(2,'Yellowsub',1),(3,'Kobra',2),(4,'Gadyuka',2),(5,'Horse',3),(6,'Cat',3),(7,'Hawk',4),(8,'Sinica',4);";

        // Insert into tables
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_ANIMALS);
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_EXAMPLE);

        Log.d("Mylog", "Create db and tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "animals");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "example");
        onCreate(sqLiteDatabase);
    }
}
