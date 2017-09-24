package com.st18apps.zoo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    private Spinner mSpinner;
    private ListView mListView;
    private ImageView mImageView;
    private ArrayAdapter<String> mArrayAdapter;

    private MyDB myDB;

    //Animals type
    private String BUGS;
    private String REPTILE;
    private String MAMMAL;
    private String BIRDS;

    //Bugs item
    private String Coloradskii;
    private String Yellowsub;

    //Reptiles item
    private String Kobra;
    private String Gadyuka;

    //Mammals item
    private String Horse;
    private String Cat;

    //Birds item
    private String Hawk;
    private String Sinica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = (Spinner) findViewById(R.id.spinner);
        mListView = (ListView) findViewById(R.id.list);
        mImageView = (ImageView) findViewById(R.id.imageView);

        myDB = new MyDB(this);

        getDataFromAnimalsTable();
        getDataFromExampleTable();

        final String[] animals = {BUGS, REPTILE, MAMMAL, BIRDS};
        final String[] bugs = {Coloradskii, Yellowsub};
        final String[] reptiles = {Kobra, Gadyuka};
        final String[] mammal = {Horse, Cat};
        final String[] birds = {Hawk, Sinica};


        mArrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, animals);
        mSpinner.setAdapter(mArrayAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        mArrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,
                                bugs);
                        mListView.setAdapter(mArrayAdapter);
                        setImageToListItem();
                        break;
                    case 1:
                        mArrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,
                                reptiles);
                        mListView.setAdapter(mArrayAdapter);
                        setImageToListItem();
                        break;
                    case 2:
                        mArrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,
                                mammal);
                        mListView.setAdapter(mArrayAdapter);
                        setImageToListItem();
                        break;
                    case 3:
                        mArrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,
                                birds);
                        mListView.setAdapter(mArrayAdapter);
                        setImageToListItem();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });


    }

    public void setImageToListItem() {
        switch (mSpinner.getSelectedItemPosition()) {

            case 0:
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch (i) {
                            case 0:
                                mImageView.setImageResource(R.drawable.koloradskiy_zhuk);
                                break;
                            case 1:
                                mImageView.setImageResource(R.drawable.yellowsub);
                                break;
                        }
                    }
                });
                break;

            case 1:
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch (i) {
                            case 0:
                                mImageView.setImageResource(R.drawable.kobra);
                                break;
                            case 1:
                                mImageView.setImageResource(R.drawable.gadyuka);
                                break;
                        }
                    }
                });
                break;

            case 2:
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch (i) {
                            case 0:
                                mImageView.setImageResource(R.drawable.horse);
                                break;
                            case 1:
                                mImageView.setImageResource(R.drawable.cat);
                                break;
                        }
                    }
                });
                break;

            case 3:
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch (i) {
                            case 0:
                                mImageView.setImageResource(R.drawable.hawk);
                                break;
                            case 1:
                                mImageView.setImageResource(R.drawable.sinica);
                                break;
                        }
                    }
                });
                break;


        }

    }

    public void getDataFromAnimalsTable() {

        SQLiteDatabase db = myDB.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT TYPE FROM animals;", new String[]{});
        //   String[] columns = {"TYPE"};

        //  Cursor cursor = db.query("animals", columns, null, null, null, null, null, null);

        cursor.moveToFirst();
        BUGS = cursor.getString(0);
        cursor.moveToNext();
        REPTILE = cursor.getString(0);
        cursor.moveToNext();
        MAMMAL = cursor.getString(0);
        cursor.moveToNext();
        BIRDS = cursor.getString(0);


        Log.d("My", "Bugs = " + BUGS);
    }

    public void getDataFromExampleTable() {

        SQLiteDatabase db = myDB.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT  EXAMPLE FROM example  WHERE id_type=1;", new String[]{});
        cursor.moveToFirst();
        Coloradskii = cursor.getString(0);
        cursor.moveToNext();
        Yellowsub = cursor.getString(0);

        cursor = db.rawQuery("SELECT  EXAMPLE FROM example  WHERE id_type=2;", new String[]{});
        cursor.moveToFirst();
        Kobra = cursor.getString(0);
        cursor.moveToNext();
        Gadyuka = cursor.getString(0);

        cursor = db.rawQuery("SELECT  EXAMPLE FROM example  WHERE id_type=3;", new String[]{});
        cursor.moveToFirst();
        Horse = cursor.getString(0);
        cursor.moveToNext();
        Cat = cursor.getString(0);

        cursor = db.rawQuery("SELECT  EXAMPLE FROM example  WHERE id_type=4;", new String[]{});
        cursor.moveToFirst();
        Hawk = cursor.getString(0);
        cursor.moveToNext();
        Sinica = cursor.getString(0);


    }
}
