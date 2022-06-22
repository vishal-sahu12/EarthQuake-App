package com.example.earthquakecopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;




public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG =MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquake locations.
        ArrayList<list> earthquakes = com.example.android.quakereport.query.extractEarthquakes();

//        earthquakes.add(new list("7.2","San Fransisco","Apr 30,2022"));
//        earthquakes.add(new list("5.2","Lahore","May 1,2022"));
//        earthquakes.add(new list("6.2","New South Land","May 2,2022"));
//        earthquakes.add(new list("4.2","kathNondu","May 3,2022"));
//        earthquakes.add(new list("2.1","Ladooree","May 4,2022"));
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list_item);

        // Create a new {@link ArrayAdapter} of earthquakes
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1, earthquakes);

        ListAdapter adapter = new ListAdapter (this,earthquakes);
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                list currentEarthquake = adapter.getItem(i);
                Uri earthquakeUri = Uri.parse(currentEarthquake.getmUrl());

                Intent websiteIntent = new Intent( Intent.ACTION_VIEW ,earthquakeUri);
                startActivity( websiteIntent);

            }
        });
    }
}