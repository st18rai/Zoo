package com.st18apps.zoo;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = (Spinner) findViewById(R.id.spinner);
        mListView = (ListView) findViewById(R.id.list);
        mImageView = (ImageView) findViewById(R.id.imageView);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        mArrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.bugs));
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

    public void setImageToListItem(){
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
}
