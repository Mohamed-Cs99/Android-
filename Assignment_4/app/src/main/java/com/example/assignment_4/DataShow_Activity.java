package com.example.assignment_4;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class DataShow_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);
        ListView myList =(ListView)findViewById(R.id.Lv) ;
        ArrayAdapter<String>adapt =new ArrayAdapter<String>(getApplicationContext() , android.R.layout.simple_list_item_1);
        myList.setAdapter(adapt);
        Emp_DB empDatabase =new Emp_DB(getApplicationContext()) ;
        EditText empName=(EditText)findViewById(R.id.edtxt);

        FloatingActionButton empBtn =(FloatingActionButton)findViewById(R.id.searchBtn);
        empBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapt.clear();
                String temp= empName.getText().toString() ;
                Cursor mycr = empDatabase.getEmployees(temp);
               // adapt.add("heoll");
               // Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_LONG).show();
                while (!mycr.isAfterLast())
                {
                    adapt.add(mycr.getString(0));

                    mycr.moveToNext();
                }
            }
        });
       // Cursor mycr = empDatabase.getEmployees(temp);
      /*   while (!mycr.isAfterLast())
        {
         adapt.add(mycr.getString(0));
         mycr.moveToNext() ;
        }*/
    }
}