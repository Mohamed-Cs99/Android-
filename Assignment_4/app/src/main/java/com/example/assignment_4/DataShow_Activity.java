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
                int tempid= Integer.parseInt(empName.getText().toString());
                Cursor mycr = empDatabase.getEmployeeData(tempid);
//
               int deptnum =Integer.parseInt(mycr.getString(4));
//               Cursor dptCr =empDatabase.getDepartementName(deptnum);
//               String deptName =dptCr.getString(0);
//               Toast.makeText(getApplicationContext(),deptName,Toast.LENGTH_LONG).show();
                while (!mycr.isAfterLast())
                {
                    adapt.add("Name : "+mycr.getString(0));
                    adapt.add("Title : "+mycr.getString(1));
                    adapt.add("Phone : "+mycr.getString(2));
                    adapt.add("Email : "+mycr.getString(3));
                    adapt.add("Departement Id : "+mycr.getString(4));
                    mycr.moveToNext();
                }


            }
        });

    }
}