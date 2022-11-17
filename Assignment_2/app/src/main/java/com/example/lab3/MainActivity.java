package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myList = (ListView)findViewById(R.id.lst);
        final ArrayAdapter<String> arr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        myList.setAdapter(arr);

        Button mybtn = (Button)findViewById(R.id.btn);
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed = (EditText)findViewById(R.id.edtxt1);
                String myItem =ed.getText().toString();
                if(!(myItem.equals("")))
                {
                    arr.add(myItem);
                    ed.getText().clear();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Add item Please ",Toast.LENGTH_LONG).show();
                }

            }
        });

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),((TextView)view).getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
        myList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int item, long l) {

               String s =((TextView)view).getText().toString() ;
               arr.remove(s);
               arr.notifyDataSetChanged();
               Toast.makeText(getApplicationContext(),"Item Deleted",Toast.LENGTH_LONG).show();

            return true;
            }
        });
        Button gd =(Button)findViewById(R.id.gridbtn);
        gd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(it);

            }
        });


    }
}
