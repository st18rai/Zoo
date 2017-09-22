package com.st18apps.zoo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    //Birds
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

      //  getDataFromDB();
        final String []Animals = {BUGS,REPTILE,MAMMAL,BIRDS};

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        mArrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, Animals
                                );
                        mListView.setAdapter(mArrayAdapter);
                        setImageToListItem();
                        break;
                    case 1:
                        mArrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.snakes));
                        mListView.setAdapter(mArrayAdapter);
                        setImageToListItem();
                        break;
                    case 2:
                        mArrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.mammalian));
                        mListView.setAdapter(mArrayAdapter);
                        setImageToListItem();
                        break;
                    case 3:
                        mArrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.birds));
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

    public void getDataFromDB() {

        SQLiteDatabase db = myDB.getReadableDatabase();

        String[] columns = {"ID", "TYPE"};

        Cursor cursor = db.query("animals", columns, null, null, null, null, null, null);

        BUGS = cursor.getString(0);
        REPTILE = cursor.getString(1);;
        MAMMAL = cursor.getString(2);;
        BIRDS = cursor.getString(3);;

    }
}
