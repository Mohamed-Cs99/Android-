package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String[]myarr = getResources().getStringArray(R.array.grid);

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myarr);

        GridView mygrid =(GridView)findViewById(R.id.gv);
        mygrid.setAdapter(adapter);


        mygrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView tv =(TextView)view ;

                String val =tv.getText().toString();

                if(Character.isLowerCase(val.charAt(0)))
                {
                    tv.setText(val.toUpperCase());
                }
                else
                {
                    tv.setText(val.toLowerCase());
                }

            }
        });

    }
}