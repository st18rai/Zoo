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
    private static final int DATABASE_VERSION = 1;

    public MyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Create tables
        String SQL_CREATE_ANIMALS_TABLE = "CREATE TABLE " + "animals" + " (" +
                "ID" + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "TYPE" + " TEXT NOT NULL UNIQUE " + " );";

        String SQL_CREATE_BUGS_TABLE = "CREATE TABLE " + "bug" + " (" +
                "ID" + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "NAME" + " TEXT NOT NULL UNIQUE " + " );";

        String SQL_CREATE_REPTILE_TABLE = "CREATE TABLE " + "reptile" + " (" +
                "ID" + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "NAME" + " TEXT NOT NULL UNIQUE " + " );";

        String SQL_CREATE_BIRD_TABLE = "CREATE TABLE " + "birds" + " (" +
                "ID" + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "NAME" + " TEXT NOT NULL UNIQUE " + " );";

        String SQL_CREATE_MAMMAL_TABLE = "CREATE TABLE " + "mammal" + " (" +
                "ID" + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "NAME" + " TEXT NOT NULL UNIQUE " + " );";

        sqLiteDatabase.execSQL(SQL_CREATE_ANIMALS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_BUGS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_REPTILE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_BIRD_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_MAMMAL_TABLE);

        String SQL_INSERT_INTO_ANIMALS = "INSERT INTO " + "animals" +
                "('ID',`TYPE`)" + "VALUES" + "(1,'Bugs'),(2,'Reptile'),(3,'Mammal'),(4,'Birds');";

        // Insert into tables
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_ANIMALS);

        String SQL_INSERT_INTO_BUG = "INSERT INTO " + "bug" +
                " (`ID`,`NAME`) " + " VALUES " + "(1,'Coloradskii'), (2, 'Yellowsub');";

        String SQL_INSERT_INTO_REPTILE = "INSERT INTO " + "reptile" +
                " (`ID`,`NAME`) " + " VALUES " + "(1,'Kobra'), (2, 'Gadyuka');";

        String SQL_INSERT_INTO_MAMMAL = "INSERT INTO " + "mammal" +
                " (`ID`,`NAME`) " + " VALUES " + "(1,'Horse'), (2, 'Cat');";

        String SQL_INSERT_INTO_BIRDS = "INSERT INTO " + "birds" +
                " (`ID`,`NAME`) " + " VALUES " + "(1,'Coloradskii'), (2, 'Yellowsub');";

        sqLiteDatabase.execSQL(SQL_INSERT_INTO_BUG);
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_REPTILE);
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_MAMMAL);
        sqLiteDatabase.execSQL(SQL_INSERT_INTO_BIRDS);

        Log.d("Mylog", "Create db and tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
