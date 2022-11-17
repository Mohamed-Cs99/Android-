package com.example.assignment3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.calculator, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        clculator obj = new clculator();

        EditText Edtxt1 = (EditText) findViewById(R.id.ed1);
        EditText Edtxt2 = (EditText) findViewById(R.id.ed2);
        EditText Edtxt3 = (EditText) findViewById(R.id.res);


        float fn = Float.parseFloat(Edtxt1.getText().toString());
        float sn = Float.parseFloat(Edtxt2.getText().toString());
        obj.setFn(fn);
        obj.setSn(sn);
        if (item.getItemId() == R.id.item1) {
            float result = obj.div();
            Edtxt3.setText(String.valueOf(result));
            return true;
        }
        if (item.getItemId() == R.id.item2) {
            float result = obj.mult();
            Edtxt3.setText(String.valueOf(result));
            return true;
        }
        if (item.getItemId() == R.id.item3) {
            float result = obj.sub();
            Edtxt3.setText(String.valueOf(result));
            return true;
        }
        if (item.getItemId() == R.id.item4) {
            float result = obj.Add();
            Edtxt3.setText(String.valueOf(result));
            return true;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.calculator, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        clculator obj = new clculator();

        EditText Edtxt1 = (EditText) findViewById(R.id.ed1);
        EditText Edtxt2 = (EditText) findViewById(R.id.ed2);
        EditText Edtxt3 = (EditText) findViewById(R.id.res);


        float fn = Float.parseFloat(Edtxt1.getText().toString());
        float sn = Float.parseFloat(Edtxt2.getText().toString());
        obj.setFn(fn);
        obj.setSn(sn);
        if (item.getItemId() == R.id.item1) {
            float result = obj.div();
            Edtxt3.setText(String.valueOf(result));
            return true;
        }
        if (item.getItemId() == R.id.item2) {
            float result = obj.mult();
            Edtxt3.setText(String.valueOf(result));
            return true;
        }
        if (item.getItemId() == R.id.item3) {
            float result = obj.sub();
            Edtxt3.setText(String.valueOf(result));
            return true;
        }
        if (item.getItemId() == R.id.item4) {
            float result = obj.Add();
            Edtxt3.setText(String.valueOf(result));
            return true;
        }

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ed3 = (EditText) findViewById(R.id.res);
        registerForContextMenu(ed3);
    }
}