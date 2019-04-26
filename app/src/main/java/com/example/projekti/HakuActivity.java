package com.example.projekti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class HakuActivity extends AppCompatActivity {

    public static final String EXTRA = "huu";


    SearchView ruokaSearchView;
    ListView ruokaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haku);

        ruokaListView = (ListView) findViewById(R.id.ruokaListaHakuActivity);

        ArrayAdapter<String> arrayAdapterOma = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                RuokaAineLista.getInstance().getRuokaAineet()
        );


        ruokaListView.setAdapter(arrayAdapterOma);

        ruokaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent hakuTulosActivity = new Intent(HakuActivity.this, hakuTulosActivity.class);

                hakuTulosActivity.putExtra(EXTRA, i);
                startActivity(hakuTulosActivity);
            }
        });


    }
    /*public void hakuMessage(View view){
        Intent haku = new Intent(this, hakuTulosActivity.class);
        EditText haku1 = (EditText) findViewById(R.id.searchViewRuokaHaku);
        String sana = haku1.getText().toString();
        haku.putExtra(EXTRA_MESSAGE, sana);
        startActivity(haku);
    }
    public void takaisin(View v){
        Intent takaisinButton = new Intent(this, MainActivity.class);
        startActivity(takaisinButton);
    }*/
}
