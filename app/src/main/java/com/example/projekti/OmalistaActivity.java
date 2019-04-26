package com.example.projekti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.projekti.HakuActivity.EXTRA;

public class OmalistaActivity extends AppCompatActivity {

    private ArrayList<String> omalista = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omalista);

        Bundle b = getIntent().getExtras();
        int i = b.getInt(EXTRA,0);

        //((TextView) findViewById(R.id.textView8)).setText(RuokaAineLista.getInstance().getRuokaAineet(i));  //TOIMII TEXTViewillä!!!!!
        String muuttuja = RuokaAineLista.getInstance().getRuokaAineet(i);
        ListView omaListaListView = findViewById(R.id.omaListaListView);


        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                omalista);
        omaListaListView.setAdapter(adapter);
        adapter.add(muuttuja);


    }

    /*public void takaisin(View v){
        Intent takaisinButton = new Intent(this, MainActivity.class);
        startActivity(takaisinButton);
    }*/
}
